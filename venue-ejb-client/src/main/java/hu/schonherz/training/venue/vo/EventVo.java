package hu.schonherz.training.venue.vo;

import hu.schonherz.training.venue.vo.enums.EventType;

import java.io.Serializable;
import java.util.Date;

/**
 * The Vo of Events.
 */
public class EventVo implements Serializable {

    private static final long serialVersionUID = 383913L;

    private Long id;

    private VenueVo venue;

    private Long bandId;

    private String name;

    private Date beginDate;

    private Date endDate;

    private String description;

    private boolean promotion = false;

    private String promoDescription;

    private double amount;

    private double percent;

    private EventType type;

    /**
     * Return the id of event.
     *
     * @return the id of event
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id of event.
     *
     * @param id the id of event
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Return the id of events place.
     *
     * @return the event's venue
     */
    public VenueVo getVenue() {
        return venue;
    }

    /**
     * Set the id of events place.
     *
     * @param venue the venue of the event
     */
    public void setVenue(VenueVo venue) {
        this.venue = venue;
    }

    /**
     * Return the id of performer band.
     *
     * @return the id of band
     */
    public Long getBandId() {
        return bandId;
    }

    /**
     * Set the id of performer band.
     *
     * @param bandId the id of band
     */
    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    /**
     * Return the name of event.
     *
     * @return the name of event
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of event.
     *
     * @param name the name of event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the date of event.
     *
     * @return the date of event
     */
    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set the date of event.
     *
     * @param begin the date of event
     */
    public void setBeginDate(Date begin) {
        this.beginDate = begin;
    }

    public void setEndDate(Date end) {
        this.endDate = end;
    }

    /**
     * Return the description of event.
     *
     * @return the description of event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of event.
     *
     * @param description the description of event
     */
    public void setDescription(String description) {
        this.description = description;
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

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
