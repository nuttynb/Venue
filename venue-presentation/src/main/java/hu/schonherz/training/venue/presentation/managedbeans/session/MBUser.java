package hu.schonherz.training.venue.presentation.managedbeans.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "userBean")
@SessionScoped
public class MBUser implements Serializable {
    private static final long serialVersionUID = 7869189274417139148L;

    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
