package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

/**
 * Collection permissions
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
    @JoinColumn(name="collection_id", referencedColumnName="id")
    private Collection collection;

    @Column
    char permissions;

    public Permissions() {
    }

    public Permissions(User user, Collection collection, char permissions) {
        this.user = user;
        this.collection = collection;
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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
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
                Objects.equals(collection, that.collection) &&
                Objects.equals(permissions, that.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, collection, permissions);
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", user=" + user +
                ", collection=" + collection +
                ", permission='" + permissions + '\'' +
                '}';
    }
}
