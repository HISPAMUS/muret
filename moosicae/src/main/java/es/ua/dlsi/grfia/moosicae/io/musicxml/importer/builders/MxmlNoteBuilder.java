package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlChord;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlNote;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.StaffNumber;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.VoiceNumber;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlNoteBuilder extends INoteBuilder implements IImporterAdapter<INote, XMLImporterParam> {
    private StaffNumber staffNumber;
    private VoiceNumber voiceNumber;
    private MxmlChord chord;
    //TODO poner aquí parámetro pitch


    public MxmlNoteBuilder from(StaffNumber staffNumber) {
        this.staffNumber = staffNumber;
        return this;
    }

    public MxmlNoteBuilder from(VoiceNumber voiceNumber) {
        this.voiceNumber = voiceNumber;
        return this;
    }

    public MxmlNoteBuilder from(MxmlChord chord) {
        this.chord = chord;
        return this;
    }

    /**
     * The musicxml does not include a noteHead element, so we admit here pitches and we'll embed into noteHead with ties if required
     */
    public MxmlNoteBuilder from(IPitch pitch) {
        // when a pitch is received, a note head is built
        this.noteHead = ICoreAbstractFactory.getInstance().createNoteHead(null, pitch, null); //TODO ties
        return this;
    }

    @Override
    public MxmlNote build() throws IMException {
        INote note = super.build();
        MxmlNote musicXMLNote = new MxmlNote(note, staffNumber, voiceNumber, chord);
        return musicXMLNote;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        // todo read tie
    }
}
