package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.impl.WholeMeasureRest;
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
    public void exportClef(IClef clef, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            if (clef.getLine().isPresent()) {
                inputOutput.addAttribute("clef.line", Integer.toString(clef.getLine().get().getValue()));
            }
            exportClefSign(clef.getSignType(), inputOutput);
            if (clef.getOctaveTransposition().isPresent()) {
                exportClefOctaveTransposition(clef.getOctaveTransposition().get(), inputOutput);
            }
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
    public void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, XMLExporterVisitorParam inputOutput) throws IMException {
        int oct = octaveTransposition.getValue();
        if (oct != 0) {
            if (octaveTransposition.getValue() < 0) {
                inputOutput.addAttribute("clef.dis.place", "below");
            } else {
                inputOutput.addAttribute("clef.dis.place", "above");
            }
            String str = null;
            switch (oct) {
                case -1:
                case 1:
                    str = "8";
                    break;
                case -2:
                case 2:
                    str = "15";
                    break;
                default:
                    throw new IMException("Unsupported octave transposition:" + oct);
            }
            inputOutput.addAttribute("clef.dis", str);
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
    public void exportStandardTimeSignature(IStandardTimeSignature meter, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.count", Integer.toString(meter.getNumerator().getValue()));
            inputOutput.addAttribute("meter.unit", Integer.toString(meter.getDenominator().getValue()));
        } else {
            XMLElement meterSig = inputOutput.addChild("meterSig");
            meterSig.addAttribute("count", Integer.toString(meter.getNumerator().getValue()));
            meterSig.addAttribute("unit", Integer.toString(meter.getDenominator().getValue()));
        }
    }

    @Override
    public void exportCutTime(ICutTime meter, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "cut");
        } else {
            XMLElement meterSig = inputOutput.addChild("meterSig");
            meterSig.addAttribute("sym", "cut");
        }

    }
    @Override
    public void exportCommonTime(ICommonTime meter, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.sym", "common");
        } else {
            XMLElement meterSig = inputOutput.addChild("meterSig");
            meterSig.addAttribute("sym", "common");
        }
    }

    private void doExportComposite(ICompositeMeter compositeMeter, XMLExporterVisitorParam inputOutput, String func) throws IMException {
        XMLExporterVisitorParam meterSigGrp = inputOutput.addChild(XMLParamExportMode.element, "meterSigGrp");
        meterSigGrp.addAttribute("func", func);
        for (IMeter meter: compositeMeter.getSubMeters()) {
            meter.export(this, meterSigGrp);
        }
    }


    @Override
    public void exportMixedMeter(IMixedMeter mixedMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        doExportComposite(mixedMeter, inputOutput, "mixed");
    }

    @Override
    public void exportAlternatingMeter(IAlternatingMeter alternatingMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        doExportComposite(alternatingMeter, inputOutput, "alternating");
    }

    @Override
    public void exportAdditiveMeter(IAdditiveMeter additiveMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        StringBuilder numerator = new StringBuilder();
        for (ITimeSignatureNumerator num: additiveMeter.getNumerators()) {
            if (numerator.length() > 0) {
                numerator.append('+');
            }
            numerator.append(num.getValue());
        }

        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("meter.count", additiveMeter.toString());
            inputOutput.addAttribute("meter.unit", Integer.toString(additiveMeter.getDenominator().getValue()));
        } else {
            XMLElement meterSig = inputOutput.addChild("meterSig");
            meterSig.addAttribute("count", additiveMeter.toString());
            meterSig.addAttribute("unit", Integer.toString(additiveMeter.getDenominator().getValue()));
        }
    }


    @Override
    public void exportInterchangingMeter(IInterchangingMeter interchangingMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLExporterVisitorParam meterSigGrp = inputOutput.addChild(XMLParamExportMode.element, "meterSigGrp");
        meterSigGrp.addAttribute("func", "interchanging");
        interchangingMeter.getLeft().export(this, meterSigGrp);
        interchangingMeter.getRight().export(this, meterSigGrp);

    }

    @Override
    public void exportWholeMeasureRest(WholeMeasureRest wholeMeasureRest, XMLExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("Whole measure rest");
    }

    @Override
    public void exportChord(IChord chord, XMLExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportCustos(ICustos custos, XMLExporterVisitorParam inputOutputOutput) throws IMException {

    }

    @Override
    public void exportKey(IKey key, XMLExporterVisitorParam inputOutput) throws IMException {
        if (key.getKeySignature().isPresent()) {
            IKeySignature ks = key.getKeySignature().get();
            if (ks instanceof IConventionalKeySignature) {
                exportConventionalKeySignature((IConventionalKeySignature) ks, inputOutput);
                exportMode(key.getMode(), inputOutput);
            } else if (ks instanceof IUnconventionalKeySignature) {
                XMLExporterVisitorParam keySigParam = doExportUnconventionalKeySignature((IUnconventionalKeySignature) ks, inputOutput);
                doExportMode(key.getMode(), "mode", keySigParam);
            }
        }
    }

    private void exportCautionaryKeySignatureAccidentals(IKeySignature keySignature, String attributeName, XMLExporterVisitorParam inputOutput) {
        if (keySignature.getCautionaryAccidentals().isPresent()) {
            inputOutput.addAttribute(attributeName, "true");
        }
    }

    @Override
    public void exportConventionalKeySignature(IConventionalKeySignature conventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            StringBuilder sb = new StringBuilder();
            sb.append(conventionalKeySignature.getAccidentalCount().getValue());
            if (conventionalKeySignature.getAccidentalSymbol().isPresent()) {
                XMLExporterVisitorParam accidentalParam = new XMLExporterVisitorParam(XMLParamExportMode.string);
                exportAccidentalSymbol(conventionalKeySignature.getAccidentalSymbol().get(), accidentalParam);
                sb.append(accidentalParam.getStringBuilderValue());
            }
            inputOutput.addAttribute("key.sig", sb.toString());
            exportCautionaryKeySignatureAccidentals(conventionalKeySignature, "keysig.showchange", inputOutput);
        } else {
            // throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    private XMLExporterVisitorParam doExportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLExporterVisitorParam keySigParam = inputOutput.addChild(XMLParamExportMode.element, "keySig");
        for (IPitchClass pitchClass: unconventionalKeySignature.getPitchClasses()) {
            XMLExporterVisitorParam keyAccidParam = keySigParam.addChild(XMLParamExportMode.attribute, "keyAccid");
            exportPitchClass(pitchClass, keyAccidParam);
        }
        exportCautionaryKeySignatureAccidentals(unconventionalKeySignature, "sig.showchange", inputOutput);
        return keySigParam;
    }
    @Override
    public void exportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        doExportUnconventionalKeySignature(unconventionalKeySignature, inputOutput);
    }



    private void doExportMode(IMode mode, String attrName, XMLExporterVisitorParam inputOutput) {
        inputOutput.addAttribute(attrName, mode.getValue().name().toLowerCase());
    }

    @Override
    public void exportMode(IMode mode, XMLExporterVisitorParam inputOutput) {
        doExportMode(mode, "key.mode", inputOutput);
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
        String accidStr;

        switch (accidental.getValue()) {
            case TRIPLE_FLAT:
                accidStr = "fff";
                break;
            case DOUBLE_FLAT:
                accidStr = "ff";
                break;
            case FLAT:
                accidStr = "f";
                break;
            case NATURAL:
                accidStr = "n";
                break;
            case SHARP:
                accidStr = "s";
                break;
            case DOUBLE_SHARP:
                accidStr = "x";
                break;
            default:
                throw new IMException("Unknown accidental symbol: " + accidental.getValue());
        }

        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.string) {
            inputOutput.append(accidStr);
        } else if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.attribute) {
            inputOutput.addAttribute("accid", accidStr);
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
    public void exportPitchClass(IPitchClass pitchClass, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() != XMLParamExportMode.attribute) {
            throw new IMException("Invalid exporting mode in pitch class: " + inputOutput.getXMLParamExportMode());
        }
        exportDiatonicPitch(pitchClass.getDiatonicPitch(), inputOutput);
        if (pitchClass.getAccidental().isPresent()) {
            exportAccidentalSymbol(pitchClass.getAccidental().get(), inputOutput);
        }
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
            if (dots.getDots().length > 0) {
                inputOutput.addAttribute("dots", Integer.toString(dots.getDots().length));
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
                    value = Integer.toString(figures.computeMeterUnit());
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
