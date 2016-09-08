package hu.schonherz.training.venue.presentation.managedbeans.view;


import hu.schonherz.training.venue.service.VenueImageService;
import hu.schonherz.training.venue.vo.VenueImageVo;
import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@ManagedBean(name = "fileUploadBean")
@ViewScoped
public class MBFileUpload {

    @ManagedProperty(value = "#{venueBean}")
    private MBVenue venue;

    @EJB
    VenueImageService venueImageService;

    private static Logger LOG = LoggerFactory.getLogger(MBFileUpload.class);

    public void fileUpload(FileUploadEvent event) {
        FacesMessage message;
        try {
            createFile(event.getFile().getFileName(), event.getFile().getInputstream());
            LOG.info("File uploaded.");
            message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        } catch (IOException e) {
            LOG.error("Upload failed on creating files.", e);
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed uploading.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void createFile(String fileName, InputStream input) throws IOException {
        File destination = new File(System.getProperty("user.dir") + File.separator +
                "venue" + File.separator + venue.getVenue().getId().toString());
        destination.mkdirs();
        Path absPath = Paths.get(destination + File.separator + fileName);

        Files.copy(input, absPath, StandardCopyOption.REPLACE_EXISTING);
        saveImageInDb(absPath.toString(), fileName);
    }

    public void saveImageInDb(String path, String fileName) {
        VenueImageVo venueImageVo = new VenueImageVo();
        venueImageVo.setName(fileName);
        venueImageVo.setRoot(path);
        venueImageVo.setVenue(venue.getVenue());
        venueImageService.saveVenueImage(venueImageVo);
    }

    public MBVenue getVenue() {
        return venue;
    }

    public void setVenue(MBVenue venue) {
        this.venue = venue;
    }

    public VenueImageService getVenueImageService() {
        return venueImageService;
    }

    public void setVenueImageService(VenueImageService venueImageService) {
        this.venueImageService = venueImageService;
    }
}
