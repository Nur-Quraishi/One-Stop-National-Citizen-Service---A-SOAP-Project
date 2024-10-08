package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.services.impl;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.SearchByCategoryResponse;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.SearchByContactResponse;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.SearchByNameResponse;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Code;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Message;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.ServiceStatus;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Status;
import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.clients.CitizenContactServiceClient;
import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.clients.SessionValidatorServiceClient;
import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.interfaces.*;
import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.services.ISearchAndSortService;
import bd.ac.du.iit.onestopcitizenservice.sessionvalidatorservice.interfaces.EvaluateSessionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchAndSortService implements ISearchAndSortService {
    @Autowired
    CitizenContactServiceClient citizenContactServiceClient;
    @Autowired
    SessionValidatorServiceClient sessionValidatorServiceClient;

    @Override
    public ValidationWithSearchByNameResponse searchByNameWithValidation(ValidationWithSearchByNameRequest request) {
        ValidationWithSearchByNameResponse response = new ValidationWithSearchByNameResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try{
            EvaluateSessionResponse evaluateSessionResponse = sessionValidatorServiceClient.validateSession(request.getSessionDetails());
            serviceStatus = evaluateSessionResponse.getServiceStatus();

            if(serviceStatus.getStatus() == Status.OK){
                SearchByNameResponse searchByNameResponse = citizenContactServiceClient.searchByName(request.getSearchByNameDetails());
                response.setSearchResults(searchByNameResponse.getContactList());
                serviceStatus = searchByNameResponse.getServiceStatus();
            }
            else{
                response.setSearchResults(null);
            }
        }
        catch(Exception e){
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setStatus(Status.SQL_QUERY_FAILURE);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public ValidationWithSearchByCategoryResponse searchByCategoryWithValidation(ValidationWithSearchByCategoryRequest request) {
        ValidationWithSearchByCategoryResponse response = new ValidationWithSearchByCategoryResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try{
            EvaluateSessionResponse evaluateSessionResponse = sessionValidatorServiceClient.validateSession(request.getSessionDetails());
            serviceStatus = evaluateSessionResponse.getServiceStatus();

            if(serviceStatus.getStatus() == Status.OK){
                SearchByCategoryResponse searchByCategoryResponse = citizenContactServiceClient.searchByCategory(request.getSearchByCategoryDetails());
                response.setSearchResults(searchByCategoryResponse.getContactList());
                serviceStatus = searchByCategoryResponse.getServiceStatus();
            }
            else{
                response.setSearchResults(null);
            }
        }
        catch(Exception e){
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setStatus(Status.SQL_QUERY_FAILURE);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public ValidationWithSearchByContactResponse searchByContactWithValidation(ValidationWithSearchByContactRequest request) {
        ValidationWithSearchByContactResponse response = new ValidationWithSearchByContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try{
            EvaluateSessionResponse evaluateSessionResponse = sessionValidatorServiceClient.validateSession(request.getSessionDetails());
            serviceStatus = evaluateSessionResponse.getServiceStatus();

            if(serviceStatus.getStatus() == Status.OK){
                SearchByContactResponse searchByContactResponse = citizenContactServiceClient.searchByContact(request.getSearchByContactDetails());
                response.setSearchResults(searchByContactResponse.getContactList());
                serviceStatus = searchByContactResponse.getServiceStatus();
            }
            else{
                response.setSearchResults(null);
            }
        }
        catch(Exception e){
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setStatus(Status.SQL_QUERY_FAILURE);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }
}
