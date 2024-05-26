package com.jeongsu.moni.Scheduler;

import com.jeongsu.moni.service.CpuUsageService;
import com.jeongsu.moni.service.DiskSpaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DiskSpaceUsageScheduler {
    @Autowired
    private DiskSpaceStatusService service;

    @Scheduled(fixedRateString = "${disk.usage.scheduler.interval}")
    public void updateCpuUsageStatus() {
        service.addDiskUsage();
    }
}
