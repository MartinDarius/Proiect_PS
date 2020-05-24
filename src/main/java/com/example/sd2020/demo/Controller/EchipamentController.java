package com.example.sd2020.demo.Controller;

import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.service.EchipamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
public class EchipamentController {
    EchipamentService echipamentService=new EchipamentService();

    @CrossOrigin(origins="*")
    @GetMapping("/allEchipaments")
    public ArrayList<Echipament> getAllEchipaments(){
        return echipamentService.findAll();
    }

    @CrossOrigin(origins="*")
    @GetMapping("/EchipamenteDisponibile")
    public ArrayList<Echipament> echipamenteDisponibile(){
        return echipamentService.echipamenteDisponibile();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/findEchipament"},method= RequestMethod.GET)
    public Echipament findEchipamentById(@RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return echipamentService.findById(sId);
    }


    @CrossOrigin(origins="*")
    @RequestMapping(value={"/insertEchipament"},method=RequestMethod.POST)
    public String insertEchipamentRequest(@RequestBody Echipament echipament) throws ParseException{
        echipamentService.insert(new Echipament(echipament.getNume(),echipament.getTip(),echipament.getStare()));
        return "Inserted successfuly";
    }

    /*
    @DeleteMapping(value="/deleteEchipament/{id}")
    public ResponseEntity<Long> deleteEchipament(@PathVariable Long id){
        boolean isRemoved=echipamentService.stergeEchipament(id);
        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

     */

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/deleteEchipament"},method=RequestMethod.POST)
    public String deleteEchipament(@RequestParam (value="id") String id){
        long Id=Long.parseLong(id);
        boolean isRemoved=echipamentService.stergeEchipament(Id);
        if(!isRemoved){
            return "Nu s-a putut sterge echipamentul!";
        }
        return "Echipamentul a fost sters din baza de date!";
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/inchiriazaEchipament"},method=RequestMethod.POST)
    public String inchiriazaEchipament(@RequestParam(value="idClient")String idClient,@RequestParam(value="idEchip")String idEchip){
        long cId=Long.parseLong(idClient);
        long eId=Long.parseLong(idEchip);
        boolean ok;
        ok=echipamentService.inchiriazaEchipament(cId,eId);
        if(ok)
        return "S-a inchiriat echipamentul!";
        else
        return "Echipamentul este deja inchiriat!";
    }
    @CrossOrigin(origins="*")
    @RequestMapping(value={"/restituieEchipament"},method=RequestMethod.POST)
    public String restituieEchipament(@RequestParam(value="idClient")String idClient,@RequestParam(value="idEchip")String idEchip){
        long cId=Long.parseLong(idClient);
        long eId=Long.parseLong(idEchip);
        echipamentService.restituieEchipament(cId,eId);
        return "S-a restituit echipamentul!";
    }


}
