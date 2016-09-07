package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Events;
import hu.schonherz.training.venue.persistence.repository.EventsRepository;
import hu.schonherz.training.venue.service.EventsService;
import hu.schonherz.training.venue.vo.EventsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.Date;
import java.util.List;


@Stateless(name = "EventsService", mappedName = "EventsService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.BEAN)
@Local(EventsService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class EventsServiceImpl extends AbstractMappingService implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<EventsVo> getAllEvents() {
        return null;
    }

    @Override
    public EventsVo getEventById(Long id) {
        return null;
    }

    @Override
    public List<EventsVo> getEventByVenueId(Long venueid) {
        return null;
    }

    @Override
    public EventsVo getEventByVenueIdAndDate(Long venueid, Date date) {
        Events event = null;
        event = eventsRepository.findByVenue_IdAndDate(venueid, date);
        if (event != null) {
            return map(event, EventsVo.class);
        }
        return null;
    }

    @Override
    public List<EventsVo> getEventByBandId(Long bandId) {
        return null;
    }

    @Override
    public List<EventsVo> getEventByName(String name) {
        return null;
    }

    @Override
    public List<EventsVo> getEventByDate(Date date) {
        return null;
    }

    @Override
    public void createEvent(EventsVo eventsVo) {
        eventsRepository.save(map(eventsVo, Events.class));
    }

    @Override
    public void deleteEvent(EventsVo eventsVo) {

    }
}
