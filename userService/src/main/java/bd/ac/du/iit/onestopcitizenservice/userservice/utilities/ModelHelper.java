package bd.ac.du.iit.onestopcitizenservice.userservice.utilities;

import bd.ac.du.iit.onestopcitizenservice.userservice.entities.User;
import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.AddUserRequest;
import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.UpdateUserRequest;

import bd.ac.du.iit.onestopcitizenservice.userservice.interfaces.UserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelHelper {
    public User prepareUserModel(AddUserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request.getUserDetails(), user);

        return user;
    }

    public User prepareUserModel(UpdateUserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request.getUserDetails(), user);

        return user;
    }

    public List<UserDetails> prepareUserListModel(List<User> users) {
        List<UserDetails> userList = new ArrayList<>();

        for(User user: users){
            UserDetails userDetails = new UserDetails();
            BeanUtils.copyProperties(user, userDetails);
            userList.add(userDetails);
        }

        return userList;
    }
}
