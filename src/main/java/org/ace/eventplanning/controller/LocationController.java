package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location){
        locationService.register(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Location>> findAll(){
        List<Location> locations = locationService.findAll();
        return new ResponseEntity<>(locations,HttpStatus.OK);
    }

    @GetMapping("/{locationID}")
    public ResponseEntity<Location> findById(@PathVariable long locationID){
        Location location = locationService.findById(locationID);
        return new ResponseEntity<>(location,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLocation(@RequestParam long locationID){
        locationService.deleteLocation(locationID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{locationID}")
    public ResponseEntity<Location> updateLocation(@PathVariable long locationID,@RequestBody Location location){
        Location updatedLoc= locationService.updateLocation(locationID,location);
        return new ResponseEntity<>(updatedLoc,HttpStatus.OK);
    }

//    @PostMapping("/upload/{locationID}")
//    public ResponseEntity<String> handleFileUpload(
//            @PathVariable long locationID,
//            @RequestParam MultipartFile file,
//            @RequestParam String photoNumber){
//        try{
//            locationService.handleFileUpload(locationID,file,photoNumber);
//        }
//        catch (IOException exception){
//            exception.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error at Uploading file!");
//        }
//
//        return ResponseEntity.ok("File Upload Successfully.");
//    }
}
