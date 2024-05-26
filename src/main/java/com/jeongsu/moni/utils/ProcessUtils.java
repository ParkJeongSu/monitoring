package com.jeongsu.moni.utils;

import com.jeongsu.moni.model.ProcessStatus;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessUtils {

    public static List<ProcessStatus> getProcessList( String processNameKeyword) {
        List<ProcessStatus> processList = new ArrayList<>();
        List<String> processNameList = Arrays.asList(processNameKeyword.split(","));
        try {
            SystemInfo systemInfo = new SystemInfo();
            OperatingSystem os = systemInfo.getOperatingSystem();
            List<OSProcess> processes = os.getProcesses(0, OperatingSystem.ProcessSort.CPU);

            for(String processName : processNameList)
            {
                ProcessStatus processStatus = new ProcessStatus();
                processStatus.setId(Long.valueOf(processList.size() + 1));
                processStatus.setProcessName(processName);
                processStatus.setAlive(false);
                for (OSProcess process : processes) {
                    if(process.getName().toUpperCase().contains( processName.toUpperCase() ))
                    {
                        processStatus.setProcessName(process.getName());
                        processStatus.setAlive(true);
                    }
//                    System.out.println("Process ID: " + process.getProcessID());
//                    System.out.println("Process Name: " + process.getName());
//                    System.out.println("User: " + process.getUser());
//                    System.out.println("State: " + process.getState());
//                    System.out.println("Memory Usage: " + process.getResidentSetSize() / 1024 / 1024  + " MB");
//                    System.out.println("------------------------------------------------");
                }
                processList.add(processStatus);
            }



//            String line;
//            Process p;
//            if (System.getProperty("os.name").toLowerCase().contains("win")) {
//                p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
//            } else {
//                p = Runtime.getRuntime().exec("ps -e");
//            }
//            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            for(String processName : processNameList)
//            {
//                ProcessStatus processStatus = new ProcessStatus();
//                processStatus.setId(Long.valueOf(processList.size() + 1));
//                processStatus.setProcessName(processName);
//                processStatus.setAlive(false);
//                while ((line = input.readLine()) != null)
//                {
//                    if (line.contains(processName))
//                    {
//                        processStatus.setProcessName(line.split("\\s+")[0]);
//                        processStatus.setAlive(true);;
//
//                        break;
//                    }
//                }
//                processList.add(processStatus);
//            }
//
//            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return processList;
    }
}
