package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.repository.ClientRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    ClientRepo repo=new ClientRepo();
    public void insertClient(Client client){
        repo.insert(client);
    }
    public Client findById(String id){
        Client client=repo.findById(id);
        return client;
    }
    public ArrayList<Client> findAll(){
        ArrayList<Client> list=repo.findAll();
        return list;
    }

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
}
