package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.SleepRecord;
import com.sneha.fitnesstracker.repository.SleepRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SleepController {

    private final SleepRepository sleepRepository;

    public SleepController(SleepRepository sleepRepository) {
        this.sleepRepository = sleepRepository;
    }

    @GetMapping("/sleep")
    public List<SleepRecord> getSleepRecords() {
        return sleepRepository.findAll();
    }

    @PostMapping("/sleep")
    public SleepRecord addSleepRecord(@RequestBody SleepRecord sleepRecord) {
        return sleepRepository.save(sleepRecord);
    }

    @DeleteMapping("/sleep/{id}")
    public void deleteSleepRecord(@PathVariable Long id) {
        sleepRepository.deleteById(id);
    }

    @GetMapping("/analytics/total-sleep")
    public double getTotalSleep() {
        return sleepRepository.findAll()
                .stream()
                .mapToDouble(SleepRecord::getHoursSlept)
                .sum();
    }
}