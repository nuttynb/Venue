package hu.schonherz.training.venue.presentation.managedbeans.view;


import hu.schonherz.training.venue.vo.enums.EventType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "eventTypeBean")
@ViewScoped
public class MBEventType implements Serializable {

    private static final long serialVersionUID = 23562834658742365L;

    private List<EventType> eventType = new ArrayList<>();

    public MBEventType() {
        eventType = Arrays.asList(EventType.values());
    }

    public List<EventType> getEventType() {
        return eventType;
    }

    public void setEventType(List<EventType> eventType) {
        this.eventType = eventType;
    }
}
