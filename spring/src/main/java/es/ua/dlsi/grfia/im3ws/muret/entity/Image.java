package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import es.ua.dlsi.grfia.im3ws.IM3WSException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author drizo
 */
@Entity
public class Image extends Auditable implements IAssignableToPart {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String filename;
    @Column
    private String comments;
    @Column
    private Integer width;
    @Column
    private Integer height;

    @JsonBackReference (value="document")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="document_id", nullable = false)
    private Document document;

    @JsonManagedReference (value="image")
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "image",
            cascade = CascadeType.ALL,
            orphanRemoval = true) // orphanRemoval = remove dependent rather than set the FK to null
    //@JoinColumn(name="image_id", referencedColumnName="id") // don't use this construct to let orphanRemoval to work right
    private Set<Page> pages;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id")
    State state;

    /**
     * It can be null because the part is assigned to other element of the score
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="part_id")
    private Part part;

    /**
     * if the section is null the image is unassigned to a section, then document must be not null
     */
    @JsonBackReference (value="section")
    @ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="document_id", referencedColumnName="id")
    @JoinColumn(name="section_id", nullable = true)
    private Section section;

    public Image() {
    }

    public Image(String path, String comments, Integer width, Integer height, Document document, State state, Part part, Section section) {
        if (document != null && section != null) {
            throw new RuntimeException("Document and Section are mutually exclusive");
        }
        this.filename = path;
        this.document = document;
        this.width = width;
        this.height = height;
        this.comments = comments;
        this.state = state;
        this.part = part;
        this.section = section;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        if (document != null && this.section != null) {
            throw new RuntimeException("section and document are mutually exclusive");
        }

        this.document = document;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        if (section != null && this.document != null) {
            throw new RuntimeException("section and document are mutually exclusive");
        }
        this.section = section;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", document=" + document +
                '}';
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void addPage(Page page) {
        if (pages == null) {
            pages = new HashSet<>();
        }
        pages.add(page);
    }
    @Override
    public Part getPart() {
        return part;
    }

    @Override
    public void setPart(Part part) {
        this.part = part;
    }

    /**
     * It returns the pages sorted using cartesian plane
     * @return
     */
    @Transient
    @JsonIgnore
    public List<Page> getSortedPages() {
        List<Page> sortedPages = getPages().stream().sorted(Page.getVerticalPositionComparator()).collect(Collectors.toList());
        return sortedPages;
    }

    public void changeDocumentAndSection(Document document, Section section) throws IM3WSException {
        if (section == null && document == null) {
            throw new IM3WSException("Cannot set both section and document to null");
        }
        if (section != null && document != null) {
            throw new IM3WSException("Section and document are mutually exclusive");
        }

        this.section = section;
        this.document = document;
    }
}
