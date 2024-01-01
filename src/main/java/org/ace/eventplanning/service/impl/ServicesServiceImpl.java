package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.dto.ServicesRequest;
import org.ace.eventplanning.entity.*;
import org.ace.eventplanning.repo.*;
import org.ace.eventplanning.service.ServicesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepo servicesRepo;
    private  final LocationRepo locationRepo;
    private  final FoodAndBeverageRepo foodAndBeverageRepo;
    private  final PhotographerRepo photographerRepo;
    private  final FloristRepo floristRepo;
    private  final PresenterRepo presenterRepo;
    @Override
    public List<Services> findAll() {
        return servicesRepo.findAll();
    }

    @Override
    public Services findById(long serviceID) {
        return servicesRepo.findById(serviceID).orElseThrow(()->new IllegalArgumentException("Services not Found!"));
    }

    @Override
    public Services register(ServicesRequest services) {
        Location location = locationRepo.findById(services.getLocationID()).orElse(null);
        FoodAndBeverage foodAndBeverage = foodAndBeverageRepo.findById(services.getRestaurantID()).orElse(null);
        Photographer photographer = photographerRepo.findById(services.getPhotographerID()).orElse(null);
        Florist florist = floristRepo.findById(services.getFloristID()).orElse(null);
        Presenter presenter = presenterRepo.findById(services.getPresenterID()).orElse(null);

        Services service = new Services();
        service.setLocation(location);
        service.setFood(foodAndBeverage);
        service.setPhotographer(photographer);
        service.setFlorist(florist);
        service.setPresenter(presenter);
        return servicesRepo.save(service);
    }

    @Override
    public void delete(long serviceID) {
        if (servicesRepo.existsById(serviceID)){
            servicesRepo.deleteById(serviceID);
        }
    }

    @Override
    public Services update(long serviceID, Services updatedData) {
        Optional<Services> optionalServices= servicesRepo.findById(serviceID);
        if (optionalServices.isPresent()){
            final Services existingServices = optionalServices.get();
//            existingServices(updatedData.getPhotographerName());
//            existingPhotograph.setEmail(updatedData.getEmail());
//            existingPhotograph.setPhoneNumber(updatedData.getPhoneNumber());

//            return photographerRepo.save(existingPhotograph);
        }
        return null;
    }
}
