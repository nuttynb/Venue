package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.EventImage;
import hu.schonherz.training.venue.persistence.repository.EventImageRepository;
import hu.schonherz.training.venue.service.EventImageService;
import hu.schonherz.training.venue.vo.EventImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "EventImageService", mappedName = "EventImageService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(EventImageService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class EventImageServiceImpl extends AbstractMappingService implements EventImageService{

    @Autowired
    EventImageRepository eventImageRepository;

    @Override
    public void saveImage(EventImageVo eventImageVo) {
        eventImageRepository.save(map(eventImageVo, EventImage.class));
    }

    @Override
    public List<EventImageVo> getEventImagesByEventId(Long eventId) {
        return map(eventImageRepository.findByEventId(eventId), EventImageVo.class);
    }

    @Override
    public EventImageVo getEventImageById(Long id) {
        return map(eventImageRepository.findById(id), EventImageVo.class);
    }
}
