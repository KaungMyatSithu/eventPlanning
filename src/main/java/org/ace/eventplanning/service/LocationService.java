package org.ace.eventplanning.service;

import org.ace.eventplanning.entity.Location;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LocationService {
    List<Location> findAll();
    Location findById(long locationID);
    void register(Location location);
    void deleteLocation(long locationID);
    Location updateLocation(long locationID, Location updatedData);

//    void handleFileUpload(long locationID, MultipartFile file,String photoNumber) throws IOException;

}
