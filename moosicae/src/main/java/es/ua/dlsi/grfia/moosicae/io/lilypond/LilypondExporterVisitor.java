package es.ua.dlsi.grfia.moosicae.io.lilypond;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.impl.UnconventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public class LilypondExporterVisitor implements IExporterVisitor<LilypondExporterVisitorParam> {


    @Override
    public void exportClef(IClef clef, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.startString();

        EClefSigns clefSigns = clef.getSignType().getValue();

        if (clefSigns == EClefSigns.Percussion) {
            inputOutput.addChildLine("\\clef percussion");
        } else if (clefSigns == EClefSigns.TAB) {
            LilypondExporterVisitorParam child = inputOutput.addChildContext("TabStaff", true);
            child.addChildLine("\\clef tab");
        } else {
            Optional<IClefLine> clefLine = clef.getLine();
            if (!clefLine.isPresent()) {
                throw new IMException("Expecting clef line for clef: " + clef);
            }

            int line = clefLine.get().getValue();
            String clefName;
            switch (clef.getSignType().getValue()) {
                case G:
                    if (line == 2) {
                        clefName = "G";
                    } else {
                        throw new IMException("Invalid line for G: " + line);
                    }
                    break;
                case F:
                    switch (line) {
                        case 3:
                            clefName = "varbaritone";
                            break;
                        case 4:
                            clefName = "F";
                            break;
                        case 5:
                            clefName = "subbass";
                            break;
                        default:
                            throw new IMException("Invalid line for F: " + line);
                    }
                    break;
                case C:
                    switch (line) {
                        case 1:
                            clefName = "soprano";
                            break;
                        case 2:
                            clefName = "mezzosoprano";
                            break;
                        case 3:
                            clefName = "C";
                            break;
                        case 4:
                            clefName = "tenor";
                            break;
                        case 5:
                            clefName = "baritone";
                            break;
                        default:
                            throw new IMException("Invalid line for F: " + line);
                    }
                    break;
                default:
                    throw new IMException("Unexpected sign: " + clefSigns);
            }
            if (clef.getOctaveTransposition().isPresent()) {
                String octave = null;
                switch (clef.getOctaveTransposition().get().getValue()) {
                    case -2:
                        octave = "_15";
                        break;
                    case -1:
                        octave = "_8";
                        break;
                    case 0:
                        break;
                    case 1:
                        octave = "^8";
                        break;
                    case 2:
                        octave = "^15";
                        break;
                    default:
                        throw new IMException("Unsupported clef octave transposition: " + clef.getOctaveTransposition().get().getValue());
                }
                inputOutput.addChildLine("\\clef \"" + clefName + octave + "\"");
            } else {
                inputOutput.addChildLine("\\clef " + clefName);
            }
        }
    }

    @Override
    public void exportClefSign(IClefSign clefSign, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, LilypondExporterVisitorParam inputOutput) throws IMException {
        // included above in exportClef
    }

    @Override
    public void exportNote(INote note, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.startString();
        exportNoteHead(note.getNoteHead(), inputOutput);
        exportFigure(note.getFigure(), inputOutput);
        if (note.getDots().isPresent()) {
            exportDots(note.getDots().get(), inputOutput);
        }
        inputOutput.finishString();
    }

    @Override
    public void exportRest(IRest rest, LilypondExporterVisitorParam inputOutput) throws IMException {

    }
    @Override
    public void exportMultimeasureRest(IMultimeasureRest mrest, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportFractionalTimeSignature(IFractionalTimeSignature meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChildLine("\\numericTimeSignature");
        inputOutput.addChildLine("\\time " + meter.getNumerator() + "/" + meter.getDenominator());
    }

    @Override
    public void exportCutTime(ICutTime meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChildLine("\\defaultTimeSignature");
        inputOutput.addChildLine("\\time 2/2");
    }

    @Override
    public void exportCommonTime(ICommonTime meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChildLine("\\defaultTimeSignature");
        inputOutput.addChildLine("\\time 4/4");
    }

    @Override
    public void exportChord(IChord chord, LilypondExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportCustos(ICustos custos, LilypondExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportKey(IKey key, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.startString();
        inputOutput.append("\\key ");
        exportPitchClass(key.getPitchClass(), inputOutput);
        inputOutput.append(' ');
        inputOutput.append('\\');
        inputOutput.append(key.getMode().getValue().name().toLowerCase());
        inputOutput.finishString();
    }

    @Override
    public void exportConventionalKeySignature(IConventionalKeySignature commonAlterationKey, LilypondExporterVisitorParam inputOutputOutput) throws IMException {
        throw new IMException("Cannot export conventional key signature, a key must be added and use it");
    }

    @Override
    public void exportMode(IMode mode, LilypondExporterVisitorParam inputOutput) {

    }

    @Override
    public void exportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, LilypondExporterVisitorParam inputOutput) throws IMException {
        // non conventional key signatures
        inputOutput.startString();
        inputOutput.append("\\set Staff.keyAlterations = #`(");

        for (IPitchClass pitchClass: unconventionalKeySignature.getPitchClasses()) {
            inputOutput.append('(');

            inputOutput.append('(');
            //inputOutput.append(pitch.getOctave().getValue() - 4); // 0 is the 4th ISO scientific pitch octave
            inputOutput.append(" . ");
            inputOutput.append(pitchClass.getDiatonicPitch().getValue().getOrder());
            inputOutput.append(')');

            Optional<IAccidentalSymbol> accidentalSymbol = pitchClass.getAccidental();
            if (!accidentalSymbol.isPresent()) {
                throw new IMException("The accidental of the pitch in the key signature must have a value: " + unconventionalKeySignature);
            }

            inputOutput.append(" . ,");
            inputOutput.append(accidentalSymbol.get().getValue().name().toUpperCase());
            inputOutput.append(')');
        }
        inputOutput.append(')');
    }

    @Override
    public void exportVoice(IVoice voice, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportDiatonicPitch(IDiatonicPitch diatonicPitch, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.append(diatonicPitch.getValue().name().toLowerCase());
    }

    @Override
    public void exportAccidentalSymbol(IAccidentalSymbol accidental, LilypondExporterVisitorParam inputOutput) throws IMException {
        switch (accidental.getValue()) {
            case TRIPLE_FLAT:
                inputOutput.append("eseses");
                break;
            case DOUBLE_FLAT:
                inputOutput.append("eses");
                break;
            case FLAT:
                inputOutput.append("es");
                break;
            case NATURAL:
                inputOutput.append("");
                break;
            case SHARP:
                inputOutput.append("is");
                break;
            case DOUBLE_SHARP:
                inputOutput.append("isis");
                break;
            default:
                throw new IMException("Unkown accidental symbol: " + accidental.getValue());
        }
    }

    @Override
    public void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportAlteration(IAlteration alteration, LilypondExporterVisitorParam inputOutput) throws IMException {
        //TODO display type
        exportAccidentalSymbol(alteration.getAccidentalSymbol(), inputOutput);
   }

    @Override
    public void exportPitchClass(IPitchClass pitchClass, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.append(pitchClass.getDiatonicPitch().getValue().name().toLowerCase());
        Optional<IAccidentalSymbol> accidentalSymbol = pitchClass.getAccidental();
        if (accidentalSymbol.isPresent()) {
            exportAccidentalSymbol(accidentalSymbol.get(), inputOutput);
        }
    }

    @Override
    public void exportPitch(IPitch pitch, LilypondExporterVisitorParam inputOutput) throws IMException {
        exportDiatonicPitch(pitch.getDiatonicPitch(), inputOutput);
        if (pitch.getAlteration().isPresent()) {
            exportAlteration(pitch.getAlteration().get(), inputOutput);
        }
        exportOctave(pitch.getOctave(), inputOutput);
    }

    @Override
    public void exportNoteHead(INoteHead head, LilypondExporterVisitorParam inputOutput) throws IMException {
        exportPitch(head.getPitch(), inputOutput); //TODO ties
    }

    @Override
    public void exportOctave(IOctave octave, LilypondExporterVisitorParam inputOutput) {
        int n = octave.getValue();
        if (n > 3) {
            for (int i = 3; i < n; i++) {
                inputOutput.append('\'');
            }
        } else if (n < 3) {
            for (int i = 3; i > n; i--) {
                inputOutput.append(',');
            }
        }
    }

    @Override
    public void exportDots(IDots dots, LilypondExporterVisitorParam inputOutput) throws IMException {
        for (int i=0; i<dots.getValue(); i++) {
            inputOutput.append('.');
        }
    }

    @Override
    public void exportFigure(IFigure figures, LilypondExporterVisitorParam inputOutput) throws IMException {
        String value;
        switch (figures.getValue()) {
            case MAXIMA: value = "maxima"; break;
            case LONGA: value = "longa"; break;
            case BREVE: value = "breve"; break;
            case SEMIBREVE: value = "1"; break;
            case MINIM: value = "2"; break;
            case SEMIMINIM: value = "4"; break;
            case FUSA: value = "8"; break;
            case SEMIFUSA: value =  "16"; break;
            case QUADRUPLE_WHOLE: value = "longa"; break;
            case DOUBLE_WHOLE: value = "breve"; break;
            default:
                value = Integer.toString(figures.getMeterUnit());
        }
        inputOutput.append(value);
    }

    @Override
    public void exportMetronomeMark(IMetronomeMark metronomeMark, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportBarline(IBarline barline, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportBarlineType(IBarlineType barlineType, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportPageBeginning(IPageBeginning pageBeginning, LilypondExporterVisitorParam inputOutput) {

    }

    @Override
    public void exportSystemBeginning(ISystemBeginning systemBeginning, LilypondExporterVisitorParam inputOutput) {

    }

}
