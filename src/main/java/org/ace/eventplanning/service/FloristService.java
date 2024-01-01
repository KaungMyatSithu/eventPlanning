package org.ace.eventplanning.service;

import org.ace.eventplanning.entity.Florist;

import java.util.List;

public interface FloristService {
    List<Florist> findAll();
    Florist findById(long floristID);
    void register(Florist florist);
    void deleteFlorist(long floristID);
    Florist updateFlorist(long floristID, Florist updatedData);
}
