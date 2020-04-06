package es.ua.dlsi.grfia.moosicae.core;

/**
 * Mixed or composite meter. Sequence of any kind of meters: e.g. 3/8+4/4, or (3+2)/4+1/8
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface ICompositeMeter extends IMeter {
    IMeter [] getSubMeters();
}
