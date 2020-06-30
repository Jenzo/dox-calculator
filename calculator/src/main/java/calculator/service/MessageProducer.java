package calculator.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageProducer {

	private static void build(final String clientId, final FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(clientId, message);
	}

	public static void success(final String message) {
		build(null, FacesMessageBuilder.newMessage()
				.withSummary(message)
				.withSeverity(FacesMessage.SEVERITY_INFO)
				.build());
	}
	
	public static void error(final String message) {
		build(null, FacesMessageBuilder.newMessage()
				.withSummary(message)
				.withSeverity(FacesMessage.SEVERITY_ERROR)
				.build());
	}
	

}
