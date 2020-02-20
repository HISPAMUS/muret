package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.BarlineType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticBarline;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticNote;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticRest;

public class BarLineState extends TransducerState {
    public BarLineState(int number) {
        super(number, "barline");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction)  {
        if (previousState instanceof BarLineState) {
            SemanticBarline semanticBarline = (SemanticBarline) transduction.getLastSymbol().getSymbol();
            semanticBarline.getCoreSymbol().setBarlineType(BarlineType.ending);
            semanticBarline.addAgnosticID(token.getId());
        } else {
            SemanticBarline semanticBarline = new SemanticBarline();
            semanticBarline.addAgnosticID(token.getId());
            transduction.add(semanticBarline);
        }

        if (FermataState.isPendingFermata(transduction, false)) {
            if (transduction.getLastSymbol().getSymbol() instanceof SemanticNote) {
                ((SemanticNote)transduction.getLastSymbol().getSymbol()).setFermata(true);
                FermataState.isPendingFermata(transduction, true);
            } else if (transduction.getLastSymbol().getSymbol() instanceof SemanticRest) {
                ((SemanticRest)transduction.getLastSymbol().getSymbol()).setFermata(true);
                FermataState.isPendingFermata(transduction, true);
            }
        }

        // TODO: 5/10/17 Tipo de barra?
        /*
        Time time = Time.TIME_ZERO;
        if (transduction.getSong().getNumMeasures() > 0) {
            try {
                time = transduction.getSong().getLastMeasure().getEndTime();
            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }
        }
        if (transduction.getSong().getMeasureWithOnset(time) == null) {
            Measure measure = new Measure(transduction.getSong());
            try {
                transduction.getSong().addMeasure(time, measure);
                measure.setEndTime(transduction.getLayer().getDuration());

                // TODO: 5/10/17 Comprobar que el endtime coincide con la duración esperada del compás
                TimeSignature lastTimeSignature = transduction.getStaff().getLastTimeSignature();
                if (lastTimeSignature.getDuration().equals(measure.getDuration())) {
                    System.err.println("TO-DO Bajar probabilidad porque la duración del compás: " +
                            measure.getDuration() + " es distinta a la del time signature: " +
                            lastTimeSignature + " --> " + lastTimeSignature.getDuration()
                    );
                }

            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }
        }*/
    }
}
