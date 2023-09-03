package pe.edu.upc.demo.controllers;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.serviceinterface.IRoleService;
import pe.edu.upc.demo.serviceinterface.IUserService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService rService;
	@Autowired
	private IUserService uService;

	@GetMapping("/nuevo")
	public String newRole(Model model) {
		model.addAttribute("r", new Role());
		model.addAttribute("listaUsuarios", uService.listar());
		return "role/role";		
	}

	@PostMapping("/guardar")
	public String registrarRole(@Valid Role objTel, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "role/role";
		} else {
			rService.insertar(objTel);
			model.addAttribute("mensaje", "Se guardó correctamente");
			// status.setComplete();
			return "redirect:/roles/listar";
		}
	}

	@GetMapping("/listar")
	public String listarRoles(Model model) {
		try {
			model.addAttribute("listaRoles", rService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/role/listaRole";
	}
	
	@RequestMapping("/delete")
	public String deleteService(Map<String, Object> model, @RequestParam(value = "id") Long id) {
		try {
			if (id != null && id > 0) {
				rService.Delete(id);
				model.put("listaRoles", rService.listar());
				return "role/listaRole";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "role/listaRole";
	}

	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable long id, Model model) {

		Optional<Role> objPer = rService.listarId(id);
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("ro", objPer.get());
		return "role/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(Role rol, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listaUsuarios", uService.listar());
			return "role/frmUpdate";
		} else {
			rService.modificar(rol);
			model.addAttribute("mensaje", "Se Actualizo correctamente!!");
			return "redirect:/roles/listar";
		}

	}
}
