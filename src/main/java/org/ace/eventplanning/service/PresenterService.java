package org.ace.eventplanning.service;

import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.entity.Presenter;

import java.util.List;

public interface PresenterService {

    List<Presenter> findAll();
    Presenter findById(long presenterID);
    void register(Presenter presenter);
    void delete(long presenterID);
    Presenter update(long presenterID, Presenter updatedData);
}
