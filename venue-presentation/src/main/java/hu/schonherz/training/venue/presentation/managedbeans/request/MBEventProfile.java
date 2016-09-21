package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBEvent;
import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;
import hu.schonherz.training.venue.service.EventService;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "eventProfileBean")
@RequestScoped
public class MBEventProfile {
    @ManagedProperty(value = "#{eventBean}")
    MBEvent event;
    @EJB
    EventService eventService;

    public void onLoad() {
        event.setEvent(eventService.getEventById(event.getEventId()));
    }

    public void onShowEvent(SelectEvent selectEvent) {
        EventVoWrapper eventVoWrapper = (EventVoWrapper) selectEvent.getObject();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("event.xhtml?eventid=" + eventVoWrapper.getEventVo().getId());
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MBEvent getEvent() {
        return event;
    }

    public void setEvent(MBEvent event) {
        this.event = event;
    }
}
