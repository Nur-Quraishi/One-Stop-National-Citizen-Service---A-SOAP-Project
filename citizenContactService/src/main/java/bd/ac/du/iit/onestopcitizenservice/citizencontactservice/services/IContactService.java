package bd.ac.du.iit.onestopcitizenservice.citizencontactservice.services;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.*;

public interface IContactService {
    public AddContactResponse addContact(AddContactRequest request);
    public GetContactResponse getContact(GetContactRequest request);
    public GetAllContactsResponse getAllContacts(GetAllContactsRequest request);
    public UpdateContactResponse updateContact(UpdateContactRequest request);
    public DeleteContactResponse deleteContact(DeleteContactRequest request);
    public SearchByNameResponse searchByName(SearchByNameRequest request);
    public SearchByCategoryResponse searchByCategory(SearchByCategoryRequest request);
    public SearchByContactResponse searchByContact(SearchByContactRequest request);
}
