package pe.edu.upc.demo.controllers;

import java.util.Date;
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

import pe.edu.upc.demo.entities.Invoice;
import pe.edu.upc.demo.entities.Service;
import pe.edu.upc.demo.serviceinterface.ICamionService;
import pe.edu.upc.demo.serviceinterface.IserviceService;
import pe.edu.upc.demo.serviceinterface.ICompanyService;
import pe.edu.upc.demo.serviceinterface.IinvoiceService;

@Controller
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	private IserviceService seService;
	@Autowired
	private ICamionService camService;
	@Autowired
	private ICompanyService comService;
	@Autowired
	private IinvoiceService inService;

	@GetMapping("/new")
	public String newService(Model model) {
		model.addAttribute("s", new Service());
		model.addAttribute("listCamion", camService.list());
		model.addAttribute("listCompany", comService.list());

		return "service/frmRegister";
	}

	@PostMapping("/save")
	public String saveService(@Valid @ModelAttribute("s") Service se, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listCamion", camService.list());
			model.addAttribute("listCompany", comService.list());
			return "service/frmRegister";
		} else {
			seService.Insert(se);
			Invoice in = new Invoice();
			Date hoy = new Date();
			in.setMont(5 * se.getQuantityWaste());
			in.setDatepayment(hoy);
			in.setService(se);
			inService.Insert(in);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/service/new";
		}
	}

	@GetMapping("/list")
	public String listService(Model model) {
		try {
			model.addAttribute("listService", seService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/service/frmList";
	}

	@RequestMapping("/delete")
	public String deleteService(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				seService.Delete(id);
				model.put("listService", seService.list());
				return "service/frmList";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "service/frmList";
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {

		Optional<Service> objPer = seService.listarId(id);
		model.addAttribute("se", objPer.get());
		model.addAttribute("listCamion", camService.list());
		model.addAttribute("listCompany", comService.list());
		return "service/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(@Valid @ModelAttribute("se") Service ser, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("listCamion", camService.list());
			model.addAttribute("listCompany", comService.list());
			return "service/frmUpdate";
		} else {
			seService.modificar(ser);
			model.addAttribute("mensaje", "Se Actualizo correctamente!!");
			return "redirect:/service/list";
		}

	}

	@RequestMapping("/reporte1")
	public String tipoDesechocantidad(Map<String, Object> model) {
		model.put("tipodesechocantidad", seService.tipodesechocantidad());
		return "service/vista";
	}

}
