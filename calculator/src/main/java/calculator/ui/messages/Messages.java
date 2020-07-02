package calculator.ui.messages;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages
{

    private Messages()
    {
    }

    private static void build(final String clientId, final FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(clientId, message);
    }

    public static void success(final String message)
    {
        success(null, message);
    }

    public static void error(final String message)
    {
        error(null, message);
    }

    public static void success(final String clientId, final String message)
    {
        build(
                clientId,
                FacesMessageBuilder.newMessage().withSummary(message).withSeverity(FacesMessage.SEVERITY_INFO).build());
    }

    public static void error(final String clientId, final String message)
    {
        build(
                clientId,
                FacesMessageBuilder.newMessage().withSummary(message).withSeverity(
                        FacesMessage.SEVERITY_ERROR).build());
    }

}
