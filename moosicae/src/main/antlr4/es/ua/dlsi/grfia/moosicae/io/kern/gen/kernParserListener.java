// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/moosicae/src/main/antlr4/es/ua/dlsi/grfia/moosicae/io/kern/kernParser.g4 by ANTLR 4.8


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link kernParser}.
 */
public interface kernParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link kernParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(kernParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(kernParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#eol}.
	 * @param ctx the parse tree
	 */
	void enterEol(kernParser.EolContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#eol}.
	 * @param ctx the parse tree
	 */
	void exitEol(kernParser.EolContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(kernParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(kernParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#headerField}.
	 * @param ctx the parse tree
	 */
	void enterHeaderField(kernParser.HeaderFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#headerField}.
	 * @param ctx the parse tree
	 */
	void exitHeaderField(kernParser.HeaderFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(kernParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(kernParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tab}.
	 * @param ctx the parse tree
	 */
	void enterTab(kernParser.TabContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tab}.
	 * @param ctx the parse tree
	 */
	void exitTab(kernParser.TabContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(kernParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(kernParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(kernParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(kernParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#associatedIDS}.
	 * @param ctx the parse tree
	 */
	void enterAssociatedIDS(kernParser.AssociatedIDSContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#associatedIDS}.
	 * @param ctx the parse tree
	 */
	void exitAssociatedIDS(kernParser.AssociatedIDSContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#placeHolder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceHolder(kernParser.PlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#placeHolder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceHolder(kernParser.PlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#graphicalToken}.
	 * @param ctx the parse tree
	 */
	void enterGraphicalToken(kernParser.GraphicalTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#graphicalToken}.
	 * @param ctx the parse tree
	 */
	void exitGraphicalToken(kernParser.GraphicalTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterTandemInterpretation(kernParser.TandemInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitTandemInterpretation(kernParser.TandemInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(kernParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(kernParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 */
	void enterLowerCasePitch(kernParser.LowerCasePitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 */
	void exitLowerCasePitch(kernParser.LowerCasePitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#upperCasePitch}.
	 * @param ctx the parse tree
	 */
	void enterUpperCasePitch(kernParser.UpperCasePitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#upperCasePitch}.
	 * @param ctx the parse tree
	 */
	void exitUpperCasePitch(kernParser.UpperCasePitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#pitchClass}.
	 * @param ctx the parse tree
	 */
	void enterPitchClass(kernParser.PitchClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#pitchClass}.
	 * @param ctx the parse tree
	 */
	void exitPitchClass(kernParser.PitchClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(kernParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(kernParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#staff}.
	 * @param ctx the parse tree
	 */
	void enterStaff(kernParser.StaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#staff}.
	 * @param ctx the parse tree
	 */
	void exitStaff(kernParser.StaffContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#clef}.
	 * @param ctx the parse tree
	 */
	void enterClef(kernParser.ClefContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#clef}.
	 * @param ctx the parse tree
	 */
	void exitClef(kernParser.ClefContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#clefValue}.
	 * @param ctx the parse tree
	 */
	void enterClefValue(kernParser.ClefValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#clefValue}.
	 * @param ctx the parse tree
	 */
	void exitClefValue(kernParser.ClefValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#clefSign}.
	 * @param ctx the parse tree
	 */
	void enterClefSign(kernParser.ClefSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#clefSign}.
	 * @param ctx the parse tree
	 */
	void exitClefSign(kernParser.ClefSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void enterClefLine(kernParser.ClefLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void exitClefLine(kernParser.ClefLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#clefOctave}.
	 * @param ctx the parse tree
	 */
	void enterClefOctave(kernParser.ClefOctaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#clefOctave}.
	 * @param ctx the parse tree
	 */
	void exitClefOctave(kernParser.ClefOctaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keySignature}.
	 * @param ctx the parse tree
	 */
	void enterKeySignature(kernParser.KeySignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keySignature}.
	 * @param ctx the parse tree
	 */
	void exitKeySignature(kernParser.KeySignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keySignaturePitchClass}.
	 * @param ctx the parse tree
	 */
	void enterKeySignaturePitchClass(kernParser.KeySignaturePitchClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keySignaturePitchClass}.
	 * @param ctx the parse tree
	 */
	void exitKeySignaturePitchClass(kernParser.KeySignaturePitchClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keySignatureCancel}.
	 * @param ctx the parse tree
	 */
	void enterKeySignatureCancel(kernParser.KeySignatureCancelContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keySignatureCancel}.
	 * @param ctx the parse tree
	 */
	void exitKeySignatureCancel(kernParser.KeySignatureCancelContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#keyMode}.
	 * @param ctx the parse tree
	 */
	void enterKeyMode(kernParser.KeyModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#keyMode}.
	 * @param ctx the parse tree
	 */
	void exitKeyMode(kernParser.KeyModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(kernParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(kernParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void enterMinorKey(kernParser.MinorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void exitMinorKey(kernParser.MinorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void enterMajorKey(kernParser.MajorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void exitMajorKey(kernParser.MajorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#timeSignature}.
	 * @param ctx the parse tree
	 */
	void enterTimeSignature(kernParser.TimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#timeSignature}.
	 * @param ctx the parse tree
	 */
	void exitTimeSignature(kernParser.TimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#numerator}.
	 * @param ctx the parse tree
	 */
	void enterNumerator(kernParser.NumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#numerator}.
	 * @param ctx the parse tree
	 */
	void exitNumerator(kernParser.NumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#denominator}.
	 * @param ctx the parse tree
	 */
	void enterDenominator(kernParser.DenominatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#denominator}.
	 * @param ctx the parse tree
	 */
	void exitDenominator(kernParser.DenominatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#standardTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterStandardTimeSignature(kernParser.StandardTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#standardTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitStandardTimeSignature(kernParser.StandardTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#additiveTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveTimeSignature(kernParser.AdditiveTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#additiveTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveTimeSignature(kernParser.AdditiveTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mixedTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterMixedTimeSignature(kernParser.MixedTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mixedTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitMixedTimeSignature(kernParser.MixedTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#alternatingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterAlternatingTimeSignature(kernParser.AlternatingTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#alternatingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitAlternatingTimeSignature(kernParser.AlternatingTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#alternatingTimeSignatureItem}.
	 * @param ctx the parse tree
	 */
	void enterAlternatingTimeSignatureItem(kernParser.AlternatingTimeSignatureItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#alternatingTimeSignatureItem}.
	 * @param ctx the parse tree
	 */
	void exitAlternatingTimeSignatureItem(kernParser.AlternatingTimeSignatureItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#interchangingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterInterchangingTimeSignature(kernParser.InterchangingTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#interchangingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitInterchangingTimeSignature(kernParser.InterchangingTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#meterSymbol}.
	 * @param ctx the parse tree
	 */
	void enterMeterSymbol(kernParser.MeterSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#meterSymbol}.
	 * @param ctx the parse tree
	 */
	void exitMeterSymbol(kernParser.MeterSymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#modernMeterSymbolSign}.
	 * @param ctx the parse tree
	 */
	void enterModernMeterSymbolSign(kernParser.ModernMeterSymbolSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#modernMeterSymbolSign}.
	 * @param ctx the parse tree
	 */
	void exitModernMeterSymbolSign(kernParser.ModernMeterSymbolSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mensuration}.
	 * @param ctx the parse tree
	 */
	void enterMensuration(kernParser.MensurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mensuration}.
	 * @param ctx the parse tree
	 */
	void exitMensuration(kernParser.MensurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#metronome}.
	 * @param ctx the parse tree
	 */
	void enterMetronome(kernParser.MetronomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#metronome}.
	 * @param ctx the parse tree
	 */
	void exitMetronome(kernParser.MetronomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#nullInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterNullInterpretation(kernParser.NullInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#nullInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitNullInterpretation(kernParser.NullInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#barline}.
	 * @param ctx the parse tree
	 */
	void enterBarline(kernParser.BarlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#barline}.
	 * @param ctx the parse tree
	 */
	void exitBarline(kernParser.BarlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#barLineType}.
	 * @param ctx the parse tree
	 */
	void enterBarLineType(kernParser.BarLineTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#barLineType}.
	 * @param ctx the parse tree
	 */
	void exitBarLineType(kernParser.BarLineTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#spineOperation}.
	 * @param ctx the parse tree
	 */
	void enterSpineOperation(kernParser.SpineOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#spineOperation}.
	 * @param ctx the parse tree
	 */
	void exitSpineOperation(kernParser.SpineOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#spineTerminator}.
	 * @param ctx the parse tree
	 */
	void enterSpineTerminator(kernParser.SpineTerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#spineTerminator}.
	 * @param ctx the parse tree
	 */
	void exitSpineTerminator(kernParser.SpineTerminatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#spineAdd}.
	 * @param ctx the parse tree
	 */
	void enterSpineAdd(kernParser.SpineAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#spineAdd}.
	 * @param ctx the parse tree
	 */
	void exitSpineAdd(kernParser.SpineAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#spineSplit}.
	 * @param ctx the parse tree
	 */
	void enterSpineSplit(kernParser.SpineSplitContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#spineSplit}.
	 * @param ctx the parse tree
	 */
	void exitSpineSplit(kernParser.SpineSplitContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#rest}.
	 * @param ctx the parse tree
	 */
	void enterRest(kernParser.RestContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#rest}.
	 * @param ctx the parse tree
	 */
	void exitRest(kernParser.RestContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#restLinePosition}.
	 * @param ctx the parse tree
	 */
	void enterRestLinePosition(kernParser.RestLinePositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#restLinePosition}.
	 * @param ctx the parse tree
	 */
	void exitRestLinePosition(kernParser.RestLinePositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(kernParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(kernParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#fermata}.
	 * @param ctx the parse tree
	 */
	void enterFermata(kernParser.FermataContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#fermata}.
	 * @param ctx the parse tree
	 */
	void exitFermata(kernParser.FermataContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mensuralDuration}.
	 * @param ctx the parse tree
	 */
	void enterMensuralDuration(kernParser.MensuralDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mensuralDuration}.
	 * @param ctx the parse tree
	 */
	void exitMensuralDuration(kernParser.MensuralDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mensuralDot}.
	 * @param ctx the parse tree
	 */
	void enterMensuralDot(kernParser.MensuralDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mensuralDot}.
	 * @param ctx the parse tree
	 */
	void exitMensuralDot(kernParser.MensuralDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#modernDuration}.
	 * @param ctx the parse tree
	 */
	void enterModernDuration(kernParser.ModernDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#modernDuration}.
	 * @param ctx the parse tree
	 */
	void exitModernDuration(kernParser.ModernDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#coloured}.
	 * @param ctx the parse tree
	 */
	void enterColoured(kernParser.ColouredContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#coloured}.
	 * @param ctx the parse tree
	 */
	void exitColoured(kernParser.ColouredContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mensuralFigure}.
	 * @param ctx the parse tree
	 */
	void enterMensuralFigure(kernParser.MensuralFigureContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mensuralFigure}.
	 * @param ctx the parse tree
	 */
	void exitMensuralFigure(kernParser.MensuralFigureContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 */
	void enterMensuralPerfection(kernParser.MensuralPerfectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 */
	void exitMensuralPerfection(kernParser.MensuralPerfectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#augmentationDot}.
	 * @param ctx the parse tree
	 */
	void enterAugmentationDot(kernParser.AugmentationDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#augmentationDot}.
	 * @param ctx the parse tree
	 */
	void exitAugmentationDot(kernParser.AugmentationDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#separationDot}.
	 * @param ctx the parse tree
	 */
	void enterSeparationDot(kernParser.SeparationDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#separationDot}.
	 * @param ctx the parse tree
	 */
	void exitSeparationDot(kernParser.SeparationDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#custos}.
	 * @param ctx the parse tree
	 */
	void enterCustos(kernParser.CustosContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#custos}.
	 * @param ctx the parse tree
	 */
	void exitCustos(kernParser.CustosContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#pitch}.
	 * @param ctx the parse tree
	 */
	void enterPitch(kernParser.PitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#pitch}.
	 * @param ctx the parse tree
	 */
	void exitPitch(kernParser.PitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#alteration}.
	 * @param ctx the parse tree
	 */
	void enterAlteration(kernParser.AlterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#alteration}.
	 * @param ctx the parse tree
	 */
	void exitAlteration(kernParser.AlterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(kernParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(kernParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(kernParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(kernParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void enterBeforeNote(kernParser.BeforeNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void exitBeforeNote(kernParser.BeforeNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#diatonicPitchAndOctave}.
	 * @param ctx the parse tree
	 */
	void enterDiatonicPitchAndOctave(kernParser.DiatonicPitchAndOctaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#diatonicPitchAndOctave}.
	 * @param ctx the parse tree
	 */
	void exitDiatonicPitchAndOctave(kernParser.DiatonicPitchAndOctaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#trebleNotes}.
	 * @param ctx the parse tree
	 */
	void enterTrebleNotes(kernParser.TrebleNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#trebleNotes}.
	 * @param ctx the parse tree
	 */
	void exitTrebleNotes(kernParser.TrebleNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#bassNotes}.
	 * @param ctx the parse tree
	 */
	void enterBassNotes(kernParser.BassNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#bassNotes}.
	 * @param ctx the parse tree
	 */
	void exitBassNotes(kernParser.BassNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#accidental}.
	 * @param ctx the parse tree
	 */
	void enterAccidental(kernParser.AccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#accidental}.
	 * @param ctx the parse tree
	 */
	void exitAccidental(kernParser.AccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#alterationDisplay}.
	 * @param ctx the parse tree
	 */
	void enterAlterationDisplay(kernParser.AlterationDisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#alterationDisplay}.
	 * @param ctx the parse tree
	 */
	void exitAlterationDisplay(kernParser.AlterationDisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void enterAfterNote(kernParser.AfterNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void exitAfterNote(kernParser.AfterNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#slurStart}.
	 * @param ctx the parse tree
	 */
	void enterSlurStart(kernParser.SlurStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#slurStart}.
	 * @param ctx the parse tree
	 */
	void exitSlurStart(kernParser.SlurStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#ligatureStart}.
	 * @param ctx the parse tree
	 */
	void enterLigatureStart(kernParser.LigatureStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#ligatureStart}.
	 * @param ctx the parse tree
	 */
	void exitLigatureStart(kernParser.LigatureStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#ligatureEnd}.
	 * @param ctx the parse tree
	 */
	void enterLigatureEnd(kernParser.LigatureEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#ligatureEnd}.
	 * @param ctx the parse tree
	 */
	void exitLigatureEnd(kernParser.LigatureEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#slurEnd}.
	 * @param ctx the parse tree
	 */
	void enterSlurEnd(kernParser.SlurEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#slurEnd}.
	 * @param ctx the parse tree
	 */
	void exitSlurEnd(kernParser.SlurEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 */
	void enterBarLineCrossedNoteStart(kernParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 */
	void exitBarLineCrossedNoteStart(kernParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 */
	void enterBarLineCrossedNoteEnd(kernParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 */
	void exitBarLineCrossedNoteEnd(kernParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#stem}.
	 * @param ctx the parse tree
	 */
	void enterStem(kernParser.StemContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#stem}.
	 * @param ctx the parse tree
	 */
	void exitStem(kernParser.StemContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#beam}.
	 * @param ctx the parse tree
	 */
	void enterBeam(kernParser.BeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#beam}.
	 * @param ctx the parse tree
	 */
	void exitBeam(kernParser.BeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#staffPosition}.
	 * @param ctx the parse tree
	 */
	void enterStaffPosition(kernParser.StaffPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#staffPosition}.
	 * @param ctx the parse tree
	 */
	void exitStaffPosition(kernParser.StaffPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#lineSpace}.
	 * @param ctx the parse tree
	 */
	void enterLineSpace(kernParser.LineSpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#lineSpace}.
	 * @param ctx the parse tree
	 */
	void exitLineSpace(kernParser.LineSpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#lyricsText}.
	 * @param ctx the parse tree
	 */
	void enterLyricsText(kernParser.LyricsTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#lyricsText}.
	 * @param ctx the parse tree
	 */
	void exitLyricsText(kernParser.LyricsTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link kernParser#plainChant}.
	 * @param ctx the parse tree
	 */
	void enterPlainChant(kernParser.PlainChantContext ctx);
	/**
	 * Exit a parse tree produced by {@link kernParser#plainChant}.
	 * @param ctx the parse tree
	 */
	void exitPlainChant(kernParser.PlainChantContext ctx);
}