package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.session.MBUser;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.VenueVo;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "profileBean")
@RequestScoped
public class MBProfile {
    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;
    @ManagedProperty(value = "#{userBean}")
    private MBUser user;

    @EJB
    VenueService venueService;
    private static Logger LOG = LoggerFactory.getLogger(MBProfile.class);

    public void onLoad() {
        if (new Long(1).equals(user.getId())) {
            VenueVo test = new VenueVo();
            test.setId(new Long(1));
            test.setName("myvenue");
            test.setDescription("Teszt eset adatbázisból töltődik fel");
            venue.setVenue(test);
        } else {
            venue.setVenue(null);
        }
        LOG.info("onLoad lefutott.");
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }

    public VenueService getVenueService() {
        return venueService;
    }

    public void setVenueService(VenueService venueService) {
        this.venueService = venueService;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }
}
