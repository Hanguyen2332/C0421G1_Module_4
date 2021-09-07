package com.exercise.model.repository;

import com.exercise.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code,Integer> {
    Code findByCode(Long code);
}

