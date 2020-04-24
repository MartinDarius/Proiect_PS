package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RaportHtml implements Raport {

    @Override
    public void generareRaport(ArrayList<Echipament> lista) throws IOException {
        String path="Raport HTML";
        File myObj = new File(path);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
        FileWriter myWriter = new FileWriter(path);
        Client client=lista.get(0).getClient();
        myWriter.write("Clientul cu numele:"+client.getNume()+" a inchiriat urmatoarele echipamente: ");
        for(Echipament e: lista){
            myWriter.write(e.getNume()+", ");
        }
        myWriter.close();
    }
}
