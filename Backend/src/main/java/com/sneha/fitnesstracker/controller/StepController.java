package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.StepRecord;
import com.sneha.fitnesstracker.repository.StepRepository;
import org.springframework.web.bind.annotation.*;
import com.sneha.fitnesstracker.dto.StepRequest;
import com.sneha.fitnesstracker.model.User;
import com.sneha.fitnesstracker.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StepController {

    private final StepRepository stepRepository;
    private final UserRepository userRepository;

    public StepController(
        StepRepository stepRepository,
        UserRepository userRepository) {

    this.stepRepository = stepRepository;
    this.userRepository = userRepository;
}

    @GetMapping("/steps")
    public List<StepRecord> getStepRecords() {
        return stepRepository.findAll();
    }

    @GetMapping("/steps/user/{userId}")
public List<StepRecord> getStepsByUser(
        @PathVariable Long userId) {

    return stepRepository.findByUserId(userId);
}

    @PostMapping("/steps")
public StepRecord addSteps(
        @RequestBody StepRequest request) {

    User user = userRepository
            .findById(request.getUserId())
            .orElseThrow();

    StepRecord stepRecord = new StepRecord();
    stepRecord.setStepDate(request.getStepDate());

stepRecord.setStepsWalked(request.getStepsWalked());

    stepRecord.setUser(user);

    return stepRepository.save(stepRecord);
}

    @DeleteMapping("/steps/{id}")
    public void deleteStepRecord(@PathVariable Long id) {
        stepRepository.deleteById(id);
    }

    @GetMapping("/analytics/total-steps")
    public int getTotalSteps() {
        return stepRepository.findAll()
                .stream()
                .mapToInt(StepRecord::getStepsWalked)
                .sum();
    }
}