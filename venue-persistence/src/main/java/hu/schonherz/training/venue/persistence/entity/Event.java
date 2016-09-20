package hu.schonherz.training.venue.persistence.entity;

import hu.schonherz.training.venue.persistence.entity.enums.EventType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Basic
    //@Column(nullable = false)
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

    @Basic
    private String promoDescription;

    @Basic
    private double amount;

    @Basic
    private double percent;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType type;

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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
