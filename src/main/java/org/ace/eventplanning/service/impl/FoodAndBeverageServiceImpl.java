package org.ace.eventplanning.service.impl;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.FoodAndBeverage;
import org.ace.eventplanning.repo.FoodAndBeverageRepo;
import org.ace.eventplanning.service.FoodAndBeverageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodAndBeverageServiceImpl implements FoodAndBeverageService {

    private final FoodAndBeverageRepo foodAndBeverageRepo;
    @Override
    public List<FoodAndBeverage> findAll() {
        return foodAndBeverageRepo.findAll();
    }

    @Override
    public FoodAndBeverage findById(long restaurantID) {
        return foodAndBeverageRepo.findById(restaurantID).orElseThrow(()-> new IllegalArgumentException("No Restaurant Found!"));
    }

    @Override
    public void register(FoodAndBeverage foodAndBeverage) {
        foodAndBeverageRepo.save(foodAndBeverage);
    }

    @Override
    public void delete(long restaurantID) {
        if(foodAndBeverageRepo.existsById(restaurantID)){
            foodAndBeverageRepo.deleteById(restaurantID);
        }
    }

    @Override
    public FoodAndBeverage update(long restaurantID, FoodAndBeverage updatedData) {
        Optional<FoodAndBeverage> optionalRes = foodAndBeverageRepo.findById(restaurantID);
        if (optionalRes.isPresent()) {
            final FoodAndBeverage existingRes = optionalRes.get();
            existingRes.setRestaurantName(updatedData.getRestaurantName());
            existingRes.setContactPerson(updatedData.getContactPerson());
            existingRes.setPhoneNumber(updatedData.getPhoneNumber());
            existingRes.setEmail(updatedData.getEmail());
            return foodAndBeverageRepo.save(existingRes);
        }
        return null;
    }
}
