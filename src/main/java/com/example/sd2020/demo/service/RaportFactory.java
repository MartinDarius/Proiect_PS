package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Echipament;

import java.io.IOException;
import java.util.ArrayList;

public class RaportFactory {

    public Raport createRaport(String format) throws IOException {
        Raport raport=null;
        if(format.equals("txt")) {
            raport = new RaportTxt();
            //raport.generareRaport(lista);
        } else if(format.equals("html")){
            raport=new RaportHtml();
            //raport.generareRaport(lista);
        } else {
            System.out.println("Unknown raport type!");
        }
        return raport;
    }
}
