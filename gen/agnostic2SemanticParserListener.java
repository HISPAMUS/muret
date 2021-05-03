// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnostic2SemanticParser.g4 by ANTLR 4.9.1




import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link agnostic2SemanticParser}.
 */
public interface agnostic2SemanticParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#startTranslation}.
	 * @param ctx the parse tree
	 */
	void enterStartTranslation(agnostic2SemanticParser.StartTranslationContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#startTranslation}.
	 * @param ctx the parse tree
	 */
	void exitStartTranslation(agnostic2SemanticParser.StartTranslationContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#version}.
	 * @param ctx the parse tree
	 */
	void enterVersion(agnostic2SemanticParser.VersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#version}.
	 * @param ctx the parse tree
	 */
	void exitVersion(agnostic2SemanticParser.VersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#semanticSymbol}.
	 * @param ctx the parse tree
	 */
	void enterSemanticSymbol(agnostic2SemanticParser.SemanticSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#semanticSymbol}.
	 * @param ctx the parse tree
	 */
	void exitSemanticSymbol(agnostic2SemanticParser.SemanticSymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#specificSemanticSymbol}.
	 * @param ctx the parse tree
	 */
	void enterSpecificSemanticSymbol(agnostic2SemanticParser.SpecificSemanticSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#specificSemanticSymbol}.
	 * @param ctx the parse tree
	 */
	void exitSpecificSemanticSymbol(agnostic2SemanticParser.SpecificSemanticSymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#semanticClef}.
	 * @param ctx the parse tree
	 */
	void enterSemanticClef(agnostic2SemanticParser.SemanticClefContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#semanticClef}.
	 * @param ctx the parse tree
	 */
	void exitSemanticClef(agnostic2SemanticParser.SemanticClefContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#coordinates}.
	 * @param ctx the parse tree
	 */
	void enterCoordinates(agnostic2SemanticParser.CoordinatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#coordinates}.
	 * @param ctx the parse tree
	 */
	void exitCoordinates(agnostic2SemanticParser.CoordinatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#positionInStaff}.
	 * @param ctx the parse tree
	 */
	void enterPositionInStaff(agnostic2SemanticParser.PositionInStaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#positionInStaff}.
	 * @param ctx the parse tree
	 */
	void exitPositionInStaff(agnostic2SemanticParser.PositionInStaffContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#staff}.
	 * @param ctx the parse tree
	 */
	void enterStaff(agnostic2SemanticParser.StaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#staff}.
	 * @param ctx the parse tree
	 */
	void exitStaff(agnostic2SemanticParser.StaffContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#accidental}.
	 * @param ctx the parse tree
	 */
	void enterAccidental(agnostic2SemanticParser.AccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#accidental}.
	 * @param ctx the parse tree
	 */
	void exitAccidental(agnostic2SemanticParser.AccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#clef}.
	 * @param ctx the parse tree
	 */
	void enterClef(agnostic2SemanticParser.ClefContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#clef}.
	 * @param ctx the parse tree
	 */
	void exitClef(agnostic2SemanticParser.ClefContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void enterClefLine(agnostic2SemanticParser.ClefLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#clefLine}.
	 * @param ctx the parse tree
	 */
	void exitClefLine(agnostic2SemanticParser.ClefLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#colon}.
	 * @param ctx the parse tree
	 */
	void enterColon(agnostic2SemanticParser.ColonContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#colon}.
	 * @param ctx the parse tree
	 */
	void exitColon(agnostic2SemanticParser.ColonContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#dot}.
	 * @param ctx the parse tree
	 */
	void enterDot(agnostic2SemanticParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#dot}.
	 * @param ctx the parse tree
	 */
	void exitDot(agnostic2SemanticParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(agnostic2SemanticParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(agnostic2SemanticParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#enclosure}.
	 * @param ctx the parse tree
	 */
	void enterEnclosure(agnostic2SemanticParser.EnclosureContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#enclosure}.
	 * @param ctx the parse tree
	 */
	void exitEnclosure(agnostic2SemanticParser.EnclosureContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#horizontalBracket}.
	 * @param ctx the parse tree
	 */
	void enterHorizontalBracket(agnostic2SemanticParser.HorizontalBracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#horizontalBracket}.
	 * @param ctx the parse tree
	 */
	void exitHorizontalBracket(agnostic2SemanticParser.HorizontalBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#leftRight}.
	 * @param ctx the parse tree
	 */
	void enterLeftRight(agnostic2SemanticParser.LeftRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#leftRight}.
	 * @param ctx the parse tree
	 */
	void exitLeftRight(agnostic2SemanticParser.LeftRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#mark}.
	 * @param ctx the parse tree
	 */
	void enterMark(agnostic2SemanticParser.MarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#mark}.
	 * @param ctx the parse tree
	 */
	void exitMark(agnostic2SemanticParser.MarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#markPositional}.
	 * @param ctx the parse tree
	 */
	void enterMarkPositional(agnostic2SemanticParser.MarkPositionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#markPositional}.
	 * @param ctx the parse tree
	 */
	void exitMarkPositional(agnostic2SemanticParser.MarkPositionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#markUnpositional}.
	 * @param ctx the parse tree
	 */
	void enterMarkUnpositional(agnostic2SemanticParser.MarkUnpositionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#markUnpositional}.
	 * @param ctx the parse tree
	 */
	void exitMarkUnpositional(agnostic2SemanticParser.MarkUnpositionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#markUpperLower}.
	 * @param ctx the parse tree
	 */
	void enterMarkUpperLower(agnostic2SemanticParser.MarkUpperLowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#markUpperLower}.
	 * @param ctx the parse tree
	 */
	void exitMarkUpperLower(agnostic2SemanticParser.MarkUpperLowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#metersign}.
	 * @param ctx the parse tree
	 */
	void enterMetersign(agnostic2SemanticParser.MetersignContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#metersign}.
	 * @param ctx the parse tree
	 */
	void exitMetersign(agnostic2SemanticParser.MetersignContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#multirest}.
	 * @param ctx the parse tree
	 */
	void enterMultirest(agnostic2SemanticParser.MultirestContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#multirest}.
	 * @param ctx the parse tree
	 */
	void exitMultirest(agnostic2SemanticParser.MultirestContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(agnostic2SemanticParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(agnostic2SemanticParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#cue}.
	 * @param ctx the parse tree
	 */
	void enterCue(agnostic2SemanticParser.CueContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#cue}.
	 * @param ctx the parse tree
	 */
	void exitCue(agnostic2SemanticParser.CueContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#noteFigure}.
	 * @param ctx the parse tree
	 */
	void enterNoteFigure(agnostic2SemanticParser.NoteFigureContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#noteFigure}.
	 * @param ctx the parse tree
	 */
	void exitNoteFigure(agnostic2SemanticParser.NoteFigureContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#beam}.
	 * @param ctx the parse tree
	 */
	void enterBeam(agnostic2SemanticParser.BeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#beam}.
	 * @param ctx the parse tree
	 */
	void exitBeam(agnostic2SemanticParser.BeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#rest}.
	 * @param ctx the parse tree
	 */
	void enterRest(agnostic2SemanticParser.RestContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#rest}.
	 * @param ctx the parse tree
	 */
	void exitRest(agnostic2SemanticParser.RestContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#slur}.
	 * @param ctx the parse tree
	 */
	void enterSlur(agnostic2SemanticParser.SlurContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#slur}.
	 * @param ctx the parse tree
	 */
	void exitSlur(agnostic2SemanticParser.SlurContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#verticalLine}.
	 * @param ctx the parse tree
	 */
	void enterVerticalLine(agnostic2SemanticParser.VerticalLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#verticalLine}.
	 * @param ctx the parse tree
	 */
	void exitVerticalLine(agnostic2SemanticParser.VerticalLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#pUpDown}.
	 * @param ctx the parse tree
	 */
	void enterPUpDown(agnostic2SemanticParser.PUpDownContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#pUpDown}.
	 * @param ctx the parse tree
	 */
	void exitPUpDown(agnostic2SemanticParser.PUpDownContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#pAboveBelow}.
	 * @param ctx the parse tree
	 */
	void enterPAboveBelow(agnostic2SemanticParser.PAboveBelowContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#pAboveBelow}.
	 * @param ctx the parse tree
	 */
	void exitPAboveBelow(agnostic2SemanticParser.PAboveBelowContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#pStartEnd}.
	 * @param ctx the parse tree
	 */
	void enterPStartEnd(agnostic2SemanticParser.PStartEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#pStartEnd}.
	 * @param ctx the parse tree
	 */
	void exitPStartEnd(agnostic2SemanticParser.PStartEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#pUpperLower}.
	 * @param ctx the parse tree
	 */
	void enterPUpperLower(agnostic2SemanticParser.PUpperLowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#pUpperLower}.
	 * @param ctx the parse tree
	 */
	void exitPUpperLower(agnostic2SemanticParser.PUpperLowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#naturalNumber}.
	 * @param ctx the parse tree
	 */
	void enterNaturalNumber(agnostic2SemanticParser.NaturalNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#naturalNumber}.
	 * @param ctx the parse tree
	 */
	void exitNaturalNumber(agnostic2SemanticParser.NaturalNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link agnostic2SemanticParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(agnostic2SemanticParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link agnostic2SemanticParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(agnostic2SemanticParser.IntegerContext ctx);
}