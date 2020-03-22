package com.example.sd2020.demo.arch;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.entity.SkiMonitor;

import java.util.List;

public class FacadeSample {

    private SampleOperations sampleOperations;

    public FacadeSample(SampleOperations sampleOperations) {
        this.sampleOperations = sampleOperations;
    }

    public List<Integer> retrieveList() {
        return sampleOperations.getList();
    }

    public Client findClient(String id){return sampleOperations.FindClientById(id);}

    public Echipament findEchipament(String id){return sampleOperations.FindEchipamentById(id);}

    public SkiMonitor findMonitor(String id){return sampleOperations.FindMonitorById(id);}
}
