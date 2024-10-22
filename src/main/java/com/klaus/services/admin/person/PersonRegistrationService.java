package com.klaus.services.admin.person;

import com.klaus.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRegistrationService {

    Person createPerson(Person person);
    List<Person> getListPerson();
    Optional<Person> getPersonId(Long id);
    void updatePerson(Person person);
    void deletePerson(Long id);



}
