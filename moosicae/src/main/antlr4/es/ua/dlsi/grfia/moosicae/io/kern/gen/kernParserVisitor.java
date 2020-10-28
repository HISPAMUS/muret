// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/moosicae/src/main/antlr4/es/ua/dlsi/grfia/moosicae/io/kern/kernParser.g4 by ANTLR 4.8


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link kernParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface kernParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link kernParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(kernParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(kernParser.EolContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(kernParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#headerField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderField(kernParser.HeaderFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#record}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord(kernParser.RecordContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTab(kernParser.TabContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(kernParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(kernParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#associatedIDS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociatedIDS(kernParser.AssociatedIDSContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#placeHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceHolder(kernParser.PlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#graphicalToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphicalToken(kernParser.GraphicalTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTandemInterpretation(kernParser.TandemInterpretationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(kernParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerCasePitch(kernParser.LowerCasePitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#upperCasePitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpperCasePitch(kernParser.UpperCasePitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#pitchClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPitchClass(kernParser.PitchClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(kernParser.PartContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#staff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaff(kernParser.StaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#clef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClef(kernParser.ClefContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#clefValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefValue(kernParser.ClefValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#clefSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefSign(kernParser.ClefSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#clefLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefLine(kernParser.ClefLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#clefOctave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefOctave(kernParser.ClefOctaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#keySignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignature(kernParser.KeySignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#keySignaturePitchClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignaturePitchClass(kernParser.KeySignaturePitchClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#keySignatureCancel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignatureCancel(kernParser.KeySignatureCancelContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#keyMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyMode(kernParser.KeyModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(kernParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#minorKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinorKey(kernParser.MinorKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#majorKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMajorKey(kernParser.MajorKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#timeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeSignature(kernParser.TimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#numerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerator(kernParser.NumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#denominator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDenominator(kernParser.DenominatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#standardTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardTimeSignature(kernParser.StandardTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#additiveTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveTimeSignature(kernParser.AdditiveTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#mixedTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixedTimeSignature(kernParser.MixedTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#alternatingTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternatingTimeSignature(kernParser.AlternatingTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#alternatingTimeSignatureItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternatingTimeSignatureItem(kernParser.AlternatingTimeSignatureItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#interchangingTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterchangingTimeSignature(kernParser.InterchangingTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#meterSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterSymbol(kernParser.MeterSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#modernMeterSymbolSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModernMeterSymbolSign(kernParser.ModernMeterSymbolSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#mensuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuration(kernParser.MensurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#metronome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetronome(kernParser.MetronomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#nullInterpretation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullInterpretation(kernParser.NullInterpretationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#barline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarline(kernParser.BarlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#barLineType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineType(kernParser.BarLineTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#spineOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineOperation(kernParser.SpineOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#spineTerminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineTerminator(kernParser.SpineTerminatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#spineAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineAdd(kernParser.SpineAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#spineSplit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineSplit(kernParser.SpineSplitContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#rest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRest(kernParser.RestContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#restLinePosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestLinePosition(kernParser.RestLinePositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(kernParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#fermata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFermata(kernParser.FermataContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#mensuralDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralDuration(kernParser.MensuralDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#mensuralDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralDot(kernParser.MensuralDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#modernDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModernDuration(kernParser.ModernDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#coloured}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColoured(kernParser.ColouredContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#mensuralFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralFigure(kernParser.MensuralFigureContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralPerfection(kernParser.MensuralPerfectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#augmentationDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugmentationDot(kernParser.AugmentationDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#separationDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparationDot(kernParser.SeparationDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#custos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustos(kernParser.CustosContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#pitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPitch(kernParser.PitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#alteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlteration(kernParser.AlterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(kernParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(kernParser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#beforeNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeNote(kernParser.BeforeNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#diatonicPitchAndOctave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiatonicPitchAndOctave(kernParser.DiatonicPitchAndOctaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#trebleNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrebleNotes(kernParser.TrebleNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#bassNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBassNotes(kernParser.BassNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#accidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccidental(kernParser.AccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#alterationDisplay}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterationDisplay(kernParser.AlterationDisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#afterNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterNote(kernParser.AfterNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#slurStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlurStart(kernParser.SlurStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#ligatureStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLigatureStart(kernParser.LigatureStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#ligatureEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLigatureEnd(kernParser.LigatureEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#slurEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlurEnd(kernParser.SlurEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineCrossedNoteStart(kernParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineCrossedNoteEnd(kernParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#stem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStem(kernParser.StemContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#beam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeam(kernParser.BeamContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#staffPosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaffPosition(kernParser.StaffPositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#lineSpace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineSpace(kernParser.LineSpaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#lyricsText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLyricsText(kernParser.LyricsTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link kernParser#plainChant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainChant(kernParser.PlainChantContext ctx);
}