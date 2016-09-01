package hu.schonherz.training.venue.persistence.repository;

import hu.schonherz.training.venue.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Home on 2016. 08. 25..
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface AddressRepository extends JpaRepository<Address , Long>{

    @Modifying
    @Query("UPDATE address a SET a.country = ?1,a.city = ?2,a.street = ?3,a.number = ?4,a.postcode = ?5 WHERE a.id = ?6")
    void updateAddress(String country,String city,String street,Integer number,Integer postcode,Long id) throws Exception;
}
