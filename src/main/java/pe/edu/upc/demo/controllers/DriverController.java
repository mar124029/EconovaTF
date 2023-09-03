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

import pe.edu.upc.demo.entities.Driver;
import pe.edu.upc.demo.serviceinterface.IDriverService;

@Controller
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	private IDriverService driService;

	@GetMapping("/new")
	public String newDriver(Model model) {
		model.addAttribute("d", new Driver());
		return "driver/frmRegister";
	}

	@PostMapping("/save")
	public String saveDriver(@Valid @ModelAttribute("d") Driver dri, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "driver/frmRegister";
		} else {
			driService.Insert(dri);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/driver/new";
		}
	}

	@GetMapping("/list")
	public String listDriver(Model model) {
		try {
			model.addAttribute("listDriver", driService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/driver/frmList";
	}

	@RequestMapping("/delete")
	public String deleteDriver(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				driService.Delete(id);
				model.put("listDriver", driService.list());
				return "driver/frmList";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "driver/frmList";
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {

		Optional<Driver> objPer = driService.listarId(id);
		model.addAttribute("dr", objPer.get());
		return "driver/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(@Valid @ModelAttribute("dr") Driver dri, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			model.addAttribute("listDriver", driService.list());
			return "driver/frmUpdate";
		} else {
			driService.modificar(dri);
			model.addAttribute("mensaje", "Se Actualizo correctamente!!");
			return "redirect:/driver/list";
		}

	}

}
