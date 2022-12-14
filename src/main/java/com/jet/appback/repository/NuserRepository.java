package com.jet.appback.repository;

import com.jet.appback.models.Nuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NuserRepository extends JpaRepository<Nuser,Long> {
    @Query(value = "SELECT * FROM BaseUser WHERE email = :email", nativeQuery = true)
    Nuser findByEmailAddress(@Param("email")String email);
    @Query(value = "SELECT id FROM BaseUser WHERE email = :email", nativeQuery = true)
    long findIdByEmail(@Param("email")String email);
    List<Nuser> findAllByEmailIsNotContaining(String email);


}
