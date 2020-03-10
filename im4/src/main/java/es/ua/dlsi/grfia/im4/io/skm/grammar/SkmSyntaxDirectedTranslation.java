package es.ua.dlsi.grfia.im4.io.skm.grammar;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.io.builders.ISymbolBuilder;
import es.ua.dlsi.grfia.im4.io.skm.SkmToken;
import es.ua.dlsi.grfia.im4.io.skm.grammar.builders.SkmClefBuilder;
import es.ua.dlsi.grfia.im4.io.skm.grammar.tokens.SkmCoreSymbol;
import es.ua.dlsi.grfia.im4.io.skm.grammar.tokens.SkmHeader;
import es.ua.dlsi.grfia.im4.io.skm.grammar.tokens.SkmPart;
import es.ua.dlsi.grfia.im4.io.skm.grammar.tokens.SkmStaff;
import es.ua.dlsi.grfia.im4.utils.antlr4.ANTLRUtils;
import es.ua.dlsi.grfia.im4.utils.antlr4.ErrorListener;
import es.ua.dlsi.grfia.im4.utils.antlr4.GrammarParseRuntimeException;
import es.ua.dlsi.grfia.im4.utils.antlr4.ParseError;
import es.ua.dlsi.grfia.im4.io.skm.SkmDocument;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It translates from **skm to a directed acyclic graph of symbols using a syntax driven translation technique
 * @author drizo
 */
public class SkmSyntaxDirectedTranslation {
    private boolean debug;
    private final ICoreAbstractFactory abstractFactory;

