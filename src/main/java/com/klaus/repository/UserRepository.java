package com.klaus.repository;

import com.klaus.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT session_failed FROM user WHERE userName =: userName", nativeQuery = true)
    Optional<Integer>ObtenerIntentosFallidos(@Param("username")String userName);

    @Query(value = "SELECT status from user WHERE username =: username", nativeQuery = true)
    Optional<Byte>estaBloqueado(@Param("userName")String userName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user u SET session_failed = session_failed + 1 where u.userName =: userName",nativeQuery = true)
    public void incrementarIntentosFallidos(@Param("userName") String userName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET status = 1 WHERE userName =: userName", nativeQuery = true)
    public void bloquearUsuario(@Param("userName") String userName);



}
