package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EBarlineTypes;
import es.ua.dlsi.grfia.moosicae.core.impl.Measure;
import es.ua.dlsi.grfia.moosicae.io.AbstractExporter;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
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
    private final boolean ekern;
    /**
     * Actually, a spine for each voice
     */
    HashMap<IVoice, KernToken> lastVoiceTokens;

    public KernExporter(boolean ekern) {
        super(new KernExporterVisitor(ekern));
        this.ekern = ekern;
        lastVoiceTokens = new HashMap<>();
    }

    public KernExporter() {
        this(false);
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        // in order to export, the IScore is transformed into a humdrum matrix
        KernDocument kernDocument = new KernDocument();
        List<IVoice> voices = generateVoices(score);

        exportParts(kernDocument, score);
        //TODO staves, text, dynamics....
        exportSymbols(kernDocument, voices, score.getMeasures());

        // now, the humdrum matrix is exported as a string
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

    private KernToken export(KernDocument kernDocument, IExporterVisitable item, KernToken lastToken) throws IMException {
        KernExporterVisitorTokenParam kernExporterVisitorTokenParam = new KernExporterVisitorTokenParam(kernDocument, lastToken);
        item.export(this.exporterVisitor, kernExporterVisitorTokenParam);
        return kernExporterVisitorTokenParam.getLastToken();
    }
    private void exportSymbols(KernDocument kernDocument, List<IVoice> voices, IMeasure[] measures) throws IMException {
        //TODO Esto no va para mensural ni para varias voces
        if (voices.size() != 1) {
            throw new IMException("Unsupported several voices and found " + voices.size());
        }
        KernToken lastToken = lastVoiceTokens.get(voices.get(0));
        for (IMeasure measure: measures) {
            //TODO Optimizarlo - esto está muy mal hecho
            for (IVoicedItem voicedItem: measure.getItems()) {
                lastToken = export(kernDocument, voicedItem, lastToken);
            }
            if (measure.getRightBarline().isPresent()) {
                lastToken = export(kernDocument, measure.getRightBarline().get(), lastToken);
            } else {
                IBarline barline = ICoreAbstractFactory.getInstance().createRightBarline(measure.getId(), EBarlineTypes.single);
                lastToken = export(kernDocument, barline, lastToken);
            }
        }
        /*for (IVoice voice: voices) {
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
        }*/
    }

    private void exportParts(KernDocument kernDocument, IScore score) throws IMException {
        //TODO text, ....
        for (int ipart = score.getParts().length-1; ipart>=0; ipart--) {
            IPart part = score.getParts()[ipart];
            for (int ivoice = part.getVoices().length -1; ivoice >= 0; ivoice--) {
                IVoice voice = part.getVoices()[ivoice];
                EKernHeaders header;
                if (this.ekern) { //TODO tipo
                    header = EKernHeaders.ekern;
                } else {
                    header = EKernHeaders.kern;
                }
                KernHeader kernHeader = new KernHeader(header);
                kernDocument.addHeader(kernHeader);

                //KernExporterVisitorTokenParam kernExporterVisitorTokenParam = new KernExporterVisitorTokenParam(kernDocument, kernHeader);
                int npart = ipart+1;
                KernPart kernPart = new KernPart(exporterVisitor.exportPart(npart), npart);
                kernDocument.add(kernHeader, kernPart);

                lastVoiceTokens.put(voice, kernPart);
            }
        }
    }
}
