package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.mensural.IMensuration;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.ImportingContexts;
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

        protected ImportingContexts<ICoreObject> importingContexts;

        public Loader(Parser parser, boolean debug, ICoreAbstractFactory coreAbstractFactory) {
            this.debug = debug;
            this.parser = parser;
            this.skmDocument = new SkmDocument();
            this.row = 0;
            this.coreAbstractFactory = coreAbstractFactory;
            this.lastSpineInsertedItem = new ArrayList<>();
            this.importingContexts = new ImportingContexts();
        }

        private GrammarParseRuntimeException createException(String message, Throwable e) throws GrammarParseRuntimeException {
            return new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + message + " :" + e);
        }

        private GrammarParseRuntimeException createException(Throwable e) throws GrammarParseRuntimeException {
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

        private void beginContext(RuleContext ruleContext, IObjectBuilder<? extends ICoreObject> builder) {
            this.importingContexts.begin(ruleContext.getClass().getName(), builder);
        }

        private void beginEndContext(RuleContext ruleContext, IObjectBuilder<? extends ICoreObject> builder, Object ... objects) {
            try {
                this.importingContexts.beginEnd(builder, objects);
            } catch (Throwable e) {
                throw createException("RuleContext " + ruleContext.getClass().getName(), e);
            }
        }

        private ICoreObject endContext(RuleContext ruleContext) {
            try {
                return this.importingContexts.end(ruleContext.getClass().getName());
            } catch (Throwable e) {
                throw createException("RuleContext " + ruleContext.getClass().getName(), e);
            }
        }

        private void endContextAndAddToSpine(RuleContext ruleContext)  {
            try {
                this.addItemToSpine(new SkmCoreSymbol(ruleContext.getText(), endContext(ruleContext)));
            } catch (Throwable e) {
                throw createException("RuleContext " + ruleContext.getClass().getName(), e);
            }
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
        public void enterPart(skmParser.PartContext ctx) {
            super.enterPart(ctx);
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
            beginContext(ctx, new IClefBuilder(coreAbstractFactory));
        }

        @Override
        public void exitClef(skmParser.ClefContext ctx) {
            super.exitClef(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }

        @Override
        public void exitClefSign(skmParser.ClefSignContext ctx) {
            super.exitClefSign(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef sign {0}", ctx.getText());

            EClefSigns clefSigns;
            switch (ctx.getText()) {
                case "P":
                    clefSigns = EClefSigns.Percussion;
                    break;
                case "T":
                    clefSigns = EClefSigns.TAB;
                    break;
                default:
                    clefSigns = EClefSigns.valueOf(ctx.getText());
            }


            beginEndContext(ctx, new IClefSignBuilder(coreAbstractFactory), clefSigns);
        }

        @Override
        public void exitClefLine(skmParser.ClefLineContext ctx) {
            super.exitClefLine(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef line {0}", ctx.getText());

            beginEndContext(ctx, new IClefLineBuilder(coreAbstractFactory), Integer.parseInt(ctx.getText()));
        }

        @Override
        public void exitClefOctave(skmParser.ClefOctaveContext ctx) {
            super.exitClefOctave(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef octave {0}", ctx.getText());

            Integer octave = null;
            switch (ctx.getText()) {
                case "^^2":
                    octave = 2;
                    break;
                case "^2":
                    octave = 1;
                    break;
                case "v2":
                    octave = -1;
                    break;
                case "vv2":
                    octave = -2;
                    break;
                default:
                    createException("Clef octave not valid: " + ctx.getText());
            }
            beginEndContext(ctx, new IOctaveTranspositionBuilder(coreAbstractFactory), octave);
        }


        @Override
        public void exitAccidental(skmParser.AccidentalContext ctx) {
            super.exitAccidental(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Accidental {0}", ctx.getText());

            EAccidentalSymbols accidentalSymbol;
            switch (ctx.getText()) {
                case "---":
                    accidentalSymbol = EAccidentalSymbols.TRIPLE_FLAT;
                    break;
                case "--":
                    accidentalSymbol = EAccidentalSymbols.DOUBLE_FLAT;
                    break;
                case "-":
                    accidentalSymbol = EAccidentalSymbols.FLAT;
                    break;
                case "n":
                    accidentalSymbol = EAccidentalSymbols.NATURAL;
                    break;
                case "#":
                    accidentalSymbol = EAccidentalSymbols.SHARP;
                    break;
                case "##":
                    accidentalSymbol = EAccidentalSymbols.DOUBLE_SHARP;
                    break;
                default:
                    throw createException("Unknown accidental symbol: " + ctx.getText());
            }

            beginEndContext(ctx, new IAccidentalSymbolBuilder(coreAbstractFactory), accidentalSymbol);
        }

        @Override
        public void enterPitchClass(skmParser.PitchClassContext ctx) {
            super.enterPitchClass(ctx);
            beginContext(ctx, new IPitchClassBuilder(coreAbstractFactory));
        }


        @Override
        public void exitPitchClass(skmParser.PitchClassContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Pitch class {0}", ctx.getText());

            importingContexts.addObjectToPool(coreAbstractFactory.createDiatonicPitch(null, EDiatonicPitches.valueOf(ctx.lowerCasePitch().getText().toUpperCase())));
            endContext(ctx);
        }

        @Override
        public void enterKeySignature(skmParser.KeySignatureContext ctx) {
            super.enterKeySignature(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Beginning a key",
                    ctx.getText());

            beginContext(ctx, new IUnconventionalKeySignatureBuilder(coreAbstractFactory));
        }

        @Override
        public void exitKeySignature(skmParser.KeySignatureContext ctx) {
            super.exitKeySignature(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Key signature {0}", ctx.getText());

            //TODO we could check whether the unconventional key signature is not unconventional, but conventional?
            endContextAndAddToSpine(ctx);
        }

        @Override
        public void enterKeyMode(skmParser.KeyModeContext ctx) {
            super.exitKeyMode(ctx);
            beginContext(ctx, new IModeBuilder(coreAbstractFactory));
            importingContexts.begin("pitchClass", new IPitchClassBuilder(coreAbstractFactory));
        }

        @Override
        public void exitKeyMode(skmParser.KeyModeContext ctx) {
            super.exitKeyMode(ctx);
            try {
                importingContexts.end("pitchClass");
            } catch (IMException e) {
                throw createException(e);
            }
            endContext(ctx);
        }

        @Override
        public void exitMajorKey(skmParser.MajorKeyContext ctx) {
            super.exitMajorKey(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Major key {0}", ctx.getText());

            importingContexts.addObjectToPool(EModes.major);
            importingContexts.addObjectToPool(EDiatonicPitches.valueOf(ctx.upperCasePitch().getText().toUpperCase()));
        }

        @Override
        public void exitMinorKey(skmParser.MinorKeyContext ctx) {
            super.exitMinorKey(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Minor key {0}", ctx.getText());

            importingContexts.addObjectToPool(EModes.minor);
            importingContexts.addObjectToPool(EDiatonicPitches.valueOf(ctx.lowerCasePitch().getText().toUpperCase()));
        }

        @Override
        public void enterKey(skmParser.KeyContext ctx) {
            super.enterKey(ctx);
            beginContext(ctx, new IKeyBuilder(coreAbstractFactory));
        }

        @Override
        public void exitKey(skmParser.KeyContext ctx) {
            super.exitKey(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Key {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }

        @Override
        public void enterFractionalTimeSignature(skmParser.FractionalTimeSignatureContext ctx) {
            super.enterFractionalTimeSignature(ctx);
            beginContext(ctx, new IFractionalTimeSignatureBuilder(coreAbstractFactory));
        }

        @Override
        public void exitFractionalTimeSignature(skmParser.FractionalTimeSignatureContext ctx) {
            super.exitFractionalTimeSignature(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Time signature {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }

        @Override
        public void exitModernMeterSymbolSign(skmParser.ModernMeterSymbolSignContext ctx) {
            super.exitModernMeterSymbolSign(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Modern meter symbol sign {0}", ctx.getText());

            IMeter meter;
            switch (ctx.getText()) {
                case "c":
                    meter = coreAbstractFactory.createCommonTime(null);
                    break;
                case "c|":
                    meter = coreAbstractFactory.createCutTime(null);
                    break;
                default:
                    throw createException("Unkown meter symbol: " + ctx.getText());
            }
            try {
                this.addItemToSpine(new SkmCoreSymbol(ctx.getText(), meter));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitMensuration(skmParser.MensurationContext ctx) {
            super.exitMensuration(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Mensuration {0}", ctx.getText());

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
            IMensuration mensurationObject = coreAbstractFactory.createMensuration(null, mensuration);
            try {
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), mensurationObject));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterMetronome(skmParser.MetronomeContext ctx) {
            super.enterMetronome(ctx);
            beginContext(ctx, new IMetronomeMarkBuilder(coreAbstractFactory));

        }

        @Override
        public void exitMetronome(skmParser.MetronomeContext ctx) {
            super.exitMetronome(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Metronome {0}", ctx.getText());

            try {
                IFigure figure = coreAbstractFactory.createFigure(null, EFigures.QUARTER);
                IMetronomeMarkValue metronomeMarkValue = coreAbstractFactory.createMetronomeMarkValue(null, Integer.parseInt(ctx.number().getText()));
                IMetronomeMark metronomeMark = coreAbstractFactory.createMetronomeMark(null, figure, null, metronomeMarkValue);
                addItemToSpine(new SkmCoreSymbol(ctx.getText(), metronomeMark));
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void exitNullInterpretation(skmParser.NullInterpretationContext ctx) {
            super.exitNullInterpretation(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Null interpretation {0}", ctx.getText());
        }

        @Override
        public void exitBarLineType(skmParser.BarLineTypeContext ctx) {
            super.exitBarLineType(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Bar line type {0}", ctx.getText());

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
            importingContexts.addObjectToPool(barlineType);
        }

        @Override
        public void enterBarline(skmParser.BarlineContext ctx) {
            super.enterBarline(ctx);
            beginContext(ctx, new IBarlineBuilder(coreAbstractFactory));
        }

        @Override
        public void exitBarline(skmParser.BarlineContext ctx) {
            super.exitBarline(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "BarLine {0}", ctx.getText());

            if (ctx.number() != null) {
                importingContexts.addObjectToPool(coreAbstractFactory.createNumber(null, Integer.parseInt(ctx.number().getText())));
            }

            endContextAndAddToSpine(ctx);
        }


        @Override
        public void exitPlaceHolder(skmParser.PlaceHolderContext ctx) {
            super.exitPlaceHolder(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Placeholder {0}", ctx.getText());
        }


        @Override
        public void enterMensuralDuration(skmParser.MensuralDurationContext ctx) {
            super.enterMensuralDuration(ctx);
        }

        @Override
        public void exitMensuralDot(skmParser.MensuralDotContext ctx) {
            super.exitMensuralDot(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Mensural dot {0}", ctx.getText());

            //lastAgumentationDots = ctx.augmentationDot()==null?0:ctx.augmentationDot().getChildCount();
        }

        @Override
        public void exitMensuralFigure(skmParser.MensuralFigureContext ctx) {
            super.exitMensuralFigure(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural figure {0}", ctx.getText());

            //TODO
        }


        @Override
        public void exitColoured(skmParser.ColouredContext ctx) {

            super.exitColoured(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural coloration {0}", ctx.getText());
          //  this.lastColoured = new SkmColoration();
        }

        @Override
        public void exitMensuralPerfection(skmParser.MensuralPerfectionContext ctx) {

            super.exitMensuralPerfection(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural perfection {0}", ctx.getText());
           /* try {
                this.lastPerfection = SkmPerfectionFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }

        @Override
        public void exitModernDuration(skmParser.ModernDurationContext ctx) {
            super.exitModernDuration(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Modern duration {0}", ctx.getText());

            // this durationalSingleBuilder will be the pointer to the restBuilder or the noteBuilder (see enterNote, enterRest)
            try {
                EFigures figure = EFigures.findMeterUnit(Integer.parseInt(ctx.getText()), ENotationTypes.eModern);
                importingContexts.addObjectToPool(figure);

                int augmentationDots = ctx.augmentationDot().size();
                IDots dots = coreAbstractFactory.createDots(null, augmentationDots);
                importingContexts.addObjectToPool(dots);
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterRest(skmParser.RestContext ctx) {
            super.enterRest(ctx);
            beginContext(ctx, new IRestBuilder(coreAbstractFactory));
        }


        @Override
        public void exitRest(skmParser.RestContext ctx) {
            super.exitRest(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Rest {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }

        @Override
        public void exitRestLinePosition(skmParser.RestLinePositionContext ctx) {
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Rest line position {0}", ctx.getText());

            //  this.lastRestLinePosition = Integer.parseInt(ctx.getChild(1).getText());
        }

        @Override
        public void exitFermata(skmParser.FermataContext ctx) {
            super.exitFermata(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Fermata {0}", ctx.getText());

            // lastFermata = new SkmFermata();
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

        @Override
        public void enterDiatonicPitchAndOctave(skmParser.DiatonicPitchAndOctaveContext ctx) {
            super.enterDiatonicPitchAndOctave(ctx);
            beginContext(ctx, new IDiatonicPitchBuilder(coreAbstractFactory));
        }

        @Override
        public void exitDiatonicPitchAndOctave(skmParser.DiatonicPitchAndOctaveContext ctx) {
            super.exitDiatonicPitchAndOctave(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Diatonic pitch and octave {0}", ctx.getText());

            endContext(ctx);
        }

        private void handleNoteName(String code, int octaveModif) {
            checkAllNoteNameEqual(code);

            importingContexts.addObjectToPool(coreAbstractFactory.createOctave(null, 4 + octaveModif));
            String noteName = code.substring(0, 1).toUpperCase();
            importingContexts.addObjectToPool(EDiatonicPitches.valueOf(noteName));
        }

        @Override
        public void exitTrebleNotes(skmParser.TrebleNotesContext ctx) {
            super.exitTrebleNotes(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "TrebleNotes {0}", ctx.getText());
            handleNoteName(ctx.getText(), ctx.getText().length() - 1);
        }

        @Override
        public void exitBassNotes(skmParser.BassNotesContext ctx) {
            super.exitBassNotes(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Bass notes {0}", ctx.getText());
            handleNoteName(ctx.getText(), -ctx.getText().length());
        }

        @Override
        public void enterNote(skmParser.NoteContext ctx) {
            beginContext(ctx, new INoteBuilder(coreAbstractFactory));
            this.importingContexts.begin("noteHead", new INoteHeadBuilder(coreAbstractFactory));
        }



        @Override
        public void exitNote(skmParser.NoteContext ctx) {
            super.exitNote(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Note {0}", ctx.getText());

            try {
                this.importingContexts.end("noteHead");
            } catch (IMException e) {
                throw createException(e);
            }
            endContextAndAddToSpine(ctx);
        }

        @Override
        public void exitStem(skmParser.StemContext ctx) {
            super.exitStem(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Stem {0}", ctx.getText());
            /*try {
                lastStemDirection = SkmStemFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }


        @Override
        public void enterChord(skmParser.ChordContext ctx) {
            super.enterChord(ctx);
            //chordNotes = new ArrayList<>();
        }

        @Override
        public void exitChord(skmParser.ChordContext ctx) {
            super.exitChord(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Chord {0}", ctx.getText());

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
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Alteration display {0}", ctx.getText());

            importingContexts.addObjectToPool(EAlterationDisplayTypes.valueOf(ctx.getText()));
        }

        @Override
        public void enterAlteration(skmParser.AlterationContext ctx) {
            super.enterAlteration(ctx);
            beginContext(ctx, new IAlterationBuilder(coreAbstractFactory));
        }

        @Override
        public void exitAlteration(skmParser.AlterationContext ctx) {
            super.enterAlteration(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Alteration {0}", ctx.getText());

            endContext(ctx);
        }

        @Override
        public void enterPitch(skmParser.PitchContext ctx) {
            super.enterPitch(ctx);
            beginContext(ctx, new IPitchBuilder(coreAbstractFactory));
        }

        @Override
        public void exitPitch(skmParser.PitchContext ctx) {
            super.exitPitch(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Pitch {0}", ctx.getText());

            endContext(ctx);
        }

        @Override
        public void enterCustos(skmParser.CustosContext ctx) {
            super.enterCustos(ctx);
            beginContext(ctx, new IPitchBuilder(coreAbstractFactory));
        }

        @Override
        public void exitCustos(skmParser.CustosContext ctx) {
            super.exitCustos(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Custos {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }


        @Override
        public void exitLyricsText(skmParser.LyricsTextContext ctx) {
            super.exitLyricsText(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Lyrics {0}", ctx.getText());

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
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Graphical token {0}", ctx.getText());

            // TODO
            /*if (associatedIDS != null && !associatedIDS.isEmpty()) {
                skmMatrix.associateIDSToLastItem(associatedIDS);
            }*/
        }

        @Override
        public void exitPlainChant(skmParser.PlainChantContext ctx) {
            super.exitPlainChant(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Plain chant {0}", ctx.getText());

            // TODO
        }

        @Override
        public void exitSpineTerminator(skmParser.SpineTerminatorContext ctx) {
            super.exitSpineTerminator(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine terminator {0}", ctx.getText());

            // throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }

        @Override
        public void exitSpineAdd(skmParser.SpineAddContext ctx) {
            super.exitSpineAdd(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine add {0}", ctx.getText());

            throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }

        @Override
        public void exitSpineSplit(skmParser.SpineSplitContext ctx) {
            super.exitSpineSplit(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine split {0}", ctx.getText());

            throw new UnsupportedOperationException("TODO"); //TODO operaciones spine
        }

        @Override
        public void exitSpineJoin(skmParser.SpineJoinContext ctx) {
            super.exitSpineJoin(ctx);
            Logger.getLogger(SkmSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine join {0}", ctx.getText());

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
