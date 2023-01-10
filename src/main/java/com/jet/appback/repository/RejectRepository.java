package com.jet.appback.repository;

import com.jet.appback.models.Reject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RejectRepository extends JpaRepository<Reject, Long> {

    List<Reject> findAllByUserId(long userid);
}
