package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLExporterVisitorParam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLParamExportMode;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MEIExporterVisitor implements IExporterVisitor<XMLExporterVisitorParam> {
    @Override
    public void exportClef(IClef clef, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (clef.getLine().isPresent()) {
                inputOutput.addAttribute("clef.line", Integer.toString(clef.getLine().get().getValue()));
            }
            exportClefSign(clef.getSignType(), inputOutput);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportClefSign(IClefSign clefSign, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            EClefSigns clefSigns = clefSign.getValue();
            String str;
            switch (clefSigns) {
                case TAB:
                    str = "TAB";
                    break;
                case Percussion:
                    str = "perc";
                    break;
                default:
                    str = clefSign.getValue().name().toUpperCase();
            }
            inputOutput.addAttribute("clef.shape", str);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }
    @Override
    public void exportNote(INote note, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement xmlNote = new XMLElement("note");
        XMLExporterVisitorParam XMLExporterVisitorParam = new XMLExporterVisitorParam(XMLParamExportMode.attribute, xmlNote);
        exportNoteHead(note.getNoteHead(), XMLExporterVisitorParam);
        exportFigure(note.getFigure(), XMLExporterVisitorParam);
        if (note.getDots().isPresent()) {
            exportDots(note.getDots().get(), XMLExporterVisitorParam);
        }
        inputOutput.addChild(xmlNote);
    }

    @Override
    public void exportRest(IRest rest, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportMultimeasureRest(IMultimeasureRest mrest, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportFractionalTimeSignature(IFractionalTimeSignature meter, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportCutTime(ICutTime meter, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "cut");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }
    @Override
    public void exportCommonTime(ICommonTime meter, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "common");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportChord(IChord chord, XMLExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportCustos(ICustos custos, XMLExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportKey(IKey key, XMLExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportCommonAlterationKey(ICommonAlterationKey commonAlterationKey, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            StringBuilder keySig = new StringBuilder();
            keySig.append(commonAlterationKey.getAccidentalCount());
            if (commonAlterationKey.getAccidentalSymbol().isPresent()) {
                XMLExporterVisitorParam accidentalParam = new XMLExporterVisitorParam(XMLParamExportMode.string);
                exportAccidentalSymbol(commonAlterationKey.getAccidentalSymbol().get(), accidentalParam);
                keySig.append(accidentalParam.getStringBuilderValue());
            }

            inputOutput.addAttribute("key.sig", keySig.toString());
            exportMode(commonAlterationKey.getMode(), inputOutput);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }
    @Override
    public void exportMode(IMode mode, XMLExporterVisitorParam inputOutput) {
        inputOutput.addAttribute("key.mode", mode.getValue().name().toLowerCase());

    }

    @Override
    public void exportKeySignature(IKeySignature keySignature, XMLExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportVoice(IVoice voice, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportDiatonicPitch(IDiatonicPitch diatonicPitch, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("pname", diatonicPitch.getValue().name().toLowerCase());
        } else {
            throw new UnsupportedOperationException("Cannot export a diatonic pitch as other thing different to attribute");
        }
    }

    @Override
    public void exportAccidentalSymbol(IAccidentalSymbol accidental, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.string) {
            switch (accidental.getValue()) {
                case TRIPLE_FLAT:
                    inputOutput.append("fff");
                    break;
                case DOUBLE_FLAT:
                    inputOutput.append("ff");
                    break;
                case FLAT:
                    inputOutput.append("f");
                    break;
                case NATURAL:
                    inputOutput.append("n");
                    break;
                case SHARP:
                    inputOutput.append("s");
                    break;
                case DOUBLE_SHARP:
                    inputOutput.append("x");
                    break;
                default:
                    throw new IMException("Unkown accidental symbol: " + accidental.getValue());
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportAlteration(IAlteration alteration, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement alterationXMLElement = new XMLElement("accid");
        inputOutput.addChild(alterationXMLElement);

        //TODO ges.... - IAlterationDisplayType
        XMLExporterVisitorParam accidentalParam = new XMLExporterVisitorParam(XMLParamExportMode.string);
        exportAccidentalSymbol(alteration.getAccidentalSymbol(), accidentalParam);
        alterationXMLElement.addAttribute("accid.ges", accidentalParam.getStringBuilderValue());

    }

    @Override
    public void exportPitchClass(IPitchClass pitchClass, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void exportPitch(IPitch pitch, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (pitch.getAlteration().isPresent()) {
                exportAlteration(pitch.getAlteration().get(), inputOutput);
            }
            exportDiatonicPitch(pitch.getDiatonicPitch(), inputOutput);
            exportOctave(pitch.getOctave(), inputOutput);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void exportNoteHead(INoteHead noteHead, XMLExporterVisitorParam inputOutput) throws IMException {
        //TODO ties
        exportPitch(noteHead.getPitch(), inputOutput);
    }

    @Override
    public void exportDots(IDots dots, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (dots.getValue() > 0) {
                inputOutput.addAttribute("dots", Integer.toString(dots.getValue()));
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportOctave(IOctave octave, XMLExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addAttribute("oct", Integer.toString(octave.getValue()));
    }

    @Override
    public void exportFigure(IFigure figures, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            String value;
            switch (figures.getValue()) {
                case MAXIMA: value = "maxima"; break;
                case LONGA: value = "longa"; break;
                case BREVE: value = "brevis"; break;
                case SEMIBREVE: value = "semibrevis"; break;
                case MINIM: value = "minima"; break;
                case SEMIMINIM: value = "semiminima"; break;
                case FUSA: value = "fusa"; break;
                case SEMIFUSA: value =  "semifusa"; break;
                case QUADRUPLE_WHOLE: value = "long"; break;
                case DOUBLE_WHOLE: value = "breve"; break;
                default:
                    value = Integer.toString(figures.getMeterUnit());
            }
            inputOutput.addAttribute("dur", value);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportMetronomeMark(IMetronomeMark metronomeMark, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportBarline(IBarline barline, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportBarlineType(IBarlineType barlineType, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportPageBeginning(IPageBeginning pageBeginning, XMLExporterVisitorParam inputOutput) {

    }

    @Override
    public void exportSystemBeginning(ISystemBeginning systemBeginning, XMLExporterVisitorParam inputOutput) {

    }


}
