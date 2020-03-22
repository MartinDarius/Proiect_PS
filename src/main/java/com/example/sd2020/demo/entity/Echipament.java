package com.example.sd2020.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Echipament {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String tip;
    private String nume;
    private boolean stare;

    public Echipament(String nume,String tip,boolean stare){
        this.nume=nume;
        this.tip=tip;
        this.stare=stare;
    }
    public Echipament(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean getStare(){return this.stare;}

    public void setStare(boolean val){this.stare=val;}

}
