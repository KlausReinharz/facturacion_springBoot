package com.klaus.services.admin.person;

import com.klaus.dto.PersonEmailDto;
import com.klaus.entity.Person;
import com.klaus.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

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
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }


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
        String pname = name.trim().split(" ")[0].toLowerCase();
        String lname = lastname.trim().split(" ")[0].toLowerCase();
        if(lname.isEmpty()){
            throw  new IllegalArgumentException("last name can´t be empty");
        }
        return pname.charAt(0)+lname;
    }






}
