package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.repository.AdminRepo;

public class AdminService {
    AdminRepo repo=new AdminRepo();

    /**
     * adauga un admin in baza de date
     */
    public void addAdmin(){
        Admin admin = new Admin();
        admin.setName("Darius");
        admin.setEmail("Darius@admin.com");
        repo.insert(admin);
    }
}
