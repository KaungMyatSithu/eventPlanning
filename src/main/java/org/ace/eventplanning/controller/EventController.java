package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.NewEventRequest;
import org.ace.eventplanning.entity.Event;
import org.ace.eventplanning.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<NewEventRequest> save(@RequestBody NewEventRequest event){
        eventService.register(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> findAll(){
        List<Event> events = eventService.findAll();
        return new ResponseEntity<>(events,HttpStatus.OK);
    }

    @GetMapping("/{eventID}")
    public ResponseEntity<Event> findById(@PathVariable long eventID){
        Event event = eventService.findById(eventID);
        return new ResponseEntity<>(event,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam long eventID){
        eventService.delete(eventID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{eventID}")
    public ResponseEntity<Event> update(@PathVariable long eventID,@RequestBody NewEventRequest event){
        Event updatedEvent= eventService.update(eventID,event);
        return ResponseEntity.ok(updatedEvent);
    }
}
