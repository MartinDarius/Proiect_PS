package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.entity.Admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proiectPS");

    public void insert(Admin admin) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(admin);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
