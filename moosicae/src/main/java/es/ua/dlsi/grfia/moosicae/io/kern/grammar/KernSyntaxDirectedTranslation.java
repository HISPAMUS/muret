package es.ua.dlsi.grfia.moosicae.io.kern.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
import es.ua.dlsi.grfia.moosicae.core.mensural.IMensuration;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IMetronomeMarkValue;
import es.ua.dlsi.grfia.moosicae.core.properties.IStem;
import es.ua.dlsi.grfia.moosicae.io.ImportingContexts;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.builders.KernMeterBuilder;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.*;
import es.ua.dlsi.grfia.moosicae.io.kern.kernLexer;
import es.ua.dlsi.grfia.moosicae.io.kern.kernParser;
import es.ua.dlsi.grfia.moosicae.io.kern.kernParserBaseListener;
import es.ua.dlsi.grfia.moosicae.utils.MathUtils;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ANTLRUtils;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ErrorListener;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.GrammarParseRuntimeException;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ParseError;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * It translates from **kern to a directed acyclic graph of symbols using a syntax driven translation technique
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernSyntaxDirectedTranslation {
    private final ICoreAbstractFactory coreAbstractFactory;
    private boolean debug;

    public KernSyntaxDirectedTranslation(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    public static class Loader extends kernParserBaseListener {
        private boolean debug;
        private final Parser parser;
        private KernDocument kernDocument;
        private final ICoreAbstractFactory coreAbstractFactory;
        private int spineIndex;
        private int row;
        /**
         * This array should maintain the spine count including spine splits, joins, etc...
         */
        private ArrayList<KernToken> lastSpineInsertedItem;

        protected ImportingContexts<IMooObject> importingContexts;

        public Loader(Parser parser, boolean debug, ICoreAbstractFactory coreAbstractFactory) {
            this.debug = debug;
            this.parser = parser;
            this.kernDocument = new KernDocument();
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

        private KernToken getLastItemForCurrentSpine() {
            if (this.spineIndex >= this.lastSpineInsertedItem.size()) {
                throw new GrammarParseRuntimeException("The current spine index is " + this.spineIndex
                        + " and the lastSpineInsertedItem array has " + lastSpineInsertedItem.size() + " elements");
            }
            return this.lastSpineInsertedItem.get(this.spineIndex);
        }

        private void addItemToSpine(KernToken kernToken) {
            try {
                KernToken previous = getLastItemForCurrentSpine();
                this.kernDocument.add(previous, kernToken);
                this.lastSpineInsertedItem.set(this.spineIndex, kernToken);
            } catch (IMException e) {
                createException(e);
            }
        }


        private void addItemToSpineAndRemoveFromContext(IMooObject symbol, String encoding) {
            try {
                KernToken previous = getLastItemForCurrentSpine();
                KernCoreSymbol coreSymbolToken = new KernCoreSymbol(encoding, symbol);
                this.kernDocument.add(previous, coreSymbolToken);
                this.lastSpineInsertedItem.set(this.spineIndex, coreSymbolToken);
                this.importingContexts.removeObjectFromPool(symbol); // it has already been used
            } catch (IMException e) {
                createException(e);
            }
        }


        private void beginContext(RuleContext ruleContext, IObjectBuilder<? extends IMooObject> builder) {
            this.importingContexts.begin(ruleContext.getClass().getName(), builder);
        }

        private void beginContext(String name, IObjectBuilder<? extends IMooObject> builder) {
            this.importingContexts.begin(name, builder);
        }

        private void beginEndContext(RuleContext ruleContext, IObjectBuilder<? extends IMooObject> builder, Object ... objects) {
            try {
                this.importingContexts.beginEnd(builder, objects);
            } catch (Throwable e) {
                throw createException("RuleContext " + ruleContext.getClass().getName(), e);
            }
        }

        private IMooObject endContext(RuleContext ruleContext) {
            try {
                return this.importingContexts.end(ruleContext.getClass().getName());
            } catch (Throwable e) {
                throw createException("RuleContext " + ruleContext.getClass().getName(), e);
            }
        }

        private IMooObject endContext(String name) {
            try {
                return this.importingContexts.end(name);
            } catch (Throwable e) {
                throw createException("RuleContext " + name, e);
            }
        }
        private IMooObject endContextAndAddToSpine(RuleContext ruleContext)  {
            try {
                IMooObject mooObject = endContext(ruleContext);
                this.addItemToSpineAndRemoveFromContext(mooObject, ruleContext.getText());
                return mooObject;
            } catch (Throwable e) {
                throw createException("RuleContext " + ruleContext.getClass().getName(), e);
            }
        }

        private IMooObject endContextAndAddToSpine(String contextName, String encoding) {
            try {
                IMooObject mooObject = this.importingContexts.end(contextName);
                this.addItemToSpineAndRemoveFromContext(mooObject, encoding);
                return mooObject;
            } catch (Throwable e) {
                throw createException("RuleContext " + contextName, e);
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
        public void exitHeaderField(kernParser.HeaderFieldContext ctx) {
            super.exitHeaderField(ctx);

            KernHeader headerToken = KernHeader.parse(ctx.getText().substring(2)); // remove the first **
            try {
                kernDocument.addHeader(headerToken);
            } catch (IMException e) {
                throw createException(e);
            }
            lastSpineInsertedItem.add(headerToken);
        }

        @Override
        public void enterPart(kernParser.PartContext ctx) {
            super.enterPart(ctx);
        }

        @Override
        public void exitPart(kernParser.PartContext ctx) {
            super.exitPart(ctx);

            int number = Integer.parseInt(ctx.number().getText());
            KernPart partNumber = new KernPart(ctx.getText(), number);
            addItemToSpine(partNumber);
        }

        @Override
        public void enterRecord(kernParser.RecordContext ctx) {
            super.enterRecord(ctx);
            this.spineIndex = 0;
        }

        @Override
        public void exitRecord(kernParser.RecordContext ctx) {
            super.exitRecord(ctx);
            this.row ++;
        }

        @Override
        public void enterHeaderField(kernParser.HeaderFieldContext ctx) {
            super.enterHeaderField(ctx);
        }

        @Override
        public void exitField(kernParser.FieldContext ctx) {
            super.exitField(ctx);
            this.spineIndex ++;
        }

        @Override
        public void exitInstrument(kernParser.InstrumentContext ctx) {
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Instrument {0}", ctx.getText());
            super.exitInstrument(ctx);

            String name;
            if (ctx.getText().startsWith("I\"")) { // I"name
                name = ctx.getText().substring(3);
            } else { // Iname
                name = ctx.getText().substring(2);
            }
            KernInstrument kernInstrument = new KernInstrument(ctx.getText(), name);
            addItemToSpine(kernInstrument);
        }

        @Override
        public void exitStaff(kernParser.StaffContext ctx) {
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Staff {0}", ctx.getText());
            super.exitStaff(ctx);

            int number = Integer.parseInt(ctx.number(0).getText()); // TODO - cuando encontramos staff1/2
            KernStaff staffNumber = new KernStaff(ctx.getText(), number);
            addItemToSpine(staffNumber);
        }


        @Override
        public void enterClef(kernParser.ClefContext ctx) {
            super.enterClef(ctx);
            beginContext(ctx, new IClefBuilder(coreAbstractFactory));
        }

        @Override
        public void exitClef(kernParser.ClefContext ctx) {
            super.exitClef(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }

        @Override
        public void exitClefSign(kernParser.ClefSignContext ctx) {
            super.exitClefSign(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void exitClefLine(kernParser.ClefLineContext ctx) {
            super.exitClefLine(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Clef line {0}", ctx.getText());

            beginEndContext(ctx, new IClefLineBuilder(coreAbstractFactory), Integer.parseInt(ctx.getText()));
        }

        @Override
        public void exitClefOctave(kernParser.ClefOctaveContext ctx) {
            super.exitClefOctave(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void exitAccidental(kernParser.AccidentalContext ctx) {
            super.exitAccidental(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void enterPitchClass(kernParser.PitchClassContext ctx) {
            super.enterPitchClass(ctx);
            beginContext(ctx, new IPitchClassBuilder(coreAbstractFactory));
        }


        @Override
        public void exitPitchClass(kernParser.PitchClassContext ctx) {
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Pitch class {0}", ctx.getText());

            importingContexts.addObjectToPool(coreAbstractFactory.createDiatonicPitch(null, EDiatonicPitches.valueOf(ctx.lowerCasePitch().getText().toUpperCase())));
            endContext(ctx);
        }

        @Override
        public void enterKeySignature(kernParser.KeySignatureContext ctx) {
            super.enterKeySignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Beginning a key",
                    ctx.getText());

            beginContext(ctx, new IUnconventionalKeySignatureBuilder(coreAbstractFactory));
        }

        @Override
        public void exitKeySignature(kernParser.KeySignatureContext ctx) {
            super.exitKeySignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Key signature {0}", ctx.getText());

            // if it is conventional, it is converted in the KernDocument2IScore
            endContextAndAddToSpine(ctx);
        }

        @Override
        public void exitKeySignatureCancel(kernParser.KeySignatureCancelContext ctx) {
            super.exitKeySignatureCancel(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Key signature {0}", ctx.getText());

            importingContexts.addObjectToPool(coreAbstractFactory.createCautionaryKeySignatureAccidentals(null, true));
        }

        @Override
        public void enterKeyMode(kernParser.KeyModeContext ctx) {
            super.exitKeyMode(ctx);
            beginContext(ctx, new IModeBuilder(coreAbstractFactory));
            this.beginContext("pitchClass", new IPitchClassBuilder(coreAbstractFactory));
        }

        @Override
        public void exitKeyMode(kernParser.KeyModeContext ctx) {
            super.exitKeyMode(ctx);
            endContext("pitchClass");
            endContext(ctx);
        }

        @Override
        public void exitMajorKey(kernParser.MajorKeyContext ctx) {
            super.exitMajorKey(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Major key {0}", ctx.getText());

            importingContexts.addObjectToPool(EModes.major);
            importingContexts.addObjectToPool(EDiatonicPitches.valueOf(ctx.upperCasePitch().getText().toUpperCase()));
        }

        @Override
        public void exitMinorKey(kernParser.MinorKeyContext ctx) {
            super.exitMinorKey(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Minor key {0}", ctx.getText());

            importingContexts.addObjectToPool(EModes.minor);
            importingContexts.addObjectToPool(EDiatonicPitches.valueOf(ctx.lowerCasePitch().getText().toUpperCase()));
        }

        @Override
        public void enterKey(kernParser.KeyContext ctx) {
            super.enterKey(ctx);
            beginContext(ctx, new IKeyBuilder(coreAbstractFactory));
        }

        @Override
        public void exitKey(kernParser.KeyContext ctx) {
            super.exitKey(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Key {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }

        @Override
        public void enterAdditiveTimeSignature(kernParser.AdditiveTimeSignatureContext ctx) {
            super.enterAdditiveTimeSignature(ctx);
            beginContext(ctx, new IAdditiveMeterBuilder(coreAbstractFactory));
        }

        @Override
        public void exitAdditiveTimeSignature(kernParser.AdditiveTimeSignatureContext ctx) {
            super.exitAdditiveTimeSignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Additive time signature {0}", ctx.getText());
            endContext(ctx);
        }

        @Override
        public void enterMixedTimeSignature(kernParser.MixedTimeSignatureContext ctx) {
            super.enterMixedTimeSignature(ctx);
            beginContext(ctx, new IMixedMeterBuilder(coreAbstractFactory));
        }

        @Override
        public void exitMixedTimeSignature(kernParser.MixedTimeSignatureContext ctx) {
            super.exitMixedTimeSignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Mixed time signature {0}", ctx.getText());
            endContext(ctx);
        }

        @Override
        public void enterAlternatingTimeSignature(kernParser.AlternatingTimeSignatureContext ctx) {
            super.enterAlternatingTimeSignature(ctx);
            beginContext(ctx, new IAlternatingMeterBuilder(coreAbstractFactory));
        }

        @Override
        public void exitAlternatingTimeSignature(kernParser.AlternatingTimeSignatureContext ctx) {
            super.exitAlternatingTimeSignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Alternating time signature {0}", ctx.getText());
            endContext(ctx);
        }


        @Override
        public void enterInterchangingTimeSignature(kernParser.InterchangingTimeSignatureContext ctx) {
            super.enterInterchangingTimeSignature(ctx);
            beginContext(ctx, new IInterchangingMeterBuilder(coreAbstractFactory));
        }

        @Override
        public void exitInterchangingTimeSignature(kernParser.InterchangingTimeSignatureContext ctx) {
            super.exitInterchangingTimeSignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Interchanging time signature {0}", ctx.getText());
            endContext(ctx);
        }

        @Override
        public void enterStandardTimeSignature(kernParser.StandardTimeSignatureContext ctx) {
            super.enterStandardTimeSignature(ctx);
            beginContext(ctx, new IStandardTimeSignatureBuilder(coreAbstractFactory));
        }

        @Override
        public void exitStandardTimeSignature(kernParser.StandardTimeSignatureContext ctx) {
            super.exitStandardTimeSignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Time signature {0}", ctx.getText());

            endContext(ctx);
        }

        @Override
        public void enterStem(kernParser.StemContext ctx) {
            super.enterStem(ctx);

            IStem stem = null;
            if (ctx.SLASH() != null) {
                stem = coreAbstractFactory.createStem(null, EStemDirection.up);
            } else if (ctx.BACKSLASH() != null) {
                stem = coreAbstractFactory.createStem(null, EStemDirection.down);
            } else {
                createException("Invalid stem: " + ctx.getText());
            }
            importingContexts.addObjectToPool(stem);
        }

        @Override
        public void exitStem(kernParser.StemContext ctx) {
            super.exitStem(ctx);
        }
        @Override
        public void enterTimeSignature(kernParser.TimeSignatureContext ctx) {
            super.enterTimeSignature(ctx);
            beginContext(ctx, new KernMeterBuilder(coreAbstractFactory));
        }


        @Override
        public void exitTimeSignature(kernParser.TimeSignatureContext ctx) {
            super.exitTimeSignature(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Time signature {0}", ctx.getText());
            endContextAndAddToSpine(ctx); // it will contain any of the meter types (standard, mixed...)
        }

        @Override
        public void exitNumerator(kernParser.NumeratorContext ctx) {
            super.exitNumerator(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Numerator {0}", ctx.getText());

            this.importingContexts.addObjectToPool(coreAbstractFactory.createTimeSignatureNumerator(null, Integer.parseInt(ctx.getText())));
        }

        @Override
        public void exitDenominator(kernParser.DenominatorContext ctx) {
            super.exitDenominator(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Denominator {0}", ctx.getText());

            this.importingContexts.addObjectToPool(coreAbstractFactory.createTimeSignatureDenominator(null, Integer.parseInt(ctx.getText())));
        }

        @Override
        public void exitModernMeterSymbolSign(kernParser.ModernMeterSymbolSignContext ctx) {
            super.exitModernMeterSymbolSign(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
            this.addItemToSpineAndRemoveFromContext(meter, ctx.getText());
        }

        @Override
        public void exitMensuration(kernParser.MensurationContext ctx) {
            super.exitMensuration(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
            addItemToSpineAndRemoveFromContext(mensurationObject, ctx.getText());
        }

        @Override
        public void enterMetronome(kernParser.MetronomeContext ctx) {
            super.enterMetronome(ctx);
            beginContext(ctx, new IMetronomeMarkBuilder(coreAbstractFactory));

        }

        @Override
        public void exitMetronome(kernParser.MetronomeContext ctx) {
            super.exitMetronome(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Metronome {0}", ctx.getText());

            IFigure figure = coreAbstractFactory.createFigure(null, EFigures.QUARTER);
            // TO-DO ¿Cogemos números reales?
            IMetronomeMarkValue metronomeMarkValue = coreAbstractFactory.createMetronomeMarkValue(null, Integer.parseInt(ctx.number(0).getText()));
            IMetronomeMark metronomeMark = coreAbstractFactory.createMetronomeMark(null, figure, null, metronomeMarkValue);
            addItemToSpineAndRemoveFromContext(metronomeMark, ctx.getText());
        }

        @Override
        public void exitNullInterpretation(kernParser.NullInterpretationContext ctx) {
            super.exitNullInterpretation(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Null interpretation {0}", ctx.getText());
        }

        @Override
        public void exitBarLineType(kernParser.BarLineTypeContext ctx) {
            super.exitBarLineType(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void enterBarline(kernParser.BarlineContext ctx) {
            super.enterBarline(ctx);
            beginContext(ctx, new IBarlineBuilder(coreAbstractFactory));
        }

        @Override
        public void exitBarline(kernParser.BarlineContext ctx) {
            super.exitBarline(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "BarLine {0}", ctx.getText());

            if (ctx.number() != null) {
                importingContexts.addObjectToPool(coreAbstractFactory.createNumber(null, Integer.parseInt(ctx.number().getText())));
            }

            endContextAndAddToSpine(ctx);
        }


        @Override
        public void exitPlaceHolder(kernParser.PlaceHolderContext ctx) {
            super.exitPlaceHolder(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Placeholder {0}", ctx.getText());
        }


        @Override
        public void enterMensuralDuration(kernParser.MensuralDurationContext ctx) {
            super.enterMensuralDuration(ctx);
        }

        @Override
        public void exitMensuralDot(kernParser.MensuralDotContext ctx) {
            super.exitMensuralDot(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Mensural dot {0}", ctx.getText());

            //lastAgumentationDots = ctx.augmentationDot()==null?0:ctx.augmentationDot().getChildCount();
        }

        @Override
        public void exitMensuralFigure(kernParser.MensuralFigureContext ctx) {
            super.exitMensuralFigure(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural figure {0}", ctx.getText());

            //TODO
        }


        @Override
        public void exitColoured(kernParser.ColouredContext ctx) {

            super.exitColoured(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural coloration {0}", ctx.getText());
          //  this.lastColoured = new SkmColoration();
        }

        @Override
        public void exitMensuralPerfection(kernParser.MensuralPerfectionContext ctx) {

            super.exitMensuralPerfection(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Mensural perfection {0}", ctx.getText());
           /* try {
                this.lastPerfection = SkmPerfectionFactory.getInstance().create(ctx.getText());
            } catch (IM4Exception e) {
                throw new GrammarParseRuntimeException(e);
            }*/
        }

        @Override
        public void exitModernDuration(kernParser.ModernDurationContext ctx) {
            super.exitModernDuration(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Modern duration {0}", ctx.getText());

            // this durationalSingleBuilder will be the pointer to the restBuilder or the noteBuilder (see enterNote, enterRest)
            try {
                Integer durationValue = Integer.parseInt(ctx.number(0).getText()); //TODO segundo nº (p.ej. 40%3)
                if (!MathUtils.isPowerOfTwo(durationValue)) {
                    throw new UnsupportedOperationException("Tuplets not supported yet"); //TODO Tuplets
                }
                EFigures figure = EFigures.findMeterUnit(durationValue, ENotationTypes.eModern);
                importingContexts.addObjectToPool(figure);

                int augmentationDots = ctx.augmentationDot().size();
                if (augmentationDots > 0) {
                    IDots dots = coreAbstractFactory.createDots(null, augmentationDots);
                    importingContexts.addObjectToPool(dots);
                }
            } catch (IMException e) {
                throw createException(e);
            }
        }

        @Override
        public void enterRest(kernParser.RestContext ctx) {
            super.enterRest(ctx);
            if (ctx.CHAR_r(1) != null) { // if second r --> whole measure rest
                this.beginContext("wholeMeasureRest", new IWholeMeasureRestBuilder(coreAbstractFactory));
                // the rest will be embedded inside the whole note rest
            }
            this.beginContext("rest", new IRestBuilder(coreAbstractFactory));
        }


        @Override
        public void exitRest(kernParser.RestContext ctx) {
            super.exitRest(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Rest {0}", ctx.getText());
            try {
                if (ctx.CHAR_r(1) != null) { // if second r --> whole measure rest
                    endContext("rest");
                    this.endContextAndAddToSpine("wholeMeasureRest", ctx.getText());
                } else {
                    endContextAndAddToSpine("rest", ctx.getText());
                }
            } catch (Exception e) {
                createException(e);
            }
        }

        /*2020 @Override
        public void exitRestLinePosition(kernParser.RestLinePositionContext ctx) {
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Rest line position {0}", ctx.getText());

            //  this.lastRestLinePosition = Integer.parseInt(ctx.getChild(1).getText());
        }*/

        @Override
        public void exitFermata(kernParser.FermataContext ctx) {
            super.exitFermata(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void enterDiatonicPitchAndOctave(kernParser.DiatonicPitchAndOctaveContext ctx) {
            super.enterDiatonicPitchAndOctave(ctx);
            beginContext(ctx, new IDiatonicPitchBuilder(coreAbstractFactory));
        }

        @Override
        public void exitDiatonicPitchAndOctave(kernParser.DiatonicPitchAndOctaveContext ctx) {
            super.exitDiatonicPitchAndOctave(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void exitTrebleNotes(kernParser.TrebleNotesContext ctx) {
            super.exitTrebleNotes(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "TrebleNotes {0}", ctx.getText());
            handleNoteName(ctx.getText(), ctx.getText().length() - 1);
        }

        @Override
        public void exitBassNotes(kernParser.BassNotesContext ctx) {
            super.exitBassNotes(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Bass notes {0}", ctx.getText());
            handleNoteName(ctx.getText(), -ctx.getText().length());
        }

        @Override
        public void enterNote(kernParser.NoteContext ctx) {
            beginContext(ctx, new INoteBuilder(coreAbstractFactory));
            beginContext("noteHead", new INoteHeadBuilder(coreAbstractFactory));
        }


        /**
         * Notes are explicitly added to the spine. The KernDocument2IScore will group them.
         * For a 4 notes beam group, the KernDocument graph will contain:
         * - beamgroup start token containing the note #1
         * - note #2
         * - note #3
         * - beamgroup end token containing the note #4
         */
        @Override
        public void exitNote(kernParser.NoteContext ctx) {
            super.exitNote(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST, "Note {0}", ctx.getText());

            this.endContext("noteHead");

            IMooObject note = endContext(ctx);

            EKernBeamType beamType = null;
            Integer beamCount = null;
            if (ctx.afterNote().beam() != null && !ctx.afterNote().beam().isEmpty()) {
                kernParser.BeamContext beam = ctx.afterNote().beam().get(0);
                if (beam.CHAR_L() != null && !beam.CHAR_L().isEmpty()) {
                    beamType = EKernBeamType.beamStart;
                    beamCount = ctx.afterNote().beam().get(0).CHAR_L().size();
                } else if (beam.CHAR_J() != null && !beam.CHAR_J().isEmpty()) {
                    beamType = EKernBeamType.beamEnd;
                    beamCount = ctx.afterNote().beam().get(0).CHAR_J().size();
                } else if (beam.CHAR_K() != null && !beam.CHAR_K().isEmpty()) {
                    beamType = EKernBeamType.partialBeamExtendingRight;
                    beamCount = ctx.afterNote().beam().get(0).CHAR_K().size();
                } else if (beam.CHAR_k() != null && !beam.CHAR_k().isEmpty()) {
                    beamType = EKernBeamType.partialBeamExtendingLeft;
                    beamCount = ctx.afterNote().beam().get(0).CHAR_k().size();
                }
            }

            if (beamType != null) {
                addItemToSpine(new KernBeamedNote(ctx.getText(), note, beamType, beamCount));
            } else {
                addItemToSpineAndRemoveFromContext(note, ctx.getText());
            }
        }


        @Override
        public void enterChord(kernParser.ChordContext ctx) {
            super.enterChord(ctx);
            //chordNotes = new ArrayList<>();
        }

        @Override
        public void exitChord(kernParser.ChordContext ctx) {
            super.exitChord(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
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
        public void exitAlterationDisplay(kernParser.AlterationDisplayContext ctx) {
            super.exitAlterationDisplay(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Alteration display {0}", ctx.getText());

            importingContexts.addObjectToPool(EAlterationDisplayTypes.valueOf(ctx.getText()));
        }

        @Override
        public void enterAlteration(kernParser.AlterationContext ctx) {
            super.enterAlteration(ctx);
            beginContext(ctx, new IAlterationBuilder(coreAbstractFactory));
        }

        @Override
        public void exitAlteration(kernParser.AlterationContext ctx) {
            super.enterAlteration(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Alteration {0}", ctx.getText());

            endContext(ctx);
        }

        @Override
        public void enterPitch(kernParser.PitchContext ctx) {
            super.enterPitch(ctx);
            beginContext(ctx, new IPitchBuilder(coreAbstractFactory));
        }

        @Override
        public void exitPitch(kernParser.PitchContext ctx) {
            super.exitPitch(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Pitch {0}", ctx.getText());

            endContext(ctx);
        }

        @Override
        public void enterCustos(kernParser.CustosContext ctx) {
            super.enterCustos(ctx);
            beginContext(ctx, new IPitchBuilder(coreAbstractFactory));
        }

        @Override
        public void exitCustos(kernParser.CustosContext ctx) {
            super.exitCustos(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Custos {0}", ctx.getText());

            endContextAndAddToSpine(ctx);
        }


        /*2021 @Override
        public void exitLyricsText(kernParser.LyricsTextContext ctx) {
            super.exitLyricsText(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Lyrics {0}", ctx.getText());

            //addItemToSpine(new SkmLyrics(ctx.getText()));
        }*/

        @Override
        public void enterGraphicalToken(kernParser.GraphicalTokenContext ctx) {
            super.enterGraphicalToken(ctx);
            // associatedIDS = null;
        }

        @Override
        public void enterAssociatedIDS(kernParser.AssociatedIDSContext ctx) {
            super.enterAssociatedIDS(ctx);
           /* if (this.associatedIDS == null) {
                this.associatedIDS = new ArrayList<>();
            }
            this.associatedIDS.add(Long.parseLong(ctx.number().getText()));*/

            //TODO - mejor una spine para los IDS
        }

        @Override
        public void exitGraphicalToken(kernParser.GraphicalTokenContext ctx) {
            super.exitGraphicalToken(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Graphical token {0}", ctx.getText());

            // TODO
            /*if (associatedIDS != null && !associatedIDS.isEmpty()) {
                kernMatrix.associateIDSToLastItem(associatedIDS);
            }*/
        }

        @Override
        public void exitPlainChant(kernParser.PlainChantContext ctx) {
            super.exitPlainChant(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Plain chant {0}", ctx.getText());

            // TODO
        }

        @Override
        public void exitSpineTerminator(kernParser.SpineTerminatorContext ctx) {
            super.exitSpineTerminator(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine terminator {0}", ctx.getText());

            addItemToSpine(new KernSpineTerminate(ctx.getText()));
        }

        @Override
        public void exitSpineAdd(kernParser.SpineAddContext ctx) {
            super.exitSpineAdd(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine add {0}", ctx.getText());

            addItemToSpine(new KernSpineAdd(ctx.getText()));
        }

        @Override
        public void exitSpineSplit(kernParser.SpineSplitContext ctx) {
            super.exitSpineSplit(ctx);
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.FINEST,
                    "Spine split {0}", ctx.getText());

            try {
                KernSpineSplit spineSplit = new KernSpineSplit(ctx.getText());

                KernToken previous = getLastItemForCurrentSpine();
                KernSpineBegin spineBegin = this.kernDocument.addSplitSpine(previous, spineSplit);

                // now set two parallel spines - the previous one and a new one
                lastSpineInsertedItem.set(this.spineIndex, spineSplit);
                lastSpineInsertedItem.add(spineBegin);
            } catch (IMException e) {
                createException(e);
            }

        }

    }

    private KernDocument importKern(CharStream input, String inputDescription) throws IMException {
        ErrorListener errorListener = new ErrorListener();
        try {
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.INFO, "Parsing {0}", inputDescription);

            kernLexer lexer = new kernLexer(input);

            if (debug) {
                new ANTLRUtils().printLexer(lexer);
            }

            lexer.addErrorListener(errorListener);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            kernParser parser = new kernParser(tokens);
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.start();
            ParseTreeWalker walker = new ParseTreeWalker();
            Loader loader = new Loader(parser, debug, coreAbstractFactory);
            walker.walk(loader, tree);
            if (errorListener.getNumberErrorsFound() != 0) {
                throw new IMException(errorListener.getNumberErrorsFound() + " errors found in "
                        + inputDescription + "\n" + errorListener.toString());
            }

            return loader.kernDocument;
        } catch (Throwable e) {
            e.printStackTrace();
            Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(KernSyntaxDirectedTranslation.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
            }

            throw new IMException(e.getMessage());
        }

    }

    public KernDocument importKern(File file) throws IMException {
        try {
            CharStream input = CharStreams.fromFileName(file.getAbsolutePath());
            return importKern(input, file.getAbsolutePath());
        } catch (IOException e) {
            throw new IMException(e);
        }
    }

    public KernDocument importKern(InputStream stream) throws IMException {
        try {
            CharStream input = CharStreams.fromStream(stream);
            return importKern(input, "Stream");
        } catch (IOException e) {
            throw new IMException(e);
        }
    }

    public KernDocument importKern(String string) throws IMException {
        CharStream input = CharStreams.fromString(string);
        return importKern(input, string);
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
