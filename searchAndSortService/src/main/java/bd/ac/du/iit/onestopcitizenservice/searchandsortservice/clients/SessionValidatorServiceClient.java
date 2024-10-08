package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.clients;

import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionRequest;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionResponse;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.SessionValidatorDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SessionValidatorServiceClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SessionValidatorServiceClient.class);

    public EvaluateSessionResponse validateSession(SessionValidatorDetails sessionValidatorDetails){
        EvaluateSessionRequest request = new EvaluateSessionRequest();

        request.setSessionValidatorDetails(sessionValidatorDetails);
        log.info("Validating session with information for uid: " + sessionValidatorDetails.getUid() + " and sessionToken: " + sessionValidatorDetails.getSessionToken());
        EvaluateSessionResponse response = (EvaluateSessionResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
}
