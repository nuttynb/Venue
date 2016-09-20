package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.landing.vo.remote.RemoteRoleVo;
import hu.schonherz.training.landing.vo.remote.RemoteUserVo;
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
    @ManagedProperty(value = "#{USER}")
    private RemoteUserVo user;
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
    @ManagedProperty(value = "#{publicProfileBean}")
    MBPublicProfile publicProfile;

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
        VenueVo possibleVenue;
        setAdmin();
        isProfileBlocked();
        if (publicProfile.getVenueId() != null) {
            possibleVenue = venueService.getVenueById(publicProfile.getVenueId());
            publicProfile.setDisabled(Boolean.TRUE);
        } else {
            possibleVenue = venueService.getVenueByOwnerId(user.getId());
            publicProfile.setDisabled(Boolean.FALSE);
        }
        if (possibleVenue != null) {
            venueImages.setImages(venueImageService.getVenueImagesByVenueId(possibleVenue.getId()));
            latLng.setLatLng(geocoder.getLatitudeAndLongitudeByAddress(possibleVenue.getAddress()));
            List<EventVo> events = eventService.getEventsByVenueId(possibleVenue.getId());
            if (events != null) {
                schedule.getEventModel()
                        .getEvents()
                        .addAll(events.stream()
                                .map(eventVo -> new EventVoWrapper(eventVo))
                                .collect(Collectors.toList()));
            }
        }
        venue.setVenue(possibleVenue);
        setOwner();
        LOG.info("onLoad completed.");
    }

    private void setAdmin() {
        for (RemoteRoleVo roleVo : user.getRoles()) {
            if ("ADMIN".equals(roleVo.getName())) {
                publicProfile.setAdmin(true);
                System.out.print("admin");
            }
        }
    }

    private void setOwner() {
        if (venue.getVenue() != null) {
            if (user.getId().equals(venue.getVenue().getOwnerId())) {
                publicProfile.setOwner(true);
            }

        }
    }

    public void isProfileBlocked() {
        if (venue.getVenue() != null) {
            publicProfile.setBlocked(venue.getVenue().getEnabled().booleanValue());
        }
    }

    public void blockProfile() {
        LOG.info("Profile enabled:" + publicProfile.isBlocked());
        venue.getVenue().setEnabled(!publicProfile.isBlocked());
        venueService.saveVenue(venue.getVenue());
    }

    public void onModify() {
        LOG.info("Modifying...");
        venueService.saveVenue(venue.getVenue());
    }

    public void onUpdateAfterNewEvent() {
        List<EventVo> events = eventService.getEventsByVenueId(venue.getVenue().getId());
        if (events != null) {
            schedule.getEventModel().clear(); //TODO
            schedule.getEventModel()
                    .getEvents()
                    .addAll(events.stream()
                            .map(eventVo -> new EventVoWrapper(eventVo))
                            .collect(Collectors.toList()));
        }
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

    public RemoteUserVo getUser() {
        return user;
    }

    public void setUser(RemoteUserVo user) {
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

    public MBPublicProfile getPublicProfile() {
        return publicProfile;
    }

    public void setPublicProfile(MBPublicProfile publicProfile) {
        this.publicProfile = publicProfile;
    }
}
