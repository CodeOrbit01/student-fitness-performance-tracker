package com.sneha.fitnesstracker.repository;

import com.sneha.fitnesstracker.model.SleepRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SleepRepository extends JpaRepository<SleepRecord, Long> {
    List<SleepRecord> findByUserId(Long userId);
}