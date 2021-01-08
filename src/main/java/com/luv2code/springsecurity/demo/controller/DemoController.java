package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	/**
	 * Due to View-Resolver in "DemoAppCOnfig.java" it will be completed:
	 * /WEB-INF/view/home.jsp
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

}
