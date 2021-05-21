package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * We must treat is as a voiced composite because MEI uses it hierarchically, not as a connector. Implementing these two interfaces, it will be appended as a group of voiced items and as a connector.
 * This fact will be handled in MEIImporter
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 17/5/21
 */
public class MEIBeam implements IVoicedComposite, IBeamGroup {
    IBeamGroup beamGroup;

    public MEIBeam(IBeamGroup beamGroup) {
        this.beamGroup = beamGroup;
    }

    @Override
    public IId getId() {
        return beamGroup.getId();
    }

    @Override
    public MEIBeam clone() {
        return new MEIBeam((IBeamGroup) beamGroup.clone());
    }

    @Override
    public IConnector[] getConnectors() {
        return new IConnector[0];
    }

    @Override
    public IMark[] getMarks() {
        return new IMark[0];
    }

    @Override
    public void addMark(IMark mark) {

    }

    @Override
    public IVoiced[] getChildren() {
        return beamGroup.getConnected();
    }

    @Override
    public void addChild(IVoiced item) {
        this.beamGroup.add(item);

    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
    }

    @Override
    public IVoiced[] getConnected() {
        return getChildren();
    }

    @Override
    public IVoiced getFirst() {
        return beamGroup.getFirst();
    }

    @Override
    public IVoiced getLast() {
        return beamGroup.getLast();
    }

    @Override
    public void add(IVoiced voiced) {
        this.addChild(voiced);
    }
}
