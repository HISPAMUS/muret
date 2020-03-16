package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporterVisitor implements IExporterVisitor<StringBuilder> {

    @Override
    public void export(IClef clef, StringBuilder inputOutput) {
        inputOutput.append("*clef");
        export(clef.getSignType(), inputOutput);
        inputOutput.append(clef.getLine());
    }

    @Override
    public void export(IClefSign clefSign, StringBuilder inputOutput) {
        inputOutput.append(clefSign.getClefSign().name().toUpperCase());
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
        inputOutput.append("*M");
        inputOutput.append(meter.getNumerator());
        inputOutput.append('/');
        inputOutput.append(meter.getDenominator());
    }

    @Override
    public void export(ICutTime meter, StringBuilder inputOutput) {
        inputOutput.append("*met(c|)");
    }

    @Override
    public void export(ICommonTime meter, StringBuilder inputOutput) {
        inputOutput.append("*met(c)");
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
        inputOutput.append("*k[");
        for (IPitchClass pitchClass: keySignature.getPitchClasses()) {
            export(pitchClass, inputOutput);
        }
        inputOutput.append(']');
    }

    @Override
    public void export(IVoice exportVisitor, StringBuilder inputOutput) {

    }

    @Override
    public void export(IDiatonicPitch diatonicPitch, StringBuilder inputOutput) {
        inputOutput.append(diatonicPitch.getDiatonicPitch().name().toLowerCase());
    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, StringBuilder inputOutput) {
        String encoding;
        switch (alterationDisplayType.getAlterationDisplayType()) {
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
        inputOutput.append(encoding);    }

    @Override
    public void export(IAccidentalSymbol accidental, StringBuilder inputOutput) {
        String encoding;
        switch (accidental.getAccidentalSymbol()) {
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
    public void export(IAlteration alteration, StringBuilder inputOutput) {
        export(alteration.getAccidentalSymbol(), inputOutput);
        if (alteration.getAlterationDisplayType().isPresent()) {
            export(alteration.getAlterationDisplayType().get(), inputOutput);
        }
    }

    @Override
    public void export(IPitchClass pitchClass, StringBuilder inputOutput) {
        export(pitchClass.getDiatonicPitch(), inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            export(pitchClass.getAccidental().get(), inputOutput);
        }
    }

    @Override
    public void export(IPitch pitch, StringBuilder inputOutput) {
        export(pitch.getDiatonicPitch(), inputOutput);
        if (pitch.getAlteration().isPresent()) {
            export(pitch.getAlteration().get(), inputOutput);
        }
    }

    @Override
    public void export(IDots dots, StringBuilder inputOutput) {
        for (int i=0; i<dots.getCount(); i++) {
            inputOutput.append('.');
        }
    }

    @Override
    public void export(IFigure figure, StringBuilder inputOutput) {
        String encoding;
        switch (figure.getFigure()) {
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
                break;
            default: // all the other modern notation
                encoding = Integer.toString(figure.getMeterUnit());
        }
        inputOutput.append(encoding);
    }

    @Override
    public void export(IMetronomeMark metronomeMark, StringBuilder inputOutput) throws IMException {
        if (metronomeMark.getDots().isPresent()) {
            throw new IMException("Unsupported dots in metronome"); //TODO
        }
        if (metronomeMark.getFigure().getFigure() != EFigures.QUARTER) {
            throw new IMException("Unsupported figure in metronome: " + metronomeMark.getFigure().getFigure()); //TODO
        }
        inputOutput.append("MM");
        inputOutput.append(metronomeMark.getValue());
    }

    @Override
    public void export(IBarline barline, StringBuilder inputOutput) throws IMException {
        inputOutput.append('=');
        if (barline.getBarNumber().isPresent()) {
            inputOutput.append(barline.getBarNumber().get());
        }
        if (barline.getBarlineType().isPresent()) {
            export(barline.getBarlineType().get(), inputOutput);
        }
    }

    @Override
    public void export(IBarlineType barlineType, StringBuilder inputOutput) throws IMException {
        String encoding;
        switch (barlineType.getBarlineType()) {
            case end:
                encoding = "=";
                break;
            case doubleThin:
                encoding = "||";
                break;
            case hidden:
                encoding = "-";
                break;
            case leftRepeat:
                encoding = "|!:";
                break;
            case leftRightRepeat:
                encoding = ":|!|:";
                break;
            case rightRepeat:
                encoding = ":|!";
                break;
            default:
                throw new IMException("Unkown barline type: " + barlineType.getBarlineType());
        }
        inputOutput.append(encoding);
    }

}
