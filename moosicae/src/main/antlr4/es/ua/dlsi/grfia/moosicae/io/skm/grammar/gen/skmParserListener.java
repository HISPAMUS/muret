// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/moosicae/src/main/antlr4/es/ua/dlsi/grfia/moosicae/io/skm/grammar/skmParser.g4 by ANTLR 4.8


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link skmParser}.
 */
public interface skmParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link skmParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(skmParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(skmParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#eol}.
	 * @param ctx the parse tree
	 */
	void enterEol(skmParser.EolContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#eol}.
	 * @param ctx the parse tree
	 */
	void exitEol(skmParser.EolContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(skmParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(skmParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#headerField}.
	 * @param ctx the parse tree
	 */
	void enterHeaderField(skmParser.HeaderFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#headerField}.
	 * @param ctx the parse tree
	 */
	void exitHeaderField(skmParser.HeaderFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(skmParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(skmParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#tab}.
	 * @param ctx the parse tree
	 */
	void enterTab(skmParser.TabContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#tab}.
	 * @param ctx the parse tree
	 */
	void exitTab(skmParser.TabContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(skmParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(skmParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(skmParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(skmParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#associatedIDS}.
	 * @param ctx the parse tree
	 */
	void enterAssociatedIDS(skmParser.AssociatedIDSContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#associatedIDS}.
	 * @param ctx the parse tree
	 */
	void exitAssociatedIDS(skmParser.AssociatedIDSContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#placeHolder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceHolder(skmParser.PlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#placeHolder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceHolder(skmParser.PlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#graphicalToken}.
	 * @param ctx the parse tree
	 */
	void enterGraphicalToken(skmParser.GraphicalTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#graphicalToken}.
	 * @param ctx the parse tree
	 */
	void exitGraphicalToken(skmParser.GraphicalTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterTandemInterpretation(skmParser.TandemInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitTandemInterpretation(skmParser.TandemInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(skmParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(skmParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 */
	void enterLowerCasePitch(skmParser.LowerCasePitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 */
	void exitLowerCasePitch(skmParser.LowerCasePitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#upperCasePitch}.
	 * @param ctx the parse tree
	 */
	void enterUpperCasePitch(skmParser.UpperCasePitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#upperCasePitch}.
	 * @param ctx the parse tree
	 */
	void exitUpperCasePitch(skmParser.UpperCasePitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#pitchClass}.
	 * @param ctx the parse tree
	 */
	void enterPitchClass(skmParser.PitchClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#pitchClass}.
	 * @param ctx the parse tree
	 */
	void exitPitchClass(skmParser.PitchClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(skmParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(skmParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#staff}.
	 * @param ctx the parse tree
	 */
	void enterStaff(skmParser.StaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#staff}.
	 * @param ctx the parse tree
	 */
	void exitStaff(skmParser.StaffContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#clef}.
	 * @param ctx the parse tree
	 */
	void enterClef(skmParser.ClefContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#clef}.
	 * @param ctx the parse tree
	 */
	void exitClef(skmParser.ClefContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#clefValue}.
	 * @param ctx the parse tree
	 */
	void enterClefValue(skmParser.ClefValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#clefValue}.
	 * @param ctx the parse tree
	 */
	void exitClefValue(skmParser.ClefValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#clefSign}.
	 * @param ctx the parse tree
	 */
	void enterClefSign(skmParser.ClefSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#clefSign}.
	 * @param ctx the parse tree
	 */
	void exitClefSign(skmParser.ClefSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void enterClefLine(skmParser.ClefLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void exitClefLine(skmParser.ClefLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#clefOctave}.
	 * @param ctx the parse tree
	 */
	void enterClefOctave(skmParser.ClefOctaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#clefOctave}.
	 * @param ctx the parse tree
	 */
	void exitClefOctave(skmParser.ClefOctaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#keySignature}.
	 * @param ctx the parse tree
	 */
	void enterKeySignature(skmParser.KeySignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#keySignature}.
	 * @param ctx the parse tree
	 */
	void exitKeySignature(skmParser.KeySignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#keySignaturePitchClass}.
	 * @param ctx the parse tree
	 */
	void enterKeySignaturePitchClass(skmParser.KeySignaturePitchClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#keySignaturePitchClass}.
	 * @param ctx the parse tree
	 */
	void exitKeySignaturePitchClass(skmParser.KeySignaturePitchClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#keySignatureCancel}.
	 * @param ctx the parse tree
	 */
	void enterKeySignatureCancel(skmParser.KeySignatureCancelContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#keySignatureCancel}.
	 * @param ctx the parse tree
	 */
	void exitKeySignatureCancel(skmParser.KeySignatureCancelContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#keyMode}.
	 * @param ctx the parse tree
	 */
	void enterKeyMode(skmParser.KeyModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#keyMode}.
	 * @param ctx the parse tree
	 */
	void exitKeyMode(skmParser.KeyModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(skmParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(skmParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void enterMinorKey(skmParser.MinorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void exitMinorKey(skmParser.MinorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void enterMajorKey(skmParser.MajorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void exitMajorKey(skmParser.MajorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#timeSignature}.
	 * @param ctx the parse tree
	 */
	void enterTimeSignature(skmParser.TimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#timeSignature}.
	 * @param ctx the parse tree
	 */
	void exitTimeSignature(skmParser.TimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#numerator}.
	 * @param ctx the parse tree
	 */
	void enterNumerator(skmParser.NumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#numerator}.
	 * @param ctx the parse tree
	 */
	void exitNumerator(skmParser.NumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#denominator}.
	 * @param ctx the parse tree
	 */
	void enterDenominator(skmParser.DenominatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#denominator}.
	 * @param ctx the parse tree
	 */
	void exitDenominator(skmParser.DenominatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#standardTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterStandardTimeSignature(skmParser.StandardTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#standardTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitStandardTimeSignature(skmParser.StandardTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#additiveTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveTimeSignature(skmParser.AdditiveTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#additiveTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveTimeSignature(skmParser.AdditiveTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#mixedTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterMixedTimeSignature(skmParser.MixedTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#mixedTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitMixedTimeSignature(skmParser.MixedTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#alternatingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterAlternatingTimeSignature(skmParser.AlternatingTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#alternatingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitAlternatingTimeSignature(skmParser.AlternatingTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#alternatingTimeSignatureItem}.
	 * @param ctx the parse tree
	 */
	void enterAlternatingTimeSignatureItem(skmParser.AlternatingTimeSignatureItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#alternatingTimeSignatureItem}.
	 * @param ctx the parse tree
	 */
	void exitAlternatingTimeSignatureItem(skmParser.AlternatingTimeSignatureItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#interchangingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void enterInterchangingTimeSignature(skmParser.InterchangingTimeSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#interchangingTimeSignature}.
	 * @param ctx the parse tree
	 */
	void exitInterchangingTimeSignature(skmParser.InterchangingTimeSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#meterSymbol}.
	 * @param ctx the parse tree
	 */
	void enterMeterSymbol(skmParser.MeterSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#meterSymbol}.
	 * @param ctx the parse tree
	 */
	void exitMeterSymbol(skmParser.MeterSymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#modernMeterSymbolSign}.
	 * @param ctx the parse tree
	 */
	void enterModernMeterSymbolSign(skmParser.ModernMeterSymbolSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#modernMeterSymbolSign}.
	 * @param ctx the parse tree
	 */
	void exitModernMeterSymbolSign(skmParser.ModernMeterSymbolSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#mensuration}.
	 * @param ctx the parse tree
	 */
	void enterMensuration(skmParser.MensurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#mensuration}.
	 * @param ctx the parse tree
	 */
	void exitMensuration(skmParser.MensurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#metronome}.
	 * @param ctx the parse tree
	 */
	void enterMetronome(skmParser.MetronomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#metronome}.
	 * @param ctx the parse tree
	 */
	void exitMetronome(skmParser.MetronomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#nullInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterNullInterpretation(skmParser.NullInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#nullInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitNullInterpretation(skmParser.NullInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#barline}.
	 * @param ctx the parse tree
	 */
	void enterBarline(skmParser.BarlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#barline}.
	 * @param ctx the parse tree
	 */
	void exitBarline(skmParser.BarlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#barLineType}.
	 * @param ctx the parse tree
	 */
	void enterBarLineType(skmParser.BarLineTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#barLineType}.
	 * @param ctx the parse tree
	 */
	void exitBarLineType(skmParser.BarLineTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#spineOperation}.
	 * @param ctx the parse tree
	 */
	void enterSpineOperation(skmParser.SpineOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#spineOperation}.
	 * @param ctx the parse tree
	 */
	void exitSpineOperation(skmParser.SpineOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#spineTerminator}.
	 * @param ctx the parse tree
	 */
	void enterSpineTerminator(skmParser.SpineTerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#spineTerminator}.
	 * @param ctx the parse tree
	 */
	void exitSpineTerminator(skmParser.SpineTerminatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#spineAdd}.
	 * @param ctx the parse tree
	 */
	void enterSpineAdd(skmParser.SpineAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#spineAdd}.
	 * @param ctx the parse tree
	 */
	void exitSpineAdd(skmParser.SpineAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#spineSplit}.
	 * @param ctx the parse tree
	 */
	void enterSpineSplit(skmParser.SpineSplitContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#spineSplit}.
	 * @param ctx the parse tree
	 */
	void exitSpineSplit(skmParser.SpineSplitContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#rest}.
	 * @param ctx the parse tree
	 */
	void enterRest(skmParser.RestContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#rest}.
	 * @param ctx the parse tree
	 */
	void exitRest(skmParser.RestContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#restLinePosition}.
	 * @param ctx the parse tree
	 */
	void enterRestLinePosition(skmParser.RestLinePositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#restLinePosition}.
	 * @param ctx the parse tree
	 */
	void exitRestLinePosition(skmParser.RestLinePositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(skmParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(skmParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#fermata}.
	 * @param ctx the parse tree
	 */
	void enterFermata(skmParser.FermataContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#fermata}.
	 * @param ctx the parse tree
	 */
	void exitFermata(skmParser.FermataContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#mensuralDuration}.
	 * @param ctx the parse tree
	 */
	void enterMensuralDuration(skmParser.MensuralDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#mensuralDuration}.
	 * @param ctx the parse tree
	 */
	void exitMensuralDuration(skmParser.MensuralDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#mensuralDot}.
	 * @param ctx the parse tree
	 */
	void enterMensuralDot(skmParser.MensuralDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#mensuralDot}.
	 * @param ctx the parse tree
	 */
	void exitMensuralDot(skmParser.MensuralDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#modernDuration}.
	 * @param ctx the parse tree
	 */
	void enterModernDuration(skmParser.ModernDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#modernDuration}.
	 * @param ctx the parse tree
	 */
	void exitModernDuration(skmParser.ModernDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#coloured}.
	 * @param ctx the parse tree
	 */
	void enterColoured(skmParser.ColouredContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#coloured}.
	 * @param ctx the parse tree
	 */
	void exitColoured(skmParser.ColouredContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#mensuralFigure}.
	 * @param ctx the parse tree
	 */
	void enterMensuralFigure(skmParser.MensuralFigureContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#mensuralFigure}.
	 * @param ctx the parse tree
	 */
	void exitMensuralFigure(skmParser.MensuralFigureContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 */
	void enterMensuralPerfection(skmParser.MensuralPerfectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 */
	void exitMensuralPerfection(skmParser.MensuralPerfectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#augmentationDot}.
	 * @param ctx the parse tree
	 */
	void enterAugmentationDot(skmParser.AugmentationDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#augmentationDot}.
	 * @param ctx the parse tree
	 */
	void exitAugmentationDot(skmParser.AugmentationDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#separationDot}.
	 * @param ctx the parse tree
	 */
	void enterSeparationDot(skmParser.SeparationDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#separationDot}.
	 * @param ctx the parse tree
	 */
	void exitSeparationDot(skmParser.SeparationDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#custos}.
	 * @param ctx the parse tree
	 */
	void enterCustos(skmParser.CustosContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#custos}.
	 * @param ctx the parse tree
	 */
	void exitCustos(skmParser.CustosContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#pitch}.
	 * @param ctx the parse tree
	 */
	void enterPitch(skmParser.PitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#pitch}.
	 * @param ctx the parse tree
	 */
	void exitPitch(skmParser.PitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#alteration}.
	 * @param ctx the parse tree
	 */
	void enterAlteration(skmParser.AlterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#alteration}.
	 * @param ctx the parse tree
	 */
	void exitAlteration(skmParser.AlterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(skmParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(skmParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(skmParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(skmParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void enterBeforeNote(skmParser.BeforeNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void exitBeforeNote(skmParser.BeforeNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#diatonicPitchAndOctave}.
	 * @param ctx the parse tree
	 */
	void enterDiatonicPitchAndOctave(skmParser.DiatonicPitchAndOctaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#diatonicPitchAndOctave}.
	 * @param ctx the parse tree
	 */
	void exitDiatonicPitchAndOctave(skmParser.DiatonicPitchAndOctaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#trebleNotes}.
	 * @param ctx the parse tree
	 */
	void enterTrebleNotes(skmParser.TrebleNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#trebleNotes}.
	 * @param ctx the parse tree
	 */
	void exitTrebleNotes(skmParser.TrebleNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#bassNotes}.
	 * @param ctx the parse tree
	 */
	void enterBassNotes(skmParser.BassNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#bassNotes}.
	 * @param ctx the parse tree
	 */
	void exitBassNotes(skmParser.BassNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#accidental}.
	 * @param ctx the parse tree
	 */
	void enterAccidental(skmParser.AccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#accidental}.
	 * @param ctx the parse tree
	 */
	void exitAccidental(skmParser.AccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#alterationDisplay}.
	 * @param ctx the parse tree
	 */
	void enterAlterationDisplay(skmParser.AlterationDisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#alterationDisplay}.
	 * @param ctx the parse tree
	 */
	void exitAlterationDisplay(skmParser.AlterationDisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void enterAfterNote(skmParser.AfterNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void exitAfterNote(skmParser.AfterNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#slurStart}.
	 * @param ctx the parse tree
	 */
	void enterSlurStart(skmParser.SlurStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#slurStart}.
	 * @param ctx the parse tree
	 */
	void exitSlurStart(skmParser.SlurStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#ligatureStart}.
	 * @param ctx the parse tree
	 */
	void enterLigatureStart(skmParser.LigatureStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#ligatureStart}.
	 * @param ctx the parse tree
	 */
	void exitLigatureStart(skmParser.LigatureStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#ligatureEnd}.
	 * @param ctx the parse tree
	 */
	void enterLigatureEnd(skmParser.LigatureEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#ligatureEnd}.
	 * @param ctx the parse tree
	 */
	void exitLigatureEnd(skmParser.LigatureEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#slurEnd}.
	 * @param ctx the parse tree
	 */
	void enterSlurEnd(skmParser.SlurEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#slurEnd}.
	 * @param ctx the parse tree
	 */
	void exitSlurEnd(skmParser.SlurEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 */
	void enterBarLineCrossedNoteStart(skmParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 */
	void exitBarLineCrossedNoteStart(skmParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 */
	void enterBarLineCrossedNoteEnd(skmParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 */
	void exitBarLineCrossedNoteEnd(skmParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#stem}.
	 * @param ctx the parse tree
	 */
	void enterStem(skmParser.StemContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#stem}.
	 * @param ctx the parse tree
	 */
	void exitStem(skmParser.StemContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#beam}.
	 * @param ctx the parse tree
	 */
	void enterBeam(skmParser.BeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#beam}.
	 * @param ctx the parse tree
	 */
	void exitBeam(skmParser.BeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#staffPosition}.
	 * @param ctx the parse tree
	 */
	void enterStaffPosition(skmParser.StaffPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#staffPosition}.
	 * @param ctx the parse tree
	 */
	void exitStaffPosition(skmParser.StaffPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#lineSpace}.
	 * @param ctx the parse tree
	 */
	void enterLineSpace(skmParser.LineSpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#lineSpace}.
	 * @param ctx the parse tree
	 */
	void exitLineSpace(skmParser.LineSpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#lyricsText}.
	 * @param ctx the parse tree
	 */
	void enterLyricsText(skmParser.LyricsTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#lyricsText}.
	 * @param ctx the parse tree
	 */
	void exitLyricsText(skmParser.LyricsTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link skmParser#plainChant}.
	 * @param ctx the parse tree
	 */
	void enterPlainChant(skmParser.PlainChantContext ctx);
	/**
	 * Exit a parse tree produced by {@link skmParser#plainChant}.
	 * @param ctx the parse tree
	 */
	void exitPlainChant(skmParser.PlainChantContext ctx);
}