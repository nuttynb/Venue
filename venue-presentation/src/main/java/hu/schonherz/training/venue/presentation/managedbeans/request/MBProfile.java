package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.session.MBUser;
import hu.schonherz.training.venue.presentation.managedbeans.view.*;
import hu.schonherz.training.venue.presentation.wrappers.EventVoWrapper;
import hu.schonherz.training.venue.service.*;
import hu.schonherz.training.venue.vo.EventVo;
import hu.schonherz.training.venue.vo.OrganizingMailVo;
import hu.schonherz.training.venue.vo.VenueVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "profileBean")
@RequestScoped
public class MBProfile {
    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;
    @ManagedProperty(value = "#{userBean}")
    private MBUser user;
    @ManagedProperty(value = "#{venueImageBean}")
    private MBVenueImage venueImage;
    @ManagedProperty(value = "#{venueImagesBean}")
    private MBVenueImages venueImages;
    @ManagedProperty(value = "#{param.profileImageId}")
    private Long profileImageId;
    @ManagedProperty(value = "#{latLngBean}")
    MBLatLng latLng;
    @ManagedProperty(value = "#{scheduleBean}")
    MBSchedule schedule;
    @ManagedProperty(value = "#{eventBean}")
    MBEvent event;

    private boolean disabled = false;


    @EJB
    VenueService venueService;
    @EJB
    AddressService addressService;
    @EJB
    VenueImageService venueImageService;
    @EJB
    GeocoderService geocoder;
    @EJB
    EventService eventService;

    private static Logger LOG = LoggerFactory.getLogger(MBProfile.class);

    public void onLoad() {
        VenueVo possibleVenue = venueService.getVenueByOwnerId(user.getId());
        if (possibleVenue != null) {
            venueImages.setImages(venueImageService.getVenueImagesByVenueId(possibleVenue.getId()));
            latLng.setLatLng(geocoder.getLatitudeAndLongitudeByAddress(possibleVenue.getAddress()));
            List<EventVo> events = eventService.getEventsByVenueId(possibleVenue.getId());
            if (events != null)
                schedule.getEventModel()
                        .getEvents()
                        .addAll(events.stream()
                                .map(eventVo -> new EventVoWrapper(eventVo))
                                .collect(Collectors.toList()));
        }
        venue.setVenue(possibleVenue);
        LOG.info("onLoad completed.");
    }

    public void onModify() {
        LOG.info("Modifying...");
        venueService.saveVenue(venue.getVenue());
    }

    public void onUpdateAfterNewEvent(){
        List<EventVo> events = eventService.getEventsByVenueId(venue.getVenue().getId());
        if (events != null)
            schedule.getEventModel()
                    .getEvents()
                    .addAll(events.stream()
                            .map(eventVo -> new EventVoWrapper(eventVo))
                            .collect(Collectors.toList()));
    }

    public void onUpdateAfterUploading() {
        venueImages.setImages(venueImageService.getVenueImagesByVenueId(venue.getVenue().getId()));
    }

    public void onUpdateMap() {
        latLng.setLatLng(geocoder.getLatitudeAndLongitudeByAddress(venue.getVenue().getAddress()));
    }

    public void onClickedProfileImage() {
        venue.getVenue().setProfileImage(venueImageService.getVenueImageById(profileImageId));
        venueService.saveVenue(venue.getVenue());
        LOG.info("onClicked - " + profileImageId);
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }

    public VenueService getVenueService() {
        return venueService;
    }

    public void setVenueService(VenueService venueService) {
        this.venueService = venueService;
    }

    public MBUser getUser() {
        return user;
    }

    public void setUser(MBUser user) {
        this.user = user;
    }

    public MBVenueImage getVenueImage() {
        return venueImage;
    }

    public void setVenueImage(MBVenueImage venueImage) {
        this.venueImage = venueImage;
    }

    public Long getProfileImageId() {
        return profileImageId;
    }

    public void setProfileImageId(Long profileImageId) {
        this.profileImageId = profileImageId;
    }

    public MBVenueImages getVenueImages() {
        return venueImages;
    }

    public void setVenueImages(MBVenueImages venueImages) {
        this.venueImages = venueImages;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public MBLatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(MBLatLng latLng) {
        this.latLng = latLng;
    }

    public MBSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MBSchedule schedule) {
        this.schedule = schedule;
    }

    public MBEvent getEvent() {
        return event;
    }

    public void setEvent(MBEvent event) {
        this.event = event;
    }
}
