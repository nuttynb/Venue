package hu.schonherz.training.venue.presentation.wrappers;

import hu.schonherz.training.venue.vo.EventVo;
import org.primefaces.model.ScheduleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Home on 2016. 09. 08..
 */


public class EventVoWrapper {

    private static Logger LOG = LoggerFactory.getLogger(EventVoWrapper.class);


    public static EventVo toEventVo(ScheduleEvent scheduleEvent){
        EventVo eventVo = new EventVo();
        //eventsVo.setId(Long.parseLong(scheduleEvent.getId()));
        eventVo.setBeginDate(scheduleEvent.getStartDate());
        eventVo.setEndDate(scheduleEvent.getEndDate());
        eventVo.setName(scheduleEvent.getTitle());
        eventVo.setDescription(scheduleEvent.getDescription());
        LOG.info(scheduleEvent.toString());
        LOG.info(String.valueOf(eventVo.getBeginDate()));

        return eventVo;
    }

}
