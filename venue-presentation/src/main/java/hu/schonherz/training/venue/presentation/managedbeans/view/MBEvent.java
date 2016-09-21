package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.EventVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "eventBean")
@ViewScoped
public class MBEvent implements Serializable {

    private static final long serialVersionUID = 8682293322193139048L;

    Long eventId;

    EventVo event;

    public EventVo getEvent() {
        return event;
    }

    public void setEvent(EventVo event) {
        this.event = event;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

}
