package hu.schonherz.training.venue.presentation.managedbeans.view;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "scheduleBean")
@ViewScoped
public class MBSchedule implements Serializable {

    private static final long serialVersionUID = 1237458387432819321L;

    private ScheduleModel eventModel;

    private static Logger LOG = LoggerFactory.getLogger(MBSchedule.class);

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
    }


    public ScheduleModel getEventModel() {
        return eventModel;
    }

}
