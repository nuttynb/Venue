package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;
import hu.schonherz.training.venue.vo.EventVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "eventBean")
@ViewScoped
public class MBEvent implements Serializable {

    private static final long serialVersionUID = 438657824362578L;

    List<EventVoWrapper> event = new ArrayList();

    public List<EventVoWrapper> getEvent() {
        return event;
    }

    public void setEvent(List<EventVoWrapper> event) {
        this.event = event;
    }
}
