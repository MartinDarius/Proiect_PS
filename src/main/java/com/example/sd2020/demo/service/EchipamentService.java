package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.repository.EchipamentRepo;

public class EchipamentService {
    EchipamentRepo repo=new EchipamentRepo();

    public void insert(Echipament echipament){
        repo.insert(echipament);
    }

    public Echipament findById(String id){
        Echipament echip=repo.findById(id);
        return echip;
    }
}
