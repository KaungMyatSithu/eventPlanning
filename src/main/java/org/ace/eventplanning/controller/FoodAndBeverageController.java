package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.FoodAndBeverage;
import org.ace.eventplanning.service.FoodAndBeverageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/foodAndBeverages")
@AllArgsConstructor
public class FoodAndBeverageController {

    private final FoodAndBeverageService foodAndBeverageService;

    @PostMapping
    public ResponseEntity<FoodAndBeverage> save(@RequestBody FoodAndBeverage foodAndBeverage){
        foodAndBeverageService.register(foodAndBeverage);
        return new ResponseEntity<>(foodAndBeverage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodAndBeverage>> findAll(){
        List<FoodAndBeverage> foodAndBeverages = foodAndBeverageService.findAll();
        return new ResponseEntity<>(foodAndBeverages,HttpStatus.OK);
    }

    @GetMapping("/{restaurantID}")
    public ResponseEntity<FoodAndBeverage> findById(@PathVariable long restaurantID){
        FoodAndBeverage foodAndBeverage = foodAndBeverageService.findById(restaurantID);
        return new ResponseEntity<>(foodAndBeverage,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLocation(@RequestParam long restaurantID){
        foodAndBeverageService.delete(restaurantID);
        return new ResponseEntity<>("Successfully Deleted!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{restaurantID}")
    public ResponseEntity<FoodAndBeverage> updateLocation(@PathVariable long restaurantID,@RequestBody FoodAndBeverage foodAndBeverage){
        FoodAndBeverage updatedRes= foodAndBeverageService.update(restaurantID,foodAndBeverage);
        return new ResponseEntity<>(updatedRes,HttpStatus.OK);
    }

}
