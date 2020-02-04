package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author drizo
 */
@Entity
public class Page extends Auditable implements IAssignableToPart {
    /**
     * It orders pages given its middle horizontal point or its approximate x
     */
    private static Comparator<? super Page> verticalPositionComparator = new Comparator<Page>() {
        @Override
        public int compare(Page o1, Page o2) {
            if (o1.getBoundingBox().getFromY() < o2.getBoundingBox().getFromY()) {
                return -1;
            } else if (o1.getBoundingBox().getFromY() > o2.getBoundingBox().getFromY()) {
                return 1;
            } else {
                if (o1.getBoundingBox().getFromX() < o2.getBoundingBox().getFromX()) {
                    return -1;
                } else if (o1.getBoundingBox().getFromX() > o2.getBoundingBox().getFromX()) {
                    return 1;
                } else {
                    return o1.hashCode() - o2.hashCode();
                }
            }
        }
    };
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


    @JsonBackReference (value="image")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="image_id", nullable = false) // use this construct to let orphanRemoval to work well
    Image image;

    @JsonManagedReference (value="page")
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "page",
            cascade = CascadeType.ALL,
            orphanRemoval = true) // orphanRemoval = remove dependent rather than set the FK to null)
    //@JoinColumn(name="page_id", referencedColumnName="id")
    private List<Region> regions;

    /**
     * It can be null because the part is assigned to other element of the score
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="part_id")
    private Part part;

    public Page() {
    }

    public Page(BoundingBox boundingBox, String comments, Image image, List<Region> regions, Part part) {
        this.boundingBox = boundingBox;
        this.image = image;
        this.regions = regions;
        this.comments = comments;
        this.part = part;
    }

    public Page(Image image, int fromX, int fromY, int toX, int toY, String comments, List<Region> regions, Part part) {
        this.boundingBox = new BoundingBox(fromX, fromY, toX, toY);
        this.image = image;
        this.regions = regions;
        this.comments = comments;
        this.part = part;
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
    @Override
    public Part getPart() {
        return part;
    }

    @Override
    public void setPart(Part part) {
        this.part = part;
    }

    /**
     * It returns the staves (region_type = "staff") sorted using cartesian plane
     * @return
     */
    @Transient
    public List<Region> getSortedStaves() {
        List<Region> sortedRegions = getRegions().stream().filter(
                region -> region.getRegionType().getName().equals("staff")).
                sorted(Region.getVerticalPositionComparator()).collect(Collectors.toList());
        return sortedRegions;
    }

    /**
     * It returns the regions sorted using cartesian plane
     * @return
     */
    @Transient
    public List<Region> getSortedRegions() {
        List<Region> sortedRegions = getRegions().stream().sorted(Region.getVerticalPositionComparator()).collect(Collectors.toList());
        return sortedRegions;
    }

    public static Comparator<? super Page> getVerticalPositionComparator() {
        return verticalPositionComparator;
    }
}
