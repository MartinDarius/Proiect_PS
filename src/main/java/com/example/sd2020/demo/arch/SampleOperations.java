package com.example.sd2020.demo.arch;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.entity.SkiMonitor;

import java.util.List;

public interface SampleOperations {

    List<Integer> getList();

    Client FindClientById(String id);

    Echipament FindEchipamentById(String id);

    SkiMonitor FindMonitorById(String id);
}
