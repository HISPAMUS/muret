package es.ua.dlsi.grfia.moosicae.core;

/**
 * Designed using a composite pattern, this is the base component
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ISystemElement extends ICoreObject{
    IStaff[] getStaves();
}
