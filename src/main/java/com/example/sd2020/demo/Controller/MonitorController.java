package com.example.sd2020.demo.Controller;

import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.entity.SkiMonitor;
import com.example.sd2020.demo.service.EchipamentService;
import com.example.sd2020.demo.service.MonitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
@RestController
public class MonitorController {
    MonitorService monitorService=new MonitorService();

    @CrossOrigin(origins="*")
    @GetMapping("/allMonitors")
    public ArrayList<SkiMonitor> getAllMonitors(){
        return monitorService.findAll();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/findMonitor"},method= RequestMethod.GET)
    public SkiMonitor findMonitorById( @RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return monitorService.findById(sId);
    }


    @CrossOrigin(origins="*")
    @RequestMapping(value={"/insertMonitor"},method=RequestMethod.POST)
    public String insertMonitorRequest(@RequestBody SkiMonitor monitor) throws ParseException{
        monitorService.insertMonitor(new SkiMonitor(monitor.getNume(),monitor.getEmail(),monitor.getPassword(),monitor.getDisponibilitate()));
        return "Inserted successfuly";
    }

    /*
    @DeleteMapping(value="/deleteMonitor/{id}")
    public ResponseEntity<Long> deleteMonitor(@PathVariable Long id){
        boolean isRemoved=monitorService.stergeMonitor(id);
        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

     */

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/deleteMonitor"},method=RequestMethod.POST)
    public String deleteMonitor(@RequestParam (value="id") String id){
        long Id=Long.parseLong(id);
        boolean isRemoved=monitorService.stergeMonitor(Id);
        if(!isRemoved){
            return "Nu s-a putut sterge instructorul!";
        }
        return "Instructorul a fost sters din baza de date!";
    }
}
