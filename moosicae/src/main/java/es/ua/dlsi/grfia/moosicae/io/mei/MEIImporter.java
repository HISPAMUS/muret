package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.MEILayerBuilder;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.MEIMeasureBuilder;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.MEIStaffBuilder;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlImportedPart;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MEIImporter extends XMLImporter implements IImporter {
    private List<MxmlImportedPart> mxmlImportedParts;
    private IScore score;

    public MEIImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory);
        //coreObjectBuilderSuppliers.add("staffDef", IStaffBuilder::new);
        coreObjectBuilderSuppliers.add("measure", MEIMeasureBuilder::new);
        coreObjectBuilderSuppliers.add("staff", MEIStaffBuilder::new);
        coreObjectBuilderSuppliers.add("layer", MEILayerBuilder::new);

        coreObjectBuilderSuppliers.add("note", INoteBuilder::new);
        coreObjectBuilderSuppliers.add("note", IAlterationBuilder::new);

        mxmlImportedParts = new LinkedList<>();
    }


    @Override
    protected IScore buildScore() throws IMException {

        return score;
    }

    @Override
    protected void onEndElement(String elementName, Object end) {

    }
}
