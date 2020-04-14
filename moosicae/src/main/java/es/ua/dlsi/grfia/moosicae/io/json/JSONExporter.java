package es.ua.dlsi.grfia.moosicae.io.json;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.IExporter;

/**
 * It exports the objects into JSON. It's not used to save any file. Instead, use the MEI encoding
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/04/2020
 */
public class JSONExporter implements IExporter {
    private final JSONExporterVisitor exporterVisitor;
    public JSONExporter() {
        exporterVisitor = new JSONExporterVisitor();
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        JSONExportParam scoreParam = new JSONExportParam();
        exporterVisitor.exportScore(score, scoreParam);
        return scoreParam.getJsonObject().toJSONString();
    }
}
