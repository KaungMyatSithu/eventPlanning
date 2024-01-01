package org.ace.eventplanning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceEventRequest {
    private long serviceEventID;
    private long serviceID;
    private long eventID;
}
