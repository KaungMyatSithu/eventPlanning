package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Florist;
import org.ace.eventplanning.repo.FloristRepo;
import org.ace.eventplanning.service.FloristService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FloristServiceImpl implements FloristService {
    private final FloristRepo floristRepo;


    @Override
    public List<Florist> findAll() {
        return floristRepo.findAll();
    }

    @Override
    public Florist findById(long floristID) {
        return floristRepo.findById(floristID).orElseThrow(()-> new IllegalArgumentException("No Florist Found!"));
    }

    @Override
    public void register(Florist florist) {
        floristRepo.save(florist);
    }

    @Override
    public void deleteFlorist(long floristID) {
        if(floristRepo.existsById(floristID)){
            floristRepo.deleteById(floristID);
        }
    }

    @Override
    public Florist updateFlorist(long floristID, Florist updatedData) {
        Optional<Florist> optionalFlorist = floristRepo.findById(floristID);
        if (optionalFlorist.isPresent()){
            final Florist existingFlorist = optionalFlorist.get();
            existingFlorist.setFloristName(updatedData.getFloristName());
            existingFlorist.setPhoneNumber(updatedData.getPhoneNumber());
            existingFlorist.setEmail(updatedData.getEmail());

            return floristRepo.save(existingFlorist);
        }
        return null;
    }
}
