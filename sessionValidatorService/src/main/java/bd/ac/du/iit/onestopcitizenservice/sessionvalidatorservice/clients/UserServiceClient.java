package bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.clients;

import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.GetUserWithSessionDetailsRequest;
import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.GetUserWithSessionDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UserServiceClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UserServiceClient.class);

    public GetUserWithSessionDetailsResponse getUserWithSessionDetails(long uid){
        GetUserWithSessionDetailsRequest request = new GetUserWithSessionDetailsRequest();
        request.setUid(uid);

        log.info("Requesting user details with session information for uid: " + uid);

        GetUserWithSessionDetailsResponse response = (GetUserWithSessionDetailsResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
}
