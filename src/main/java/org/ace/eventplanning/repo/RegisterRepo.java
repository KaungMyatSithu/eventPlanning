package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Long> {
}
