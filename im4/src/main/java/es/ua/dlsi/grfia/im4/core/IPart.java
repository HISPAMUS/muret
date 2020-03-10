package es.ua.dlsi.grfia.im4.core;


import java.util.Optional;

public interface IPart {
    Optional<String> getName();

    void addVoice(IVoice voice);

    IVoice[] getVoices();
}
