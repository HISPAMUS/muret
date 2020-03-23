package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IMetronomeMarkValue;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMetronomeMarkBuilder extends CoreObjectBuilder<IMetronomeMark> {
    private IFigure figure;
    private IDots dots;
    private IMetronomeMarkValue value;

    public IMetronomeMarkBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IMetronomeMarkBuilder from(IFigure figure) {
        this.figure = figure;
        return this;
    }

    public IMetronomeMarkBuilder from(IDots dots) {
        this.dots = dots;
        return this;
    }

    public IMetronomeMarkBuilder from(IMetronomeMarkValue value) {
        this.value = value;
        return this;
    }

    @Override
    public IMetronomeMark build() throws IMException {
        return coreObjectFactory.createMetronomeMark(getId(), figure, dots, value);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMetronome(this, inputOutputType);
    }
}
