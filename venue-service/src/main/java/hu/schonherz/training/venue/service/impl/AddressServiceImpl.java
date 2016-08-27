package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Address;
import hu.schonherz.training.venue.persistence.repository.AddressRepository;
import hu.schonherz.training.venue.service.AddressService;
import hu.schonherz.training.venue.vo.AddressVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;

/**
 * Created by Roli on 2016. 08. 26..
 */


@Stateless(name = "AddressService", mappedName = "AddressService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local(AddressService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class AddressServiceImpl extends AbstractMappingService implements AddressService {

    @Autowired
    private AddressRepository addresRepository;

    @Override
    public AddressVo getAddressByVenueId(Long id) {
        return null;
    }

    @Override
    public void createAddress(AddressVo addressVo) {
        addresRepository.save(mapper.map(addressVo, Address.class));
    }
}