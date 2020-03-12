package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IChord;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;

public class Chord extends DurationalSingle implements IChord {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
