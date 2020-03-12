package es.ua.dlsi.grfia.moosicae.core;


import java.util.Optional;

public interface IPart {
    Optional<String> getName();

    void addVoice(IVoice voice);

    IVoice[] getVoices();
    void removeVoice(IVoice voice);
}
