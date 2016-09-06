package hu.schonherz.training.venue.presentation.managedbeans.view;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Home on 2016. 09. 06..
 */

@ManagedBean(name = "scheduleBean")
@ViewScoped
public class MBSchedule implements Serializable{

    private static final long serialVersionUID = 1237458387432819321L;

    private ScheduleModel eventModel;

    private LazyScheduleModel lazyEventModel;

    private ScheduleModel event = new DefaultScheduleModel();

    @PostConstruct
    public void init(){
        eventModel = new DefaultScheduleModel();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public LazyScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public ScheduleModel getEvent() {
        return event;
    }

    public void setEvent(ScheduleModel event) {
        this.event = event;
    }
}
