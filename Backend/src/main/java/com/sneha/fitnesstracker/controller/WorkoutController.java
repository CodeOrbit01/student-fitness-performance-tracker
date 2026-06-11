package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.Workout;
import com.sneha.fitnesstracker.repository.WorkoutRepository;
import org.springframework.web.bind.annotation.*;
import com.sneha.fitnesstracker.dto.WorkoutRequest;
import com.sneha.fitnesstracker.model.User;
import com.sneha.fitnesstracker.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WorkoutController {

    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public WorkoutController(
        WorkoutRepository workoutRepository,
        UserRepository userRepository) {

    this.workoutRepository = workoutRepository;
    this.userRepository = userRepository;
}

    // =========================
    // WORKOUT CRUD ENDPOINTS
    // =========================

    @GetMapping("/workouts")
    public List<Workout> getWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/workouts/user/{userId}")
public List<Workout> getWorkoutsByUser(
        @PathVariable Long userId) {

    return workoutRepository.findByUserId(userId);
}

    @PostMapping("/workouts")
public Workout addWorkout(
        @RequestBody WorkoutRequest request) {

    User user = userRepository
            .findById(request.getUserId())
            .orElseThrow();

    Workout workout = new Workout();

    workout.setWorkoutDate(request.getWorkoutDate());
    workout.setExercise(request.getExercise());
    workout.setSetsDone(request.getSetsDone());
    workout.setRepsDone(request.getRepsDone());
    workout.setCaloriesBurned(request.getCaloriesBurned());

    workout.setUser(user);

    return workoutRepository.save(workout);
}


    @DeleteMapping("/workouts/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutRepository.deleteById(id);
    }

    @PutMapping("/workouts/{id}")
    public Workout updateWorkout(
            @PathVariable Long id,
            @RequestBody Workout updatedWorkout) {

        Workout workout = workoutRepository.findById(id)
                .orElseThrow();

        workout.setWorkoutDate(updatedWorkout.getWorkoutDate());
        workout.setExercise(updatedWorkout.getExercise());
        workout.setSetsDone(updatedWorkout.getSetsDone());
        workout.setRepsDone(updatedWorkout.getRepsDone());
        workout.setCaloriesBurned(updatedWorkout.getCaloriesBurned());

        return workoutRepository.save(workout);
    }

    // =========================
    // ANALYTICS ENDPOINTS
    // =========================

    @GetMapping("/analytics/total-workouts")
    public long getTotalWorkouts() {
        return workoutRepository.count();
    }

    @GetMapping("/analytics/total-workouts/{userId}")
    public long getTotalWorkoutsByUser(@PathVariable Long userId) {
        return workoutRepository.findByUserId(userId).size();
    }

    @GetMapping("/analytics/total-calories")
    public int getTotalCalories() {
        return workoutRepository.findAll()
                .stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();
    }

    @GetMapping("/analytics/total-calories/{userId}")
    public int getTotalCaloriesByUser(@PathVariable Long userId) {
        return workoutRepository.findByUserId(userId)
                .stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();
    }

    @GetMapping("/analytics/average-reps")
    public double getAverageReps() {
        return workoutRepository.findAll()
                .stream()
                .mapToInt(Workout::getRepsDone)
                .average()
                .orElse(0);
    }

    @GetMapping("/analytics/average-reps/{userId}")
    public double getAverageRepsByUser(@PathVariable Long userId) {
        return workoutRepository.findByUserId(userId)
                .stream()
                .mapToInt(Workout::getRepsDone)
                .average()
                .orElse(0);
    }

    @GetMapping("/analytics/average-sets")
    public double getAverageSets() {
        return workoutRepository.findAll()
                .stream()
                .mapToInt(Workout::getSetsDone)
                .average()
                .orElse(0);
    }

    @GetMapping("/analytics/average-sets/{userId}")
    public double getAverageSetsByUser(@PathVariable Long userId) {
        return workoutRepository.findByUserId(userId)
                .stream()
                .mapToInt(Workout::getSetsDone)
                .average()
                .orElse(0);
    }

    @GetMapping("/analytics/workouts")
    public List<Workout> analyticsWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/analytics/workouts/{userId}")
    public List<Workout> analyticsWorkoutsByUser(@PathVariable Long userId) {
        return workoutRepository.findByUserId(userId);
    }
}