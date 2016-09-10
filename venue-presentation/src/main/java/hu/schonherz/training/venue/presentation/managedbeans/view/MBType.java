package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.service.TypeService;
import hu.schonherz.training.venue.vo.TypeVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "typeBean")
@ViewScoped
public class MBType implements Serializable {
    private static final long serialVersionUID = 7869189274417139148L;
    private List<TypeVo> types = new ArrayList<>();

    @EJB(beanName = "VenueTypeService")
    TypeService typeService;

    @PostConstruct
    public void init() {
        types = typeService.getAllTypes();
    }

    public List<TypeVo> getTypes() {
        return types;
    }

    public void setTypes(List<TypeVo> types) {
        this.types = types;
    }

    public TypeVo findTypeById(Long id) {
        return typeService.getTypeById(id);
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
}
