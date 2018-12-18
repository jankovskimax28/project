package fapi.controller;

import fapi.config.TokenProvider;
import fapi.models.UserViewModel;
import fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pm/user")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveProject(@RequestBody UserViewModel user) {
        if (user != null) {
            return ResponseEntity.ok(userDataService.saveUser(user));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserViewModel>> getAllUsers() {
        return ResponseEntity.ok(userDataService.getAll());
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getOne(@PathVariable String login) {

        return ResponseEntity.ok(userDataService.getOne(login));
    }

    @RequestMapping(value = "/token/{token}", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> findUserByToken(@PathVariable(name = "token") String token) throws AuthenticationException {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserViewModel user = userDataService.getOne(username);
        user.setPassword(null);
        return ResponseEntity.ok(user);

    }

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getTasksByCode(@RequestParam(value = "login") String login){
        return ResponseEntity.ok(userDataService.getOne(login));
    }

}