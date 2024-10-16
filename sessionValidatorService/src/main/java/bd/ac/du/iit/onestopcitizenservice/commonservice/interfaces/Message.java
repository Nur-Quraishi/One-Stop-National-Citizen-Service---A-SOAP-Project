//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.07 at 02:11:53 AM BDT 
//


package bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for message.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="message"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Successfully added a new user!"/&gt;
 *     &lt;enumeration value="Failed to add a user!"/&gt;
 *     &lt;enumeration value="Successfully fetched the user details!"/&gt;
 *     &lt;enumeration value="Successfully fetched the list of user details!"/&gt;
 *     &lt;enumeration value="Failed to fetch the list of user details!"/&gt;
 *     &lt;enumeration value="No user found!"/&gt;
 *     &lt;enumeration value="Successfully updated the user!"/&gt;
 *     &lt;enumeration value="Failed to update the user!"/&gt;
 *     &lt;enumeration value="Successfully deleted the user details!"/&gt;
 *     &lt;enumeration value="No user found to be deleted!"/&gt;
 *     &lt;enumeration value="Successfully added a new contact!"/&gt;
 *     &lt;enumeration value="Failed to add a contact!"/&gt;
 *     &lt;enumeration value="Successfully fetched the contact details!"/&gt;
 *     &lt;enumeration value="Successfully fetched the list of contact details!"/&gt;
 *     &lt;enumeration value="Failed to fetch the list of contact details!"/&gt;
 *     &lt;enumeration value="No contact found!"/&gt;
 *     &lt;enumeration value="Successfully updated the contact!"/&gt;
 *     &lt;enumeration value="Failed to update the contact!"/&gt;
 *     &lt;enumeration value="Successfully deleted the contact details!"/&gt;
 *     &lt;enumeration value="No contact found to be deleted!"/&gt;
 *     &lt;enumeration value="Email not found!"/&gt;
 *     &lt;enumeration value="Mobile number not found!"/&gt;
 *     &lt;enumeration value="Incorrect password!"/&gt;
 *     &lt;enumeration value="Successfully logged in!"/&gt;
 *     &lt;enumeration value="Successfully logged out!"/&gt;
 *     &lt;enumeration value="No user found to log out!"/&gt;
 *     &lt;enumeration value="Successfully validated the user session!"/&gt;
 *     &lt;enumeration value="Invalid user session!"/&gt;
 *     &lt;enumeration value="No match Found!"/&gt;
 *     &lt;enumeration value="Successfully fetched the search results!"/&gt;
 *     &lt;enumeration value="SQL Query Fault!"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "message")
@XmlEnum
public enum Message {

    @XmlEnumValue("Successfully added a new user!")
    SUCCESSFULLY_ADDED_A_NEW_USER("Successfully added a new user!"),
    @XmlEnumValue("Failed to add a user!")
    FAILED_TO_ADD_A_USER("Failed to add a user!"),
    @XmlEnumValue("Successfully fetched the user details!")
    SUCCESSFULLY_FETCHED_THE_USER_DETAILS("Successfully fetched the user details!"),
    @XmlEnumValue("Successfully fetched the list of user details!")
    SUCCESSFULLY_FETCHED_THE_LIST_OF_USER_DETAILS("Successfully fetched the list of user details!"),
    @XmlEnumValue("Failed to fetch the list of user details!")
    FAILED_TO_FETCH_THE_LIST_OF_USER_DETAILS("Failed to fetch the list of user details!"),
    @XmlEnumValue("No user found!")
    NO_USER_FOUND("No user found!"),
    @XmlEnumValue("Successfully updated the user!")
    SUCCESSFULLY_UPDATED_THE_USER("Successfully updated the user!"),
    @XmlEnumValue("Failed to update the user!")
    FAILED_TO_UPDATE_THE_USER("Failed to update the user!"),
    @XmlEnumValue("Successfully deleted the user details!")
    SUCCESSFULLY_DELETED_THE_USER_DETAILS("Successfully deleted the user details!"),
    @XmlEnumValue("No user found to be deleted!")
    NO_USER_FOUND_TO_BE_DELETED("No user found to be deleted!"),
    @XmlEnumValue("Successfully added a new contact!")
    SUCCESSFULLY_ADDED_A_NEW_CONTACT("Successfully added a new contact!"),
    @XmlEnumValue("Failed to add a contact!")
    FAILED_TO_ADD_A_CONTACT("Failed to add a contact!"),
    @XmlEnumValue("Successfully fetched the contact details!")
    SUCCESSFULLY_FETCHED_THE_CONTACT_DETAILS("Successfully fetched the contact details!"),
    @XmlEnumValue("Successfully fetched the list of contact details!")
    SUCCESSFULLY_FETCHED_THE_LIST_OF_CONTACT_DETAILS("Successfully fetched the list of contact details!"),
    @XmlEnumValue("Failed to fetch the list of contact details!")
    FAILED_TO_FETCH_THE_LIST_OF_CONTACT_DETAILS("Failed to fetch the list of contact details!"),
    @XmlEnumValue("No contact found!")
    NO_CONTACT_FOUND("No contact found!"),
    @XmlEnumValue("Successfully updated the contact!")
    SUCCESSFULLY_UPDATED_THE_CONTACT("Successfully updated the contact!"),
    @XmlEnumValue("Failed to update the contact!")
    FAILED_TO_UPDATE_THE_CONTACT("Failed to update the contact!"),
    @XmlEnumValue("Successfully deleted the contact details!")
    SUCCESSFULLY_DELETED_THE_CONTACT_DETAILS("Successfully deleted the contact details!"),
    @XmlEnumValue("No contact found to be deleted!")
    NO_CONTACT_FOUND_TO_BE_DELETED("No contact found to be deleted!"),
    @XmlEnumValue("Email not found!")
    EMAIL_NOT_FOUND("Email not found!"),
    @XmlEnumValue("Mobile number not found!")
    MOBILE_NUMBER_NOT_FOUND("Mobile number not found!"),
    @XmlEnumValue("Incorrect password!")
    INCORRECT_PASSWORD("Incorrect password!"),
    @XmlEnumValue("Successfully logged in!")
    SUCCESSFULLY_LOGGED_IN("Successfully logged in!"),
    @XmlEnumValue("Successfully logged out!")
    SUCCESSFULLY_LOGGED_OUT("Successfully logged out!"),
    @XmlEnumValue("No user found to log out!")
    NO_USER_FOUND_TO_LOG_OUT("No user found to log out!"),
    @XmlEnumValue("Successfully validated the user session!")
    SUCCESSFULLY_VALIDATED_THE_USER_SESSION("Successfully validated the user session!"),
    @XmlEnumValue("Invalid user session!")
    INVALID_USER_SESSION("Invalid user session!"),
    @XmlEnumValue("No match Found!")
    NO_MATCH_FOUND("No match Found!"),
    @XmlEnumValue("Successfully fetched the search results!")
    SUCCESSFULLY_FETCHED_THE_SEARCH_RESULTS("Successfully fetched the search results!"),
    @XmlEnumValue("SQL Query Fault!")
    SQL_QUERY_FAULT("SQL Query Fault!");
    private final String value;

    Message(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Message fromValue(String v) {
        for (Message c: Message.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
