package pe.edu.upc.demo.controllers;

/*import java.io.IOException;*/
import java.util.Map;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.demo.entities.TypeSuscription;
import pe.edu.upc.demo.serviceinterface.ITypeSuscriptionService;
import pe.edu.upc.demo.serviceinterface.IUploadFileService;

@Controller
@RequestMapping("/typesuscription")
public class TypeSuscriptionController {
	@Autowired
	private ITypeSuscriptionService tyService;
	@Autowired
	private IUploadFileService upService;


	@GetMapping("/new")
	public String newTypeSuscription(Model model) {
		model.addAttribute("t", new TypeSuscription());
		model.addAttribute("listtypesuscription",tyService.list());
		return "typesuscription/frmRegister";
	}

	@PostMapping("/save")
	public String saveTypeSuscription(@Valid @ModelAttribute("t") TypeSuscription type, BindingResult binRes,
			Model model){
		if (binRes.hasErrors()) {
			System.out.println(binRes.getFieldError());
			return "typesuscription/frmRegister";
		}else { 
			tyService.Insert(type);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/typesuscription/new";
		}
	}

	@GetMapping("/list")
	public String listTypeSuscription(Model model) {
		try {
			model.addAttribute("listtypesuscription", tyService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/typesuscription/frmList";
	}

	@RequestMapping("/delete")
	public String deleteTypeSuscription(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tyService.Delete(id);
				model.put("listtypesuscription", tyService.list());
				return "typesuscription/frmList";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "typesuscription/frmList";
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {

		Optional<TypeSuscription> objPer = tyService.listarId(id);
		model.addAttribute("ty", objPer.get());
		return "typesuscription/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(@Valid @ModelAttribute("ty") TypeSuscription typ, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "typesuscription/frmUpdate";
		} else {
			tyService.modificar(typ);
			model.addAttribute("mensaje", "Se Actualizo correctamente!!");
			return "redirect:/typesuscription/list";
		}

	}

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Map<String, Object> model, RedirectAttributes flash) {

		Optional<TypeSuscription> typeSuscription = tyService.listarId(id);
		if (typeSuscription == null) {
			flash.addFlashAttribute("error", "La suscripción no existe en la base de datos");
			return "redirect:/typesuscription/list";
		}

		model.put("t", typeSuscription.get());

		return "typesuscription/ver";
	}

	@RequestMapping("/reporte1")
	public String CantidadSuscripcionesXEmpresas(Map<String, Object> model) {
		model.put("cantidadSusXempresas", tyService.CantidadSuscripcionesXEmpresa());
		return "typesuscription/vista";
	}

}
