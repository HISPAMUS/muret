package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Rest extends DurationalSingle implements IRest {
    public Rest(@NotNull IId id, @NotNull IFigure figure, @Nullable IDots dots) {
        super(id, figure, dots);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public Rest clone() {
        return new Rest(IdGenerator.getInstance().generateUniqueId(), figure, dots);
    }

    @Override
    public String toString() {
        return "Rest{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
