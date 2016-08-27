package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.TypeVo;
import hu.schonherz.training.venue.vo.VenueVo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@ManagedBean(name = "typeBean")
@ViewScoped
public class MBType {
    private List<TypeVo> types = new ArrayList<>();

    public List<TypeVo> getTypes() {
        return types;
    }

    public void setTypes(List<TypeVo> types) {
        this.types = types;
    }

    public TypeVo findTypeByName(String typeName) {
        return types.stream()
                .filter(type -> type.getName().equals(typeName))
                .findFirst()
                .get();
    }
}
