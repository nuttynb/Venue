package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.VenueImageVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Home on 2016. 09. 04..
 */

@ManagedBean(name = "venueImageBean")
@ViewScoped
public class MBVenueImage implements Serializable{

    private static final long serialVersionUID = 3458459324382189349L;

    private VenueImageVo venueImage = new VenueImageVo();

    public VenueImageVo getVenueImage() {
        return venueImage;
    }

    public void setVenueImage(VenueImageVo venueImage) {
        this.venueImage = venueImage;
    }
}
