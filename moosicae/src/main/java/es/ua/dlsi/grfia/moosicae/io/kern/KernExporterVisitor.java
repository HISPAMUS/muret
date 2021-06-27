package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernCoreSymbol;
import es.ua.dlsi.grfia.moosicae.utils.Pair;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernExporterVisitor implements IExporterVisitor<KernExporterVisitorTokenParam> {
    private final boolean ekern;
    String SEP = "·";

    public KernExporterVisitor(boolean ekern) {
        this.ekern = ekern;
        if (!ekern) {
            SEP = "";
        }
    }

    public String exportPart(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*part");
        stringBuilder.append(SEP);
        stringBuilder.append(n);
        return stringBuilder.toString();
    }


    @Override
    public void exportClef(IClef clef, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportClefSign(IClefSign clefSign, KernExporterVisitorTokenParam inputOutput) {
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
    public void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportNote(INote note, KernExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(note.getFigure(), inputOutput);
        inputOutput.append(SEP);
        if (note.getDots().isPresent()) {
            exportDots(note.getDots().get(), inputOutput);
        }
        doExport(note.getNoteHead(), inputOutput, note.getGraceNoteType());

        if (note.getStem().isPresent()) {
            inputOutput.append(SEP);
            exportStem(note.getStem().get(), inputOutput);
        }

        exportConnectors(note, inputOutput);
        exportMarks(note, inputOutput);

        inputOutput.buildAndAddToken(note);
    }

    private void exportMarks(IVoiced voiced, KernExporterVisitorTokenParam inputOutput) throws IMException {
        for (IMark mark: voiced.getMarks()) {
            mark.export(this, inputOutput);
        }
    }

    private void exportStem(IStem stem, KernExporterVisitorTokenParam inputOutput) throws IMException {
        switch (stem.getStemDirection().getValue()) {
            case down:
                inputOutput.append("\\");
                break;
            case up:
                inputOutput.append("/");
                break;
            default:
                throw new IMException("Unsupported stem direction: " + stem.getStemDirection().getValue());
        }
    }

    @Override
    public void exportRest(IRest rest, KernExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(rest.getFigure(), inputOutput);
        inputOutput.append(SEP);
        if (rest.getDots().isPresent()) {
            exportDots(rest.getDots().get(), inputOutput);
        }
        inputOutput.append("r");

        //TODO optional position on line
        exportConnectors(rest, inputOutput);
        exportMarks(rest, inputOutput);

        inputOutput.buildAndAddToken(rest);
    }

    private void exportConnectors(IVoiced voiced, KernExporterVisitorTokenParam inputOutput) throws IMException {
        for (IConnector connector: voiced.getConnectors()) {
            if (connector instanceof IBeamGroup) {
                if (connector.getFirst() == voiced) {
                    inputOutput.append(SEP);
                    inputOutput.append('L');
                } else if (connector.getLast() == voiced) {
                    inputOutput.append(SEP);
                    inputOutput.append('J');
                }
            } else {
                throw new IMException("Not supported yet: " + connector.getClass().getName());
            }
        }
    }

    @Override
    public void exportMultimeasureRest(IMultimeasureRest mrest, KernExporterVisitorTokenParam inputOutput) throws IMException {
        if (this.ekern) {
            inputOutput.append("rr");
            inputOutput.append(SEP);
            inputOutput.append(mrest.getMeasureCount().getValue());
            inputOutput.buildAndAddToken(mrest);
        } else {
            if (inputOutput.getLastMeter() == null) {
                throw new IMException("Last meter contexual field is empty in KernExporterVisitorTokenParam");
            }
            ITime meterDuration = inputOutput.getLastMeter().getBarDuration();
            Pair<EFigures, Integer> figureAndDots = EFigures.findDurationWithDots(meterDuration, ENotationTypes.eModern, 2); // **ekern is modern
            IDots dots = null;
            if (figureAndDots.getRight() > 0) {
                dots = ICoreAbstractFactory.getInstance().createDots(null, figureAndDots.getRight());
            }
            IFigure figure = ICoreAbstractFactory.getInstance().createFigure(null, figureAndDots.getLeft());
            IRest rest = ICoreAbstractFactory.getInstance().createRest(null, figure, dots);
            for (int i=0; i<mrest.getMeasureCount().getValue(); i++) {
                exportRest(rest, inputOutput);
                if (i<mrest.getMeasureCount().getValue()-1) {
                    doExport(EBarlineTypes.single, inputOutput);
                    IMeasure measure = ICoreAbstractFactory.getInstance().createMeasure(null, null, null, null);
                    inputOutput.buildAndAddToken(measure);
                }
            }
            // "TO-DO mrest in raw kern: sequence of rests - see multiple spines");
        }
    }

    private void doExport(IStandardTimeSignature standardTimeSignature, KernExporterVisitorTokenParam inputOutput) {
        inputOutput.append(standardTimeSignature.getNumerator().getValue());
        inputOutput.append('/');
        inputOutput.append(standardTimeSignature.getDenominator().getValue());
    }
    @Override
    public void exportStandardTimeSignature(IStandardTimeSignature meter, KernExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*M");
        inputOutput.append(SEP);
        doExport(meter, inputOutput);
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportCutTime(ICutTime meter, KernExporterVisitorTokenParam inputOutput) throws IMException {
        if (!ekern) {
            inputOutput.append("*M2/2");
            inputOutput.buildAndAddToken(meter);
        }
        inputOutput.append("*met");
        inputOutput.append(SEP);
        inputOutput.append("(c|)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportCommonTime(ICommonTime meter, KernExporterVisitorTokenParam inputOutput) throws IMException {
        if (!ekern) {
            inputOutput.append("*M4/4");
            inputOutput.buildAndAddToken(meter);
        }

        inputOutput.append("*met");
        inputOutput.append(SEP);
        inputOutput.append("(c)");
        inputOutput.buildAndAddToken(meter);
    }

    @Override
    public void exportMixedMeter(IMixedMeter mixedMeter, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportAlternatingMeter(IAlternatingMeter mixedMeter, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportAdditiveMeter(IAdditiveMeter additiveMeter, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportInterchangingMeter(IInterchangingMeter interchangingMeter, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportWholeMeasureRest(IWholeMeasureRest wholeMeasureRest, KernExporterVisitorTokenParam inputOutput) {
        throw new UnsupportedOperationException("Whole measure rest");
    }

    @Override
    public void exportMeasure(IMeasure measure, KernExporterVisitorTokenParam inputOutput) throws IMException {
        if (measure.getBarNumber().isPresent()) {
            inputOutput.append(measure.getBarNumber().get().getValue());
        }
        if (measure.getLeftBarline().isPresent()) {
            throw new IMException("Unsupported left barline export");
        }
        if (measure.getRightBarline().isPresent()) {
            exportBarline(measure.getRightBarline().get(), inputOutput);
        } else {
            doExport(EBarlineTypes.single, inputOutput);
            inputOutput.buildAndAddToken(measure);
        }

    }

    @Override
    public void exportFermata(IFermata fermata, KernExporterVisitorTokenParam inputOutput) {
        inputOutput.append(SEP);
        inputOutput.append(';');
    }

    @Override
    public void exportTuplet(ITuplet tuplet, KernExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.setInTuplet(tuplet);
        for (IVoiced child: tuplet.getChildren()) {
            child.export(this, inputOutput);
        }
        inputOutput.setInTuplet(null);
    }

    @Override
    public void exportChord(IChord chord, KernExporterVisitorTokenParam inputOutput) throws IMException {
        exportFigure(chord.getFigure(), inputOutput);
        if (chord.getDots().isPresent()) {
            exportDots(chord.getDots().get(), inputOutput);
        }
        for (INoteHead noteHead: chord.getNoteHeads()) {
            exportNoteHead(noteHead, inputOutput);
        }

        exportConnectors(chord, inputOutput);
        inputOutput.buildAndAddToken(chord);
    }

    @Override
    public void exportCustos(ICustos custos, KernExporterVisitorTokenParam inputOutput) throws IMException {
        inputOutput.append("*custos");
        exportPitch(custos.getPitch(), inputOutput);
        inputOutput.buildAndAddToken(custos);
    }

    @Override
    public void exportKey(IKey key, KernExporterVisitorTokenParam inputOutput) throws IMException {
        if (key.getKeySignature().isPresent()) {
            if (!(inputOutput.getLastToken() instanceof KernCoreSymbol)
                    || !((KernCoreSymbol) inputOutput.getLastToken()).getSymbol().equals(key.getKeySignature().get())) {
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
            inputOutput.append(SEP);
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
    public void exportConventionalKeySignature(IConventionalKeySignature conventionalKeySignature, KernExporterVisitorTokenParam inputOutput) throws IMException {
        exportKeySignature(conventionalKeySignature, inputOutput);
    }

    @Override
    public void exportMode(IMode mode, KernExporterVisitorTokenParam inputOutput) {

    }

    public void exportKeySignature(IKeySignature keySignature, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportVoice(IVoice voice, KernExporterVisitorTokenParam inputOutput) throws IMException {

    }

    @Override
    public void exportDiatonicPitch(IDiatonicPitch diatonicPitch, KernExporterVisitorTokenParam inputOutput) {
        inputOutput.append(diatonicPitch.getValue().name().toLowerCase());
    }

    @Override
    public void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, KernExporterVisitorTokenParam inputOutput) {
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
    public void exportAccidentalSymbol(IAccidentalSymbol accidental, KernExporterVisitorTokenParam inputOutput) {
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
    public void exportAlteration(IAlteration alteration, KernExporterVisitorTokenParam inputOutput) {
        exportAccidentalSymbol(alteration.getAccidentalSymbol(), inputOutput);
        if (alteration.getAlterationDisplayType().isPresent()) {
            inputOutput.append(SEP);
            exportAlterationDisplayType(alteration.getAlterationDisplayType().get(), inputOutput);
        }
    }

    @Override
    public void exportPitchClass(IPitchClass pitchClass, KernExporterVisitorTokenParam inputOutput) {
        exportDiatonicPitch(pitchClass.getDiatonicPitch(), inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            exportAccidentalSymbol(pitchClass.getAccidental().get(), inputOutput);
        }
    }

    private void exportDiatonicPitchAndOctave(IDiatonicPitch diatonicPitch, IOctave octave, KernExporterVisitorTokenParam inputOutput) {
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
    public void exportPitch(IPitch pitch, KernExporterVisitorTokenParam inputOutput) {
        exportDiatonicPitchAndOctave(pitch.getDiatonicPitch(), pitch.getOctave(), inputOutput);
        if (pitch.getAlteration().isPresent()) {
            inputOutput.append(SEP);
            exportAlteration(pitch.getAlteration().get(), inputOutput);
        }
    }

    private void doExport(INoteHead noteHead, KernExporterVisitorTokenParam inputOutput, Optional<IGraceNoteType> graceNoteType) throws IMException {
        exportPitch(noteHead.getPitch(), inputOutput);

        if (inputOutput.getKernExporterContext().isTieOpened()) {
            if (noteHead.getStartsTie().isPresent()) {
                inputOutput.append(SEP);
                // continue tie
                inputOutput.append('_');
            } else {
                inputOutput.append(SEP);
                // end tie
                inputOutput.append(']');
                inputOutput.getKernExporterContext().setTieOpened(false);
            }
        } else {
            if (noteHead.getStartsTie().isPresent()) {
                inputOutput.append(SEP);
                // start tie
                inputOutput.append('[');
                inputOutput.getKernExporterContext().setTieOpened(true);
            }
        }

        if (graceNoteType != null && graceNoteType.isPresent()) {
            switch (graceNoteType.get().getValue()) {
                case acciaccatura:
                    inputOutput.append(SEP);
                    inputOutput.append("q");
                    break;
                case appoggiatura:
                    inputOutput.append(SEP);
                    inputOutput.append("qq");
                    break;
                default:
                    throw new IMException("Unsupported grace note type: " + graceNoteType.get().getValue());
            }
        }
    }

    @Override
    public void exportNoteHead(INoteHead noteHead, KernExporterVisitorTokenParam inputOutput) throws IMException {
        doExport(noteHead, inputOutput, null);
    }

    @Override
    public void exportDots(IDots dots, KernExporterVisitorTokenParam inputOutput) {
        for (int i=0; i<dots.getDots().length; i++) {
            inputOutput.append('.');
            inputOutput.append(SEP);
        }
    }

    @Override
    public void exportOctave(IOctave octave, KernExporterVisitorTokenParam inputOutput) throws IMException {
        // not used, exported using exportDiatonicPitchAndOctave
    }

    @Override
    public void exportFigure(IFigure figure, KernExporterVisitorTokenParam inputOutput) {
        String encoding;
        if (inputOutput.getInTuplet() != null) {
            encoding = exportTupletFigure(inputOutput.getInTuplet(), figure);
        } else {
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
                    encoding = Integer.toString(figure.computeMeterUnit());
            }
        }
        inputOutput.append(encoding);
    }

    private String exportTupletFigure(ITuplet inTuplet, IFigure figure) {
        int meterUnit = figure.computeMeterUnit();
        int value = meterUnit * inTuplet.getActual().getValue() / inTuplet.getNormal().getValue();
        return Integer.toString(value);
    }

    @Override
    public void exportMetronomeMark(IMetronomeMark metronomeMark, KernExporterVisitorTokenParam inputOutput) throws IMException {
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
    public void exportBarline(IBarline barline, KernExporterVisitorTokenParam inputOutput) throws IMException {
        if (barline.getBarlineType().isPresent()) {
            exportBarlineType(barline.getBarlineType().get(), inputOutput);
        }
        inputOutput.buildAndAddToken(barline);
    }

    private void doExport(EBarlineTypes barlineTypes, KernExporterVisitorTokenParam inputOutput) throws IMException {
        String encoding;
        switch (barlineTypes) {
            case single:
                encoding = "=";
                break;
            case end:
                encoding = "==";
                break;
            case doubleThin:
                encoding = "||";
                break;
            case hidden:
                encoding = "=-";
                break;
            case repeatStart:
                encoding = "|!:";
                break;
            case repeatBoth:
                encoding = ":|!|:";
                break;
            case repeatEnd:
                encoding = ":|!";
                break;
            default:
                throw new IMException("Unknown barline type: " + barlineTypes);
        }
        inputOutput.append(encoding);
    }
    @Override
    public void exportBarlineType(IBarlineType barlineType, KernExporterVisitorTokenParam inputOutput) throws IMException {
        doExport(barlineType.getValue(), inputOutput);
    }

    @Override
    public void exportPageBeginning(IPageBeginning pageBeginning, KernExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void exportSystemBeginning(ISystemBeginning systemBeginning, KernExporterVisitorTokenParam inputOutput) {

    }

    @Override
    public void exportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, KernExporterVisitorTokenParam inputOutput) throws IMException {
        exportKeySignature(unconventionalKeySignature, inputOutput);
    }



}
