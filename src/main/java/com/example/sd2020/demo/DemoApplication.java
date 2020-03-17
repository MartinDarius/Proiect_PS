package com.example.sd2020.demo;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.service.AdminService;
import com.example.sd2020.demo.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		AdminService ad=new AdminService();
		ad.addAdmin();
		ClientService clientServ=new ClientService();
       // Client primul=new Client("Ioan","Ioan@yahoo.com",true,"incepator");
        //clientServ.insertClient(primul);
		Client x=clientServ.findById("4");
		System.out.println(x.toString());
	}

}
