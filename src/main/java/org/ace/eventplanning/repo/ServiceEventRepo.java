package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.ServiceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceEventRepo extends JpaRepository<ServiceEvent,Long> {
}
