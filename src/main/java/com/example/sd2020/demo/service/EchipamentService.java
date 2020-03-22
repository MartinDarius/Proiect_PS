package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.repository.EchipamentRepo;

import java.util.ArrayList;

public class EchipamentService {
    EchipamentRepo repo=new EchipamentRepo();

    /**
     * insereaza un echipament in baza de date
     * @param echipament
     */
    public void insert(Echipament echipament){
        repo.insert(echipament);
    }

    /**
     * cauta un echipament in baza de date
     * @param id id ul echipamentului cautat
     * @return echipamentul cautat
     */
    public Echipament findById(String id){
        Echipament echip=repo.findById(id);
        return echip;
    }

    /**
     *
     * @return o lista cu toate echipamentele din baza de date
     */
    public ArrayList<Echipament> findAll(){
        return repo.findAll();
    }

    /**
     * sterge un echipament din baza de date
     * @param id id ul echipamentului de sters
     * @return true daca s-a efectuat stergerea si false daca nu s-a putut efectua
     */
    public boolean stergeEchipament(Long id){
        String sId=id.toString();
        Echipament echip=repo.findById(sId);
        if(echip==null){
            return false;
        }
        repo.delete(echip);
        return true;
    }

}
