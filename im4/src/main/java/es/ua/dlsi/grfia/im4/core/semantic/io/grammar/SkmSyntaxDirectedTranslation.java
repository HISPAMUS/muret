package es.ua.dlsi.grfia.im4.core.semantic.io.grammar;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.io.antlr4.ANTLRUtils;
import es.ua.dlsi.grfia.im4.core.io.antlr4.ErrorListener;
import es.ua.dlsi.grfia.im4.core.io.antlr4.GrammarParseRuntimeException;
import es.ua.dlsi.grfia.im4.core.io.antlr4.ParseError;
import es.ua.dlsi.grfia.im4.core.semantic.*;
import es.ua.dlsi.grfia.im4.core.semantic.barlines.BarlineFactory;
import es.ua.dlsi.grfia.im4.core.semantic.clefs.*;
import es.ua.dlsi.grfia.im4.core.semantic.headers.HeaderFactory;
import es.ua.dlsi.grfia.im4.core.semantic.keys.KeyFactory;
import es.ua.dlsi.grfia.im4.core.semantic.meters.Meter;
import es.ua.dlsi.grfia.im4.core.semantic.meters.MeterFactory;
import es.ua.dlsi.grfia.im4.core.semantic.timesignatures.TimeSignatureFactory;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO Documentar por qué usamos a veces enum y otras objetos - básicamente usaremos enums cuando los elementos sean
// para siempre los mismos (p.ej. nombres de notas)
/**
 * It translates from **skm to a semantic composition using a syntax driven translation technique
 * @author drizo
 */
public class SkmSyntaxDirectedTranslation {
    private boolean debug;

    public static class Loader extends skmParserBaseListener {
        private boolean debug;
        private final Parser parser;
        private SemanticComposition semanticComposition;
        private int spineIndex;
        private int row;
        /**
         * This array should maintain the spine count including spine splits, joins, etc...
         */
        private ArrayList<SemanticItem> lastSpineInsertedItem;
        private ArrayList<PitchClass> keySignaturePitchClasses;

        private Figures lastFigure;
        private Coloration lastColoured;
        private Perfection lastPerfection;
        private int lastAgumentationDots;
        private Fermata lastFermata;

        private int octaveModif;
        private String noteName;

        private StemDirection lastStemDirection;
        private Integer lastRestLinePosition;
        private ArrayList<Note> chordNotes;



        //NOT USED YET
        private NotationType notationType;
        private boolean lastHasSeparationDot;
        private ArrayList<Long> associatedIDS;


        public Loader(Parser parser, boolean debug) {
            this.debug = debug;
            this.parser = parser;
            this.semanticComposition = new SemanticComposition();
            this.row = 0;
            this.lastSpineInsertedItem = new ArrayList<>();
        }

        private void throwError(String message) throws GrammarParseRuntimeException {
            throw new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + message);
        }

        private SemanticItem getLastItemForCurrentSpine() {
            if (this.spineIndex >= this.lastSpineInsertedItem.size()) {
                throw new GrammarParseRuntimeException("The current spine index is " + this.spineIndex
                        + " and the lastSpineInsertedItem array has " + lastSpineInsertedItem.size() + " elements");
            }
            return this.lastSpineInsertedItem.get(this.spineIndex);
        }

