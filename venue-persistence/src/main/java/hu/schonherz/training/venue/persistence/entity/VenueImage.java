package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "venueImage")
public class VenueImage extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String root;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
