package bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.endpoints;

import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionRequest;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionResponse;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.services.impl.SessionValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SessionValidatorEndpoint {

    private static final String NAMESPACE_URI = "http://iit.du.ac.bd/onestopcitizenservice/sessionvalidatorservice/interfaces";
    @Autowired
    private SessionValidatorService sessionValidatorService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "evaluateSessionRequest")
    @ResponsePayload
    public EvaluateSessionResponse evaluateSession(@RequestPayload EvaluateSessionRequest request) {
        return sessionValidatorService.evaluateSession(request);
    }
}