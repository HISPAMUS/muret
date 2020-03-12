package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the leaf class
 */
public interface IStaff extends IStaves {
    int getNumber();
    IStaffSymbol [] getStaffSymbols();
}
