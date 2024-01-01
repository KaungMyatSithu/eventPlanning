package org.ace.eventplanning.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class NewRegisterRequest {
    private long registerID;
    private LocalDate registerDate;
    private long customerID;
    private long eventID;
}
