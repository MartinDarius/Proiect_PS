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

    @GetMapping("/allMonitors")
    public ArrayList<SkiMonitor> getAllMonitors(){
        return monitorService.findAll();
    }

    @RequestMapping(value={"/{findMonitorById}"},method= RequestMethod.GET)
    public SkiMonitor findMonitorById(@PathVariable String findMonitorById, @RequestBody int id) throws ParseException {
        String sId=Integer.toString(id);
        System.out.println(sId);
        return monitorService.findById(sId);
    }

    /*
    @RequestMapping(value={"/{insertMonitor}"},method=RequestMethod.POST)
    public String insertMonitorRequest(@PathVariable String insertMonitor,@RequestBody SkiMonitor monitor) throws ParseException{
        monitorService.insertMonitor(new SkiMonitor(monitor.getNume(),monitor.getEmail(),monitor.getEchipament(),monitor.getDisponibilitate(),monitor.getTip()));
        return "Inserted successfuly";
    }
    */

    @DeleteMapping(value="/deleteMonitor/{id}")
    public ResponseEntity<Long> deleteMonitor(@PathVariable Long id){
        boolean isRemoved=monitorService.stergeMonitor(id);
        if(!isRemoved){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
