package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Roli on 2016. 08. 27..
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface TypeRepository extends JpaRepository<Type, Long>{

}