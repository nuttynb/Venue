package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Venue;
import hu.schonherz.training.venue.persistence.repository.VenueRepository;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.VenueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;

/**
 * Created by Roli on 2016. 08. 26..
 */

@Stateless(name = "VenueService", mappedName = "VenueService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.BEAN)
@Local(VenueService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class VenueServiceImpl extends AbstractMappingService implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public void createVenue(VenueVo venueVo) {
        venueRepository.save(map(venueVo, Venue.class));
    }

    @Override
    public VenueVo getVenueByOwnerId(Long ownerId) {
        Venue venue = null;
        venue = venueRepository.findVenueByOwnerId(ownerId);
        if (venue != null) {
            return map(venue, VenueVo.class);
        }
        return null;
    }
}
