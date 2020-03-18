package es.ua.dlsi.grfia.moosicae.io.lilypond;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public class LilypondExporterVisitor implements IExporterVisitor<LilypondContext> {


    @Override
    public void export(IClef clef, LilypondContext inputOutput) throws IMException {
        //TODO
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\clef ");
        stringBuilder.append(clef.getSignType().getClefSign().name().toUpperCase());

        inputOutput.addChild(stringBuilder.toString());
    }

    @Override
    public void export(IClefSign clefSign, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(INote note, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IRest rest, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IMultimeasureRest mrest, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IFractionalTimeSignature meter, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(ICutTime meter, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(ICommonTime meter, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IChord chord, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(ICustos custos, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IKey key, LilypondContext inputOutput) throws IMException {
    }

    @Override
    public void export(ICommonAlterationKey commonAlterationKey, LilypondContext inputOutput) throws IMException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\key ");
        stringBuilder.append(commonAlterationKey.getPitchClass().getDiatonicPitch().getDiatonicPitch().name().toLowerCase());
        stringBuilder.append(' ');
        stringBuilder.append(commonAlterationKey.getMode().getMode().name().toLowerCase());
        inputOutput.addChild(stringBuilder.toString());

    }

    @Override
    public void export(IMode mode, LilypondContext inputOutput) {

    }

    @Override
    public void export(IKeySignature keySignature, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IVoice voice, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IDiatonicPitch diatonicPitch, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IAccidentalSymbol accidental, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IAlteration alteration, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IPitchClass pitchClass, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IPitch pitch, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IDots dots, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IFigure figures, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IMetronomeMark metronomeMark, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IBarline barline, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IBarlineType barlineType, LilypondContext inputOutput) throws IMException {

    }

    @Override
    public void export(IPageBeginning pageBeginning, LilypondContext inputOutput) {

    }

    @Override
    public void export(ISystemBeginning systemBeginning, LilypondContext inputOutput) {

    }
}
