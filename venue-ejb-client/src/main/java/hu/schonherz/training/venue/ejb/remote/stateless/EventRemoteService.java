package hu.schonherz.training.venue.ejb.remote.stateless;


public interface EventRemoteService {

    void registerBandForEvent(Long eventId, Long bandId);

}
