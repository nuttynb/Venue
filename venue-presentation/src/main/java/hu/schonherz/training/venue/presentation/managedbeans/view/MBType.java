package hu.schonherz.training.venue.presentation.managedbeans.view;

import hu.schonherz.training.venue.vo.TypeVo;

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
