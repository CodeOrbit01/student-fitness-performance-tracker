package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.WaterRecord;
import com.sneha.fitnesstracker.repository.WaterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WaterController {

    private final WaterRepository waterRepository;

    public WaterController(WaterRepository waterRepository) {
        this.waterRepository = waterRepository;
    }

    @GetMapping("/water")
    public List<WaterRecord> getWaterRecords() {
        return waterRepository.findAll();
    }

    @PostMapping("/water")
    public WaterRecord addWaterRecord(@RequestBody WaterRecord waterRecord) {
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
}