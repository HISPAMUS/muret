package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MEIExporterVisitor implements IExporterVisitor<MEIExporterVisitorParam> {
    @Override
    public void export(IClef clef, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            inputOutput.addAttribute("clef.line", Integer.toString(clef.getLine()));
            export(clef.getSignType(), inputOutput);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IClefSign clefSign, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            inputOutput.addAttribute("clef.shape", clefSign.getClefSign().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(INote note, MEIExporterVisitorParam inputOutput) throws IMException {
        XMLElement xmlNote = new XMLElement("note");
        MEIExporterVisitorParam meiExporterVisitorParam = new MEIExporterVisitorParam(MEIExporterVisitorParam.ExportMode.attribute, xmlNote);
        export(note.getPitch(), meiExporterVisitorParam);
        export(note.getFigure(), meiExporterVisitorParam);
        if (note.getDots().isPresent()) {
            export(note.getDots().get(), meiExporterVisitorParam);
        }
        inputOutput.addChild(xmlNote);
    }

    @Override
    public void export(IRest rest, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IMultimeasureRest mrest, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IFractionalTimeSignature meter, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(ICutTime meter, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "cut");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(ICommonTime meter, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "common");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(IChord chord, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(ICustos custos, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IKey key, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }


    @Override
    public void export(ICommonAlterationKey commonAlterationKey, MEIExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            StringBuilder keySig = new StringBuilder();
            keySig.append(commonAlterationKey.getAccidentalCount());
            if (commonAlterationKey.getAccidentalSymbol().isPresent()) {
                MEIExporterVisitorParam accidentalParam = new MEIExporterVisitorParam(MEIExporterVisitorParam.ExportMode.string, null);
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
    public void export(IMode mode, MEIExporterVisitorParam inputOutput) {
        inputOutput.addAttribute("key.mode", mode.getMode().name().toLowerCase());

    }

    @Override
    public void export(IKeySignature keySignature, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IVoice voice, MEIExporterVisitorParam inputOutput) {

    }

    @Override
    public void export(IDiatonicPitch diatonicPitch, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            inputOutput.addAttribute("pname", diatonicPitch.getDiatonicPitch().name().toLowerCase());
        } else {
            throw new UnsupportedOperationException("Cannot export a diatonic pitch as other thing different to attribute");
        }
    }

    @Override
    public void export(IAccidentalSymbol accidental, MEIExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.string) {
            switch (accidental.getAccidentalSymbol()) {
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
                    throw new IMException("Unkown accidental symbol: " + accidental.getAccidentalSymbol());
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IAlteration alteration, MEIExporterVisitorParam inputOutput) throws IMException {
        XMLElement alterationXMLElement = new XMLElement("accid");
        inputOutput.addChild(alterationXMLElement);

        //TODO ges.... - IAlterationDisplayType
        MEIExporterVisitorParam accidentalParam = new MEIExporterVisitorParam(MEIExporterVisitorParam.ExportMode.string, null);
        export(alteration.getAccidentalSymbol(), accidentalParam);
        alterationXMLElement.addAttribute("accid.ges", accidentalParam.getStringBuilderValue());

    }

    @Override
    public void export(IPitchClass pitchClass, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPitch pitch, MEIExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
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
    public void export(IDots dots, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            if (dots.getCount() > 0) {
                inputOutput.addAttribute("dots", Integer.toString(dots.getCount()));
            }
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IOctave octave, MEIExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addAttribute("oct", Integer.toString(octave.getNumber()));
    }

    @Override
    public void export(IFigure figures, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.getExportMode() == MEIExporterVisitorParam.ExportMode.attribute) {
            String value;
            switch (figures.getFigure()) {
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
    public void export(IMetronomeMark metronomeMark, MEIExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IBarline barline, MEIExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IBarlineType barlineType, MEIExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPageBeginning pageBeginning, MEIExporterVisitorParam inputOutput) {

    }

    @Override
    public void export(ISystemBeginning systemBeginning, MEIExporterVisitorParam inputOutput) {

    }


}
