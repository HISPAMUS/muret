package es.ua.dlsi.grfia.moosicae.core;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IClef extends INonDurational {
    Optional<IClefLine> getLine();
    IClefSign getSignType();
}
