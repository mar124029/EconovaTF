package pe.edu.upc.demo.controllers;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.demo.entities.TypeSuscription;
import pe.edu.upc.demo.entities.Users;
import pe.edu.upc.demo.serviceinterface.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService uService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/nuevo")
	public String newUser(Model model) {
		model.addAttribute("u", new Users());
		return "user/usuario";
	}

	@PostMapping("/guardar")
	public String registrarUser(@Valid @ModelAttribute("u") Users objTel, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "user/usuario";
		} else {
			String p = objTel.getPassword();
			String pE = passwordEncoder.encode(p);
			Users us = new Users();
			us.setUsername(objTel.getUsername());
			us.setEnabled(objTel.getEnabled());
			us.setEmail(objTel.getEmail());
			us.setName(objTel.getName());
			us.setPassword(pE);

			uService.insertar(us);
			model.addAttribute("mensaje", "Se guardó correctamente");
			// status.setComplete();
			return "redirect:/user/nuevo";
		}
	}

	@GetMapping("/listar")
	public String listarUsuarios(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/user/listaUsuario";
	}

	@RequestMapping("/delete")
	public String deleteUsuario(Map<String, Object> model, @RequestParam(value = "id") Long id) {
		try {
			if (id != null && id > 0) {
				uService.Delete(id);
				model.put("listaUsuarios", uService.listar());
				return "user/listaUsuario";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "user/listaUsuario";
	}

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Optional<Users> user = uService.listarId(id);
		if (user == null) {
			flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
			return "redirect:/user/listar";
		}

		model.put("u", user.get());

		return "user/ver";
	}

}
