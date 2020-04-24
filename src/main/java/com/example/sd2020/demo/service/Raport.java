package com.example.sd2020.demo.service;

import com.example.sd2020.demo.entity.Echipament;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface Raport {

    public void generareRaport(ArrayList<Echipament> lista) throws IOException;
}
