package hu.schonherz.training.venue.vo;

import java.io.Serializable;

/**
 * The Vo of Address.
 */
public class AddressVo implements Serializable {

    private static final long serialVersionUID = 125312L;

    private Long venueId;

    private String country;

    private String city;

    private String street;

    private String number;

    private int postcode;

    /**
     * Return the id of venue.
     *
     * @return the id of venue
     */
    public Long getVenueId() {
        return venueId;
    }

    /**
     * Set the id of venue.
     *
     * @param venueId the id of venue
     */
    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    /**
     * Return the country of venue.
     *
     * @return the country of venue
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country of venue.
     *
     * @param country the country of venue
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Return the city of venue.
     *
     * @return the city of venue
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city of venue.
     *
     * @param city the city of venue
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Return the street of venue.
     *
     * @return the street of venue
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street of venue.
     *
     * @param street the street of venue
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Return the number of venue.
     *
     * @return the number of venue
     */
    public String getNumber() {
        return number;
    }

    /**
     * Set the number of venue.
     *
     * @param number the number of venue
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Return the postcode of venue.
     *
     * @return the postcode of venue
     */
    public int getPostcode() {
        return postcode;
    }

    /**
     * Set the postcode of venue.
     *
     * @param postcode the postcode of venue
     */
    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
