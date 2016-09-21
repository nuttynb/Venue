package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "eventImage")
public class EventImage extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String root;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
