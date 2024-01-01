package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.Florist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloristRepo extends JpaRepository<Florist,Long> {
}