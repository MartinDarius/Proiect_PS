package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
//    public List<Client> findAll() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        List<Client> clienti =
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        return client;
//    }

}