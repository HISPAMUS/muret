package es.ua.dlsi.grfia.im3ws.muret.model.semantic.grammar;

import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.io.kern.*;
import es.ua.dlsi.im3.core.score.layout.MarkBarline;
import es.ua.dlsi.im3.core.score.meters.FractionalTimeSignature;
import es.ua.dlsi.im3.core.score.meters.SignTimeSignature;
import es.ua.dlsi.im3.omr.encoding.semantic.ISemanticImporter;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.*;

import java.io.File;

public class SKernMensSemanticImporter implements ISemanticImporter {

    @Override
    public SemanticEncoding importString(NotationType notationType, String string) throws IM3Exception {
        SKernMensImporter importer = new SKernMensImporter();
        HumdrumMatrix humdrumMatrix = importer.importSKernMens(string, true);
        return humdrumMatrix2SemanticEncoding(notationType, humdrumMatrix);
    }

    @Override
    public SemanticEncoding importFile(NotationType notationType, File file) throws IM3Exception {
        SKernMensImporter importer = new SKernMensImporter();
        HumdrumMatrix humdrumMatrix = importer.importSKernMens(file);
        return humdrumMatrix2SemanticEncoding(notationType, humdrumMatrix);
    }

    //TODO See HumdrumMatrix2ScoreSong (it contains several spines - poly) - we should create first a poly semantic encoding
    private SemanticEncoding humdrumMatrix2SemanticEncoding(NotationType notationType, HumdrumMatrix humdrumMatrix) throws IM3Exception {
        SemanticEncoding semanticEncoding = new SemanticEncoding();

        Ligature lastLigature = null;
        for (int row=0; row<humdrumMatrix.getRowCount(); row++) {
            if (humdrumMatrix.getSpineCount(row) != 1) {
                throw new ImportException("Currently only monodies are supported");
            }
            //for (int spine=0; spine < humdrumMatrix.getSpineCount(row); spine++) {
            int spine = 0;
            HumdrumMatrixItem item = humdrumMatrix.get(row, spine);
            SemanticSymbolType semanticSymbolType = null;
            if (item.getHumdrumEncoding().equals(".")) {
                // continuation, skip
            } else if (item.getParsedObject() instanceof Clef) { // TODO algo más elegante
                semanticEncoding.add(semanticSymbolType = new SemanticClef((Clef) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof Custos) { // TODO algo más elegante
                semanticEncoding.add(semanticSymbolType = new SemanticCustos((Custos) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof Key) {
                KeySignature keySignature = new KeySignature(notationType, (Key) item.getParsedObject());
                semanticEncoding.add(semanticSymbolType = new SemanticKeySignature(keySignature));
            } else if (item.getParsedObject() instanceof FractionalTimeSignature) {
                semanticEncoding.add(semanticSymbolType = new SemanticFractionalTimeSignature((FractionalTimeSignature) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof SignTimeSignature) {
                semanticEncoding.add(semanticSymbolType = new SemanticMeterSignTimeSignature((SignTimeSignature) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof MarkBarline) {
                semanticEncoding.add(semanticSymbolType = new SemanticBarline((MarkBarline) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof SimpleNote) {
                semanticEncoding.add(semanticSymbolType = new SemanticNote((SimpleNote) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof SimpleRest) {
                semanticEncoding.add(semanticSymbolType = new SemanticRest((SimpleRest) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof SimpleMultiMeasureRest) {
                semanticEncoding.add(semanticSymbolType = new SemanticMultirest((SimpleMultiMeasureRest) item.getParsedObject()));
            } else if (item.getParsedObject() instanceof KernLigatureComponent) {
                KernLigatureComponent kernLigatureComponent = (KernLigatureComponent) item.getParsedObject();
                if (kernLigatureComponent.getStartEnd() == LigatureStartEnd.start) {
                    lastLigature = new Ligature(kernLigatureComponent.getType());
                }

                //TODO ligature con tipos mezclados
                lastLigature.addSubatom(kernLigatureComponent.getSimpleNote());

                if (kernLigatureComponent.getStartEnd() == LigatureStartEnd.end) {
                    semanticEncoding.add(semanticSymbolType = new SemanticLigature(lastLigature));
                    lastLigature = null;
                }

            } else if (!item.getHumdrumEncoding().equals("!")) {
                //TODO Acabar
                System.err.println("TO-DO: " + item.getHumdrumEncoding());
            }

            if (semanticSymbolType != null) {
                semanticSymbolType.setAgnosticIDs(item.getAssociatedIDS());
            }
        }

        return semanticEncoding;
    }


}
