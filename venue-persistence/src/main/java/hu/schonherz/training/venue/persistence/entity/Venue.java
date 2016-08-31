package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Home on 2016. 08. 23..
 */

@Entity
@Table(name = "Venue")
public class Venue extends BaseEntity {

    @Basic
   // @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private String name;

    @Basic
    private String description;

    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne
    @JoinColumn(name = "venueId")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "venueId", nullable = false)
    private Collection<Events> events;


    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<Events> getEvents() {
        return events;
    }

    public void setEvents(Collection<Events> events) {
        this.events = events;
    }
}