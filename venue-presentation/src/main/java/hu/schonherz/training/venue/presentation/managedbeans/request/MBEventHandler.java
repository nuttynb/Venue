package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.*;
import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;
import hu.schonherz.training.venue.service.EventService;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "eventHandler")
@RequestScoped
public class MBEventHandler implements Serializable {

    private static final long serialVersionUID = 6146151326262641557L;

    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;

    @ManagedProperty(value = "#{scheduleBean}")
    private MBSchedule schedule;

    @ManagedProperty(value = "#{eventVoWrapperBean}")
    MBEventVoWrapper event;

    @EJB
    private EventService eventService;


    private static Logger LOG = LoggerFactory.getLogger(MBEventHandler.class);

    @PostConstruct
    public void init() {
        if (!event.getEvent().getEventVo().isPromotion()) {
            event.getEvent().getEventVo().setAmount(0.0);
            event.getEvent().getEventVo().setPromoDescription("");
            event.getEvent().getEventVo().setPercent(0.0);
        }
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getEvent().getId() == null) {
            schedule.getEventModel().addEvent(event.getEvent());
        } else {
            schedule.getEventModel().updateEvent(event.getEvent());
        }
        event.getEvent().getEventVo().setVenue(venue.getVenue());
        //selectColour();
        eventService.createEvent(event.getEvent().getEventVo());

    }

    public void onEventSelect(SelectEvent selectEvent) {
        event.setEvent((EventVoWrapper) selectEvent.getObject());
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event.setEvent(new EventVoWrapper((Date) selectEvent.getObject()));
    }
/*
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
*/

    public void selectColour(){
        switch(event.getEvent().getEventVo().getType().name()){
            case "FREE_SLOT" :
                event.getEvent().setStyleClass("open");
            case "BOOKED_EVENT" :
                event.getEvent().setStyleClass("booked");
            case "DRINK_PROMOTION" :
                event.getEvent().setStyleClass("promotion");
        }
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public MBEventVoWrapper getEvent() {
        return event;
    }

    public void setEvent(MBEventVoWrapper event) {
        this.event = event;
    }

    public MBSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MBSchedule schedule) {
        this.schedule = schedule;
    }

}
