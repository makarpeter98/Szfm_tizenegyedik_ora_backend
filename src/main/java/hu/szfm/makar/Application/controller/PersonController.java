package hu.szfm.makar.Application.controller;

import hu.szfm.makar.Application.modell.Person;
import hu.szfm.makar.Application.modell.PersonRepository;
import hu.szfm.makar.Application.exception.PersonNotFoundException;
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
        return personRepository.save(newPerson);
    }

    @GetMapping("/persons")
    List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    Person getUserById(@PathVariable Integer id) {
        System.out.println("ID: " +  id.toString());
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/person/{id}")
    Person updatePerson(@RequestBody Person newPerson, @PathVariable Integer id) {
        return personRepository.findById(id)
                .map(user -> {
                    user.setUsername(newPerson.getUsername());
                    user.setName(newPerson.getName());
                    user.setEmail(newPerson.getEmail());
                    return personRepository.save(user);
                }).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deletePerson(@PathVariable Integer id){
        if(!personRepository.existsById(id)){
            throw new PersonNotFoundException(id);
        }
        personRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}
