package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.entity.Photographer;
import org.ace.eventplanning.repo.PhotographerRepo;
import org.ace.eventplanning.service.PhotographerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PhotographerServiceImpl implements PhotographerService {

    private final PhotographerRepo photographerRepo;
    @Override
    public List<Photographer> findAll() {
        return photographerRepo.findAll();
    }

    @Override
    public Photographer findById(long photographerID) {
        return photographerRepo.findById(photographerID).orElseThrow(()-> new IllegalArgumentException("Photographer Not Found."));
    }

    @Override
    public void register(Photographer photographer) {
        photographerRepo.save(photographer);
    }

    @Override
    public void delete(long photographerID) {
        if(photographerRepo.existsById(photographerID)){
            photographerRepo.deleteById(photographerID);
        }
    }

    @Override
    public Photographer update(long photographerID, Photographer updatedData) {
        Optional<Photographer> optionalPhotographer= photographerRepo.findById(photographerID);
        if (optionalPhotographer.isPresent()){
            final Photographer existingPhotograph = optionalPhotographer.get();
            existingPhotograph.setPhotographerName(updatedData.getPhotographerName());
            existingPhotograph.setEmail(updatedData.getEmail());
            existingPhotograph.setPhoneNumber(updatedData.getPhoneNumber());

            return photographerRepo.save(existingPhotograph);
        }
        return null;
    }
}
