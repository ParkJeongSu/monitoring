package com.jeongsu.moni.controller;

import com.jeongsu.moni.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private TablespaceStatusService tablespaceStatusService;

    @Autowired
    private DiskSpaceStatusService diskSpaceStatusService;

    @Autowired
    private CpuUsageService cpuUsageService;

    @Autowired
    private MemoryUsageService memoryUsageService;

    @Autowired
    private ProcessStatusService processStatusService;

    @Value("${broswer.refresh.time}")
    private int refreshTime;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("processes", processStatusService.getAllProcesses());
        model.addAttribute("databaseTablespace", tablespaceStatusService.getAllTablespaces());
        model.addAttribute("diskUsages", diskSpaceStatusService.getAllDisks());
        model.addAttribute("cpuUsages", cpuUsageService.getAllCpuUsages());
        model.addAttribute("memoryUsages", memoryUsageService.getAllMemoryUsages());
        model.addAttribute("refreshment", refreshTime);

        return "index";
    }
}
