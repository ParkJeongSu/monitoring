package com.jeongsu.moni.service;

import com.jeongsu.moni.model.CpuUsage;
import com.jeongsu.moni.model.DiskSpaceStatus;
import com.jeongsu.moni.repository.CpuUsageRepository;
import com.jeongsu.moni.repository.DiskSpaceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class CpuUsageService {
    @Autowired
    private CpuUsageRepository repository;

    private static Queue<CpuUsage> cpuUsageQueue = new LinkedList<>();

    @Value("${cpu.usage.count}")
    private int cpuUsageCount;

    public void addCpuUsage()
    {
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();

        // Initial tick counts
        long[] prevTicks = processor.getSystemCpuLoadTicks();

        // Wait a second to get a current tick count
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Current tick counts
//        long[] ticks = processor.getSystemCpuLoadTicks();
//        long user = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
//        long nice = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
//        long sys = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
//        long idle = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
//        long iowait = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
//        long irq = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
//        long softirq = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
//        long steal = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
//        long totalCpu = user + nice + sys + idle + iowait + irq + softirq + steal;
//
//        System.out.format("User: %.1f%%\n", 100d * user / totalCpu);
//        System.out.format("Nice: %.1f%%\n", 100d * nice / totalCpu);
//        System.out.format("System: %.1f%%\n", 100d * sys / totalCpu);
//        System.out.format("Idle: %.1f%%\n", 100d * idle / totalCpu);
//        System.out.format("I/O Wait: %.1f%%\n", 100d * iowait / totalCpu);
//        System.out.format("IRQ: %.1f%%\n", 100d * irq / totalCpu);
//        System.out.format("SoftIRQ: %.1f%%\n", 100d * softirq / totalCpu);
//        System.out.format("Steal: %.1f%%\n", 100d * steal / totalCpu);

        // Total CPU usage
        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks);
        System.out.format("Total CPU Usage: %.1f%%\n", cpuLoad * 100);

        CpuUsage usage = new CpuUsage();
        usage.setId( Long.valueOf( cpuUsageQueue.size()+1 ) );
        usage.setUsage(cpuLoad*100);
        usage.setTimestamp(LocalDateTime.now());

        cpuUsageQueue.add(usage);

        if(cpuUsageCount  < cpuUsageQueue.size() )
        {
            cpuUsageQueue.poll();
        }
    }

    public List<CpuUsage> getAllCpuUsages()
    {
        return (List<CpuUsage>) cpuUsageQueue;
    }

}