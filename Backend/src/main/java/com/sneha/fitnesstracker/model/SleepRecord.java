package com.sneha.fitnesstracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SleepRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate sleepDate;

    private double hoursSlept;

    @ManyToOne
@JoinColumn(name = "user_id")
private User user;

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

    public SleepRecord() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getSleepDate() {
        return sleepDate;
    }

    public void setSleepDate(LocalDate sleepDate) {
        this.sleepDate = sleepDate;
    }

    public double getHoursSlept() {
        return hoursSlept;
    }

    public void setHoursSlept(double hoursSlept) {
        this.hoursSlept = hoursSlept;
    }
}