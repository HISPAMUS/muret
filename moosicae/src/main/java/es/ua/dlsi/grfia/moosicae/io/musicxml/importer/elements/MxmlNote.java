package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.IMark;
import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;

import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * It uses the decorator pattern in order to add some other parameters
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlNote extends MxmlObject implements IMxmlPartItem, INote {
    @NotNull
    private final INote note;

    private final StaffNumber staffNumber;

    private final VoiceNumber voiceNumber;

    private final MxmlChord chord;


    public MxmlNote(@NotNull INote note, StaffNumber staffNumber, VoiceNumber voiceNumber, MxmlChord chord) {
        super(note.getId());
        this.note = note;
        this.staffNumber = staffNumber;
        this.voiceNumber = voiceNumber;
        this.chord = chord;
    }

    public INote getNote() {
        return note;
    }

    public Optional<StaffNumber> getStaffNumber() {
        return Optional.ofNullable(staffNumber);
    }

    public Optional<VoiceNumber> getVoiceNumber() {
        return Optional.ofNullable(voiceNumber);
    }

    @Override
    public INoteHead getNoteHead() {
        return note.getNoteHead();
    }

    @Override
    public IFigure getFigure() {
        return note.getFigure();
    }

    @Override
    public Optional<IDots> getDots() {
        return note.getDots();
    }

    @Override
    public ITime getDuration() {
        return note.getDuration();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {

    }

    @Override
    public IId getId() {
        return note.getId();
    }

    @Override
    public MxmlNote clone() {
        return new MxmlNote(note, staffNumber, voiceNumber, chord);
    }

    @Override
    public IVoicedSingle[] getItems() {
        return new IVoicedSingle[] {this.getNote()};
    }


    @Override
    public Optional<IStem> getStem() {
        return note.getStem();
    }

    @Override
    public Optional<IGraceNoteType> getGraceNoteType() {
        return note.getGraceNoteType();
    }

    @Override
    public IConnector[] getConnectors() {
        throw new UnsupportedOperationException("TO-DO");
    }

    @Override
    public IMark[] getMarks() {
        return new IMark[0];
    }

    @Override
    public void addMark(IMark mark) {

    }

    @Override
    public void addConnector(IConnector connector) {

    }
}
