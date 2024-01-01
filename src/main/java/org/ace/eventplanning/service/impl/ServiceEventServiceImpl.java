package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.ServiceEventRequest;
import org.ace.eventplanning.entity.Event;
import org.ace.eventplanning.entity.ServiceEvent;
import org.ace.eventplanning.entity.Services;
import org.ace.eventplanning.repo.EventRepo;
import org.ace.eventplanning.repo.ServiceEventRepo;
import org.ace.eventplanning.repo.ServicesRepo;
import org.ace.eventplanning.service.ServiceEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceEventServiceImpl implements ServiceEventService {
    private final ServiceEventRepo serviceEventRepo;
    private final ServicesRepo servicesRepo;
    private final EventRepo eventRepo;
    @Override
    public List<ServiceEvent> findAll() {
        return serviceEventRepo.findAll();
    }

    @Override
    public ServiceEvent findById(long serviceEventID) {
        return serviceEventRepo.findById(serviceEventID).orElseThrow(()->new IllegalArgumentException("ServiceEvent not Found!"));
    }

    @Override
    public ServiceEvent register(ServiceEventRequest serviceEventReq) {
        Services service = servicesRepo.findById(serviceEventReq.getServiceID()).orElseThrow(()-> new IllegalArgumentException("Service Not Fund!"));
        Event event= eventRepo.findById(serviceEventReq.getEventID()).orElseThrow(()-> new IllegalArgumentException("Event Not found!"));

        ServiceEvent serviceEvent = new ServiceEvent();
        serviceEvent.setServices(service);
        serviceEvent.setEvent(event);
        serviceEventRepo.save(serviceEvent);
        return serviceEvent;
    }
}
