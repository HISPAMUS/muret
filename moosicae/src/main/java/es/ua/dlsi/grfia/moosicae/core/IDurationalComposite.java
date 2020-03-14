package es.ua.dlsi.grfia.moosicae.core;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IDurationalComposite extends IDurational {
    IDurational[] getChildren();
}
