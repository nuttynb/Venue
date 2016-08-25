package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Home on 2016. 08. 25..
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface EventsRepository extends JpaRepository<Events , Long>{

    

}
