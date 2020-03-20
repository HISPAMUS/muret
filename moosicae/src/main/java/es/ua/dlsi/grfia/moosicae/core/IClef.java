package es.ua.dlsi.grfia.moosicae.core;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IClef extends INonDurational {
    int getLine();
    IClefSign getSignType();
}
