package com.example.sd2020.demo.Controller;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.repository.AdminRepo;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.service.AdminService;
import com.example.sd2020.demo.service.ClientService;
import com.example.sd2020.demo.service.MonitorService;

import javax.swing.*;

public class LoginController {


    public void login(String numeIntrodus, String parolaIntrodusa) {

        AdminService adminServ = new AdminService();
        Admin admin = new Admin();

        ClientService clientServ = new ClientService();
        Client client= new Client();

        MonitorService monitorServ=new MonitorService();
        SkiMonitor monitor=new SkiMonitor();

        admin = adminServ.findByEmail(numeIntrodus);
        client= clientServ.findByEmail(numeIntrodus);
        monitor= monitorServ.findByEmail(numeIntrodus);

        int wrong = 0;

        if(numeIntrodus.equals("")) {
            //JOptionPane.showMessageDialog(null,"Please insert an username !");
            return;
        }

        if(parolaIntrodusa.equals("")) {
            //JOptionPane.showMessageDialog(null,"Please insert a password !");
            return;
        }

        if(admin == null && client == null && monitor==null){
            wrong++;
            //JOptionPane.showMessageDialog(null,"Wrong username or password. Try again");
            System.out.println("Teapta!");
        }

        if(wrong == 0){
            if(admin != null && numeIntrodus.equals(admin.getEmail())) {
                if(parolaIntrodusa.equals(admin.getPassword())) {
                    System.out.println("SUCCESS ! ");
                    //GUIAdmin adminGUI= new GUIAdmin();

                }
                else {
                    wrong++;
                }
            }
            else if(client != null){
                if(numeIntrodus.equals(client.getEmail())){
                    if(parolaIntrodusa.equals(client.getPassword())) {
                        System.out.println("SUCCESS ! ");
                        //GUIAngajat guiAngajat = new GUIAngajat(angajat.getEmailAngajat());

                    }else{
                        wrong++;
                    }
                }
                else {
                    wrong++;
                }
            }else if(monitor != null){
                if(numeIntrodus.equals(monitor.getEmail())){
                    if(parolaIntrodusa.equals(monitor.getPassword())) {
                        System.out.println("SUCCESS ! ");
                        //GUIMonitor guiMonitor = new GUIMonitor(monitor.getEmailAngajat());
                    }else{
                        wrong++;
                    }
                }
                else {
                    wrong++;
                }
            }
        }

        if(wrong > 0) {
            //JOptionPane.showMessageDialog(null,"Wrong username or password. Try again");
            System.out.println("Teapa!");
        }
    }
}
