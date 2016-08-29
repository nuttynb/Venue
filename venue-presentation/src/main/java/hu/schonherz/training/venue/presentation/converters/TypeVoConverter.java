package hu.schonherz.training.venue.presentation.converters;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBType;
import hu.schonherz.training.venue.vo.TypeVo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TypeVo.class, value = "typeVoConverter")
public class TypeVoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        MBType type = (MBType) facesContext.getViewRoot().getViewMap().get("typeBean");
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
}
