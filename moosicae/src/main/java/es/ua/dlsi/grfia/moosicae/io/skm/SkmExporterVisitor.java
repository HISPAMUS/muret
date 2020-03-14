package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporterVisitor implements IExporterVisitor<StringBuilder> {

    @Override
    public void export(IClef clef, StringBuilder inputOutputOutput) {
        inputOutputOutput.append("*clef");
        inputOutputOutput.append(clef.getSignType().name());
        inputOutputOutput.append(clef.getLine());
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
    public void export(IFractionalTimeSignature meter, StringBuilder inputOutputOutput) {
        inputOutputOutput.append("M");
        inputOutputOutput.append(meter.getNumerator());
        inputOutputOutput.append('/');
        inputOutputOutput.append(meter.getDenominator());
    }

    @Override
    public void export(ICutTime meter, StringBuilder inputOutputOutput) {
        inputOutputOutput.append("met(c|)");
    }

    @Override
    public void export(ICommonTime meter, StringBuilder inputOutputOutput) {
        inputOutputOutput.append("met(c)");
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
        inputOutputOutput.append("k[");
        for (IPitchClass pitchClass: keySignature.getPitchClasses()) {
            export(pitchClass, inputOutputOutput);
        }
        inputOutputOutput.append(']');
    }

    @Override
    public void export(IVoice exportVisitor, StringBuilder inputOutput) {

    }

    @Override
    public void export(EDiatonicPitches diatonicPitch, StringBuilder inputOutput) {
        inputOutput.append(diatonicPitch.name().toLowerCase());
    }

    @Override
    public void export(EAccidentals accidental, StringBuilder inputOutput) {
        String encoding;
        switch (accidental) {
            case DOUBLE_FLAT:
                encoding = "--";
                break;
            case FLAT:
                encoding = "-";
                break;
            case NATURAL:
                encoding = "n";
                break;
            case SHARP:
                encoding = "#";
                break;
            case DOUBLE_SHARP:
                encoding = "##";
                break;
            default:
                throw new IMRuntimeException("Unknown accidental: " + accidental);
        }
        inputOutput.append(encoding);
    }

    @Override
    public void export(IPitchClass pitchClass, StringBuilder inputOutput) {
        export(pitchClass, inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            export(pitchClass.getAccidental().get(), inputOutput);
        }
    }

}
