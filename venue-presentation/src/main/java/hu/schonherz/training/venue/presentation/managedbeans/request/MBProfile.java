package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.session.MBUser;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenueImage;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenueImages;
import hu.schonherz.training.venue.service.AddressService;
import hu.schonherz.training.venue.service.VenueImageService;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.VenueImageVo;
import hu.schonherz.training.venue.vo.VenueVo;
import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.nio.file.*;


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

    @EJB
    VenueService venueService;
    @EJB
    AddressService addressService;
    @EJB
    VenueImageService venueImageService;

    private static Logger LOG = LoggerFactory.getLogger(MBProfile.class);

    public void onLoad() {
        //if (user.getId() == null) {
        //    FacesContext fc = FacesContext.getCurrentInstance();
        //    fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "error");
        //}
        VenueVo possibleVenue = venueService.getVenueByOwnerId(user.getId());
        if (possibleVenue != null) {
            venueImages.setImages(venueImageService.getVenueImagesByVenueId(possibleVenue.getId()));
        }
        venue.setVenue(possibleVenue);
        LOG.info("onLoad completed.");
    }

    public void onModify() {
        LOG.info("Modifying...");
        venueService.saveVenue(venue.getVenue());
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
}
