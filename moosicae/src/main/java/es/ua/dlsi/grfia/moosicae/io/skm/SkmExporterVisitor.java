package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmCoreSymbol;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmPart;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporterVisitor implements IExporterVisitor<SkmExporterVisitorTokenParam> {
    static final String SEP = "·";

    public String exportPart(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*part");
        stringBuilder.append(SEP);
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    @Override
    public void exportClef(IClef clef, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*clef");
        inputOutput.append(SEP);
        exportClefSign(clef.getSignType(), inputOutput);
        if (clef.getLine().isPresent()) {
            inputOutput.append(SEP);
            inputOutput.append(clef.getLine().get().getValue());
        }
        if (clef.getOctaveTransposition().isPresent()) {
            inputOutput.append(SEP);
            exportClefOctaveTransposition(clef.getOctaveTransposition().get(), inputOutput);
        }
        inputOutput.buildAndAddToken(clef);
    }

    @Override
    public void exportClefSign(IClefSign clefSign, SkmExporterVisitorTokenParam inputOutput) {
        EClefSigns clefSigns = clefSign.getValue();
        String str;
        switch (clefSigns) {
            case TAB:
                str = "T";
                break;
            case Percussion:
                str = "P";
                break;
            default:
                str = clefSign.getValue().name().toUpperCase();
        }

        inputOutput.append(str);
    }

    @Override
    public void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        String str = null;
        switch (octaveTransposition.getValue()) {
            case -2:
                str = "vv2";
                break;
            case -1:
                str = "v2";
                break;
            case 0:
                break;
            case 1:
                str = "^2";
                break;
            case 2:
                str = "^^2";
                break;
            default:
                throw new IMException("Unsupported octave transposition: " + octaveTransposition);
        }
        inputOutput.append(str);
    }

    @Override
    public void exportNote(INote note, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(note.getFigure(), inputOutput);
        inputOutput.append(SEP);
        if (note.getDots().isPresent()) {
            exportDots(note.getDots().get(), inputOutput);
        }
        exportNoteHead(note.getNoteHead(), inputOutput);
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

    private void doExport(IStandardTimeSignature standardTimeSignature, SkmExporterVisitorTokenParam inputOutput) {
        inputOutput.append(standardTimeSignature.getNumerator().getValue());
        inputOutput.append('/');
        inputOutput.append(standardTimeSignature.getDenominator().getValue());
    }
    @Override
    public void exportStandardTimeSignature(IStandardTimeSignature meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(SEP);
        doExport(meter, inputOutput);
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportCutTime(ICutTime meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        //inputOutput.append("*met(c|)");
        inputOutput.append("*M");
        inputOutput.append(SEP);
        inputOutput.append("(c|)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportCommonTime(ICommonTime meter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        //inputOutput.append("*met(c)");
        inputOutput.append("*M");
        inputOutput.append(SEP);
        inputOutput.append("(c)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportMixedMeter(IMixedMeter mixedMeter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(SEP);
        boolean first = true;
        for (IMeter submeter: mixedMeter.getSubMeters()) {
            if (!(submeter instanceof IStandardTimeSignature)) {
                throw new IMException("Unsupported " + submeter.getClass() + " inside an alternating meter");
            }
            IStandardTimeSignature standardSubmeter = (IStandardTimeSignature) submeter;
            if (first) {
                first = false;
            } else {
                inputOutput.append('+');
            }
            doExport(standardSubmeter, inputOutput);
        }
    }

    @Override
    public void exportAlternatingMeter(IAlternatingMeter mixedMeter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(SEP);
        IStandardTimeSignature previous = null;
        int countPrevious = 0;
        boolean needsSeparator = false;
        for (IMeter submeter: mixedMeter.getSubMeters()) {
            if (!(submeter instanceof IStandardTimeSignature)) {
                throw new IMException("Unsupported " + submeter.getClass() + " inside an alternating meter");
            }
            IStandardTimeSignature standardSubmeter = (IStandardTimeSignature) submeter;
            if (previous == null) {
                previous = standardSubmeter;
                countPrevious = 1;
            } else {
                if (previous.equals(standardSubmeter)) {
                    countPrevious ++;
                } else {
                    doExport(standardSubmeter, inputOutput);
                    if (countPrevious > 1) {
                        inputOutput.append(';');
                        inputOutput.append(countPrevious);
                    }
                    needsSeparator = true;
                    previous = standardSubmeter;
                    countPrevious = 1;
                }
            }
        }

        if (previous != null) {
            if (needsSeparator) {
                inputOutput.append(';');
            }
            doExport(previous, inputOutput);
            if (countPrevious > 1) {
                inputOutput.append(';');
                inputOutput.append(countPrevious);
            }
        }
    }

    @Override
    public void exportAdditiveMeter(IAdditiveMeter additiveMeter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(SEP);
        boolean first = true;
        for (ITimeSignatureNumerator numerator: additiveMeter.getNumerators()) {
            if (first) {
                first = false;
            } else {
                inputOutput.append('+');
            }
            inputOutput.append(numerator.getValue());
        }
        inputOutput.append('/');
        inputOutput.append(additiveMeter.getDenominator().getValue());
    }

    @Override
    public void exportInterchangingMeter(IInterchangingMeter interchangingMeter, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        IMeter left = interchangingMeter.getLeft();
        IMeter right = interchangingMeter.getRight();
        if (!(left instanceof IStandardTimeSignature && right instanceof IStandardTimeSignature)) {
            throw new IMException("Unsupported interchanging meters made of other thing that standard time signatures, and found " + left.getClass() + " and " + right.getClass());
        }

        inputOutput.append("*M");
        inputOutput.append(SEP);
        doExport((IStandardTimeSignature) left, inputOutput);
        inputOutput.append('|');
        doExport((IStandardTimeSignature) right, inputOutput);
        inputOutput.buildAndAddToken(interchangingMeter);
    }

    @Override
    public void exportChord(IChord chord, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(chord.getFigure(), inputOutput);
        if (chord.getDots().isPresent()) {
            exportDots(chord.getDots().get(), inputOutput);
        }
        for (INoteHead noteHead: chord.getNoteHeads()) {
            exportNoteHead(noteHead, inputOutput);
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
        if (key.getKeySignature().isPresent()) {
            if (!(inputOutput.getLastToken() instanceof SkmCoreSymbol)
                    || !((SkmCoreSymbol) inputOutput.getLastToken()).getSymbol().equals(key.getKeySignature().get())) {
                exportKeySignature(key.getKeySignature().get(), inputOutput); // do not repeat previous explicit key signature and the key signature of the key
            }
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
        //inputOutput.append('*');
        inputOutput.append("*K");
        inputOutput.append(SEP);
        inputOutput.append(diatonicPitch);
        if (key.getPitchClass().getAccidental().isPresent()) {
            exportAccidentalSymbol(key.getPitchClass().getAccidental().get(), inputOutput);
        }

        if (key.getKeySignature().isPresent() && key.getKeySignature().get().getCautionaryAccidentals().isPresent()) {
            inputOutput.append(SEP);
            inputOutput.append('X');
        }
        inputOutput.append(':');
        inputOutput.buildAndAddToken(key);
    }

    @Override
    public void exportConventionalKeySignature(IConventionalKeySignature conventionalKeySignature, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportKeySignature(conventionalKeySignature, inputOutput);
    }

    @Override
    public void exportMode(IMode mode, SkmExporterVisitorTokenParam inputOutput) {

    }

    public void exportKeySignature(IKeySignature keySignature, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*k");
        inputOutput.append(SEP);
        inputOutput.append('[');
        for (IPitchClass pitchClass: keySignature.getPitchClasses()) {
            exportPitchClass(pitchClass, inputOutput);
        }
        if (keySignature.getCautionaryAccidentals().isPresent()) {
            inputOutput.append(SEP);
            inputOutput.append('X');
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
    public void exportNoteHead(INoteHead noteHead, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        //TODO ties
        exportPitch(noteHead.getPitch(), inputOutput);
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
                throw new IMException("Unknown barline type: " + barlineType.getValue());
        }
        inputOutput.append(encoding);
    }

    @Override
    public void exportPageBeginning(IPageBeginning pageBeginning, SkmExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void exportSystemBeginning(ISystemBeginning systemBeginning, SkmExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void exportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, SkmExporterVisitorTokenParam inputOutput) throws IMException {
        exportKeySignature(unconventionalKeySignature, inputOutput);
    }



}
