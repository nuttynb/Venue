package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventImageRepository extends JpaRepository<EventImage, Long>{

    List<EventImage> findByEventId(Long eventId);

    EventImage findById(Long id);
}
