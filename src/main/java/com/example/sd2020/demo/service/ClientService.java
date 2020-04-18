package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.repository.EchipamentRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    ClientRepo repo=new ClientRepo();
    EchipamentRepo repoEchip=new EchipamentRepo();

    /**
     * Insereaza un client in baza de date
     * @param client clientul care este inserat
     */
    public void insertClient(Client client){
        repo.insert(client);
    }

    /**
     * gaseste clientul cu id ul respectiv
     * @param id Id ul care este cautat in baza de date
     * @return clientul cu id ul respectiv
     */
    public Client findById(String id){
        Client client=repo.findById(id);
        return client;
    }

    public Client findByEmail(String email) {
      List<Client> lista=repo.findByEmail(email);
      return lista.get(0);
    }

    /**
     *
     * @return returneaza o lista cu toti clientii de baza de date
     */
    public ArrayList<Client> findAll(){
        ArrayList<Client> list=repo.findAll();
        return list;
    }

    /**
     * sterge un client din baza de date
     * @param sid acest id este id ul clientului care urmeaza a fi sters
     * @return true daca s-a gasit si sters clientul, false in caz contrar
     */
    public boolean stergeClient(Long sid){
        String id= sid.toString();
        Client client=repo.findById(id);
        if(client==null)
            return false;
        int inainte=repo.NrOfClients();
        repo.delete(client);
        int dupa=repo.NrOfClients();
        if(inainte!=dupa)
            return true;
        return false;
    }

    /**
     *
     * @return numarul de clienti din BD
     */
    public int NrOfClients(){
        return repo.NrOfClients();
    }

    public void inchiriazaEchipament(Long idClient,Long idEchip){
        String sId=idEchip.toString();
        String cId=idClient.toString();
        Echipament echip=repoEchip.findById(sId);
        Client client=repo.findById(cId);
       // repo.inchiriazaEchip(client,true,echip);
        repoEchip.inchiriazaEchip(client,true,echip);

    }
}
