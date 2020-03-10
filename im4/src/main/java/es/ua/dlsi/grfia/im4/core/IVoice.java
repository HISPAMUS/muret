package es.ua.dlsi.grfia.im4.core;

/**
 * A composite pattern is used because the voice may contain a list of symbols where a symbol may be a note or other voice
 * (e.g. a divisi)
 */
public interface IVoice extends IVoiced {
    IVoiced[] getItems();
    void addItem(IVoiced voiced);
}
