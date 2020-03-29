package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.repository.EchipamentRepo;

import java.util.ArrayList;
import java.util.List;

public class EchipamentService {
    EchipamentRepo repo=new EchipamentRepo();
    private String news;
    private List<Observator> observatori=new ArrayList<>();

    public void addObserver(Observator channel) {
        this.observatori.add(channel);
    }

    public void removeObserver(Observator channel) {
        this.observatori.remove(channel);
    }


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

    public void setInchiriat(String id){

        Echipament echip=repo.findById(id);
        repo.updateStare(echip,true);
        this.news="Echipamentul cu id-ul:"+id+" a fost inchiriat.";
        for(Observator obs: this.observatori){
            obs.update(this.news);
        }

    }

}
