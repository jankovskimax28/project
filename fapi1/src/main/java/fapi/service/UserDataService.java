package fapi.service;

import fapi.models.UserViewModel;
import java.util.List;

public interface UserDataService{

    UserViewModel saveUser(UserViewModel user);
    List<UserViewModel> getAll();
    UserViewModel getOne(String login);

}
