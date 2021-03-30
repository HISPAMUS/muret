package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Accidental;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Note;

import javax.persistence.*;
import java.util.Comparator;

/**
 * @author drizo
 */
@Entity
public class Symbol extends Auditable implements IAssignableToPart, IDelimitedWithBoundingBox, IID<Long>{
    private static Integer getMiddleX(Symbol symbol) {
        if (symbol.getApproximateX() != null) {
            return symbol.getApproximateX();
        } else if (symbol.getBoundingBox() != null) {
            return (symbol.getBoundingBox().getFromX() + symbol.getBoundingBox().getToX()) / 2;
        } else {
            return null;
        }
    }

    /**
     * It orders symbols given its middle horizontal point or its approximate x
     */
    private static Comparator<? super Symbol> horizontalPositionComparator = new Comparator<Symbol>() {
        @Override
        public int compare(Symbol o1, Symbol o2) {
            Integer o1x = getMiddleX(o1); // sort using approximateX or bounding box
            Integer o2x = getMiddleX(o2);
            int diff = 0;

            AgnosticSymbolType o1Type = o1.getAgnosticSymbol().getSymbol();
            AgnosticSymbolType o2Type = o2.getAgnosticSymbol().getSymbol();

            //TODO parche
            if (o1Type instanceof Note && o2Type instanceof Accidental && o1.getBoundingBox() != null && o2.getBoundingBox() != null && o1.getBoundingBox().containsCenterOfInX(o2.getBoundingBox())) {
                diff = 1; // first accidental
            } else if (o1Type instanceof Accidental && o2Type instanceof Note && o1.getBoundingBox() != null && o2.getBoundingBox() != null && o2.getBoundingBox().containsCenterOfInX(o1.getBoundingBox())) {
                diff = -1; // first accidental
            } else {
                if (o1x != null && o2x != null) {
                    diff = o1x - o2x;
                }

                if (diff == 0 && o1.getBoundingBox() != null && o2.getBoundingBox() != null) {
                    diff = o1.getBoundingBox().getFromY() - o2.getBoundingBox().getFromY();
                }

                if (diff == 0) {
                    diff = o1.hashCode() - o2.hashCode();
                }
            }
             return diff;
        }
    };
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String comments;

    @JsonBackReference (value="region")
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

    /**
     * It can be null because the part is assigned to other element of the score
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="part_id")
    private Part part;

    public Symbol() {
    }

    public Symbol(Region region, AgnosticSymbol agnosticSymbol, BoundingBox boundingBox, String comments, Strokes strokes, Part part, Integer approximateX) {
        this.region = region;
        this.agnosticSymbol = agnosticSymbol;
        this.boundingBox = boundingBox;
        this.strokes = strokes;
        this.comments = comments;
        this.approximateX = approximateX;
        this.part = part;
    }

    public static Comparator<? super Symbol> getHorizontalPositionComparator() {
        return horizontalPositionComparator;
    }

    @Override
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

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @Transient
    public Integer getMiddleX() {
        if (this.getApproximateX() != null) {
            return this.getApproximateX();
        } else if (this.getBoundingBox() != null) {
            return this.getBoundingBox().getFromX();
        } else {
            return null;
        }
    }

    @Transient
    public boolean isVerticallyStacked(Symbol symbol) {
        if (this.getBoundingBox() != null && symbol.getBoundingBox() != null) {
            return this.getBoundingBox().overlapsX(symbol.getBoundingBox());
        } else {
            return false;
        }
    }
}
