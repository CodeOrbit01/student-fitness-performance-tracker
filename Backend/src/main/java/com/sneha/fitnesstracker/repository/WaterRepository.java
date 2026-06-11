package com.sneha.fitnesstracker.repository;

import com.sneha.fitnesstracker.model.WaterRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WaterRepository extends JpaRepository<WaterRecord, Long> {
    List<WaterRecord> findByUserId(Long userId);
}