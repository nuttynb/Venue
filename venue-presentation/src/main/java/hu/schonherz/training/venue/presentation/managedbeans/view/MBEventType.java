package hu.schonherz.training.venue.presentation.managedbeans.view;


import hu.schonherz.training.venue.vo.enums.EventType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "eventTypeBean")
@ViewScoped
public class MBEventType implements Serializable {

    private static final long serialVersionUID = 23562834658742365L;

    private EventType[] eventType;

    public MBEventType() {
        eventType = EventType.values();
    }

    public EventType[] getEventType() {
        return eventType;
    }

    public void setEventType(EventType[] eventType) {
        this.eventType = eventType;
    }
}
