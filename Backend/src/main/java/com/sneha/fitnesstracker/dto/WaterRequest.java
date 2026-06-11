package com.sneha.fitnesstracker.dto;

import java.time.LocalDate;

public class WaterRequest {

    private Long userId;

    private LocalDate waterDate;

    private double litersDrank;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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