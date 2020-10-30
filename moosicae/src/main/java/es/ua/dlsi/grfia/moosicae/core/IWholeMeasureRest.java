package es.ua.dlsi.grfia.moosicae.core;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 30/10/2020
 */
public interface IWholeMeasureRest extends IMultimeasureRest {
    default IRest getRest() {
        return (IRest) getChildren()[0];
    }
}
