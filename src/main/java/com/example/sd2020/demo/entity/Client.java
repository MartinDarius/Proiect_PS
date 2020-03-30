package com.example.sd2020.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nume;
    private String email;
    private String password;
    private boolean echipament;
    private String tip;
    private boolean monitor;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Echipament> echipamente;

    public Client(String nume,String email,boolean echipament,String tip,boolean monitor){
        this.nume=nume;
        this.email=email;
        this.echipament=echipament;
        this.tip=tip;
        this.monitor=monitor;
    }

    public Client(String nume,String email,String password,boolean echipament,String tip,boolean monitor,List<Echipament> echipamente){
        this.nume=nume;
        this.password=password;
        this.email=email;
        this.echipament=echipament;
        this.tip=tip;
        this.monitor=monitor;
        this.echipamente=echipamente;
    }

    public Client() {
        this.echipamente=new ArrayList<Echipament>();

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

    public boolean getMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public String toString(){
        return this.nume+" "+this.email;
    }

    public void updateEchipament(boolean val){ this.echipament=val;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
