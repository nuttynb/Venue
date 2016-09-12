package hu.schonherz.training.venue.presentation.wrappers;

import hu.schonherz.training.venue.service.TypeService;
import hu.schonherz.training.venue.vo.EventVo;
import hu.schonherz.training.venue.vo.TypeVo;
import hu.schonherz.training.venue.vo.VenueVo;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Home on 2016. 09. 08..
 */


public class EventVoWrapper extends DefaultScheduleEvent {

    private static Logger LOG = LoggerFactory.getLogger(EventVoWrapper.class);

    private EventVo eventVo;

    public EventVoWrapper(EventVo eventVo) {
        this.eventVo = eventVo;
    }

    public EventVoWrapper() {
        eventVo = new EventVo();
    }

    public EventVoWrapper(Date object) {
        eventVo = new EventVo();
        eventVo.setBeginDate(object);
        eventVo.setEndDate(object);
    }

    public EventVo getEventVo() {
        return eventVo;
    }

    @Override
    public String getId() {
        return String.valueOf(eventVo.getId());
    }

    @Override
    public void setId(String id) {
        eventVo.setId(Long.valueOf(id));
    }

    @Override
    public String getTitle() {
        return eventVo.getName();
    }

    @Override
    public void setTitle(String title) {
        eventVo.setName(title);
    }

    @Override
    public Date getStartDate() {
        return eventVo.getBeginDate();
    }

    @Override
    public void setStartDate(Date startDate) {
        eventVo.setBeginDate(startDate);
    }

    @Override
    public Date getEndDate() {
        return eventVo.getEndDate();
    }

    @Override
    public void setEndDate(Date endDate) {
        eventVo.setEndDate(endDate);
    }

    @Override
    public Object getData() {
        return eventVo;
    }

    @Override
    public void setData(Object data) {
        eventVo = (EventVo) data;
    }

    @Override
    public String getDescription() {
        return eventVo.getDescription();
    }

    @Override
    public void setDescription(String description) {
        eventVo.setDescription(description);
    }

    public void setType(TypeVo eventTypeVo) {
        eventVo.setType(eventTypeVo);
    }

    public TypeVo getType() {
        return eventVo.getType();
    }
}
