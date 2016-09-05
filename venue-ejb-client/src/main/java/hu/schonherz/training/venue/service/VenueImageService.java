package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.VenueImageVo;

import java.util.List;

/**
 * Created by Home on 2016. 09. 02..
 */

public interface VenueImageService {

    void createVenueImage(VenueImageVo venueImageVo);

    List<VenueImageVo> getVenueImageByVenueId(Long venueId);

    VenueImageVo getVenueImageById(Long id);
}
