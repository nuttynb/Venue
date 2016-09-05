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
import javax.faces.event.SystemEvent;
import java.io.*;
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
        if (possibleVenue != null) {
            possibleVenue.setImages(venueImageService.getVenueImageByVenueId(possibleVenue.getId()));

        }
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
        try {
            createFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName, InputStream input) throws IOException {
        File destination = new File(System.getProperty("user.dir") + File.separator +
                "venue" + File.separator + venue.getVenue().getId().toString());
        destination.mkdirs();
        File file = new File(destination + File.separator + fileName);
        String absPath = file.getAbsolutePath().toString();
        OutputStream out = new FileOutputStream(file);

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = input.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        input.close();
        out.flush();
        out.close();
        setImageInDb(absPath, fileName);
    }

    public void setImageInDb(String path, String fileName) {
        VenueImageVo venueImageVo = new VenueImageVo();
        venueImageVo.setName(fileName);
        venueImageVo.setRoot(path);
        venueImageVo.setVenue(venue.getVenue());
        venueImageService.createVenueImage(venueImageVo);
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
