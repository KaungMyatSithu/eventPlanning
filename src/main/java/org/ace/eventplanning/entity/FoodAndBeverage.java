package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodAndBeverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantID;
    private String restaurantName;
    private String contactPerson;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "food",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> servicesList;
}
