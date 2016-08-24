package hu.schonherz.training.venue.vo;

import hu.schonherz.training.venue.persistence.entity.Address;
import hu.schonherz.training.venue.persistence.entity.Events;
import hu.schonherz.training.venue.persistence.entity.Type;

import java.io.Serializable;
import java.util.Collection;

/**
 * The Vo of Venue.
 */
public class VenueVo implements Serializable {

    private static final long serialVersionUID = 568123L;

    private Long ownerId;

    private String name;

    private String description;

    private Type type;

    private Address address;

    private Collection<Events> events;

    /**
     * Return the id of venue owner.
     *
     * @return the id of venue owner
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * Set the id of venue owner.
     *
     * @param ownerId the id of venue owner
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Return the name of venue.
     *
     * @return the name of venue
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of venue.
     *
     * @param name the name of venue
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the description of venue.
     *
     * @return the description of venue
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of venue.
     *
     * @param description the description of venue
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return the type of venue.
     *
     * @return the type of venue
     */
    public Type getType() {
        return type;
    }

    /**
     * Set the type of venue.
     *
     * @param type the type of venue
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Return the address of venue.
     *
     * @return the address of venue
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address of venue.
     *
     * @param address the address of venue
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Return the collection of events in venue.
     *
     * @return the collection of events in venue
     */
    public Collection<Events> getEvents() {
        return events;
    }

    /**
     * Set the collection of events in venue.
     *
     * @param events the collection of events in venue.
     */
    public void setEvents(Collection<Events> events) {
        this.events = events;
    }
}
