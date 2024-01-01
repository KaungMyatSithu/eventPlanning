package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Florist;
import org.ace.eventplanning.service.FloristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/florists")
public class FloristController {
    private final FloristService floristService;

    @PostMapping
    public ResponseEntity<Florist> save(@RequestBody Florist florist){
        floristService.register(florist);
        return new ResponseEntity<>(florist, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Florist>> findAll(){
        List<Florist> florists = floristService.findAll();
        return new ResponseEntity<>(florists,HttpStatus.OK);
    }

    @GetMapping("/{floristID}")
    public ResponseEntity<Florist> findById(@PathVariable long floristID){
        Florist florist = floristService.findById(floristID);
        return new ResponseEntity<>(florist,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLocation(@RequestParam long floristID){
        floristService.deleteFlorist(floristID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{floristID}")
    public ResponseEntity<Florist> updateLocation(@PathVariable long floristID,@RequestBody Florist florist){
        Florist updatedFl= floristService.updateFlorist(floristID,florist);
        return new ResponseEntity<>(updatedFl,HttpStatus.OK);
    }
}
