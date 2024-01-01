package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.ServiceEventRequest;
import org.ace.eventplanning.entity.ServiceEvent;
import org.ace.eventplanning.service.ServiceEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/serviceEvents")
public class ServiceEventController {
    private final ServiceEventService serviceEventService;
    @PostMapping
    public ResponseEntity<ServiceEvent> save(@RequestBody ServiceEventRequest serviceEvent){
        ServiceEvent serviceEventResp=serviceEventService.register(serviceEvent);
        return new ResponseEntity<>(serviceEventResp, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceEvent>> findAll(){
        List<ServiceEvent> serviceEventList = serviceEventService.findAll();
        return new ResponseEntity<>(serviceEventList,HttpStatus.OK);
    }

    @GetMapping("/{serviceEventID}")
    public ResponseEntity<ServiceEvent> findById(@PathVariable long serviceEventID){
        ServiceEvent serviceEvent = serviceEventService.findById(serviceEventID);
        return new ResponseEntity<>(serviceEvent,HttpStatus.OK);
    }
}
