package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;

import java.util.Objects;

public class FermataState extends TransducerState {
    private Long agnosticID;
    private static final String FERMATE = "fermate";

    public FermataState(int number) {
        super(number, "fermata");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws IM3Exception {
        agnosticID = token.getId();
        transduction.getPayload().setProperty(FERMATE, FERMATE);
    }

    public static boolean isPendingFermata(SemanticTransduction transduction, boolean resetIt) {
        boolean result = false;
        String value = transduction.getPayload().getProperty(FERMATE);
        if (Objects.equals(value, FERMATE)) {
            result = true;

            if (resetIt) {
                transduction.getPayload().remove(FERMATE);
            }
        }
        return result;
    }

    public Long getAgnosticID() {
        return agnosticID;
    }
}
