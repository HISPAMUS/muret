package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

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

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="project_id", referencedColumnName="id")
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "image",
            cascade = CascadeType.ALL,
            orphanRemoval = true) // orphanRemoval = remove dependent rather than set the FK to null
    //@JoinColumn(name="image_id", referencedColumnName="id") // don't use this construct to let orphanRemoval to work right
    private List<Page> pages;

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

    public Image() {
    }

    public Image(String path, String comments, Integer width, Integer height, Project project, State state, Part part) {
        this.filename = path;
        this.project = project;
        this.width = width;
        this.height = height;
        this.comments = comments;
        this.state = state;
        this.part = part;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
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

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", project=" + project +
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
            pages = new LinkedList<>();
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
}
