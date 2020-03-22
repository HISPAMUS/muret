package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.ISystemBeginning;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SystemBeginning extends PageBeginning implements ISystemBeginning {
    public SystemBeginning(@NotNull IId id) {
        super(id);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public SystemBeginning clone() {
        return new SystemBeginning(IdGenerator.getInstance().generateUniqueId());
    }
}
