package org.ace.eventplanning.service;

import org.ace.eventplanning.dto.NewEventRequest;
import org.ace.eventplanning.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();
    Event findById(long eventID);
    void register(NewEventRequest event);
    void delete(long eventID);
    Event update(long eventID, NewEventRequest updatedData);
}
