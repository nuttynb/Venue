package hu.schonherz.training.venue.service;


import hu.schonherz.training.venue.vo.AddressVo;
import hu.schonherz.training.venue.vo.LatLngVo;

public interface GeocoderService {
    LatLngVo getLatitudeAndLongitudeByAddress(AddressVo addressVo);
}
