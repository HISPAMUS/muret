package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IUnconventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 01/04/2020
 */
public class UnconventionalKeySignature extends KeySignature implements IUnconventionalKeySignature {
    /**
     * Created by factories
     *
     * @param id
     * @param pitchClasses
     */
    UnconventionalKeySignature(IId id, @NotNull IPitchClass[] pitchClasses, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        super(id, pitchClasses, cautionaryKeySignatureAccidentals);
    }

    @Override
    public UnconventionalKeySignature clone() {
        return new UnconventionalKeySignature(null, getPitchClasses().clone(), cautionaryKeySignatureAccidentals);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportUnconventionalKeySignature(this, inputOutput);
    }
}
