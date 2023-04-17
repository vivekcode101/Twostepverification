package com.tsv.implementation.controller;

import com.tsv.implementation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tsv.implementation.dto.UserRegisteredDTO;
import com.tsv.implementation.service.DefaultUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	 private DefaultUserService userService;

	    public RegistrationController(DefaultUserService userService) {
	        super();
	        this.userService = userService;
	    }

	    @ModelAttribute("user")
	    public UserRegisteredDTO userRegistrationDto() {
	        return new UserRegisteredDTO();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }


	    @PostMapping
	    @ResponseBody
		public String registerUserAccount(@ModelAttribute("user")
	              UserRegisteredDTO registrationDto) {

			User user = userService.save(registrationDto);
	        return "redirect:/login";
	    }
}
