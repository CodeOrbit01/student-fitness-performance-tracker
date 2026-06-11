package com.sneha.fitnesstracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class WaterRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate waterDate;

    private double litersDrank;

    @ManyToOne
@JoinColumn(name = "user_id")
private User user;

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

    public WaterRecord() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getWaterDate() {
        return waterDate;
    }

    public void setWaterDate(LocalDate waterDate) {
        this.waterDate = waterDate;
    }

    public double getLitersDrank() {
        return litersDrank;
    }

    public void setLitersDrank(double litersDrank) {
        this.litersDrank = litersDrank;
    }
}