// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnosticParser.g4 by ANTLR 4.9.1


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link agnosticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface agnosticParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link agnosticParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(agnosticParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#anystart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnystart(agnosticParser.AnystartContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(agnosticParser.EolContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(agnosticParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#headerField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderField(agnosticParser.HeaderFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#record}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord(agnosticParser.RecordContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#tab}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTab(agnosticParser.TabContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(agnosticParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(agnosticParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#associatedIDS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociatedIDS(agnosticParser.AssociatedIDSContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#placeHolder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceHolder(agnosticParser.PlaceHolderContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#graphicalToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphicalToken(agnosticParser.GraphicalTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#tandemInterpretation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTandemInterpretation(agnosticParser.TandemInterpretationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(agnosticParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#lowerCasePitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerCasePitch(agnosticParser.LowerCasePitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#upperCasePitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpperCasePitch(agnosticParser.UpperCasePitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(agnosticParser.PartContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#staff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaff(agnosticParser.StaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#clef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClef(agnosticParser.ClefContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#clefValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefValue(agnosticParser.ClefValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#clefNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefNote(agnosticParser.ClefNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#clefLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefLine(agnosticParser.ClefLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#keySignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignature(agnosticParser.KeySignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#keySignatureNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeySignatureNote(agnosticParser.KeySignatureNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#keyAccidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyAccidental(agnosticParser.KeyAccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#keyChange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyChange(agnosticParser.KeyChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#minorKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinorKey(agnosticParser.MinorKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#majorKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMajorKey(agnosticParser.MajorKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#fractionalMeter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFractionalMeter(agnosticParser.FractionalMeterContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#numerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerator(agnosticParser.NumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#denominator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDenominator(agnosticParser.DenominatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#meterSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterSign(agnosticParser.MeterSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#meterSignValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterSignValue(agnosticParser.MeterSignValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#maximodus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaximodus(agnosticParser.MaximodusContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#modusMinor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModusMinor(agnosticParser.ModusMinorContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#tempus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempus(agnosticParser.TempusContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#prolatio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlatio(agnosticParser.ProlatioContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#metronome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetronome(agnosticParser.MetronomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#nullInterpretation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullInterpretation(agnosticParser.NullInterpretationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#barLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLine(agnosticParser.BarLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#barlineProperties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarlineProperties(agnosticParser.BarlinePropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#spineOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineOperation(agnosticParser.SpineOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#spineTerminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineTerminator(agnosticParser.SpineTerminatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#spineSplit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineSplit(agnosticParser.SpineSplitContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#spineJoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpineJoin(agnosticParser.SpineJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#multirest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultirest(agnosticParser.MultirestContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#rest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRest(agnosticParser.RestContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#restLinePosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestLinePosition(agnosticParser.RestLinePositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(agnosticParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#pause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPause(agnosticParser.PauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#mensuralDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralDuration(agnosticParser.MensuralDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#mensuralDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralDot(agnosticParser.MensuralDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#modernDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModernDuration(agnosticParser.ModernDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#coloured}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColoured(agnosticParser.ColouredContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#mensuralFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralFigure(agnosticParser.MensuralFigureContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#mensuralPerfection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMensuralPerfection(agnosticParser.MensuralPerfectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#augmentationDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugmentationDot(agnosticParser.AugmentationDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#separationDot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeparationDot(agnosticParser.SeparationDotContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#custos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustos(agnosticParser.CustosContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(agnosticParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#beforeNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeNote(agnosticParser.BeforeNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#noteName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteName(agnosticParser.NoteNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#trebleNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrebleNotes(agnosticParser.TrebleNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#bassNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBassNotes(agnosticParser.BassNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#alteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlteration(agnosticParser.AlterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#editorialAccidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditorialAccidental(agnosticParser.EditorialAccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#afterNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterNote(agnosticParser.AfterNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#graceNote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraceNote(agnosticParser.GraceNoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#slurStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlurStart(agnosticParser.SlurStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#ligatureStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLigatureStart(agnosticParser.LigatureStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#ligatureEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLigatureEnd(agnosticParser.LigatureEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#slurEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlurEnd(agnosticParser.SlurEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#barLineCrossedNoteStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineCrossedNoteStart(agnosticParser.BarLineCrossedNoteStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#barLineCrossedNoteEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarLineCrossedNoteEnd(agnosticParser.BarLineCrossedNoteEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#stem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStem(agnosticParser.StemContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#beam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeam(agnosticParser.BeamContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#layout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayout(agnosticParser.LayoutContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#layoutCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutCommand(agnosticParser.LayoutCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#layoutVisualAccidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutVisualAccidental(agnosticParser.LayoutVisualAccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#layoutRestPosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutRestPosition(agnosticParser.LayoutRestPositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#staffPosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaffPosition(agnosticParser.StaffPositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#lineSpace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineSpace(agnosticParser.LineSpaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#lyricsText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLyricsText(agnosticParser.LyricsTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#plainChant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainChant(agnosticParser.PlainChantContext ctx);
}