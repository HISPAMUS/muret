package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MusicXMLNoteBuilder extends INoteBuilder {
    private StaffNumber staffNumber;
    private VoiceNumber voiceNumber;
    private MusicXMLChord chord;

    public MusicXMLNoteBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public MusicXMLNoteBuilder from(StaffNumber staffNumber) {
        this.staffNumber = staffNumber;
        return this;
    }

    public MusicXMLNoteBuilder from(VoiceNumber voiceNumber) {
        this.voiceNumber = voiceNumber;
        return this;
    }

    public MusicXMLNoteBuilder from(MusicXMLChord chord) {
        this.chord = chord;
        return this;
    }

    @Override
    public MusicXMLNote build() throws IMException {
        INote note = super.build();
        MusicXMLNote musicXMLNote = new MusicXMLNote(note, staffNumber, voiceNumber, chord);
        return musicXMLNote;
    }
}
