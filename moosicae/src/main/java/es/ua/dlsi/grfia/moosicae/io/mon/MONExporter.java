package es.ua.dlsi.grfia.moosicae.io.mon;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.IExporter;

/**
 * It exports the objects into mO.O.sicae Object Notation JSON (MON).
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/04/2020
 */
public class MONExporter implements IExporter {
    private final MONExporterVisitor exporterVisitor;
    public MONExporter() {
        exporterVisitor = new MONExporterVisitor();
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        MONExportParam scoreParam = new MONExportParam();
        exporterVisitor.exportScore(score, scoreParam);
        return scoreParam.getJsonObject().toJSONString();
    }
}
