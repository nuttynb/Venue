package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Type;
import hu.schonherz.training.venue.persistence.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Home on 2016. 08. 25..
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface VenueRepository extends JpaRepository<Venue , Long>{

    Collection<Venue> findAllVenue();

    Venue findVenueById(Long venueId);

    Collection<Venue> findVenueByOwnerId(Long ownerId);

    Venue findVenueByName(String name);

    Collection<Venue> findVenueByType(Type type);

    Venue findVenuebyByEventId(Long eventId);

    Venue findVenueByAdressId(Long addressId);
}
