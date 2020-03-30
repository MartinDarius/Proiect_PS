package com.example.sd2020.demo.Controller;

import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
public class ClientController {

    ClientService clientService=new ClientService();

    /**
     * Afiseaza toti clientii din BD
     * @return lista cu clientii
     */
    @GetMapping("/allClients")
    public ArrayList<Client> getAllClients(){
        return clientService.findAll();
    }

    /**
     * Afiseaza clientul cu un id specific
     * @param findClientById este string ul pe care il scriem dupa localhost8080
     * @param id id ul care este cautat in bd
     * @return clientul cautat
     * @throws ParseException
     */

    @RequestMapping(value={"/{findClientById}"},method= RequestMethod.GET)
    public Client findClientById(@PathVariable String findClientById, @RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return clientService.findById(sId);
    }
    /*
    @RequestMapping(value={"/{findClientByEmail}"},method= RequestMethod.GET)
    public Client findClientByEmail(@PathVariable String findClientByEmail, @RequestBody String email) throws ParseException {
        return clientService.findByEmail(email);
    }
    */


    /**
     * insereaza un client in BD
     * @param insertClient Stringul care este scris dupa localhost
     * @param client clientul care trebuie inserat
     * @return un mesaj in caz de succes sau esec
     * @throws ParseException
     */
    @RequestMapping(value={"/{insertClient}"},method=RequestMethod.POST)
    public String insertClientRequest(@PathVariable String insertClient,@RequestBody Client client) throws ParseException{
        int inainte=clientService.NrOfClients();
        clientService.insertClient(new Client(client.getNume(),client.getEmail(),client.getEchipament(),client.getTip(),client.getMonitor()));
        int dupa=clientService.NrOfClients();
        if(inainte==dupa){
            return "This client was not inserted in BD!";
        }
        return "Inserted successfuly";
    }

    /**
     * Sterge un client din BD
     * @param id clientul cu id ul respectiv va fi sters
     * @return daca s-a facut stergerea sau nu
     */
    @DeleteMapping(value="/deleteClient/{id}")
    public ResponseEntity<Long> deleteClient(@PathVariable Long id){
        boolean isRemoved=clientService.stergeClient(id);
        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
