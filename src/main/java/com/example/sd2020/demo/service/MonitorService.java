package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.repository.MonitorRepo;

import java.util.ArrayList;

public class MonitorService {
    MonitorRepo repo=new MonitorRepo();

    public void insertMonitor(SkiMonitor monitor){
        repo.insert(monitor);
    }
    public SkiMonitor findById(String id){
        SkiMonitor monitor=repo.findById(id);
        return monitor;
    }
    public ArrayList<SkiMonitor> findAll(){
        ArrayList<SkiMonitor> list=repo.findAll();
        return list;
    }
}
