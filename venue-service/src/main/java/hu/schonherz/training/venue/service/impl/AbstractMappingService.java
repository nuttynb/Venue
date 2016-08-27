package hu.schonherz.training.venue.service.impl;

import javax.ejb.EJB;

/**
 * Created by ikant on 2016. 08. 27..
 */
public abstract class AbstractMappingService {
    @EJB
    protected MapperEJB mapper;

}
