package hu.schonherz.training.venue.service.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import hu.schonherz.training.venue.service.GeocoderService;
import hu.schonherz.training.venue.vo.AddressVo;
import hu.schonherz.training.venue.vo.LatLngVo;

import javax.ejb.*;

@Stateless(name = "GeocoderService", mappedName = "GeocoderService")
@Local(GeocoderService.class)
public class GeocoderServiceImpl implements GeocoderService {

    private static final String APIKEY = "AIzaSyBLmMvpnM-2vU-IHA0FJNpXIffXSYIFGTw";
    private GeoApiContext context;
    private LatLngVo latLngVo = new LatLngVo(0, 0);

    public GeocoderServiceImpl() {
        context = new GeoApiContext();
        context.setApiKey(APIKEY);
    }

    public LatLngVo getLatitudeAndLongitudeByAddress(AddressVo addressVo) {
        String address = addressVo.getStreet() + " " + addressVo.getNumber() + " " + addressVo.getPostcode() + " " + addressVo.getCity() + ", " + addressVo.getCountry();
        GeocodingApiRequest request = GeocodingApi.geocode(context, address);
        try {
            GeocodingResult[] results = request.await();
            if (results.length != 0) {
                latLngVo = new LatLngVo(results[0].geometry.location.lat, results[0].geometry.location.lng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLngVo;
    }
}
