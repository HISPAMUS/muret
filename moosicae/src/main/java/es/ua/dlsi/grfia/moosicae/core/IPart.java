package es.ua.dlsi.grfia.moosicae.core;


import java.util.Optional;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPart {
    Optional<String> getName();

    void addVoice(IVoice voice);

    IVoice[] getVoices();
    void removeVoice(IVoice voice);
}
