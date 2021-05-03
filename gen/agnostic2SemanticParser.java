// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnostic2SemanticParser.g4 by ANTLR 4.9.1




import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class agnostic2SemanticParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EOL=1, VERSION=2, COLON=3, TAB=4, CHAR_L=5, CHAR_S=6, TACCIDENTAL=7, SEPSYMBOL=8, 
		STACCIDENTALS=9, SEPPROPERTIES=10, PCUE=11, TCLEF=12, CHAR_C=13, CHAR_F=14, 
		CHAR_G=15, STCLEFOCTAVE=16, DIGIT_1=17, DIGIT_2=18, DIGIT_3=19, DIGIT_4=20, 
		DIGIT_5=21, TCOLON=22, TDOT=23, TDIGIT=24, TENCLOSURE=25, STENCLOSURES=26, 
		THORIZONTAL_BRACKET=27, PSTART=28, PEND=29, PRIGHT=30, PLEFT=31, TMARK=32, 
		STMARKS_POSITIONAL=33, STMARKS_UNPOSITIONAL=34, STMARKS_UPPERLOWER=35, 
		TMETERSIGN=36, STMETERSIGNS=37, TMULTIREST=38, TNOTE=39, PCHORD=40, PSLASH=41, 
		STFIGURES_WITHOUT_STEM=42, STFIGURES_WITH_STEM=43, STBEAM=44, TREST=45, 
		STMENSURAL_REST_FIGURES=46, TSLUR=47, PTIE=48, TVERTICAL_LINE=49, STLINEWIDTH=50, 
		PUP=51, PDOWN=52, PABOVE=53, PBELOW=54, PUPPER=55, PLOWER=56, DIGIT_0=57, 
		DIGIT_6=58, DIGIT_7=59, DIGIT_8=60, DIGIT_9=61, HYPHEN=62;
	public static final int
		RULE_startTranslation = 0, RULE_version = 1, RULE_semanticSymbol = 2, 
		RULE_specificSemanticSymbol = 3, RULE_semanticClef = 4, RULE_coordinates = 5, 
		RULE_positionInStaff = 6, RULE_staff = 7, RULE_accidental = 8, RULE_clef = 9, 
		RULE_clefLine = 10, RULE_colon = 11, RULE_dot = 12, RULE_digit = 13, RULE_enclosure = 14, 
		RULE_horizontalBracket = 15, RULE_leftRight = 16, RULE_mark = 17, RULE_markPositional = 18, 
		RULE_markUnpositional = 19, RULE_markUpperLower = 20, RULE_metersign = 21, 
		RULE_multirest = 22, RULE_note = 23, RULE_cue = 24, RULE_noteFigure = 25, 
		RULE_beam = 26, RULE_rest = 27, RULE_slur = 28, RULE_verticalLine = 29, 
		RULE_pUpDown = 30, RULE_pAboveBelow = 31, RULE_pStartEnd = 32, RULE_pUpperLower = 33, 
		RULE_naturalNumber = 34, RULE_integer = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"startTranslation", "version", "semanticSymbol", "specificSemanticSymbol", 
			"semanticClef", "coordinates", "positionInStaff", "staff", "accidental", 
			"clef", "clefLine", "colon", "dot", "digit", "enclosure", "horizontalBracket", 
			"leftRight", "mark", "markPositional", "markUnpositional", "markUpperLower", 
			"metersign", "multirest", "note", "cue", "noteFigure", "beam", "rest", 
			"slur", "verticalLine", "pUpDown", "pAboveBelow", "pStartEnd", "pUpperLower", 
			"naturalNumber", "integer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EOL", "VERSION", "COLON", "TAB", "CHAR_L", "CHAR_S", "TACCIDENTAL", 
			"SEPSYMBOL", "STACCIDENTALS", "SEPPROPERTIES", "PCUE", "TCLEF", "CHAR_C", 
			"CHAR_F", "CHAR_G", "STCLEFOCTAVE", "DIGIT_1", "DIGIT_2", "DIGIT_3", 
			"DIGIT_4", "DIGIT_5", "TCOLON", "TDOT", "TDIGIT", "TENCLOSURE", "STENCLOSURES", 
			"THORIZONTAL_BRACKET", "PSTART", "PEND", "PRIGHT", "PLEFT", "TMARK", 
			"STMARKS_POSITIONAL", "STMARKS_UNPOSITIONAL", "STMARKS_UPPERLOWER", "TMETERSIGN", 
			"STMETERSIGNS", "TMULTIREST", "TNOTE", "PCHORD", "PSLASH", "STFIGURES_WITHOUT_STEM", 
			"STFIGURES_WITH_STEM", "STBEAM", "TREST", "STMENSURAL_REST_FIGURES", 
			"TSLUR", "PTIE", "TVERTICAL_LINE", "STLINEWIDTH", "PUP", "PDOWN", "PABOVE", 
			"PBELOW", "PUPPER", "PLOWER", "DIGIT_0", "DIGIT_6", "DIGIT_7", "DIGIT_8", 
			"DIGIT_9", "HYPHEN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "agnostic2SemanticParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public agnostic2SemanticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartTranslationContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(agnostic2SemanticParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(agnostic2SemanticParser.EOL, i);
		}
		public List<SemanticSymbolContext> semanticSymbol() {
			return getRuleContexts(SemanticSymbolContext.class);
		}
		public SemanticSymbolContext semanticSymbol(int i) {
			return getRuleContext(SemanticSymbolContext.class,i);
		}
		public StartTranslationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTranslation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterStartTranslation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitStartTranslation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitStartTranslation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartTranslationContext startTranslation() throws RecognitionException {
		StartTranslationContext _localctx = new StartTranslationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startTranslation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			version();
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					match(EOL);
					setState(74);
					semanticSymbol();
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(80);
				match(EOL);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VersionContext extends ParserRuleContext {
		public TerminalNode VERSION() { return getToken(agnostic2SemanticParser.VERSION, 0); }
		public TerminalNode COLON() { return getToken(agnostic2SemanticParser.COLON, 0); }
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitVersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitVersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_version);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(VERSION);
			setState(87);
			match(COLON);
			setState(88);
			naturalNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SemanticSymbolContext extends ParserRuleContext {
		public SpecificSemanticSymbolContext specificSemanticSymbol() {
			return getRuleContext(SpecificSemanticSymbolContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(agnostic2SemanticParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(agnostic2SemanticParser.COLON, i);
		}
		public PositionInStaffContext positionInStaff() {
			return getRuleContext(PositionInStaffContext.class,0);
		}
		public StaffContext staff() {
			return getRuleContext(StaffContext.class,0);
		}
		public CoordinatesContext coordinates() {
			return getRuleContext(CoordinatesContext.class,0);
		}
		public TerminalNode TAB() { return getToken(agnostic2SemanticParser.TAB, 0); }
		public SemanticSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semanticSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterSemanticSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitSemanticSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitSemanticSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemanticSymbolContext semanticSymbol() throws RecognitionException {
		SemanticSymbolContext _localctx = new SemanticSymbolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_semanticSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_0) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0)) {
				{
				setState(90);
				coordinates();
				setState(91);
				match(TAB);
				}
			}

			setState(95);
			specificSemanticSymbol();
			setState(96);
			match(COLON);
			setState(97);
			positionInStaff();
			setState(98);
			match(COLON);
			setState(99);
			staff();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecificSemanticSymbolContext extends ParserRuleContext {
		public SemanticClefContext semanticClef() {
			return getRuleContext(SemanticClefContext.class,0);
		}
		public SpecificSemanticSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificSemanticSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterSpecificSemanticSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitSpecificSemanticSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitSpecificSemanticSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificSemanticSymbolContext specificSemanticSymbol() throws RecognitionException {
		SpecificSemanticSymbolContext _localctx = new SpecificSemanticSymbolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_specificSemanticSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			semanticClef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SemanticClefContext extends ParserRuleContext {
		public ClefContext clef() {
			return getRuleContext(ClefContext.class,0);
		}
		public SemanticClefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semanticClef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterSemanticClef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitSemanticClef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitSemanticClef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemanticClefContext semanticClef() throws RecognitionException {
		SemanticClefContext _localctx = new SemanticClefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_semanticClef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			clef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CoordinatesContext extends ParserRuleContext {
		public List<NaturalNumberContext> naturalNumber() {
			return getRuleContexts(NaturalNumberContext.class);
		}
		public NaturalNumberContext naturalNumber(int i) {
			return getRuleContext(NaturalNumberContext.class,i);
		}
		public TerminalNode TAB() { return getToken(agnostic2SemanticParser.TAB, 0); }
		public CoordinatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterCoordinates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitCoordinates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitCoordinates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordinatesContext coordinates() throws RecognitionException {
		CoordinatesContext _localctx = new CoordinatesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_coordinates);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			naturalNumber();
			setState(106);
			match(TAB);
			setState(107);
			naturalNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PositionInStaffContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode CHAR_L() { return getToken(agnostic2SemanticParser.CHAR_L, 0); }
		public TerminalNode CHAR_S() { return getToken(agnostic2SemanticParser.CHAR_S, 0); }
		public PositionInStaffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionInStaff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterPositionInStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitPositionInStaff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitPositionInStaff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionInStaffContext positionInStaff() throws RecognitionException {
		PositionInStaffContext _localctx = new PositionInStaffContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_positionInStaff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==CHAR_L || _la==CHAR_S) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(110);
			integer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaffContext extends ParserRuleContext {
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public StaffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitStaff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitStaff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaffContext staff() throws RecognitionException {
		StaffContext _localctx = new StaffContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_staff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			naturalNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccidentalContext extends ParserRuleContext {
		public TerminalNode TACCIDENTAL() { return getToken(agnostic2SemanticParser.TACCIDENTAL, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode STACCIDENTALS() { return getToken(agnostic2SemanticParser.STACCIDENTALS, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public TerminalNode PCUE() { return getToken(agnostic2SemanticParser.PCUE, 0); }
		public AccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitAccidental(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitAccidental(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccidentalContext accidental() throws RecognitionException {
		AccidentalContext _localctx = new AccidentalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_accidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(TACCIDENTAL);
			setState(115);
			match(SEPSYMBOL);
			setState(116);
			match(STACCIDENTALS);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(117);
				match(SEPPROPERTIES);
				setState(118);
				match(PCUE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClefContext extends ParserRuleContext {
		public TerminalNode TCLEF() { return getToken(agnostic2SemanticParser.TCLEF, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public ClefLineContext clefLine() {
			return getRuleContext(ClefLineContext.class,0);
		}
		public TerminalNode CHAR_C() { return getToken(agnostic2SemanticParser.CHAR_C, 0); }
		public TerminalNode CHAR_F() { return getToken(agnostic2SemanticParser.CHAR_F, 0); }
		public TerminalNode CHAR_G() { return getToken(agnostic2SemanticParser.CHAR_G, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public TerminalNode STCLEFOCTAVE() { return getToken(agnostic2SemanticParser.STCLEFOCTAVE, 0); }
		public ClefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterClef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitClef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitClef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClefContext clef() throws RecognitionException {
		ClefContext _localctx = new ClefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TCLEF);
			setState(122);
			match(SEPSYMBOL);
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_C) | (1L << CHAR_F) | (1L << CHAR_G))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(124);
			clefLine();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(125);
				match(SEPPROPERTIES);
				setState(126);
				match(STCLEFOCTAVE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClefLineContext extends ParserRuleContext {
		public TerminalNode DIGIT_1() { return getToken(agnostic2SemanticParser.DIGIT_1, 0); }
		public TerminalNode DIGIT_2() { return getToken(agnostic2SemanticParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnostic2SemanticParser.DIGIT_3, 0); }
		public TerminalNode DIGIT_4() { return getToken(agnostic2SemanticParser.DIGIT_4, 0); }
		public TerminalNode DIGIT_5() { return getToken(agnostic2SemanticParser.DIGIT_5, 0); }
		public ClefLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clefLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterClefLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitClefLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitClefLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClefLineContext clefLine() throws RecognitionException {
		ClefLineContext _localctx = new ClefLineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_clefLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColonContext extends ParserRuleContext {
		public TerminalNode TCOLON() { return getToken(agnostic2SemanticParser.TCOLON, 0); }
		public ColonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitColon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitColon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColonContext colon() throws RecognitionException {
		ColonContext _localctx = new ColonContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_colon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(TCOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DotContext extends ParserRuleContext {
		public TerminalNode TDOT() { return getToken(agnostic2SemanticParser.TDOT, 0); }
		public DotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitDot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotContext dot() throws RecognitionException {
		DotContext _localctx = new DotContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(TDOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DigitContext extends ParserRuleContext {
		public TerminalNode TDIGIT() { return getToken(agnostic2SemanticParser.TDIGIT, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(TDIGIT);
			setState(136);
			match(SEPSYMBOL);
			setState(137);
			naturalNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnclosureContext extends ParserRuleContext {
		public TerminalNode TENCLOSURE() { return getToken(agnostic2SemanticParser.TENCLOSURE, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode STENCLOSURES() { return getToken(agnostic2SemanticParser.STENCLOSURES, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public LeftRightContext leftRight() {
			return getRuleContext(LeftRightContext.class,0);
		}
		public EnclosureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterEnclosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitEnclosure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitEnclosure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnclosureContext enclosure() throws RecognitionException {
		EnclosureContext _localctx = new EnclosureContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enclosure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(TENCLOSURE);
			setState(140);
			match(SEPSYMBOL);
			setState(141);
			match(STENCLOSURES);
			setState(142);
			match(SEPPROPERTIES);
			setState(143);
			leftRight();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HorizontalBracketContext extends ParserRuleContext {
		public TerminalNode THORIZONTAL_BRACKET() { return getToken(agnostic2SemanticParser.THORIZONTAL_BRACKET, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode PSTART() { return getToken(agnostic2SemanticParser.PSTART, 0); }
		public TerminalNode PEND() { return getToken(agnostic2SemanticParser.PEND, 0); }
		public HorizontalBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horizontalBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterHorizontalBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitHorizontalBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitHorizontalBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HorizontalBracketContext horizontalBracket() throws RecognitionException {
		HorizontalBracketContext _localctx = new HorizontalBracketContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_horizontalBracket);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(THORIZONTAL_BRACKET);
			setState(146);
			match(SEPSYMBOL);
			setState(147);
			_la = _input.LA(1);
			if ( !(_la==PSTART || _la==PEND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftRightContext extends ParserRuleContext {
		public TerminalNode PRIGHT() { return getToken(agnostic2SemanticParser.PRIGHT, 0); }
		public TerminalNode PLEFT() { return getToken(agnostic2SemanticParser.PLEFT, 0); }
		public LeftRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterLeftRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitLeftRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitLeftRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftRightContext leftRight() throws RecognitionException {
		LeftRightContext _localctx = new LeftRightContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_leftRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==PRIGHT || _la==PLEFT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkContext extends ParserRuleContext {
		public TerminalNode TMARK() { return getToken(agnostic2SemanticParser.TMARK, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public MarkPositionalContext markPositional() {
			return getRuleContext(MarkPositionalContext.class,0);
		}
		public MarkUnpositionalContext markUnpositional() {
			return getRuleContext(MarkUnpositionalContext.class,0);
		}
		public MarkUpperLowerContext markUpperLower() {
			return getRuleContext(MarkUpperLowerContext.class,0);
		}
		public MarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitMark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitMark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkContext mark() throws RecognitionException {
		MarkContext _localctx = new MarkContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(TMARK);
			setState(152);
			match(SEPSYMBOL);
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STMARKS_POSITIONAL:
				{
				setState(153);
				markPositional();
				}
				break;
			case STMARKS_UNPOSITIONAL:
				{
				setState(154);
				markUnpositional();
				}
				break;
			case STMARKS_UPPERLOWER:
				{
				setState(155);
				markUpperLower();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkPositionalContext extends ParserRuleContext {
		public TerminalNode STMARKS_POSITIONAL() { return getToken(agnostic2SemanticParser.STMARKS_POSITIONAL, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public PAboveBelowContext pAboveBelow() {
			return getRuleContext(PAboveBelowContext.class,0);
		}
		public MarkPositionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markPositional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterMarkPositional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitMarkPositional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitMarkPositional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkPositionalContext markPositional() throws RecognitionException {
		MarkPositionalContext _localctx = new MarkPositionalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_markPositional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(STMARKS_POSITIONAL);
			setState(159);
			match(SEPPROPERTIES);
			setState(160);
			pAboveBelow();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkUnpositionalContext extends ParserRuleContext {
		public TerminalNode STMARKS_UNPOSITIONAL() { return getToken(agnostic2SemanticParser.STMARKS_UNPOSITIONAL, 0); }
		public MarkUnpositionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markUnpositional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterMarkUnpositional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitMarkUnpositional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitMarkUnpositional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkUnpositionalContext markUnpositional() throws RecognitionException {
		MarkUnpositionalContext _localctx = new MarkUnpositionalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_markUnpositional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(STMARKS_UNPOSITIONAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MarkUpperLowerContext extends ParserRuleContext {
		public TerminalNode STMARKS_UPPERLOWER() { return getToken(agnostic2SemanticParser.STMARKS_UPPERLOWER, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public PUpperLowerContext pUpperLower() {
			return getRuleContext(PUpperLowerContext.class,0);
		}
		public MarkUpperLowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markUpperLower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterMarkUpperLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitMarkUpperLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitMarkUpperLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkUpperLowerContext markUpperLower() throws RecognitionException {
		MarkUpperLowerContext _localctx = new MarkUpperLowerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_markUpperLower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(STMARKS_UPPERLOWER);
			setState(165);
			match(SEPPROPERTIES);
			setState(166);
			pUpperLower();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetersignContext extends ParserRuleContext {
		public TerminalNode TMETERSIGN() { return getToken(agnostic2SemanticParser.TMETERSIGN, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode STMETERSIGNS() { return getToken(agnostic2SemanticParser.STMETERSIGNS, 0); }
		public MetersignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metersign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterMetersign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitMetersign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitMetersign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetersignContext metersign() throws RecognitionException {
		MetersignContext _localctx = new MetersignContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_metersign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(TMETERSIGN);
			setState(169);
			match(SEPSYMBOL);
			setState(170);
			match(STMETERSIGNS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultirestContext extends ParserRuleContext {
		public TerminalNode TMULTIREST() { return getToken(agnostic2SemanticParser.TMULTIREST, 0); }
		public MultirestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multirest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterMultirest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitMultirest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitMultirest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultirestContext multirest() throws RecognitionException {
		MultirestContext _localctx = new MultirestContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_multirest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(TMULTIREST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteContext extends ParserRuleContext {
		public TerminalNode TNOTE() { return getToken(agnostic2SemanticParser.TNOTE, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public NoteFigureContext noteFigure() {
			return getRuleContext(NoteFigureContext.class,0);
		}
		public List<TerminalNode> SEPPROPERTIES() { return getTokens(agnostic2SemanticParser.SEPPROPERTIES); }
		public TerminalNode SEPPROPERTIES(int i) {
			return getToken(agnostic2SemanticParser.SEPPROPERTIES, i);
		}
		public TerminalNode PCHORD() { return getToken(agnostic2SemanticParser.PCHORD, 0); }
		public CueContext cue() {
			return getRuleContext(CueContext.class,0);
		}
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(TNOTE);
			setState(175);
			match(SEPSYMBOL);
			setState(176);
			noteFigure();
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(177);
				match(SEPPROPERTIES);
				setState(178);
				match(PCHORD);
				}
				break;
			}
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(181);
				match(SEPPROPERTIES);
				setState(182);
				cue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CueContext extends ParserRuleContext {
		public TerminalNode PCUE() { return getToken(agnostic2SemanticParser.PCUE, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public TerminalNode PSLASH() { return getToken(agnostic2SemanticParser.PSLASH, 0); }
		public CueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterCue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitCue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitCue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CueContext cue() throws RecognitionException {
		CueContext _localctx = new CueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(PCUE);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(186);
				match(SEPPROPERTIES);
				setState(187);
				match(PSLASH);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoteFigureContext extends ParserRuleContext {
		public TerminalNode STFIGURES_WITHOUT_STEM() { return getToken(agnostic2SemanticParser.STFIGURES_WITHOUT_STEM, 0); }
		public TerminalNode STFIGURES_WITH_STEM() { return getToken(agnostic2SemanticParser.STFIGURES_WITH_STEM, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnostic2SemanticParser.SEPPROPERTIES, 0); }
		public PUpDownContext pUpDown() {
			return getRuleContext(PUpDownContext.class,0);
		}
		public BeamContext beam() {
			return getRuleContext(BeamContext.class,0);
		}
		public NoteFigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteFigure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterNoteFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitNoteFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitNoteFigure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteFigureContext noteFigure() throws RecognitionException {
		NoteFigureContext _localctx = new NoteFigureContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_noteFigure);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STFIGURES_WITHOUT_STEM:
			case STFIGURES_WITH_STEM:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STFIGURES_WITHOUT_STEM:
					{
					setState(190);
					match(STFIGURES_WITHOUT_STEM);
					}
					break;
				case STFIGURES_WITH_STEM:
					{
					setState(191);
					match(STFIGURES_WITH_STEM);
					setState(192);
					match(SEPPROPERTIES);
					setState(193);
					pUpDown();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case STBEAM:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(196);
				beam();
				setState(197);
				match(SEPPROPERTIES);
				setState(198);
				pUpDown();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BeamContext extends ParserRuleContext {
		public TerminalNode STBEAM() { return getToken(agnostic2SemanticParser.STBEAM, 0); }
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public BeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterBeam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitBeam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitBeam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeamContext beam() throws RecognitionException {
		BeamContext _localctx = new BeamContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_beam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(STBEAM);
			setState(203);
			naturalNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestContext extends ParserRuleContext {
		public TerminalNode TREST() { return getToken(agnostic2SemanticParser.TREST, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode STFIGURES_WITHOUT_STEM() { return getToken(agnostic2SemanticParser.STFIGURES_WITHOUT_STEM, 0); }
		public TerminalNode STFIGURES_WITH_STEM() { return getToken(agnostic2SemanticParser.STFIGURES_WITH_STEM, 0); }
		public TerminalNode STMENSURAL_REST_FIGURES() { return getToken(agnostic2SemanticParser.STMENSURAL_REST_FIGURES, 0); }
		public RestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(TREST);
			setState(206);
			match(SEPSYMBOL);
			setState(207);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STFIGURES_WITHOUT_STEM) | (1L << STFIGURES_WITH_STEM) | (1L << STMENSURAL_REST_FIGURES))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SlurContext extends ParserRuleContext {
		public TerminalNode TSLUR() { return getToken(agnostic2SemanticParser.TSLUR, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode PTIE() { return getToken(agnostic2SemanticParser.PTIE, 0); }
		public PStartEndContext pStartEnd() {
			return getRuleContext(PStartEndContext.class,0);
		}
		public SlurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterSlur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitSlur(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitSlur(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlurContext slur() throws RecognitionException {
		SlurContext _localctx = new SlurContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_slur);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(TSLUR);
			setState(210);
			match(SEPSYMBOL);
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PTIE:
				{
				setState(211);
				match(PTIE);
				}
				break;
			case PSTART:
			case PEND:
				{
				setState(212);
				pStartEnd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerticalLineContext extends ParserRuleContext {
		public TerminalNode TVERTICAL_LINE() { return getToken(agnostic2SemanticParser.TVERTICAL_LINE, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnostic2SemanticParser.SEPSYMBOL, 0); }
		public TerminalNode STLINEWIDTH() { return getToken(agnostic2SemanticParser.STLINEWIDTH, 0); }
		public VerticalLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verticalLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterVerticalLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitVerticalLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitVerticalLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerticalLineContext verticalLine() throws RecognitionException {
		VerticalLineContext _localctx = new VerticalLineContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_verticalLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(TVERTICAL_LINE);
			setState(216);
			match(SEPSYMBOL);
			setState(217);
			match(STLINEWIDTH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PUpDownContext extends ParserRuleContext {
		public TerminalNode PUP() { return getToken(agnostic2SemanticParser.PUP, 0); }
		public TerminalNode PDOWN() { return getToken(agnostic2SemanticParser.PDOWN, 0); }
		public PUpDownContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pUpDown; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterPUpDown(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitPUpDown(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitPUpDown(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PUpDownContext pUpDown() throws RecognitionException {
		PUpDownContext _localctx = new PUpDownContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pUpDown);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !(_la==PUP || _la==PDOWN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PAboveBelowContext extends ParserRuleContext {
		public TerminalNode PABOVE() { return getToken(agnostic2SemanticParser.PABOVE, 0); }
		public TerminalNode PBELOW() { return getToken(agnostic2SemanticParser.PBELOW, 0); }
		public PAboveBelowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pAboveBelow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterPAboveBelow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitPAboveBelow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitPAboveBelow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PAboveBelowContext pAboveBelow() throws RecognitionException {
		PAboveBelowContext _localctx = new PAboveBelowContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pAboveBelow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_la = _input.LA(1);
			if ( !(_la==PABOVE || _la==PBELOW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PStartEndContext extends ParserRuleContext {
		public TerminalNode PSTART() { return getToken(agnostic2SemanticParser.PSTART, 0); }
		public TerminalNode PEND() { return getToken(agnostic2SemanticParser.PEND, 0); }
		public PStartEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pStartEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterPStartEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitPStartEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitPStartEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PStartEndContext pStartEnd() throws RecognitionException {
		PStartEndContext _localctx = new PStartEndContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pStartEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_la = _input.LA(1);
			if ( !(_la==PSTART || _la==PEND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PUpperLowerContext extends ParserRuleContext {
		public TerminalNode PUPPER() { return getToken(agnostic2SemanticParser.PUPPER, 0); }
		public TerminalNode PLOWER() { return getToken(agnostic2SemanticParser.PLOWER, 0); }
		public PUpperLowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pUpperLower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterPUpperLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitPUpperLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitPUpperLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PUpperLowerContext pUpperLower() throws RecognitionException {
		PUpperLowerContext _localctx = new PUpperLowerContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_pUpperLower);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !(_la==PUPPER || _la==PLOWER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NaturalNumberContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT_0() { return getTokens(agnostic2SemanticParser.DIGIT_0); }
		public TerminalNode DIGIT_0(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_0, i);
		}
		public List<TerminalNode> DIGIT_1() { return getTokens(agnostic2SemanticParser.DIGIT_1); }
		public TerminalNode DIGIT_1(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_1, i);
		}
		public List<TerminalNode> DIGIT_2() { return getTokens(agnostic2SemanticParser.DIGIT_2); }
		public TerminalNode DIGIT_2(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_2, i);
		}
		public List<TerminalNode> DIGIT_3() { return getTokens(agnostic2SemanticParser.DIGIT_3); }
		public TerminalNode DIGIT_3(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_3, i);
		}
		public List<TerminalNode> DIGIT_4() { return getTokens(agnostic2SemanticParser.DIGIT_4); }
		public TerminalNode DIGIT_4(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_4, i);
		}
		public List<TerminalNode> DIGIT_5() { return getTokens(agnostic2SemanticParser.DIGIT_5); }
		public TerminalNode DIGIT_5(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_5, i);
		}
		public List<TerminalNode> DIGIT_6() { return getTokens(agnostic2SemanticParser.DIGIT_6); }
		public TerminalNode DIGIT_6(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_6, i);
		}
		public List<TerminalNode> DIGIT_7() { return getTokens(agnostic2SemanticParser.DIGIT_7); }
		public TerminalNode DIGIT_7(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_7, i);
		}
		public List<TerminalNode> DIGIT_8() { return getTokens(agnostic2SemanticParser.DIGIT_8); }
		public TerminalNode DIGIT_8(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_8, i);
		}
		public List<TerminalNode> DIGIT_9() { return getTokens(agnostic2SemanticParser.DIGIT_9); }
		public TerminalNode DIGIT_9(int i) {
			return getToken(agnostic2SemanticParser.DIGIT_9, i);
		}
		public NaturalNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_naturalNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterNaturalNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitNaturalNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitNaturalNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NaturalNumberContext naturalNumber() throws RecognitionException {
		NaturalNumberContext _localctx = new NaturalNumberContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_naturalNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_0) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_0) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public TerminalNode HYPHEN() { return getToken(agnostic2SemanticParser.HYPHEN, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnostic2SemanticParserListener ) ((agnostic2SemanticParserListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnostic2SemanticParserVisitor ) return ((agnostic2SemanticParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HYPHEN) {
				{
				setState(232);
				match(HYPHEN);
				}
			}

			setState(235);
			naturalNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u00f0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2"+
		"\7\2T\n\2\f\2\16\2W\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4`\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0082\n"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u009f\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00b6\n\31\3\31\3\31"+
		"\5\31\u00ba\n\31\3\32\3\32\3\32\5\32\u00bf\n\32\3\33\3\33\3\33\3\33\5"+
		"\33\u00c5\n\33\3\33\3\33\3\33\3\33\5\33\u00cb\n\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u00d8\n\36\3\37\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\6$\u00e7\n$\r$\16$\u00e8\3%\5%\u00ec\n%"+
		"\3%\3%\3%\2\2&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFH\2\f\3\2\7\b\3\2\17\21\3\2\23\27\3\2\36\37\3\2 !\4\2,-\60"+
		"\60\3\2\65\66\3\2\678\3\29:\4\2\23\27;?\2\u00da\2J\3\2\2\2\4X\3\2\2\2"+
		"\6_\3\2\2\2\bg\3\2\2\2\ni\3\2\2\2\fk\3\2\2\2\16o\3\2\2\2\20r\3\2\2\2\22"+
		"t\3\2\2\2\24{\3\2\2\2\26\u0083\3\2\2\2\30\u0085\3\2\2\2\32\u0087\3\2\2"+
		"\2\34\u0089\3\2\2\2\36\u008d\3\2\2\2 \u0093\3\2\2\2\"\u0097\3\2\2\2$\u0099"+
		"\3\2\2\2&\u00a0\3\2\2\2(\u00a4\3\2\2\2*\u00a6\3\2\2\2,\u00aa\3\2\2\2."+
		"\u00ae\3\2\2\2\60\u00b0\3\2\2\2\62\u00bb\3\2\2\2\64\u00ca\3\2\2\2\66\u00cc"+
		"\3\2\2\28\u00cf\3\2\2\2:\u00d3\3\2\2\2<\u00d9\3\2\2\2>\u00dd\3\2\2\2@"+
		"\u00df\3\2\2\2B\u00e1\3\2\2\2D\u00e3\3\2\2\2F\u00e6\3\2\2\2H\u00eb\3\2"+
		"\2\2JO\5\4\3\2KL\7\3\2\2LN\5\6\4\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2"+
		"\2\2PU\3\2\2\2QO\3\2\2\2RT\7\3\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2"+
		"\2\2V\3\3\2\2\2WU\3\2\2\2XY\7\4\2\2YZ\7\5\2\2Z[\5F$\2[\5\3\2\2\2\\]\5"+
		"\f\7\2]^\7\6\2\2^`\3\2\2\2_\\\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\5\b\5\2bc"+
		"\7\5\2\2cd\5\16\b\2de\7\5\2\2ef\5\20\t\2f\7\3\2\2\2gh\5\n\6\2h\t\3\2\2"+
		"\2ij\5\24\13\2j\13\3\2\2\2kl\5F$\2lm\7\6\2\2mn\5F$\2n\r\3\2\2\2op\t\2"+
		"\2\2pq\5H%\2q\17\3\2\2\2rs\5F$\2s\21\3\2\2\2tu\7\t\2\2uv\7\n\2\2vy\7\13"+
		"\2\2wx\7\f\2\2xz\7\r\2\2yw\3\2\2\2yz\3\2\2\2z\23\3\2\2\2{|\7\16\2\2|}"+
		"\7\n\2\2}~\t\3\2\2~\u0081\5\26\f\2\177\u0080\7\f\2\2\u0080\u0082\7\22"+
		"\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\25\3\2\2\2\u0083\u0084"+
		"\t\4\2\2\u0084\27\3\2\2\2\u0085\u0086\7\30\2\2\u0086\31\3\2\2\2\u0087"+
		"\u0088\7\31\2\2\u0088\33\3\2\2\2\u0089\u008a\7\32\2\2\u008a\u008b\7\n"+
		"\2\2\u008b\u008c\5F$\2\u008c\35\3\2\2\2\u008d\u008e\7\33\2\2\u008e\u008f"+
		"\7\n\2\2\u008f\u0090\7\34\2\2\u0090\u0091\7\f\2\2\u0091\u0092\5\"\22\2"+
		"\u0092\37\3\2\2\2\u0093\u0094\7\35\2\2\u0094\u0095\7\n\2\2\u0095\u0096"+
		"\t\5\2\2\u0096!\3\2\2\2\u0097\u0098\t\6\2\2\u0098#\3\2\2\2\u0099\u009a"+
		"\7\"\2\2\u009a\u009e\7\n\2\2\u009b\u009f\5&\24\2\u009c\u009f\5(\25\2\u009d"+
		"\u009f\5*\26\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2"+
		"\2\2\u009f%\3\2\2\2\u00a0\u00a1\7#\2\2\u00a1\u00a2\7\f\2\2\u00a2\u00a3"+
		"\5@!\2\u00a3\'\3\2\2\2\u00a4\u00a5\7$\2\2\u00a5)\3\2\2\2\u00a6\u00a7\7"+
		"%\2\2\u00a7\u00a8\7\f\2\2\u00a8\u00a9\5D#\2\u00a9+\3\2\2\2\u00aa\u00ab"+
		"\7&\2\2\u00ab\u00ac\7\n\2\2\u00ac\u00ad\7\'\2\2\u00ad-\3\2\2\2\u00ae\u00af"+
		"\7(\2\2\u00af/\3\2\2\2\u00b0\u00b1\7)\2\2\u00b1\u00b2\7\n\2\2\u00b2\u00b5"+
		"\5\64\33\2\u00b3\u00b4\7\f\2\2\u00b4\u00b6\7*\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b8\7\f\2\2\u00b8\u00ba"+
		"\5\62\32\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\61\3\2\2\2\u00bb"+
		"\u00be\7\r\2\2\u00bc\u00bd\7\f\2\2\u00bd\u00bf\7+\2\2\u00be\u00bc\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\63\3\2\2\2\u00c0\u00c5\7,\2\2\u00c1\u00c2"+
		"\7-\2\2\u00c2\u00c3\7\f\2\2\u00c3\u00c5\5> \2\u00c4\u00c0\3\2\2\2\u00c4"+
		"\u00c1\3\2\2\2\u00c5\u00cb\3\2\2\2\u00c6\u00c7\5\66\34\2\u00c7\u00c8\7"+
		"\f\2\2\u00c8\u00c9\5> \2\u00c9\u00cb\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca"+
		"\u00c6\3\2\2\2\u00cb\65\3\2\2\2\u00cc\u00cd\7.\2\2\u00cd\u00ce\5F$\2\u00ce"+
		"\67\3\2\2\2\u00cf\u00d0\7/\2\2\u00d0\u00d1\7\n\2\2\u00d1\u00d2\t\7\2\2"+
		"\u00d29\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d7\7\n\2\2\u00d5\u00d8\7"+
		"\62\2\2\u00d6\u00d8\5B\"\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8"+
		";\3\2\2\2\u00d9\u00da\7\63\2\2\u00da\u00db\7\n\2\2\u00db\u00dc\7\64\2"+
		"\2\u00dc=\3\2\2\2\u00dd\u00de\t\b\2\2\u00de?\3\2\2\2\u00df\u00e0\t\t\2"+
		"\2\u00e0A\3\2\2\2\u00e1\u00e2\t\5\2\2\u00e2C\3\2\2\2\u00e3\u00e4\t\n\2"+
		"\2\u00e4E\3\2\2\2\u00e5\u00e7\t\13\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9G\3\2\2\2\u00ea"+
		"\u00ec\7@\2\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\5F$\2\u00eeI\3\2\2\2\20OU_y\u0081\u009e\u00b5\u00b9\u00be"+
		"\u00c4\u00ca\u00d7\u00e8\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}