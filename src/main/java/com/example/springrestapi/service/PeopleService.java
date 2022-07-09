package com.example.springrestapi.service;


import com.example.springrestapi.models.Person;
import com.example.springrestapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }




    public List<Person> findAll(){
       return peopleRepository.findAll();
    }

    public Person findByName(String name){
        Optional<Person> foundPerson = peopleRepository.findByName(name);

        return foundPerson.orElse(null);

    }

    public Person finById (int id){
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null); }

}
