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
    private final LinkedList<ISystem> systemElements;
    @NotNull
    private final LinkedList<IMeasure> measures;

    public Score(IId id) {
        super(id);
        parts = new LinkedList<>();
        systemElements = new LinkedList<>();
        measures = new LinkedList<>();
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
    public ISystem[] getSystemElements() {
        return systemElements.toArray(new ISystem[systemElements.size()]);
    }

    @Override
    public IMeasure[] getMeasures() {
        return measures.toArray(new IMeasure[measures.size()]);
    }

    @Override
    @Deprecated
    public IStaff[] listAllStaves() {
        LinkedList<IStaff> staves = new LinkedList<>();
        for (ISystem child: systemElements) {
            for (IStaff staff: child.listStaves()) {
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
    public void add(ISystem systemElement) {
        this.systemElements.add(systemElement);
    }

    @Override
    public void remove(ISystem systemElement) {
        this.systemElements.remove(systemElement);
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
    public void add(IVoice toVoice, IStaff inStaff, IVoicedItem symbol) {
        toVoice.addItem(symbol);
        inStaff.put(symbol);
    }

    @Override
    public void add(IMeasure measure) {
        this.measures.add(measure);
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
