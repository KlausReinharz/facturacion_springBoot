package com.klaus.controller;

import com.klaus.entity.Person;
import com.klaus.exceptions.BadRequestException;
import com.klaus.exceptions.ResponseMessage;
import com.klaus.services.admin.person.PersonRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRegistrationService personRegistrationService;

    //listar Personas
    @GetMapping("/personas")
    public List<Person> getAllPerson(){
       if(personRegistrationService.getListPerson()==null){
           throw new BadRequestException("person list not found");
       }
        return this.personRegistrationService.getListPerson();
    }

    //Guardar Personas
    @PostMapping("/crear")
    public ResponseEntity<?> postPerson(@RequestBody Person person){
       Person nuevo =this.personRegistrationService.createPerson(person);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    //Obterner cliente por id
    @GetMapping("/persons/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id){
        Optional<Person> person = this.personRegistrationService.getPersonId(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //editar
    @PutMapping("/update")
    public ResponseEntity<?>updatePerson(@RequestBody Person person){
        this.personRegistrationService.updatePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deletePerson(@PathVariable Long id){
        if(this.personRegistrationService.getPersonId(id).isPresent()){
            this.personRegistrationService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/verification/{identification}")
    public ResponseEntity<ResponseMessage>VerificationPerson(@PathVariable String identification){
        String verification = this.personRegistrationService.VerificationPersonId(identification);
        return  ResponseEntity.ok(new ResponseMessage(200, verification));
    }







}
