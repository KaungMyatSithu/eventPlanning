package org.ace.eventplanning.service;

import org.ace.eventplanning.entity.FoodAndBeverage;


import java.util.List;

public interface FoodAndBeverageService {
    List<FoodAndBeverage> findAll();
    FoodAndBeverage findById(long restaurantID);
    void register(FoodAndBeverage foodAndBeverage);
    void delete(long restaurantID);
    FoodAndBeverage update(long restaurantID,FoodAndBeverage updatedData);
}
