package com.jeongsu.moni.controller;

import com.jeongsu.moni.model.MemoryUsage;
import com.jeongsu.moni.model.ProcessStatus;
import com.jeongsu.moni.service.MemoryUsageService;
import com.jeongsu.moni.service.ProcessStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processes")
public class ProcessStatusController {
    @Autowired
    private ProcessStatusService service;

    @GetMapping
    public List<ProcessStatus> getAllProcesses() {
        return service.getAllProcesses();
    }

}
