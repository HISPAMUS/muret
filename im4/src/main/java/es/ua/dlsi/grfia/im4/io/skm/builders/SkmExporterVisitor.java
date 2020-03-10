package es.ua.dlsi.grfia.im4.io.skm.builders;

import es.ua.dlsi.grfia.im4.core.*;

public class SkmExporterVisitor implements IExportVisitor<StringBuilder> {

    @Override
    public void export(IClef clef, StringBuilder stringBuilder) {
        stringBuilder.append("*clef");
        stringBuilder.append(clef.getSignType().name());
        stringBuilder.append(clef.getLine());
    }

    @Override
    public void export(INote note, StringBuilder inputOutput) {

    }

    @Override
    public void export(IRest rest, StringBuilder inputOutput) {

    }

    @Override
    public void export(IMultimeasureRest mrest, StringBuilder inputOutput) {

    }

    @Override
    public void export(IMeter meter, StringBuilder inputOutputOutput) {

    }

    @Override
    public void export(IChord chord, StringBuilder inputOutputOutput) {

    }

    @Override
    public void export(ICustos custos, StringBuilder inputOutputOutput) {

    }

    @Override
    public void export(IKey key, StringBuilder inputOutputOutput) {

    }

    @Override
    public void export(IKeySignature keySignature, StringBuilder inputOutputOutput) {

    }

    @Override
    public void export(IVoice exportVisitor, StringBuilder inputOutput) {

    }

}
