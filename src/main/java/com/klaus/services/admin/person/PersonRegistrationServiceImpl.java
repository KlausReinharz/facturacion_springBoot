package com.klaus.services.admin.person;

import com.klaus.dto.PersonEmailDto;
import com.klaus.entity.Person;
import com.klaus.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonRegistrationServiceImpl implements PersonRegistrationService {

    private final PersonRepository personRepository;

    public String generationEmail(PersonEmailDto personEmailDto){
        String emailBase = generationEmailBase(personEmailDto.getName(), personEmailDto.getLastName());
        String email = emailBase + "@mail.com";
        int cont = 1;

        while(personRepository.existsByEmail(email)){
            email = emailBase + cont + "@mail.com";
            cont ++;
        }
        return email;
    }

    private String generationEmailBase(String name ,String lastname){
        String pname = name.split("")[0].toLowerCase();
        String lname = lastname.split("")[0].toLowerCase();
        return pname.charAt(0)+lname;
    }






}
