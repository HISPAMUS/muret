package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class Section extends Auditable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonBackReference (value="document")
    @ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="document_id", referencedColumnName="id")
    @JoinColumn(name="document_id", nullable = false)
    private Document document;

    @JsonManagedReference(value="section")
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "section")
    private Set<Image> images;

    public Section() {
    }

    public Section(String name, Document document) {
        this.name = name;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section that = (Section) o;
        return name.equals(that.name) &&
                document.equals(that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, document);
    }
}
