package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.properties.*;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IMetronomeMarkBuilder extends CoreObjectBuilder<IMetronomeMark> {
    private IFigure figure;
    private IDots dots;
    private IMetronomeMarkValue value;
    private IHorizontalAnchor start;

    public IMetronomeMarkBuilder() {}

    public IMetronomeMarkBuilder from(IFigure figure) {
        this.figure = figure;
        return this;
    }

    public IMetronomeMarkBuilder from(IDots dots) {
        this.dots = dots;
        return this;
    }

    public IMetronomeMarkBuilder from(IHorizontalAnchor start) {
        this.start = start;
        return this;
    }


    public IMetronomeMarkBuilder from(IMetronomeMarkValue value) {
        this.value = value;
        return this;
    }

    @Override
    public IMetronomeMark build() throws IMException {
        return ICoreAbstractFactory.getInstance().createMetronomeMark(getId(), start, figure, dots, value);
    }


}
