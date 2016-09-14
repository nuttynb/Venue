package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Event;
import hu.schonherz.training.venue.persistence.entity.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByVenue_IdAndBeginDateAndEndDate(Long venueId, Date begin, Date end);

    List<Event> findByVenue_Id(Long venueId);

    List<Event> findByBandId(Long bandId);

    List<Event> findByBeginDate(Date beginDate);

    List<Event> findByType(EventType type);
}