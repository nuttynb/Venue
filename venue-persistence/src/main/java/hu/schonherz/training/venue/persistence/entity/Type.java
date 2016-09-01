package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Home on 2016. 08. 23..
 */
@Entity
@Table(name = "type")
public class Type extends BaseEntity {

    @Column(nullable = false)
    private String name;

    //@OneToOne(mappedBy = "type")
    //private Venue venue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