        private void addItemToSpine(SemanticItem semanticItem) {
            SemanticItem previous = getLastItemForCurrentSpine();
            this.semanticComposition.add(previous, semanticItem);
            lastSpineInsertedItem.set(this.spineIndex, semanticItem);
        }

        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            super.enterEveryRule(ctx);
            if (debug) {
                System.out.println(ANTLRUtils.getRuleDescription(parser, ctx, "Enter"));
            }
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx) {
            super.enterEveryRule(ctx);
            if (debug) {
                System.out.print(ANTLRUtils.getRuleDescription(parser, ctx, "Exit"));
                System.out.println();
            }
        }


        @Override
        public void exitHeaderField(skmParser.HeaderFieldContext ctx) {
            super.exitHeaderField(ctx);

            try {
                HeaderItem headerItem = HeaderFactory.getInstance().create(ctx.getText());
                semanticComposition.addHeader(headerItem);
                lastSpineInsertedItem.add(headerItem);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }


        @Override
        public void exitPart(skmParser.PartContext ctx) {
            super.exitPart(ctx);

            int number = Integer.parseInt(ctx.number().getText());
            PartNumber partNumber = new PartNumber(number);
            addItemToSpine(partNumber);
        }


        @Override
        public void enterRecord(skmParser.RecordContext ctx) {
            super.enterRecord(ctx);
            this.spineIndex = 0;
        }

        @Override
        public void exitRecord(skmParser.RecordContext ctx) {
            super.exitRecord(ctx);
            this.row ++;
        }

        @Override
        public void exitField(skmParser.FieldContext ctx) {
            super.exitField(ctx);
            this.spineIndex ++;
        }

        @Override
        public void exitStaff(skmParser.StaffContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Staff {0}", ctx.getText());
            super.exitStaff(ctx);

            int number = Integer.parseInt(ctx.number().getText());
            StaffNumber staffNumber = new StaffNumber(number);
            addItemToSpine(staffNumber);
        }


        @Override
        public void exitClef(skmParser.ClefContext ctx) {
            super.exitClef(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef {0}", ctx.getText());

            Clef clef = null;
            try {
                clef = ClefFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
            addItemToSpine(clef);
        }

        @Override
        public void enterKeySignature(skmParser.KeySignatureContext ctx) {
            super.enterKeySignature(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Beginning a key",
                    ctx.getText());
            keySignaturePitchClasses = new ArrayList<>();
        }

        @Override
        public void exitKeySignatureNote(skmParser.KeySignatureNoteContext ctx) {
            super.exitKeySignatureNote(ctx);

            try {
                DiatonicPitch diatonicPitch = DiatonicPitch.noteFromName(ctx.getText().substring(0, 1));
                Accidentals accidentals;
                if (ctx.getText().length() == 1) {
                    accidentals = Accidentals.NATURAL;
                } else {
                    char acc = ctx.getText().charAt(1);
                    if (acc == '#') {
                        accidentals = Accidentals.SHARP;
                    } else if (acc == '-') {
                        accidentals = Accidentals.FLAT;
                    } else {
                        throw new GrammarParseRuntimeException("Invalid accidental for key signature: '" + acc + "'");
                    }
                }
                this.keySignaturePitchClasses.add(new PitchClass(diatonicPitch, accidentals));
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }

        @Override
        public void exitKeySignature(skmParser.KeySignatureContext ctx) {
            super.exitKeySignature(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Key signature {0}", ctx.getText());

            KeySignature keySignature = new KeySignature(this.keySignaturePitchClasses);
            addItemToSpine(keySignature);
            keySignaturePitchClasses = null;
        }

        @Override
        public void exitKeyChange(skmParser.KeyChangeContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Key {0}", ctx.getText());

            try {
                Key key = KeyFactory.getInstance().create(ctx.getText());
                addItemToSpine(key);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }

        @Override
        public void exitTimeSignature(skmParser.TimeSignatureContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Time signature {0}", ctx.getText());

            try {
                TimeSignature ts = TimeSignatureFactory.getInstance().create(ctx.getText());
                addItemToSpine(ts);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }


        @Override
        public void exitMeter(skmParser.MeterContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Meter {0}", ctx.getText());

            try {
                Meter meter = MeterFactory.getInstance().create(ctx.getText());
                addItemToSpine(meter);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }

        @Override
        public void exitMetronome(skmParser.MetronomeContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Metronome {0}", ctx.getText());
            super.exitMetronome(ctx);
            String numberStr = ctx.number().getText();
            MetronomeMark mm = new MetronomeMark(Integer.parseInt(numberStr));
            addItemToSpine(mm);
        }

        @Override
        public void exitNullInterpretation(skmParser.NullInterpretationContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Null interpretation {0}", ctx.getText());
            super.exitNullInterpretation(ctx);
        }

        @Override
        public void exitBarLine(skmParser.BarLineContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "BarLine {0}", ctx.getText());
            super.exitBarLine(ctx);

            Integer number = null;
            if (ctx.number() != null) {
                number = Integer.parseInt(ctx.getText());
            }

            String barlineType;
            if (ctx.barLineType() != null) {
                barlineType = ctx.getText();
            } else {
                barlineType = "";
            }
            try {
                BarLine barLine = BarlineFactory.getInstance().create(barlineType, number);
                addItemToSpine(barLine);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }


        @Override
        public void exitPlaceHolder(skmParser.PlaceHolderContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Placeholder {0}", ctx.getText());
            super.exitPlaceHolder(ctx);
        }


        @Override
        public void enterMensuralDuration(skmParser.MensuralDurationContext ctx) {
            super.enterMensuralDuration(ctx);
            lastColoured = null;
            lastPerfection = null;
            lastAgumentationDots = 0;
            lastHasSeparationDot = false;
        }

        @Override
        public void exitMensuralDot(skmParser.MensuralDotContext ctx) {
            super.exitMensuralDot(ctx);
            //lastAgumentationDots = ctx.augmentationDots()==null?0:ctx.augmentationDots().getChildCount();
            lastAgumentationDots = ctx.augmentationDot()==null?0:ctx.augmentationDot().getChildCount();
            lastHasSeparationDot = ctx.separationDot()!=null;
        }

        @Override
        public void exitMensuralFigure(skmParser.MensuralFigureContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural figure {0}", ctx.getText());
            super.exitMensuralFigure(ctx);
            Figures f = null;
            try {
                f = Figures.findFigure(ctx.getText());
                lastFigure = f;
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }

        @Override
        public void exitColoured(skmParser.ColouredContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural coloration {0}", ctx.getText());
            super.exitColoured(ctx);
            this.lastColoured = new Coloration();
        }

        @Override
        public void exitMensuralPerfection(skmParser.MensuralPerfectionContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural perfection {0}", ctx.getText());
            super.exitMensuralPerfection(ctx);
            switch (ctx.getText()) {
                case "p":
                    this.lastPerfection = Perfection.perfectum;
                    break;
                case "i":
                    this.lastPerfection = Perfection.imperfectum;
                    break;
                case "I":
                    this.lastPerfection = Perfection.alteratio;
                    break;
                default:
                    throw new GrammarParseRuntimeException("Mensural perfection '" + ctx.getText() + "' not recognized");

            }
        }

        @Override
        public void exitModernDuration(skmParser.ModernDurationContext ctx) {
            super.exitModernDuration(ctx);
            Figures f = null;
            try {
                f = Figures.findFigure(ctx.getText());
                lastFigure = f;
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e); //TODO la duración corresponderá a una tuplet!!!!
            }

            lastAgumentationDots = ctx.augmentationDot().size();
        }

        @Override
        public void enterRest(skmParser.RestContext ctx) {
            lastRestLinePosition = null;
            lastFermata = null;
        }

        @Override
        public void exitRestLinePosition(skmParser.RestLinePositionContext ctx) {
            this.lastRestLinePosition = Integer.parseInt(ctx.getChild(1).getText());
        }

        @Override
        public void exitFermata(skmParser.FermataContext ctx) {
            super.exitFermata(ctx);
            lastFermata = new Fermata();
        }

        @Override
        public void exitRest(skmParser.RestContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural rest {0}", ctx.getText());

            super.exitRest(ctx);

            //TODO cue size=?
            Rest rest = null;
            try {
                rest = new Rest(lastFigure, lastAgumentationDots, lastRestLinePosition, lastPerfection, lastFermata, null);
                addItemToSpine(rest);

                //TODO division dot
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }


        private void checkAllNoteNameEqual(String text) throws GrammarParseRuntimeException {
            // check all letters are equal
            for (int i = 1; i < text.length(); i++) {
                if (text.charAt(i) != text.charAt(0)) {
                    throw new GrammarParseRuntimeException(
                            "The characters for a note name should be the same for specifying the octave, and we have '"
                                    + text + "'");
                }
            }
        }

        private void handleNoteName(String code, int octaveModif) {
            checkAllNoteNameEqual(code);
            this.octaveModif = octaveModif;
            noteName = code.substring(0, 1).toUpperCase();
        }

        @Override
        public void enterTrebleNotes(skmParser.TrebleNotesContext ctx) {
            super.enterTrebleNotes(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "TrebleNotes {0}", ctx.getText());
            handleNoteName(ctx.getText(), ctx.getText().length() - 1);
        }

        @Override
        public void enterBassNotes(skmParser.BassNotesContext ctx) {
            super.enterBassNotes(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "BassNotes {0}", ctx.getText());
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "TrebleNotes {0}", ctx.getText());
            handleNoteName(ctx.getText(), -ctx.getText().length());
        }

        private ScientificPitch constructScientificPitch(skmParser.AlterationContext alterationContext) {
            int octave = 4 + octaveModif;

            // check all letters are equal
            DiatonicPitch nn = DiatonicPitch.valueOf(noteName);

            Accidentals acc = null;
            try {
                acc = Accidentals.accidentalFromSkmEncoding(alterationContext.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
            ScientificPitch scientificPitch = new ScientificPitch(new PitchClass(nn, acc), octave);
            return scientificPitch;
        }

        @Override
        public void enterNote(skmParser.NoteContext ctx) {
            this.lastStemDirection = null;
            this.lastFermata = null;
        }

        @Override
        public void exitStem(skmParser.StemContext ctx) {
            switch (ctx.getText()) {
                case "/":
                    lastStemDirection = StemDirection.up;
                    break;
                case "\\":
                    lastStemDirection = StemDirection.down;
                    break;
                default:
                    throw new GrammarParseRuntimeException("Unimplemented stem direction: " + ctx.getText());
            }
        }

        @Override
        public void exitNote(skmParser.NoteContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Note {0}", ctx.getText());
            super.exitNote(ctx);


            AccidentalQualifier accidentalQualifier = null;
            try {
                accidentalQualifier = AccidentalQualifier.findQualifier(ctx.editorialAccidental().getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }

            //TODO Ties
            Tie tie = null;

            ScientificPitch scientificPitch = constructScientificPitch(ctx.alteration());
            NotePitch notePitch = new NotePitch(scientificPitch, accidentalQualifier, tie);
            Note note = null;
            try {
                note = new Note(lastFigure, lastAgumentationDots, lastPerfection, lastFermata, null, notePitch, lastStemDirection, lastColoured);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }

            //TODO Ligature
            /*if (ctx.beforeNote().ligatureStart() != null && ctx.beforeNote().ligatureStart().size() > 0) {
                if (ctx.afterNote().ligatureEnd() != null && ctx.afterNote().ligatureEnd().size() > 0) {
                    throw new GrammarParseRuntimeException("Cannot create a ligature of just one symbol");
                }
                if (ctx.beforeNote().ligatureStart().size() != 1) {
                    throw new GrammarParseRuntimeException("Expected just 1 ligature start");
                }
                LigatureType ligatureType = null;
                switch (ctx.beforeNote().ligatureStart().get(0).getText()) {
                    case "[":
                        ligatureType = LigatureType.rectaStart;
                        break;
                    case "<":
                        ligatureType = LigatureType.obliquaStart;
                        break;
                    default:
                        throw new GrammarParseRuntimeException("Invalid ligature start type, should be [ or <, and it is: " + ctx.beforeNote().ligatureStart().get(0).getText());
                }
                note.setLigature(ligatureType);
            } else if (ctx.afterNote().ligatureEnd() != null && ctx.afterNote().ligatureEnd().size() > 0) {
                if (ctx.afterNote().ligatureEnd().size() != 1) {
                    throw new GrammarParseRuntimeException("Expected just 1 ligature end");
                }
                LigatureType ligatureType = null;
                switch (ctx.afterNote().ligatureEnd().get(0).getText()) {
                    case "]":
                        ligatureType = LigatureType.rectaEnd;
                        break;
                    case ">":
                        ligatureType = LigatureType.obliquaEnd;
                        break;
                    default:
                        throw new GrammarParseRuntimeException("Invalid ligature end type, should be > or ], and it is: " + ctx.beforeNote().ligatureStart().get(0).getText());
                }
                note.setLigature(ligatureType);
            }*/

            lastFermata = null;

            if (chordNotes == null) {
                addItemToSpine(note);

                //TODO separation dot
                /*if (lastHasSeparationDot) {
                    addToCurrentSpinePart(new DivisionDot());
                }*/
            } else {
                chordNotes.add(note);

                if (lastHasSeparationDot) {
                    throw new GrammarParseRuntimeException("There cannot be a separation dot in a chord");
                }
            }
        }

        @Override
        public void enterChord(skmParser.ChordContext ctx) {
            super.enterChord(ctx);
            chordNotes = new ArrayList<>();
        }

        @Override
        public void exitChord(skmParser.ChordContext ctx) {
            super.exitChord(ctx);

            // check all notes in chord are the same duration
            if (chordNotes.size() <= 1) {
                // this situation should never happen because the grammar rule does not allow it
                throw new GrammarParseRuntimeException("Chord has only " + chordNotes.size() + " notes");
            }

            NotePitch [] pitches = new NotePitch[chordNotes.size()];
            pitches[0] = chordNotes.get(0).getNotePitch();

            for (int i=1; i<chordNotes.size(); i++) {
                if (chordNotes.get(0).getFigure() != chordNotes.get(i).getFigure()
                    || chordNotes.get(0).getDots() != chordNotes.get(i).getDots()) {
                    throw new GrammarParseRuntimeException("There are different durations in the chord");
                }
                pitches[i] = chordNotes.get(i).getNotePitch();
            }

            //TODO cue size
            try {
                Chord chord = new Chord(lastFigure, lastAgumentationDots, pitches, lastPerfection, lastFermata, null, lastColoured);
                addItemToSpine(chord);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
        }

        @Override
        public void exitCustos(skmParser.CustosContext ctx) {
            super.exitCustos(ctx);
            ScientificPitch scientificPitch = constructScientificPitch(ctx.alteration());
            Custos custos = new Custos(scientificPitch.getPitchClass().getNoteName(), scientificPitch.getOctave());
            addItemToSpine(custos);
        }


        @Override
        public void exitLyricsText(skmParser.LyricsTextContext ctx) {
            super.exitLyricsText(ctx);
            addItemToSpine(new TextItem(ctx.getText()));
        }

        @Override
        public void enterGraphicalToken(skmParser.GraphicalTokenContext ctx) {
            super.enterGraphicalToken(ctx);
            associatedIDS = null;
        }

        @Override
        public void enterAssociatedIDS(skmParser.AssociatedIDSContext ctx) {
            super.enterAssociatedIDS(ctx);
            if (this.associatedIDS == null) {
                this.associatedIDS = new ArrayList<>();
            }
            this.associatedIDS.add(Long.parseLong(ctx.number().getText()));

            //TODO - mejor una spine para los IDS
        }

        @Override
        public void exitGraphicalToken(skmParser.GraphicalTokenContext ctx) {
            super.exitGraphicalToken(ctx);
            // TODO
            /*if (associatedIDS != null && !associatedIDS.isEmpty()) {
                skmMatrix.associateIDSToLastItem(associatedIDS);
            }*/
        }

        @Override
        public void exitPlainChant(skmParser.PlainChantContext ctx) {
            super.exitPlainChant(ctx);
            // TODO
        }

        @Override
        public void exitSpineTerminator(skmParser.SpineTerminatorContext ctx) {
            super.exitSpineTerminator(ctx);
            throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }

        @Override
        public void exitSpineAdd(skmParser.SpineAddContext ctx) {
            super.exitSpineAdd(ctx);
            throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }

        @Override
        public void exitSpineSplit(skmParser.SpineSplitContext ctx) {
            super.exitSpineSplit(ctx);
            throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }

        @Override
        public void exitSpineJoin(skmParser.SpineJoinContext ctx) {
            super.exitSpineJoin(ctx);
            throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }
    }

    private SemanticComposition importSkm(CharStream input, String inputDescription) throws IM4Exception {
        ErrorListener errorListener = new ErrorListener();
        try {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.INFO, "Parsing {0}", inputDescription);

            skmLexer lexer = new skmLexer(input);

            if (debug) {
                new ANTLRUtils().printLexer(lexer);
            }

            lexer.addErrorListener(errorListener);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            skmParser parser = new skmParser(tokens);
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.start();
            ParseTreeWalker walker = new ParseTreeWalker();
            Loader loader = new Loader(parser, debug);
            walker.walk(loader, tree);
            if (errorListener.getNumberErrorsFound() != 0) {
                throw new IM4Exception(errorListener.getNumberErrorsFound() + " errors found in "
                        + inputDescription + "\n" + errorListener.toString());
            }

            return loader.semanticComposition;
        } catch (Throwable e) {
            e.printStackTrace();
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
            }

            throw new IM4Exception(e.getMessage());
        }

    }

    public SemanticComposition importSkm(File file) throws IM4Exception {
        try {
            CharStream input = CharStreams.fromFileName(file.getAbsolutePath());
            return importSkm(input, file.getAbsolutePath());
        } catch (IOException e) {
            throw new IM4Exception(e);
        }
    }

    public SemanticComposition importSkm(String string) throws IM4Exception {
        CharStream input = CharStreams.fromString(string);
        return importSkm(input, string);
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
