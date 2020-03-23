package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
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
        exportVisitor.exportSystemBeginning(this, inputOutput);
    }

    @Override
    public SystemBeginning clone() {
        return new SystemBeginning(IdGenerator.getInstance().generateUniqueId());
    }
}
