package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Venue;
import hu.schonherz.training.venue.persistence.repository.VenueRepository;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.TypeVo;
import hu.schonherz.training.venue.vo.VenueVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Roli on 2016. 08. 26..
 */

@Stateless(name = "VenueService",mappedName = "VenueService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local(VenueService.class)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public List<VenueVo> getAllVenue() {
        return null;
    }

    @Override
    public VenueVo getVenueById(Long id) {
        return null;
    }

    @Override
    public List<VenueVo> getVenueByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<VenueVo> getVenueByName(String name) {
        return null;
    }

    @Override
    public List<VenueVo> getVenueByType(TypeVo type) {
        return null;
    }

    @Override
    public void createVenue(VenueVo venueVo) {
        venueRepository.save(mapper.map(venueVo, Venue.class));
    }

    @Override
    public void deleteVenue(VenueVo venueVo) {

    }
}
