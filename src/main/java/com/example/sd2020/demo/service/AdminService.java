package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.repository.AdminRepo;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.repository.MonitorRepo;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    AdminRepo repoAdmin=new AdminRepo();
    MonitorRepo repoMonitor=new MonitorRepo();
    ClientRepo repoClient=new ClientRepo();
    /**
     * adauga un admin in baza de date
     */
    public void addAdmin(){
        Admin admin = new Admin();
        admin.setName("Darius");
        admin.setEmail("Darius@admin.com");
        repoAdmin.insert(admin);
    }

    /**
     * Insereaza un client in baza de date
     * @param client clientul care este inserat
     */
    public void insertClient(Client client){
        repoClient.insert(client);
    }


    /**
     * sterge un client din baza de date
     * @param sid acest id este id ul clientului care urmeaza a fi sters
     * @return true daca s-a gasit si sters clientul, false in caz contrar
     */
    public boolean stergeClient(Long sid){
        String id= sid.toString();
        Client client=repoClient.findById(id);
        if(client==null)
            return false;
        int inainte=repoClient.NrOfClients();
        repoClient.delete(client);
        int dupa=repoClient.NrOfClients();
        if(inainte!=dupa)
            return true;
        return false;
    }

    /**
     *
     * @return returneaza o lista cu toti clientii de baza de date
     */
    public ArrayList<Client> findAll(){
        ArrayList<Client> list=repoClient.findAll();
        return list;
    }

    public Admin findByEmail(String email) {
        List<Admin> lista=repoAdmin.findByEmail(email);
        if(lista.size()>0)
            return lista.get(0);
        else
           return null;
    }

}
