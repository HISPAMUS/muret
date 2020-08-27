package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.impl.KeySignature;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLExporterVisitorParam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLParamExportMode;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MusicXMLExporterVisitor implements IExporterVisitor<XMLExporterVisitorParam> {
    public static final int MAX_DUR = 256;

    @Override
    public void exportClef(IClef clef, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam clefXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("clef"));
            exportClefSign(clef.getSignType(), clefXMLParam);
            if (clef.getLine().isPresent()) {
                clefXMLParam.addChild("line", Integer.toString(clef.getLine().get().getValue()));
            } else if (clef.getSignType().getValue() == EClefSigns.TAB) {
                clefXMLParam.addChild("line", "5");
            }
            if (clef.getOctaveTransposition().isPresent()) {
                exportClefOctaveTransposition(clef.getOctaveTransposition().get(), clefXMLParam);
            }

        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportClefSign(IClefSign clefSign, XMLExporterVisitorParam inputOutput) {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            EClefSigns clefSigns = clefSign.getValue();
            String str;
            switch (clefSigns) {
                case TAB:
                    str = "TAB";
                    break;
                case Percussion:
                    str = "percussion";
                    break;
                default:
                    str = clefSign.getValue().name().toUpperCase();
            }
            inputOutput.addChild("sign", str);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, XMLExporterVisitorParam inputOutput) {
        inputOutput.addChild("clef-octave-change", octaveTransposition.getValue().toString());
    }

    @Override
    public void exportNote(INote note, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLElement xmlNote = new XMLElement("note");
        XMLExporterVisitorParam XMLExporterVisitorParam = new XMLExporterVisitorParam(XMLParamExportMode.element, xmlNote);
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

    private void addTimeSignatureElements(IMeter meter, XMLExporterVisitorParam timeXMLParam) throws IMException {
        if (meter instanceof IStandardTimeSignature) {
            IStandardTimeSignature fractionalTimeSignature = (IStandardTimeSignature) meter;
            timeXMLParam.addChild("beats", fractionalTimeSignature.getNumerator().getValue().toString());
            timeXMLParam.addChild("beat-type", fractionalTimeSignature.getDenominator().getValue().toString());
        } else if (meter instanceof IAdditiveMeter) {
            IAdditiveMeter compoundMeter = (IAdditiveMeter) meter;
            StringBuilder sumNumerators = new StringBuilder();
            for (ITimeSignatureNumerator numerator : compoundMeter.getNumerators()) {
                if (sumNumerators.length() > 0) {
                    sumNumerators.append('+');
                }
                sumNumerators.append(numerator.getValue());
            }
            timeXMLParam.addChild("beats", sumNumerators.toString());
            timeXMLParam.addChild("beat-type", compoundMeter.getDenominator().getValue().toString());
        } else if (meter instanceof ICompositeMeter) {
            ICompositeMeter compositeMeter = (ICompositeMeter) meter;
            for (IMeter submeter: compositeMeter.getSubMeters()) {
                addTimeSignatureElements(submeter, timeXMLParam);
            }
        } else {
            // the cut time and common time cannot be added here because they use an attribute for the time element
            throw new IMException("Unsupported meter: " + meter.getClass().getName());
        }
    }

    @Override
    public void exportStandardTimeSignature(IStandardTimeSignature meter, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam timeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("time"));
            addTimeSignatureElements(meter, timeXMLParam);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
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
    public void exportMixedMeter(IMixedMeter iCompositeMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam timeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("time"));
            addTimeSignatureElements(iCompositeMeter, timeXMLParam);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportAlternatingMeter(IAlternatingMeter mixedMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        throw new UnsupportedOperationException("Alternating meters are not supported by MusicXML");
    }

    @Override
    public void exportAdditiveMeter(IAdditiveMeter compoundMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam timeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("time"));
            addTimeSignatureElements(compoundMeter, timeXMLParam);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void exportInterchangingMeter(IInterchangingMeter interchangingMeter, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam timeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("time"));
            addTimeSignatureElements(interchangingMeter.getLeft(), timeXMLParam);
            XMLExporterVisitorParam interchangeTimeXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, timeXMLParam.addChild("interchangeable"));
            addTimeSignatureElements(interchangingMeter.getRight(), interchangeTimeXMLParam);
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
    public void exportKey(IKey key, XMLExporterVisitorParam inputOutput) throws IMException {
        XMLExporterVisitorParam keyXMLParam;
        if (key.getKeySignature().isPresent()) {
            IKeySignature ks = key.getKeySignature().get();
            if (ks instanceof IConventionalKeySignature) {
                keyXMLParam = doExportConventionalKeySignature((IConventionalKeySignature) ks, inputOutput);
                exportMode(key.getMode(), keyXMLParam);
            } else if (ks instanceof IUnconventionalKeySignature) {
                keyXMLParam = doExportUnconventionalKeySignature((IUnconventionalKeySignature) ks, inputOutput);
            } else {
                throw new IMException("Unsupported key signature class in key: " + key.getKeySignature());
            }
        }
    }

    private XMLExporterVisitorParam doExportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam keyXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("key"));

            for (IPitchClass pitchClass: unconventionalKeySignature.getPitchClasses()) {
                keyXMLParam.addChild("key-step", pitchClass.getDiatonicPitch().getValue().name().toUpperCase());
                if (pitchClass.getAccidental().isPresent()) {
                    keyXMLParam.addChild("key-alter", Integer.toString(pitchClass.getAccidental().get().getValue().getAlteration()));
                } else {
                    throw new IMException("Expected an alteration for the pitch class in key: " + unconventionalKeySignature);
                }
            }

            return keyXMLParam;
        } else {
            throw new UnsupportedOperationException("Invalid export mode: " + inputOutput.getXMLParamExportMode()); //TODO
        }
    }


    @Override
    public void exportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        doExportUnconventionalKeySignature(unconventionalKeySignature, inputOutput);
    }



    @Override
    public void exportConventionalKeySignature(IConventionalKeySignature conventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        doExportConventionalKeySignature(conventionalKeySignature, inputOutput);
    }

    private void exportCautionaryKeySignatureAccidentals(IKeySignature keySignature, String attributeName, XMLExporterVisitorParam inputOutput) throws IMException {
        if (keySignature.getCautionaryAccidentals().isPresent()) {
            XMLExporterVisitorParam cancelElement = inputOutput.addChild(XMLParamExportMode.element, "cancel");
            Optional<KeySignature> previousKeySignature = inputOutput.getProperty(MusicXMLExporter.CONTEXT_LAST_KEY_SIGNATURE);
            if (!previousKeySignature.isPresent()) {
                throw new IMException("Previous key signature to be cancelled not found");
            }
            if (previousKeySignature.get() instanceof IConventionalKeySignature) {
                doExportConventionalKeySignature((IConventionalKeySignature) previousKeySignature.get(), cancelElement);
            } else {
                // cannot add cancel parameter if previous key signature is not conventional (does not uses fifths)
            }
        }
    }

    private XMLExporterVisitorParam doExportConventionalKeySignature(IConventionalKeySignature conventionalKeySignature, XMLExporterVisitorParam inputOutput) throws IMException {
        if (inputOutput.getXMLParamExportMode() == XMLParamExportMode.element) {
            XMLExporterVisitorParam keyXMLParam = new XMLExporterVisitorParam(XMLParamExportMode.element, inputOutput.addChild("key"));
            int fifths;
            if (conventionalKeySignature.getAccidentalSymbol().isPresent()) {
                if (conventionalKeySignature.getAccidentalSymbol().get().getValue() == EAccidentalSymbols.SHARP) {
                    fifths = conventionalKeySignature.getAccidentalCount().getValue();
                } else if (conventionalKeySignature.getAccidentalSymbol().get().getValue() == EAccidentalSymbols.FLAT){
                    fifths = -conventionalKeySignature.getAccidentalCount().getValue();
                } else {
                    throw new IMException("Unsupported accidental in standard key " + conventionalKeySignature.getAccidentalSymbol().get());
                }
            } else {
                fifths = 0;
            }
            keyXMLParam.addChild("fifths", Integer.toString(fifths));
            return keyXMLParam;
        } else {
            throw new UnsupportedOperationException("Invalid export mode: " + inputOutput.getXMLParamExportMode()); //TODO
        }
    }

    @Override
    public void exportMode(IMode mode, XMLExporterVisitorParam inputOutput) {
        inputOutput.addChild("mode", mode.getValue().name().toLowerCase());
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
            if (pitch.getAlteration().isPresent()) {
                exportAlteration(pitch.getAlteration().get(), pitchXMLElement);
            }
            exportOctave(pitch.getOctave(), pitchXMLElement);
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
