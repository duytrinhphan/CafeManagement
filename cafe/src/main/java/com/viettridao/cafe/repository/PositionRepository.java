package com.viettridao.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viettridao.cafe.model.PositionEntity;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {

    List<PositionEntity> findPositionByDeletedFalse();
}
