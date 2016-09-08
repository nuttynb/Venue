package hu.schonherz.training.venue.presentation.wrappers;

import hu.schonherz.training.venue.vo.EventsVo;
import org.primefaces.model.ScheduleEvent;

/**
 * Created by Home on 2016. 09. 08..
 */


public class EventVoWrapper {

    public static EventsVo toEventVo(ScheduleEvent scheduleEvent){
        EventsVo eventsVo = new EventsVo();
        //eventsVo.setId(Long.parseLong(scheduleEvent.getId()));
        eventsVo.setBegin(scheduleEvent.getStartDate());
        eventsVo.setEndDate(scheduleEvent.getEndDate());
        eventsVo.setName(scheduleEvent.getTitle());

        return eventsVo;
    }

}
