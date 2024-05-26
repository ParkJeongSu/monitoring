package com.jeongsu.moni.controller;

import com.jeongsu.moni.model.CpuUsage;
import com.jeongsu.moni.model.DiskSpaceStatus;
import com.jeongsu.moni.service.CpuUsageService;
import com.jeongsu.moni.service.DiskSpaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpu")
public class CpuUsageController {
    @Autowired
    private CpuUsageService service;

    @GetMapping
    public List<CpuUsage> getAllCpuUsages() {
        return service.getAllCpuUsages();
    }

}