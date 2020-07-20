package com.entertainment.test.repo;

import com.entertainment.test.entity.DramaSeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DramaSeriesRepo extends JpaRepository<DramaSeriesEntity,String> {
    //根据名字查询节目
    DramaSeriesEntity findByName(String name);
    //根据更新状态查询节目
    List<DramaSeriesEntity> findBySeriesState(Integer state);
}
