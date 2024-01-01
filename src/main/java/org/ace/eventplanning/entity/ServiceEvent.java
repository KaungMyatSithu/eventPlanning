package org.ace.eventplanning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "serviceEvents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceEventID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID")
    private Services services;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventID")
    private Event event;
}
