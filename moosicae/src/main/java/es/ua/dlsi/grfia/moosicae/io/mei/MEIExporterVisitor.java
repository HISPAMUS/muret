package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class MEIExporterVisitor implements IExporterVisitor<MEIExporterVisitorParam> {
    @Override
    public void export(IClef clef, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.isExportAsAttributes()) {
            inputOutput.addAttribute("clef.line", Integer.toString(clef.getLine()));
            export(clef.getSignType(), inputOutput);
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }
    }

    @Override
    public void export(IClefSign clefSign, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.isExportAsAttributes()) {
            inputOutput.addAttribute("clef.shape", clefSign.getClefSign().name().toUpperCase());
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(INote note, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
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
        if (inputOutput.isExportAsAttributes()) {
            inputOutput.addAttribute("meter.sym", "cut");
        } else {
            throw new UnsupportedOperationException("TO-DO"); //TODO
        }

    }

    @Override
    public void export(ICommonTime meter, MEIExporterVisitorParam inputOutput) {
        if (inputOutput.isExportAsAttributes()) {
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
    public void export(ICommonAlterationKey commonAlterationKey, MEIExporterVisitorParam inputOutputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
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
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IAccidentalSymbol accidental, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IAlterationDisplayType alterationDisplayType, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IAlteration alteration, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPitchClass pitchClass, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IPitch pitch, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IDots dots, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }

    @Override
    public void export(IFigure figures, MEIExporterVisitorParam inputOutput) {
        throw new UnsupportedOperationException("TO-DO"); //TODO
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
    public void export(IBarlineType barlineType, StringBuilder inputOutput) throws IMException {
        throw new UnsupportedOperationException("TO-DO"); //TODO
    }
}
