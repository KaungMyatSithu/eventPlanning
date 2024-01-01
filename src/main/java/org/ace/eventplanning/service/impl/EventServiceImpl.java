package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.NewEventRequest;
import org.ace.eventplanning.entity.Event;
import org.ace.eventplanning.entity.Florist;
import org.ace.eventplanning.entity.Staff;
import org.ace.eventplanning.repo.EventRepo;
import org.ace.eventplanning.repo.StaffRepo;
import org.ace.eventplanning.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final StaffRepo staffRepo;
    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event findById(long eventID) {
        return eventRepo.findById(eventID).orElseThrow(()->new IllegalArgumentException("Event not Found!"));
    }

    @Override
    public void register(NewEventRequest event) {
        Staff staff =staffRepo.findById(event.getStaffID())
                .orElseThrow(() -> new IllegalArgumentException("Staff not found"));

        Event eventResp = Event.of(event);
        eventResp.setStaff(staff);
        eventRepo.save(eventResp);
    }

    @Override
    public void delete(long eventID) {
        if(eventRepo.existsById(eventID)){
            eventRepo.deleteById(eventID);
        }
    }

    @Override
    public Event update(long eventID, NewEventRequest updatedData) {
        Staff staff =staffRepo.findById(updatedData.getStaffID())
                .orElseThrow(() -> new IllegalArgumentException("Staff not found"));

        Optional<Event> optionalEvent = eventRepo.findById(eventID);
        if (optionalEvent.isPresent()){
            final Event existingEvent = optionalEvent.get();
            existingEvent.setEstimatedGuest(updatedData.getEstimatedGuest());
            existingEvent.setEstimatedBudget(updatedData.getEstimatedBudget());
            existingEvent.setCoupleNationalities(updatedData.getCoupleNationalities());
            existingEvent.setPreferredCeremonyVenue(updatedData.getPreferredCeremonyVenue());
            existingEvent.setPreferredDestination(updatedData.getPreferredDestination());
            existingEvent.setExpectedEventDate(updatedData.getExpectedEventDate());
            existingEvent.setEventDescription(updatedData.getEventDescription());
            existingEvent.setStatus(updatedData.getStatus());

            existingEvent.setStaff(staff);

            return eventRepo.save(existingEvent);
        }
        return null;
    }
}
