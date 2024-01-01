package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "photographers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long photographerID;
    private String photographerName;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "photographer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> servicesList;
}
