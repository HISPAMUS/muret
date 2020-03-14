package es.ua.dlsi.grfia.moosicae.core;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface IPitch extends ISymbolProperty {
    IOctave getOctave();
    IAlteration getAlteration();
    EDiatonicPitches getDiatonicPitch();
}
