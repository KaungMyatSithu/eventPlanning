package org.ace.eventplanning.service;

import org.ace.eventplanning.dto.NewStaffRequest;
import org.ace.eventplanning.entity.Staff;

import java.util.List;

public interface StaffService {
    //Find All Method
    List<Staff> findAllStaff();




    //Register Method
    Staff registerStaff(NewStaffRequest staffRequest);




    //Find By ID Method
    Staff findByStaffID(long staffID);



    //Delete Method
    void deleteStaff(long staffID);


    //Update Method
    Staff updateStaff(long staffID, Staff updateStaffData);
}
