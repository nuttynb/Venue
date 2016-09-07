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
    @Column(nullable = false, name = "begin_date", columnDefinition = "TIMESTAMP(0)")
    @Temporal(TemporalType.TIMESTAMP)
    private Date begin;

    @Basic
    @Column(nullable = false, name = "end_date", columnDefinition = "TIMESTAMP(0)")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
