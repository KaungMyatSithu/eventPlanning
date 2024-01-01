package org.ace.eventplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ace.eventplanning.dto.NewEventRequest;
import org.ace.eventplanning.enumtypes.StatusForEvent;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventID;
    private int estimatedGuest;
    private double estimatedBudget;
    private String coupleNationalities;
    private String preferredCeremonyVenue;
    private String preferredDestination;
    private LocalDate expectedEventDate;
    private String eventDescription;

    @Enumerated(EnumType.STRING)
    private StatusForEvent status;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ServiceEvent> serviceEventList;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Register> registerList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staffID")
    private Staff staff;

    public static Event of(NewEventRequest eventRequest){
        Event event = new Event();
        event.setEstimatedGuest(eventRequest.getEstimatedGuest());
        event.setEstimatedBudget(eventRequest.getEstimatedBudget());
        event.setCoupleNationalities(eventRequest.getCoupleNationalities());
        event.setPreferredCeremonyVenue(eventRequest.getPreferredCeremonyVenue());
        event.setPreferredDestination(eventRequest.getPreferredDestination());
        event.setExpectedEventDate(eventRequest.getExpectedEventDate());
        event.setEventDescription(eventRequest.getEventDescription());
        event.setStatus(eventRequest.getStatus());
        return event;
    }
}
