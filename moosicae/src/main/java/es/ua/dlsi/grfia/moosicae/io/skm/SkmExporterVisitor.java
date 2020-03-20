package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmCoreSymbol;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporterVisitor implements IExporterVisitor<SkmExporterVisitorTokenParam> {

    @Override
    public void export(IClef clef, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*clef");
        export(clef.getSignType(), inputOutput);
        inputOutput.append(clef.getLine());
        inputOutput.buildAndAddToken(clef);
    }

    @Override
    public void export(IClefSign clefSign, SkmExporterVisitorTokenParam inputOutput) {
        inputOutput.append(clefSign.getClefSign().name().toUpperCase());
    }

    @Override
    public void export(INote note, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        export(note.getFigure(), inputOutput);
        if (note.getDots().isPresent()) {
            export(note.getDots().get(), inputOutput);
        }
        export(note.getPitch(), inputOutput);
        inputOutput.buildAndAddToken(note);
    }

    @Override
    public void export(IRest rest, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        export(rest.getFigure(), inputOutput);
        if (rest.getDots().isPresent()) {
            export(rest.getDots().get(), inputOutput);
        }
        inputOutput.append("r");
        inputOutput.buildAndAddToken(rest);
    }

    @Override
    public void export(IMultimeasureRest mrest, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("rr");
        inputOutput.append(mrest.getMeasureCount());
        inputOutput.buildAndAddToken(mrest);
    }

    @Override
    public void export(IFractionalTimeSignature meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(meter.getNumerator());
        inputOutput.append('/');
        inputOutput.append(meter.getDenominator());
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void export(ICutTime meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*met(c|)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void export(ICommonTime meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*met(c)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void export(IChord chord, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        export(chord.getFigure(), inputOutput);
        if (chord.getDots().isPresent()) {
            export(chord.getDots().get(), inputOutput);
        }
        for (IPitch pitch: chord.getPitches()) {
            export(pitch, inputOutput);
        }
        inputOutput.buildAndAddToken(chord);
    }

    @Override
    public void export(ICustos custos, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*custos");
        export(custos.getPitch(), inputOutput);
        inputOutput.buildAndAddToken(custos);
    }

    @Override
    public void export(IKey key, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        if (!(inputOutput.getLastToken() instanceof SkmCoreSymbol)
        || !((SkmCoreSymbol) inputOutput.getLastToken()).getSymbol().equals(key.getKeySignature())) {
            export(key.getKeySignature(), inputOutput); // do not repeat previous explicit key signature and the key signature of the key
        }

        String diatonicPitch;
        switch (key.getMode().getMode()) {
            case major:
                diatonicPitch = key.getPitchClass().getDiatonicPitch().getDiatonicPitch().name().toUpperCase();
                break;
            case minor:
                diatonicPitch = key.getPitchClass().getDiatonicPitch().getDiatonicPitch().name().toLowerCase();
                break;
            default:
                throw new IMException("Unknown mode: " + key.getMode().getMode());
        }
        inputOutput.append('*');
        inputOutput.append(diatonicPitch);
        if (key.getPitchClass().getAccidental().isPresent()) {
            export(key.getPitchClass().getAccidental().get(), inputOutput);
        }
        inputOutput.append(':');
        inputOutput.buildAndAddToken(key);
    }

    @Override
    public void export(ICommonAlterationKey commonAlterationKey, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        export((IKey)commonAlterationKey, inputOutput);
    }

    @Override
    public void export(IMode mode, SkmExporterVisitorTokenParam inputOutput) {

    }


    @Override
    public void export(IKeySignature keySignature, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*k[");
        for (IPitchClass pitchClass: keySignature.getPitchClasses()) {
            export(pitchClass, inputOutput);
        }
        inputOutput.append(']');
        inputOutput.buildAndAddToken(keySignature);
    }

    @Override
    public void export(IVoice exportVisitor, SkmExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void export(IDiatonicPitch diatonicPitch, SkmExporterVisitorTokenParam inputOutput) {
        inputOutput.append(diatonicPitch.getDiatonicPitch().name().toLowerCase());
    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, SkmExporterVisitorTokenParam inputOutput) {
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
        inputOutput.append(encoding);
    }

    @Override
    public void export(IAccidentalSymbol accidental, SkmExporterVisitorTokenParam inputOutput) {
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
    public void export(IAlteration alteration, SkmExporterVisitorTokenParam inputOutput) {
        export(alteration.getAccidentalSymbol(), inputOutput);
        if (alteration.getAlterationDisplayType().isPresent()) {
            export(alteration.getAlterationDisplayType().get(), inputOutput);
        }
    }

    @Override
    public void export(IPitchClass pitchClass, SkmExporterVisitorTokenParam inputOutput) {
        export(pitchClass.getDiatonicPitch(), inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            export(pitchClass.getAccidental().get(), inputOutput);
        }
    }

    public void exportDiatonicPitchAndOctave(IDiatonicPitch diatonicPitch, IOctave octave, SkmExporterVisitorTokenParam inputOutput) {
        String middleOctaveNote = diatonicPitch.getDiatonicPitch().name().toLowerCase();

        int octaveValue = octave.getNumber();
        if (octaveValue < 4) {
            int characters = 4 - octaveValue;
            middleOctaveNote = middleOctaveNote.toUpperCase();
            for (int i=0; i<characters; i++) {
                inputOutput.append(middleOctaveNote);
            }
        } else if (octaveValue == 4) {
            inputOutput.append(middleOctaveNote);
        } else {
            int characters = 1 + octaveValue - 4;
            for (int i=0; i<characters; i++) {
                inputOutput.append(middleOctaveNote);
            }
        }
    }

    @Override
    public void export(IPitch pitch, SkmExporterVisitorTokenParam inputOutput) {
        exportDiatonicPitchAndOctave(pitch.getDiatonicPitch(), pitch.getOctave(), inputOutput);
        if (pitch.getAlteration().isPresent()) {
            export(pitch.getAlteration().get(), inputOutput);
        }
    }

    @Override
    public void export(IDots dots, SkmExporterVisitorTokenParam inputOutput) {
        for (int i=0; i<dots.getCount(); i++) {
            inputOutput.append('.');
        }
    }

    @Override
    public void export(IOctave octave, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        // not used, exported using exportDiatonicPitchAndOctave
    }

    @Override
    public void export(IFigure figure, SkmExporterVisitorTokenParam inputOutput) {
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
    public void export(IMetronomeMark metronomeMark, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        if (metronomeMark.getDots().isPresent()) {
            throw new IMException("Unsupported dots in metronome"); //TODO
        }
        if (metronomeMark.getFigure().getFigure() != EFigures.QUARTER) {
            throw new IMException("Unsupported figure in metronome: " + metronomeMark.getFigure().getFigure()); //TODO
        }
        inputOutput.append("MM");
        inputOutput.append(metronomeMark.getValue());
        inputOutput.buildAndAddToken(metronomeMark);
    }

    @Override
    public void export(IBarline barline, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append('=');
        if (barline.getBarNumber().isPresent()) {
            inputOutput.append(barline.getBarNumber().get());
        }
        if (barline.getBarlineType().isPresent()) {
            export(barline.getBarlineType().get(), inputOutput);
        }
        inputOutput.buildAndAddToken(barline);
    }

    @Override
    public void export(IBarlineType barlineType, SkmExporterVisitorTokenParam inputOutput) throws IMException {
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

    @Override
    public void export(IPageBeginning pageBeginning, SkmExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void export(ISystemBeginning systemBeginning, SkmExporterVisitorTokenParam inputOutput) {

    }


}
