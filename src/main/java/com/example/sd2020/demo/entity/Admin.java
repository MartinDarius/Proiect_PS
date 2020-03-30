package com.example.sd2020.demo.entity;

import com.example.sd2020.demo.service.Observator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Admin implements Observator {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String password;
    private String email;
    private String news;

    public void setNews(String news){
        this.news=news;
    }

    public String getNews(){
        return this.news;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //metoda care se suprascrie
    @Override
    public void update(Object news) {
        this.setNews((String) news);
        System.out.println(news);
    }
}
