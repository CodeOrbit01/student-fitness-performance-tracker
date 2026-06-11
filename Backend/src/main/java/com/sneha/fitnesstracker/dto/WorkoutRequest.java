package com.sneha.fitnesstracker.dto;

import java.time.LocalDate;

public class WorkoutRequest {

    private Long userId;

    private LocalDate workoutDate;

    private String exercise;

    private Integer setsDone;

    private Integer repsDone;

    private Integer caloriesBurned;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Integer getSetsDone() {
        return setsDone;
    }

    public void setSetsDone(Integer setsDone) {
        this.setsDone = setsDone;
    }

    public Integer getRepsDone() {
        return repsDone;
    }

    public void setRepsDone(Integer repsDone) {
        this.repsDone = repsDone;
    }

    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Integer caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
}