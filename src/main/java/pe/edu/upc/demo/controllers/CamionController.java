package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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

import pe.edu.upc.demo.entities.Camion;
import pe.edu.upc.demo.serviceinterface.ICamionService;
import pe.edu.upc.demo.serviceinterface.IDriverService;

@Controller
@RequestMapping("/camion")
public class CamionController {
	@Autowired
	private ICamionService camionService;
	@Autowired
	private IDriverService driService;

	@GetMapping("/new")
	public String newCamion(Model model) {
		model.addAttribute("c", new Camion());
		model.addAttribute("listDriver", driService.list());
		return "camion/frmRegister";
	}

	@PostMapping("/save")
	public String saveCamion(@Valid @ModelAttribute("c") Camion cam, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listDriver", driService.list());
			return "camion/frmRegister";
		} else {
			camionService.Insert(cam);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/camion/new";
		}
	}

	@GetMapping("/list")
	public String listCamion(Model model) {
		try {
			model.addAttribute("listCamion", camionService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/camion/frmList";
	}

	@RequestMapping("/delete")
	public String deleteCamion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				camionService.delete(id);
				model.put("listCamion", camionService.list());
				return "camion/frmList";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "camion/frmList";
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {

		Optional<Camion> objPer = camionService.listarId(id);
		model.addAttribute("ca", objPer.get());
		model.addAttribute("listDriver", driService.list());
		return "camion/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(@Valid @ModelAttribute("ca") Camion cami, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			model.addAttribute("listDriver", driService.list());
			return "camion/frmUpdate";
		} else {
			camionService.modificar(cami);
			model.addAttribute("mensaje", "Se Actualizo correctamente!!");
			return "redirect:/camion/list";
		}
	}

}
