package com.example.sd2020.demo;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.repository.ClientRepo;
import com.example.sd2020.demo.service.AdminService;
import com.example.sd2020.demo.service.ClientService;
import com.example.sd2020.demo.service.EchipamentService;
import com.example.sd2020.demo.service.MonitorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		AdminService ad=new AdminService();

		EchipamentService echipService=new EchipamentService();
		ClientService clientServ=new ClientService();
		MonitorService monitorService= new MonitorService();

		//clientServ.inchiriazaEchipament(4L,3L);

		//ad.addAdmin();

		Echipament primulEchipament=new Echipament("Head","ski",false);
		Echipament alDoileaEchipament=new Echipament("Ficher","ski",false);


        Client primul=new Client("Mihai","Ioan@yahoo.com","pass",false,"incepator",false);

		 //clientServ.insertClient(primul);
         //echipService.insert(primulEchipament);
       //  echipService.insert(alDoileaEchipament);

         clientServ.inchiriazaEchipament(Long.valueOf(43),Long.valueOf(44));



	}

}
