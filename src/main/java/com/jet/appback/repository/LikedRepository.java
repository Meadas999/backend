package com.jet.appback.repository;

import com.jet.appback.models.Liked;
import com.jet.appback.models.Nuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikedRepository extends JpaRepository<Liked, Long> {

    List<Liked> findAllByUserId(long userid);

}