    public SkmSyntaxDirectedTranslation(ICoreAbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    public static class Loader extends skmParserBaseListener {
        private boolean debug;
        private final Parser parser;
        private SkmDocument skmDocument;
        private final SkmBuilderFactory skmBuilderFactory;
        private int spineIndex;
        private int row;
        /**
         * This array should maintain the spine count including spine splits, joins, etc...
         */
        private ArrayList<SkmToken> lastSpineInsertedItem;
        private ISymbolBuilder<IClef> clefBuilder;
        /*private ArrayList<SkmPitchClass> keySignaturePitchClasses;
        private SkmFigure lastFigure;
        private SkmColoration lastColoured;
        private SkmPerfection lastPerfection;
        private int lastAgumentationDots;
        private SkmFermata lastFermata;

        private int octaveModif;
        private String noteName;

        private SkmStemDirection lastStemDirection;
        private Integer lastRestLinePosition;
        private ArrayList<SkmNote> chordNotes;
        private SkmDots lastSkmDots;*/

        public Loader(Parser parser, boolean debug, ICoreAbstractFactory abstractFactory) {
            this.debug = debug;
            this.parser = parser;
            this.skmDocument = new SkmDocument();
            this.row = 0;
            this.skmBuilderFactory = new SkmBuilderFactory(abstractFactory);
            /// this.lastSpineInsertedItem = new ArrayList<>();
        }

        private void throwError(String message) throws GrammarParseRuntimeException {
            throw new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + message);
        }

        private SkmToken getLastItemForCurrentSpine() {
            if (this.spineIndex >= this.lastSpineInsertedItem.size()) {
                throw new GrammarParseRuntimeException("The current spine index is " + this.spineIndex
                        + " and the lastSpineInsertedItem array has " + lastSpineInsertedItem.size() + " elements");
            }
            return this.lastSpineInsertedItem.get(this.spineIndex);
        }

        private void addItemToSpine(SkmToken skmItem) {
            SkmToken previous = getLastItemForCurrentSpine();
            this.skmDocument.add(previous, skmItem);
            lastSpineInsertedItem.set(this.spineIndex, skmItem);
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

            SkmHeader headerToken = SkmHeader.parse(ctx.getText());
            skmDocument.addHeader(headerToken);
            lastSpineInsertedItem.add(headerToken);
        }


        @Override
        public void exitPart(skmParser.PartContext ctx) {
            super.exitPart(ctx);

            int number = Integer.parseInt(ctx.number().getText());
            SkmPart partNumber = new SkmPart(number);
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
            SkmStaff staffNumber = new SkmStaff(number);
            addItemToSpine(staffNumber);
        }

        @Override
        public void enterClef(skmParser.ClefContext ctx) {
            super.enterClef(ctx);
            clefBuilder = skmBuilderFactory.getClefBuilder();
        }

        @Override
        public void exitClefNote(skmParser.ClefNoteContext ctx) {
            super.exitClefNote(ctx);
            clefBuilder.addProperty(SkmClefBuilder.PROP_NOTE, ctx.getText());
        }

        @Override
        public void exitClefLine(skmParser.ClefLineContext ctx) {
            super.exitClefLine(ctx);
            clefBuilder.addProperty(SkmClefBuilder.PROP_LINE, ctx.getText());
        }

        @Override
        public void exitClef(skmParser.ClefContext ctx) {
            super.exitClef(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef {0}", ctx.getText());

            IClef clef = null;
            try {
                clef = clefBuilder.build();
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }
            addItemToSpine(new SkmCoreSymbol(ctx.getText(), clef));
            clefBuilder = null;
        }

        @Override
        public void enterKeySignature(skmParser.KeySignatureContext ctx) {
            super.enterKeySignature(ctx);
            /*Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Beginning a key",
                    ctx.getText());
            keySignaturePitchClasses = new ArrayList<>();*/
        }

        @Override
        public void exitKeySignatureNote(skmParser.KeySignatureNoteContext ctx) {
            super.exitKeySignatureNote(ctx);

            /*try {
                String accidentalText = null;
                if (ctx.keyAccidental() != null) {
                    accidentalText = ctx.keyAccidental().getText();
                }
                SkmPitchClass skmPitchClass = SkmPitchClassFactory.getInstance().create(ctx.lowerCasePitch().getText(), accidentalText);
                this.keySignaturePitchClasses.add(skmPitchClass);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }

        @Override
        public void exitKeySignature(skmParser.KeySignatureContext ctx) {
            super.exitKeySignature(ctx);
           /* Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Key signature {0}", ctx.getText());

            SkmPitchClass [] pitchClasses = new SkmPitchClass[this.keySignaturePitchClasses.size()];
            pitchClasses = this.keySignaturePitchClasses.toArray(pitchClasses);
            SkmKeySignature keySignature = new SkmKeySignature(pitchClasses);
            addItemToSpine(keySignature);
            keySignaturePitchClasses = null;*/
        }

        @Override
        public void exitKeyChange(skmParser.KeyChangeContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Key {0}", ctx.getText());

           /* try {
                SkmKey key = SkmKeyFactory.getInstance().create(ctx.getText());
                addItemToSpine(key);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }

        @Override
        public void exitTimeSignature(skmParser.TimeSignatureContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Time signature {0}", ctx.getText());

           /* try {
                SkmTimeSignature ts = SkmTimeSignatureFactory.getInstance().create(ctx.getText());
                addItemToSpine(ts);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }


        @Override
        public void exitMeter(skmParser.MeterContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Meter {0}", ctx.getText());

           /* try {
                SkmMeter meter = SkmMeterFactory.getInstance().create(ctx.getText());
                addItemToSpine(meter);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }

        @Override
        public void exitMetronome(skmParser.MetronomeContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Metronome {0}", ctx.getText());
            super.exitMetronome(ctx);
           /* String numberStr = ctx.number().getText();
            SkmMetronomeMark mm = new SkmMetronomeMark(Integer.parseInt(numberStr));
            addItemToSpine(mm);*/
        }

        @Override
        public void exitNullInterpretation(skmParser.NullInterpretationContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Null interpretation {0}", ctx.getText());
            super.exitNullInterpretation(ctx);
        }

        @Override
        public void exitBarline(skmParser.BarlineContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "BarLine {0}", ctx.getText());
            super.exitBarline(ctx);

           /* Integer number = null;
            if (ctx.number() != null) {
                number = Integer.parseInt(ctx.getText());
            }

            String barlineType;
            if (ctx.barLineType() != null) {
                barlineType = ctx.barLineType().getText();
            } else {
                barlineType = "";
            }
            try {
                SkmBarLine skmBarLine = SkmBarLineFactory.getInstance().create(barlineType, number);
                addItemToSpine(skmBarLine);
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }


        @Override
        public void exitPlaceHolder(skmParser.PlaceHolderContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Placeholder {0}", ctx.getText());
            super.exitPlaceHolder(ctx);
        }


        @Override
        public void enterMensuralDuration(skmParser.MensuralDurationContext ctx) {
            super.enterMensuralDuration(ctx);

           /* if (lastAgumentationDots > 0) {
                lastSkmDots = new SkmDots(lastAgumentationDots);
            }

            lastColoured = null;
            lastPerfection = null;
            lastAgumentationDots = 0;*/
        }

        @Override
        public void exitMensuralDot(skmParser.MensuralDotContext ctx) {
            super.exitMensuralDot(ctx);
            //lastAgumentationDots = ctx.augmentationDot()==null?0:ctx.augmentationDot().getChildCount();
        }

        @Override
        public void exitMensuralFigure(skmParser.MensuralFigureContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural figure {0}", ctx.getText());
            super.exitMensuralFigure(ctx);

            /*try {
                lastFigure = SkmFigureFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }


        @Override
        public void exitColoured(skmParser.ColouredContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural coloration {0}", ctx.getText());
            super.exitColoured(ctx);
          //  this.lastColoured = new SkmColoration();
        }

        @Override
        public void exitMensuralPerfection(skmParser.MensuralPerfectionContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural perfection {0}", ctx.getText());
            super.exitMensuralPerfection(ctx);

           /* try {
                this.lastPerfection = SkmPerfectionFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }

        @Override
        public void exitModernDuration(skmParser.ModernDurationContext ctx) {
            super.exitModernDuration(ctx);

           /* try {
                lastFigure = SkmFigureFactory.getInstance().create(ctx.number().getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }


            lastAgumentationDots = ctx.augmentationDot().size();
            if (lastAgumentationDots > 0) {
                lastSkmDots = new SkmDots(lastAgumentationDots);
            }
            lastAgumentationDots = 0;*/
        }

        @Override
        public void enterRest(skmParser.RestContext ctx) {
            /*lastRestLinePosition = null;
            lastFermata = null;*/
        }

        @Override
        public void exitRestLinePosition(skmParser.RestLinePositionContext ctx) {
          //  this.lastRestLinePosition = Integer.parseInt(ctx.getChild(1).getText());
        }

        @Override
        public void exitFermata(skmParser.FermataContext ctx) {
            super.exitFermata(ctx);
            // lastFermata = new SkmFermata();
        }

        @Override
        public void exitRest(skmParser.RestContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural rest {0}", ctx.getText());
            super.exitRest(ctx);

           /* SkmRest rest = new SkmRest(lastFigure, lastSkmDots, lastPerfection, lastRestLinePosition, lastFermata);
            addItemToSpine(rest);*/
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
           /* this.octaveModif = octaveModif;
            noteName = code.substring(0, 1).toLowerCase();*/
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

        @Override
        public void enterNote(skmParser.NoteContext ctx) {
          /*  this.lastStemDirection = null;
            this.lastFermata = null;*/
        }

        @Override
        public void exitStem(skmParser.StemContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Stem {0}", ctx.getText());
            /*try {
                lastStemDirection = SkmStemFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }


        @Override
        public void exitNote(skmParser.NoteContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Note {0}", ctx.getText());
            super.exitNote(ctx);

//           SkmAccidental skmAccidental = null;
//            if (ctx.accidental() != null) {
//                try {
//                    skmAccidental = SkmAccidentalFactory.getInstance().create(ctx.accidental().getText());
//                } catch (IM4Exception e) {
//                    throw new GrammarParseRuntimeException(e);
//                }
//            } else {
//                skmAccidental = new SkmAccidentalNatural();
//            }
//
//            SkmAlterationQualifier alterationQualifier = null;
//            if (ctx.alterationQualifier() != null) {
//                try {
//                    alterationQualifier = SkmAlterationQualifierFactory.getInstance().create(ctx.alterationQualifier().getText());
//                } catch (IM4Exception e) {
//                    throw new GrammarParseRuntimeException(e);
//                }
//            }
//
//            SkmAlteration skmAlteration;
//            if (alterationQualifier == null) {
//                skmAlteration = new SkmAlteration(skmAccidental);
//            } else {
//                skmAlteration = new SkmAlteration(skmAccidental, alterationQualifier);
//            }
//
//            //TODO Ties ...
//            SkmDiatonicPitch skmDiatonicPitch = null;
//            try {
//                skmDiatonicPitch = SkmDiatonicPitchFactory.getInstance().create(noteName);
//            } catch (IM4Exception e) {
//                throw new GrammarParseRuntimeException(e);
//            }
//
//            SkmScientificPitch skmScientificPitch = new SkmScientificPitch(skmDiatonicPitch, skmAlteration, octaveModif);
//            SkmNote skmNote = new SkmNote(lastFigure, lastSkmDots, lastPerfection, lastColoured, skmScientificPitch);
//
//            lastFermata = null;
//
//            if (chordNotes == null) {
//                addItemToSpine(skmNote);
//
//                //TODO separation dot
//                /*if (lastHasSeparationDot) {
//                    addToCurrentSpinePart(new DivisionDot());
//                }*/
//            } else {
//                chordNotes.add(skmNote);
//
//                /*if (lastHasSeparationDot) {
//                    throw new GrammarParseRuntimeException("There cannot be a separation dot in a chord");
//                }*/
//            }
        }

        @Override
        public void enterChord(skmParser.ChordContext ctx) {
            super.enterChord(ctx);
            //chordNotes = new ArrayList<>();
        }

        @Override
        public void exitChord(skmParser.ChordContext ctx) {
            super.exitChord(ctx);
/*
            // check all notes in chord are the same duration
            if (chordNotes.size() <= 1) {
                // this situation should never happen because the grammar rule does not allow it
                throw new GrammarParseRuntimeException("Chord has only " + chordNotes.size() + " notes");
            }

            SkmScientificPitch [] pitches = new SkmScientificPitch[chordNotes.size()];
            pitches[0] = chordNotes.get(0).getSkmScientificPitch();

            for (int i=1; i<chordNotes.size(); i++) {
                if (chordNotes.get(0).getSkmFigure().equals(chordNotes.get(i).getSkmFigure())
                    || !Objects.equals(chordNotes.get(0).getSkmDots(), chordNotes.get(i).getSkmDots())) {
                    throw new GrammarParseRuntimeException("There are different durations in the chord");
                }
                pitches[i] = chordNotes.get(i).getSkmScientificPitch();
            }

            //TODO cue size, fermata ...
            SkmChord chord = new SkmChord(lastFigure, lastSkmDots, pitches);
            addItemToSpine(chord);*/
        }

        @Override
        public void exitCustos(skmParser.CustosContext ctx) {
            super.exitCustos(ctx);
           /* SkmScientificPitch skmScientificPitch = null; //TODO
            SkmCustos skmCustos = new SkmCustos(skmScientificPitch);
            addItemToSpine(skmCustos);*/
        }


        @Override
        public void exitLyricsText(skmParser.LyricsTextContext ctx) {
            super.exitLyricsText(ctx);
            //addItemToSpine(new SkmLyrics(ctx.getText()));
        }

        @Override
        public void enterGraphicalToken(skmParser.GraphicalTokenContext ctx) {
            super.enterGraphicalToken(ctx);
            // associatedIDS = null;
        }

        @Override
        public void enterAssociatedIDS(skmParser.AssociatedIDSContext ctx) {
            super.enterAssociatedIDS(ctx);
           /* if (this.associatedIDS == null) {
                this.associatedIDS = new ArrayList<>();
            }
            this.associatedIDS.add(Long.parseLong(ctx.number().getText()));*/

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
            // throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
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

    private SkmDocument importSkm(CharStream input, String inputDescription) throws IM4Exception {
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
            Loader loader = new Loader(parser, debug, abstractFactory);
            walker.walk(loader, tree);
            if (errorListener.getNumberErrorsFound() != 0) {
                throw new IM4Exception(errorListener.getNumberErrorsFound() + " errors found in "
                        + inputDescription + "\n" + errorListener.toString());
            }

            return loader.skmDocument;
        } catch (Throwable e) {
            e.printStackTrace();
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
            }

            throw new IM4Exception(e.getMessage());
        }

    }

    public SkmDocument importSkm(File file) throws IM4Exception {
        try {
            CharStream input = CharStreams.fromFileName(file.getAbsolutePath());
            return importSkm(input, file.getAbsolutePath());
        } catch (IOException e) {
            throw new IM4Exception(e);
        }
    }

    public SkmDocument importSkm(String string) throws IM4Exception {
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
