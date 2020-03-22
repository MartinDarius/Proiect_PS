package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.repository.MonitorRepo;

import java.util.ArrayList;

public class MonitorService {
    MonitorRepo repo=new MonitorRepo();

    /**
     * insereaza un skiMonitor in baza de date
     * @param monitor monitorul care trebuie inserat
     */
    public void insertMonitor(SkiMonitor monitor){
        repo.insert(monitor);
    }

    /**
     * cauta un Monitor in baza de date
     * @param id id ul Monitorului de cautat
     * @return Monitorul din baza de date
     */
    public SkiMonitor findById(String id){
        SkiMonitor monitor=repo.findById(id);
        return monitor;
    }

    /**
     *
     * @return o lista cu toti Monitorii din baza de date
     */
    public ArrayList<SkiMonitor> findAll(){
        ArrayList<SkiMonitor> list=repo.findAll();
        return list;
    }

    /**
     * sterge un monitor din baza de date
     * @param id id ul monitorului de sters
     * @return true daca s-a efectuat stergerea, false daca nu
     */
    public boolean stergeMonitor(Long id){
        String sId=id.toString();
        SkiMonitor monitor=repo.findById(sId);
        if(monitor==null){
            return false;
        }
        repo.delete(monitor);
        return true;
    }
}
