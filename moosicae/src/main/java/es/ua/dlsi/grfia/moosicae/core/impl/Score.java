package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Score implements IScore {
    private final LinkedList<IPart> parts;
    private final LinkedList<ISystemElement> systemElements;

    public Score() {
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

}
