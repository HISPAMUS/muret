package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.IVoice;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.io.AbstractExporter;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.EKernHeaders;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernDocument;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernHeader;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernPart;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernExporter extends AbstractExporter<KernExporterVisitor> {
    /**
     * Actually, a spine for each voice
     */
    HashMap<IVoice, KernToken> lastVoiceTokens;

    public KernExporter() {
        super(new KernExporterVisitor());
        lastVoiceTokens = new HashMap<>();
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        KernDocument kernDocument = new KernDocument();
        List<IVoice> voices = generateVoices(score);

        exportParts(kernDocument, score);
        //TODO staves, text, dynamics....
        exportSymbols(kernDocument, voices);

        return exportKernDocument(kernDocument);
    }

    private String exportKernDocument(KernDocument kernDocument) {
        StringBuilder stringBuilder = new StringBuilder();
        //TODO - null tokens para múltiples spines - ahora uso el grafo ¿debería usar un visitor?
        //TODO varios spines - ahora sólo uso uno
        List<KernToken> headers = kernDocument.getHeaderTokens();
        for (KernToken header: headers) {
            export(kernDocument, header, stringBuilder);
        }
        //TODO añado esto a mano
        stringBuilder.append("*-");
        return stringBuilder.toString();
    }

    private void export(KernDocument kernDocument, KernToken token, StringBuilder stringBuilder) {
        stringBuilder.append(token.getEncoding());
        stringBuilder.append('\n');
        for (KernToken nextToken: kernDocument.getNextList(token)) {
            export(kernDocument, nextToken, stringBuilder);
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

    private void exportSymbols(KernDocument kernDocument, List<IVoice> voices) throws IMException {
        for (IVoice voice: voices) {
            KernToken lastToken = lastVoiceTokens.get(voice);
            if (voice == null) {
                throw new IMRuntimeException("Cannot find last token for voice " + voice);
            }
            for (IVoiced voiced: voice.getItems()) {
                KernExporterVisitorTokenParam kernExporterVisitorTokenParam = new KernExporterVisitorTokenParam(kernDocument, lastToken);
                voiced.export(this.exporterVisitor, kernExporterVisitorTokenParam);
                //TODO varios spines...
                lastToken = kernExporterVisitorTokenParam.getLastToken();
            }
        }
    }

    private void exportParts(KernDocument kernDocument, IScore score) throws IMException {
        //TODO text, ....
        for (int ipart = score.getParts().length-1; ipart>=0; ipart--) {
            IPart part = score.getParts()[ipart];
            for (int ivoice = part.getVoices().length -1; ivoice >= 0; ivoice--) {
                IVoice voice = part.getVoices()[ivoice];
                KernHeader kernHeader = new KernHeader(EKernHeaders.skern);  //TODO tipo
                kernDocument.addHeader(kernHeader);

                KernExporterVisitorTokenParam kernExporterVisitorTokenParam = new KernExporterVisitorTokenParam(kernDocument, kernHeader);
                int npart = ipart+1;
                KernPart kernPart = new KernPart(exporterVisitor.exportPart(npart), npart);
                kernDocument.add(kernHeader, kernPart);

                lastVoiceTokens.put(voice, kernPart);
            }
        }
    }
}
