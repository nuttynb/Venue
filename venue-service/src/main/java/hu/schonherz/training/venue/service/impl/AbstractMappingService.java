package hu.schonherz.training.venue.service.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMappingService implements Mapper {

    private final Mapper mapper = new DozerBeanMapper();

    private Mapper getMapper() {
        return mapper;
    }

    public <T, U> List<U> map(List<T> var1, Class<U> var2) {
        List<U> vos = new ArrayList<>();
        for (T element : var1) {
            vos.add(getMapper().map(element, var2));
        }
        return vos;
    }

    @Override
    public <T> T map(Object var1, Class<T> var2) throws MappingException {
        return getMapper().map(var1, var2);
    }

    @Override
    public void map(Object var1, Object var2) throws MappingException {
        getMapper().map(var1, var2);
    }

    @Override
    public <T> T map(Object var1, Class<T> var2, String var3) throws MappingException {
        return getMapper().map(var1, var2, var3);
    }

    @Override
    public void map(Object var1, Object var2, String var3) throws MappingException {
        getMapper().map(var1, var2, var3);
    }

}
