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
}
