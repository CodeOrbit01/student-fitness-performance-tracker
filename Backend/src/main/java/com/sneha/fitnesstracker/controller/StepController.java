package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.StepRecord;
import com.sneha.fitnesstracker.repository.StepRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StepController {

    private final StepRepository stepRepository;

    public StepController(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    @GetMapping("/steps")
    public List<StepRecord> getStepRecords() {
        return stepRepository.findAll();
    }

    @PostMapping("/steps")
    public StepRecord addStepRecord(@RequestBody StepRecord stepRecord) {
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