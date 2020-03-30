package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.repository.ClientRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    ClientRepo repo=new ClientRepo();

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
      Client client=repo.findByEmail(email);
      return client;
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
}
