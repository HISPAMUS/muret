package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class NoteHead extends CoreProperty implements INoteHead {
    @NotNull
    private final IPitch pitch;
    private ITie tiedToNext;

    public NoteHead(IId id, @NotNull IPitch pitch, ITie tiedToNext) {
        super(id);
        this.pitch = pitch;
        this.tiedToNext = tiedToNext;
    }

    @Override
    public NoteHead clone() {
        return new NoteHead(null, pitch, null); // we remove the ties

    }

    @Override
    public IPitch getPitch() {
        return pitch;
    }

    @Override
    public Optional<ITie> getStartsTie() {
        return Optional.ofNullable(tiedToNext);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoteHead)) return false;

        NoteHead noteHead = (NoteHead) o;

        if (!pitch.equals(noteHead.pitch)) return false;
        return tiedToNext != null ? tiedToNext.equals(noteHead.tiedToNext) : noteHead.tiedToNext == null;
    }

    @Override
    public int hashCode() {
        int result = pitch.hashCode();
        result = 31 * result + (tiedToNext != null ? tiedToNext.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NoteHead{" +
                "pitch=" + pitch +
                ", tiedToNext=" + tiedToNext +
                "} " + super.toString();
    }
}
