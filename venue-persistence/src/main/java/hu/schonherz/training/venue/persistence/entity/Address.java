package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Home on 2016. 08. 23..
 */

@Entity
@Table(name = "Address")
public class Address extends BaseEntity {

    @Basic
    private Long venueId;

    @Basic
    @Column
    private String country;

    @Basic
    @Column(nullable = false)
    private String city;

    @Basic
    @Column(nullable = false)
    private String street;

    @Basic
    @Column(nullable = false)
    private String number;

    @Basic
    @Column(nullable = false)
    private int postcode;

    public Long getVenueId() {
        return venueId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
