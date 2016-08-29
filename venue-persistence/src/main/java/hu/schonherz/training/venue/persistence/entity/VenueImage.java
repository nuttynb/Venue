package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;

/**
 * Created by Home on 2016. 08. 29..
 */

@Entity
@Table(name = "venuepictures")
public class VenueImage extends BaseEntity{

    @Basic
    @Column(nullable = false)
    private String name;

    @Lob
    @Column(length = 10000)
    private byte[] data;

    @Basic
    @Column(nullable = false)
    private Long venueId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
