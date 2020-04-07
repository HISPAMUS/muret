package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.AbstractExporter;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmDocument;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.ESkmHeaders;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmHeader;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmPart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmExporter extends AbstractExporter<SkmExporterVisitor> {
    /**
     * Actually, a spine for each voice
     */
    HashMap<IVoice, SkmToken> lastVoiceTokens;

    public SkmExporter() {
        super(new SkmExporterVisitor());
        lastVoiceTokens = new HashMap<>();
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        SkmDocument skmDocument = new SkmDocument();
        List<IVoice> voices = generateVoices(score);

        exportParts(skmDocument, score);
        //TODO staves, text, dynamics....
        exportSymbols(skmDocument, voices);

        return exportSkmDocument(skmDocument);
    }

    private String exportSkmDocument(SkmDocument skmDocument) {
        StringBuilder stringBuilder = new StringBuilder();
        //TODO - null tokens para múltiples spines - ahora uso el grafo ¿debería usar un visitor?
        //TODO varios spines - ahora sólo uso uno
        List<SkmToken> headers = skmDocument.getHeaderTokens();
        for (SkmToken header: headers) {
            export(skmDocument, header, stringBuilder);
        }
        //TODO añado esto a mano
        stringBuilder.append("*-");
        return stringBuilder.toString();
    }

    private void export(SkmDocument skmDocument, SkmToken token, StringBuilder stringBuilder) {
        stringBuilder.append(token.getEncoding());
        stringBuilder.append('\n');
        for (SkmToken nextToken: skmDocument.getNextList(token)) {
            export(skmDocument, nextToken, stringBuilder);
        }
    }

    private List<IVoice> generateVoices(IScore score) {
        LinkedList<IVoice> result = new LinkedList<>();
        for (int ipart = score.getParts().length-1; ipart>=0; ipart--) {
            IPart part = score.getParts()[ipart];
            for (int ivoice = part.getVoices().length - 1; ivoice >= 0; ivoice--) {
                IVoice voice = part.getVoices()[ivoice];
                result.add(voice);
            }
        }
        return result;
    }

    private void exportSymbols(SkmDocument skmDocument, List<IVoice> voices) throws IMException {
        for (IVoice voice: voices) {
            SkmToken lastToken = lastVoiceTokens.get(voice);
            if (voice == null) {
                throw new IMRuntimeException("Cannot find last token for voice " + voice);
            }
            for (IVoiced voiced: voice.getItems()) {
                SkmExporterVisitorTokenParam skmExporterVisitorTokenParam = new SkmExporterVisitorTokenParam(skmDocument, lastToken);
                voiced.export(this.exporterVisitor, skmExporterVisitorTokenParam);
                //TODO varios spines...
                lastToken = skmExporterVisitorTokenParam.getLastToken();
            }
        }
    }

    private void exportParts(SkmDocument skmDocument, IScore score) throws IMException {
        //TODO text, ....
        for (int ipart = score.getParts().length-1; ipart>=0; ipart--) {
            IPart part = score.getParts()[ipart];
            for (int ivoice = part.getVoices().length -1; ivoice >= 0; ivoice--) {
                IVoice voice = part.getVoices()[ivoice];
                SkmHeader skmHeader = new SkmHeader(ESkmHeaders.skern);  //TODO tipo
                skmDocument.addHeader(skmHeader);

                SkmPart skmPart = new SkmPart(ipart+1);
                skmDocument.add(skmHeader, skmPart);
                lastVoiceTokens.put(voice, skmPart);
            }
        }
    }

    private String exportPartNumber(int n) {
        return "*part" + n;
    }
}
