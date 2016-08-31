package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.TypeVo;
import hu.schonherz.training.venue.vo.VenueVo;

import java.util.List;

/**
 * Created by Roli on 2016. 08. 25..
 */
public interface VenueService {

    void createVenue(VenueVo venueVo);

    VenueVo getVenueByOwnerId(Long ownerId);

}
