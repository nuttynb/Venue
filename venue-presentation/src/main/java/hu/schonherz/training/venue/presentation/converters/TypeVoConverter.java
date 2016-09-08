package hu.schonherz.training.venue.presentation.converters;

import hu.schonherz.training.venue.presentation.managedbeans.view.MBType;
import hu.schonherz.training.venue.vo.TypeVo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("typeVoConverter")
public class TypeVoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        MBType type = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{typeBean}", MBType.class);
        return type.findTypeById(Long.valueOf(submittedValue));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof TypeVo) {
            return ((TypeVo) modelValue).getId().toString();
        } else {
            return "";
        }
    }
}
