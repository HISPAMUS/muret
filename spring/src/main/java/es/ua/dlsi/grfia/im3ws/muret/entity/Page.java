package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author drizo
 */
@Entity
public class Page {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Format: fromX,fromY,toX,toY
     */
    @Column (name = "bounding_box")
    @Convert(converter = BoundingBoxConverter.class)
    private BoundingBox boundingBox;

    @Column
    private String comments;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="image_id", nullable = false) // use this construct to let orphanRemoval to work well
    Image image;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true) // orphanRemoval = remove dependent rather than set the FK to null)
    //@JoinColumn(name="page_id", referencedColumnName="id")
    private List<Region> regions;

    public Page() {
    }

    public Page(BoundingBox boundingBox, String comments, Image image, List<Region> regions) {
        this.boundingBox = boundingBox;
        this.image = image;
        this.regions = regions;
        this.comments = comments;
    }

    public Page(Image image, int fromX, int fromY, int toX, int toY, String comments, List<Region> regions) {
        this.boundingBox = new BoundingBox(fromX, fromY, toX, toY);
        this.image = image;
        this.regions = regions;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
    public void setBoundingBox(BoundingBox boundingBox)  {
        this.boundingBox = boundingBox;
    }
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void addRegion(Region newRegion) {
        if (regions == null) {
            regions = new LinkedList<>();
        }
        regions.add(newRegion);
    }
}
