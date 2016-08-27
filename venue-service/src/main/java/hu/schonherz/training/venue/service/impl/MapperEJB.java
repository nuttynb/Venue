package hu.schonherz.training.venue.service.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by ikant on 2016. 08. 27..
 */
@Startup
@Singleton
public class MapperEJB implements Mapper {
    private Mapper mapper;

    @PostConstruct
    public void init() {
        mapper = new DozerBeanMapper();
    }

    @Override
    public <T> T map(Object var1, Class<T> var2) throws MappingException {
        return mapper.map(var1, var2);
    }

    @Override
    public void map(Object var1, Object var2) throws MappingException {
        mapper.map(var1, var2);
    }

    @Override
    public <T> T map(Object var1, Class<T> var2, String var3) throws MappingException {
        return mapper.map(var1, var2, var3);
    }

    @Override
    public void map(Object var1, Object var2, String var3) throws MappingException {
        mapper.map(var1, var2, var3);
    }
}
