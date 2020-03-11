package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IChord;
import es.ua.dlsi.grfia.im4.core.IExporterVisitor;

public class Chord extends DurationalSingle implements IChord {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
