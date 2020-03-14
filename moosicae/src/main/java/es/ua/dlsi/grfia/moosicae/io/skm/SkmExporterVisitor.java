package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporterVisitor implements IExporterVisitor<StringBuilder> {

    @Override
    public void export(IClef clef, StringBuilder inputOutput) {
        inputOutput.append("*clef");
        inputOutput.append(clef.getSignType().name());
        inputOutput.append(clef.getLine());
    }

    @Override
    public void export(INote note, StringBuilder inputOutput) {
        export(note.getFigure(), inputOutput);
        if (note.getDots().isPresent()) {
            export(note.getDots().get(), inputOutput);
        }
        export(note.getPitch(), inputOutput);
    }

    @Override
    public void export(IRest rest, StringBuilder inputOutput) {
        export(rest.getFigure(), inputOutput);
        if (rest.getDots().isPresent()) {
            export(rest.getDots().get(), inputOutput);
        }
        inputOutput.append("r");
    }

    @Override
    public void export(IMultimeasureRest mrest, StringBuilder inputOutput) {
        inputOutput.append("rr");
        inputOutput.append(mrest.getMeasureCount());
    }

    @Override
    public void export(IFractionalTimeSignature meter, StringBuilder inputOutput) {
        inputOutput.append("M");
        inputOutput.append(meter.getNumerator());
        inputOutput.append('/');
        inputOutput.append(meter.getDenominator());
    }

    @Override
    public void export(ICutTime meter, StringBuilder inputOutput) {
        inputOutput.append("met(c|)");
    }

    @Override
    public void export(ICommonTime meter, StringBuilder inputOutput) {
        inputOutput.append("met(c)");
    }

    @Override
    public void export(IChord chord, StringBuilder inputOutput) {
        export(chord.getFigure(), inputOutput);
        if (chord.getDots().isPresent()) {
            export(chord.getDots().get(), inputOutput);
        }
        for (IPitch pitch: chord.getPitches()) {
            export(pitch, inputOutput);
        }

    }

    @Override
    public void export(ICustos custos, StringBuilder inputOutput) {
        inputOutput.append("*custos");
        export(custos.getPitch(), inputOutput);
    }

    @Override
    public void export(IKey key, StringBuilder inputOutput) {
        throw new UnsupportedOperationException("Unimplemented key"); //TODO
    }

    @Override
    public void export(IKeySignature keySignature, StringBuilder inputOutput) {
        inputOutput.append("k[");
        for (IPitchClass pitchClass: keySignature.getPitchClasses()) {
            export(pitchClass, inputOutput);
        }
        inputOutput.append(']');
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
    public void export(EAlterationDisplayType alterationDisplayType, StringBuilder inputOutput) {
        String encoding;
        switch (alterationDisplayType) {
            case ficta:
                encoding = "Y";
                break;
            case editorial:
                encoding = "YY";
                break;
            case cautionary:
                encoding = "yy";
                break;
            case hidden:
                encoding = "yy";
                break;
            default:
                throw new IMRuntimeException("Unknown alteration display type: " + alterationDisplayType);
        }
        inputOutput.append(encoding);
    }

    @Override
    public void export(IAlteration alteration, StringBuilder inputOutput) {
        export(alteration.getAccidental(), inputOutput);
        if (alteration.getAlterationDisplayType().isPresent()) {
            export(alteration.getAlterationDisplayType().get(), inputOutput);
        }
    }

    @Override
    public void export(IPitchClass pitchClass, StringBuilder inputOutput) {
        export(pitchClass, inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            export(pitchClass.getAccidental().get(), inputOutput);
        }
    }

    @Override
    public void export(IPitch pitch, StringBuilder inputOutput) {
        export(pitch.getDiatonicPitch(), inputOutput);
        export(pitch.getAlteration(), inputOutput);
    }

    @Override
    public void export(IDots dots, StringBuilder inputOutput) {
        for (int i=0; i<dots.getCount(); i++) {
            inputOutput.append('.');
        }
    }

    @Override
    public void export(EFigures figures, StringBuilder inputOutput) {
        String encoding;
        switch (figures) {
            case MAXIMA:
                encoding = "X";
                break;
            case LONGA:
                encoding = "L";
                break;
            case BREVE:
                encoding = "S";
                break;
            case SEMIBREVE:
                encoding = "s";
                break;
            case MINIM:
                encoding = "M";
                break;
            case SEMIMINIM:
                encoding = "m";
                break;
            case FUSA:
                encoding = "U";
                break;
            case SEMIFUSA:
                encoding = "u";
                break;
            case OCTUPLE_WHOLE: // modern
                encoding = "000";
                break;
            case QUADRUPLE_WHOLE: // modern
                encoding = "00";
                break;
            case DOUBLE_WHOLE: // modern
                encoding = "0";
            default: // all the other modern notation
                encoding = Integer.toString(figures.getMeterUnit());
        }
        inputOutput.append(encoding);
    }

}
