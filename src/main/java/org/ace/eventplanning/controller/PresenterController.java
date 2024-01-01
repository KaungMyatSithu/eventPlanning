package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Photographer;
import org.ace.eventplanning.entity.Presenter;
import org.ace.eventplanning.service.PresenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/presenters")
public class PresenterController {
    private final PresenterService presenterService;

    @PostMapping
    public ResponseEntity<Presenter> save(@RequestBody Presenter presenter){
        presenterService.register(presenter);
        return new ResponseEntity<>(presenter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Presenter>> findAll(){
        List<Presenter> presenters = presenterService.findAll();
        return new ResponseEntity<>(presenters,HttpStatus.OK);
    }

    @GetMapping("/{presenterID}")
    public ResponseEntity<Presenter> findById(@PathVariable long presenterID){
        Presenter presenter = presenterService.findById(presenterID);
        return new ResponseEntity<>(presenter,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam long presenterID){
        presenterService.delete(presenterID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{presenterID}")
    public ResponseEntity<Presenter> update(@PathVariable long presenterID,@RequestBody Presenter presenter){
        Presenter updatedPrs= presenterService.update(presenterID,presenter);
        return new ResponseEntity<>(updatedPrs,HttpStatus.OK);
    }
}
