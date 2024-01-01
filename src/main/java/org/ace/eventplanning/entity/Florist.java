package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "florists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Florist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long floristID;
    private String floristName;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "florist",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> servicesList;
}
