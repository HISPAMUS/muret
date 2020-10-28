// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/moosicae/src/main/antlr4/es/ua/dlsi/grfia/moosicae/io/skm/grammar/skmParser.g4 by ANTLR 4.8


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link skmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface skmParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link skmParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(skmParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(skmParser.EolContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(skmParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#headerField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderField(skmParser.HeaderFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#record}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord(skmParser.RecordContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTab(skmParser.TabContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(skmParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(skmParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#associatedIDS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociatedIDS(skmParser.AssociatedIDSContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#placeHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceHolder(skmParser.PlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#graphicalToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphicalToken(skmParser.GraphicalTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTandemInterpretation(skmParser.TandemInterpretationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(skmParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerCasePitch(skmParser.LowerCasePitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#upperCasePitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpperCasePitch(skmParser.UpperCasePitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#pitchClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPitchClass(skmParser.PitchClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(skmParser.PartContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#staff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaff(skmParser.StaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#clef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClef(skmParser.ClefContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#clefValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefValue(skmParser.ClefValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#clefSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefSign(skmParser.ClefSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#clefLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefLine(skmParser.ClefLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#clefOctave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefOctave(skmParser.ClefOctaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#keySignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignature(skmParser.KeySignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#keySignaturePitchClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignaturePitchClass(skmParser.KeySignaturePitchClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#keySignatureCancel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignatureCancel(skmParser.KeySignatureCancelContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#keyMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyMode(skmParser.KeyModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(skmParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#minorKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinorKey(skmParser.MinorKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#majorKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMajorKey(skmParser.MajorKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#timeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeSignature(skmParser.TimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#numerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerator(skmParser.NumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#denominator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDenominator(skmParser.DenominatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#standardTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandardTimeSignature(skmParser.StandardTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#additiveTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveTimeSignature(skmParser.AdditiveTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#mixedTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixedTimeSignature(skmParser.MixedTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#alternatingTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternatingTimeSignature(skmParser.AlternatingTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#alternatingTimeSignatureItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternatingTimeSignatureItem(skmParser.AlternatingTimeSignatureItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#interchangingTimeSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterchangingTimeSignature(skmParser.InterchangingTimeSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#meterSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterSymbol(skmParser.MeterSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#modernMeterSymbolSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModernMeterSymbolSign(skmParser.ModernMeterSymbolSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#mensuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuration(skmParser.MensurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#metronome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetronome(skmParser.MetronomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#nullInterpretation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullInterpretation(skmParser.NullInterpretationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#barline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarline(skmParser.BarlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#barLineType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineType(skmParser.BarLineTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#spineOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineOperation(skmParser.SpineOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#spineTerminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineTerminator(skmParser.SpineTerminatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#spineAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineAdd(skmParser.SpineAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#spineSplit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineSplit(skmParser.SpineSplitContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#rest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRest(skmParser.RestContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#restLinePosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestLinePosition(skmParser.RestLinePositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(skmParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#fermata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFermata(skmParser.FermataContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#mensuralDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralDuration(skmParser.MensuralDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#mensuralDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralDot(skmParser.MensuralDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#modernDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModernDuration(skmParser.ModernDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#coloured}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColoured(skmParser.ColouredContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#mensuralFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralFigure(skmParser.MensuralFigureContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralPerfection(skmParser.MensuralPerfectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#augmentationDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugmentationDot(skmParser.AugmentationDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#separationDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparationDot(skmParser.SeparationDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#custos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustos(skmParser.CustosContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#pitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPitch(skmParser.PitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#alteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlteration(skmParser.AlterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(skmParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(skmParser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#beforeNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeNote(skmParser.BeforeNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#diatonicPitchAndOctave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiatonicPitchAndOctave(skmParser.DiatonicPitchAndOctaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#trebleNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrebleNotes(skmParser.TrebleNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#bassNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBassNotes(skmParser.BassNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#accidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccidental(skmParser.AccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#alterationDisplay}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterationDisplay(skmParser.AlterationDisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#afterNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterNote(skmParser.AfterNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#slurStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlurStart(skmParser.SlurStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#ligatureStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLigatureStart(skmParser.LigatureStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#ligatureEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLigatureEnd(skmParser.LigatureEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#slurEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlurEnd(skmParser.SlurEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineCrossedNoteStart(skmParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineCrossedNoteEnd(skmParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#stem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStem(skmParser.StemContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#beam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeam(skmParser.BeamContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#staffPosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaffPosition(skmParser.StaffPositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#lineSpace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineSpace(skmParser.LineSpaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#lyricsText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLyricsText(skmParser.LyricsTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link skmParser#plainChant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainChant(skmParser.PlainChantContext ctx);
}