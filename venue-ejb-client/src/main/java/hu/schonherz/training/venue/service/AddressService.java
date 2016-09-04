package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.AddressVo;

public interface AddressService {

    AddressVo getAddressByVenueId(Long id);

    void createAddress(AddressVo addressVo);
}
