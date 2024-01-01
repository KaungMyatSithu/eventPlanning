package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.entity.Presenter;
import org.ace.eventplanning.repo.PresenterRepo;
import org.ace.eventplanning.service.PresenterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PresenterServiceImpl implements PresenterService {

    private final PresenterRepo presenterRepo;
    @Override
    public List<Presenter> findAll() {
        return presenterRepo.findAll();
    }

    @Override
    public Presenter findById(long presenterID) {
        return presenterRepo.findById(presenterID).orElseThrow(()->new IllegalArgumentException("Presenter not Found?"));
    }

    @Override
    public void register(Presenter presenter) {
        presenterRepo.save(presenter);
    }

    @Override
    public void delete(long presenterID) {
        if(presenterRepo.existsById(presenterID)){
            presenterRepo.deleteById(presenterID);
        }
    }

    @Override
    public Presenter update(long presenterID, Presenter updatedData) {
        Optional<Presenter> optionalPresenter = presenterRepo.findById(presenterID);
        if(optionalPresenter.isPresent()){
            final Presenter existingPresenter = optionalPresenter.get();
            existingPresenter.setPresenterName(updatedData.getPresenterName());
            existingPresenter.setEmail(updatedData.getEmail());
            existingPresenter.setPhoneNumber(updatedData.getPhoneNumber());

            return presenterRepo.save(existingPresenter);
        }
        return null;
    }
}
