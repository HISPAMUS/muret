package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IFigureBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlFigureBuilder extends IFigureBuilder implements IImporterAdapter<IFigure, XMLImporterParam> {
    public MxmlFigureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        int meterUnit = Integer.parseInt(xmlImporterParam.getCharacters().get()) / MusicXMLExporterVisitor.MAX_DUR;
        //TODO - meter unit ¿cuando tiene puntillos? - mejor buscar type... --- ¿es obligatorio type?
        EFigures figure = EFigures.findMeterUnit(meterUnit, ENotationTypes.eModern);
        from(figure);
    }
}
