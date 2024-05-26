package com.jeongsu.moni.service;

import com.jeongsu.moni.model.ProcessStatus;
import com.jeongsu.moni.repository.ProcessStatusRepository;
import com.jeongsu.moni.utils.ProcessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessStatusService {
    @Autowired
    private ProcessStatusRepository repository;

    @Value("${process.name.keyword}")
    private String processNameKeyword;

    private static List<ProcessStatus> processStatusList = new ArrayList<ProcessStatus>();

    public List<ProcessStatus> getAllProcesses() {
        if(processStatusList.size() == 0 )
        {
            setAllProcess();
        }

        return processStatusList;
    }

    public void setAllProcess(){
            processStatusList = ProcessUtils.getProcessList(processNameKeyword);
    }

}