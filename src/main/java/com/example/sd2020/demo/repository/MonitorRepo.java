package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.SkiMonitor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MonitorRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proiectPS");

    public void insert(SkiMonitor monitor) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(monitor);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
    public SkiMonitor findById(String sId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int id=Integer.parseInt(sId);
        SkiMonitor monitor = entityManager.find(SkiMonitor.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return monitor;
    }
    public ArrayList<SkiMonitor> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT p FROM SkiMonitor p");
        entityManager.getTransaction().commit();
        // entityManager.close();

        return (ArrayList<SkiMonitor>) query.getResultList();
    }

    public void delete(SkiMonitor monitor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.contains(monitor) ? monitor : entityManager.merge(monitor));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<SkiMonitor> findByEmail(String email){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT cl FROM SkiMonitor cl WHERE cl.email=?1");
        //Client client = entityManager.find(Client.class, email);
        query.setParameter(1,email);
        List<SkiMonitor> lista=query.getResultList();
        //entityManager.getTransaction().commit();
        entityManager.close();

        return lista;
    }

}
