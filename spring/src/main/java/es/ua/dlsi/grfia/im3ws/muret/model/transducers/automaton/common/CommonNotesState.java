package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states.AccNoteState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.Accidentals;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.mensural.ligature.LigatureFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.*;

import java.util.ArrayList;
import java.util.Arrays;

// TODO: 5/10/17 Mirar si podemos compartir algo con modern
public abstract class CommonNotesState extends TransducerState {
    private final NotationType notationType;

    public CommonNotesState(int number, NotationType notationType) {
        super(number, "notes");
        this.notationType = notationType;
    }

    public class FiguresColoration {
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
    
    protected abstract void postProcessContext(SemanticKeySignature semanticKeySignature, SemanticTimeSignature semanticTimeSignature) throws IM3Exception;

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws IM3Exception {
        SemanticKeySignature currentKeySignature = findLastKeySignature(transduction);
        SemanticTimeSignature currentTimeSignature = findLastTimeSignature(transduction);

        this.postProcessContext(currentKeySignature, currentTimeSignature);

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
                FiguresColoration figuresColoration = parseFigure(value.getDurationSpecification());

                SemanticClef clef = findLastClef(transduction);

                ScientificPitch scientificPitch = parsePitch(clef, token.getPositionInStaff(), accidental);

                Accidentals keySignatureAccidental = null;
                if (currentKeySignature != null) {
                    keySignatureAccidental = currentKeySignature.getCoreSymbol().getAccidentalOf(scientificPitch.getPitchClass().getNoteName());
                }

                Accidentals visualAccidental = null;
                Accidentals actualAccidental = null;

                if (keySignatureAccidental != null) {
                    if (keySignatureAccidental == Accidentals.FLAT && scientificPitch.getPitchClass().getAccidental() == Accidentals.SHARP) {
                        actualAccidental = Accidentals.NATURAL;
                        visualAccidental = Accidentals.SHARP;
                    } else {

                        if (!scientificPitch.getPitchClass().isAltered()) {
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


    private SemanticTimeSignature findLastTimeSignature(SemanticTransduction transduction) {
        for (SemanticSymbol symbol: transduction.getSemanticEncoding().getSymbols()) {
            SemanticSymbolType symbolType = symbol.getSymbol();
            if (symbolType instanceof SemanticTimeSignature) {
                return (SemanticTimeSignature)symbol.getSymbol();
            }
        }
        return null;
    }

    public static SemanticClef findLastClef(SemanticTransduction transduction) {
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

    protected abstract Figures convert(RestFigures value);
    protected abstract FiguresColoration convert(NoteFigures value);


    public static ScientificPitch parsePitch(SemanticClef clef, PositionInStaff positionInStaff, Accidentals accidental) throws IM3Exception {
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

    private FiguresColoration parseFigure(INoteDurationSpecification durationSpecification) throws IM3Exception {
        if (durationSpecification instanceof Beam) {
            Beam beam = (Beam) durationSpecification;
            return new FiguresColoration(Figures.findFigureWithFlags(beam.getBeams(), notationType), null);
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

