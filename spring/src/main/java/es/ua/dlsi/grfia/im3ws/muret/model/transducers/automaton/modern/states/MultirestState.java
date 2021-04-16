package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonTimeSignatureState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.Time;
import es.ua.dlsi.im3.core.score.TimeSignature;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Digit;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Multirest;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticMultirest;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticTimeSignature;

import java.util.ArrayList;
import java.util.List;

public class MultirestState extends TransducerState {
    Multirest multirest;
    List<Digit> digits;
    List<Long> agnosticIDs;

    public MultirestState(int number) {
        super(number, "multirest");
        this.agnosticIDs = new ArrayList<>();
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws IM3Exception {
        super.onEnter(token, previousState, transduction);
        agnosticIDs.add(token.getId());
        if (token.getSymbol() instanceof Multirest) {
            this.multirest = (Multirest) token.getSymbol();
        } else if (token.getSymbol() instanceof Digit) {
            if (digits == null) {
                digits = new ArrayList<>();
            }
            digits.add((Digit) token.getSymbol());
        }
    }

    @Override
    public void onExit(State nextState, boolean isStateChange, SemanticTransduction transduction) throws IM3Exception {
        super.onExit(nextState, isStateChange, transduction);
        if (isStateChange) {
            if (multirest == null) {
                throw new IM3Exception("Missing multirest symbol in multirest state");
            }

            int n = 0;
            if (digits != null && digits.size() > 0) {
                for (Digit digit: digits) {
                    n *= 10;
                    n += digit.getDigit();
                }
            } else {
                n = 1;
            }

            //Get the last key signature
            List<SemanticSymbol> symbols = transduction.getSemanticEncoding().getSymbols();
            TimeSignature lastTimeSignature = null;
            for (int i=symbols.size()-1; lastTimeSignature == null && i>=0; i--) {
                if (symbols.get(i).getSymbol() instanceof SemanticTimeSignature) {
                    lastTimeSignature = (TimeSignature) ((SemanticTimeSignature)symbols.get(i).getSymbol()).getCoreSymbol();
                }
            }
            if (lastTimeSignature == null) {
                throw new IM3Exception("Cannot find last time signature");
            }
            SemanticMultirest semanticMultirest = new SemanticMultirest(lastTimeSignature.getDuration(), n);
            semanticMultirest.setAgnosticIDs(agnosticIDs);
            transduction.add(semanticMultirest);
        }
    }
}
