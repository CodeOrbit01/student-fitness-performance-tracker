package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.WaterRecord;
import com.sneha.fitnesstracker.repository.WaterRepository;
import org.springframework.web.bind.annotation.*;
import com.sneha.fitnesstracker.dto.WaterRequest;
import com.sneha.fitnesstracker.model.User;
import com.sneha.fitnesstracker.repository.UserRepository;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WaterController {

    private final WaterRepository waterRepository;
    private final UserRepository userRepository;

    public WaterController(
        WaterRepository waterRepository,
        UserRepository userRepository) {

    this.waterRepository = waterRepository;
    this.userRepository = userRepository;
}

    @GetMapping("/water")
    public List<WaterRecord> getWaterRecords() {
        return waterRepository.findAll();
    }

    @GetMapping("/water/user/{userId}")
public List<WaterRecord> getWaterByUser(
        @PathVariable Long userId) {

    return waterRepository.findByUserId(userId);
}

    @PostMapping("/water")
public WaterRecord addWater(
        @RequestBody WaterRequest request) {

    User user = userRepository
            .findById(request.getUserId())
            .orElseThrow();

    WaterRecord waterRecord = new WaterRecord();

    waterRecord.setWaterDate(request.getWaterDate());
    waterRecord.setLitersDrank(request.getLitersDrank());

    waterRecord.setUser(user);

    return waterRepository.save(waterRecord);
}

    @DeleteMapping("/water/{id}")
    public void deleteWaterRecord(@PathVariable Long id) {
        waterRepository.deleteById(id);
    }

    @GetMapping("/analytics/total-water")
    public double getTotalWater() {
        return waterRepository.findAll()
                .stream()
                .mapToDouble(WaterRecord::getLitersDrank)
                .sum();
    }

    @GetMapping("/analytics/total-water/{userId}")
    public double getTotalWaterByUser(@PathVariable Long userId) {
        return waterRepository.findByUserId(userId)
                .stream()
                .mapToDouble(WaterRecord::getLitersDrank)
                .sum();
    }
}