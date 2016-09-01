package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Type;
import hu.schonherz.training.venue.persistence.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    Venue findVenueByOwnerId(Long ownerId);

    Venue findVenueById(Long Id);

    Venue findVeuneByAddress_Id(Long address_id);

    Collection<Venue> findVenueByType_Id(Long type_id);

    Venue findVenueByName(Long name);

    @Modifying
    @Query("update venue v set v.name = ?1, v.description = ?2 ,v.type_id = ?3 where v.id = ?4")
    void updateVenue(String name, String description, Long type_id, Long id) throws Exception;


}
