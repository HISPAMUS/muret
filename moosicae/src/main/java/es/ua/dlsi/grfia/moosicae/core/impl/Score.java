package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

import java.util.LinkedList;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Score extends CoreObject implements IScore {
    @NotNull
    private final LinkedList<IPart> parts;
    @NotNull
    private final LinkedList<ISystemElement> systemElements;

    public Score(@NotNull IId id) {
        super(id);
        parts = new LinkedList<>();
        systemElements = new LinkedList<>();
    }

    @Override
    public IMetadata getMetadata() {
        return null;
    }

    @Override
    public IPart[] getParts() {
        return parts.toArray(new IPart[parts.size()]);
    }

    @Override
    public ISystemElement[] getSystemElements() {
        return systemElements.toArray(new ISystemElement[systemElements.size()]);
    }

    @Override
    public IStaff[] getAllStaves() {
        LinkedList<IStaff> staves = new LinkedList<>();
        for (ISystemElement child: systemElements) {
            for (IStaff staff: child.getStaves()) {
                staves.add(staff);
            }
        }
        return staves.toArray(new IStaff[staves.size()]);
    }

    @Override
    public void add(IPart part) {
        this.parts.add(part);
    }

    @Override
    public void add(ISystemElement systemElement) {
        this.systemElements.add(systemElement);
    }

    @Override
    public void moveVoice(IVoice voice, IPart fromPart, IPart toPart) {
        fromPart.remove(voice);
        toPart.add(voice);
    }

    @Override
    public void remove(IPart part) {
        this.parts.remove(part);
    }

    @Override
    public void add(IVoice toVoice, IStaff inStaff, ICoreItem symbol) {
        toVoice.addItem(symbol);
        inStaff.put(symbol);
    }

    @Override
    public Score clone() {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;

        Score score = (Score) o;

        if (!parts.equals(score.parts)) return false;
        return systemElements.equals(score.systemElements);
    }

    @Override
    public int hashCode() {
        int result = parts.hashCode();
        result = 31 * result + systemElements.hashCode();
        return result;
    }
}
