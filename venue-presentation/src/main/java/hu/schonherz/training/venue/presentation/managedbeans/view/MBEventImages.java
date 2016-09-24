package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.EventImageVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "eventImagesBean")
@ViewScoped
public class MBEventImages implements Serializable {

    private static final long serialVersionUID = -5454332432324443323L;

    List<EventImageVo> images = new ArrayList<>();

    public MBEventImages() {
    }

    public List<EventImageVo> getImages() {
        return images;
    }

    public void setImages(List<EventImageVo> images) {
        this.images = images;
    }
}
