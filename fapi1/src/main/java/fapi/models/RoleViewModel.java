package fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleViewModel {
    private int id;
    private String typeRole;

    public RoleViewModel(){
    }

    public RoleViewModel(int id, String typeRole){
        this.id = id;
        this.typeRole = typeRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }
}
