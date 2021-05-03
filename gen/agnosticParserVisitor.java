// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnosticParser.g4 by ANTLR 4.9.1


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
	 * Visit a parse tree produced by {@link agnosticParser#version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersion(agnosticParser.VersionContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#agnosticSymbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgnosticSymbol(agnosticParser.AgnosticSymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#coordinates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinates(agnosticParser.CoordinatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#positionInStaff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionInStaff(agnosticParser.PositionInStaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#staff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaff(agnosticParser.StaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(agnosticParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#accidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccidental(agnosticParser.AccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#clef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClef(agnosticParser.ClefContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#clefLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClefLine(agnosticParser.ClefLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#colon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColon(agnosticParser.ColonContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot(agnosticParser.DotContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(agnosticParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#enclosure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosure(agnosticParser.EnclosureContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#horizontalBracket}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHorizontalBracket(agnosticParser.HorizontalBracketContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#leftRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftRight(agnosticParser.LeftRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#mark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMark(agnosticParser.MarkContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#markPositional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkPositional(agnosticParser.MarkPositionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#markUnpositional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkUnpositional(agnosticParser.MarkUnpositionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#markUpperLower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkUpperLower(agnosticParser.MarkUpperLowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#metersign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetersign(agnosticParser.MetersignContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#multirest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultirest(agnosticParser.MultirestContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(agnosticParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#cue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCue(agnosticParser.CueContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#noteFigure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteFigure(agnosticParser.NoteFigureContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#beam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeam(agnosticParser.BeamContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#rest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRest(agnosticParser.RestContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#slur}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlur(agnosticParser.SlurContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#verticalLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerticalLine(agnosticParser.VerticalLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#pUpDown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPUpDown(agnosticParser.PUpDownContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#pAboveBelow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPAboveBelow(agnosticParser.PAboveBelowContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#pStartEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPStartEnd(agnosticParser.PStartEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#pUpperLower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPUpperLower(agnosticParser.PUpperLowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#naturalNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalNumber(agnosticParser.NaturalNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link agnosticParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(agnosticParser.IntegerContext ctx);
}