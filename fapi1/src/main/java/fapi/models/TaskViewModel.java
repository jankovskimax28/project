package fapi.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskViewModel {

    private int id;
    @NotNull(message = "code cannot be null")
    @Size(min = 3, max = 15, message = "About Me must be between 3 and 10")
    private String ticetCode;
    private int status;
    private int priority;
    private String attacment;
    private int reporter ;
    private String estimation;
    private int assignee;
    private String comment;
    private String description;
    private int projectId;
    private Date closeDate;
    private Date resolve;
    private String dueDate;
    private Date createDate = new Date();
    private Date updateDate;
    private StatusViewModel statusByStatus;
    private PriorityViewModel priorityByPriority;
    private UserViewModel userByReporter;
    private UserViewModel userByAssignee;
    private ProjectViewModel projectByProjectId;

    public int getId() {return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicetCode() {
        return ticetCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public void setTicetCode(String ticetCode) {

        this.ticetCode = ticetCode;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getAttacment() {
        return attacment;
    }

    public void setAttacment(String attacment) {
        this.attacment = attacment;
    }

    public int getReporter() {
        return reporter;
    }

    public void setReporter(int reporter) {

        this.reporter = reporter;
    }

    public String getEstimation() {
        return estimation;
    }

    public void setEstimation(String estimation) {
        this.estimation = estimation;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getResolve() {
        return resolve;
    }

    public void setResolve(Date resolve) {
        this.resolve = resolve;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityViewModel getPriorityByPriority() {
        return priorityByPriority;
    }

    public ProjectViewModel getProjectByProjectId() {
        return projectByProjectId;
    }

    public UserViewModel getUserByAssignee() {
        return userByAssignee;
    }

    public UserViewModel getUserByReporter() {
        return userByReporter;
    }

    public void setPriorityByPriority(PriorityViewModel priorityByPriority) {
        this.priorityByPriority = priorityByPriority;
    }

    public void setStatusByStatus(StatusViewModel statusByStatus) {
        this.statusByStatus = statusByStatus;
    }

    public StatusViewModel getStatusByStatus() {
        return statusByStatus;
    }

    public void setProjectByProjectId(ProjectViewModel projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    public void setUserByAssignee(UserViewModel userByAssignee) {
        this.userByAssignee = userByAssignee;
    }

    public void setUserByReporter(UserViewModel userByReporter) {
        this.userByReporter = userByReporter;
    }
}
