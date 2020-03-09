package es.ua.dlsi.grfia.im4.core;

/**
 * Leaf of the composite pattern with IDurationalComposite
 */
public interface IDurationalSingle extends IDurational {
    IFigure getFigure();
    IDots getDots();
}
