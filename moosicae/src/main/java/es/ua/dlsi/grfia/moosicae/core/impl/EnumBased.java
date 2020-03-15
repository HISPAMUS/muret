package es.ua.dlsi.grfia.moosicae.core.impl;

/**
 * Used as a convenience class serving as base for all classes wrapping an enum
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class EnumBased<EnumType>  {
    protected final EnumType enumValue;

    public EnumBased(EnumType enumValue) {
        this.enumValue = enumValue;
    }
}
