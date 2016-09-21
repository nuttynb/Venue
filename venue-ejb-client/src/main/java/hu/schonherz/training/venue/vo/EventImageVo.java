package hu.schonherz.training.venue.vo;


import java.io.Serializable;

public class EventImageVo implements Serializable{

    private static final long serialVersionUID = 3212241112334141212L;

    private Long id;

    private String name;

    private String root;

    private EventVo event;

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

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public EventVo getEvent() {
        return event;
    }

    public void setEvent(EventVo event) {
        this.event = event;
    }
}