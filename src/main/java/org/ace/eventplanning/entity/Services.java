package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Table(name = "services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationID")
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantID")
    private FoodAndBeverage food;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photographerID")
    private Photographer photographer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floristID")
    private Florist florist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "presenterID")
    private Presenter presenter;


    @OneToMany(mappedBy = "services",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ServiceEvent> serviceEventList;

}
