package hu.schonherz.training.venue.service;


import hu.schonherz.training.venue.vo.EventImageVo;

import java.util.List;

public interface EventImageService {

    void saveImage(EventImageVo eventImageVo);

    List<EventImageVo> getEventImagesByEventId(Long eventId);

    EventImageVo getEventImageById(Long id);
}
