package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IStemBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEINoteBuilder extends CoreObjectBuilder<IPitchedDurationalSingle> implements IImporterAdapter<IPitchedDurationalSingle, XMLImporterParam> {
    /**
     * In MEI the alteration is child of the note because there is no pitch element inside note
     */
    private IAlteration alteration;
    private IPitchBuilder pitchBuilder;
    private INoteBuilder noteBuilder;

    private Optional<EStemDirection> eStemDirection;
    private Optional<EGraceNoteType> eGraceNoteType;

    public MEINoteBuilder() {
        this.noteBuilder = new INoteBuilder();
    }

    public MEINoteBuilder from(IAlteration alteration) {
        this.alteration = alteration;
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<EFigures> figure = MEIAttributesParsers.getInstance().parseFigure(xmlImporterParam);
        if (figure.isPresent()) {
            this.noteBuilder.from(figure.get());
        }
        Optional<Integer> dots = MEIAttributesParsers.getInstance().parseDots(xmlImporterParam);
        if (dots.isPresent()) {
            this.noteBuilder.from(dots.get());
        }

        if (xmlImporterParam.hasAttributes()) { // pname... are included as parameters
            pitchBuilder = new IPitchBuilder();
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
                IAlterationBuilder alterationBuilder = new IAlterationBuilder();
                alterationBuilder.from(eAccidentalSymbol.get());
                pitchBuilder.from(alterationBuilder.build());
            }

            INoteHead noteHead = ICoreAbstractFactory.getInstance().createNoteHead(null, pitchBuilder.build(), null); //TODO ties
            this.noteBuilder.from(noteHead);

            eStemDirection = MEIAttributesParsers.getInstance().parseStem(xmlImporterParam, "stem.dir");
            eGraceNoteType = MEIAttributesParsers.getInstance().parseGraceNoteType(xmlImporterParam);
        }
    }

    @Override
    public IPitchedDurationalSingle build() throws IMException {
        if (this.pitchBuilder != null) {
            if (alteration != null) { //TODO Should accidental be implemented as a decorator as we do with stem or grace?
                this.pitchBuilder.from(alteration);
                INoteHead noteHead = ICoreAbstractFactory.getInstance().createNoteHead(null, pitchBuilder.build(), null); //TODO ties;
                this.noteBuilder.from(noteHead);
            }
        } else {
            throw new IMException("Missing pitch builder");
        }

        IPitchedDurationalSingle note = this.noteBuilder.build();
        // now add all decorators
        if (this.eStemDirection != null && this.eStemDirection.isPresent()) {
            IStem stem = ICoreAbstractFactory.getInstance().createStem(null, this.eStemDirection.get());
            IStemmedBuilder stemmedBuilder = new IStemmedBuilder();
            stemmedBuilder.from(note).from(stem);
            note = stemmedBuilder.build();
        }

        if (this.eGraceNoteType != null && this.eGraceNoteType.isPresent()) {
            IGraceNoteType graceNoteType = ICoreAbstractFactory.getInstance().createGraceNoteType(null, this.eGraceNoteType.get());
            IGraceBuilder graceBuilder = new IGraceBuilder();
            graceBuilder.from(note).from(graceNoteType);
            note = graceBuilder.build();
        }
        return note;
    }
}
