package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class PitchedDurationalSingle extends DurationalSingle implements IPitchedDurationalSingle {
    protected final IStem stem;
    protected final IGraceNoteType graceNoteType;

    public PitchedDurationalSingle(IId id, @NotNull IFigure figure, IDots dots, IStem stem, IGraceNoteType graceNoteType) {
        super(id, figure, dots);
        this.stem = stem;
        this.graceNoteType = graceNoteType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PitchedDurationalSingle)) return false;
        if (!super.equals(o)) return false;

        PitchedDurationalSingle that = (PitchedDurationalSingle) o;

        if (stem != null ? !stem.equals(that.stem) : that.stem != null) return false;
        return graceNoteType != null ? graceNoteType.equals(that.graceNoteType) : that.graceNoteType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (stem != null ? stem.hashCode() : 0);
        result = 31 * result + (graceNoteType != null ? graceNoteType.hashCode() : 0);
        return result;
    }

    @Override
    public Optional<IStem> getStem() {
        return Optional.ofNullable(stem);
    }

    @Override
    public Optional<IGraceNoteType> getGraceNoteType() {
        return Optional.ofNullable(graceNoteType);
    }
}
