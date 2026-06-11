package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.SleepRecord;
import com.sneha.fitnesstracker.repository.SleepRepository;
import org.springframework.web.bind.annotation.*;
import com.sneha.fitnesstracker.dto.SleepRequest;
import com.sneha.fitnesstracker.model.User;
import com.sneha.fitnesstracker.repository.UserRepository;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SleepController {

    private final SleepRepository sleepRepository;
    private final UserRepository userRepository;

    public SleepController(
        SleepRepository sleepRepository,
        UserRepository userRepository) {

    this.sleepRepository = sleepRepository;
    this.userRepository = userRepository;
}

    @GetMapping("/sleep")
    public List<SleepRecord> getSleepRecords() {
        return sleepRepository.findAll();
    }

    @GetMapping("/sleep/user/{userId}")
public List<SleepRecord> getSleepByUser(
        @PathVariable Long userId) {

    return sleepRepository.findByUserId(userId);
}

    @PostMapping("/sleep")
public SleepRecord addSleep(
        @RequestBody SleepRequest request) {

    User user = userRepository
            .findById(request.getUserId())
            .orElseThrow();

    SleepRecord sleepRecord = new SleepRecord();

    sleepRecord.setSleepDate(request.getSleepDate());
    sleepRecord.setHoursSlept(request.getHoursSlept());

    sleepRecord.setUser(user);

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

    @GetMapping("/analytics/total-sleep/{userId}")
    public double getTotalSleepByUser(@PathVariable Long userId) {
        return sleepRepository.findByUserId(userId)
                .stream()
                .mapToDouble(SleepRecord::getHoursSlept)
                .sum();
    }
}