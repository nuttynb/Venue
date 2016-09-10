package hu.schonherz.training.venue.persistence.repository;


import hu.schonherz.training.venue.persistence.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {
    EventType findById(Long id);
}
