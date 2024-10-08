package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.clients;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CitizenContactServiceClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CitizenContactServiceClient.class);

    public SearchByNameResponse searchByName(SearchByNameDetails searchByNameDetails){
        SearchByNameRequest request = new SearchByNameRequest();

        request.setSearchByNameDetails(searchByNameDetails);
        log.info("Conducting contact search by name with information name: " + searchByNameDetails.getName() + ", columnToBeSorted: " + searchByNameDetails.getColumnToBeSorted().value() + " and sortOrder: " + searchByNameDetails.getSortOrder().value());
        SearchByNameResponse response = (SearchByNameResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public SearchByCategoryResponse searchByCategory(SearchByCategoryDetails searchByCategoryDetails){
        SearchByCategoryRequest request = new SearchByCategoryRequest();

        request.setSearchByCategoryDetails(searchByCategoryDetails);
        log.info("Conducting contact search by category with information category: " + searchByCategoryDetails.getCategory().value() + ", columnToBeSorted: " + searchByCategoryDetails.getColumnToBeSorted().value() + " and sortOrder: " + searchByCategoryDetails.getSortOrder().value());
        SearchByCategoryResponse response = (SearchByCategoryResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public SearchByContactResponse searchByContact(SearchByContactDetails searchByContactDetails){
        SearchByContactRequest request = new SearchByContactRequest();

        request.setSearchByContactDetails(searchByContactDetails);
        log.info("Conducting contact search by contact no. with information contact no.: " + searchByContactDetails.getContact() + ", columnToBeSorted: " + searchByContactDetails.getColumnToBeSorted().value() + " and sortOrder: " + searchByContactDetails.getSortOrder().value());
        SearchByContactResponse response = (SearchByContactResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
}
