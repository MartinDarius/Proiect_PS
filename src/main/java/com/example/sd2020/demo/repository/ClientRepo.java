package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClientRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proiectPS");

    public void insert(Client client) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(client);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public Client findById(String sId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int id=Integer.parseInt(sId);
        Client client = entityManager.find(Client.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return client;
    }

    public List<Client> findByEmail(String email){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT cl FROM Client cl WHERE cl.email=?1");
        //Client client = entityManager.find(Client.class, email);
        query.setParameter(1,email);
        List<Client> lista=query.getResultList();
        //entityManager.getTransaction().commit();
        entityManager.close();

        return lista;
    }

    public ArrayList<Client> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT p FROM Client p");
        entityManager.getTransaction().commit();
       // entityManager.close();

        return (ArrayList<Client>) query.getResultList();
    }

    public int NrOfClients(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT p FROM Client p");
        entityManager.getTransaction().commit();
        // entityManager.close();
        ArrayList<Client>list=(ArrayList<Client>) query.getResultList();
        return list.size();
    }


    public void delete(Client client) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.contains(client) ? client : entityManager.merge(client));

        entityManager.getTransaction().commit();
        entityManager.close();
    }



    public void updateEchipament(Client e, boolean val){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        e.updateEchipament(val);

        entityManager.merge(e);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


}