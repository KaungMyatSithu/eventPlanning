package org.ace.eventplanning.service;

import org.ace.eventplanning.dto.ServiceEventRequest;
import org.ace.eventplanning.entity.ServiceEvent;

import java.util.List;

public interface ServiceEventService {

    List<ServiceEvent> findAll();
    ServiceEvent findById(long serviceEventID);
    ServiceEvent register(ServiceEventRequest serviceEvent);
}
