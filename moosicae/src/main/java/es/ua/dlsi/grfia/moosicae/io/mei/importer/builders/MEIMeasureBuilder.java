package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
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
    private MEIMeasureRightProperty right;

    public MEIMeasureBuilder() {
        layers = new LinkedList<>();
    }

    public void add(MEIStaff layer) {
        this.layers.add(layer);
    }

    public void from(MEIMeasureRightProperty right) {
        this.right = right;
    }

    @Override
    public MEIMeasure build() throws IMException {
        return new MEIMeasure(getId(), right, layers.toArray(new MEIStaff[layers.size()]));
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);

        Optional<String> rightAttr = xmlImporterParam.getAttribute("right");
        if (rightAttr.isPresent()) {
            right = new MEIMeasureRightProperty(rightAttr.get());
        }
    }
}
