package hu.schonherz.training.venue.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @OneToOne(mappedBy = "address")
    private Venue venue;

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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
