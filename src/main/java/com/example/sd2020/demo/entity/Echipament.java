package com.example.sd2020.demo.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Echipament {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String tip;
    private String nume;
    private boolean stare;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;


    public Echipament(String nume,String tip,boolean stare){
        this.nume=nume;
        this.tip=tip;
        this.stare=stare;
    }
    public Echipament(String nume,String tip,boolean stare,Client client){
        this.nume=nume;
        this.tip=tip;
        this.stare=stare;
        this.client=client;
    }


    public Echipament(){

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
