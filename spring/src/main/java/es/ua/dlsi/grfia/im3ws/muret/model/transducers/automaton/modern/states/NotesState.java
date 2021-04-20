package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonNotesState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.score.Figures;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.NoteFigures;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.RestFigures;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticKeySignature;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticTimeSignature;


// TODO: 5/10/17 Mirar si podemos compartir algo con modern
public class NotesState extends CommonNotesState {

    public NotesState(int number) {
        super(number, NotationType.eModern);
    }

    @Override
    protected void postProcessContext(SemanticKeySignature semanticKeySignature, SemanticTimeSignature semanticTimeSignature) throws IM3Exception {
    }

    //TODO Esto es solo para compases binarios
    protected FiguresColoration convert(NoteFigures value) {
        switch (value) {
            case whole:
                return new FiguresColoration(Figures.WHOLE, null);
            case half:
                return new FiguresColoration(Figures.HALF, null);
            case quarter:
                return new FiguresColoration(Figures.QUARTER, null);
            case eighth:
                return new FiguresColoration(Figures.EIGHTH, null);
            case sixteenth:
                return new FiguresColoration(Figures.SIXTEENTH, null);
            case thirtySecond:
                return new FiguresColoration(Figures.THIRTY_SECOND, null);
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }


    protected Figures convert(RestFigures value) {
        switch (value) {
            case whole:
                return Figures.WHOLE;
            case half:
                return Figures.HALF;
            case quarter:
                return Figures.QUARTER;
            case eighth:
                return Figures.EIGHTH;
            case sixteenth:
                return Figures.SIXTEENTH;
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }



}

