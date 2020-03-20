package es.ua.dlsi.grfia.moosicae.core;


import java.util.Optional;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPart {
    Optional<String> getName();

    void add(IVoice voice);

    IVoice[] getVoices();
    void remove(IVoice voice);
}
