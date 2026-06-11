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

    @ManyToOne
@JoinColumn(name = "user_id")
private User user;

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

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