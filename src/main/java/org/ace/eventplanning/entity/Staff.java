package org.ace.eventplanning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ace.eventplanning.dto.NewStaffRequest;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long staffID;
    private String staffName;
    private int staffAge;
    private String staffAddress;
    private String staffPhoneNumber;
    private String staffEmail;
    private String staffPassword;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID")
    private Role role;



    public static Staff of (NewStaffRequest staffRequest){
        Staff staff = new Staff();
        staff.setStaffName(staffRequest.getStaffName());
        staff.setStaffAge(staffRequest.getStaffAge());
        staff.setStaffAddress(staffRequest.getStaffAddress());
        staff.setStaffPhoneNumber(staffRequest.getStaffPhoneNumber());
        staff.setStaffEmail(staffRequest.getStaffEmail());
        staff.setStaffPassword(staffRequest.getStaffPassword());
        return staff;
    }
}
