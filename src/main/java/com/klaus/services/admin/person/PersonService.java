package com.klaus.services.admin.person;

import com.klaus.dto.PersonEmailDto;
import com.klaus.entity.Person;

import java.util.List;

public interface PersonService {

     String generationEmail(PersonEmailDto personEmailDto);
     Person postPerson(PersonEmailDto personEmailDto);
     List<Person> getAllPerson();



}
