package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.VenueImageVo;

import java.util.List;


public interface VenueImageService {

    void saveVenueImage(VenueImageVo venueImageVo);

    List<VenueImageVo> getVenueImageByVenueId(Long venueId);

    VenueImageVo getVenueImageById(Long id);
}
