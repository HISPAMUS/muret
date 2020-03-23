package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.IObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MusicXMLAttributesBuilder implements IObjectBuilder<MusicXMLAttributes> {
    private List<INonDurational> nonDurationals;

    public MusicXMLAttributesBuilder(ICoreAbstractFactory coreAbstractFactory) {
        this.nonDurationals = new LinkedList<>();
    }

    public MusicXMLAttributesBuilder add(INonDurational nonDurational) {
        this.nonDurationals.add(nonDurational);
        return this;
    }

    @Override
    public MusicXMLAttributes build() throws IMException {
        return new MusicXMLAttributes(nonDurationals.toArray(new INonDurational[nonDurationals.size()]));
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) throws IMException {

    }
}
