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

    @EJB
    TypeService typeService;

    @PostConstruct
    public void init() {
        //type.setTypes(typeService.getAllType());
        List<TypeVo> tempListForTest = new ArrayList<>();
        TypeVo tempType1 = new TypeVo();
        TypeVo tempType2 = new TypeVo();
        TypeVo tempType3 = new TypeVo();
        tempType1.setId(new Long(1));
        tempType1.setName("Test1");
        tempListForTest.add(tempType1);
        tempType2.setId(new Long(2));
        tempType2.setName("Test2");
        tempListForTest.add(tempType2);
        tempType3.setId(new Long(3));
        tempType3.setName("Test3");
        tempListForTest.add(tempType3);
        types = tempListForTest;
    }


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

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
}
