package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.IRest;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IRestBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/05/2021
 */
public class MEIRestBuilder extends IRestBuilder implements IImporterAdapter<IRest, XMLImporterParam> {
    public MEIRestBuilder() {
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<EFigures> figure = MEIAttributesParsers.getInstance().parseFigure(xmlImporterParam);
        if (figure.isPresent()) {
            this.from(figure.get());
        }
        Optional<Integer> dots = MEIAttributesParsers.getInstance().parseDots(xmlImporterParam);
        if (dots.isPresent()) {
            this.from(dots.get());
        }
    }

    @Override
    public IRest build() throws IMException {
        return super.build();
    }
}
