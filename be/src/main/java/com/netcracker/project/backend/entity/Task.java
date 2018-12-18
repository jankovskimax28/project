package com.netcracker.project.backend.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
public class Task {
    private int id;
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
    private Date createDate;
    private Date updateDate;
    private Date closeDate;
    private Date resolve;
    private Date dueDate;
    private Status statusByStatus;
    private Priority priorityByPriority;
    private User userByReporter;
    private User userByAssignee;
    private Project projectByProjectId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ticet_code", nullable = true, length = 45)
    public String getTicetCode() {
        return ticetCode;
    }

    public void setTicetCode(String ticetCode) {

        this.ticetCode = ticetCode;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "priority", nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "attacment", nullable = false, length = -1)
    public String getAttacment() {
        return attacment;
    }

    public void setAttacment(String attacment) {
        this.attacment = attacment;
    }

    @Basic
    @Column(name = "reporter", nullable = false)
    public int getReporter() {
        return reporter;
    }

    public void setReporter(int reporter) {
        this.reporter = reporter;
    }

    @Basic
    @Column(name = "estimation", nullable = false, length = 45)
    public String getEstimation() {
        return estimation;
    }

    public void setEstimation(String estimation) {
        this.estimation = estimation;
    }

    @Basic
    @Column(name = "assignee", nullable = false)
    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "project_id", nullable = false)
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "close_date", nullable = true)
    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    @Basic
    @Column(name = "resolve", nullable = true)
    public Date getResolve() {
        return resolve;
    }

    public void setResolve(Date resolve) {
        this.resolve = resolve;
    }

    @Basic
    @Column(name = "due_date", nullable = true)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (status != task.status) return false;
        if (priority != task.priority) return false;
        if (reporter != task.reporter) return false;
        if (assignee != task.assignee) return false;
        if (projectId != task.projectId) return false;
        if (ticetCode != null ? !ticetCode.equals(task.ticetCode) : task.ticetCode != null) return false;
        if (attacment != null ? !attacment.equals(task.attacment) : task.attacment != null) return false;
        if (estimation != null ? !estimation.equals(task.estimation) : task.estimation != null) return false;
        if (comment != null ? !comment.equals(task.comment) : task.comment != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (createDate != null ? !createDate.equals(task.createDate) : task.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(task.updateDate) : task.updateDate != null) return false;
        if (closeDate != null ? !closeDate.equals(task.closeDate) : task.closeDate != null) return false;
        if (resolve != null ? !resolve.equals(task.resolve) : task.resolve != null) return false;
        if (dueDate != null ? !dueDate.equals(task.dueDate) : task.dueDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ticetCode != null ? ticetCode.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + priority;
        result = 31 * result + (attacment != null ? attacment.hashCode() : 0);
        result = 31 * result + reporter;
        result = 31 * result + (estimation != null ? estimation.hashCode() : 0);
        result = 31 * result + assignee;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + projectId;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
        result = 31 * result + (resolve != null ? resolve.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Status getStatusByStatus() {
        return statusByStatus;
    }

    public void setStatusByStatus(Status statusByStatus) {
        this.statusByStatus = statusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "priority", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    public Priority getPriorityByPriority() {
        return priorityByPriority;
    }

    public void setPriorityByPriority(Priority priorityByPriority) {
        this.priorityByPriority = priorityByPriority;
    }

    @ManyToOne
    @JoinColumn(name = "reporter", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByReporter() {
        return userByReporter;
    }

    public void setUserByReporter(User userByReporter) {
        this.userByReporter = userByReporter;
    }

    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByAssignee() {
        return userByAssignee;
    }

    public void setUserByAssignee(User userByAssignee) {
        this.userByAssignee = userByAssignee;
    }

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false, insertable = false, updatable = false)
    public Project getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(Project projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }
}
