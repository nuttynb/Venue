package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.repository.TypeRepository;
import hu.schonherz.training.venue.service.TypeService;
import hu.schonherz.training.venue.vo.TypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "TypeService", mappedName = "TypeService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(TypeService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class TypeServiceImpl extends AbstractMappingService implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<TypeVo> getAllTypes() {
        List<TypeVo> types = map(typeRepository.findAll(), TypeVo.class);
        return types;
    }

    @Override
    public TypeVo getTypeById(Long id) {
        return map(typeRepository.findById(id), TypeVo.class);
    }
}
