package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Type;
import hu.schonherz.training.venue.persistence.entity.Venue;
import hu.schonherz.training.venue.persistence.repository.VenueRepository;
import hu.schonherz.training.venue.service.VenueService;
import hu.schonherz.training.venue.vo.VenueVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Roli on 2016. 08. 26..
 */

@Service
@Transactional
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
    public List<VenueVo> getVenueByType(Type type) {
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
