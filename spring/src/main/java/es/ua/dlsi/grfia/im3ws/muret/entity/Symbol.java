package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;

import javax.persistence.*;

/**
 * @author drizo
 */
@Entity
public class Symbol extends Auditable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String comments;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    //@JoinColumn(name="region_id", referencedColumnName="id")
    @JoinColumn(name="region_id", nullable = false)
    private Region region;

    /**
     * Format: fromX,fromY,toX,toY - absolute values
     */
    @Column (name = "bounding_box")
    @Convert(converter = BoundingBoxConverter.class)
    private BoundingBox boundingBox;

    @Column
    @Convert(converter = StrokesConverter.class)
    private Strokes strokes;

    @Column (name = "approximate_x")
    private Integer approximateX;

    @Column (name="agnostic_encoding")
    @Convert(converter = AgnosticSymbolConverter.class)
    private AgnosticSymbol agnosticSymbol;

    public Symbol() {
    }

    public Symbol(Region region, AgnosticSymbol agnosticSymbol, BoundingBox boundingBox, String comments, Strokes strokes, Integer approximateX) {
        this.region = region;
        this.agnosticSymbol = agnosticSymbol;
        this.boundingBox = boundingBox;
        this.strokes = strokes;
        this.comments = comments;
        this.approximateX = approximateX;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @JsonIgnore // use getAgnosticSymbolType + getPositionInStaff instead
    public AgnosticSymbol getAgnosticSymbol() {
        return agnosticSymbol;
    }

    @Transient
    public String getAgnosticSymbolType() {
        return agnosticSymbol.getSymbol().toAgnosticString();
    }

    @Transient
    public String getPositionInStaff() {
        return agnosticSymbol.getPositionInStaff().toString();
    }

    public void setAgnosticSymbol(AgnosticSymbol agnosticSymbol) {
        this.agnosticSymbol = agnosticSymbol;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Strokes getStrokes() {
        return strokes;
    }

    public void setStrokes(Strokes strokes) {
        this.strokes = strokes;
    }

    public Integer getApproximateX() {
        return approximateX;
    }

    public void setApproximateX(Integer approximateX) {
        this.approximateX = approximateX;
    }
}
