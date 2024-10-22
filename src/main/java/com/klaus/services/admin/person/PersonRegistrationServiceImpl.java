package com.klaus.services.admin.person;

import com.klaus.dto.PersonDto;
import com.klaus.entity.Person;
import com.klaus.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonRegistrationServiceImpl implements PersonRegistrationService {

    private final PersonRepository personRepository;

    //crearCliente
    public Person createPerson(Person person){
        return this.personRepository.save(person);
    }
    //Listar
    public List<Person> getListPerson(){
        return  (List<Person>) this.personRepository.findAll();
    }
    //Obtener Cliente id
    public Optional<Person>getPersonId(Long id){
        return this.personRepository.findById(id);
    }
    //actualizar person
    public void updatePerson(Person person){
        this.personRepository.save(person);
    }
    //delte
    public void deletePerson(Long id){
        this.personRepository.deleteById(id);
    }






}
