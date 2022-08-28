package com.javameans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javameans.entity.Employee;
import com.javameans.entity.Feedback;
import com.javameans.repository.EmployeeRepository;
import com.javameans.repository.FeedbackRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository eRepo;

	@Autowired
	private FeedbackRepository fRepo;

	@GetMapping({ "/showEmployees", "/", "/list" })
	public ModelAndView showEmployees() {
		ModelAndView mav = new ModelAndView("list-employees");
		List<Employee> list = eRepo.findAll();
		mav.addObject("employees", list);
		return mav;
	}

	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		return mav;
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		eRepo.save(employee);
		return "redirect:/list";
	}

	@PostMapping("/saveFeedback")
	public String saveFeedback(@ModelAttribute Feedback feedback) {
		fRepo.save(feedback);
		return "redirect:/list";
	}

	@GetMapping("/addFeedback")
	public ModelAndView giveFeedback() {
		ModelAndView fav = new ModelAndView("contactus");
		Feedback newFeedback = new Feedback();
		fav.addObject("feedback", newFeedback);
		return fav;
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee employee = eRepo.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		eRepo.deleteById(employeeId);
		return "redirect:/list";
	}

	@GetMapping("/gotoMozilla")
	public ModelAndView gotoMozilla() {
		ModelAndView mav = new ModelAndView("mozilla-page");
		return mav;
	}

}
