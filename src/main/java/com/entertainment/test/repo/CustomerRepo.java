package com.entertainment.test.repo;

import com.entertainment.test.entity.EntertainmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<EntertainmentEntity,String> {
}
