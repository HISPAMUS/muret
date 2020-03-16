package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.io.builders.*;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmCoreSymbol;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmHeader;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmPart;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmStaff;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ANTLRUtils;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ErrorListener;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.GrammarParseRuntimeException;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ParseError;
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
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmSyntaxDirectedTranslation {
    private final ICoreAbstractFactory coreAbstractFactory;
    private boolean debug;

    public SkmSyntaxDirectedTranslation(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    public static class Loader extends skmParserBaseListener {
        private boolean debug;
        private final Parser parser;
        private SkmDocument skmDocument;
        private final ICoreAbstractFactory coreAbstractFactory;
        private int spineIndex;
        private int row;
        /**
         * This array should maintain the spine count including spine splits, joins, etc...
         */
        private ArrayList<SkmToken> lastSpineInsertedItem;
        private IClefBuilder clefBuilder;
        private ICustosBuilder custosBuilder;
        private IPitchClassBuilder pitchClassBuilder;
        private IAccidentalSymbolBuilder accidentalSymbolBuilder;
        private IDiatonicPitchBuilder diatonicPitchBuilder;
        private IKeySignatureBuilder keySignatureBuilder;
        private IPitchBuilder pitchBuilder;
        private IAlterationDisplayTypeBuilder alterationDisplayTypeBuilder;
        private IAlterationBuilder alterationBuilder;
        private IBarlineTypeBuilder barlineTypeBuilder;
        private IModeBuilder modeBuilder;

        private void resetBuilders() { // written here to have all object just above
            clefBuilder = null;
            custosBuilder = null;
            pitchClassBuilder = null;
            accidentalSymbolBuilder = null;
            diatonicPitchBuilder = null;
            keySignatureBuilder = null;
            pitchBuilder = null;
            alterationDisplayTypeBuilder = null;
            alterationBuilder = null;
            barlineTypeBuilder = null;
            modeBuilder = null;
        }

        public Loader(Parser parser, boolean debug, ICoreAbstractFactory coreAbstractFactory) {
            this.debug = debug;
            this.parser = parser;
            this.skmDocument = new SkmDocument();
            this.row = 0;
            this.coreAbstractFactory = coreAbstractFactory;
            this.lastSpineInsertedItem = new ArrayList<>();
        }

        private GrammarParseRuntimeException createException(IMException e) throws GrammarParseRuntimeException {
            return new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + e);
        }

        private GrammarParseRuntimeException createException(String message) throws GrammarParseRuntimeException {
            return new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + message);
        }

        private SkmToken getLastItemForCurrentSpine() {
            if (this.spineIndex >= this.lastSpineInsertedItem.size()) {
                throw new GrammarParseRuntimeException("The current spine index is " + this.spineIndex
                        + " and the lastSpineInsertedItem array has " + lastSpineInsertedItem.size() + " elements");
            }
            return this.lastSpineInsertedItem.get(this.spineIndex);
        }

        private void addItemToSpine(SkmToken skmItem) throws IMException {
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

            SkmHeader headerToken = SkmHeader.parse(ctx.getText().substring(2)); // remove the first **
            try {
                skmDocument.addHeader(headerToken);
            } catch (IMException e) {
                throw createException(e);
            }
            lastSpineInsertedItem.add(headerToken);
        }


        @Override
        public void exitPart(skmParser.PartContext ctx) {
            super.exitPart(ctx);

            int number = Integer.parseInt(ctx.number().getText());
            SkmPart partNumber = new SkmPart(number);
            try {
                addItemToSpine(partNumber);
            } catch (IMException e) {
                throw createException(e);
            }
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
        public void enterHeaderField(skmParser.HeaderFieldContext ctx) {
            super.enterHeaderField(ctx);
        }

        @Override
        public void exitField(skmParser.FieldContext ctx) {
            super.exitField(ctx);
            this.spineIndex ++;
            resetBuilders();
        }

        @Override
        public void exitStaff(skmParser.StaffContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Staff {0}", ctx.getText());
            super.exitStaff(ctx);

            int number = Integer.parseInt(ctx.number().getText());
            SkmStaff staffNumber = new SkmStaff(number);
            try {
                addItemToSpine(staffNumber);
            } catch (IMException e) {
                throw createException(e);
            }
        }


        @Override
        public void enterClef(skmParser.ClefContext ctx) {
            super.enterClef(ctx);
            clefBuilder = new IClefBuilder(coreAbstractFactory);
        }

        @Override
        public void exitClefSign(skmParser.ClefSignContext ctx) {
            super.exitClefSign(ctx);
            IClefSignBuilder clefSignBuilder = new IClefSignBuilder(coreAbstractFactory);
            clefSignBuilder.setClefSign(EClefSigns.valueOf(ctx.getText()));
            try {
                clefBuilder.setClefSign(clefSignBuilder.build());
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitClefLine(skmParser.ClefLineContext ctx) {
            super.exitClefLine(ctx);
            clefBuilder.setLine(Integer.parseInt(ctx.getText()));
        }

        @Override
        public void exitClef(skmParser.ClefContext ctx) {
            super.exitClef(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef {0}", ctx.getText());

            IClef clef = null;
            try {
                clef = clefBuilder.build();
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), clef));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterAccidental(skmParser.AccidentalContext ctx) {
            super.enterAccidental(ctx);
            accidentalSymbolBuilder = new IAccidentalSymbolBuilder(coreAbstractFactory);
        }

        @Override
        public void exitAccidental(skmParser.AccidentalContext ctx) {
            super.exitAccidental(ctx);
            EAccidentalSymbols accidentalSymbols;
            switch (ctx.getText()) {
                case "---":
                    accidentalSymbols = EAccidentalSymbols.TRIPLE_FLAT;
                    break;
                case "--":
                    accidentalSymbols = EAccidentalSymbols.DOUBLE_FLAT;
                    break;
                case "-":
                    accidentalSymbols = EAccidentalSymbols.FLAT;
                    break;
                case "n":
                    accidentalSymbols = EAccidentalSymbols.NATURAL;
                    break;
                case "#":
                    accidentalSymbols = EAccidentalSymbols.SHARP;
                    break;
                case "##":
                    accidentalSymbols = EAccidentalSymbols.DOUBLE_SHARP;
                    break;
                default:
                    throw createException("Unkown accidental symbol: " + ctx.getText());
            }
            accidentalSymbolBuilder.setAccidentalSymbol(accidentalSymbols);
        }

        @Override
        public void exitDiatonicPitch(skmParser.DiatonicPitchContext ctx) {
            super.exitDiatonicPitch(ctx);
            diatonicPitchBuilder = new IDiatonicPitchBuilder(coreAbstractFactory);
            diatonicPitchBuilder.setDiatonicPitch(EDiatonicPitches.valueOf(ctx.getText().toUpperCase()));
        }

        @Override
        public void enterPitchClass(skmParser.PitchClassContext ctx) {
            super.enterPitchClass(ctx);
            pitchClassBuilder = new IPitchClassBuilder(coreAbstractFactory);
        }


        @Override
        public void exitPitchClass(skmParser.PitchClassContext ctx) {
            if (accidentalSymbolBuilder != null) {
                try {
                    pitchClassBuilder.setAccidentalSymbol(accidentalSymbolBuilder.build());
                } catch (IMException e) {
                    throw createException(e);
                }
            }

            pitchClassBuilder.setDiatonicPitch(coreAbstractFactory.createDiatonicPitch(EDiatonicPitches.valueOf(ctx.lowerCasePitch().getText().toUpperCase())));
        }

        @Override
        public void enterKeySignature(skmParser.KeySignatureContext ctx) {
            super.enterKeySignature(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Beginning a key",
                    ctx.getText());
            keySignatureBuilder = new IKeySignatureBuilder(coreAbstractFactory);
        }

        @Override
        public void exitKeySignaturePitchClass(skmParser.KeySignaturePitchClassContext ctx) {
            super.exitKeySignaturePitchClass(ctx);
            try {
                keySignatureBuilder.addPitchClass(pitchClassBuilder.build());
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitKeySignature(skmParser.KeySignatureContext ctx) {
            super.exitKeySignature(ctx);
            try {
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), keySignatureBuilder.build()));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterKeyMode(skmParser.KeyModeContext ctx) {
            super.exitKeyMode(ctx);
            modeBuilder = new IModeBuilder(coreAbstractFactory);
        }

        @Override
        public void exitMajorKey(skmParser.MajorKeyContext ctx) {
            super.exitMajorKey(ctx);
            modeBuilder.setMode(EModes.major);
            pitchClassBuilder = new IPitchClassBuilder(coreAbstractFactory);
            diatonicPitchBuilder = new IDiatonicPitchBuilder(coreAbstractFactory);
            diatonicPitchBuilder.setDiatonicPitch(EDiatonicPitches.valueOf(ctx.upperCasePitch().getText().toUpperCase()));
            try {
                pitchClassBuilder.setDiatonicPitch(diatonicPitchBuilder.build());
                if (accidentalSymbolBuilder != null) {
                    pitchClassBuilder.setAccidentalSymbol(accidentalSymbolBuilder.build());
                }
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitMinorKey(skmParser.MinorKeyContext ctx) {
            super.exitMinorKey(ctx);
            modeBuilder.setMode(EModes.minor);
            pitchClassBuilder = new IPitchClassBuilder(coreAbstractFactory);
            diatonicPitchBuilder = new IDiatonicPitchBuilder(coreAbstractFactory);
            diatonicPitchBuilder.setDiatonicPitch(EDiatonicPitches.valueOf(ctx.lowerCasePitch().getText().toUpperCase()));
            try {
                pitchClassBuilder.setDiatonicPitch(diatonicPitchBuilder.build());
                if (accidentalSymbolBuilder != null) {
                    pitchClassBuilder.setAccidentalSymbol(accidentalSymbolBuilder.build());
                }
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitKey(skmParser.KeyContext ctx) {
            try {
                IPitchClass pitchClass = pitchClassBuilder.build();
                IMode mode = modeBuilder.build();
                IKey key = coreAbstractFactory.createKey(pitchClass, mode);
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), key));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitFractionalTimeSignature(skmParser.FractionalTimeSignatureContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Time signature {0}", ctx.getText());
            IFractionalTimeSignatureBuilder fractionalTimeSignatureBuilder = new IFractionalTimeSignatureBuilder(coreAbstractFactory);
            fractionalTimeSignatureBuilder.setNumerator(Integer.parseInt(ctx.numerator().getText()));
            fractionalTimeSignatureBuilder.setDenominator(Integer.parseInt(ctx.denominator().getText()));
            try {
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), fractionalTimeSignatureBuilder.build()));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitModernMeterSymbolSign(skmParser.ModernMeterSymbolSignContext ctx) {
            super.exitModernMeterSymbolSign(ctx);
            IMeterSymbolBuilder meterSymbolBuilder = new IMeterSymbolBuilder(coreAbstractFactory);
            EMeterSymbols eMeterSymbols;
            switch (ctx.getText()) {
                case "c":
                    eMeterSymbols = EMeterSymbols.commonTime;
                    break;
                case "c|":
                    eMeterSymbols = EMeterSymbols.cutTime;
                    break;
                default:
                    throw createException("Unkown meter symbol: " + ctx.getText());
            }
            meterSymbolBuilder.setMeterSymbols(eMeterSymbols);
            try {
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), meterSymbolBuilder.build()));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitMensuration(skmParser.MensurationContext ctx) {
            super.exitMensuration(ctx);
            IMensurationBuilder mensurationBuilder = new IMensurationBuilder(coreAbstractFactory);
            EMensurations mensuration;
            switch (ctx.getText()) {
                case "C":
                    mensuration = EMensurations.tempusImperfectumCumProlationeImperfecta;
                    break;
                case "C.":
                    mensuration = EMensurations.tempusImperfectumCumProlationePerfecta;
                    break;
                case "O":
                    mensuration = EMensurations.tempusPerfectumCumProlationeImperfecta;
                    break;
                case "O.":
                    mensuration = EMensurations.tempusPerfectumCumProlationePerfecta;
                    break;
                case "C|":
                    mensuration = EMensurations.tempusImperfectumCumProlationeImperfectaDiminutum;
                    break;
                case "C3/2":
                    mensuration = EMensurations.proportioSesquialtera;
                    break;
                case "C|3/2":
                    mensuration = EMensurations.proportioTripla;
                    break;
                case "2":
                    mensuration = EMensurations.proportioChangeDupla;
                    break;
                case "3":
                    mensuration = EMensurations.proportioChangeTripla;
                    break;
                default:
                    throw createException("Unkown mensuration: " + ctx.getText());

            }
            mensurationBuilder.setMensurations(mensuration);
            try {
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), mensurationBuilder.build()));
            } catch (IMException e) {
                throw createException(e);
            }
        }



        @Override
        public void exitMetronome(skmParser.MetronomeContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Metronome {0}", ctx.getText());
            super.exitMetronome(ctx);
            IMetronomeMarkBuilder metronomeMarkBuilder = new IMetronomeMarkBuilder(coreAbstractFactory);
            metronomeMarkBuilder.setFigure(coreAbstractFactory.createFigure(EFigures.QUARTER));
            metronomeMarkBuilder.setValue(Integer.parseInt(ctx.number().getText()));
            SkmCoreSymbol mm = null;
            try {
                mm = new SkmCoreSymbol(ctx.getText(), metronomeMarkBuilder.build());
                addItemToSpine(mm);
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitNullInterpretation(skmParser.NullInterpretationContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Null interpretation {0}", ctx.getText());
            super.exitNullInterpretation(ctx);
        }

        @Override
        public void exitBarLineType(skmParser.BarLineTypeContext ctx) {
            super.exitBarLineType(ctx);
            barlineTypeBuilder = new IBarlineTypeBuilder(coreAbstractFactory);
            EBarlineTypes barlineType;
            switch (ctx.getText()) {
                case "=":
                    barlineType = EBarlineTypes.end;
                    break;
                case "||":
                    barlineType = EBarlineTypes.doubleThin;
                    break;
                case "-":
                    barlineType = EBarlineTypes.hidden;
                    break;
                case "|!:":
                    barlineType = EBarlineTypes.leftRepeat;
                    break;
                case ":|!|:":
                    barlineType = EBarlineTypes.leftRightRepeat;
                    break;
                case ":|!":
                    barlineType = EBarlineTypes.rightRepeat;
                    break;
                default:
                    throw createException("Unkopwn barline type: " + ctx.getText());
            }
            barlineTypeBuilder.setBarlineType(barlineType);
        }

        @Override
        public void exitBarline(skmParser.BarlineContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "BarLine {0}", ctx.getText());
            super.exitBarline(ctx);

            IBarlineBuilder barlineBuilder = new IBarlineBuilder(coreAbstractFactory);

            if (ctx.number() != null) {
                barlineBuilder.setBarNumber(Integer.parseInt(ctx.number().getText()));
            }

            if (barlineTypeBuilder != null) {
                try {
                    barlineBuilder.setBarlineType(barlineTypeBuilder.build());
                } catch (IMException e) {
                    throw createException(e);
                }
            }
            try {
                SkmCoreSymbol skmBarLine = new SkmCoreSymbol(ctx.getText(), barlineBuilder.build());
                addItemToSpine(skmBarLine);
            } catch (IMException e) {
                throw createException(e);
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
        public void exitAlterationDisplay(skmParser.AlterationDisplayContext ctx) {
            super.exitAlterationDisplay(ctx);
            alterationDisplayTypeBuilder = new IAlterationDisplayTypeBuilder(coreAbstractFactory);
            alterationDisplayTypeBuilder.setAlterationDisplayType(EAlterationDisplayTypes.valueOf(ctx.getText()));
        }

        @Override
        public void enterAlteration(skmParser.AlterationContext ctx) {
            super.enterAlteration(ctx);
            alterationBuilder = new IAlterationBuilder(coreAbstractFactory);
        }

        @Override
        public void exitAlteration(skmParser.AlterationContext ctx) {
            super.enterAlteration(ctx);
            try {
                alterationBuilder.setAccidentalSymbol(accidentalSymbolBuilder.build());

                if (alterationDisplayTypeBuilder != null) {
                    alterationBuilder.setAlterationDisplayType(alterationDisplayTypeBuilder.build());
                }
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterPitch(skmParser.PitchContext ctx) {
            super.enterPitch(ctx);
            pitchBuilder = new IPitchBuilder(coreAbstractFactory);
        }

        @Override
        public void exitPitch(skmParser.PitchContext ctx) {
            super.exitPitch(ctx);
            try {
                pitchBuilder.setDiatonicPitch(diatonicPitchBuilder.build());
                if (alterationBuilder != null) {
                    pitchBuilder.setAlteration(alterationBuilder.build());
                }
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterCustos(skmParser.CustosContext ctx) {
            super.enterCustos(ctx);
            custosBuilder = new ICustosBuilder(coreAbstractFactory);
        }

        @Override
        public void exitCustos(skmParser.CustosContext ctx) {
            super.exitCustos(ctx);
            try {
                custosBuilder.setPitch(pitchBuilder.build());
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), custosBuilder.build()));
            } catch (IMException e) {
                throw createException(e);
            }
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

    private SkmDocument importSkm(CharStream input, String inputDescription) throws IMException {
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
            Loader loader = new Loader(parser, debug, coreAbstractFactory);
            walker.walk(loader, tree);
            if (errorListener.getNumberErrorsFound() != 0) {
                throw new IMException(errorListener.getNumberErrorsFound() + " errors found in "
                        + inputDescription + "\n" + errorListener.toString());
            }

            return loader.skmDocument;
        } catch (Throwable e) {
            e.printStackTrace();
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
            }

            throw new IMException(e.getMessage());
        }

    }

    public SkmDocument importSkm(File file) throws IMException {
        try {
            CharStream input = CharStreams.fromFileName(file.getAbsolutePath());
            return importSkm(input, file.getAbsolutePath());
        } catch (IOException e) {
            throw new IMException(e);
        }
    }

    public SkmDocument importSkm(String string) throws IMException {
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
