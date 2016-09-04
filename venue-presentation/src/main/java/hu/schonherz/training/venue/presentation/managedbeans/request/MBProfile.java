package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.session.MBUser;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenue;
import hu.schonherz.training.venue.presentation.managedbeans.view.MBVenueImage;
import hu.schonherz.training.venue.service.AddressService;
import hu.schonherz.training.venue.service.VenueImageService;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.VenueImageVo;
import hu.schonherz.training.venue.vo.VenueVo;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@ManagedBean(name = "profileBean")
@RequestScoped
public class MBProfile {
    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;
    @ManagedProperty(value = "#{userBean}")
    private MBUser user;
    @ManagedProperty(value = "#{venueImageBean}")
    private MBVenueImage venueImage;

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
        venue.setVenue(possibleVenue);

        LOG.info("onLoad completed.");
    }

    public void onModify() {
        LOG.info("Modifying...");
        venueService.createVenue(venue.getVenue());
    }

    public void fileUpload(FileUploadEvent event) throws IOException {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        UploadedFile uploadedFile = event.getFile();
        Path folder = Paths.get("D:\\Project2\\uploads");
        VenueImageVo venueImageVo = new VenueImageVo();
        venueImageVo.setName(FilenameUtils.getBaseName(uploadedFile.getFileName()));
        venueImageVo.setRoot("D:\\Project2\\uploads" + File.separator + uploadedFile.getFileName());
        venueImageVo.setVenue(venue.getVenue());
        venueImageService.createVenueImage(venueImageVo);
        String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
        Path file = Files.createTempFile(folder, venueImageVo.getName() +  "-", "." + extension);
        try (InputStream input = uploadedFile.getInputstream()){
            Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
        }
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
}
