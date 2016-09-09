package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.persistence.entity.VenueType;
import hu.schonherz.training.venue.persistence.repository.VenueTypeRepository;
import hu.schonherz.training.venue.service.TypeService;
import hu.schonherz.training.venue.vo.TypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "TypeService", mappedName = "TypeService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@Local(TypeService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class TypeServiceImpl extends AbstractMappingService implements TypeService {

    @Autowired
    private VenueTypeRepository typeRepository;

    public List<TypeVo> toTypeVo(List<VenueType> types) {
        List<TypeVo> typeVos = new ArrayList<>();
        for (VenueType type : types) {
            typeVos.add(map(type, TypeVo.class));
        }
        return typeVos;
    }

    @Override
    public List<TypeVo> getAllTypes() {
        List<TypeVo> types = toTypeVo(typeRepository.findAll());
        return types;
    }

    @Override
    public TypeVo getTypeById(Long id) {
        return map(typeRepository.findById(id), TypeVo.class);
    }
}
