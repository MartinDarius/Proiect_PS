package com.example.sd2020.demo;

import com.example.sd2020.demo.Controller.LoginController;
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

import javax.management.monitor.Monitor;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		AdminService ad=new AdminService();

		EchipamentService echipService=new EchipamentService();
		ClientService clientServ=new ClientService();
		MonitorService monitorService= new MonitorService();


		LoginController login=new LoginController();
		login.login("darius@yahoo.com","pass");
	}

}
