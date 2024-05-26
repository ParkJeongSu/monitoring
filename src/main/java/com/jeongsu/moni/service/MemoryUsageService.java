package com.jeongsu.moni.service;

import com.jeongsu.moni.model.CpuUsage;
import com.jeongsu.moni.model.MemoryUsage;
import com.jeongsu.moni.repository.CpuUsageRepository;
import com.jeongsu.moni.repository.MemoryUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class MemoryUsageService {
    @Autowired
    private MemoryUsageRepository repository;

    private static Queue<MemoryUsage> memoryUsageQueue = new LinkedList<>();

    @Value("${memory.usage.count}")
    private int memoryUsageCount;

    public List<MemoryUsage> getAllMemoryUsages()
    {
        return (List<MemoryUsage>) memoryUsageQueue;
    }

    public void addMomoryUsage()
    {
        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        MemoryUsage memoryUsage = new MemoryUsage();
        memoryUsage.setId( Long.valueOf( memoryUsageQueue.size() + 1 ) );
        double memoryUsageP =( (double) ( memory.getTotal() - memory.getAvailable()) /  (double) memory.getTotal() ) * 100;
        memoryUsage.setUsage( memoryUsageP  );
        memoryUsage.setTimestamp(LocalDateTime.now());
        memoryUsageQueue.add(memoryUsage);


        if(memoryUsageCount  < memoryUsageQueue.size() )
        {
            memoryUsageQueue.poll();
        }
    }

}