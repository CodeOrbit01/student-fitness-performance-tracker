package com.sneha.fitnesstracker.repository;

import com.sneha.fitnesstracker.model.StepRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<StepRecord, Long> {
}