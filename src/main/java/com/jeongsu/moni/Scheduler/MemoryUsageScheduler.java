package com.jeongsu.moni.Scheduler;

import com.jeongsu.moni.service.MemoryUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MemoryUsageScheduler {
    @Autowired
    private MemoryUsageService service;

    @Scheduled(fixedRateString = "${memory.usage.scheduler.interval}")
    public void updateMomoryUsageStatus() {
        service.addMomoryUsage();
    }
}
