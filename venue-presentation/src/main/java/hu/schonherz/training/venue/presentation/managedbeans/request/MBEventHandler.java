package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBSchedule;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;
import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;
import hu.schonherz.training.venue.service.EventService;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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

    @EJB
    private EventService eventService;

    private boolean promotion;

    private EventVoWrapper event = new EventVoWrapper();

    private static Logger LOG = LoggerFactory.getLogger(MBEventHandler.class);

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            schedule.getEventModel().addEvent(event);
        } else {
            schedule.getEventModel().updateEvent(event);
        }
        event.getEventVo().setVenue(venue.getVenue());
        LOG.info("!!!!!" + event.getEventVo().getPromoDescripton());
        LOG.info(";;;;;;;" + event.getEventVo().getAmount());
        LOG.info("________" + event.getEventVo().getPercent());
        eventService.createEvent(event.getEventVo());

    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (EventVoWrapper) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new EventVoWrapper((Date) selectEvent.getObject());
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

    public EventVoWrapper getEvent() {
        return event;
    }

    public void setEvent(EventVoWrapper event) {
        this.event = event;
    }

    public MBSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MBSchedule schedule) {
        this.schedule = schedule;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
