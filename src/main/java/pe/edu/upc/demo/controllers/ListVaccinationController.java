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

import pe.edu.upc.demo.entities.ListVaccination;
import pe.edu.upc.demo.serviceinterface.IDriverService;
import pe.edu.upc.demo.serviceinterface.IListVaccinationService;
import pe.edu.upc.demo.serviceinterface.IVaccineService;

@Controller
@RequestMapping("/listvaccination")
public class ListVaccinationController {
	@Autowired
	private IListVaccinationService listService;
	@Autowired
	private IVaccineService vaService;
	@Autowired
	private IDriverService driService;

	@GetMapping("/new")
	public String newListVaccination(Model model) {
		model.addAttribute("l", new ListVaccination());
		model.addAttribute("listVaccine", vaService.list());
		model.addAttribute("listDriver", driService.list());
		return "listvaccination/frmRegister";
	}

	@PostMapping("/save")
	public String saveListVaccination(@Valid @ModelAttribute("l") ListVaccination list, BindingResult binRes,
			Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listVaccine", vaService.list());
			model.addAttribute("listDriver", driService.list());
			return "listvaccination/frmRegister";
		} else {
			listService.Insert(list);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/listvaccination/new";
		}
	}

	@GetMapping("/list")
	public String listListVaccination(Model model) {
		try {
			model.addAttribute("listVaccination", listService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/listvaccination/frmList";
	}

	@RequestMapping("/delete")
	public String deleteListVaccination(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				listService.Delete(id);
				model.put("listVaccination", listService.list());
				return "listvaccination/frmList";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "listvaccination/frmList";
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {

		Optional<ListVaccination> objPer = listService.listarId(id);
		model.addAttribute("lis", objPer.get());
		model.addAttribute("listVaccine", vaService.list());
		model.addAttribute("listDriver", driService.list());
		return "listvaccination/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(@Valid @ModelAttribute("lis") ListVaccination list, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listVaccine", vaService.list());
			model.addAttribute("listDriver", driService.list());
			return "listvaccination/frmUpdate";
		} else {
			listService.modificar(list);
			model.addAttribute("mensaje", "Se Actualizo correctamente!!");
			return "redirect:/listvaccination/list";
		}

	}

}
