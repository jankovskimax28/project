package fapi.service.impl;

import fapi.models.RoleViewModel;
import fapi.models.UserViewModel;
import fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

@Service(value="userService")
public class UserDataServiceimpl implements UserDataService, UserDetailsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserViewModel user = getOne(login);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority() );
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public UserViewModel saveUser(UserViewModel user){
        RestTemplate restTemplate = new RestTemplate();

        UserViewModel userViewModel = new UserViewModel(user.getLogin(), bcryptEncoder.encode(user.getPassword()), user.getEmail(), user.getRoleId());
        return restTemplate.postForEntity(backendServerUrl+"/be/pm/user/", userViewModel, UserViewModel.class).getBody();
    }

    @Override
    public List<UserViewModel> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] UserViewModelResponse = restTemplate.getForObject(backendServerUrl + "/be/pm/user/", UserViewModel[].class);
        return UserViewModelResponse == null ? Collections.emptyList() : Arrays.asList(UserViewModelResponse);

    }

    @Override
    public UserViewModel getOne (String login){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(backendServerUrl + "/be/pm/user/login/?login=" + login, UserViewModel.class);

    }
}

