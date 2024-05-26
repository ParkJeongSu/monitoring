package com.jeongsu.moni.controller;

import com.jeongsu.moni.model.CpuUsage;
import com.jeongsu.moni.model.MemoryUsage;
import com.jeongsu.moni.service.CpuUsageService;
import com.jeongsu.moni.service.MemoryUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memory")
public class MemoryUsageController {
    @Autowired
    private MemoryUsageService service;

    @GetMapping
    public List<MemoryUsage> getAllMemoryUsages() {
        return service.getAllMemoryUsages();
    }

}