package com.vache.springcourse.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

public class Person {
	private int id;

	@Min(value = 0, message = "Age should be greater then 0")
	private int age;

	@NotEmpty(message = "Name should not be empty")
	@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	private String name;

	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email should be valid")
	private String email;

	public Person(String name,String email, int age, int id) {
		this.email = email;
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public Person() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
