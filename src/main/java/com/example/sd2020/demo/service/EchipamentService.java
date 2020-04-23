package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.repository.EchipamentRepo;

import java.util.ArrayList;
import java.util.List;

public class EchipamentService {
    EchipamentRepo repo=new EchipamentRepo();
    ClientRepo clientRepo=new ClientRepo();
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

    /**
     *
     * @param idClient id ul clientului care o sa inchirieze echipamentul
     * @param idEchip id ul echipamentului care o sa fie inchiriat
     */
    public boolean inchiriazaEchipament(Long idClient,Long idEchip){
        String sId=idEchip.toString();
        String cId=idClient.toString();
        boolean ok=false;
        Echipament echip=repo.findById(sId);
        Client client=clientRepo.findById(cId);
        if(echip.getClient()==null) {
            repo.inchiriazaEchip(client, echip);
            this.news = "Echipamentul cu id-ul:" + sId + " a fost inchiriat de catre clientul cu numele " + client.getNume();
            for (Observator obs : this.observatori) {
                obs.update(this.news);
            }
            ok=true;
        }
        return ok;
    }

    /**
     *
     * @param idClient id ul clientului care restituie echipamentul
     * @param idEchip id ul echipamentului care va fi restituit
     */
    public void restituieEchipament(Long idClient,Long idEchip){
        String eId=idEchip.toString();
        String cId=idClient.toString();
        Echipament echip=repo.findById(eId);
        Client client=clientRepo.findById(cId);
        if(echip.getClient().getId()==client.getId()){
            repo.restituieEchip(echip);
        }

    }


    public ArrayList<Echipament> echipamenteDisponibile(){
        ArrayList<Echipament> lista1=repo.findAll();
        ArrayList<Echipament> listaFinala=new ArrayList<Echipament>();
        for(Echipament e : lista1){
            if(e.getClient()==null)
                listaFinala.add(e);
        }
        return listaFinala;
    }

}
