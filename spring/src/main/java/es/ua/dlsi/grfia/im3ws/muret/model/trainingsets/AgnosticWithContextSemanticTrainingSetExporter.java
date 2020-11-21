package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/11/20
 */
public class AgnosticWithContextSemanticTrainingSetExporter extends AgnosticSemanticTrainingSetExporter {
    public AgnosticWithContextSemanticTrainingSetExporter(int id, DocumentModel documentModel) {
        super(id, documentModel, true);
    }
}
