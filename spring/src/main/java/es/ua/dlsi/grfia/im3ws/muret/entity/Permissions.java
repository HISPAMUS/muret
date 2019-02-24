package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

/**
 * Project permissions
 * @author drizo
 */
@Entity
public class Permissions {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference (value="user") // it avoids circular relationships
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName="id")
    private Project project;

    @Column
    char permissions;

    public Permissions() {
    }

    public Permissions(User user, Project project, char permissions) {
        this.user = user;
        this.project = project;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public char getPermission() {
        return permissions;
    }

    public void setPermission(char permission) {
        this.permissions = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permissions that = (Permissions) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(project, that.project) &&
                Objects.equals(permissions, that.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, project, permissions);
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", user=" + user +
                ", project=" + project +
                ", permission='" + permissions + '\'' +
                '}';
    }
}
