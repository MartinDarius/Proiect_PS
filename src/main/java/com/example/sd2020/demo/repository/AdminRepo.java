package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.entity.Admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class AdminRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proiectPS");

    public void insert(Admin admin) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(admin);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
    public Admin findById(String sId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int id=Integer.parseInt(sId);
        Admin admin = entityManager.find(Admin.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return admin;
    }
    public ArrayList<Admin> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("SELECT p FROM Admin p");
        entityManager.getTransaction().commit();
        // entityManager.close();

        return (ArrayList<Admin>) query.getResultList();
    }

    public void delete(Admin admin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.contains(admin) ? admin : entityManager.merge(admin));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
