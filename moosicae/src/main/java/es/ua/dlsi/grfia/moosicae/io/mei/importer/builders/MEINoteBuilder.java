package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEINoteBuilder extends INoteBuilder implements IImporterAdapter<INote, XMLImporterParam> {
    public MEINoteBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<EFigures> figure = MEIAttributesParsers.getInstance().parseFigure(xmlImporterParam);
        if (figure.isPresent()) {
            from(figure.get());
        }
        Optional<Integer> dots = MEIAttributesParsers.getInstance().parseDots(xmlImporterParam);
        if (dots.isPresent()) {
            from(dots.get());
        }

        if (xmlImporterParam.hasAttributes()) { // pname... are included as parameters
            IPitchBuilder pitchBuilder = new IPitchBuilder(coreObjectFactory);
            Optional<EDiatonicPitches> diatonicPitch = MEIAttributesParsers.getInstance().parseDiatonicPitch(xmlImporterParam);
            if (diatonicPitch.isPresent()) {
                pitchBuilder.from(diatonicPitch.get());
            }

            Optional<Integer> octave = MEIAttributesParsers.getInstance().parseOctave(xmlImporterParam);
            if (octave.isPresent()) {
                pitchBuilder.from(octave.get());
            }

            Optional<EAccidentalSymbols> eAccidentalSymbol = MEIAttributesParsers.getInstance().parseAccidentalSymbol(xmlImporterParam);
            if (eAccidentalSymbol.isPresent()) {
                IAlterationBuilder alterationBuilder = new IAlterationBuilder(coreObjectFactory);
                alterationBuilder.from(eAccidentalSymbol.get());
                pitchBuilder.from(alterationBuilder.build());
            }

            from(pitchBuilder.build());
        }
    }
}
