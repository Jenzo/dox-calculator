package calculator.ui.util.messages;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

public class FacesMessageBuilder
{

    private FacesMessage facesMsg = new FacesMessage();

    public static FacesMessageBuilder newMessage()
    {
        return new FacesMessageBuilder();
    }

    private FacesMessageBuilder()
    {
    }

    public FacesMessageBuilder withSummary(final String summary)
    {
        facesMsg.setSummary(summary);
        return this;
    }

    public FacesMessageBuilder withDetail(final String detail)
    {
        facesMsg.setDetail(detail);
        return this;
    }

    public FacesMessageBuilder withSeverity(final Severity severity)
    {
        facesMsg.setSeverity(severity);
        return this;
    }

    public FacesMessage build()
    {
        return facesMsg;
    }

}
