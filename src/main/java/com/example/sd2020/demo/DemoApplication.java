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
		ad.addAdmin();
		ClientService clientServ=new ClientService();
       // Client primul=new Client("Ioan","Ioan@yahoo.com",true,"incepator");
        //clientServ.insertClient(primul);
		Client x=clientServ.findById("18");
		//System.out.println(x.toString());
		ArrayList<Client> list=clientServ.findAll();
		//	System.out.println(list.toString());

		//Echipament primulEchipament=new Echipament("Head","ski",false);
		EchipamentService echipService=new EchipamentService();
		//echipService.insert(primulEchipament);

		//SkiMonitor primulMonitor=new SkiMonitor("Iancu","iancu@yahoo.com",true,false,"snowboard");
		//MonitorService monitorService=new MonitorService();
		//monitorService.insertMonitor(primulMonitor);

		Admin observer=new Admin();
		echipService.addObserver(observer);
		echipService.setInchiriat("33");

	}

}
