package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.endpoints;

import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.interfaces.*;
import bd.ac.du.iit.onestopcitizenservice.searchandsortservice.services.impl.SearchAndSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SearchAndSortEndpoint {
    private static final String NAMESPACE_URI = "http://iit.du.ac.bd/onestopcitizenservice/searchandsortservice/interfaces";
    @Autowired
    private SearchAndSortService searchAndSortService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "validationWithSearchByNameRequest")
    @ResponsePayload
    public ValidationWithSearchByNameResponse searchByNameWithValidation(@RequestPayload ValidationWithSearchByNameRequest request) {
        return searchAndSortService.searchByNameWithValidation(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "validationWithSearchByCategoryRequest")
    @ResponsePayload
    public ValidationWithSearchByCategoryResponse searchByCategoryWithValidation(@RequestPayload ValidationWithSearchByCategoryRequest request) {
        return searchAndSortService.searchByCategoryWithValidation(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "validationWithSearchByContactRequest")
    @ResponsePayload
    public ValidationWithSearchByContactResponse searchByContactWithValidation(@RequestPayload ValidationWithSearchByContactRequest request) {
        return searchAndSortService.searchByContactWithValidation(request);
    }
}