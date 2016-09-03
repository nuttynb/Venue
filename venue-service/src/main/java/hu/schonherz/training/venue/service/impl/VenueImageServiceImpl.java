package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.VenueImage;
import hu.schonherz.training.venue.persistence.repository.VenueImageRepository;
import hu.schonherz.training.venue.service.VenueImageService;
import hu.schonherz.training.venue.vo.VenueImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Home on 2016. 09. 03..
 */

@Stateless(name = "VenueImageService", mappedName = "VenueImageService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.BEAN)
@Local(VenueImageService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class VenueImageServiceImpl extends AbstractMappingService implements VenueImageService{

    @Autowired
    private VenueImageRepository venueImageRepository;

    @Override
    public void createVenueImage(VenueImageVo venueImageVo) {
        venueImageRepository.save(map(venueImageVo, VenueImage.class));
    }

    @Override
    public List<VenueImageVo> getVenueImageByVenueId(Long venueId) {
        return null;
    }
}
