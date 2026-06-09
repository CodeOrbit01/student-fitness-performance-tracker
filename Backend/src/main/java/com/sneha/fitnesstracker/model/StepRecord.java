package com.sneha.fitnesstracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class StepRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate stepDate;

    private int stepsWalked;

    public StepRecord() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStepDate() {
        return stepDate;
    }

    public void setStepDate(LocalDate stepDate) {
        this.stepDate = stepDate;
    }

    public int getStepsWalked() {
        return stepsWalked;
    }

    public void setStepsWalked(int stepsWalked) {
        this.stepsWalked = stepsWalked;
    }
}