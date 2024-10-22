package com.klaus.controller;

import com.klaus.entity.Person;
import com.klaus.services.admin.person.PersonRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRegistrationService personRegistrationService;

    //listar Personas
    @GetMapping("/personas")
    public List<Person> getAllPerson(){
        return this.personRegistrationService.getListPerson();
    }

    //Guardar Personas
    @PostMapping("/crear")
    public ResponseEntity<?> postPerson(@RequestBody Person person){
       Person nuevo =this.personRegistrationService.createPerson(person);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }







}
