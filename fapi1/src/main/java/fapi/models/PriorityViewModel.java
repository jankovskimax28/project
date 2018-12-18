package fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriorityViewModel {
    private int id;
    private String typePriority;

    public PriorityViewModel(){
    }

    public PriorityViewModel(int id, String typePriority){
        this.id = id;
        this.typePriority = typePriority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePriority() {
        return typePriority;
    }

    public void setTypePriority(String typePriority) {
        this.typePriority = typePriority;
    }
}
