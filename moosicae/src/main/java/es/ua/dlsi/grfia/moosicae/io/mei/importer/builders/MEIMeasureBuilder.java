package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.ILeftBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.core.properties.IRightBarline;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIMeasure;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaff;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIMeasureBuilder extends MEIObjectBuilder<MEIMeasure> {
    private final List<MEIStaff> layers;
    private INumber number;
    private ILeftBarline leftBarline;
    private IRightBarline rightBarline;

    public MEIMeasureBuilder() {
        layers = new LinkedList<>();
    }

    public void add(MEIStaff layer) {
        this.layers.add(layer);
    }

    public void from(ILeftBarline left) {
        this.leftBarline = left;
    }
    public void from(IRightBarline right) {
        this.rightBarline = right;
    }

    @Override
    public MEIMeasure build() throws IMException {
        return new MEIMeasure(getId(), number, leftBarline, rightBarline, layers.toArray(new MEIStaff[layers.size()]));
    }

    private EBarlineTypes convertToBarline(String barlineType) throws IMException {
        switch (barlineType) {
            case "single":
                return EBarlineTypes.single;
            case "end":
                return EBarlineTypes.end;
            case "invisBar":
                return EBarlineTypes.hidden;
            case "dbl":
                return EBarlineTypes.doubleThin;
            case "dashedDashed":
                return EBarlineTypes.dashed;
            case "rptstart":
                return EBarlineTypes.repeatStart;
            case "rptend":
                return EBarlineTypes.repeatEnd;
            case "rptboth":
                return EBarlineTypes.repeatBoth;
            default:
                throw new IMException("Unsupported barline type: " + barlineType);
        }
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);

        Optional<String> numberStr = xmlImporterParam.getAttribute("n");
        if (numberStr.isPresent()) {
            try {
                number = ICoreAbstractFactory.getInstance().createNumber(null, Integer.parseInt(numberStr.get()));
            } catch (Throwable t) {
                throw new IMException("Cannot convert to integer measure number '" + numberStr + "'");
            }
        }

        Optional<String> leftAttr = xmlImporterParam.getAttribute("left");
        if (leftAttr.isPresent()) {
            leftBarline = ICoreAbstractFactory.getInstance().createLeftBarline(null, convertToBarline(leftAttr.get()));
        }

        Optional<String> rightAttr = xmlImporterParam.getAttribute("right");
        if (rightAttr.isPresent()) {
            rightBarline = ICoreAbstractFactory.getInstance().createRightBarline(null, convertToBarline(rightAttr.get()));
        }
    }
}
