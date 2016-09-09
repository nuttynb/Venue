package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    Event findByVenue_IdAndBeginDateAndEndDate(Long venueId, Date begin, Date end);
}
