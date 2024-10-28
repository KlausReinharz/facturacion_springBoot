package com.klaus.services.admin.person;

import com.klaus.dto.PersonDto;
import com.klaus.dto.PersonEmailDto;
import com.klaus.entity.Person;
import com.klaus.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
/*
    @Transactional
    public Person postPerson(PersonEmailDto personEmailDto){
        String emailFinal = generationEmail(personEmailDto);
        Person person = new Person();
        person.setName(personEmailDto.getName());
        person.setLastName(personEmailDto.getLastName());
        person.setEmail(emailFinal);

        person.setIdentification(personEmailDto.getIdentification());
        person.setDateOfBirth(personEmailDto.getDateOfBirth());


        return personRepository.save(person);
    }*/


    //PostEmail an person data
    @Override
    public PersonDto save(PersonEmailDto personEmailDto) {
        String emailAutoGenerated = generatedEmail(personEmailDto);
        Person person = new Person();
        person.setName(personEmailDto.getName());
        person.setLastName(personEmailDto.getLastName());
        person.setEmailGenerated(emailAutoGenerated);
        person.setIdentification(personEmailDto.ge);
        return null;
    }





    public String generatedEmail(PersonEmailDto personEmailDto){
        String emailBase = generatedEmailBase(personEmailDto.getName(), personEmailDto.getLastName());
        String email = emailBase + "@mail.com";
        int cont = 1;

        while(personRepository.existsByEmail(email)){
            email = emailBase + cont + "@mail.com";
            cont ++;
        }
        return email;
    }

    private String generatedEmailBase(String name ,String lastname){
        String pname = name.trim().split(" ")[0].toLowerCase();
        /*String lname = lastname.trim().split(" ")[0].toLowerCase();
        if(lname.isEmpty()){
            throw  new IllegalArgumentException("last name can´t be empty");
        }*/

        String[] plastname = lastname.trim().split(" ");

        if(plastname.length==0){
            throw  new  IllegalArgumentException("last name can´t be empty");
        }

        String firstLastname = plastname[0].toLowerCase();
        String secondLastname = "";

        if(plastname.length > 1){
            secondLastname = plastname[1].substring(0,1).toLowerCase();
        }
        return pname.charAt(0) + firstLastname + secondLastname;
    }



}
