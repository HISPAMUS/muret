package es.ua.dlsi.grfia.moosicae.core;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoicedComposite extends IVoiced {
    IVoiced[] getChildren();
    void addChild(IVoiced voiced);
}
