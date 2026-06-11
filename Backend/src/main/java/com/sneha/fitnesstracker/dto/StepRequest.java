package com.sneha.fitnesstracker.dto;

import java.time.LocalDate;

public class StepRequest {

    private Long userId;

    private LocalDate stepDate;

    private int stepsWalked;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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