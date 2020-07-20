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
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEINoteBuilder extends INoteBuilder implements IImporterAdapter<INote, XMLImporterParam> {
    /**
     * In MEI the alteration is child of the note because there is no pitch element inside note
     */
    private IAlteration alteration;
    private IPitchBuilder pitchBuilder;

    public MEINoteBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public MEINoteBuilder from(IAlteration alteration) {
        this.alteration = alteration;
        return this;
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
            pitchBuilder = new IPitchBuilder(coreObjectFactory);
            Optional<EDiatonicPitches> diatonicPitch = MEIAttributesParsers.getInstance().parseDiatonicPitch(xmlImporterParam);
            if (diatonicPitch.isPresent()) {
                pitchBuilder.from(diatonicPitch.get());
            }

            Optional<Integer> octave = MEIAttributesParsers.getInstance().parseOctave(xmlImporterParam);
            if (octave.isPresent()) {
                pitchBuilder.from(octave.get());
            }

            //TODO accid sin .ges
            Optional<EAccidentalSymbols> eAccidentalSymbol = MEIAttributesParsers.getInstance().parseAccidentalSymbol(xmlImporterParam, "accid.ges");
            if (eAccidentalSymbol.isPresent()) {
                IAlterationBuilder alterationBuilder = new IAlterationBuilder(coreObjectFactory);
                alterationBuilder.from(eAccidentalSymbol.get());
                pitchBuilder.from(alterationBuilder.build());
            }

            INoteHead noteHead = coreObjectFactory.createNoteHead(null, pitchBuilder.build(), null); //TODO ties
            from(noteHead);
        }
    }

    @Override
    public INote build() throws IMException {
        if (this.pitchBuilder != null) {
            if (alteration != null) {
                this.pitchBuilder.from(alteration);
                INoteHead noteHead = coreObjectFactory.createNoteHead(null, pitchBuilder.build(), null); //TODO ties;
                this.from(noteHead);
            }
        } else {
            throw new IMException("Missing pitch builder");
        }

        return super.build();
    }
}