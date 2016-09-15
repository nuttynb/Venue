package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.VenueVo;

import java.util.List;


public interface VenueService {

    void saveVenue(VenueVo venueVo);

    VenueVo getVenueByOwnerId(Long ownerId);

    VenueVo getVenueById(Long venueId);

    List<VenueVo> getAllVenues();
}
