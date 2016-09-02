package hu.schonherz.training.venue.vo;

import java.io.Serializable;

/**
 * Created by Roli on 2016. 09. 02..
 */
public class VenueImageVo implements Serializable {

    private static final long serialVersionUID = 892012L;

    private Long id;

    private String name;

    private String root;

    private VenueVo venue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public VenueVo getVenue() {
        return venue;
    }

    public void setVenue(VenueVo venue) {
        this.venue = venue;
    }
}
