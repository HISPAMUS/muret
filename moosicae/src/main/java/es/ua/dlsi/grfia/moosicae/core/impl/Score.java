package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;

public class Score implements IScore {
    private final LinkedList<IPart> parts;
    private final LinkedList<IStaves> staves;

    public Score() {
        parts = new LinkedList<>();
        staves = new LinkedList<>();
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
    public IStaves[] getStaves() {
        return staves.toArray(new IStaves[staves.size()]);
    }

    @Override
    public void addPart(IPart part) {
        this.parts.add(part);
    }

    @Override
    public void addStaves(IStaves staves) {
        this.staves.add(staves);
    }
}
