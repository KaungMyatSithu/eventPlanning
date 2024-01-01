package org.ace.eventplanning.repo;

import org.ace.eventplanning.entity.Presenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenterRepo extends JpaRepository<Presenter,Long> {
}
