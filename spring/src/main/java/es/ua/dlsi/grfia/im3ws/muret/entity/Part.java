package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class Part extends Auditable implements IID<Long>, IOrdered, Comparable<Part>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String comments;

    @Column
    private Integer ordering;

    @JsonBackReference (value="document")
    @ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="document_id", referencedColumnName="id")
    @JoinColumn(name="document_id", nullable = false)
    private Document document;

    public Part() {
    }

    public Part(String name, String comments, Document document, Integer ordering) {
        this.name = name;
        this.comments = comments;
        this.document = document;
        this.ordering = ordering;
    }

    @Override
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public Integer getOrdering() {
        return ordering;
    }

    @Override
    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part that = (Part) o;
        return name.equals(that.name) &&
                document.equals(that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, document);
    }

    @Override
    public int compareTo(Part o) {
        int result = 0;
        if (this.ordering != null && o.ordering != null) {
            result = this.ordering - o.ordering;
        }
        if (result == 0) {
            if (this.id < o.id) {
                result = -1;
            } else if (this.id > o.id) {
                result = 1;
            } else {
                result = 0;
            }
        }
        return result;
    }
}
