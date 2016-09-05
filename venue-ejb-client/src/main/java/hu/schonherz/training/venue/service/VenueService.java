package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.VenueVo;


public interface VenueService {

    void createVenue(VenueVo venueVo);

    VenueVo getVenueByOwnerId(Long ownerId);

    public VenueVo getVenueById(Long venueId);
}
