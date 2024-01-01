package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "role")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long roleID;
    private String roleName;

    @OneToMany(mappedBy = "role", cascade =  CascadeType.ALL)
    @JsonIgnore
    private List<Staff> staffList;

//    public void addStaff(Staff staff){
//        staff.setRole(this);
//        this.staffList.add(staff);
//    }
}
