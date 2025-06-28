package com.viettridao.cafe.repository;

import com.viettridao.cafe.model.AccountEntity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    Optional<AccountEntity> findByUsername(String username);

    Optional<AccountEntity> findByUsernameAndDeletedFalse(String username);

    List<AccountEntity> findAllByDeletedFalse();

    @EntityGraph(attributePaths = {"employee", "employee.position"})
    Optional<AccountEntity> findById(Integer id);

}
