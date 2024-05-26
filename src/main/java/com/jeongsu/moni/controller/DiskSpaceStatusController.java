package com.jeongsu.moni.controller;

import com.jeongsu.moni.model.DiskSpaceStatus;
import com.jeongsu.moni.model.TablespaceStatus;
import com.jeongsu.moni.service.DiskSpaceStatusService;
import com.jeongsu.moni.service.TablespaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disks")
public class DiskSpaceStatusController {
    @Autowired
    private DiskSpaceStatusService service;

    @GetMapping
    public List<DiskSpaceStatus> getAllDisks() {
        return service.getAllDisks();
    }
}