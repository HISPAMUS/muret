package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlPartContents;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlScorePartWise;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlScorePartWiseBuilder extends CoreObjectBuilder<MxmlScorePartWise> implements IImporterAdapter<MxmlScorePartWise, XMLImporterParam> {
    private List<IPart> coreParts;
    private List<MxmlPartContents> mxmlPartContentsList;

    public MxmlScorePartWiseBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        mxmlPartContentsList = new LinkedList<>();
        coreParts = new LinkedList<>();
    }

    public MxmlScorePartWiseBuilder add(MxmlPartContents part) {
        mxmlPartContentsList.add(part);
        return this;
    }

    public MxmlScorePartWiseBuilder add(IPart part) {
        coreParts.add(part);
        return this;
    }

    @Override
    public MxmlScorePartWise build() throws IMException {
        return new MxmlScorePartWise(getId(),
                coreParts.toArray(new IPart[coreParts.size()]),
                mxmlPartContentsList.toArray(new MxmlPartContents[mxmlPartContentsList.size()]));
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {

    }
}
