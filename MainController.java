package com.reglog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reglog.model.User;
import com.reglog.repository.UserRepository;
import com.reglog.service.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String index() {
		return "base";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user , org.springframework.ui.Model model) //  to get binding data from html page 
	{
		boolean existuser = userService.checkEmail(user.getEmail());
		
		if(existuser) {
			 model.addAttribute("msg", "User Already Exists !!");
		}else {
			User userdetails= userService.registerUser(user);
			if(userdetails != null)
			{
				model.addAttribute("regSuccess", "Regsiteration Done");
			}else {
				model.addAttribute("errReg", "error in regsiteration");
				System.out.println("error in regsiteration");
			}
		
		}
		return "redirect:/register";
	}

	
	
	
	
	
}
