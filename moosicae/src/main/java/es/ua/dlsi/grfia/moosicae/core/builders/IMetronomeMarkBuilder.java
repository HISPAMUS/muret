package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMetronomeMarkBuilder extends CoreObjectBuilder<IMetronomeMark> {
    private IFigure figure;
    private IDots dots;
    private Integer value;

    public IMetronomeMarkBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setFigure(IFigure figure) {
        this.figure = figure;
    }

    public void setDots(IDots dots) {
        this.dots = dots;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public IMetronomeMark build() throws IMException {
        assertRequired("figure", figure);
        assertRequired("value", value);
        return coreObjectFactory.createMetronomeMark(getId(), figure, dots, value);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importMetronome(this, inputOutputType);
    }
}
