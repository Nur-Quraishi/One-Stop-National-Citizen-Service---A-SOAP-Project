package bd.ac.du.iit.onestopcitizenservice.citizencontactservice.endpoints;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.services.impl.ContactService;

@Endpoint
public class ContactEndpoint {
    private static final String NAMESPACE_URI = "http://iit.du.ac.bd/onestopcitizenservice/citizencontactservice/interfaces";

    @Autowired
    private ContactService contactService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addContactRequest")
    @ResponsePayload
    public AddContactResponse addContact(@RequestPayload AddContactRequest request) {
        return contactService.addContact(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContactRequest")
    @ResponsePayload
    public GetContactResponse getContact(@RequestPayload GetContactRequest request) {
        return contactService.getContact(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllContactsRequest")
    @ResponsePayload
    public GetAllContactsResponse getAllContacts(@RequestPayload GetAllContactsRequest request) {
        return contactService.getAllContacts(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateContactRequest")
    @ResponsePayload
    public UpdateContactResponse updateContact(@RequestPayload UpdateContactRequest request) {
        return contactService.updateContact(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteContactRequest")
    @ResponsePayload
    public DeleteContactResponse deleteContact(@RequestPayload DeleteContactRequest request) {
        return contactService.deleteContact(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchByNameRequest")
    @ResponsePayload
    public SearchByNameResponse searchByName(@RequestPayload SearchByNameRequest request) {
        return contactService.searchByName(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchByCategoryRequest")
    @ResponsePayload
    public SearchByCategoryResponse searchByCategory(@RequestPayload SearchByCategoryRequest request) {
        return contactService.searchByCategory(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchByContactRequest")
    @ResponsePayload
    public SearchByContactResponse searchByContact(@RequestPayload SearchByContactRequest request) {
        return contactService.searchByContact(request);
    }
}
