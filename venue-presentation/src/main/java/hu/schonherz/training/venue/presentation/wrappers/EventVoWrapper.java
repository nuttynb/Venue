package hu.schonherz.training.venue.presentation.wrappers;

import hu.schonherz.training.venue.service.TypeService;
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
    
    private static TypeService typeService;

    public static EventVo toEventVo(ScheduleEvent scheduleEvent, VenueVo venueVo){
        EventVo eventVo = new EventVo();

        eventVo.setVenue(venueVo);
        eventVo.setBeginDate(scheduleEvent.getStartDate());
        eventVo.setEndDate(scheduleEvent.getEndDate());
        eventVo.setName(scheduleEvent.getTitle());
        eventVo.setDescription(scheduleEvent.getDescription());
        //eventVo.setType(typeService.getTypeById(Long.parseLong(scheduleEvent.getStyleClass())));

        //LOG.info(typeService.getTypeById(Long.valueOf(scheduleEvent.getStyleClass())).getName());


        return eventVo;
    }

    public static ScheduleEvent toScheduleEvent(EventVo eventVo){

        ScheduleEvent scheduleEvent = new DefaultScheduleEvent(eventVo.getName(),eventVo.getBeginDate(),eventVo.getEndDate(),eventVo);

        return scheduleEvent;

    }


    public static TypeService getTypeService() {
        return typeService;
    }

    public static void setTypeService(TypeService typeService) {
        EventVoWrapper.typeService = typeService;
    }
}
