package hu.schonherz.training.venue.presentation.managedbeans.application;

import hu.schonherz.training.venue.service.VenueImageService;
import hu.schonherz.training.venue.vo.VenueImageVo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@ManagedBean(name = "venueImagesLoader")
@ApplicationScoped
public class MBVenueImagesLoader {
    @EJB
    VenueImageService venueImageService;

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();

        } else {
            String imageId = context.getExternalContext().getRequestParameterMap().get("imageId");

            VenueImageVo image = venueImageService.getVenueImageById(Long.valueOf(imageId));
            return new DefaultStreamedContent(new FileInputStream(Paths.get(image.getRoot()).toFile()), "image/png", image.getName());
        }
    }
}
