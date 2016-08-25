package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.persistence.entity.Type;
import hu.schonherz.training.venue.vo.VenueVo;

import java.util.List;

/**
 * Created by Roli on 2016. 08. 25..
 */
public interface VenueService {

    List<VenueVo> getAllVenue();

    VenueVo getVenueById(Long id);

    List<VenueVo> getVenueByOwnerId(Long ownerId);

    List<VenueVo> getVenueByName(String name);

    List<VenueVo> getVenueByType(Type type);

    void createVenue(VenueVo venueVo);

    void deleteVenue(VenueVo venueVo);
}
