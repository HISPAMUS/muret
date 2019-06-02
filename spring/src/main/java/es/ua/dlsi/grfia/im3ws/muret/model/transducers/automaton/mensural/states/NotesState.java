package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.Accidentals;
import es.ua.dlsi.im3.core.score.Clef;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Custos;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticClef;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticNote;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticRest;
import es.ua.dlsi.im3.omr.language.mensural.states.AccNoteState;

// TODO: 5/10/17 Mirar si podemos compartir algo con modern 
public class NotesState extends TransducerState {
    public NotesState(int number, String name) {
        super(number, "notes");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws ImportException {
        System.err.println("TO-DO Alteraciones anteriores y armadura en NotesState");

        Accidentals accidental = null;
        if (previousState instanceof AccNoteState) {
            accidental = ((AccNoteState)previousState).getAccidental(); //Ojo, si en el mismo compas hay otra nota alterada no lo ve
        }

        if (token.getSymbol() instanceof Note) {
            Note value = ((Note) token.getSymbol());
            try {
                Figures figures = parseFigure(value.getDurationSpecification());

                SemanticClef clef = findLastClef(transduction);

                ScientificPitch scientificPitch = parsePitch(clef, token.getPositionInStaff(), accidental);

                //TODO fermata ...
                SemanticNote note = new SemanticNote(false, scientificPitch, figures, 0, false, false, null);
                transduction.add(note);

            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }
        } else if (token.getSymbol() instanceof Custos) {
            //TODO código repetido con nota
            //TODO no está aún en semantic encoding
        } else if (token.getSymbol() instanceof Rest) {
            //TODO si accidental no es nulo la alteración debe ir con alguien
            Rest value = ((Rest) token.getSymbol());
            Figures figures = convert(value.getRestFigures());

            //TODO fermata ...
            SemanticRest rest = new SemanticRest(figures, 0, false, null);
            transduction.add(rest);

        } else if (token.getSymbol() instanceof Dot) {
            SemanticSymbol lastSymbol = transduction.getLastSymbol();
            if (lastSymbol.getSymbol().getCoreSymbol() instanceof SingleFigureAtom) {
                SingleFigureAtom sfa = (SingleFigureAtom) lastSymbol.getSymbol().getCoreSymbol();
                sfa.getAtomFigure().addDot(); // TODO podría ser de puntillo de división
            } else {
                throw new ImportException("Last symbol should be a single figure atom"); // TODO y los acordes
            }
        } else if (token.getSymbol() instanceof Ligature) {
            // TODO We don't treat them yet
        } else {
            throw new IM3RuntimeException("Invalid token: " + token);
        }
        /*ScientificPitch pitch = null;
        if (token.getSymbol() instanceof Note ||token.getSymbol() instanceof Custos) { //TODO Mejor añadir un interface (IPitched)
            // TODO: 5/10/17 Chords
            Clef clef = transduction.getStaff().getLastClef();
            if (clef == null) {
                throw new IM3RuntimeException("No clef found to determine pitch");
            }
            try {
                pitch = parsePitch(staff, clef, token.getPositionInStaff(), accidental);
            } catch (IM3Exception e) {
                transduction.setZeroProbability();
                return;
            }
        }
        if (token.getSymbol() instanceof Note) {
            try {
                Note value = ((Note) token.getSymbol());
                SimpleNote note = new SimpleNote(parseFigure(value.getDurationSpecification()), 0, pitch);
                transduction.getStaff().addCoreSymbol(note);
                transduction.getLayer().add(note);
            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }

        } else {
            throw new IM3RuntimeException("Symbol should be note");
        } else if (token.getSymbol() instanceof Rest) {
            try {
                Rest value = ((Rest) token.getSymbol());
                Figures figures = convert(value.getRestFigures());
                SimpleRest rest = new SimpleRest(figures, 0);
                transduction.getStaff().addCoreSymbol(rest);
                transduction.getLayer().add(rest);
            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }

        } else if (token.getSymbol() instanceof Dot) {
            try {
                Atom lastAtom = transduction.getLayer().getLastAtom();
                if (lastAtom instanceof SingleFigureAtom) {
                    ((SingleFigureAtom)lastAtom).getAtomFigure().addDot();
                } else {
                    transduction.setProbability(new BigFraction(0));
                }
            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }
        } else if (token.getSymbol() instanceof Custos) {
            es.ua.dlsi.im3.core.score.Custos custos = new es.ua.dlsi.im3.core.score.Custos(transduction.getStaff(), transduction.getLayer().getDuration(), pitch.getPitchClass().getNoteName(), pitch.getOctave());
            transduction.getStaff().addCustos(custos);
        } else {
            throw new IM3RuntimeException("Symbol should be note or dot");
        }*/
    }

    SemanticClef findLastClef(SemanticTransduction transduction) {
        for (SemanticSymbol symbol: transduction.getSemanticEncoding().getSymbols()) {
            SemanticSymbolType symbolType = symbol.getSymbol();
            if (symbolType instanceof SemanticClef) {
                return (SemanticClef)symbol.getSymbol();
            }
        }
        throw new IM3RuntimeException("Cannot find a clef");
    }

    //TODO Esto es solo para compases binarios
    private Figures convert(RestFigures value) {
        switch (value) {
            case fusa:
            case eighth:
                return Figures.FUSA;
            case breve:
                return Figures.BREVE;
            case half:
                return Figures.MINIM;
            case longa2:
                return Figures.LONGA;
            case quarter:
            case seminima:
                return Figures.SEMIMINIM;
            case whole:
                return Figures.SEMIBREVE;
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }

    //TODO Esto es solo para compases binarios
    private Figures convert(NoteFigures value) {
        switch (value) {
            case breveBlack:
            case breve:
                return Figures.BREVE;
            case eighth:
            case eighthCut:
                return Figures.FUSA;
            case half:
                return Figures.MINIM;
            case longa:
                return Figures.LONGA;
            case eighthVoid:
            case quarter:
                return Figures.SEMIMINIM;
            case whole:
            case wholeBlack:
                return Figures.SEMIBREVE;
            case tripleWholeStem:
            case doubleWholeStem:
            case doubleWholeBlackStem:
            case doubleWhole:
            case quadrupleWholeStem:
                return Figures.MAXIMA;
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }

    private ScientificPitch parsePitch(SemanticClef clef, PositionInStaff positionInStaff, Accidentals accidental) throws IM3Exception {
        try {
            ScientificPitch sp = Staff.computeScientificPitch(clef.getCoreSymbol(), positionInStaff);
            if (accidental != null) {
                sp.getPitchClass().setAccidental(accidental);
            }
            return sp;
        } catch (Throwable t) {
            t.printStackTrace();
            throw new IM3Exception("Cannot parse pitch for " + clef.toKernSemanticString() + ", position " + positionInStaff + ", accidental " + accidental);
        }
    }

    private Figures parseFigure(INoteDurationSpecification durationSpecification) throws IM3Exception {
        if (durationSpecification instanceof Beam) {
            Beam beam = (Beam) durationSpecification;
            return Figures.findFigureWithFlags(beam.getBeams(), NotationType.eMensural);
        } else if (durationSpecification instanceof NoteFigures) {
            NoteFigures noteFigures = (NoteFigures) durationSpecification;
            return convert(noteFigures);
        } else {
            throw new IM3Exception("Unsupported durationSpecification: " + durationSpecification);
        }

        /*String upperCaseValue = value.toUpperCase();
        if (upperCaseValue.startsWith(BEAMED)) { // it is a beam
            String beams = value.substring(value.length()-1); // we'll not have more than 9 beams
            int nbeams;
            try {
                nbeams = Integer.parseInt(beams);
            } catch (Throwable t) {
                throw new IM3RuntimeException("Invalid beam number: '" + beams + "' for value " + value);
            }
            return Figures.findFigureWithFlags(nbeams, NotationType.eModern);
        } else { // it is a figure
            return Figures.valueOf(upperCaseValue);
        }*/
    }
}

