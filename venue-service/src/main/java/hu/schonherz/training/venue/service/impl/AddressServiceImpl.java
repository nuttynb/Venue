package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Address;
import hu.schonherz.training.venue.persistence.repository.AddressRepository;
import hu.schonherz.training.venue.service.AddressService;
import hu.schonherz.training.venue.vo.AddressVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Roli on 2016. 08. 26..
 */

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addresRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public AddressVo getAddressByVenueId(Long id) {
        return null;
    }

    @Override
    public void createAddress(AddressVo addressVo) {
        addresRepository.save(mapper.map(addressVo, Address.class));
    }
}
