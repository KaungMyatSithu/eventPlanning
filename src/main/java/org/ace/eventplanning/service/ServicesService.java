package org.ace.eventplanning.service;

import org.ace.eventplanning.dto.ServicesRequest;
import org.ace.eventplanning.entity.Photographer;
import org.ace.eventplanning.entity.Services;

import java.util.List;

public interface ServicesService {
    List<Services> findAll();
    Services findById(long serviceID);
    Services register(ServicesRequest services);
    void delete(long serviceID);
    Services update(long serviceID, Services updatedData);
}
