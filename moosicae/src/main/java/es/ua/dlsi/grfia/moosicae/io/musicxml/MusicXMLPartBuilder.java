package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.IMusicXMLPartItem;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.MusicXMLImportedPart;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.MusicXMLImporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.xml.IXMLImporterVisitorParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MusicXMLPartBuilder extends CoreObjectBuilder<MusicXMLImportedPart> {
    private final List<IMusicXMLPartItem> items;

    public MusicXMLPartBuilder(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
        this.items = new LinkedList<>();
    }

    @Override
    public MusicXMLImportedPart build() throws IMException {
        return new MusicXMLImportedPart(getId(), items);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) throws IMException {
        MusicXMLImporterVisitor musicXMLImporterVisitor = (MusicXMLImporterVisitor) importerVisitor; // only used by this visitor
        musicXMLImporterVisitor.importMusicXMLPartBuilder(this, (IXMLImporterVisitorParam)inputOutputType);
    }

    public void add(IMusicXMLPartItem voiced) {
        this.items.add(voiced);
    }
}
