package com.sneha.fitnesstracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "workouts")
public class Workout {
    @ManyToOne
@JoinColumn(name = "user_id")
private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate workoutDate;

    private String exercise;

    private Integer setsDone;

    private Integer repsDone;

    private Integer caloriesBurned;

    public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

    public Workout() {
    }

    public Long getId() {
        return id;
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