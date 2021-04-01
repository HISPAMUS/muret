package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class Section extends Auditable implements IID<Long>, IOrdered {
    public static final Comparator<? super Section> COMPARATOR = (Comparator<Section>) (o1, o2) -> {
        if (o1.ordering != null && o2.getOrdering() != null) {
            int diff = o1.ordering - o2.ordering;
            if (diff != 0) {
                return diff;
            }
        }
        return o1.id.compareTo(o2.id);
    };

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
    // don't use because it requires non sparse values @OrderColumn(name = "ordering", nullable = false)
    private List<Image> images;

    @Column // in the document
    private Integer ordering;

    public Section() {
    }

    public Section(String name, Document document, Integer ordering) {
        this.name = name;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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
        Section that = (Section) o;
        return name.equals(that.name) &&
                document.equals(that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, document);
    }
}
