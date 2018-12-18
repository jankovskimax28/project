package fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectViewModel {

    private int projectId;

    @NotNull(message = "code cannot be null")
    @Size(min = 3, max = 10, message = "About Me must be between 3 and 10")
    private String projectcode;
    private String summary;

    public ProjectViewModel(){
    }

    public ProjectViewModel(int projectId, String projectcode, String summary){
        this.projectId=projectId;
        this.projectcode=projectcode;
        this.summary=summary;
    }

    public void setProjectId(int projectId) {
        this.projectId= projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }
}
