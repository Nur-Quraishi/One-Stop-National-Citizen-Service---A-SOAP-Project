package bd.ac.du.iit.onestopcitizenservice.userservice.services;

import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.*;

public interface IUserService {
    public AddUserResponse addUser(AddUserRequest request);
    public GetUserResponse getUser(GetUserRequest request);
    public GetUserWithSessionDetailsResponse getUserWithSessionDetails(GetUserWithSessionDetailsRequest request);
    public GetAllUsersResponse getAllUsers(GetAllUsersRequest request);
    public UpdateUserResponse updateUser(UpdateUserRequest request);
    public DeleteUserResponse deleteUser(DeleteUserRequest request);
    public LoginWithEmailResponse loginWithEmail(LoginWithEmailRequest request);
    public LoginWithMobileNoResponse loginWithMobileNo(LoginWithMobileNoRequest request);
    public LogOutResponse logOut(LogOutRequest request);
}
