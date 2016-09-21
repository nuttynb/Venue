package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.ejb.remote.stateless.EventRemoteService;
import hu.schonherz.training.venue.persistence.entity.Event;
import hu.schonherz.training.venue.persistence.entity.enums.EventType;
import hu.schonherz.training.venue.persistence.repository.EventRepository;
import hu.schonherz.training.venue.service.EventService;
import hu.schonherz.training.venue.vo.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Date;
import java.util.List;


@Stateless(name = "EventService", mappedName = "EventService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(EventService.class)
@Remote(EventRemoteService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class EventServiceImpl extends AbstractMappingService implements EventService, EventRemoteService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventVo> getAllEvents() {
        return map(eventRepository.findAll(), EventVo.class);
    }

    @Override
    public EventVo getEventById(Long id) {
        Event event = eventRepository.findOne(id);
        if (event != null) {
            return map(event, EventVo.class);
        } else {
            return null;
        }
    }

    @Override
    public List<EventVo> getEventsByVenueId(Long venueid) {
        return map(eventRepository.findByVenue_Id(venueid), EventVo.class);
    }

    @Override
    public EventVo getEventByVenueIdAndDate(Long venueId, Date begin, Date end) {
        Event event = null;
        event = eventRepository.findByVenue_IdAndBeginDateAndEndDate(venueId, begin, end);
        if (event != null) {
            return map(event, EventVo.class);
        }
        return null;
    }

    @Override
    public List<EventVo> getEventsByBandId(Long bandId) {
        return map(eventRepository.findByBandId(bandId), EventVo.class);
    }

    @Override
    public List<EventVo> getEventsByDate(Date date) {
        return map(eventRepository.findByBeginDate(date), EventVo.class);
    }

    @Override
    public void createEvent(EventVo eventVo) {
        Event converted = map(eventVo, Event.class);
        eventRepository.save(converted);
    }

    @Override
    public void deleteEvent(EventVo eventVo) {

    }

    @Override
    public void registerBandForEvent(Long eventId, Long bandId) {

        eventRepository.getOne(eventId).setBandId(bandId);

    }

    @Override
    public List<EventVo> getEventsByType(hu.schonherz.training.venue.vo.enums.EventType type) {

        return map(eventRepository.findByType(EventType.valueOf(type.name())), EventVo.class);
    }

    @Override
    public List<EventVo> getFreeSlotEvents() {
        return map(eventRepository.findByType(EventType.FREE_SLOT), EventVo.class);
    }
}
