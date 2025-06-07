package CodewithHarry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CodewithHarry.entites.Specialization;
import CodewithHarry.service.SpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private SpecializationService service;
	
	// display all Specialization data
      
	@GetMapping("/all")
	 public String viewAll(Model model)
	 {
		List<Specialization> list = service.getAllSpecialization();
		model.addAttribute("list",list);
		return "SpecializationData";
		 
	 }

}
