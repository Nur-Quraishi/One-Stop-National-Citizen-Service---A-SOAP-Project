package bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.services.impl;

import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionRequest;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionResponse;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.clients.UserServiceClient;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.services.ISessionValidatorService;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Code;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Message;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.ServiceStatus;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Status;

import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.GetUserWithSessionDetailsResponse;
import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.UserDetails;
import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.UserWithSessionDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SessionValidatorService implements ISessionValidatorService {

    @Autowired
    UserServiceClient userServiceClient;

    @Override
    public EvaluateSessionResponse evaluateSession(EvaluateSessionRequest request) {
        EvaluateSessionResponse response = new EvaluateSessionResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try{
            GetUserWithSessionDetailsResponse userWithSessionDetailsResponse = userServiceClient.getUserWithSessionDetails(request.getSessionValidatorDetails().getUid());

            UserWithSessionDetails userWithSessionDetails = userWithSessionDetailsResponse.getUserWithSessionDetails();
            if(userWithSessionDetails != null)
            {
                DateFormat formatter = new SimpleDateFormat();
                Date currentTime = new Date();
                Date expiryTime = formatter.parse(userWithSessionDetails.getExpiryDate());
                String sessionTokenDB = userWithSessionDetails.getSessionToken();
                String sessionTokenProvided = request.getSessionValidatorDetails().getSessionToken();

                UserDetails userDetails = new UserDetails();
                BeanUtils.copyProperties(userWithSessionDetails, userDetails);
                response.setUserDetails(userDetails);

                if(expiryTime.after(currentTime) && sessionTokenDB.equals(sessionTokenProvided)){
                    serviceStatus.setStatus(Status.OK);
                    serviceStatus.setCode(Code.RC_200);
                    serviceStatus.setMessage(Message.SUCCESSFULLY_VALIDATED_THE_USER_SESSION);
                }
                else{
                    serviceStatus.setStatus(Status.FAILED);
                    serviceStatus.setCode(Code.RC_400);
                    serviceStatus.setMessage(Message.INVALID_USER_SESSION);
                }
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e){
            serviceStatus.setStatus(Status.NO_CONTENT);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_USER_FOUND);

            response.setUserDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }
}