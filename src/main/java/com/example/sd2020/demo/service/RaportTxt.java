package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class RaportTxt implements Raport {

    @Override
    public void generareRaport(ArrayList<Echipament> lista) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("Raport.txt", "UTF-8");
        Client client=lista.get(0).getClient();
        writer.println("Clientul cu numele: "+client.getNume()+" are inchiriate urmatoarele echipamente:");
        for(Echipament e: lista){
            writer.println(e.getNume());
        }
        writer.close();
    }
}
