package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

/**
 * @author drizo
 */
@Entity
public class Region {
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

    @JsonBackReference
    @ManyToOne
    //@JoinColumn(name="page_id", referencedColumnName="id")
    @JoinColumn(name="page_id", nullable = false)
    private Page page;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true) // orphanRemoval = remove dependent rather than set the FK to null)
    //@JoinColumn(name="region_id", referencedColumnName="id")
    //@JoinColumn(name="region_id")
    private List<Symbol> symbols;

    @ManyToOne
    @JoinColumn(name="regiontype_id")
    RegionType regionType;

    public Region() {
    }

    public Region(Page page, BoundingBox boundingBox, String comments, RegionType regionType, List<Symbol> symbols) {
        this.boundingBox = boundingBox;
        this.page = page;
        this.regionType = regionType;
        this.symbols = symbols;
        this.comments = comments;
    }

    public Region(Page page, RegionType regionType, int fromX, int fromY, int toX, int toY) {
        this.page = page;
        this.regionType = regionType;
        this.boundingBox = new BoundingBox(fromX, fromY, toX, toY);
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
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", boundingBox='" + boundingBox + '\'' +
                ", page=" + page +
                '}';
    }
}
