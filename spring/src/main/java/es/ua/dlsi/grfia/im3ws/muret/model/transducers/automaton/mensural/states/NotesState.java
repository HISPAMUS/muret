package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.Accidentals;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.mensural.ligature.LigatureFactory;
import es.ua.dlsi.im3.core.score.mensural.meters.Perfection;
import es.ua.dlsi.im3.core.score.mensural.meters.TimeSignatureMensural;
import es.ua.dlsi.im3.core.score.mensural.meters.hispanic.TimeSignatureProporcionMayor;
import es.ua.dlsi.im3.core.score.mensural.meters.hispanic.TimeSignatureProporcionMenor;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureCommonTime;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureCutTime;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.*;

import java.util.ArrayList;
import java.util.Arrays;

// TODO: 5/10/17 Mirar si podemos compartir algo con modern
public class NotesState extends TransducerState {
    public NotesState(int number, String name) {
        super(number, "notes");
    }

    class FiguresColoration {
        Figures figure;
        Boolean colored;

        public FiguresColoration(Figures figure, Boolean colored) {
            this.figure = figure;
            this.colored = colored;
        }

        public Figures getFigure() {
            return figure;
        }

        public Boolean getColored() {
            return colored;
        }
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws ImportException {
        SemanticKeySignature keySignature = findLastKeySignature(transduction);
        SemanticTimeSignature timeSignature = findLastTimeSignature(transduction);

        Accidentals accidental = null;

        ArrayList<Long> agnosticIDs = new ArrayList<>();
        if (previousState instanceof AccNoteState) {
            AccNoteState prevState = (AccNoteState) previousState;
            accidental = prevState.getAccidental(); //Ojo, si en el mismo compas hay otra nota alterada no lo ve
            agnosticIDs.add(prevState.getAgnosticID());
        }

        agnosticIDs.add(token.getId());

        if (token.getSymbol() instanceof Note) {
            Note value = ((Note) token.getSymbol());
            try {
                boolean inTernaryRhythm = computeInTernaryRhythm(timeSignature);
                FiguresColoration figuresColoration = parseFigure(value.getDurationSpecification(), inTernaryRhythm);

                SemanticClef clef = findLastClef(transduction);

                ScientificPitch scientificPitch = parsePitch(clef, token.getPositionInStaff(), accidental);

                Accidentals keySignatureAccidental = null;
                if (keySignature != null) {
                    keySignatureAccidental = keySignature.getCoreSymbol().getAccidentalOf(scientificPitch.getPitchClass().getNoteName());
                }

                Accidentals visualAccidental = null;
                Accidentals actualAccidental = null;

                if (keySignatureAccidental != null) {
                    if (keySignatureAccidental == Accidentals.FLAT && scientificPitch.getPitchClass().getAccidental() == Accidentals.SHARP) {
                        actualAccidental = Accidentals.NATURAL;
                        visualAccidental = Accidentals.SHARP;
                    } else {
                        if (scientificPitch.getPitchClass().getAccidental() == null) {
                            actualAccidental = keySignatureAccidental;
                            visualAccidental = scientificPitch.getPitchClass().getAccidental();
                        } else {
                            actualAccidental = scientificPitch.getPitchClass().getAccidental();
                            visualAccidental =  scientificPitch.getPitchClass().getAccidental();;
                        }
                    }
                } else {
                    actualAccidental = scientificPitch.getPitchClass().getAccidental();
                    visualAccidental =  scientificPitch.getPitchClass().getAccidental();;
                }

                scientificPitch.getPitchClass().setAccidental(actualAccidental);

                //TODO fermata ...
                SemanticNote note = new SemanticNote(false, scientificPitch, visualAccidental, figuresColoration.getFigure(), 0, false, false, null, figuresColoration.getColored());

                if (value != null && value.getStemDirection() != null && token.getPositionInStaff().equals(PositionsInStaff.LINE_3)) {
                    switch (value.getStemDirection()) {
                        case up:
                            note.getCoreSymbol().setExplicitStemDirection(StemDirection.up);
                            break;
                        case down:
                            note.getCoreSymbol().setExplicitStemDirection(StemDirection.down);
                            break;
                    }
                }

                note.setAgnosticIDs(agnosticIDs);
                transduction.add(note);

            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }
        } else if (token.getSymbol() instanceof Rest) {
            //TODO si accidental no es nulo la alteración debe ir con alguien
            Rest value = ((Rest) token.getSymbol());

            Figures figures = convert(value.getRestFigures());

            //TODO fermata ...
            SemanticRest rest = new SemanticRest(figures, 0, false, null);
            rest.setLinePosition(token.getPositionInStaff().getLine());
            rest.setAgnosticIDs(agnosticIDs);
            transduction.add(rest);

        } else if (token.getSymbol() instanceof Dot) {
            SemanticSymbol lastSymbol = transduction.getLastSymbol();
            lastSymbol.getSymbol().addAgnosticID(token.getId());
            if (lastSymbol.getSymbol().getCoreSymbol() instanceof SingleFigureAtom) {
                SingleFigureAtom sfa = (SingleFigureAtom) lastSymbol.getSymbol().getCoreSymbol();
                sfa.getAtomFigure().addDot(); // TODO podría ser de puntillo de división
            } else {
                throw new ImportException("Last symbol should be a single figure atom"); // TODO y los acordes
            }
        } else if (token.getSymbol() instanceof Ligature) {
            //TODO Currently we always add the same kind of ligature
            SimpleNote simpleNote1 = new SimpleNote(Figures.SEMIBREVE, 0, new ScientificPitch(PitchClasses.A, 2));
            SimpleNote simpleNote2 = new SimpleNote(Figures.SEMIBREVE, 0, new ScientificPitch(PitchClasses.B, 2));
            es.ua.dlsi.im3.core.score.Ligature ligature = null;
            try {
                ligature = LigatureFactory.createLigature(Arrays.asList(simpleNote1, simpleNote2), LigatureType.recta);
            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }
            SemanticLigature semanticLigature = new SemanticLigature(ligature);
            semanticLigature.setAgnosticIDs(agnosticIDs);
            transduction.add(semanticLigature);
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

    //TODO Mejor en IMCore
    // TODO añadir contexto (pentagrama anterior)
    private boolean computeInTernaryRhythm(SemanticTimeSignature semanticTimeSignature) throws ImportException {
        if (semanticTimeSignature == null) {
            System.err.println("TO-DO compás pentagrama anterior");
            return false;
        }
        TimeSignature ts = (TimeSignature) semanticTimeSignature.getCoreSymbol();
        if (ts instanceof TimeSignatureCommonTime || ts instanceof TimeSignatureCutTime) {
            return false;
        } else if (ts instanceof TimeSignatureProporcionMayor || ts instanceof TimeSignatureProporcionMenor) {
            return true;
        } else if (ts instanceof TimeSignatureMensural) {
            return ((TimeSignatureMensural)ts).getProlatio() == Perfection.perfectum;
        } else {
            throw new ImportException("Unsupported meter type:  " + ts.getClass());
        }
    }

    private SemanticTimeSignature findLastTimeSignature(SemanticTransduction transduction) {
        for (SemanticSymbol symbol: transduction.getSemanticEncoding().getSymbols()) {
            SemanticSymbolType symbolType = symbol.getSymbol();
            if (symbolType instanceof SemanticTimeSignature) {
                return (SemanticTimeSignature)symbol.getSymbol();
            }
        }
        return null;
    }

    static SemanticClef findLastClef(SemanticTransduction transduction) {
        for (SemanticSymbol symbol: transduction.getSemanticEncoding().getSymbols()) {
            SemanticSymbolType symbolType = symbol.getSymbol();
            if (symbolType instanceof SemanticClef) {
                return (SemanticClef)symbol.getSymbol();
            }
        }
        throw new IM3RuntimeException("Cannot find a clef");
    }

    static SemanticKeySignature findLastKeySignature(SemanticTransduction transduction) {
        for (SemanticSymbol symbol: transduction.getSemanticEncoding().getSymbols()) {
            SemanticSymbolType symbolType = symbol.getSymbol();
            if (symbolType instanceof SemanticKeySignature) {
                return (SemanticKeySignature)symbol.getSymbol();
            }
        }
        return null;
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
    private FiguresColoration convert(NoteFigures value, boolean ternaryRhythm) {
        switch (value) {
            case doubleWholeBlackStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case tripleWholeStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case doubleWholeStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case doubleWhole:
                return new FiguresColoration(Figures.MAXIMA, true);
            case quadrupleWholeStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case longa:
                return new FiguresColoration(Figures.LONGA, null);
            case breveBlack:
                return new FiguresColoration(Figures.BREVE, true);
            case breve:
                return new FiguresColoration(Figures.BREVE, false);
            case whole:
                return new FiguresColoration(Figures.SEMIBREVE, false);
            case wholeBlack:
                return new FiguresColoration(Figures.SEMIBREVE, true);
            case half:
                if (ternaryRhythm) {
                    return new FiguresColoration(Figures.SEMIMINIM, true);
                } else {
                    return new FiguresColoration(Figures.MINIM, null);
                }
            case quarter:
                if (ternaryRhythm) {
                    return new FiguresColoration(Figures.MINIM, true);
                } else {
                    return new FiguresColoration(Figures.SEMIMINIM, null);
                }
            case eighthVoid:
                return new FiguresColoration(Figures.SEMIMINIM, null);
            case eighth:
                return new FiguresColoration(Figures.FUSA, null);
            case eighthCut:
                return new FiguresColoration(Figures.SEMIFUSA, null);
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }

    static ScientificPitch parsePitch(SemanticClef clef, PositionInStaff positionInStaff, Accidentals accidental) throws IM3Exception {
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

    private FiguresColoration parseFigure(INoteDurationSpecification durationSpecification, boolean inTernaryRhythm) throws IM3Exception {
        if (durationSpecification instanceof Beam) {
            Beam beam = (Beam) durationSpecification;
            return new FiguresColoration(Figures.findFigureWithFlags(beam.getBeams(), NotationType.eMensural), null);
        } else if (durationSpecification instanceof NoteFigures) {
            NoteFigures noteFigures = (NoteFigures) durationSpecification;
            return convert(noteFigures, inTernaryRhythm);
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

