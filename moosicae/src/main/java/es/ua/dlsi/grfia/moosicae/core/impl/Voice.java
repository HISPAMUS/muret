package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IName;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


import java.util.LinkedList;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Voice extends CoreObject implements IVoice {

    private final IName name;
    @NotNull
    private final LinkedList<IVoiced> items;

    public Voice(IId id,  IName name) {
        super(id);
        this.name = name;
        items = new LinkedList<>();
    }

    @Override
    public Optional<IName> getName() {
        return Optional.ofNullable(name);
    }

    @Override
    public IVoiced[] getItems() {
        return items.toArray(new IVoiced[items.size()]);
    }

    @Override
    public void addItem(IVoiced item) {
        this.items.add(item);
    }

    @Override
    public Voice clone() {
        Voice voice = new Voice(null, name);
        for (IVoiced voiced: items) {
            voice.addItem((IVoiced) voiced.clone());
        }
        return voice;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportVoice(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voice)) return false;

        Voice voice = (Voice) o;

        if (name != null ? !name.equals(voice.name) : voice.name != null) return false;
        return items.equals(voice.items);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + items.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Voice{" +
                "name=" + name +
                ", items=" + items +
                "} " + super.toString();
    }
}
