package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Photographer;
import org.ace.eventplanning.service.PhotographerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/photographers")
public class PhotographerController {

    private final PhotographerService photographerService;

    @PostMapping
    public ResponseEntity<Photographer> save(@RequestBody Photographer photographer){
        photographerService.register(photographer);
        return new ResponseEntity<>(photographer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Photographer>> findAll(){
        List<Photographer> photographers = photographerService.findAll();
        return new ResponseEntity<>(photographers,HttpStatus.OK);
    }

    @GetMapping("/{photographerID}")
    public ResponseEntity<Photographer> findById(@PathVariable long photographerID){
        Photographer photographer = photographerService.findById(photographerID);
        return new ResponseEntity<>(photographer,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam long photographerID){
        photographerService.delete(photographerID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{photographerID}")
    public ResponseEntity<Photographer> update(@PathVariable long photographerID,@RequestBody Photographer photographer){
        Photographer updatedPhoto= photographerService.update(photographerID,photographer);
        return new ResponseEntity<>(updatedPhoto,HttpStatus.OK);
    }
}
