package com.example.sd2020.demo.Controller;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.service.AdminService;
import com.example.sd2020.demo.service.ClientService;
import com.example.sd2020.demo.service.MonitorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginRestController {

    @CrossOrigin(origins="*")
    @GetMapping("/login")
    public String login(@RequestParam(value="email") String email,@RequestParam(value="passwordd")String password){

        AdminService adminServ = new AdminService();
        Admin admin = new Admin();

        ClientService clientServ = new ClientService();
        Client client= new Client();

        MonitorService monitorServ=new MonitorService();
        SkiMonitor monitor=new SkiMonitor();

        admin = adminServ.findByEmail(email);
        client= clientServ.findByEmail(email);
        monitor= monitorServ.findByEmail(email);


        int wrong = 0;

        if(email.equals("")) {
            return "Introduceti email!";
        }

        if(password.equals("")) {
            return "Introduceti parola!";
        }

        if(admin == null && client == null && monitor==null){
            wrong++;
            //JOptionPane.showMessageDialog(null,"Wrong username or password. Try again");
            return "Adresa de email nu este valida!";
        }

        if(wrong == 0){
            if(admin != null && email.equals(admin.getEmail())) {
                if(password.equals(admin.getPassword())) {
                    return "SUCCESS! V-ati logat drept Admin!";

                }
                else {
                    wrong++;
                }
            }
            else if(client != null){
                if(email.equals(client.getEmail())){
                    if(password.equals(client.getPassword())) {
                        return "SUCCESS! V-ati logat drept client!";

                    }else{
                        wrong++;
                    }
                }
                else {
                    wrong++;
                }
            }else if(monitor != null){
                if(email.equals(monitor.getEmail())){
                    if(password.equals(monitor.getPassword())) {
                        return "SUCCESS! V-ati logat drept instructor!";

                    }else{
                        wrong++;
                    }
                }
                else {
                    wrong++;
                }
            }
        }

            return "Datele introduse sunt incorecte! Va rugam mai incercati!";
    }



}
