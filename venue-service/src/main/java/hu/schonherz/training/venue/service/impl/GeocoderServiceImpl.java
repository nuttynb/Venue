package hu.schonherz.training.venue.service.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import hu.schonherz.training.venue.service.GeocoderService;
import hu.schonherz.training.venue.vo.AddressVo;
import hu.schonherz.training.venue.vo.LatLngVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.*;

@Stateless(name = "GeocoderService", mappedName = "GeocoderService")
@Local(GeocoderService.class)
public class GeocoderServiceImpl implements GeocoderService {

    private static String apiKey;
    private GeoApiContext context;
    private static final Logger LOG = LoggerFactory.getLogger(GeocoderServiceImpl.class);

    @PostConstruct
    public void init() {
        context = new GeoApiContext();
        context.setApiKey(apiKey);
    }

    public LatLngVo getLatitudeAndLongitudeByAddress(AddressVo addressVo) {
        String address = getFormattedAddress(addressVo);
        GeocodingApiRequest request = GeocodingApi.geocode(context, address);
        LatLngVo latLngVo = new LatLngVo(0, 0);
        try {
            GeocodingResult[] results = request.await();
            if (results.length != 0) {
                latLngVo = getLatLngVoFromResult(results[0]);
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        return latLngVo;
    }

    private String getFormattedAddress(AddressVo addressVo) {
        StringBuffer address = new StringBuffer();
        address.append(addressVo.getStreet()).append(" ");
        address.append(addressVo.getNumber()).append(" ");
        address.append(addressVo.getPostcode()).append(" ");
        address.append(addressVo.getCity()).append(", ");
        address.append(addressVo.getCountry());
        return address.toString();
    }

    private LatLngVo getLatLngVoFromResult(GeocodingResult result) {
        LatLngVo latLngVo = new LatLngVo();
        latLngVo.setLat(result.geometry.location.lat);
        latLngVo.setLng(result.geometry.location.lng);
        return latLngVo;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
