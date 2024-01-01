package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationID;
    private String locationName;
    private String contactPerson;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> servicesList;
}
