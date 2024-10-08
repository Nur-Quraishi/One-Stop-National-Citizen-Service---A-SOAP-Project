package bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.services;

import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionRequest;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionResponse;

public interface ISessionValidatorService {
    public EvaluateSessionResponse evaluateSession(EvaluateSessionRequest request);
}
