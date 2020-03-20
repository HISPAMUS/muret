package es.ua.dlsi.grfia.moosicae.io.lilypond;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public class LilypondExporterVisitor implements IExporterVisitor<LilypondExporterVisitorParam> {


    @Override
    public void export(IClef clef, LilypondExporterVisitorParam inputOutput) throws IMException {
        //TODO
        inputOutput.startString();
        inputOutput.append("\\clef ");
        inputOutput.append(clef.getSignType().getClefSign().name().toUpperCase());
        inputOutput.finishString();
    }

    @Override
    public void export(IClefSign clefSign, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(INote note, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.startString();
        export(note.getPitch(), inputOutput);
        export(note.getFigure(), inputOutput);
        if (note.getDots().isPresent()) {
            export(note.getDots().get(), inputOutput);
        }
        inputOutput.finishString();
    }

    @Override
    public void export(IRest rest, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IMultimeasureRest mrest, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IFractionalTimeSignature meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChild("\\numericTimeSignature");
        inputOutput.addChild("\\time " + meter.getNumerator() + "/" + meter.getDenominator());
    }

    @Override
    public void export(ICutTime meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChild("\\defaultTimeSignature");
        inputOutput.addChild("\\time 2/2");
    }

    @Override
    public void export(ICommonTime meter, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.addChild("\\defaultTimeSignature");
        inputOutput.addChild("\\time 4/4");
    }

    @Override
    public void export(IChord chord, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(ICustos custos, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IKey key, LilypondExporterVisitorParam inputOutput) throws IMException {
    }

    @Override
    public void export(ICommonAlterationKey commonAlterationKey, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.startString();
        inputOutput.append("\\key ");
        inputOutput.append(commonAlterationKey.getPitchClass().getDiatonicPitch().getDiatonicPitch().name().toLowerCase());
        inputOutput.append(' ');
        inputOutput.append('\\');
        inputOutput.append(commonAlterationKey.getMode().getMode().name().toLowerCase());
        inputOutput.finishString();

    }

    @Override
    public void export(IMode mode, LilypondExporterVisitorParam inputOutput) {

    }

    @Override
    public void export(IKeySignature keySignature, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IVoice voice, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IDiatonicPitch diatonicPitch, LilypondExporterVisitorParam inputOutput) throws IMException {
        inputOutput.append(diatonicPitch.getDiatonicPitch().name().toLowerCase());
    }

    @Override
    public void export(IAccidentalSymbol accidental, LilypondExporterVisitorParam inputOutput) throws IMException {
        switch (accidental.getAccidentalSymbol()) {
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
                throw new IMException("Unkown accidental symbol: " + accidental.getAccidentalSymbol());
        }
    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IAlteration alteration, LilypondExporterVisitorParam inputOutput) throws IMException {
        //TODO display type
        export(alteration.getAccidentalSymbol(), inputOutput);
   }

    @Override
    public void export(IPitchClass pitchClass, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IPitch pitch, LilypondExporterVisitorParam inputOutput) throws IMException {
        export(pitch.getDiatonicPitch(), inputOutput);
        if (pitch.getAlteration().isPresent()) {
            export(pitch.getAlteration().get(), inputOutput);
        }
        export(pitch.getOctave(), inputOutput);
    }

    @Override
    public void export(IOctave octave, LilypondExporterVisitorParam inputOutput) {
        int n = octave.getNumber();
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
    public void export(IDots dots, LilypondExporterVisitorParam inputOutput) throws IMException {
        for (int i=0; i<dots.getCount(); i++) {
            inputOutput.append('.');
        }
    }

    @Override
    public void export(IFigure figures, LilypondExporterVisitorParam inputOutput) throws IMException {
        String value;
        switch (figures.getFigure()) {
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
    public void export(IMetronomeMark metronomeMark, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IBarline barline, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IBarlineType barlineType, LilypondExporterVisitorParam inputOutput) throws IMException {

    }

    @Override
    public void export(IPageBeginning pageBeginning, LilypondExporterVisitorParam inputOutput) {

    }

    @Override
    public void export(ISystemBeginning systemBeginning, LilypondExporterVisitorParam inputOutput) {

    }
}
