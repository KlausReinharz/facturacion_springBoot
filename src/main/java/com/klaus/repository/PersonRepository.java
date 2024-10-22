package com.klaus.repository;

import com.klaus.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {


    @Query(value = "SELECT count(identification)as identification from project1.person where identification = identification", nativeQuery = true)
    public String verificarSiExiste(@Param("identification")String identification);


}
