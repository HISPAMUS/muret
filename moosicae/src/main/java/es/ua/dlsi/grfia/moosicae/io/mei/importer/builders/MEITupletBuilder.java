package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ITuplet;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.builders.ITupletBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIBeam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * MEI allows the encoding of beams including tuplets or tuplets including beams. MEIBeam does not implement any IVoiced interface, so we handle it here
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class MEITupletBuilder extends ITupletBuilder implements IImporterAdapter<ITuplet, XMLImporterParam> {
    private MEIBeam beam;

    public MEITupletBuilder from(MEIBeam beam) {
        this.beam = beam;
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
        Optional<String> num = xmlImporterParam.getAttribute("num");
        if (!num.isPresent()) {
            throw new IMException("Missing parameter 'num' in tuplet");
        }
        Optional<String> numBase = xmlImporterParam.getAttribute("numbase");
        if (!numBase.isPresent()) {
            throw new IMException("Missing parameter 'numBase' in tuplet");
        }

        from(ICoreAbstractFactory.getInstance().createTupletActual(null, Integer.parseInt(num.get())));
        from(ICoreAbstractFactory.getInstance().createTupletNormal(null, Integer.parseInt(numBase.get())));
    }

    @Override
    public ITuplet build() throws IMException {
        if (beam != null) {
            // the elements inside the mei beam are added here - it is used for the XML structure <tuplet><beam>...</beam></tuplet>
            for (IVoiced voiced : beam.getChildren()) {
                children.add(voiced);
            }
        }
        return super.build();
    }
}
