package com.example.sd2020.demo.entity;

import com.example.sd2020.demo.service.ClientService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_client;

    private String nume;
    private String email;
    private String password;
  //  private boolean echipament;
    private String tip;
   // private boolean monitor;

    //@OneToMany(mappedBy = "client", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    //private List<Echipament> echipamente;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "id_monitor")
    private SkiMonitor skiMonitor;




    public Client(String nume,String email,String password,String tip){
        this.nume=nume;
        this.password=password;
        this.email=email;
        this.tip=tip;
    }

    public Client() {

    }


    public Integer getId() {
        return id_client;
    }

    public void setId(Integer id) {
        this.id_client = id;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SkiMonitor getSkiMonitor() {
        return skiMonitor;
    }

    public void setSkiMonitor(SkiMonitor skiMonitor) {
        this.skiMonitor = skiMonitor;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tip='" + tip + '\'' +
                ", skiMonitor=" + skiMonitor +
                '}';
    }
}
