package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.VenueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueTypeRepository extends JpaRepository<VenueType, Long> {
    VenueType findById(Long id);
}