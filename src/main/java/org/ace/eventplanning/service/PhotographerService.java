package org.ace.eventplanning.service;

import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.entity.Photographer;

import java.util.List;

public interface PhotographerService {
    List<Photographer> findAll();
    Photographer findById(long photographerID);
    void register(Photographer photographer);
    void delete(long photographerID);
    Photographer update(long photographerID, Photographer updatedData);
}
