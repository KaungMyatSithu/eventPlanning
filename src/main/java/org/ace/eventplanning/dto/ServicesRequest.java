package org.ace.eventplanning.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicesRequest {
    private long serviceID;
    private long locationID;
    private long restaurantID;
    private long photographerID;
    private long floristID;
    private long presenterID;

}
