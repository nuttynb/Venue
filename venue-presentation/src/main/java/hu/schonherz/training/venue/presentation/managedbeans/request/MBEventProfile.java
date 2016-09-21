package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBEvent;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBEventImages;
import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;
import hu.schonherz.training.venue.service.EventImageService;
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
    @ManagedProperty(value = "#{eventImagesBean}")
    MBEventImages image;

    @EJB
    EventService eventService;
    @EJB
    EventImageService eventImageService;

    public void onLoad() {
        if (event.getEventId() != null) {
            image.setImages(eventImageService.getEventImagesByEventId(event.getEventId()));
            event.setEvent(eventService.getEventById(event.getEventId()));
        }
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

    public void onUpdateafterUploading(){
        image.setImages(eventImageService.getEventImagesByEventId(event.getEventId()));
    }

    public MBEvent getEvent() {
        return event;
    }

    public void setEvent(MBEvent event) {
        this.event = event;
    }

    public MBEventImages getImage() {
        return image;
    }

    public void setImage(MBEventImages image) {
        this.image = image;
    }
}
