package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.*;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAGNode;

import java.util.HashMap;

/**
 * It converts the KernDocument obtained when parsing to an IScore object
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmDocument2IScore {
    private final IScore score;
    private final HashMap<Integer, IPart> partNumbers;
    private final HashMap<Integer, IStaff> staffNumbers;
    private final HashMap<IVoice, IPart> voiceParts;
    private final HashMap<IVoice, IStaff> voiceStaves;
    private IPart defaultPart;
    private IStaff defaultStaff;

    public SkmDocument2IScore() {
        this.score = ICoreAbstractFactory.getInstance().createScore(null);
        this.partNumbers = new HashMap<>();
        this.voiceParts = new HashMap<>();
        this.staffNumbers = new HashMap<>();
        this.voiceStaves = new HashMap<>();
    }


    public IScore convert(DAGNode<SkmToken> firstNode) throws IMException {
        defaultPart = ICoreAbstractFactory.getInstance().createPart(score, null, null);
        IStaffLineCount defaultStaffLineCount = ICoreAbstractFactory.getInstance().createStaffLineCount(5);
        defaultStaff = ICoreAbstractFactory.getInstance().createStaff(score, null, defaultStaffLineCount, null);

        // first create voices, all associated to a default part that will be moved to other part when the **part token is found
        for (DAGNode<SkmToken> node: firstNode.getNextList()) {
            SkmToken skmToken = node.getLabel().getContent();
            if (skmToken instanceof SkmHeader) {
                ESkmHeaders headerType = ((SkmHeader) skmToken).getSkmHeaderType();
                if (headerType == ESkmHeaders.skern || headerType == ESkmHeaders.smens) {
                    IVoice voice = ICoreAbstractFactory.getInstance().createVoice(defaultPart, null, null);
                    voiceParts.put(voice, defaultPart);
                    //TODO staves - cuando se encuentre con *staff1 o *staff1/2
                    IStaff defaultStaff = ICoreAbstractFactory.getInstance().createStaff(score, null, defaultStaffLineCount, null);
                    voiceStaves.put(voice, defaultStaff);
                    // now traverse the spine
                    for (DAGNode<SkmToken> next: node.getNextList()) {
                        visit(voice, next);
                    }
                    
                } // else TODO harm, text...
            } else {
                throw new IMException("The first nodes after the start node should be header ones, and there is a " + skmToken.getEncoding());
            }
        }

        // remove unused default part and staves
        if (defaultPart.getVoices().length == 0) {
            score.remove(defaultPart);
        }
        //TODO
        /*if (defaultStaff.getStaffSymbols().length == 0) {
            score.remove(defaultStaff);
        }*/
        return score;
    }

    private void visit(IVoice voice, DAGNode<SkmToken> node) throws IMException {
        process(voice, node.getLabel().getContent());
        for (DAGNode<SkmToken> next: node.getNextList()) {
            visit(voice, next);
        }
    }

    private void process(IVoice voice, SkmToken skmToken) throws IMException {
        if (skmToken instanceof SkmPart) {
            SkmPart skmPart = (SkmPart) skmToken;
            processPart(voice, skmPart);
        } else if (skmToken instanceof SkmStaff) {
            SkmStaff skmStaff = (SkmStaff) skmToken;
            processStaff(voice, skmStaff);
        } else if (skmToken instanceof SkmCoreSymbol ){
            SkmCoreSymbol skmCoreSymbol = (SkmCoreSymbol) skmToken;
            processCoreSymbol(voice, skmCoreSymbol);
        } // TODO spine operations
    }

    private void processCoreSymbol(IVoice voice, SkmCoreSymbol skmCoreSymbol) throws IMException {
        IStaff voiceStaff = voiceStaves.get(voice);
        if (skmCoreSymbol.getSymbol() instanceof IVoiced) {
            voice.addChild((IVoiced) skmCoreSymbol.getSymbol());
            if (voiceStaff != null) {
                voiceStaff.put((IVoicedSingle) skmCoreSymbol.getSymbol());
            }
        }
    }

    private void processStaff(IVoice voice, SkmStaff skmStaff) {
        IStaff staff = staffNumbers.get(skmStaff.getNumber());

        if (staff == null) {
            staff = ICoreAbstractFactory.getInstance().createStaff(score, null, ICoreAbstractFactory.getInstance().createStaffLineCount(5), null);
            staffNumbers.put(skmStaff.getNumber(), staff);
        }

        voiceStaves.put(voice, staff);
    }

    private void processPart(IVoice voice, SkmPart skmPart) {
        IPart part = partNumbers.get(skmPart.getNumber());

        if (part == null) {
            part = ICoreAbstractFactory.getInstance().createPart(score, null, null);
            partNumbers.put(skmPart.getNumber(), part);
        }

        // move the voice (already inserted to a default part) to this one
        score.moveVoice(voice, defaultPart, part);
        voiceParts.put(voice, part);
    }
}
