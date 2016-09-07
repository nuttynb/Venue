package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Home on 2016. 08. 23..
 */

@Entity
@Table(name = "event")
public class Events extends BaseEntity {

    @ManyToOne
    @JoinColumn(name ="venue_id")
    private Venue venue;

    @Basic
    @Column(nullable = false)
    private Long bandId;

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false, name = "date", columnDefinition = "TIMESTAMP(0)")
    @Temporal(TemporalType.TIMESTAMP)
    public Date date;

    @Basic
    private String description;

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
