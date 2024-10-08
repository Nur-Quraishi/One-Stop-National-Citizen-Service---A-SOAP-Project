//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.07 at 01:09:52 AM BDT 
//


package bd.ac.du.iit.onestopcitizenservice.userservice.interfaces;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bd.ac.du.iit.onestopcitizenservice.userservice.interfaces package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UserWithSessionDetails_QNAME = new QName("http://iit.du.ac.bd/onestopcitizenservice/userservice/interfaces", "userWithSessionDetails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bd.ac.du.iit.onestopcitizenservice.userservice.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserWithSessionDetails }
     * 
     */
    public UserWithSessionDetails createUserWithSessionDetails() {
        return new UserWithSessionDetails();
    }

    /**
     * Create an instance of {@link AddUserRequest }
     * 
     */
    public AddUserRequest createAddUserRequest() {
        return new AddUserRequest();
    }

    /**
     * Create an instance of {@link UserDetails }
     * 
     */
    public UserDetails createUserDetails() {
        return new UserDetails();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link GetUserRequest }
     * 
     */
    public GetUserRequest createGetUserRequest() {
        return new GetUserRequest();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link GetUserWithSessionDetailsRequest }
     * 
     */
    public GetUserWithSessionDetailsRequest createGetUserWithSessionDetailsRequest() {
        return new GetUserWithSessionDetailsRequest();
    }

    /**
     * Create an instance of {@link GetUserWithSessionDetailsResponse }
     * 
     */
    public GetUserWithSessionDetailsResponse createGetUserWithSessionDetailsResponse() {
        return new GetUserWithSessionDetailsResponse();
    }

    /**
     * Create an instance of {@link GetAllUsersRequest }
     * 
     */
    public GetAllUsersRequest createGetAllUsersRequest() {
        return new GetAllUsersRequest();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link UserList }
     * 
     */
    public UserList createUserList() {
        return new UserList();
    }

    /**
     * Create an instance of {@link UpdateUserRequest }
     * 
     */
    public UpdateUserRequest createUpdateUserRequest() {
        return new UpdateUserRequest();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUserRequest }
     * 
     */
    public DeleteUserRequest createDeleteUserRequest() {
        return new DeleteUserRequest();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link LoginWithEmailRequest }
     * 
     */
    public LoginWithEmailRequest createLoginWithEmailRequest() {
        return new LoginWithEmailRequest();
    }

    /**
     * Create an instance of {@link LoginWithEmailDetails }
     * 
     */
    public LoginWithEmailDetails createLoginWithEmailDetails() {
        return new LoginWithEmailDetails();
    }

    /**
     * Create an instance of {@link LoginWithEmailResponse }
     * 
     */
    public LoginWithEmailResponse createLoginWithEmailResponse() {
        return new LoginWithEmailResponse();
    }

    /**
     * Create an instance of {@link LoginWithMobileNoRequest }
     * 
     */
    public LoginWithMobileNoRequest createLoginWithMobileNoRequest() {
        return new LoginWithMobileNoRequest();
    }

    /**
     * Create an instance of {@link LoginWithMobileNoDetails }
     * 
     */
    public LoginWithMobileNoDetails createLoginWithMobileNoDetails() {
        return new LoginWithMobileNoDetails();
    }

    /**
     * Create an instance of {@link LoginWithMobileNoResponse }
     * 
     */
    public LoginWithMobileNoResponse createLoginWithMobileNoResponse() {
        return new LoginWithMobileNoResponse();
    }

    /**
     * Create an instance of {@link LogOutRequest }
     * 
     */
    public LogOutRequest createLogOutRequest() {
        return new LogOutRequest();
    }

    /**
     * Create an instance of {@link LogOutResponse }
     * 
     */
    public LogOutResponse createLogOutResponse() {
        return new LogOutResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserWithSessionDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserWithSessionDetails }{@code >}
     */
    @XmlElementDecl(namespace = "http://iit.du.ac.bd/onestopcitizenservice/userservice/interfaces", name = "userWithSessionDetails")
    public JAXBElement<UserWithSessionDetails> createUserWithSessionDetails(UserWithSessionDetails value) {
        return new JAXBElement<UserWithSessionDetails>(_UserWithSessionDetails_QNAME, UserWithSessionDetails.class, null, value);
    }

}
