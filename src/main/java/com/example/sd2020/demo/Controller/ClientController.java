package com.example.sd2020.demo.Controller;


import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.service.ClientService;
import com.example.sd2020.demo.service.Raport;
import com.example.sd2020.demo.service.RaportFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value= "/findClient",method= RequestMethod.GET)
    public Client findClientById(@RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return clientService.findById(sId);

    }

    /**
     *
     * @param email emailul care se cauta in BD
     * @return primul client gasit cu emailul respectiv
     * @throws ParseException
     */
    @RequestMapping(value={"/findClientByEmail"},method= RequestMethod.GET)
    public Client findClientByEmail( @RequestBody String email) throws ParseException {
        return clientService.findByEmail(email);
    }



    /**
     * insereaza un client in BD
     * @param insertClient Stringul care este scris dupa localhost
     * @param client clientul care trebuie inserat
     * @return un mesaj in caz de succes sau esec
     * @throws ParseException
     */
    @RequestMapping(value={"/insertClient"},method=RequestMethod.POST)
    public String insertClientRequest(@RequestBody Client client) throws ParseException{
        int inainte=clientService.NrOfClients();
        clientService.insertClient(new Client(client.getNume(),client.getEmail(),client.getPassword(),client.getTip()));
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

    @RequestMapping(value={"/angajeazaInstructor"},method=RequestMethod.POST)
    public String angajeazaInstructor(@RequestParam(value="idClient")String idClient,@RequestParam(value="idMonitor")String idMonitor){
        long cId=Long.parseLong(idClient);
        long mId=Long.parseLong(idMonitor);
        clientService.angajeazaMonitor(cId,mId);
        return "Instructorul a fost angajat!";
    }

    @RequestMapping(value={"/concediazaInstructor"},method=RequestMethod.POST)
    public String concediazaInstructor(@RequestParam(value="idClient")String idClient,@RequestParam(value="idMonitor")String idMonitor){
        long cId=Long.parseLong(idClient);
        long mId=Long.parseLong(idMonitor);
        clientService.concediazaMonitor(cId,mId);
        return "Instructorul a fost concediat!";
    }


    @RequestMapping(value= "/echipamenteleClientului",method= RequestMethod.GET)
    public ArrayList<Echipament> echipamenteleClientului(@RequestBody long id) throws ParseException {
        ArrayList<Echipament> lista=clientService.echipamenteleClientului(id);
        return lista;

    }

    @RequestMapping(value={"/genereazaRaport"},method=RequestMethod.POST)
    public String genereazaRaport(@RequestParam(value="idClient")String idClient,@RequestParam(value="extensie")String extensie) throws IOException {
        long cId=Long.parseLong(idClient);
        ArrayList<Echipament>lista=clientService.echipamenteleClientului(cId);
        RaportFactory fact=new RaportFactory();
        Raport raport=fact.createRaport(extensie);
        raport.generareRaport(lista);
        return "Raportul a fost generat!";
    }


}
