package hu.schonherz.training.venue.presentation.managedbeans;

import copyofvofortest.VenueVo;
import org.primefaces.event.FlowEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class VenueWizard {
    private VenueVo venue = new VenueVo();

    public void save() {
        FacesMessage msg = new FacesMessage("Successful", venue.getName() + " venue is created.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public VenueVo getVenue() {
        return venue;
    }

    public void setVenue(VenueVo venue) {
        this.venue = venue;
    }
}
