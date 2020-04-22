package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class EchipamentRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proiectPS");

    public void insert(Echipament echipament) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(echipament);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
    public Echipament findById(String sId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int id=Integer.parseInt(sId);
        Echipament echipament = entityManager.find(Echipament.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return echipament;
    }
    public ArrayList<Echipament> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT p FROM Echipament p");
        entityManager.getTransaction().commit();
        // entityManager.close();

        return (ArrayList<Echipament>) query.getResultList();
    }

    public void delete(Echipament echipament) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.contains(echipament) ? echipament : entityManager.merge(echipament));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateStare(Echipament t, boolean val){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        t.setStare(val);

        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void inchiriazaEchip(Client e, Echipament echip){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        echip.setClient(e);
        echip.setStare(true);

        entityManager.merge(echip);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void restituieEchip(Echipament echip){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        echip.setClient(null);
        echip.setStare(false);

        entityManager.merge(echip);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
