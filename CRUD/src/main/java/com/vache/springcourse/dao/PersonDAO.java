package com.vache.springcourse.dao;

import com.vache.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	private List<Person> people;

	{
		people = new ArrayList<>();
		people.add(new Person("John", "John@mail.ru", 27, ++PEOPLE_COUNT));
		people.add(new Person("Tom", "Tom@mail.ru", 13, ++PEOPLE_COUNT));
		people.add(new Person("Bob", "Bob@mail.ru", 35, ++PEOPLE_COUNT));
		people.add(new Person("Leo", "Leo@mail.ru", 55, ++PEOPLE_COUNT));
	}

	public List<Person> index() {
		return people;
	}

	public Person show(int id) {
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}

	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}

	public void update(Person person, int id) {
		Person personToUpdate = show(id);

		personToUpdate.setName(person.getName());
		personToUpdate.setAge(person.getAge());
		personToUpdate.setEmail(person.getEmail());
	}

	public void delete(int id) {
		people.removeIf(p -> id == p.getId());
	}
}

