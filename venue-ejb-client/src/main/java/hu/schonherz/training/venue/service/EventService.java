package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.EventVo;

import java.util.Date;
import java.util.List;


public interface EventService {

    List<EventVo> getAllEvents();

    EventVo getEventById(Long id);

    EventVo getEventByVenueIdAndDate(Long venueid, Date begin, Date end);

    List<EventVo> getEventsByVenueId(Long venueId);

    List<EventVo> getEventsByBandId(Long bandId);

    List<EventVo> getEventsByDate(Date date);

    void createEvent(EventVo eventVo);

    void deleteEvent(EventVo eventVo);
}
