package bd.ac.du.iit.onestopcitizenservice.userservice.services.impl;

import bd.ac.du.iit.onestopcitizenservice.userservice.repository.UserRepository;
import bd.ac.du.iit.onestopcitizenservice.userservice.utilities.ModelHelper;
import bd.ac.du.iit.onestopcitizenservice.userservice.entities.User;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Code;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Message;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.ServiceStatus;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.Status;
import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.*;
import bd.ac.du.iit.onestopcitizenservice.userservice.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelHelper modelHelper;

    @Override
    public AddUserResponse addUser(AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            User userModel = modelHelper.prepareUserModel(request);
            userRepository.save(userModel);

            serviceStatus.setStatus(Status.CREATED);
            serviceStatus.setCode(Code.RC_201);
            serviceStatus.setMessage(Message.SUCCESSFULLY_ADDED_A_NEW_USER);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_400);
            serviceStatus.setMessage(Message.FAILED_TO_ADD_A_USER);
        }

        response.setUserDetails(request.getUserDetails());
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetUserResponse getUser(GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            long uid = request.getUid();
            User user = userRepository.findById(uid).orElseThrow();

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_USER_DETAILS);

            UserDetails userDetails = new UserDetails();
            BeanUtils.copyProperties(user, userDetails);
            response.setUserDetails(userDetails);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.NO_CONTENT);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_USER_FOUND);

            response.setUserDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetUserWithSessionDetailsResponse getUserWithSessionDetails(GetUserWithSessionDetailsRequest request) {
        GetUserWithSessionDetailsResponse response = new GetUserWithSessionDetailsResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            long uid = request.getUid();
            User user = userRepository.findById(uid).orElseThrow();

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_USER_DETAILS);

            UserWithSessionDetails userWithSessionDetails = new UserWithSessionDetails();
            BeanUtils.copyProperties(user, userWithSessionDetails);
            if(user.getExpiryDate() != null){
                userWithSessionDetails.setExpiryDate(DateFormat.getInstance().format(user.getExpiryDate()));
            }
            response.setUserWithSessionDetails(userWithSessionDetails);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.NO_CONTENT);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_USER_FOUND);

            response.setUserWithSessionDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetAllUsersResponse getAllUsers(GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            UserList userList = new UserList();
            List<User> users = userRepository.findAll();
            List<UserDetails> userDetailsList = modelHelper.prepareUserListModel(users);
            userList.getUsers().addAll(userDetailsList);
            response.setUserList(userList);

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_FETCHED_THE_LIST_OF_USER_DETAILS);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_400);
            serviceStatus.setMessage(Message.FAILED_TO_FETCH_THE_LIST_OF_USER_DETAILS);

            response.setUserList(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            User userModel = modelHelper.prepareUserModel(request);
            userRepository.save(userModel);

            serviceStatus.setStatus(Status.UPDATED);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_UPDATED_THE_USER);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_400);
            serviceStatus.setMessage(Message.FAILED_TO_UPDATE_THE_USER);
        }

        response.setUserDetails(request.getUserDetails());
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            long uid = request.getUid();
            User user = userRepository.findById(uid).orElseThrow();
            userRepository.delete(user);

            serviceStatus.setStatus(Status.DELETED);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_DELETED_THE_USER_DETAILS);

            UserDetails userDetails = new UserDetails();
            BeanUtils.copyProperties(user, userDetails);
            response.setUserDetails(userDetails);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.NO_CONTENT);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_USER_FOUND_TO_BE_DELETED);

            response.setUserDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public LoginWithEmailResponse loginWithEmail(LoginWithEmailRequest request){
        LoginWithEmailResponse response = new LoginWithEmailResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            String providedEmail = request.getLoginWithEmailDetails().getEmail();
            String providedPassword = request.getLoginWithEmailDetails().getPassword();
            Optional<User> user = userRepository.findUserByEmailAndPassword(providedEmail, providedPassword);
            response.setUserWithSessionDetails(null);

            if(user.isPresent()){
                User foundUser = user.get();
                ZonedDateTime expiryZonedDateTime = ZonedDateTime.now().plusDays(1);
                String sessionToken = String.valueOf(user.get().getUid()) + expiryZonedDateTime.hashCode() + user.get().getEmail().hashCode();
                Date expiryDate = Date.from(expiryZonedDateTime.toInstant());

                foundUser.setSessionToken(sessionToken);
                foundUser.setExpiryDate(expiryDate);
                userRepository.save(foundUser);

                UserWithSessionDetails userWithSessionDetails = new UserWithSessionDetails();
                BeanUtils.copyProperties(foundUser, userWithSessionDetails);
                userWithSessionDetails.setExpiryDate(foundUser.getExpiryDate().toString());
                response.setUserWithSessionDetails(userWithSessionDetails);

                serviceStatus.setStatus(Status.AUTHENTICATION_SUCCESSFUL);
                serviceStatus.setCode(Code.RC_200);
                serviceStatus.setMessage(Message.SUCCESSFULLY_LOGGED_IN);
            }
            else{
                Optional<User> userWithCorrectEmail = userRepository.findUserByEmail(providedEmail);

                if(userWithCorrectEmail.isPresent()){
                    serviceStatus.setStatus(Status.AUTHENTICATION_FAILED);
                    serviceStatus.setCode(Code.RC_498);
                    serviceStatus.setMessage(Message.INCORRECT_PASSWORD);
                }
                else{
                    serviceStatus.setStatus(Status.AUTHENTICATION_FAILED);
                    serviceStatus.setCode(Code.RC_498);
                    serviceStatus.setMessage(Message.EMAIL_NOT_FOUND);
                }
            }
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.SQL_QUERY_FAILURE);
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);

            response.setUserWithSessionDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public LoginWithMobileNoResponse loginWithMobileNo(LoginWithMobileNoRequest request){
        LoginWithMobileNoResponse response = new LoginWithMobileNoResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            String providedMobileNo = request.getLoginWithMobileNoDetails().getMobileNo();
            String providedPassword = request.getLoginWithMobileNoDetails().getPassword();
            Optional<User> user = userRepository.findUserByMobileNoAndPassword(providedMobileNo, providedPassword);
            response.setUserWithSessionDetails(null);

            if(user.isPresent()){
                User foundUser = user.get();
                ZonedDateTime expiryZonedDateTime = ZonedDateTime.now().plusDays(1);
                String sessionToken = String.valueOf(user.get().getUid()) + expiryZonedDateTime.hashCode() + user.get().getMobileNo().hashCode();
                Date expiryDate = Date.from(expiryZonedDateTime.toInstant());

                foundUser.setSessionToken(sessionToken);
                foundUser.setExpiryDate(expiryDate);
                userRepository.save(foundUser);

                UserWithSessionDetails userWithSessionDetails = new UserWithSessionDetails();
                BeanUtils.copyProperties(foundUser, userWithSessionDetails);
                userWithSessionDetails.setExpiryDate(foundUser.getExpiryDate().toString());
                response.setUserWithSessionDetails(userWithSessionDetails);

                serviceStatus.setStatus(Status.AUTHENTICATION_SUCCESSFUL);
                serviceStatus.setCode(Code.RC_200);
                serviceStatus.setMessage(Message.SUCCESSFULLY_LOGGED_IN);
            }
            else{
                Optional<User> userWithCorrectMobileNo = userRepository.findUserByMobileNo(providedMobileNo);

                if(userWithCorrectMobileNo.isPresent()){
                    serviceStatus.setStatus(Status.AUTHENTICATION_FAILED);
                    serviceStatus.setCode(Code.RC_498);
                    serviceStatus.setMessage(Message.INCORRECT_PASSWORD);
                }
                else{
                    serviceStatus.setStatus(Status.AUTHENTICATION_FAILED);
                    serviceStatus.setCode(Code.RC_498);
                    serviceStatus.setMessage(Message.MOBILE_NUMBER_NOT_FOUND);
                }
            }
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.SQL_QUERY_FAILURE);
            serviceStatus.setCode(Code.RC_450);
            serviceStatus.setMessage(Message.SQL_QUERY_FAULT);

            response.setUserWithSessionDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public LogOutResponse logOut(LogOutRequest request){
        LogOutResponse response = new LogOutResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            long uid = request.getUid();
            User user = userRepository.findById(uid).orElseThrow();
            UserDetails userDetails = new UserDetails();
            BeanUtils.copyProperties(user, userDetails);
            response.setUserDetails(userDetails);

            user.setSessionToken(null);
            user.setExpiryDate(null);
            userRepository.save(user);

            serviceStatus.setStatus(Status.OK);
            serviceStatus.setCode(Code.RC_200);
            serviceStatus.setMessage(Message.SUCCESSFULLY_LOGGED_OUT);
        }
        catch(Exception e) {
            serviceStatus.setStatus(Status.FAILED);
            serviceStatus.setCode(Code.RC_204);
            serviceStatus.setMessage(Message.NO_USER_FOUND_TO_LOG_OUT);

            response.setUserDetails(null);
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }
}