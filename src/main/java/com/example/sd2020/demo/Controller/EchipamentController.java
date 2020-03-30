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

    @GetMapping("/allEchipaments")
    public ArrayList<Echipament> getAllEchipaments(){
        return echipamentService.findAll();
    }
    /*
    @RequestMapping(value={"/{findEchipamentById}"},method= RequestMethod.GET)
    public Echipament findEchipamentById(@PathVariable String findEchipamentById, @RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return echipamentService.findById(sId);
    }

     */
    /*
    @RequestMapping(value={"/{insertEchipament}"},method=RequestMethod.POST)
    public String insertEchipamentRequest(@PathVariable String insertEchipament,@RequestBody Echipament echipament) throws ParseException{
        echipamentService.insert(new Echipament(echipament.getNume(),echipament.getTip(),echipament.getStare()));
        return "Inserted successfuly";
    }
    */
    @DeleteMapping(value="/deleteEchipament/{id}")
    public ResponseEntity<Long> deleteEchipament(@PathVariable Long id){
        boolean isRemoved=echipamentService.stergeEchipament(id);
        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
