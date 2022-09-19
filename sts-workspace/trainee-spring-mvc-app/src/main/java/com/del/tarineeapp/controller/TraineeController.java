package com.del.tarineeapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.del.tarineeapp.model.Trainee;
import com.del.tarineeapp.service.TraineeService;

@Controller
public class TraineeController {
	
	@Autowired
	private TraineeService service;

	
//	@RequestMapping(path = "/register", method = RequestMethod.POST)
	
//	@PostMapping("/register")
//	public String addTrainee(@RequestParam("traineeId") int traineeId,
//								@RequestParam("traineeName") String traineeName,
//								@RequestParam("joinDate") String date,
//								Model m) {
//		
//		LocalDate joinDate = LocalDate.parse(date);
//		
//		Trainee trainee = new Trainee(traineeId, traineeName, joinDate);
//		
//		System.out.println(trainee);
//		m.addAttribute("trainee", trainee);
//		
//		return "show-trainee.jsp";
//	}
	
	@PostMapping("/register")
	public String addTrainee(@ModelAttribute("trainee") Trainee trainee) {
		
		// Write code to call the the service method
		
		service.addTrainee(trainee);
		
		return "show-trainee.jsp";
	}
	
	@GetMapping("/search")
	public String searchTrainee(@RequestParam("traineeId") int traineeId, Model m) {
		Trainee trainee = service.searchTrainee(traineeId);
		m.addAttribute("trainee", trainee);
		return "show-trainee.jsp";
		
	}
	
}
