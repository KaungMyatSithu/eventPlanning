package org.ace.eventplanning.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.ace.eventplanning.enumtypes.StatusForEvent;

import java.time.LocalDate;

@Getter
@Setter
public class NewEventRequest {
    private long eventID;
    private int estimatedGuest;
    private String eventDescription;
    private double estimatedBudget;
    private String coupleNationalities;
    private String preferredCeremonyVenue;
    private String preferredDestination;
    private LocalDate expectedEventDate;

    @Enumerated(EnumType.STRING)
    private StatusForEvent status;

    private long staffID;
}
