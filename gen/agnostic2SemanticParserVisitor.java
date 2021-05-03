// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnostic2SemanticParser.g4 by ANTLR 4.9.1




import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link agnostic2SemanticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface agnostic2SemanticParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#startTranslation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTranslation(agnostic2SemanticParser.StartTranslationContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersion(agnostic2SemanticParser.VersionContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#semanticSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemanticSymbol(agnostic2SemanticParser.SemanticSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#specificSemanticSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificSemanticSymbol(agnostic2SemanticParser.SpecificSemanticSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#semanticClef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemanticClef(agnostic2SemanticParser.SemanticClefContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#coordinates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinates(agnostic2SemanticParser.CoordinatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#positionInStaff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionInStaff(agnostic2SemanticParser.PositionInStaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#staff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaff(agnostic2SemanticParser.StaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#accidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccidental(agnostic2SemanticParser.AccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#clef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClef(agnostic2SemanticParser.ClefContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#clefLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefLine(agnostic2SemanticParser.ClefLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#colon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColon(agnostic2SemanticParser.ColonContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(agnostic2SemanticParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(agnostic2SemanticParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#enclosure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosure(agnostic2SemanticParser.EnclosureContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#horizontalBracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHorizontalBracket(agnostic2SemanticParser.HorizontalBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#leftRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftRight(agnostic2SemanticParser.LeftRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#mark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMark(agnostic2SemanticParser.MarkContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#markPositional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkPositional(agnostic2SemanticParser.MarkPositionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#markUnpositional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkUnpositional(agnostic2SemanticParser.MarkUnpositionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#markUpperLower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkUpperLower(agnostic2SemanticParser.MarkUpperLowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#metersign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetersign(agnostic2SemanticParser.MetersignContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#multirest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultirest(agnostic2SemanticParser.MultirestContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(agnostic2SemanticParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#cue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCue(agnostic2SemanticParser.CueContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#noteFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteFigure(agnostic2SemanticParser.NoteFigureContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#beam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeam(agnostic2SemanticParser.BeamContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#rest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRest(agnostic2SemanticParser.RestContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#slur}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlur(agnostic2SemanticParser.SlurContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#verticalLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerticalLine(agnostic2SemanticParser.VerticalLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#pUpDown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPUpDown(agnostic2SemanticParser.PUpDownContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#pAboveBelow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAboveBelow(agnostic2SemanticParser.PAboveBelowContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#pStartEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPStartEnd(agnostic2SemanticParser.PStartEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#pUpperLower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPUpperLower(agnostic2SemanticParser.PUpperLowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#naturalNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalNumber(agnostic2SemanticParser.NaturalNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnostic2SemanticParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(agnostic2SemanticParser.IntegerContext ctx);
}