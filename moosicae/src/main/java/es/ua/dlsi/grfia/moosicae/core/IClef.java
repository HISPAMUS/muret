package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IClef extends INonDurational {
    Optional<IClefLine> getLine();
    IClefSign getSignType();
}
