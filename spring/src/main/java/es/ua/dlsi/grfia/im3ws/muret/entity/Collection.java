package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity (name="collection")
public class Collection {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String comments;

    @JsonManagedReference (value="collection")
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "collection")
    private List<Document> documents;

    @JsonManagedReference (value="parent")
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "parent")
    private List<Collection> subcollections;

    @JsonBackReference(value="parent")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_collection_id", nullable = true)
    private Collection parent;

    @Lob
    @Column (name = "thumbnail_base64_encoding", columnDefinition = "LONGTEXT")
    private String thumbnailBase64Encoding;

    public Collection() {
    }

    public Collection(String name, String thumbnailBase64Encoding, List<Document> documents) {
        this.name = name;
        this.documents = documents;
        this.thumbnailBase64Encoding = thumbnailBase64Encoding;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getThumbnailBase64Encoding() {
        return thumbnailBase64Encoding;
    }

    public void setThumbnailBase64Encoding(String thumbnailBase64Encoding) {
        this.thumbnailBase64Encoding = thumbnailBase64Encoding;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Collection> getSubcollections() {
        return subcollections;
    }

    public void setSubcollections(List<Collection> subcollections) {
        this.subcollections = subcollections;
    }

    public Collection getParent() {
        return parent;
    }

    public void setParent(Collection parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
