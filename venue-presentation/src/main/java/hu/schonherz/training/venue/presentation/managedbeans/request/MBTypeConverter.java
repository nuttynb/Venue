package hu.schonherz.training.venue.presentation.managedbeans.request;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBType;
import hu.schonherz.training.venue.service.TypeService;
import hu.schonherz.training.venue.vo.TypeVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "typeConverterBean")
@RequestScoped
public class MBTypeConverter implements Converter {
    @ManagedProperty(value = "#{typeBean}")
    private MBType type;

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
        type.setTypes(tempListForTest);
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        return type.findTypeByName(submittedValue);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof TypeVo) {
            return ((TypeVo) modelValue).getName();
        } else {
            return "";
        }
    }

    public MBType getType() {
        return type;
    }

    public void setType(MBType type) {
        this.type = type;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
}
