package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.repository.EchipamentRepo;
import com.example.sd2020.demo.repository.MonitorRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    ClientRepo repo=new ClientRepo();
    EchipamentRepo repoEchip=new EchipamentRepo();
    MonitorRepo repoMonitor=new MonitorRepo();

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
      if(lista.size()>0)
        return lista.get(0);
      else
          return null;
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



    /**
     *
     * @param idClient id ul clientului care o sa angajeze un instructor
     * @param idMonitor id ul instructorului care o sa fie angajat
     */
    public void angajeazaMonitor(Long idClient,Long idMonitor){
        String mId=idMonitor.toString();
        String cId=idClient.toString();
        SkiMonitor m=repoMonitor.findById(mId);
        Client c=repo.findById(cId);
        repo.angajeazaMonitor(c,m);
    }



    /**
     *
     * @param idClient id ul clientului care concediaza monitorul
     * @param idMonitor id ul monitorului care este concediat
     */
    public void concediazaMonitor(Long idClient,Long idMonitor){
        String mId=idMonitor.toString();
        String cId=idClient.toString();
        Client client=repo.findById(cId);
        SkiMonitor monitor=repoMonitor.findById(mId);
        if(client.getSkiMonitor().getId()==monitor.getId()){
            repo.concediazaMonitor(client);
        }
    }


    public ArrayList<Echipament> echipamenteleClientului(Long idClient){
        String cId=idClient.toString();
        Client client=repo.findById(cId);
        ArrayList<Echipament> list1=repoEchip.findAll();
        ArrayList<Echipament> list2=new ArrayList<Echipament>();
        for(Echipament e: list1){
            if(e.getClient()!=null) {
                if (e.getClient().getId() == client.getId()) {
                    list2.add(e);
                }
            }
        }
        return list2;
    }

}
