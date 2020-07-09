package calculator.ui.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@SuppressWarnings("rawtypes")
@FacesConverter(value = "solvedConverter")
public class SolvedConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        return Boolean.parseBoolean(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object solved)
    {
        boolean b = ((Boolean)solved).booleanValue();
        return b ? "richtig" : "falsch";
    }

}
