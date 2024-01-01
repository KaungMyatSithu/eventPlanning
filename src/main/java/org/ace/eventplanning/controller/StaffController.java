
package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.NewStaffRequest;
import org.ace.eventplanning.entity.Staff;
import org.ace.eventplanning.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
@AllArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<Staff> registerStaff(@RequestBody NewStaffRequest staffRequest){
        Staff registeredStaff = staffService.registerStaff(staffRequest);
        return new ResponseEntity<>(registeredStaff,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Staff>> findAllStaff (){
        List<Staff> staffList = staffService.findAllStaff();
        return new ResponseEntity<>(staffList,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStaff(@RequestParam long staffID){
        staffService.deleteStaff(staffID);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{staffID}")
    public ResponseEntity<Staff> findStaffID (@PathVariable long staffID){
        Staff staff = staffService.findByStaffID(staffID);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PutMapping("/{staffID}")
    public ResponseEntity<Staff> updateStaff (@PathVariable Long staffID, @RequestBody Staff updatedStaffData) {
        Staff updatedStaff = staffService.updateStaff(staffID, updatedStaffData);

        if (updatedStaff != null) {
            return ResponseEntity.ok(updatedStaff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
