package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {
}
