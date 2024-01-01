package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Location;
import org.ace.eventplanning.repo.LocationRepo;
import org.ace.eventplanning.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepo locationRepo;
    @Override
    public List<Location> findAll() {
        return locationRepo.findAll();
    }

    @Override
    public Location findById(long locationID) {
        return locationRepo.findById(locationID).orElseThrow(()-> new IllegalArgumentException("No Location Found!"));
    }

    @Override
    public void register(Location location) {
        locationRepo.save(location);
    }

    @Override
    public void deleteLocation(long locationID) {
        if (locationRepo.existsById(locationID)){
            locationRepo.deleteById(locationID);
        }
    }

    @Override
    public Location updateLocation(long locationID, Location updatedData) {
        Optional<Location> optionalLocation = locationRepo.findById(locationID);
        if(optionalLocation.isPresent()){
            final Location existingLocation = optionalLocation.get();
            existingLocation.setLocationName(updatedData.getLocationName());
            existingLocation.setContactPerson(updatedData.getContactPerson());
            existingLocation.setEmail(updatedData.getEmail());
            existingLocation.setPhoneNumber(updatedData.getPhoneNumber());

            return locationRepo.save(existingLocation);
        }
        return null;
    }
//    @Override
//    public void handleFileUpload(long locationID, MultipartFile file, String photoNumber) throws IOException {
//        Optional<Location> optionalLocation = locationRepo.findById(locationID);
//        if(optionalLocation.isPresent()){
//
//            Location location = optionalLocation.get();
//            byte[] fileBytes = file.getBytes();
//
//            switch (photoNumber) {
//                case "1": location.setPhoto1(fileBytes);break;
//                case "2": location.setPhoto2(fileBytes);break;
//                case "3": location.setPhoto3(fileBytes);break;
//            }
//            locationRepo.save(location);
//        }
//    }
}
