package com.entertainment.test.repo;

import com.entertainment.test.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderItemEntity,String> {
}
