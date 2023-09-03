package pe.edu.upc.demo.controllers;

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

import pe.edu.upc.demo.entities.Report;
import pe.edu.upc.demo.serviceinterface.IReportService;
import pe.edu.upc.demo.serviceinterface.IserviceService;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private IReportService repService;
	@Autowired
	private IserviceService serService;
	
	@GetMapping("/new")
	public String newReport(Model model) {
		model.addAttribute("rep", new Report());
		model.addAttribute("listService",serService.list());
		return "report/frmRegister";
	}

	@PostMapping("/save")
	public String saveReport(@Valid Report rep, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "report/frmRegister";
		} else {
			repService.Insert(rep);
			model.addAttribute("mensaje", "Se registro correctamente!!");
			return "redirect:/report/new";
		}
	}

	@GetMapping("/list")
	public String listReport(Model model) {
		try {
			model.addAttribute("listReport", repService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/report/frmList";
	}

	@RequestMapping("/delete")
	public String deleteReport(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				repService.Delete(id);
				model.put("listReport", repService.list());
				return "report/frmList";
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "report/frmList";
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {

		Optional<Report> objPer = repService.listarId(id);
		model.addAttribute("repo", objPer.get());
		model.addAttribute("listService",serService.list());
		return "report/frmUpdate";
	}

	@PostMapping("/actualizar")
	public String actualizar(Report rep, Model model) {
		repService.modificar(rep);
		return "redirect:/report/list";
	}

}
