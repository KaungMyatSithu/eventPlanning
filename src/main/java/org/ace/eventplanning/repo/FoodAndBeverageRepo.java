package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.FoodAndBeverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodAndBeverageRepo extends JpaRepository<FoodAndBeverage,Long> {
}
