package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IPart;
import es.ua.dlsi.grfia.im4.core.IVoice;

import java.util.LinkedList;
import java.util.Optional;

public class Part implements IPart {
    private String name;
    private final LinkedList<IVoice> voices;

    public Part(String name) {
        this.name = name;
        this.voices = new LinkedList<>();
    }

    public Part() {
        this(null);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public void addVoice(IVoice voice) {
        this.voices.add(voice);
    }

    @Override
    public IVoice[] getVoices() {
        return voices.toArray(new IVoice[voices.size()]);
    }
}
