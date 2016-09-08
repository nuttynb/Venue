package hu.schonherz.training.venue.presentation.wrappers;

import hu.schonherz.training.venue.vo.EventVo;
import hu.schonherz.training.venue.vo.VenueVo;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Home on 2016. 09. 08..
 */


public class EventVoWrapper {

    private static Logger LOG = LoggerFactory.getLogger(EventVoWrapper.class);


    public static EventVo toEventVo(ScheduleEvent scheduleEvent, VenueVo venueVo){
        EventVo eventVo = new EventVo();

        eventVo.setVenue(venueVo);
        eventVo.setBeginDate(scheduleEvent.getStartDate());
        eventVo.setEndDate(scheduleEvent.getEndDate());
        eventVo.setName(scheduleEvent.getTitle());
        eventVo.setDescription(scheduleEvent.getDescription());

        return eventVo;
    }

    public static ScheduleEvent toScheduleEvent(EventVo eventVo){

        ScheduleEvent scheduleEvent = new DefaultScheduleEvent(eventVo.getName(),eventVo.getBeginDate(),eventVo.getEndDate(),eventVo);

        return scheduleEvent;

    }

}
