package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * It uses the decorator pattern
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MusicXMLNote implements IMusicXMLPartItem, INote {
    @NotNull
    private final INote note;

    private final StaffNumber staffNumber;

    private final VoiceNumber voiceNumber;

    private final MusicXMLChord chord;


    public MusicXMLNote(@NotNull INote note,  StaffNumber staffNumber,  VoiceNumber voiceNumber,  MusicXMLChord chord) {
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
    public IPitch getPitch() {
        return null;
    }

    @Override
    public IFigure getFigure() {
        return null;
    }

    @Override
    public Optional<IDots> getDots() {
        return Optional.empty();
    }

    @Override
    public Time getDuration() {
        return null;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {

    }

    @Override
    public IId getId() {
        return null;
    }

    @Override
    public ICoreObject clone() {
        return null;
    }

    @Override
    public ICoreItem[] getItems() {
        return new ICoreItem[] {this.getNote()};
    }
}
