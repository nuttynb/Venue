package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Address;
import hu.schonherz.training.venue.persistence.repository.AddressRepository;
import hu.schonherz.training.venue.service.AddressService;
import hu.schonherz.training.venue.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;

@Stateless(name = "AddressService", mappedName = "AddressService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(AddressService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class AddressServiceImpl extends AbstractMappingService implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void saveAddress(AddressVo addressVo) {
        addressRepository.save(map(addressVo, Address.class));
    }

}
