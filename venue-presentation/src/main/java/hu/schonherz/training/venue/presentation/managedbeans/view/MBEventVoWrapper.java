package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "eventVoWrapperBean")
@ViewScoped
public class MBEventVoWrapper implements Serializable {

    private static final long serialVersionUID = -4611233140750186769L;

    EventVoWrapper event = new EventVoWrapper();

    private boolean promotion;

    public EventVoWrapper getEvent() {
        return event;
    }

    public void setEvent(EventVoWrapper event) {
        this.event = event;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
