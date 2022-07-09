package com.example.springrestapi.controllers;


import com.example.springrestapi.models.Person;
import com.example.springrestapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

     @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/name")
    public List<Person> findAll(){
         return peopleService.findAll();//JACKSON  конвертирует эти объекты в JSON
    }

    @GetMapping("/")
    public Person findPerson(@RequestParam (value = "name", required = false)String name){

          return  peopleService.findByName(name);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") int id){
         return peopleService.finById(id);
    }
}
