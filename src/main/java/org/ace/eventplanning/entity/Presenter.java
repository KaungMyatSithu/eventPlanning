package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "presenter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Presenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long presenterID;
    private String presenterName;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "presenter",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> servicesList;
}
