package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.TypeVo;

import java.util.List;

public interface TypeService {

    List<TypeVo> getAllTypes();

    TypeVo getTypeById(Long id);
}
