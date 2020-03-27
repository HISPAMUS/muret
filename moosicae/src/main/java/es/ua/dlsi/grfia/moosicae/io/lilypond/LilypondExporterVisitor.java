package es.ua.dlsi.grfia.moosicae.io.lilypond;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
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
            inputOutput.append("\\clef percussion");
        } else if (clefSigns == EClefSigns.TAB) {
            inputOutput.addChild("new TabStaff");
            inputOutput.append("\\clef percussion");
        } else {
            Optional<IClefLine> clefLine = clef.getLine();
            if (!clefLine.isPresent()) {
                throw new IMException("Expecting clef line for clef: " + clef);
            }

            int line = clefLine.get().getValue();
            switch (clef.getSignType().getValue()) {
                case G:
                    if (line == 2) {
                        inputOutput.append("\\clef G");
                    } else {
                        throw new IMException("Invalid line for G: " + line);
                    }
                    break;
                case F:
                    switch (line) {
                        case 3:
                            inputOutput.append("\\clef varbaritone");
                            break;
                        case 4:
                            inputOutput.append("\\clef F");
                            break;
                        case 5:
                            inputOutput.append("\\clef subbass");
                            break;
                        default:
                            throw new IMException("Invalid line for F: " + line);
                    }
                    break;
                case C:
                    switch (line) {
                        case 1:
                            inputOutput.append("\\clef soprano");
                            break;
                        case 2:
                            inputOutput.append("\\clef mezzosoprano");
                            break;
                        case 3:
                            inputOutput.append("\\clef C");
                            break;
                        case 4:
                            inputOutput.append("\\clef tenor");
                            break;
                        case 5:
                            inputOutput.append("\\clef baritone");
                            break;
                        default:
                            throw new IMException("Invalid line for F: " + line);
                    }
                    break;
                default:
                    throw new IMException("Unexpected sign: " + clefSigns);
            }
            inputOutput.finishString();
        }
    }

    @Override
    public void exportClefSign(IClefSign clefSign, LilypondExporterVisitorParam inputOutput) throws IMException {

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
        inputOutput.addChild("\\numericTimeSignature");
        inputOutput.addChild("\\time " + meter.getNumerator() + "/" + meter.getDenominator());
    }

    @Override
    public void exportCutTime(ICutTime meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChild("\\defaultTimeSignature");
        inputOutput.addChild("\\time 2/2");
    }

    @Override
    public void exportCommonTime(ICommonTime meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChild("\\defaultTimeSignature");
        inputOutput.addChild("\\time 4/4");
    }

    @Override
    public void exportChord(IChord chord, LilypondExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportCustos(ICustos custos, LilypondExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportKey(IKey key, LilypondExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportCommonAlterationKey(ICommonAlterationKey commonAlterationKey, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.startString();
        inputOutput.append("\\key ");
        inputOutput.append(commonAlterationKey.getPitchClass().getDiatonicPitch().getValue().name().toLowerCase());
        inputOutput.append(' ');
        inputOutput.append('\\');
        inputOutput.append(commonAlterationKey.getMode().getValue().name().toLowerCase());
        inputOutput.finishString();

    }

    @Override
    public void exportMode(IMode mode, LilypondExporterVisitorParam inputOutput) {

    }

    @Override
    public void exportKeySignature(IKeySignature keySignature, LilypondExporterVisitorParam inputOutputOutput) throws IMException {

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
