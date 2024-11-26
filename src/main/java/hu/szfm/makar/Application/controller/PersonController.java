package hu.szfm.makar.Application.controller;

import hu.szfm.makar.Application.modell.Person;
import hu.szfm.makar.Application.modell.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http.//localhost:3000")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/person")
    Person newPerson(@RequestBody Person newPerson)
    {
        return personRepository.save(newPerson)
    }

    @GetMapping("/persons")
    List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }

}
