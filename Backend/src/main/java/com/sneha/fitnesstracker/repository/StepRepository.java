package com.sneha.fitnesstracker.repository;

import com.sneha.fitnesstracker.model.StepRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StepRepository extends JpaRepository<StepRecord, Long> {
    List<StepRecord> findByUserId(Long userId);
}