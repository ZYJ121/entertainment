package com.entertainment.test.repo;

import com.entertainment.test.entity.EntertainmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntertainmentRepo extends JpaRepository<EntertainmentEntity,String> {
    EntertainmentEntity findById(Integer id);
}
