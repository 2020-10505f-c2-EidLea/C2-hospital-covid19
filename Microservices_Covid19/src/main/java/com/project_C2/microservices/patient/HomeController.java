package com.project_C2.microservices.patient;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 * 
 * @author Michel IBRAHIM
 */

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	
}
