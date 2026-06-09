package com.sneha.fitnesstracker.repository;

import com.sneha.fitnesstracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository
        extends JpaRepository<Workout, Long> {
}