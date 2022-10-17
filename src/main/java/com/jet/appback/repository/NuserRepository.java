package com.jet.appback.repository;

import com.jet.appback.models.Nuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NuserRepository extends JpaRepository<Nuser,Long> {
}
