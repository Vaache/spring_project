package com.vache.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;

@Controller
@RequestMapping("/first")
public class FirstControllers {
	@GetMapping("/hello")
	public String HelloPage(@RequestParam(value = "name", required = false) String name,
							@RequestParam(value = "surname", required = false) String surname,
							Model model) {
		model.addAttribute("message", "Hello " + name + " " + surname);

		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String GoodByePage() {
		return "first/goodbye";
	}

	@GetMapping("/calculate")
	public String calculate(@RequestParam(value = "num1") int num1,
							@RequestParam(value = "num2") int num2,
							@RequestParam(value = "action") char action,
							Model model) {

		double res = 0;
		switch (action) {
			case '+': {
				res = (num1 + num2);
				break;
			}
			case '-': {
				res = (num1 - num2);
				break;
			}
			case '*': {
				res = (num1 * num2);
				break;
			}
			case '/': {
				if (num2 != 0) {
					res = ((double)num1 / (double)num2);
				}
				else {
					model.addAttribute("Calculate", "Can't divide to zero");
					return "/first/calculate";
				}
				break;
			}
			default:
				model.addAttribute("Calculate", "Invalid action");
				break;
		}
			model.addAttribute("Calculate",
					"Calculate: " + num1 + " " + action + " " + num2 + " = " + res);
		return "/first/calculate";
	}
}
