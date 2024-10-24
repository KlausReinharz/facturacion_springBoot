package com.klaus.controller;

import com.klaus.dto.PersonEmailDto;
import com.klaus.entity.Person;
import com.klaus.services.admin.person.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    //postPerson
    @PostMapping("/persona")
    public ResponseEntity<?>postPerson(@RequestBody PersonEmailDto personEmailDto){
         Person person = personService.postPerson(personEmailDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

    //getAllPerson
    @GetMapping("/getperson")
    public ResponseEntity<List<Person>>getAllPerson(){
        return ResponseEntity.ok(personService.getAllPerson());
    }











}
