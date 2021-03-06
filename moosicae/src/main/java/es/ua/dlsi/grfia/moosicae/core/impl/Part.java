package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.IVoice;

import java.util.LinkedList;
import java.util.Optional;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Part implements IPart {
    private final String name;
    private final LinkedList<IVoice> voices;

    public Part(String name) {
        this.name = name;
        this.voices = new LinkedList<>();
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public void add(IVoice voice) {
        this.voices.add(voice);
    }

    @Override
    public IVoice[] getVoices() {
        return voices.toArray(new IVoice[voices.size()]);
    }

    @Override
    public void remove(IVoice voice) {
        this.voices.remove(voice);
    }
}
