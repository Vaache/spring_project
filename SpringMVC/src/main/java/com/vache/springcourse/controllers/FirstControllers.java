package com.vache.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstControllers {
	@GetMapping("/hello")
	public String HelloPage() {
		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String GoodByePage() {
		return "first/goodbye";
	}
}
