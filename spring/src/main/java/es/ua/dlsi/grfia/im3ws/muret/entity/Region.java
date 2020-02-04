package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author drizo
 */
@Entity
public class Region extends Auditable implements IAssignableToPart {
    /**
     * It orders regions given its middle horizontal point or its approximate x
     */
    private static Comparator<? super Region> verticalPositionComparator = new Comparator<Region>() {
        @Override
        public int compare(Region o1, Region o2) {
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
    @Column
    String comments;

    /**
     * Format: fromX,fromY,toX,toY - absolute values
     */
    @Column (name = "bounding_box")
    @Convert(converter = BoundingBoxConverter.class)
    private BoundingBox boundingBox;

    @JsonBackReference (value="page")
    @ManyToOne
    //@JoinColumn(name="page_id", referencedColumnName="id")
    @JoinColumn(name="page_id", nullable = false)
    private Page page;

    @JsonManagedReference (value="region")
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "region",
            cascade = CascadeType.ALL,
            orphanRemoval = true) // orphanRemoval = remove dependent rather than set the FK to null)
    //@JoinColumn(name="region_id", referencedColumnName="id")
    //@JoinColumn(name="region_id")
    private List<Symbol> symbols;

    @ManyToOne
    @JoinColumn(name="regiontype_id")
    RegionType regionType;

    /**
     * It can be null because the part is assigned to other element of the score
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="part_id")
    private Part part;

    @Column (name = "semantic_encoding")
    private String semanticEncoding;

    public Region() {
    }

    public Region(Page page, BoundingBox boundingBox, String comments, RegionType regionType, List<Symbol> symbols, Part part, String semanticEncoding) {
        this.boundingBox = boundingBox;
        this.page = page;
        this.regionType = regionType;
        this.symbols = symbols;
        this.comments = comments;
        this.part = part;
        this.semanticEncoding = semanticEncoding;
    }

    public Region(Page page, RegionType regionType, int fromX, int fromY, int toX, int toY, Part part) {
        this.page = page;
        this.regionType = regionType;
        this.boundingBox = new BoundingBox(fromX, fromY, toX, toY);
        this.part = part;
    }

    public static Comparator<? super Region> getVerticalPositionComparator() {
        return verticalPositionComparator;
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

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    @JsonIgnore
    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public Part getPart() {
        return part;
    }

    @Override
    public void setPart(Part part) {
        this.part = part;
    }

    public String getSemanticEncoding() {
        return semanticEncoding;
    }

    public void setSemanticEncoding(String semanticEncoding) {
        this.semanticEncoding = semanticEncoding;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", boundingBox='" + boundingBox + '\'' +
                ", page=" + page +
                '}';
    }

    public void removeSymbol(Symbol symbol) {
        this.symbols.remove(symbol);
    }

    @Transient
    public List<Symbol> getSortedSymbols() {
        List<Symbol> sortedRegions = getSymbols().stream().sorted(Symbol.getHorizontalPositionComparator()).collect(Collectors.toList());
        return sortedRegions;
    }
}
