package com.viettridao.cafe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viettridao.cafe.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findEmployeeByDeletedFalse();

    Optional<EmployeeEntity> findByAccount_Username(String username);
}
