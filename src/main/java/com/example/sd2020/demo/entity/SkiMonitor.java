package com.example.sd2020.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Instructori")

public class SkiMonitor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_monitor;

    private String nume;
    private String email;
    private String password;
    private boolean disponibilitate;




    public SkiMonitor(String nume,String email,String password,boolean disponibilitate){
        this.nume=nume;
        this.email=email;
        this.password=password;
        this.disponibilitate=disponibilitate;
    }




    public SkiMonitor() {

    }

    public Integer getId() {
        return id_monitor;
    }

    public void setId(Integer id) {
        this.id_monitor = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return this.nume+" "+this.email;
    }


}
