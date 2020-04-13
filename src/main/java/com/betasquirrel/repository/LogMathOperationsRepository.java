package com.betasquirrel.repository;

import com.betasquirrel.model.LogMathOperations;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LogMathOperationsRepository extends JpaRepository<LogMathOperations, Integer>  {

    List<LogMathOperations> findByEmail(String email);
}
