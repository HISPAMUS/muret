package es.ua.dlsi.grfia.im3ws.muret.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class User {
    public static final String ADMINISTRATOR_ROLE = "ADMIN";
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private boolean administrator;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "createdBy")
    private List<Document> documentsCreated;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Permissions> permissions;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String email, boolean administrator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.administrator = administrator;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public List<Document> getDocumentsCreated() {
        return documentsCreated;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public void setDocumentsCreated(List<Document> documentsCreated) {
        this.documentsCreated = documentsCreated;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public void grantPermission(Permissions newPermission) { this.permissions.add(newPermission); }

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

