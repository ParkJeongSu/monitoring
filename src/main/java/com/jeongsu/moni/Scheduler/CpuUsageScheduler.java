package com.jeongsu.moni.Scheduler;

import com.jeongsu.moni.model.ProcessStatus;
import com.jeongsu.moni.service.CpuUsageService;
import com.jeongsu.moni.service.ProcessStatusService;
import com.jeongsu.moni.utils.ProcessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CpuUsageScheduler {
    @Autowired
    private CpuUsageService service;

    @Scheduled(fixedRateString = "${cpu.usage.scheduler.interval}")
    public void updateCpuUsageStatus() {
        service.addCpuUsage();
    }
}
