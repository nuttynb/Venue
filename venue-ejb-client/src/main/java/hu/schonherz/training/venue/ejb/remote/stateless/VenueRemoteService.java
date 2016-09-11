package hu.schonherz.training.venue.ejb.remote.stateless;

import hu.schonherz.training.venue.vo.VenueVo;

import java.util.List;

public interface VenueRemoteService {
    List<VenueVo> getAllVenues();

    List<VenueVo> getVenuesWithPaging(int page, int pageSize);
}
