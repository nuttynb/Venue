package hu.schonherz.training.venue.ejb.remote.stateless;


import hu.schonherz.training.venue.vo.EventVo;
import hu.schonherz.training.venue.vo.enums.EventType;

import java.util.Date;
import java.util.List;

public interface EventRemoteService {

    void registerBandForEvent(Long eventId, Long bandId);

    List<EventVo> getAllEvents();

    EventVo getEventByVenueIdAndDate(Long venueid, Date begin, Date end);

    List<EventVo> getEventsByVenueId(Long venueId);

    List<EventVo> getEventsByType(EventType type);

}
