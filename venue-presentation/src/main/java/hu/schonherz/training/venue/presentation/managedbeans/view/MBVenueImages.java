package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.VenueImageVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "venueImagesBean")
@ViewScoped
public class MBVenueImages implements Serializable {

    private static final long serialVersionUID = -6900437474056199453L;
    List<VenueImageVo> images = new ArrayList<>();

    public List<VenueImageVo> getImages() {
        return images;
    }

    public void setImages(List<VenueImageVo> images) {
        this.images = images;
    }
}
