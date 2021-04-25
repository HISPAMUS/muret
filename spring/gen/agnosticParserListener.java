// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnosticParser.g4 by ANTLR 4.9.1


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link agnosticParser}.
 */
public interface agnosticParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link agnosticParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(agnosticParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(agnosticParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#anystart}.
	 * @param ctx the parse tree
	 */
	void enterAnystart(agnosticParser.AnystartContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#anystart}.
	 * @param ctx the parse tree
	 */
	void exitAnystart(agnosticParser.AnystartContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#eol}.
	 * @param ctx the parse tree
	 */
	void enterEol(agnosticParser.EolContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#eol}.
	 * @param ctx the parse tree
	 */
	void exitEol(agnosticParser.EolContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(agnosticParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(agnosticParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#headerField}.
	 * @param ctx the parse tree
	 */
	void enterHeaderField(agnosticParser.HeaderFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#headerField}.
	 * @param ctx the parse tree
	 */
	void exitHeaderField(agnosticParser.HeaderFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(agnosticParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(agnosticParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#tab}.
	 * @param ctx the parse tree
	 */
	void enterTab(agnosticParser.TabContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#tab}.
	 * @param ctx the parse tree
	 */
	void exitTab(agnosticParser.TabContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(agnosticParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(agnosticParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(agnosticParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(agnosticParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#associatedIDS}.
	 * @param ctx the parse tree
	 */
	void enterAssociatedIDS(agnosticParser.AssociatedIDSContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#associatedIDS}.
	 * @param ctx the parse tree
	 */
	void exitAssociatedIDS(agnosticParser.AssociatedIDSContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#placeHolder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceHolder(agnosticParser.PlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#placeHolder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceHolder(agnosticParser.PlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#graphicalToken}.
	 * @param ctx the parse tree
	 */
	void enterGraphicalToken(agnosticParser.GraphicalTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#graphicalToken}.
	 * @param ctx the parse tree
	 */
	void exitGraphicalToken(agnosticParser.GraphicalTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterTandemInterpretation(agnosticParser.TandemInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitTandemInterpretation(agnosticParser.TandemInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(agnosticParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(agnosticParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 */
	void enterLowerCasePitch(agnosticParser.LowerCasePitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 */
	void exitLowerCasePitch(agnosticParser.LowerCasePitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#upperCasePitch}.
	 * @param ctx the parse tree
	 */
	void enterUpperCasePitch(agnosticParser.UpperCasePitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#upperCasePitch}.
	 * @param ctx the parse tree
	 */
	void exitUpperCasePitch(agnosticParser.UpperCasePitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(agnosticParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(agnosticParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#staff}.
	 * @param ctx the parse tree
	 */
	void enterStaff(agnosticParser.StaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#staff}.
	 * @param ctx the parse tree
	 */
	void exitStaff(agnosticParser.StaffContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#clef}.
	 * @param ctx the parse tree
	 */
	void enterClef(agnosticParser.ClefContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#clef}.
	 * @param ctx the parse tree
	 */
	void exitClef(agnosticParser.ClefContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#clefValue}.
	 * @param ctx the parse tree
	 */
	void enterClefValue(agnosticParser.ClefValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#clefValue}.
	 * @param ctx the parse tree
	 */
	void exitClefValue(agnosticParser.ClefValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#clefNote}.
	 * @param ctx the parse tree
	 */
	void enterClefNote(agnosticParser.ClefNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#clefNote}.
	 * @param ctx the parse tree
	 */
	void exitClefNote(agnosticParser.ClefNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void enterClefLine(agnosticParser.ClefLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void exitClefLine(agnosticParser.ClefLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#keySignature}.
	 * @param ctx the parse tree
	 */
	void enterKeySignature(agnosticParser.KeySignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#keySignature}.
	 * @param ctx the parse tree
	 */
	void exitKeySignature(agnosticParser.KeySignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#keySignatureNote}.
	 * @param ctx the parse tree
	 */
	void enterKeySignatureNote(agnosticParser.KeySignatureNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#keySignatureNote}.
	 * @param ctx the parse tree
	 */
	void exitKeySignatureNote(agnosticParser.KeySignatureNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#keyAccidental}.
	 * @param ctx the parse tree
	 */
	void enterKeyAccidental(agnosticParser.KeyAccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#keyAccidental}.
	 * @param ctx the parse tree
	 */
	void exitKeyAccidental(agnosticParser.KeyAccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#keyChange}.
	 * @param ctx the parse tree
	 */
	void enterKeyChange(agnosticParser.KeyChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#keyChange}.
	 * @param ctx the parse tree
	 */
	void exitKeyChange(agnosticParser.KeyChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void enterMinorKey(agnosticParser.MinorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#minorKey}.
	 * @param ctx the parse tree
	 */
	void exitMinorKey(agnosticParser.MinorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void enterMajorKey(agnosticParser.MajorKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#majorKey}.
	 * @param ctx the parse tree
	 */
	void exitMajorKey(agnosticParser.MajorKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#fractionalMeter}.
	 * @param ctx the parse tree
	 */
	void enterFractionalMeter(agnosticParser.FractionalMeterContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#fractionalMeter}.
	 * @param ctx the parse tree
	 */
	void exitFractionalMeter(agnosticParser.FractionalMeterContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#numerator}.
	 * @param ctx the parse tree
	 */
	void enterNumerator(agnosticParser.NumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#numerator}.
	 * @param ctx the parse tree
	 */
	void exitNumerator(agnosticParser.NumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#denominator}.
	 * @param ctx the parse tree
	 */
	void enterDenominator(agnosticParser.DenominatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#denominator}.
	 * @param ctx the parse tree
	 */
	void exitDenominator(agnosticParser.DenominatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#meterSign}.
	 * @param ctx the parse tree
	 */
	void enterMeterSign(agnosticParser.MeterSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#meterSign}.
	 * @param ctx the parse tree
	 */
	void exitMeterSign(agnosticParser.MeterSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#meterSignValue}.
	 * @param ctx the parse tree
	 */
	void enterMeterSignValue(agnosticParser.MeterSignValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#meterSignValue}.
	 * @param ctx the parse tree
	 */
	void exitMeterSignValue(agnosticParser.MeterSignValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#maximodus}.
	 * @param ctx the parse tree
	 */
	void enterMaximodus(agnosticParser.MaximodusContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#maximodus}.
	 * @param ctx the parse tree
	 */
	void exitMaximodus(agnosticParser.MaximodusContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#modusMinor}.
	 * @param ctx the parse tree
	 */
	void enterModusMinor(agnosticParser.ModusMinorContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#modusMinor}.
	 * @param ctx the parse tree
	 */
	void exitModusMinor(agnosticParser.ModusMinorContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#tempus}.
	 * @param ctx the parse tree
	 */
	void enterTempus(agnosticParser.TempusContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#tempus}.
	 * @param ctx the parse tree
	 */
	void exitTempus(agnosticParser.TempusContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#prolatio}.
	 * @param ctx the parse tree
	 */
	void enterProlatio(agnosticParser.ProlatioContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#prolatio}.
	 * @param ctx the parse tree
	 */
	void exitProlatio(agnosticParser.ProlatioContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#metronome}.
	 * @param ctx the parse tree
	 */
	void enterMetronome(agnosticParser.MetronomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#metronome}.
	 * @param ctx the parse tree
	 */
	void exitMetronome(agnosticParser.MetronomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#nullInterpretation}.
	 * @param ctx the parse tree
	 */
	void enterNullInterpretation(agnosticParser.NullInterpretationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#nullInterpretation}.
	 * @param ctx the parse tree
	 */
	void exitNullInterpretation(agnosticParser.NullInterpretationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#barLine}.
	 * @param ctx the parse tree
	 */
	void enterBarLine(agnosticParser.BarLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#barLine}.
	 * @param ctx the parse tree
	 */
	void exitBarLine(agnosticParser.BarLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#barlineProperties}.
	 * @param ctx the parse tree
	 */
	void enterBarlineProperties(agnosticParser.BarlinePropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#barlineProperties}.
	 * @param ctx the parse tree
	 */
	void exitBarlineProperties(agnosticParser.BarlinePropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#spineOperation}.
	 * @param ctx the parse tree
	 */
	void enterSpineOperation(agnosticParser.SpineOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#spineOperation}.
	 * @param ctx the parse tree
	 */
	void exitSpineOperation(agnosticParser.SpineOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#spineTerminator}.
	 * @param ctx the parse tree
	 */
	void enterSpineTerminator(agnosticParser.SpineTerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#spineTerminator}.
	 * @param ctx the parse tree
	 */
	void exitSpineTerminator(agnosticParser.SpineTerminatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#spineSplit}.
	 * @param ctx the parse tree
	 */
	void enterSpineSplit(agnosticParser.SpineSplitContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#spineSplit}.
	 * @param ctx the parse tree
	 */
	void exitSpineSplit(agnosticParser.SpineSplitContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#spineJoin}.
	 * @param ctx the parse tree
	 */
	void enterSpineJoin(agnosticParser.SpineJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#spineJoin}.
	 * @param ctx the parse tree
	 */
	void exitSpineJoin(agnosticParser.SpineJoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#multirest}.
	 * @param ctx the parse tree
	 */
	void enterMultirest(agnosticParser.MultirestContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#multirest}.
	 * @param ctx the parse tree
	 */
	void exitMultirest(agnosticParser.MultirestContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#rest}.
	 * @param ctx the parse tree
	 */
	void enterRest(agnosticParser.RestContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#rest}.
	 * @param ctx the parse tree
	 */
	void exitRest(agnosticParser.RestContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#restLinePosition}.
	 * @param ctx the parse tree
	 */
	void enterRestLinePosition(agnosticParser.RestLinePositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#restLinePosition}.
	 * @param ctx the parse tree
	 */
	void exitRestLinePosition(agnosticParser.RestLinePositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(agnosticParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(agnosticParser.DurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#pause}.
	 * @param ctx the parse tree
	 */
	void enterPause(agnosticParser.PauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#pause}.
	 * @param ctx the parse tree
	 */
	void exitPause(agnosticParser.PauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#mensuralDuration}.
	 * @param ctx the parse tree
	 */
	void enterMensuralDuration(agnosticParser.MensuralDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#mensuralDuration}.
	 * @param ctx the parse tree
	 */
	void exitMensuralDuration(agnosticParser.MensuralDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#mensuralDot}.
	 * @param ctx the parse tree
	 */
	void enterMensuralDot(agnosticParser.MensuralDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#mensuralDot}.
	 * @param ctx the parse tree
	 */
	void exitMensuralDot(agnosticParser.MensuralDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#modernDuration}.
	 * @param ctx the parse tree
	 */
	void enterModernDuration(agnosticParser.ModernDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#modernDuration}.
	 * @param ctx the parse tree
	 */
	void exitModernDuration(agnosticParser.ModernDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#coloured}.
	 * @param ctx the parse tree
	 */
	void enterColoured(agnosticParser.ColouredContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#coloured}.
	 * @param ctx the parse tree
	 */
	void exitColoured(agnosticParser.ColouredContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#mensuralFigure}.
	 * @param ctx the parse tree
	 */
	void enterMensuralFigure(agnosticParser.MensuralFigureContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#mensuralFigure}.
	 * @param ctx the parse tree
	 */
	void exitMensuralFigure(agnosticParser.MensuralFigureContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 */
	void enterMensuralPerfection(agnosticParser.MensuralPerfectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 */
	void exitMensuralPerfection(agnosticParser.MensuralPerfectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#augmentationDot}.
	 * @param ctx the parse tree
	 */
	void enterAugmentationDot(agnosticParser.AugmentationDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#augmentationDot}.
	 * @param ctx the parse tree
	 */
	void exitAugmentationDot(agnosticParser.AugmentationDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#separationDot}.
	 * @param ctx the parse tree
	 */
	void enterSeparationDot(agnosticParser.SeparationDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#separationDot}.
	 * @param ctx the parse tree
	 */
	void exitSeparationDot(agnosticParser.SeparationDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#custos}.
	 * @param ctx the parse tree
	 */
	void enterCustos(agnosticParser.CustosContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#custos}.
	 * @param ctx the parse tree
	 */
	void exitCustos(agnosticParser.CustosContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(agnosticParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(agnosticParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void enterBeforeNote(agnosticParser.BeforeNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#beforeNote}.
	 * @param ctx the parse tree
	 */
	void exitBeforeNote(agnosticParser.BeforeNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#noteName}.
	 * @param ctx the parse tree
	 */
	void enterNoteName(agnosticParser.NoteNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#noteName}.
	 * @param ctx the parse tree
	 */
	void exitNoteName(agnosticParser.NoteNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#trebleNotes}.
	 * @param ctx the parse tree
	 */
	void enterTrebleNotes(agnosticParser.TrebleNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#trebleNotes}.
	 * @param ctx the parse tree
	 */
	void exitTrebleNotes(agnosticParser.TrebleNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#bassNotes}.
	 * @param ctx the parse tree
	 */
	void enterBassNotes(agnosticParser.BassNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#bassNotes}.
	 * @param ctx the parse tree
	 */
	void exitBassNotes(agnosticParser.BassNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#alteration}.
	 * @param ctx the parse tree
	 */
	void enterAlteration(agnosticParser.AlterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#alteration}.
	 * @param ctx the parse tree
	 */
	void exitAlteration(agnosticParser.AlterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#editorialAccidental}.
	 * @param ctx the parse tree
	 */
	void enterEditorialAccidental(agnosticParser.EditorialAccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#editorialAccidental}.
	 * @param ctx the parse tree
	 */
	void exitEditorialAccidental(agnosticParser.EditorialAccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void enterAfterNote(agnosticParser.AfterNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#afterNote}.
	 * @param ctx the parse tree
	 */
	void exitAfterNote(agnosticParser.AfterNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#graceNote}.
	 * @param ctx the parse tree
	 */
	void enterGraceNote(agnosticParser.GraceNoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#graceNote}.
	 * @param ctx the parse tree
	 */
	void exitGraceNote(agnosticParser.GraceNoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#slurStart}.
	 * @param ctx the parse tree
	 */
	void enterSlurStart(agnosticParser.SlurStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#slurStart}.
	 * @param ctx the parse tree
	 */
	void exitSlurStart(agnosticParser.SlurStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#ligatureStart}.
	 * @param ctx the parse tree
	 */
	void enterLigatureStart(agnosticParser.LigatureStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#ligatureStart}.
	 * @param ctx the parse tree
	 */
	void exitLigatureStart(agnosticParser.LigatureStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#ligatureEnd}.
	 * @param ctx the parse tree
	 */
	void enterLigatureEnd(agnosticParser.LigatureEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#ligatureEnd}.
	 * @param ctx the parse tree
	 */
	void exitLigatureEnd(agnosticParser.LigatureEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#slurEnd}.
	 * @param ctx the parse tree
	 */
	void enterSlurEnd(agnosticParser.SlurEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#slurEnd}.
	 * @param ctx the parse tree
	 */
	void exitSlurEnd(agnosticParser.SlurEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 */
	void enterBarLineCrossedNoteStart(agnosticParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 */
	void exitBarLineCrossedNoteStart(agnosticParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 */
	void enterBarLineCrossedNoteEnd(agnosticParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 */
	void exitBarLineCrossedNoteEnd(agnosticParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#stem}.
	 * @param ctx the parse tree
	 */
	void enterStem(agnosticParser.StemContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#stem}.
	 * @param ctx the parse tree
	 */
	void exitStem(agnosticParser.StemContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#beam}.
	 * @param ctx the parse tree
	 */
	void enterBeam(agnosticParser.BeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#beam}.
	 * @param ctx the parse tree
	 */
	void exitBeam(agnosticParser.BeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#layout}.
	 * @param ctx the parse tree
	 */
	void enterLayout(agnosticParser.LayoutContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#layout}.
	 * @param ctx the parse tree
	 */
	void exitLayout(agnosticParser.LayoutContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#layoutCommand}.
	 * @param ctx the parse tree
	 */
	void enterLayoutCommand(agnosticParser.LayoutCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#layoutCommand}.
	 * @param ctx the parse tree
	 */
	void exitLayoutCommand(agnosticParser.LayoutCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#layoutVisualAccidental}.
	 * @param ctx the parse tree
	 */
	void enterLayoutVisualAccidental(agnosticParser.LayoutVisualAccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#layoutVisualAccidental}.
	 * @param ctx the parse tree
	 */
	void exitLayoutVisualAccidental(agnosticParser.LayoutVisualAccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#layoutRestPosition}.
	 * @param ctx the parse tree
	 */
	void enterLayoutRestPosition(agnosticParser.LayoutRestPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#layoutRestPosition}.
	 * @param ctx the parse tree
	 */
	void exitLayoutRestPosition(agnosticParser.LayoutRestPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#staffPosition}.
	 * @param ctx the parse tree
	 */
	void enterStaffPosition(agnosticParser.StaffPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#staffPosition}.
	 * @param ctx the parse tree
	 */
	void exitStaffPosition(agnosticParser.StaffPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#lineSpace}.
	 * @param ctx the parse tree
	 */
	void enterLineSpace(agnosticParser.LineSpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#lineSpace}.
	 * @param ctx the parse tree
	 */
	void exitLineSpace(agnosticParser.LineSpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#lyricsText}.
	 * @param ctx the parse tree
	 */
	void enterLyricsText(agnosticParser.LyricsTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#lyricsText}.
	 * @param ctx the parse tree
	 */
	void exitLyricsText(agnosticParser.LyricsTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnosticParser#plainChant}.
	 * @param ctx the parse tree
	 */
	void enterPlainChant(agnosticParser.PlainChantContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnosticParser#plainChant}.
	 * @param ctx the parse tree
	 */
	void exitPlainChant(agnosticParser.PlainChantContext ctx);
}