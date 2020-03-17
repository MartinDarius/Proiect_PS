package com.example.sd2020.demo;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    private List<Integer> sampleList;
    ClientService clientService=new ClientService();

    public SampleController() {
        sampleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sampleList.add(i);
        }
    }

    @GetMapping("/") // localhost:8080/
    public String getHelloWorld() {
        return "Hello SD 2020";
    }

    @GetMapping("/allList") // localhost:8080/allList
    public List<Integer> getAllList() {
        return sampleList;
    }

    @PostMapping("/insertItem")
    public void insertItem(Integer item) {
        sampleList.add(item);
    }

    @RequestMapping(value={"/{findClientById}"},method= RequestMethod.GET)
    public Client findClientById(@PathVariable String findClientById, @RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return clientService.findById(sId);
    }
    @RequestMapping(value={"/{insertClient}"},method=RequestMethod.POST)
    public String insertClientRequest(@PathVariable String insertClient,@RequestBody Client client) throws ParseException{
        clientService.insertClient(new Client(client.getNume(),client.getEmail(),client.getEchipament(),client.getTip()));
       return "Inserted successfuly";
    }
}
