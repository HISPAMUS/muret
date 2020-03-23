package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IName;
import javax.validation.constraints.NotNull;


import java.util.LinkedList;
import java.util.Optional;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Part extends CoreObject implements IPart {

    private final IName name;
    @NotNull
    private final LinkedList<IVoice> voices;

    public Part(@NotNull IId id,  IName name) {
        super(id);
        this.name = name;
        this.voices = new LinkedList<>();
    }

    @Override
    public Optional<IName> getName() {
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

    @Override
    public Part clone() {
        Part part = new Part(IdGenerator.getInstance().generateUniqueId(), name);
        for (IVoice voice: voices) {
            part.add((IVoice) voice.clone());
        }
        return part;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Part)) return false;

        Part part = (Part) o;

        if (name != null ? !name.equals(part.name) : part.name != null) return false;
        return voices.equals(part.voices);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + voices.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name=" + name +
                ", voices=" + voices +
                "} " + super.toString();
    }
}
