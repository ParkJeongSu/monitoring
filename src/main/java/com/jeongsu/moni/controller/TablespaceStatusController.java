package com.jeongsu.moni.controller;

import com.jeongsu.moni.model.TablespaceStatus;
import com.jeongsu.moni.service.TablespaceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tablespaces")
public class TablespaceStatusController {
    @Autowired
    private TablespaceStatusService service;

    @GetMapping
    public List<TablespaceStatus> getAllTablespaces() {
        return service.getAllTablespaces();
    }

}
