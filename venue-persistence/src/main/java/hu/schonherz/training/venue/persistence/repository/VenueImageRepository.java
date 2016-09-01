package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.VenueImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Home on 2016. 09. 01..
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface VenueImageRepository extends JpaRepository<VenueImage, Long> {
}
