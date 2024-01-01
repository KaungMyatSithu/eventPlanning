package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.ServicesRequest;
import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.entity.Services;
import org.ace.eventplanning.service.ServicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/services")
public class ServicesController {
    private final ServicesService servicesService;

    @PostMapping
    public ResponseEntity<Services> save(@RequestBody ServicesRequest services){
        Services serviceResp = servicesService.register(services);
        return new ResponseEntity<>(serviceResp, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Services>> findAll(){
        List<Services> services = servicesService.findAll();
        return new ResponseEntity<>(services,HttpStatus.OK);
    }

    @GetMapping("/{serviceID}")
    public ResponseEntity<Services> findById(@PathVariable long serviceID){
        Services services = servicesService.findById(serviceID);
        return new ResponseEntity<>(services,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLocation(@RequestParam long serviceID){
        servicesService.delete(serviceID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{serviceID}")
    public ResponseEntity<Services> updateLocation(@PathVariable long serviceID,@RequestBody Services services){
        Services updateSer= servicesService.update(serviceID,services);
        return new ResponseEntity<>(updateSer,HttpStatus.OK);
    }
}
