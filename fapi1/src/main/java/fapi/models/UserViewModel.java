package fapi.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserViewModel {

    private int id;
    @NotNull(message = "code cannot be null")
    @Size(min = 3, max = 10, message = "About Me must be between 3 and 10")
    private String login;
    @NotNull(message = "code cannot be null")
    @Size(min = 3, max = 16, message = "About Me must be between 3 and 10")
    private String password;

    private String email;
    private Integer roleId;
    private RoleViewModel roleByRoleId;

    public UserViewModel(){

    }

    public UserViewModel(int id,
                         String login,
                         String password,
                         String email,
                         Integer roleId,
                         RoleViewModel roleByRoleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
        this.roleByRoleId = roleByRoleId;
    }

    public UserViewModel(
                         String login,
                         String password,
                         String email,
                         Integer roleId
                         ) {

        this.login = login;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }


    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {

        this.roleId = roleId;
    }

    public RoleViewModel getRoleByRoleId(){

        return roleByRoleId;
    }

    public void setRoleByRoleId(){

        this.roleByRoleId = roleByRoleId;
    }
}
