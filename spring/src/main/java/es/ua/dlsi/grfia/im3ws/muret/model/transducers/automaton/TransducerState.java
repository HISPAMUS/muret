package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;

public class TransducerState extends State<AgnosticSymbolType, AgnosticSymbol, SemanticTransduction> {
    public TransducerState(int number, String name) {
        super(number, name);
    }
}
