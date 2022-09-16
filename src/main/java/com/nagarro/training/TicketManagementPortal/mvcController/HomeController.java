package com.nagarro.training.TicketManagementPortal.mvcController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.TicketManagementPortal.dto.UserDto;
import com.nagarro.training.TicketManagementPortal.service.EmployeeServiceImpl;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping("/")
	public String index() {
		logger.trace("Method accessed to open the Login Page.");
		return "index";
	}

	@GetMapping(value = "/register")
	public String registerForm() {
		logger.trace("Method accessed to go to the Registration Form.");
		return "register";
	}

	@PostMapping(value = "/registerForm")
	public String register(@RequestParam String username, String password) {
		logger.trace("Method accessed to consume the registration information.");
		System.out.println(username + " " + password + " " + "register");
		System.out.println("Entered Register");
		UserDto userDto = new UserDto();
		userDto.setUsername(username);
		userDto.setPassword(password);
		employeeService.addEmployee(userDto);
		return "redirect:user/welcome";
	}

}
