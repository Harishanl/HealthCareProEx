package CodewithHarry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CodewithHarry.entites.Specialization;
import CodewithHarry.service.SpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private SpecializationService service;

	// Register Specialization
	@GetMapping("/register")
	public String specRegister(Model model) {
		model.addAttribute("specialization", new Specialization());
		return "SpecializationRegister";
	}

	@PostMapping("/save")
	public String saveSpec(@ModelAttribute Specialization spec, Model model) {
		System.out.println(model.getClass().getName());
		Long id = service.saveSpecialization(spec);
		String message = "Specialization '" + id + "' Created";
		model.addAttribute("message", message);

		return "SpecializationRegister";

	}

	// Delete Specialization

	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Long id, Model model) {
		service.removeSpecialization(id);
		String message = "Specialization '" + id + "' Deleted";
		model.addAttribute("message", message);
		// get latest data
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list", list);

		return "SpecializationData";

	}

	// edit SpecializationData
	@GetMapping("/edit")
	public String showSpecializationEdit(@RequestParam Long id, Model model) {
		// load object from DB

		Specialization spec = service.getOneSpecialization(id);
		// send object to UI

		model.addAttribute("spec", spec);
		// return to View page
		return "SpecializationEdit";

	}

	// update Specialization
	@PostMapping("/update")
	public String updateSpecialization(@ModelAttribute Specialization spec) {

		service.updateSpecialization(spec);

		return "redirect:all";

	}

	// display all Specialization data

	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list", list);
		return "SpecializationData";

	}

}
