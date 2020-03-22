package com.example.sd2020.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkiMonitor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nume;
    private String email;
    private boolean echipament;
    private boolean disponibilitate;
    private String tip;

    public SkiMonitor(String nume,String email,boolean echipament,boolean disponibilitate,String tip){
        this.nume=nume;
        this.email=email;
        this.echipament=echipament;
        this.disponibilitate=disponibilitate;
        this.tip=tip;
    }

    public SkiMonitor() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean getEchipament() {
        return echipament;
    }

    public void setEchipamnet(boolean echipament) {
        this.echipament = echipament;
    }

    public boolean getDisponibilitate() {
        return disponibilitate;
    }

    public void setTip(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }


    public String toString(){
        return this.nume+" "+this.email;
    }


}
