package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLExporterVisitorParam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLParamExportMode;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MusicXMLExporterVisitor implements IExporterVisitor<XMLExporterVisitorParam> {
    static final int MAX_DUR = 256;

    @Override
    public void exportClef(IClef clef, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam clefXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("clef"));
            exportClefSign(clef.getSignType(), clefXMLParam);
            if (clef.getLine().isPresent()) {
                clefXMLParam.addChild("line", Integer.toString(clef.getLine().get().getValue()));
            }

        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportClefSign(IClefSign clefSign, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            inputOutput.addChild("sign", clefSign.getValue().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void exportNote(INote note, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement xmlNote = new XMLElement("note");
        XMLExporterVisitorParam XMLExporterVisitorParam = new XMLExporterVisitorParam(XMLParamExportMode.element, xmlNote);
        exportPitch(note.getPitch(), XMLExporterVisitorParam);
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
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam timeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("time"));
            timeXMLParam.addAttribute("symbol", "cut");
            timeXMLParam.addChild("beats", "2");
            timeXMLParam.addChild("beat-type", "2");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportCommonTime(ICommonTime meter, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam timeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("time"));
            timeXMLParam.addAttribute("symbol", "common");
            timeXMLParam.addChild("beats", "4");
            timeXMLParam.addChild("beat-type", "4");
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
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam keyXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("key"));
            int fifths;
            if (commonAlterationKey.getAccidentalSymbol().isPresent()) {
                if (commonAlterationKey.getAccidentalSymbol().get().getValue() == EAccidentalSymbols.SHARP) {
                    fifths = commonAlterationKey.getAccidentalCount();
                } else if (commonAlterationKey.getAccidentalSymbol().get().getValue() == EAccidentalSymbols.FLAT){
                    fifths = -commonAlterationKey.getAccidentalCount();
                } else {
                    throw new IMException("Unsupported accidental in standard key " + commonAlterationKey.getAccidentalSymbol().get());
                }
            } else {
                fifths = 0;
            }
            keyXMLParam.addChild("fifths", Integer.toString(fifths));
            exportMode(commonAlterationKey.getMode(), keyXMLParam);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportMode(IMode mode, XMLExporterVisitorParam inputOutput) {
        inputOutput.addChild("mode", mode.getValue().name().toLowerCase());
    }

    @Override
    public void exportKeySignature(IKeySignature keySignature, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void exportVoice(IVoice voice, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportDiatonicPitch(IDiatonicPitch diatonicPitch, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            inputOutput.addChild("step", diatonicPitch.getValue().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("Cannot export a diatonic pitch as other thing different to attribute");
        }
    }

    @Override
    public void exportAccidentalSymbol(IAccidentalSymbol accidental, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            inputOutput.addChild("alter", Integer.toString(accidental.getValue().getAlteration()));
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportAlteration(IAlteration alteration, XMLExporterVisitorParam inputOutput) throws IMException {
        exportAccidentalSymbol(alteration.getAccidentalSymbol(), inputOutput);
        //TODO ges.... - IAlterationDisplayType

    }

    @Override
    public void exportPitchClass(IPitchClass pitchClass, XMLExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void exportPitch(IPitch pitch, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam pitchXMLElement = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("pitch"));
            exportDiatonicPitch(pitch.getDiatonicPitch(), pitchXMLElement);
            exportOctave(pitch.getOctave(), pitchXMLElement);
            if (pitch.getAlteration().isPresent()) {
                exportAlteration(pitch.getAlteration().get(), pitchXMLElement);
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

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
        inputOutput.addChild("octave", Integer.toString(octave.getValue()));
    }

    @Override
    public void exportFigure(IFigure figures, XMLExporterVisitorParam inputOutput) {
        //TODO ¿es necesario type?
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            String type;
            switch (figures.getValue()) {
                //TODO todos estos valores
                case MAXIMA: type = "maxima"; break;
                case LONGA: type = "long"; break;
                case BREVE: type = "breve"; break;
                case SEMIBREVE: type = "whole"; break;
                case MINIM: type = "half"; break;
                case SEMIMINIM: type = "quarter"; break;
                case FUSA: type = "eighth"; break;
                case SEMIFUSA: type =  "16th"; break;
                case OCTUPLE_WHOLE: type = "maxima"; break;
                case QUADRUPLE_WHOLE: type = "long"; break;
                case DOUBLE_WHOLE: type = "breve"; break;
                case WHOLE: type = "whole"; break;
                case HALF: type = "half"; break;
                case QUARTER: type = "quarter"; break;
                case EIGHTH: type = "eighth"; break;
                case SIXTEENTH: type = "16th"; break;
                case THIRTY_SECOND: type = "32nd"; break;
                case SIXTY_FOURTH: type = "64th"; break;
                case HUNDRED_TWENTY_EIGHTH: type = "128th"; break;
                case TWO_HUNDRED_FIFTY_SIX: type = "256th"; break;
                default:
                    type = Integer.toString(figures.getMeterUnit());
            }
            int dur = MAX_DUR / figures.getValue().getMeterUnit();
            inputOutput.addChild("duration", Integer.toString(dur));
            inputOutput.addChild("type", type);
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
