package bd.ac.du.iit.onestopcitizenservice.citizencontactservice.utilities;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.entities.Contact;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.AddContactRequest;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.Category;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.ContactDetails;
import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.UpdateContactRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelHelper {
    public Contact prepareContactModel(AddContactRequest request) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(request.getContactDetails(), contact);
        contact.setCategory(request.getContactDetails().getCategory().value());

        return contact;
    }

    public Contact prepareContactModel(UpdateContactRequest request) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(request.getContactDetails(), contact);
        contact.setCategory(request.getContactDetails().getCategory().value());

        return contact;
    }

    public List<ContactDetails> prepareContactListModel(List<Contact> contacts) {
        List<ContactDetails> contactList = new ArrayList<>();

        for(Contact contact: contacts){
            ContactDetails contactDetails = new ContactDetails();
            BeanUtils.copyProperties(contact, contactDetails);
            contactDetails.setCategory(Category.fromValue(contact.getCategory()));
            contactList.add(contactDetails);
        }

        return contactList;
    }
}
