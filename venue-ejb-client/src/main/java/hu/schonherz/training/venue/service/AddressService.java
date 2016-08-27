package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.AddressVo;

/**
 * Created by Roli on 2016. 08. 25..
 */
public interface AddressService {

    AddressVo getAddressByVenueId(Long id);

    void createAddress(AddressVo addressVo);
}
