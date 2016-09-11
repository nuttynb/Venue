package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface VenueRepository extends JpaRepository<Venue , Long>{

    Venue findVenueByOwnerId(Long ownerId);

    Venue findById(Long id);

    Venue findByAddressId(Long address_id);

    Venue findByName(Long name);
}
