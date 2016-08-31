package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;

/**
 * Created by Home on 2016. 08. 23..
 */

@Entity
@Table(name = "Address")
public class Address extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private Long venueId;

    @Basic
    @Column(nullable = false)
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
    private Integer postcode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
