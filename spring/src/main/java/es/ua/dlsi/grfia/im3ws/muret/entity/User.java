package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "createdBy")
    private List<Project> projectsCreated;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
    private List<Permissions> permissions;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    public String getUsername() {
        return username;
    }

    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    public List<Project> getProjectsCreated() {
        return projectsCreated;
    }

    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setProjectsCreated(List<Project> projectsCreated) {
        this.projectsCreated = projectsCreated;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

}

