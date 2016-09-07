package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Events;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import java.util.Date;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface EventsRepository extends JpaRepository<Events , Long>{

    Events findByVenue_IdAndBeginAndEnd(Long id, Date begin, Date end);
}
