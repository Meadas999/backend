package com.jet.appback.repository;

import com.jet.appback.models.Liked;
import com.jet.appback.models.Nuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedRepository extends JpaRepository<Liked, Long> {

    List<Liked> findAllByUserId(long userid);

}
