package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Basic
    @Column(nullable = false)
    private Long bandId;

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false, name = "begin_date")
    private Date beginDate;

    @Basic
    @Column(nullable = false, name = "end_date")
    private Date endDate;

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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
