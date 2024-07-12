package com.vache.springcourse.controllers;

import com.vache.springcourse.dao.PersonDAO;
import com.vache.springcourse.models.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private final PersonDAO personDAO;

	@Autowired
	public PeopleController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}


	// Получим всех людей из DAO и передадим на отоброжения в представления
	@GetMapping()
	public String index(Model model) {
		model.addAttribute( "people", personDAO.index());

		return "people/index";
	}

	// Получим одного человека по id из DAO и передадим на отоброжения в представления
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", personDAO.show(id));
		return "people/show";
	}

	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "people/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("person") @Valid Person person,
						 BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "people/new";
		personDAO.save(person);
		return "redirect:/people";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id){
		model.addAttribute("person", personDAO.show(id));
		return "people/edit";
	}

	@PatchMapping("{id}")
	public String update(@ModelAttribute("person") @Valid Person person,
						 BindingResult bindingResult, @PathVariable("id") int id) {
		if (bindingResult.hasErrors())
			return "people/edit";

		personDAO.update(person, id);
		return "redirect:/people";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") int id) {
		personDAO.delete(id);
		return "redirect:/people";
	}

}
