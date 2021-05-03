// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnosticParser.g4 by ANTLR 4.9.1


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class agnosticParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VERSION=1, TACCIDENTAL=2, TCLEF=3, TCOLON=4, TDIGIT=5, TENCLOSURE=6, TDOT=7, 
		THORIZONTAL_BRACKET=8, TMARK=9, TMETERSIGN=10, TMULTIREST=11, TNOTE=12, 
		TREST=13, TSLUR=14, TVERTICAL_LINE=15, SEPSYMBOL=16, SEPPROPERTIES=17, 
		STCLEFOCTAVE=18, STACCIDENTALS=19, STMETERSIGNS=20, STFIGURES_WITH_STEM=21, 
		STFIGURES_WITHOUT_STEM=22, STMENSURAL_REST_FIGURES=23, STMARKS_UNPOSITIONAL=24, 
		STMARKS_POSITIONAL=25, STMARKS_UPPERLOWER=26, STBEAM=27, STLINEWIDTH=28, 
		STENCLOSURES=29, PSTART=30, PEND=31, PDOWN=32, PUP=33, PABOVE=34, PBELOW=35, 
		PUPPER=36, PLOWER=37, PCHORD=38, PCUE=39, PSLASH=40, PTIE=41, PRIGHT=42, 
		PLEFT=43, COLON=44, CHAR_C=45, CHAR_F=46, CHAR_G=47, CHAR_L=48, CHAR_S=49, 
		DIGIT_0=50, DIGIT_1=51, DIGIT_2=52, DIGIT_3=53, DIGIT_4=54, DIGIT_5=55, 
		DIGIT_6=56, DIGIT_7=57, DIGIT_8=58, DIGIT_9=59, EOL=60, HYPHEN=61, TAB=62;
	public static final int
		RULE_start = 0, RULE_version = 1, RULE_agnosticSymbol = 2, RULE_coordinates = 3, 
		RULE_positionInStaff = 4, RULE_staff = 5, RULE_symbol = 6, RULE_accidental = 7, 
		RULE_clef = 8, RULE_clefLine = 9, RULE_colon = 10, RULE_dot = 11, RULE_digit = 12, 
		RULE_enclosure = 13, RULE_horizontalBracket = 14, RULE_leftRight = 15, 
		RULE_mark = 16, RULE_markPositional = 17, RULE_markUnpositional = 18, 
		RULE_markUpperLower = 19, RULE_metersign = 20, RULE_multirest = 21, RULE_note = 22, 
		RULE_cue = 23, RULE_noteFigure = 24, RULE_beam = 25, RULE_rest = 26, RULE_slur = 27, 
		RULE_verticalLine = 28, RULE_pUpDown = 29, RULE_pAboveBelow = 30, RULE_pStartEnd = 31, 
		RULE_pUpperLower = 32, RULE_naturalNumber = 33, RULE_integer = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "version", "agnosticSymbol", "coordinates", "positionInStaff", 
			"staff", "symbol", "accidental", "clef", "clefLine", "colon", "dot", 
			"digit", "enclosure", "horizontalBracket", "leftRight", "mark", "markPositional", 
			"markUnpositional", "markUpperLower", "metersign", "multirest", "note", 
			"cue", "noteFigure", "beam", "rest", "slur", "verticalLine", "pUpDown", 
			"pAboveBelow", "pStartEnd", "pUpperLower", "naturalNumber", "integer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'version'", "'accidental'", "'clef'", "'colon'", "'digit'", "'enclosure'", 
			"'dot'", "'horizBracket'", "'mark'", "'metersign'", "'multirest'", "'note'", 
			"'rest'", "'slur'", "'verticalLine'", null, null, null, null, null, null, 
			null, null, null, null, "'turn'", null, null, null, "'start'", "'end'", 
			"'down'", "'up'", "'above'", "'below'", "'upper'", "'lower'", "'chord'", 
			"'cue'", "'slash'", "'tie'", "'right'", "'left'", "':'", "'C'", "'F'", 
			"'G'", "'L'", "'S'", "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", 
			"'7'", "'8'", "'9'", null, "'-'", "'\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VERSION", "TACCIDENTAL", "TCLEF", "TCOLON", "TDIGIT", "TENCLOSURE", 
			"TDOT", "THORIZONTAL_BRACKET", "TMARK", "TMETERSIGN", "TMULTIREST", "TNOTE", 
			"TREST", "TSLUR", "TVERTICAL_LINE", "SEPSYMBOL", "SEPPROPERTIES", "STCLEFOCTAVE", 
			"STACCIDENTALS", "STMETERSIGNS", "STFIGURES_WITH_STEM", "STFIGURES_WITHOUT_STEM", 
			"STMENSURAL_REST_FIGURES", "STMARKS_UNPOSITIONAL", "STMARKS_POSITIONAL", 
			"STMARKS_UPPERLOWER", "STBEAM", "STLINEWIDTH", "STENCLOSURES", "PSTART", 
			"PEND", "PDOWN", "PUP", "PABOVE", "PBELOW", "PUPPER", "PLOWER", "PCHORD", 
			"PCUE", "PSLASH", "PTIE", "PRIGHT", "PLEFT", "COLON", "CHAR_C", "CHAR_F", 
			"CHAR_G", "CHAR_L", "CHAR_S", "DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", 
			"DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", "EOL", 
			"HYPHEN", "TAB"
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
	public String getGrammarFileName() { return "agnosticParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public agnosticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(agnosticParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(agnosticParser.EOL, i);
		}
		public List<AgnosticSymbolContext> agnosticSymbol() {
			return getRuleContexts(AgnosticSymbolContext.class);
		}
		public AgnosticSymbolContext agnosticSymbol(int i) {
			return getRuleContext(AgnosticSymbolContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			version();
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(71);
					match(EOL);
					setState(72);
					agnosticSymbol();
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(78);
				match(EOL);
				}
				}
				setState(83);
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
		public TerminalNode VERSION() { return getToken(agnosticParser.VERSION, 0); }
		public TerminalNode COLON() { return getToken(agnosticParser.COLON, 0); }
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitVersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitVersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_version);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(VERSION);
			setState(85);
			match(COLON);
			setState(86);
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

	public static class AgnosticSymbolContext extends ParserRuleContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(agnosticParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(agnosticParser.COLON, i);
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
		public TerminalNode TAB() { return getToken(agnosticParser.TAB, 0); }
		public AgnosticSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agnosticSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAgnosticSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAgnosticSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAgnosticSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgnosticSymbolContext agnosticSymbol() throws RecognitionException {
		AgnosticSymbolContext _localctx = new AgnosticSymbolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_agnosticSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_0) | (1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0)) {
				{
				setState(88);
				coordinates();
				setState(89);
				match(TAB);
				}
			}

			setState(93);
			symbol();
			setState(94);
			match(COLON);
			setState(95);
			positionInStaff();
			setState(96);
			match(COLON);
			setState(97);
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

	public static class CoordinatesContext extends ParserRuleContext {
		public List<NaturalNumberContext> naturalNumber() {
			return getRuleContexts(NaturalNumberContext.class);
		}
		public NaturalNumberContext naturalNumber(int i) {
			return getRuleContext(NaturalNumberContext.class,i);
		}
		public TerminalNode TAB() { return getToken(agnosticParser.TAB, 0); }
		public CoordinatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterCoordinates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitCoordinates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitCoordinates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordinatesContext coordinates() throws RecognitionException {
		CoordinatesContext _localctx = new CoordinatesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_coordinates);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			naturalNumber();
			setState(100);
			match(TAB);
			setState(101);
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
		public TerminalNode CHAR_L() { return getToken(agnosticParser.CHAR_L, 0); }
		public TerminalNode CHAR_S() { return getToken(agnosticParser.CHAR_S, 0); }
		public PositionInStaffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positionInStaff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPositionInStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPositionInStaff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPositionInStaff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionInStaffContext positionInStaff() throws RecognitionException {
		PositionInStaffContext _localctx = new PositionInStaffContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_positionInStaff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !(_la==CHAR_L || _la==CHAR_S) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
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
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitStaff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitStaff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaffContext staff() throws RecognitionException {
		StaffContext _localctx = new StaffContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_staff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
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

	public static class SymbolContext extends ParserRuleContext {
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
		}
		public HorizontalBracketContext horizontalBracket() {
			return getRuleContext(HorizontalBracketContext.class,0);
		}
		public ClefContext clef() {
			return getRuleContext(ClefContext.class,0);
		}
		public ColonContext colon() {
			return getRuleContext(ColonContext.class,0);
		}
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public DotContext dot() {
			return getRuleContext(DotContext.class,0);
		}
		public EnclosureContext enclosure() {
			return getRuleContext(EnclosureContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public MetersignContext metersign() {
			return getRuleContext(MetersignContext.class,0);
		}
		public MultirestContext multirest() {
			return getRuleContext(MultirestContext.class,0);
		}
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public SlurContext slur() {
			return getRuleContext(SlurContext.class,0);
		}
		public VerticalLineContext verticalLine() {
			return getRuleContext(VerticalLineContext.class,0);
		}
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_symbol);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TACCIDENTAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				accidental();
				}
				break;
			case THORIZONTAL_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				horizontalBracket();
				}
				break;
			case TCLEF:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				clef();
				}
				break;
			case TCOLON:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				colon();
				}
				break;
			case TDIGIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				digit();
				}
				break;
			case TDOT:
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				dot();
				}
				break;
			case TENCLOSURE:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				enclosure();
				}
				break;
			case TMARK:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				mark();
				}
				break;
			case TMETERSIGN:
				enterOuterAlt(_localctx, 9);
				{
				setState(116);
				metersign();
				}
				break;
			case TMULTIREST:
				enterOuterAlt(_localctx, 10);
				{
				setState(117);
				multirest();
				}
				break;
			case TNOTE:
				enterOuterAlt(_localctx, 11);
				{
				setState(118);
				note();
				}
				break;
			case TREST:
				enterOuterAlt(_localctx, 12);
				{
				setState(119);
				rest();
				}
				break;
			case TSLUR:
				enterOuterAlt(_localctx, 13);
				{
				setState(120);
				slur();
				}
				break;
			case TVERTICAL_LINE:
				enterOuterAlt(_localctx, 14);
				{
				setState(121);
				verticalLine();
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

	public static class AccidentalContext extends ParserRuleContext {
		public TerminalNode TACCIDENTAL() { return getToken(agnosticParser.TACCIDENTAL, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode STACCIDENTALS() { return getToken(agnosticParser.STACCIDENTALS, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
		public TerminalNode PCUE() { return getToken(agnosticParser.PCUE, 0); }
		public AccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAccidental(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAccidental(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccidentalContext accidental() throws RecognitionException {
		AccidentalContext _localctx = new AccidentalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_accidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(TACCIDENTAL);
			setState(125);
			match(SEPSYMBOL);
			setState(126);
			match(STACCIDENTALS);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(127);
				match(SEPPROPERTIES);
				setState(128);
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
		public TerminalNode TCLEF() { return getToken(agnosticParser.TCLEF, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public ClefLineContext clefLine() {
			return getRuleContext(ClefLineContext.class,0);
		}
		public TerminalNode CHAR_C() { return getToken(agnosticParser.CHAR_C, 0); }
		public TerminalNode CHAR_F() { return getToken(agnosticParser.CHAR_F, 0); }
		public TerminalNode CHAR_G() { return getToken(agnosticParser.CHAR_G, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
		public TerminalNode STCLEFOCTAVE() { return getToken(agnosticParser.STCLEFOCTAVE, 0); }
		public ClefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterClef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitClef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitClef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClefContext clef() throws RecognitionException {
		ClefContext _localctx = new ClefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_clef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(TCLEF);
			setState(132);
			match(SEPSYMBOL);
			setState(133);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_C) | (1L << CHAR_F) | (1L << CHAR_G))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(134);
			clefLine();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(135);
				match(SEPPROPERTIES);
				setState(136);
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
		public TerminalNode DIGIT_1() { return getToken(agnosticParser.DIGIT_1, 0); }
		public TerminalNode DIGIT_2() { return getToken(agnosticParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnosticParser.DIGIT_3, 0); }
		public TerminalNode DIGIT_4() { return getToken(agnosticParser.DIGIT_4, 0); }
		public TerminalNode DIGIT_5() { return getToken(agnosticParser.DIGIT_5, 0); }
		public ClefLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clefLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterClefLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitClefLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitClefLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClefLineContext clefLine() throws RecognitionException {
		ClefLineContext _localctx = new ClefLineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clefLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
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
		public TerminalNode TCOLON() { return getToken(agnosticParser.TCOLON, 0); }
		public ColonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitColon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitColon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColonContext colon() throws RecognitionException {
		ColonContext _localctx = new ColonContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_colon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
		public TerminalNode TDOT() { return getToken(agnosticParser.TDOT, 0); }
		public DotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitDot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotContext dot() throws RecognitionException {
		DotContext _localctx = new DotContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
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
		public TerminalNode TDIGIT() { return getToken(agnosticParser.TDIGIT, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(TDIGIT);
			setState(146);
			match(SEPSYMBOL);
			setState(147);
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
		public TerminalNode TENCLOSURE() { return getToken(agnosticParser.TENCLOSURE, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode STENCLOSURES() { return getToken(agnosticParser.STENCLOSURES, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
		public LeftRightContext leftRight() {
			return getRuleContext(LeftRightContext.class,0);
		}
		public EnclosureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterEnclosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitEnclosure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitEnclosure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnclosureContext enclosure() throws RecognitionException {
		EnclosureContext _localctx = new EnclosureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enclosure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(TENCLOSURE);
			setState(150);
			match(SEPSYMBOL);
			setState(151);
			match(STENCLOSURES);
			setState(152);
			match(SEPPROPERTIES);
			setState(153);
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
		public TerminalNode THORIZONTAL_BRACKET() { return getToken(agnosticParser.THORIZONTAL_BRACKET, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode PSTART() { return getToken(agnosticParser.PSTART, 0); }
		public TerminalNode PEND() { return getToken(agnosticParser.PEND, 0); }
		public HorizontalBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horizontalBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterHorizontalBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitHorizontalBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitHorizontalBracket(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HorizontalBracketContext horizontalBracket() throws RecognitionException {
		HorizontalBracketContext _localctx = new HorizontalBracketContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_horizontalBracket);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(THORIZONTAL_BRACKET);
			setState(156);
			match(SEPSYMBOL);
			setState(157);
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
		public TerminalNode PRIGHT() { return getToken(agnosticParser.PRIGHT, 0); }
		public TerminalNode PLEFT() { return getToken(agnosticParser.PLEFT, 0); }
		public LeftRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLeftRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLeftRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLeftRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftRightContext leftRight() throws RecognitionException {
		LeftRightContext _localctx = new LeftRightContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_leftRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
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
		public TerminalNode TMARK() { return getToken(agnosticParser.TMARK, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
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
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkContext mark() throws RecognitionException {
		MarkContext _localctx = new MarkContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(TMARK);
			setState(162);
			match(SEPSYMBOL);
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STMARKS_POSITIONAL:
				{
				setState(163);
				markPositional();
				}
				break;
			case STMARKS_UNPOSITIONAL:
				{
				setState(164);
				markUnpositional();
				}
				break;
			case STMARKS_UPPERLOWER:
				{
				setState(165);
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
		public TerminalNode STMARKS_POSITIONAL() { return getToken(agnosticParser.STMARKS_POSITIONAL, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
		public PAboveBelowContext pAboveBelow() {
			return getRuleContext(PAboveBelowContext.class,0);
		}
		public MarkPositionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markPositional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMarkPositional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMarkPositional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMarkPositional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkPositionalContext markPositional() throws RecognitionException {
		MarkPositionalContext _localctx = new MarkPositionalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_markPositional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(STMARKS_POSITIONAL);
			setState(169);
			match(SEPPROPERTIES);
			setState(170);
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
		public TerminalNode STMARKS_UNPOSITIONAL() { return getToken(agnosticParser.STMARKS_UNPOSITIONAL, 0); }
		public MarkUnpositionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markUnpositional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMarkUnpositional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMarkUnpositional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMarkUnpositional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkUnpositionalContext markUnpositional() throws RecognitionException {
		MarkUnpositionalContext _localctx = new MarkUnpositionalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_markUnpositional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		public TerminalNode STMARKS_UPPERLOWER() { return getToken(agnosticParser.STMARKS_UPPERLOWER, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
		public PUpperLowerContext pUpperLower() {
			return getRuleContext(PUpperLowerContext.class,0);
		}
		public MarkUpperLowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markUpperLower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMarkUpperLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMarkUpperLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMarkUpperLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkUpperLowerContext markUpperLower() throws RecognitionException {
		MarkUpperLowerContext _localctx = new MarkUpperLowerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_markUpperLower);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(STMARKS_UPPERLOWER);
			setState(175);
			match(SEPPROPERTIES);
			setState(176);
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
		public TerminalNode TMETERSIGN() { return getToken(agnosticParser.TMETERSIGN, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode STMETERSIGNS() { return getToken(agnosticParser.STMETERSIGNS, 0); }
		public MetersignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metersign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMetersign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMetersign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMetersign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetersignContext metersign() throws RecognitionException {
		MetersignContext _localctx = new MetersignContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_metersign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(TMETERSIGN);
			setState(179);
			match(SEPSYMBOL);
			setState(180);
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
		public TerminalNode TMULTIREST() { return getToken(agnosticParser.TMULTIREST, 0); }
		public MultirestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multirest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMultirest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMultirest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMultirest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultirestContext multirest() throws RecognitionException {
		MultirestContext _localctx = new MultirestContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_multirest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		public TerminalNode TNOTE() { return getToken(agnosticParser.TNOTE, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public NoteFigureContext noteFigure() {
			return getRuleContext(NoteFigureContext.class,0);
		}
		public List<TerminalNode> SEPPROPERTIES() { return getTokens(agnosticParser.SEPPROPERTIES); }
		public TerminalNode SEPPROPERTIES(int i) {
			return getToken(agnosticParser.SEPPROPERTIES, i);
		}
		public TerminalNode PCHORD() { return getToken(agnosticParser.PCHORD, 0); }
		public CueContext cue() {
			return getRuleContext(CueContext.class,0);
		}
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(TNOTE);
			setState(185);
			match(SEPSYMBOL);
			setState(186);
			noteFigure();
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(187);
				match(SEPPROPERTIES);
				setState(188);
				match(PCHORD);
				}
				break;
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(191);
				match(SEPPROPERTIES);
				setState(192);
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
		public TerminalNode PCUE() { return getToken(agnosticParser.PCUE, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
		public TerminalNode PSLASH() { return getToken(agnosticParser.PSLASH, 0); }
		public CueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterCue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitCue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitCue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CueContext cue() throws RecognitionException {
		CueContext _localctx = new CueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(PCUE);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEPPROPERTIES) {
				{
				setState(196);
				match(SEPPROPERTIES);
				setState(197);
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
		public TerminalNode STFIGURES_WITHOUT_STEM() { return getToken(agnosticParser.STFIGURES_WITHOUT_STEM, 0); }
		public TerminalNode STFIGURES_WITH_STEM() { return getToken(agnosticParser.STFIGURES_WITH_STEM, 0); }
		public TerminalNode SEPPROPERTIES() { return getToken(agnosticParser.SEPPROPERTIES, 0); }
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
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNoteFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNoteFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNoteFigure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteFigureContext noteFigure() throws RecognitionException {
		NoteFigureContext _localctx = new NoteFigureContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_noteFigure);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STFIGURES_WITH_STEM:
			case STFIGURES_WITHOUT_STEM:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STFIGURES_WITHOUT_STEM:
					{
					setState(200);
					match(STFIGURES_WITHOUT_STEM);
					}
					break;
				case STFIGURES_WITH_STEM:
					{
					setState(201);
					match(STFIGURES_WITH_STEM);
					setState(202);
					match(SEPPROPERTIES);
					setState(203);
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
				setState(206);
				beam();
				setState(207);
				match(SEPPROPERTIES);
				setState(208);
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
		public TerminalNode STBEAM() { return getToken(agnosticParser.STBEAM, 0); }
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public BeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBeam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBeam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBeam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeamContext beam() throws RecognitionException {
		BeamContext _localctx = new BeamContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_beam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(STBEAM);
			setState(213);
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
		public TerminalNode TREST() { return getToken(agnosticParser.TREST, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode STFIGURES_WITHOUT_STEM() { return getToken(agnosticParser.STFIGURES_WITHOUT_STEM, 0); }
		public TerminalNode STFIGURES_WITH_STEM() { return getToken(agnosticParser.STFIGURES_WITH_STEM, 0); }
		public TerminalNode STMENSURAL_REST_FIGURES() { return getToken(agnosticParser.STMENSURAL_REST_FIGURES, 0); }
		public RestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(TREST);
			setState(216);
			match(SEPSYMBOL);
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STFIGURES_WITH_STEM) | (1L << STFIGURES_WITHOUT_STEM) | (1L << STMENSURAL_REST_FIGURES))) != 0)) ) {
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
		public TerminalNode TSLUR() { return getToken(agnosticParser.TSLUR, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode PTIE() { return getToken(agnosticParser.PTIE, 0); }
		public PStartEndContext pStartEnd() {
			return getRuleContext(PStartEndContext.class,0);
		}
		public SlurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSlur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSlur(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSlur(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlurContext slur() throws RecognitionException {
		SlurContext _localctx = new SlurContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_slur);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(TSLUR);
			setState(220);
			match(SEPSYMBOL);
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PTIE:
				{
				setState(221);
				match(PTIE);
				}
				break;
			case PSTART:
			case PEND:
				{
				setState(222);
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
		public TerminalNode TVERTICAL_LINE() { return getToken(agnosticParser.TVERTICAL_LINE, 0); }
		public TerminalNode SEPSYMBOL() { return getToken(agnosticParser.SEPSYMBOL, 0); }
		public TerminalNode STLINEWIDTH() { return getToken(agnosticParser.STLINEWIDTH, 0); }
		public VerticalLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verticalLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterVerticalLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitVerticalLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitVerticalLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerticalLineContext verticalLine() throws RecognitionException {
		VerticalLineContext _localctx = new VerticalLineContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_verticalLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(TVERTICAL_LINE);
			setState(226);
			match(SEPSYMBOL);
			setState(227);
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
		public TerminalNode PUP() { return getToken(agnosticParser.PUP, 0); }
		public TerminalNode PDOWN() { return getToken(agnosticParser.PDOWN, 0); }
		public PUpDownContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pUpDown; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPUpDown(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPUpDown(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPUpDown(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PUpDownContext pUpDown() throws RecognitionException {
		PUpDownContext _localctx = new PUpDownContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_pUpDown);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_la = _input.LA(1);
			if ( !(_la==PDOWN || _la==PUP) ) {
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
		public TerminalNode PABOVE() { return getToken(agnosticParser.PABOVE, 0); }
		public TerminalNode PBELOW() { return getToken(agnosticParser.PBELOW, 0); }
		public PAboveBelowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pAboveBelow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPAboveBelow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPAboveBelow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPAboveBelow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PAboveBelowContext pAboveBelow() throws RecognitionException {
		PAboveBelowContext _localctx = new PAboveBelowContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pAboveBelow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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
		public TerminalNode PSTART() { return getToken(agnosticParser.PSTART, 0); }
		public TerminalNode PEND() { return getToken(agnosticParser.PEND, 0); }
		public PStartEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pStartEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPStartEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPStartEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPStartEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PStartEndContext pStartEnd() throws RecognitionException {
		PStartEndContext _localctx = new PStartEndContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pStartEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
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
		public TerminalNode PUPPER() { return getToken(agnosticParser.PUPPER, 0); }
		public TerminalNode PLOWER() { return getToken(agnosticParser.PLOWER, 0); }
		public PUpperLowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pUpperLower; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPUpperLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPUpperLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPUpperLower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PUpperLowerContext pUpperLower() throws RecognitionException {
		PUpperLowerContext _localctx = new PUpperLowerContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pUpperLower);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		public List<TerminalNode> DIGIT_0() { return getTokens(agnosticParser.DIGIT_0); }
		public TerminalNode DIGIT_0(int i) {
			return getToken(agnosticParser.DIGIT_0, i);
		}
		public List<TerminalNode> DIGIT_1() { return getTokens(agnosticParser.DIGIT_1); }
		public TerminalNode DIGIT_1(int i) {
			return getToken(agnosticParser.DIGIT_1, i);
		}
		public List<TerminalNode> DIGIT_2() { return getTokens(agnosticParser.DIGIT_2); }
		public TerminalNode DIGIT_2(int i) {
			return getToken(agnosticParser.DIGIT_2, i);
		}
		public List<TerminalNode> DIGIT_3() { return getTokens(agnosticParser.DIGIT_3); }
		public TerminalNode DIGIT_3(int i) {
			return getToken(agnosticParser.DIGIT_3, i);
		}
		public List<TerminalNode> DIGIT_4() { return getTokens(agnosticParser.DIGIT_4); }
		public TerminalNode DIGIT_4(int i) {
			return getToken(agnosticParser.DIGIT_4, i);
		}
		public List<TerminalNode> DIGIT_5() { return getTokens(agnosticParser.DIGIT_5); }
		public TerminalNode DIGIT_5(int i) {
			return getToken(agnosticParser.DIGIT_5, i);
		}
		public List<TerminalNode> DIGIT_6() { return getTokens(agnosticParser.DIGIT_6); }
		public TerminalNode DIGIT_6(int i) {
			return getToken(agnosticParser.DIGIT_6, i);
		}
		public List<TerminalNode> DIGIT_7() { return getTokens(agnosticParser.DIGIT_7); }
		public TerminalNode DIGIT_7(int i) {
			return getToken(agnosticParser.DIGIT_7, i);
		}
		public List<TerminalNode> DIGIT_8() { return getTokens(agnosticParser.DIGIT_8); }
		public TerminalNode DIGIT_8(int i) {
			return getToken(agnosticParser.DIGIT_8, i);
		}
		public List<TerminalNode> DIGIT_9() { return getTokens(agnosticParser.DIGIT_9); }
		public TerminalNode DIGIT_9(int i) {
			return getToken(agnosticParser.DIGIT_9, i);
		}
		public NaturalNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_naturalNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNaturalNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNaturalNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNaturalNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NaturalNumberContext naturalNumber() throws RecognitionException {
		NaturalNumberContext _localctx = new NaturalNumberContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_naturalNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(237);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_0) | (1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_0) | (1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0) );
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
		public TerminalNode HYPHEN() { return getToken(agnosticParser.HYPHEN, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HYPHEN) {
				{
				setState(242);
				match(HYPHEN);
				}
			}

			setState(245);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u00fa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\7\2R\n"+
		"\2\f\2\16\2U\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4^\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b}\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u0084"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00a9\n\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u00c0\n\30\3\30\3\30\5\30\u00c4\n\30\3\31\3\31\3"+
		"\31\5\31\u00c9\n\31\3\32\3\32\3\32\3\32\5\32\u00cf\n\32\3\32\3\32\3\32"+
		"\3\32\5\32\u00d5\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\5\35\u00e2\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3"+
		"\"\3#\6#\u00f1\n#\r#\16#\u00f2\3$\5$\u00f6\n$\3$\3$\3$\2\2%\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\f\3\2\62"+
		"\63\3\2/\61\3\2\659\3\2 !\3\2,-\3\2\27\31\3\2\"#\3\2$%\3\2&\'\3\2\64="+
		"\2\u00f2\2H\3\2\2\2\4V\3\2\2\2\6]\3\2\2\2\be\3\2\2\2\ni\3\2\2\2\fl\3\2"+
		"\2\2\16|\3\2\2\2\20~\3\2\2\2\22\u0085\3\2\2\2\24\u008d\3\2\2\2\26\u008f"+
		"\3\2\2\2\30\u0091\3\2\2\2\32\u0093\3\2\2\2\34\u0097\3\2\2\2\36\u009d\3"+
		"\2\2\2 \u00a1\3\2\2\2\"\u00a3\3\2\2\2$\u00aa\3\2\2\2&\u00ae\3\2\2\2(\u00b0"+
		"\3\2\2\2*\u00b4\3\2\2\2,\u00b8\3\2\2\2.\u00ba\3\2\2\2\60\u00c5\3\2\2\2"+
		"\62\u00d4\3\2\2\2\64\u00d6\3\2\2\2\66\u00d9\3\2\2\28\u00dd\3\2\2\2:\u00e3"+
		"\3\2\2\2<\u00e7\3\2\2\2>\u00e9\3\2\2\2@\u00eb\3\2\2\2B\u00ed\3\2\2\2D"+
		"\u00f0\3\2\2\2F\u00f5\3\2\2\2HM\5\4\3\2IJ\7>\2\2JL\5\6\4\2KI\3\2\2\2L"+
		"O\3\2\2\2MK\3\2\2\2MN\3\2\2\2NS\3\2\2\2OM\3\2\2\2PR\7>\2\2QP\3\2\2\2R"+
		"U\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\3\3\2\2\2US\3\2\2\2VW\7\3\2\2WX\7.\2\2"+
		"XY\5D#\2Y\5\3\2\2\2Z[\5\b\5\2[\\\7@\2\2\\^\3\2\2\2]Z\3\2\2\2]^\3\2\2\2"+
		"^_\3\2\2\2_`\5\16\b\2`a\7.\2\2ab\5\n\6\2bc\7.\2\2cd\5\f\7\2d\7\3\2\2\2"+
		"ef\5D#\2fg\7@\2\2gh\5D#\2h\t\3\2\2\2ij\t\2\2\2jk\5F$\2k\13\3\2\2\2lm\5"+
		"D#\2m\r\3\2\2\2n}\5\20\t\2o}\5\36\20\2p}\5\22\n\2q}\5\26\f\2r}\5\32\16"+
		"\2s}\5\30\r\2t}\5\34\17\2u}\5\"\22\2v}\5*\26\2w}\5,\27\2x}\5.\30\2y}\5"+
		"\66\34\2z}\58\35\2{}\5:\36\2|n\3\2\2\2|o\3\2\2\2|p\3\2\2\2|q\3\2\2\2|"+
		"r\3\2\2\2|s\3\2\2\2|t\3\2\2\2|u\3\2\2\2|v\3\2\2\2|w\3\2\2\2|x\3\2\2\2"+
		"|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\17\3\2\2\2~\177\7\4\2\2\177\u0080\7\22"+
		"\2\2\u0080\u0083\7\25\2\2\u0081\u0082\7\23\2\2\u0082\u0084\7)\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\21\3\2\2\2\u0085\u0086\7\5\2"+
		"\2\u0086\u0087\7\22\2\2\u0087\u0088\t\3\2\2\u0088\u008b\5\24\13\2\u0089"+
		"\u008a\7\23\2\2\u008a\u008c\7\24\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\23\3\2\2\2\u008d\u008e\t\4\2\2\u008e\25\3\2\2\2\u008f\u0090"+
		"\7\6\2\2\u0090\27\3\2\2\2\u0091\u0092\7\t\2\2\u0092\31\3\2\2\2\u0093\u0094"+
		"\7\7\2\2\u0094\u0095\7\22\2\2\u0095\u0096\5D#\2\u0096\33\3\2\2\2\u0097"+
		"\u0098\7\b\2\2\u0098\u0099\7\22\2\2\u0099\u009a\7\37\2\2\u009a\u009b\7"+
		"\23\2\2\u009b\u009c\5 \21\2\u009c\35\3\2\2\2\u009d\u009e\7\n\2\2\u009e"+
		"\u009f\7\22\2\2\u009f\u00a0\t\5\2\2\u00a0\37\3\2\2\2\u00a1\u00a2\t\6\2"+
		"\2\u00a2!\3\2\2\2\u00a3\u00a4\7\13\2\2\u00a4\u00a8\7\22\2\2\u00a5\u00a9"+
		"\5$\23\2\u00a6\u00a9\5&\24\2\u00a7\u00a9\5(\25\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9#\3\2\2\2\u00aa\u00ab\7\33\2\2"+
		"\u00ab\u00ac\7\23\2\2\u00ac\u00ad\5> \2\u00ad%\3\2\2\2\u00ae\u00af\7\32"+
		"\2\2\u00af\'\3\2\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3"+
		"\5B\"\2\u00b3)\3\2\2\2\u00b4\u00b5\7\f\2\2\u00b5\u00b6\7\22\2\2\u00b6"+
		"\u00b7\7\26\2\2\u00b7+\3\2\2\2\u00b8\u00b9\7\r\2\2\u00b9-\3\2\2\2\u00ba"+
		"\u00bb\7\16\2\2\u00bb\u00bc\7\22\2\2\u00bc\u00bf\5\62\32\2\u00bd\u00be"+
		"\7\23\2\2\u00be\u00c0\7(\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00c2\7\23\2\2\u00c2\u00c4\5\60\31\2\u00c3\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4/\3\2\2\2\u00c5\u00c8\7)\2\2\u00c6\u00c7"+
		"\7\23\2\2\u00c7\u00c9\7*\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\61\3\2\2\2\u00ca\u00cf\7\30\2\2\u00cb\u00cc\7\27\2\2\u00cc\u00cd\7\23"+
		"\2\2\u00cd\u00cf\5<\37\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00cf"+
		"\u00d5\3\2\2\2\u00d0\u00d1\5\64\33\2\u00d1\u00d2\7\23\2\2\u00d2\u00d3"+
		"\5<\37\2\u00d3\u00d5\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d5"+
		"\63\3\2\2\2\u00d6\u00d7\7\35\2\2\u00d7\u00d8\5D#\2\u00d8\65\3\2\2\2\u00d9"+
		"\u00da\7\17\2\2\u00da\u00db\7\22\2\2\u00db\u00dc\t\7\2\2\u00dc\67\3\2"+
		"\2\2\u00dd\u00de\7\20\2\2\u00de\u00e1\7\22\2\2\u00df\u00e2\7+\2\2\u00e0"+
		"\u00e2\5@!\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e29\3\2\2\2\u00e3"+
		"\u00e4\7\21\2\2\u00e4\u00e5\7\22\2\2\u00e5\u00e6\7\36\2\2\u00e6;\3\2\2"+
		"\2\u00e7\u00e8\t\b\2\2\u00e8=\3\2\2\2\u00e9\u00ea\t\t\2\2\u00ea?\3\2\2"+
		"\2\u00eb\u00ec\t\5\2\2\u00ecA\3\2\2\2\u00ed\u00ee\t\n\2\2\u00eeC\3\2\2"+
		"\2\u00ef\u00f1\t\13\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3E\3\2\2\2\u00f4\u00f6\7?\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\5D"+
		"#\2\u00f8G\3\2\2\2\21MS]|\u0083\u008b\u00a8\u00bf\u00c3\u00c8\u00ce\u00d4"+
		"\u00e1\u00f2\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}