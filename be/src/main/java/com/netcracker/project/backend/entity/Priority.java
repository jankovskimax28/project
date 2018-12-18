package com.netcracker.project.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Priority {
    private int id;
    private String typePriority;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_priority", nullable = true, length = 45)
    public String getTypePriority() {
        return typePriority;
    }

    public void setTypePriority(String typePriority) {
        this.typePriority = typePriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority = (Priority) o;

        if (id != priority.id) return false;
        if (typePriority != null ? !typePriority.equals(priority.typePriority) : priority.typePriority != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typePriority != null ? typePriority.hashCode() : 0);
        return result;
    }
}
