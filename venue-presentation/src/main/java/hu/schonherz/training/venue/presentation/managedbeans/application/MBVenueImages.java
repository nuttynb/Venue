package hu.schonherz.training.venue.presentation.managedbeans.application;

import hu.schonherz.training.venue.service.VenueImageService;
import hu.schonherz.training.venue.vo.VenueImageVo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@ManagedBean(name = "venueImages")
@ApplicationScoped
public class MBVenueImages {
    @EJB
    VenueImageService venueImageService;
    private static Logger LOG = LoggerFactory.getLogger(MBVenueImages.class);

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String imageId = context.getExternalContext().getRequestParameterMap().get("imageId");
            LOG.info(imageId);
            VenueImageVo image = venueImageService.getVenueImageById(Long.valueOf(imageId));
            LOG.info(image.getRoot());
            return new DefaultStreamedContent(new FileInputStream(Paths.get(image.getRoot()).toFile()), "image/png", image.getName());
        }
    }
}