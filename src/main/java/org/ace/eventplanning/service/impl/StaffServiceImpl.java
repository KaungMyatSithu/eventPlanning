package org.ace.eventplanning.service.impl;


import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.NewStaffRequest;
import org.ace.eventplanning.entity.Role;
import org.ace.eventplanning.entity.Staff;
import org.ace.eventplanning.repo.RoleRepo;
import org.ace.eventplanning.repo.StaffRepo;
import org.ace.eventplanning.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepo staffRepo;
    private final RoleRepo roleRepo;

    @Override
    public List<Staff> findAllStaff() {
        return staffRepo.findAll();
    }

    @Override
    public Staff registerStaff(NewStaffRequest staffRequest) {
        Role role = roleRepo.findById(staffRequest.getRoleID())
                .orElseThrow(() -> new RuntimeException("No role found"));

        Staff staff = Staff.of(staffRequest);
        staff.setRole(role);
        return staffRepo.save(staff);
    }


    @Override
    public Staff findByStaffID(long staffID) {
        return staffRepo.findById(staffID).orElseThrow(() -> new RuntimeException("Invalid ID" + staffID));
    }

    @Override
    public void deleteStaff(long staffID) {
        if (staffRepo.existsById(staffID));
        staffRepo.findById(staffID);
    }

    @Override
    public Staff updateStaff(long staffID, Staff updateStaffData) {
        Optional<Staff> optionalStaff = staffRepo.findById(staffID);
        if (optionalStaff.isPresent()) {
            Staff existingStaff = optionalStaff.get();
            existingStaff.setStaffName(updateStaffData.getStaffName());
            existingStaff.setStaffAge(updateStaffData.getStaffAge());
            existingStaff.setStaffAddress(updateStaffData.getStaffAddress());
            existingStaff.setStaffPhoneNumber(updateStaffData.getStaffPhoneNumber());
            existingStaff.setStaffEmail(updateStaffData.getStaffEmail());
            existingStaff.setStaffPassword(updateStaffData.getStaffPassword());
            return staffRepo.save(existingStaff);
        } else {
            return null;
        }
    }
}
