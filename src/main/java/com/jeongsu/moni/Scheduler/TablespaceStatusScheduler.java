package com.jeongsu.moni.Scheduler;

import com.jeongsu.moni.service.DiskSpaceStatusService;
import com.jeongsu.moni.service.TablespaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TablespaceStatusScheduler {
    @Autowired
    private TablespaceStatusService service;

    @Scheduled(fixedRateString = "${tablespace.usage.scheduler.interval}")
    public void updateCpuUsageStatus() {
        service.setAllTablespaces();
    }
}
