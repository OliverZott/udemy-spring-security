package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * TODO: add enum for ROLES / or env vars?
 */
@Controller
public class DemoController {

	/**
	 * Due to View-Resolver in "DemoAppConfig.java" it will be completed:
	 * /WEB-INF/view/home.jsp
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaders(){
		return "leaders";
	}

	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}

}
