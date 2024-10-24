package com.klaus.controller;

import com.klaus.dto.PersonEmailDto;
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

    //generarCorreo
    @PostMapping("generar-email")
    public ResponseEntity<String>generationEmail(@RequestBody PersonEmailDto personEmailDto){
        String emailG = personRegistrationService.generationEmail(personEmailDto);
        return ResponseEntity.ok(emailG);
    }






}
