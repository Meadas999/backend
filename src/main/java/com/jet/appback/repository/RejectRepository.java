package com.jet.appback.repository;

import com.jet.appback.models.Reject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejectRepository extends JpaRepository<Reject, Long> {
}
