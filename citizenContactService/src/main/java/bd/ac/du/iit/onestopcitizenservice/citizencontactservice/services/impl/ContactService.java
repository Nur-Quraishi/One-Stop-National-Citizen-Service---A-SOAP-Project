package bd.ac.du.iit.onestopcitizenservice.citizencontactservice.services.impl;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.entities.Contact;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.*;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.repository.ContactRepository;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.utilities.ModelHelper;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Code;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Message;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.ServiceStatus;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Status;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.services.IContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ModelHelper modelHelper;

    @Override
    public AddContactResponse addContact(AddContactRequest request) {
        AddContactResponse response = new AddContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            Contact contactModel = modelHelper.prepareContactModel(request);
            contactRepository.save(contactModel);

            serviceStatus.setStatus(Status.CREATED);
            serviceStatus.setCode(Code.RC_201);
            serviceStatus.setMessage(Message.SUCCESSFULLY_ADDED_A_NEW_CONTACT);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_400);
            serviceStatus.setMessage(Message.FAILED_TO_ADD_A_CONTACT);
        }

        response.setContactDetails(request.getContactDetails());
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetContactResponse getContact(GetContactRequest request) {
        GetContactResponse response = new GetContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            long uid = request.getUid();
            Contact contact = contactRepository.findById(uid).orElseThrow();

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_CONTACT_DETAILS);

            ContactDetails contactDetails = new ContactDetails();
            BeanUtils.copyProperties(contact, contactDetails);
            contactDetails.setCategory(Category.fromValue(contact.getCategory()));
            response.setContactDetails(contactDetails);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.NO_CONTENT);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_CONTACT_FOUND);

            response.setContactDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetAllContactsResponse getAllContacts(GetAllContactsRequest request) {
        GetAllContactsResponse response = new GetAllContactsResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            ContactList contactList = new ContactList();
            List<Contact> contacts = contactRepository.findAll();
            List<ContactDetails> contactDetailsList = modelHelper.prepareContactListModel(contacts);
            contactList.getContacts().addAll(contactDetailsList);
            response.setContactList(contactList);

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_LIST_OF_CONTACT_DETAILS);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_400);
            serviceStatus.setMessage(Message.FAILED_TO_FETCH_THE_LIST_OF_CONTACT_DETAILS);

            response.setContactList(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public UpdateContactResponse updateContact(UpdateContactRequest request) {
        UpdateContactResponse response = new UpdateContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            Contact contactModel = modelHelper.prepareContactModel(request);
            contactRepository.save(contactModel);

            serviceStatus.setStatus(Status.UPDATED);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_UPDATED_THE_CONTACT);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_400);
            serviceStatus.setMessage(Message.FAILED_TO_UPDATE_THE_CONTACT);
        }

        response.setContactDetails(request.getContactDetails());
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public DeleteContactResponse deleteContact(DeleteContactRequest request) {
        DeleteContactResponse response = new DeleteContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            long uid = request.getUid();
            Contact contact = contactRepository.findById(uid).orElseThrow();
            contactRepository.delete(contact);

            serviceStatus.setStatus(Status.DELETED);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_DELETED_THE_CONTACT_DETAILS);

            ContactDetails contactDetails = new ContactDetails();
            BeanUtils.copyProperties(contact, contactDetails);
            contactDetails.setCategory(Category.fromValue(contact.getCategory()));
            response.setContactDetails(contactDetails);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.NO_CONTENT);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_CONTACT_FOUND_TO_BE_DELETED);

            response.setContactDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public SearchByNameResponse searchByName(SearchByNameRequest request){
        SearchByNameResponse response = new SearchByNameResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            String name = request.getSearchByNameDetails().getName();
            String columnToBeSorted = request.getSearchByNameDetails().getColumnToBeSorted().value().toLowerCase().replace(' ', '_');
            String order = request.getSearchByNameDetails().getSortOrder().value();

            ContactList contactList = new ContactList();
            Sort sortOrder = Sort.by((order.equals("Descending") ? Sort.Direction.DESC : Sort.Direction.ASC), columnToBeSorted);
            List<Contact> contacts = contactRepository.findContactByName(name, sortOrder);
            List<ContactDetails> contactDetailsList = modelHelper.prepareContactListModel(contacts);
            contactList.getContacts().addAll(contactDetailsList);
            response.setContactList(contactList);

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_LIST_OF_CONTACT_DETAILS);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);

            response.setContactList(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public SearchByCategoryResponse searchByCategory(SearchByCategoryRequest request){
        SearchByCategoryResponse response = new SearchByCategoryResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            String category = request.getSearchByCategoryDetails().getCategory().value();
            String columnToBeSorted = request.getSearchByCategoryDetails().getColumnToBeSorted().value().toLowerCase().replace(' ', '_');
            String order = request.getSearchByCategoryDetails().getSortOrder().value();

            ContactList contactList = new ContactList();
            Sort sortOrder = Sort.by((order.equals("Descending") ? Sort.Direction.DESC : Sort.Direction.ASC), columnToBeSorted);
            List<Contact> contacts = contactRepository.findContactByCategory(category, sortOrder);
            List<ContactDetails> contactDetailsList = modelHelper.prepareContactListModel(contacts);
            contactList.getContacts().addAll(contactDetailsList);
            response.setContactList(contactList);

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_LIST_OF_CONTACT_DETAILS);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);

            response.setContactList(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public SearchByContactResponse searchByContact(SearchByContactRequest request){
        SearchByContactResponse response = new SearchByContactResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            String contactNo = request.getSearchByContactDetails().getContact();
            String columnToBeSorted = request.getSearchByContactDetails().getColumnToBeSorted().value().toLowerCase().replace(' ', '_');
            String order = request.getSearchByContactDetails().getSortOrder().value();

            ContactList contactList = new ContactList();
            Sort sortOrder = Sort.by((order.equals("Descending") ? Sort.Direction.DESC : Sort.Direction.ASC), columnToBeSorted);
            List<Contact> contacts = contactRepository.findContactByContactNo(contactNo, sortOrder);
            List<ContactDetails> contactDetailsList = modelHelper.prepareContactListModel(contacts);
            contactList.getContacts().addAll(contactDetailsList);
            response.setContactList(contactList);

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_LIST_OF_CONTACT_DETAILS);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);

            response.setContactList(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }
}
