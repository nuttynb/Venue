package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.Type;
import hu.schonherz.training.venue.persistence.repository.TypeRepository;
import hu.schonherz.training.venue.service.TypeService;
import hu.schonherz.training.venue.vo.TypeVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roli on 2016. 08. 27..
 */

@Stateless(name = "TypeService", mappedName = "TypeService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local(TypeService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class TypeServiceImpl extends AbstractMappingService implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<TypeVo> toReporytory(List<Type> typeRepositorys) {
        List<TypeVo> typeVos = new ArrayList<>();
        for (Type typeRepository : typeRepositorys) {
            typeVos.add(mapper.map(typeRepository, TypeVo.class));
        }
        return typeVos;
    }

    @Override
    public List<TypeVo> getAllType() {
        List<TypeVo> types = toReporytory(typeRepository.findAll());
        return types;
    }
}
