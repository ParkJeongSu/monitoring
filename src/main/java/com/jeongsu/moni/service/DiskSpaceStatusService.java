package com.jeongsu.moni.service;

import com.jeongsu.moni.model.DiskSpaceStatus;
import com.jeongsu.moni.repository.DiskSpaceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiskSpaceStatusService {
    @Autowired
    private DiskSpaceStatusRepository repository;

    private static List<DiskSpaceStatus> diskUsageList = new ArrayList<DiskSpaceStatus>();

    public void addDiskUsage()
    {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem os = systemInfo.getOperatingSystem();
        diskUsageList.clear();


        // Disk Usage
        for (oshi.software.os.OSFileStore fs : os.getFileSystem().getFileStores()) {
            System.out.println("File System: " + fs.getMount());
            System.out.println("Total Space: " + fs.getTotalSpace() / 1024 / 1024 / 1024 + " GB");
            System.out.println("Usable Space: " + fs.getUsableSpace() / 1024 / 1024 / 1024 + " GB");
            DiskSpaceStatus diskSpaceStatus = new DiskSpaceStatus();
            diskSpaceStatus.setId(Long.valueOf(diskUsageList.size()+1));
            diskSpaceStatus.setDiskName(fs.getName());
            diskSpaceStatus.setFreeSpace(fs.getFreeSpace() / 1024 / 1024 / 1024);
            diskSpaceStatus.setUsedSpace( (fs.getTotalSpace() - fs.getFreeSpace()) / 1024 / 1024 / 1024 );
            diskUsageList.add(diskSpaceStatus);
        }
    }
    public List<DiskSpaceStatus> getAllDisks() {

        if(diskUsageList.size() == 0)
        {
            addDiskUsage();
        }

        return diskUsageList;
    }

}