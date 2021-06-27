package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.INotationType;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphContentNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreStaffSubgraph;
import es.ua.dlsi.grfia.moosicae.io.AbstractExporter;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.EKernHeaders;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernDocument;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernHeader;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernPart;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernStaff;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Each KernExported object should be used for every exportation, as it uses internal variables for the process
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernExporter extends AbstractExporter<KernExporterVisitor> {
    private final boolean ekern;
    /**
     * Actually, a spine for each voice
     */
    HashMap<IVoice, KernToken> lastVoiceTokens;
    private IScore score;
    private KernDocument kernDocument;
    private KernExporterContext kernExporterContext;
    private IMeter lastMeter;
    private boolean addPart;

    public KernExporter(boolean addPart, boolean ekern) {
        super(new KernExporterVisitor(ekern));
        this.ekern = ekern;
        this.addPart = addPart; //TODO
        kernExporterContext = new KernExporterContext();
        lastVoiceTokens = new HashMap<>();
    }

    public KernExporter() {
        this(true, false);
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        this.score = score;
        // in order to export, the IScore is transformed into a humdrum matrix
        kernDocument = new KernDocument();

        exportScoreGraph();

        /*TODO Spines .... exportParts(kernDocument, score);
        //TODO staves, text, dynamics....
        List<IVoice> voices = generateVoices(score);
        exportSymbols(kernDocument, voices, score.getMeasures());*/

        // now, the humdrum matrix is exported as a string
        return exportKernDocument(kernDocument);
    }

    private void exportScoreGraph() throws IMException {
        //TODO Varios spines
        IScoreStaffSubgraph[] stavesSubgraphs = score.getScoreGraph().getStavesSubgraphs();
        if (stavesSubgraphs.length != 1) {
            throw new IMException("Unsupported several staves");
        }

        INotationType notationType = stavesSubgraphs[0].getStaff().getNotationType();
        IScoreGraphContentNode[] next = score.getScoreGraph().getStartNode().getNextNodes(stavesSubgraphs[0]);
        KernToken lastToken = null;
        EKernHeaders header;
        KernPart kernPart = null;
        KernStaff kernStaff = null;
        if (this.ekern) { //TODO Otros tipos
            if (notationType.getValue() == ENotationTypes.eMensural) {
                header = EKernHeaders.emens_1_0;
            } else {
                header = EKernHeaders.ekern_1_0;
            }

            if (this.addPart) {
                kernPart = new KernPart("*part·1", 1);
            }
            kernStaff = new KernStaff("*staff·1", 1);
        } else {
            if (notationType.getValue() == ENotationTypes.eMensural) {
                header = EKernHeaders.mens;
            } else {
                header = EKernHeaders.kern;
            }
            if (this.addPart) {
                kernPart = new KernPart("*part1", 1);
            }
            kernStaff = new KernStaff("*staff1", 1);
        }
        KernHeader kernHeader = new KernHeader(header);
        kernDocument.addHeader(kernHeader);
        lastToken = kernHeader;

        //TODO Part
        if (addPart) {
            kernDocument.add(lastToken, kernPart);
            lastToken = kernPart;
        }

        kernDocument.add(lastToken, kernStaff);
        lastToken = kernStaff;

        IMeasure lastMeasure = null;
        while (next != null && next.length > 0) {
            if (next.length > 1) {
                throw new IMException("Unsupported several spines, found " + next.length);
            }

            IMooObject mooObject = next[0].getContent();

            if (!(mooObject instanceof IExporterVisitable)) {
                throw new IMException("TO-DO Must be an exportable visitable: " + next[0].getContent().getClass());
            }

            if (mooObject instanceof IMeasure) {
                if (lastMeasure != null) {
                    lastToken = export(lastMeasure, lastToken);
                }
                lastMeasure = (IMeasure) mooObject;
            } else if (mooObject instanceof IMeter) {
                lastMeter = (IMeter)mooObject;
                lastToken = export((IExporterVisitable) mooObject, lastToken);
            } else {
                lastToken = export((IExporterVisitable) mooObject, lastToken);
            }
            next = next[0].getNextNodes(stavesSubgraphs[0]);
        }
        if (lastMeasure != null) {
            lastToken = export(lastMeasure, lastToken);
        }
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

    private KernToken export(IExporterVisitable item, KernToken lastToken) throws IMException {
        KernExporterVisitorTokenParam kernExporterVisitorTokenParam = new KernExporterVisitorTokenParam(kernDocument, kernExporterContext, lastToken);
        kernExporterVisitorTokenParam.setLastMeter(lastMeter);
        item.export(this.exporterVisitor, kernExporterVisitorTokenParam);
        return kernExporterVisitorTokenParam.getLastToken();
    }
}
