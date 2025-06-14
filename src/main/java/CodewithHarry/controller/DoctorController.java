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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import CodewithHarry.entites.Doctor;

import CodewithHarry.exception.DoctorNotFoundException;
import CodewithHarry.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	@GetMapping("/register")
	public String displayRegister(
			@RequestParam(value = "message",
			required = false) String message,
			Model model
			) {
		   model.addAttribute("message",message);
		return "DoctorRegister";
	}
	
	
	@PostMapping("/save")
	public String saveForm(
			@ModelAttribute Doctor doc,
			Model model
			)
	{
		Integer id = service.saveDoctor(doc);
		String message ="Record ("+id+") is created";
		model.addAttribute("message", message);
		return "redirect:register";
	}
	@GetMapping("/all")
	public String viewAll(
			Model model,
			@RequestParam(value = "message",required = false) String message
			)
	{
		List<Doctor> list = service.getAllDoctor();
		model.addAttribute("list",list);
		model.addAttribute("message", message);
		return "DoctorData";
	}
	/**
	 * 4. Delete by id
	 */
	@GetMapping("/delete")
	public String deleteData(
			@RequestParam Integer id,
			RedirectAttributes attributes
			) 
	{
		try {
			service.removeDoctor(id);
			attributes.addAttribute("message", "Record ("+id+") is removed");
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String showEditPage(
			@RequestParam Integer id,
			Model model,
			RedirectAttributes attributes
			) 
	{
		String page = null;
		try {
			Doctor doc = service.getOneDoctor(id);
			model.addAttribute("doctor", doc);
			page = "DoctorEdit";
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}
	
	
	 // 6. Update Form data and redirect to all

	@PostMapping("/update")
	public String updateData(
			@ModelAttribute Doctor doc,
			RedirectAttributes attributes
			)
	{
		service.updateDoctor(doc);
		attributes.addAttribute("message", "Record ("+doc.getId()+") is updated");
		return "redirect:all";
	}
	
	}

