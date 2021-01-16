package es.ua.dlsi.grfia.moosicae.io.kern.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.IBeamGroupBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.prototypes.PrototypesAbstractBuilder;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.*;
import es.ua.dlsi.grfia.moosicae.utils.dag.DAGNode;

import java.util.*;

/**
 * It converts the KernDocument obtained when parsing to an IScore object
 * The KernDocument contains spines in the form of a directed acyclic graph with KernTokens. A KernToken can be a part definition, a staff definition, a clef.
 * a note, or any spine operation, including the beginning of a spine. See the convert method documentation.
 * Beam groups are expanded in spines, i.e., they are encoded in the graph using a "begin group" note, regular notes, and a "end group" note.
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernDocument2IScore {
    private final IScore score;
    private final HashMap<Integer, IPart> partNumbers;
    private final HashMap<Integer, IStaff> staffNumbers;
    private final HashMap<IId, IPart> voiceParts;
    private final HashMap<IId, IStaff> voiceStaves;
    private IPart defaultPart;
    private ArrayList<IStaff> staves;
    private IBeamGroupBuilder currentBeamGroupBuilder; // for creating a beam group

    public KernDocument2IScore() {
        this.score = ICoreAbstractFactory.getInstance().createScore(null);
        this.partNumbers = new HashMap<>();
        this.voiceParts = new HashMap<>();
        this.staffNumbers = new HashMap<>();
        this.voiceStaves = new HashMap<>();
        this.currentBeamGroupBuilder = null;
    }

    /**
     * It traverses the directed acyclic graph and takes decisions on the visit method for each token found.
     * The traversal is depth-first, so the sequence of notes in each voice is followed.
     * partNumbers is used as a map to known which part belongs each part number belongs to. Note that several spines may have the same part number header
     * staffNumbers is used as a map to known which staff belongs each staff number belongs to. Note that several spines may have the same staff number header
     * @param firstNode
     * @return
     * @throws IMException
     */
    public IScore convert(DAGNode<KernToken> firstNode) throws IMException {
        defaultPart = ICoreAbstractFactory.getInstance().createPart(score, null, null);

        staves = new ArrayList<>();
        // first create voices, all associated to a default part that will be moved to other part when the **part token is found
        for (DAGNode<KernToken> node: firstNode.getNextList()) {
            KernToken kernToken = node.getLabel().getContent();
            if (kernToken instanceof KernHeader) {
                EKernHeaders headerType = ((KernHeader) kernToken).getSkmHeaderType();
                if (headerType == EKernHeaders.kern || headerType == EKernHeaders.mens) { //TODO tambuén smens y skern ??? - o emens / ekern
                    // Create the voice for this spine - it may be moved to another part when the *part signifier is found
                    IVoice voice = ICoreAbstractFactory.getInstance().createVoice(defaultPart, null, null);
                    voiceParts.put(voice.getId(), defaultPart);

                    //TODO staves - cuando se encuentre con *staff1 o *staff1/2
                    // don't insert the staff yet into the score yet because their order must be reversed
                    IStaff defaultVoiceStaff = ICoreAbstractFactory.getInstance().createStaff(null, ICoreAbstractFactory.getInstance().createStaffLineCount(5), null);
                    staves.add(0, defaultVoiceStaff); // insert from the beginning
                    voiceStaves.put(voice.getId(), defaultVoiceStaff);
                    // now traverse the spine
                    for (DAGNode<KernToken> next: node.getNextList()) {
                        visit(voice, next);
                    }
                    
                } // else TODO harm, text...
            } else {
                throw new IMException("The first nodes after the start node should be header ones, and there is a " + kernToken.getEncoding());
            }
        }

        // remove unused default part and staves
        if (defaultPart.getVoices().length == 0) {
            score.remove(defaultPart);
        }

        for (IStaff staff: staves) {
            score.add(staff);
        }
        return score;
    }

    private void visit(IVoice voice, DAGNode<KernToken> node) throws IMException {
        process(voice, node.getLabel().getContent());
        for (DAGNode<KernToken> next: node.getNextList()) {
            visit(voice, next);
        }
    }

    private void process(IVoice voice, KernToken kernToken) throws IMException {
        if (kernToken instanceof KernPart) {
            KernPart kernPart = (KernPart) kernToken;
            processPart(voice, kernPart);
        } else if (kernToken instanceof KernInstrument) {
            KernInstrument kernInstrument = (KernInstrument) kernToken;
            IPart part = voiceParts.get(voice.getId());
            if (part == null) {
                throw new IMException("Cannot find a part for voice " + voice.getId()); //TODO ¿Podríamos tener una *I sin una *Part --> creamos una part
            }
            part.setName(kernInstrument.getName());

        } else if (kernToken instanceof KernStaff) {
            KernStaff kernStaff = (KernStaff) kernToken;
            processStaff(voice, kernStaff);
        } else if (kernToken instanceof KernCoreSymbol) {
            KernCoreSymbol kernCoreSymbol = (KernCoreSymbol) kernToken;
            processCoreSymbol(voice, kernCoreSymbol);
        } // TODO spine operations
    }

    private void processCoreSymbol(IVoice voice, KernCoreSymbol kernCoreSymbol) throws IMException {
        IStaff voiceStaff = voiceStaves.get(voice.getId());
        IMooObject symbol = kernCoreSymbol.getSymbol();

        if (symbol instanceof IVoiced) {
            if (symbol instanceof IUnconventionalKeySignature) {
                // if it is a conventional or theoretical key, we take its key signature
                IUnconventionalKeySignature uks = (IUnconventionalKeySignature) kernCoreSymbol.getSymbol();
                Optional<IKeySignature> ks = PrototypesAbstractBuilder.getInstance().getKeys().findExistingKeySignature(uks.getPitchClasses());
                if (ks.isPresent()) {
                    symbol = ks.get();
                }  // else use the unconventionalKeySignature
            } else if (kernCoreSymbol instanceof KernBeamedNote) {
                KernBeamedNote beamedNote = (KernBeamedNote) kernCoreSymbol;
                if (beamedNote.getCount() != 1) {
                    //TODO Non lazy beaming
                    throw new IMException("Unsupported non lazy beaming, with explicit beam count = " + beamedNote.getCount());
                }
                switch (beamedNote.getBeamType()) {
                    case beamStart:
                        if (currentBeamGroupBuilder != null) {
                            throw new UnsupportedOperationException("Unsupported nested beams"); //TODO nested beams
                        }
                        currentBeamGroupBuilder = new IBeamGroupBuilder();
                        break;
                    case beamEnd:
                        currentBeamGroupBuilder.add((IDurational) symbol);
                        symbol = currentBeamGroupBuilder.build();
                        currentBeamGroupBuilder = null;
                        break;
                    default:
                        throw new IMException("Unsupported partial beams: " + beamedNote.getBeamType());
                }
            }

            if (symbol instanceof IDurational && currentBeamGroupBuilder != null) {
                currentBeamGroupBuilder.add((IDurational) symbol);
            } else {
                voice.addItem((IVoiced) symbol);
                if (voiceStaff != null) {
                    voiceStaff.put((IVoicedItem) symbol);
                }
            }
        }
    }

    private void processStaff(IVoice voice, KernStaff kernStaff) throws IMException {
        IStaff defaultStaff = voiceStaves.get(voice.getId());
        if (defaultStaff == null) {
            throw new RuntimeException("There should exist a default staff created for voice " + voice); // see the beginning of convert method
        }
        IStaff existingStaffWithNumber = staffNumbers.get(kernStaff.getNumber());
        // if there was a defined staff with the given number, remove the default staff and substitute that one
        if (existingStaffWithNumber != null) {
            voiceStaves.put(voice.getId(), existingStaffWithNumber);
            if (!defaultStaff.isEmpty()) {
                throw new IMException("Cannot remove the default staff because it already contains " + defaultStaff.getStaffSymbols().length + " elements");
            }
            staves.remove(defaultStaff);
        } else {
            // assign the staff number to the default one
            staffNumbers.put(kernStaff.getNumber(), defaultStaff);
        }
    }

    private void processPart(IVoice voice, KernPart kernPart) {
        IPart part = partNumbers.get(kernPart.getNumber());

        if (part == null) {
            part = ICoreAbstractFactory.getInstance().createPart(score, null, null);
            partNumbers.put(kernPart.getNumber(), part);
        }

        // move the voice (already inserted to a default part) to this one
        score.moveVoice(voice, defaultPart, part);
        voiceParts.put(voice.getId(), part);
    }
}
