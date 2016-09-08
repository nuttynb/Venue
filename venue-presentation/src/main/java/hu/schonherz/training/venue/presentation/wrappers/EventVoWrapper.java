package hu.schonherz.training.venue.presentation.wrappers;

import hu.schonherz.training.venue.vo.EventVo;
import org.primefaces.model.ScheduleEvent;

/**
 * Created by Home on 2016. 09. 08..
 */


public class EventVoWrapper {

    public static EventVo toEventVo(ScheduleEvent scheduleEvent){
        EventVo eventVo = new EventVo();
        //eventsVo.setId(Long.parseLong(scheduleEvent.getId()));
        eventVo.setBegin(scheduleEvent.getStartDate());
        eventVo.setEndDate(scheduleEvent.getEndDate());
        eventVo.setName(scheduleEvent.getTitle());

        return eventVo;
    }

}
