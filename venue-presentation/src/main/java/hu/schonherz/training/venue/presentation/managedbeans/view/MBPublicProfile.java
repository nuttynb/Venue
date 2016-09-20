package hu.schonherz.training.venue.presentation.managedbeans.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "publicProfileBean")
@ViewScoped
public class MBPublicProfile implements Serializable {
    private static final long serialVersionUID = 3120995162929031446L;
    private Long venueId = null;
    private boolean disabled = false;
    private boolean isAdmin;
    private boolean isOwner;
    private boolean isBlocked;

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
