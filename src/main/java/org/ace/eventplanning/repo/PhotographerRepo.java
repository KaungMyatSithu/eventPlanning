package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerRepo extends JpaRepository<Photographer,Long> {
}
