package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
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
    public void export(IClef clef, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam clefXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("clef"));
            export(clef.getSignType(), clefXMLParam);
            if (clef.getLine().isPresent()) {
                clefXMLParam.addChild("line", Integer.toString(clef.getLine().get()));
            }

        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IClefSign clefSign, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            inputOutput.addChild("sign", clefSign.getValue().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(INote note, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement xmlNote = new XMLElement("note");
        XMLExporterVisitorParam XMLExporterVisitorParam = new XMLExporterVisitorParam(XMLParamExportMode.element, xmlNote);
        export(note.getPitch(), XMLExporterVisitorParam);
        export(note.getFigure(), XMLExporterVisitorParam);
        if (note.getDots().isPresent()) {
            export(note.getDots().get(), XMLExporterVisitorParam);
        }
        inputOutput.addChild(xmlNote);
    }

    @Override
    public void export(IRest rest, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IMultimeasureRest mrest, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IFractionalTimeSignature meter, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(ICutTime meter, XMLExporterVisitorParam inputOutput) {
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
    public void export(ICommonTime meter, XMLExporterVisitorParam inputOutput) {
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
    public void export(IChord chord, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(ICustos custos, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IKey key, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }


    @Override
    public void export(ICommonAlterationKey commonAlterationKey, XMLExporterVisitorParam inputOutput) throws IMException {
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
            export(commonAlterationKey.getMode(), keyXMLParam);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IMode mode, XMLExporterVisitorParam inputOutput) {
        inputOutput.addAttribute("key.mode", mode.getMode().name().toLowerCase());

    }

    @Override
    public void export(IKeySignature keySignature, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IVoice voice, XMLExporterVisitorParam inputOutput) {

    }

    @Override
    public void export(IDiatonicPitch diatonicPitch, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            inputOutput.addChild("step", diatonicPitch.getValue().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("Cannot export a diatonic pitch as other thing different to attribute");
        }
    }

    @Override
    public void export(IAccidentalCore accidental, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            inputOutput.addChild("alter", Integer.toString(accidental.getValue().getAlteration()));
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IAlteration alteration, XMLExporterVisitorParam inputOutput) throws IMException {
        export(alteration.getAccidentalSymbol(), inputOutput);
        //TODO ges.... - IAlterationDisplayType

    }

    @Override
    public void export(IPitchClass pitchClass, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPitch pitch, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam pitchXMLElement = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("pitch"));
            export(pitch.getDiatonicPitch(), inputOutput);
            export(pitch.getOctave(), inputOutput);
            if (pitch.getAlteration().isPresent()) {
                export(pitch.getAlteration().get(), inputOutput);
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(IDots dots, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (dots.getCount() > 0) {
                inputOutput.addAttribute("dots", Integer.toString(dots.getCount()));
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IOctave octave, XMLExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChild("octave", Integer.toString(octave.getNumber()));
    }

    @Override
    public void export(IFigure figures, XMLExporterVisitorParam inputOutput) {
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
            inputOutput.addChild("dur", Integer.toString(dur));
            inputOutput.addChild("type", type);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IMetronomeMark metronomeMark, XMLExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IBarline barline, XMLExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IBarlineType barlineType, XMLExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPageBeginning pageBeginning, XMLExporterVisitorParam inputOutput) {

    }

    @Override
    public void export(ISystemBeginning systemBeginning, XMLExporterVisitorParam inputOutput) {

    }


}
