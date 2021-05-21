package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IStemBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITieBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
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
    private ITie tie;

    public MEINoteBuilder() {
    }

    public MEINoteBuilder from(IAlteration alteration) {
        this.alteration = alteration;
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
        Optional<EFigures> figure = MEIAttributesParsers.getInstance().parseFigure(xmlImporterParam);
        if (figure.isPresent()) {
            this.from(figure.get());
        }
        Optional<Integer> dots = MEIAttributesParsers.getInstance().parseDots(xmlImporterParam);
        if (dots.isPresent()) {
            this.from(dots.get());
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

            Optional<EStemDirection> eStemDirection = MEIAttributesParsers.getInstance().parseStem(xmlImporterParam, "stem.dir");
            if (eStemDirection.isPresent()) {
                this.from(ICoreAbstractFactory.getInstance().createStem(null, eStemDirection.get()));
            }

            Optional<String> tieStr = xmlImporterParam.getAttribute("tie");
            if (tieStr.isPresent() && (tieStr.get().equals("i") || tieStr.get().equals("m"))) {
                tie = ICoreAbstractFactory.getInstance().createTie(null, null);
            }

            Optional<EGraceNoteType> eGraceNoteType = MEIAttributesParsers.getInstance().parseGraceNoteType(xmlImporterParam);
            if (eGraceNoteType.isPresent()) {
                this.from(ICoreAbstractFactory.getInstance().createGraceNoteType(null, eGraceNoteType.get()));
            }

            //INoteHead noteHead = ICoreAbstractFactory.getInstance().createNoteHead(null, pitchBuilder.build(), tie);
            //this.from(noteHead);


        }
    }

    @Override
    public INote build() throws IMException {
        if (this.pitchBuilder != null) {
            if (alteration != null) {
                this.pitchBuilder.from(alteration);
            }
            INoteHead noteHead = ICoreAbstractFactory.getInstance().createNoteHead(null, pitchBuilder.build(), tie);
            this.from(noteHead);
        } else {
            throw new IMException("Missing pitch builder");
        }

        return super.build();
    }
}
