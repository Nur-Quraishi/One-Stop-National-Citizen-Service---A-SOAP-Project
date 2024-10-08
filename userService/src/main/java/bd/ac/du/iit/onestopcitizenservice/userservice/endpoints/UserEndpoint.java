package bd.ac.du.iit.onestopcitizenservice.userservice.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.*;
import bd.ac.du.iit.onestopcitizenservice.userservice.services.impl.UserService;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://iit.du.ac.bd/onestopcitizenservice/userservice/interfaces";

    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
        return userService.addUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        return userService.getUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserWithSessionDetailsRequest")
    @ResponsePayload
    public GetUserWithSessionDetailsResponse getUserWithSessionDetails(@RequestPayload GetUserWithSessionDetailsRequest request) {
        return userService.getUserWithSessionDetails(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        return userService.getAllUsers(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        return userService.updateUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        return userService.deleteUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginWithEmailRequest")
    @ResponsePayload
    public LoginWithEmailResponse loginWithEmail(@RequestPayload LoginWithEmailRequest request) {
        return userService.loginWithEmail(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginWithMobileNoRequest")
    @ResponsePayload
    public LoginWithMobileNoResponse loginWithMobileNo(@RequestPayload LoginWithMobileNoRequest request) {
        return userService.loginWithMobileNo(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "logOutRequest")
    @ResponsePayload
    public LogOutResponse logOut(@RequestPayload LogOutRequest request) {
        return userService.logOut(request);
    }

}
