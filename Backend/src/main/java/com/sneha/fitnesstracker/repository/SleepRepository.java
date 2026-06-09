package com.sneha.fitnesstracker.repository;

import com.sneha.fitnesstracker.model.SleepRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepRepository extends JpaRepository<SleepRecord, Long> {
}