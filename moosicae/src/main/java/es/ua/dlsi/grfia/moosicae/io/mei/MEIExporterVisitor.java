package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLExporterVisitorParam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLParamExportMode;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MEIExporterVisitor implements IExporterVisitor<XMLExporterVisitorParam> {
    @Override
    public void export(IClef clef, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (clef.getLine().isPresent()) {
                inputOutput.addAttribute("clef.line", Integer.toString(clef.getLine().get()));
            }
            export(clef.getSignType(), inputOutput);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IClefSign clefSign, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("clef.shape", clefSign.getValue().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(INote note, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement xmlNote = new XMLElement("note");
        XMLExporterVisitorParam XMLExporterVisitorParam = new XMLExporterVisitorParam(XMLParamExportMode.attribute, xmlNote);
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
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "cut");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(ICommonTime meter, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "common");
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
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            StringBuilder keySig = new StringBuilder();
            keySig.append(commonAlterationKey.getAccidentalCount());
            if (commonAlterationKey.getAccidentalSymbol().isPresent()) {
                XMLExporterVisitorParam accidentalParam = new XMLExporterVisitorParam(XMLParamExportMode.string);
                export(commonAlterationKey.getAccidentalSymbol().get(), accidentalParam);
                keySig.append(accidentalParam.getStringBuilderValue());
            }

            inputOutput.addAttribute("key.sig", keySig.toString());
            export(commonAlterationKey.getMode(), inputOutput);
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
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("pname", diatonicPitch.getValue().name().toLowerCase());
        } else {
            throw new UnsupportedOperationException("Cannot export a diatonic pitch as other thing different to attribute");
        }
    }

    @Override
    public void export(IAccidentalCore accidental, XMLExporterVisitorParam inputOutput) throws IMException {
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
    public void export(IAlterationDisplayType alterationDisplayType, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IAlteration alteration, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement alterationXMLElement = new XMLElement("accid");
        inputOutput.addChild(alterationXMLElement);

        //TODO ges.... - IAlterationDisplayType
        XMLExporterVisitorParam accidentalParam = new XMLExporterVisitorParam(XMLParamExportMode.string);
        export(alteration.getAccidentalSymbol(), accidentalParam);
        alterationXMLElement.addAttribute("accid.ges", accidentalParam.getStringBuilderValue());

    }

    @Override
    public void export(IPitchClass pitchClass, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPitch pitch, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (pitch.getAlteration().isPresent()) {
                export(pitch.getAlteration().get(), inputOutput);
            }
            export(pitch.getDiatonicPitch(), inputOutput);
            export(pitch.getOctave(), inputOutput);
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
        inputOutput.addAttribute("oct", Integer.toString(octave.getNumber()));
    }

    @Override
    public void export(IFigure figures, XMLExporterVisitorParam inputOutput) {
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
