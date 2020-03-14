package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.EFigures;
import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IRest;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Rest extends DurationalSingle implements IRest {
    public Rest(EFigures figure, Optional<IDots> dots) {
        super(figure, dots);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public Rest clone() {
        return new Rest(figure, dots);
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
