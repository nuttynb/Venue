package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.ejb.remote.stateless.VenueRemoteService;
import hu.schonherz.training.venue.persistence.entity.Venue;
import hu.schonherz.training.venue.persistence.repository.VenueRepository;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.VenueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "VenueService", mappedName = "VenueService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(VenueService.class)
@Remote(VenueRemoteService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class VenueServiceImpl extends AbstractMappingService implements VenueService, VenueRemoteService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public void saveVenue(VenueVo venueVo) {
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

    @Override
    public VenueVo getVenueById(Long venueId) {
        Venue venue = null;
        venue = venueRepository.findById(venueId);
        if (venue != null) {
            return map(venue, VenueVo.class);
        }
        return null;
    }

    @Override
    public List<VenueVo> getAllVenues() {
        return map(venueRepository.findAll(), VenueVo.class);
    }

    @Override
    public List<VenueVo> getVenuesWithPaging(int page, int pageSize) {
        Pageable pageable = new PageRequest(page, pageSize);
        return map(venueRepository.findAll(pageable).getContent(), VenueVo.class);
    }
}
