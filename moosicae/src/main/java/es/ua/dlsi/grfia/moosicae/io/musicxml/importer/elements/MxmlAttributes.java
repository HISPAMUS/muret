package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;


import javax.validation.constraints.NotNull;

/**
 * It contains clef changes, keys, meters..
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlAttributes extends MxmlObject implements IMxmlPartItem {

    @NotNull
    private final INonDurational [] nonDurationalList;
    /**
     * It can be null in clef or key changes in the middle of a measure
     */
    private final MxmlDivisions divisions;

    public MxmlAttributes(IId id, MxmlDivisions divisions, INonDurational [] nonDurationalList ) {
        super(id);
        this.divisions = divisions;
        this.nonDurationalList = nonDurationalList.clone();
    }

    public INonDurational[] getNonDurationalList() {
        return nonDurationalList;
    }

    public MxmlDivisions getDivisions() {
        return divisions;
    }

    @Override
    public MxmlAttributes clone() {
        return new MxmlAttributes(id, divisions, nonDurationalList);

    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {

    }

    @Override
    public IVoicedSingle[] getItems() {
        return nonDurationalList;
    }

    @Override
    public IConnector[] getConnectors() {
        throw new UnsupportedOperationException("TO-DO");
    }

    @Override
    public IMark[] getMarks() {
        return new IMark[0];
    }

    @Override
    public void addMark(IMark mark) {

    }

    @Override
    public void addConnector(IConnector connector) {

    }
}
