package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.EventsVo;

import java.util.Date;
import java.util.List;


public interface EventsService {

    List<EventsVo> getAllEvents();

    EventsVo getEventById(Long id);

    List<EventsVo> getEventByVenueId(Long venueid);

    EventsVo getEventByVenueIdAndDate(Long venueid, Date begin, Date end);

    List<EventsVo> getEventByBandId(Long bandId);

    List<EventsVo> getEventByName(String name);

    List<EventsVo> getEventByDate(Date date);

    void createEvent(EventsVo eventsVo);

    void deleteEvent(EventsVo eventsVo);
}
