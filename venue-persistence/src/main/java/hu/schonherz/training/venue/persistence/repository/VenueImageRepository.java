package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.VenueImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueImageRepository extends JpaRepository<VenueImage, Long> {

    List<VenueImage> findByVenueId(Long venueId);

    VenueImage findById(Long id);

}
