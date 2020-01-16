package com.entertainment.test.repo;

import com.entertainment.test.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<MenuEntity,String> {
}
