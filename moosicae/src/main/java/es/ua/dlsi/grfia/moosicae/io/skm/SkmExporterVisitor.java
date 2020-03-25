package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmCoreSymbol;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporterVisitor implements IExporterVisitor<SkmExporterVisitorTokenParam> {

    @Override
    public void exportClef(IClef clef, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*clef");
        exportClefSign(clef.getSignType(), inputOutput);
        if (clef.getLine().isPresent()) {
            inputOutput.append(clef.getLine().get().getValue());
        }
        inputOutput.buildAndAddToken(clef);
    }

    @Override
    public void exportClefSign(IClefSign clefSign, SkmExporterVisitorTokenParam inputOutput) {
        inputOutput.append(clefSign.getValue().name().toUpperCase());
    }

    @Override
    public void exportNote(INote note, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(note.getFigure(), inputOutput);
        if (note.getDots().isPresent()) {
            exportDots(note.getDots().get(), inputOutput);
        }
        exportPitch(note.getPitch(), inputOutput);
        inputOutput.buildAndAddToken(note);
    }

    @Override
    public void exportRest(IRest rest, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(rest.getFigure(), inputOutput);
        if (rest.getDots().isPresent()) {
            exportDots(rest.getDots().get(), inputOutput);
        }
        inputOutput.append("r");
        inputOutput.buildAndAddToken(rest);
    }

    @Override
    public void exportMultimeasureRest(IMultimeasureRest mrest, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("rr");
        inputOutput.append(mrest.getMeasureCount().getValue());
        inputOutput.buildAndAddToken(mrest);
    }

    @Override
    public void exportFractionalTimeSignature(IFractionalTimeSignature meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(meter.getNumerator().getValue());
        inputOutput.append('/');
        inputOutput.append(meter.getDenominator().getValue());
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportCutTime(ICutTime meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*met(c|)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportCommonTime(ICommonTime meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*met(c)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportChord(IChord chord, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(chord.getFigure(), inputOutput);
        if (chord.getDots().isPresent()) {
            exportDots(chord.getDots().get(), inputOutput);
        }
        for (IPitch pitch: chord.getPitches()) {
            exportPitch(pitch, inputOutput);
        }
        inputOutput.buildAndAddToken(chord);
    }

    @Override
    public void exportCustos(ICustos custos, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*custos");
        exportPitch(custos.getPitch(), inputOutput);
        inputOutput.buildAndAddToken(custos);
    }

    @Override
    public void exportKey(IKey key, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        if (!(inputOutput.getLastToken() instanceof SkmCoreSymbol)
        || !((SkmCoreSymbol) inputOutput.getLastToken()).getSymbol().equals(key.getKeySignature())) {
            exportKeySignature(key.getKeySignature(), inputOutput); // do not repeat previous explicit key signature and the key signature of the key
        }

        String diatonicPitch;
        switch (key.getMode().getValue()) {
            case major:
                diatonicPitch = key.getPitchClass().getDiatonicPitch().getValue().name().toUpperCase();
                break;
            case minor:
                diatonicPitch = key.getPitchClass().getDiatonicPitch().getValue().name().toLowerCase();
                break;
            default:
                throw new IMException("Unknown mode: " + key.getMode().getValue());
        }
        inputOutput.append('*');
        inputOutput.append(diatonicPitch);
        if (key.getPitchClass().getAccidental().isPresent()) {
            exportAccidentalSymbol(key.getPitchClass().getAccidental().get(), inputOutput);
        }
        inputOutput.append(':');
        inputOutput.buildAndAddToken(key);
    }

    @Override
    public void exportCommonAlterationKey(ICommonAlterationKey commonAlterationKey, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportKey((IKey)commonAlterationKey, inputOutput);
    }

    @Override
    public void exportMode(IMode mode, SkmExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void exportKeySignature(IKeySignature keySignature, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*k[");
        for (IPitchClass pitchClass: keySignature.getPitchClasses()) {
            exportPitchClass(pitchClass, inputOutput);
        }
        inputOutput.append(']');
        inputOutput.buildAndAddToken(keySignature);
    }

    @Override
    public void exportVoice(IVoice voice, SkmExporterVisitorTokenParam inputOutput) throws IMException {

    }

    @Override
    public void exportDiatonicPitch(IDiatonicPitch diatonicPitch, SkmExporterVisitorTokenParam inputOutput) {
        inputOutput.append(diatonicPitch.getValue().name().toLowerCase());
    }

    @Override
    public void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, SkmExporterVisitorTokenParam inputOutput) {
        String encoding;
        switch (alterationDisplayType.getValue()) {
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
    public void exportAccidentalSymbol(IAccidentalSymbol accidental, SkmExporterVisitorTokenParam inputOutput) {
        String encoding;
        switch (accidental.getValue()) {
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
    public void exportAlteration(IAlteration alteration, SkmExporterVisitorTokenParam inputOutput) {
        exportAccidentalSymbol(alteration.getAccidentalSymbol(), inputOutput);
        if (alteration.getAlterationDisplayType().isPresent()) {
            exportAlterationDisplayType(alteration.getAlterationDisplayType().get(), inputOutput);
        }
    }

    @Override
    public void exportPitchClass(IPitchClass pitchClass, SkmExporterVisitorTokenParam inputOutput) {
        exportDiatonicPitch(pitchClass.getDiatonicPitch(), inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            exportAccidentalSymbol(pitchClass.getAccidental().get(), inputOutput);
        }
    }

    private void exportDiatonicPitchAndOctave(IDiatonicPitch diatonicPitch, IOctave octave, SkmExporterVisitorTokenParam inputOutput) {
        String middleOctaveNote = diatonicPitch.getValue().name().toLowerCase();

        int octaveValue = octave.getValue();
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
    public void exportPitch(IPitch pitch, SkmExporterVisitorTokenParam inputOutput) {
        exportDiatonicPitchAndOctave(pitch.getDiatonicPitch(), pitch.getOctave(), inputOutput);
        if (pitch.getAlteration().isPresent()) {
            exportAlteration(pitch.getAlteration().get(), inputOutput);
        }
    }

    @Override
    public void exportDots(IDots dots, SkmExporterVisitorTokenParam inputOutput) {
        for (int i=0; i<dots.getValue(); i++) {
            inputOutput.append('.');
        }
    }

    @Override
    public void exportOctave(IOctave octave, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        // not used, exported using exportDiatonicPitchAndOctave
    }

    @Override
    public void exportFigure(IFigure figure, SkmExporterVisitorTokenParam inputOutput) {
        String encoding;
        switch (figure.getValue()) {
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
    public void exportMetronomeMark(IMetronomeMark metronomeMark, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        if (metronomeMark.getDots().isPresent()) {
            throw new IMException("Unsupported dots in metronome"); //TODO
        }
        if (metronomeMark.getFigure().getValue() != EFigures.QUARTER) {
            throw new IMException("Unsupported figure in metronome: " + metronomeMark.getFigure().getValue()); //TODO
        }
        inputOutput.append("MM");
        inputOutput.append(metronomeMark.getValue().getValue());
        inputOutput.buildAndAddToken(metronomeMark);
    }

    @Override
    public void exportBarline(IBarline barline, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append('=');
        if (barline.getBarNumber().isPresent()) {
            inputOutput.append(barline.getBarNumber().get().getValue());
        }
        if (barline.getBarlineType().isPresent()) {
            exportBarlineType(barline.getBarlineType().get(), inputOutput);
        }
        inputOutput.buildAndAddToken(barline);
    }

    @Override
    public void exportBarlineType(IBarlineType barlineType, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        String encoding;
        switch (barlineType.getValue()) {
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
                throw new IMException("Unkown barline type: " + barlineType.getValue());
        }
        inputOutput.append(encoding);
    }

    @Override
    public void exportPageBeginning(IPageBeginning pageBeginning, SkmExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void exportSystemBeginning(ISystemBeginning systemBeginning, SkmExporterVisitorTokenParam inputOutput) {

    }


}