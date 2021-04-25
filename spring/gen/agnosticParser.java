// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnosticParser.g4 by ANTLR 4.9.1


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
		SMENS=1, SKERN=2, TEXT=3, TANDEM_PART=4, TANDEM_STAFF=5, TANDEM_CLEF=6, 
		TANDEM_CUSTOS=7, TANDEM_KEY=8, TANDEM_MET=9, METRONOME=10, TANDEM_TIMESIGNATURE=11, 
		TANDEM_BEGIN_PLAIN_CHANT=12, TANDEM_END_PLAIN_CHANT=13, AT=14, CHAR_A=15, 
		CHAR_B=16, CHAR_C=17, CHAR_D=18, CHAR_E=19, CHAR_F=20, CHAR_G=21, CHAR_I=22, 
		CHAR_J=23, CHAR_L=24, CHAR_M=25, CHAR_O=26, CHAR_P=27, CHAR_Q=28, CHAR_R=29, 
		CHAR_S=30, CHAR_X=31, CHAR_Y=32, CHAR_T=33, CHAR_U=34, CHAR_i=35, CHAR_m=36, 
		CHAR_n=37, CHAR_p=38, CHAR_q=39, CHAR_r=40, CHAR_s=41, CHAR_t=42, CHAR_u=43, 
		CHAR_v=44, CHAR_x=45, CHAR_y=46, LOWERCASE_PITCH_CHARACTER=47, DIGIT_0=48, 
		DIGIT_1=49, DIGIT_2=50, DIGIT_3=51, DIGIT_4=52, DIGIT_5=53, DIGIT_6=54, 
		DIGIT_7=55, DIGIT_8=56, DIGIT_9=57, ASTERISK=58, LEFT_BRACKET=59, RIGHT_BRACKET=60, 
		OCTOTHORPE=61, MINUS=62, EQUAL=63, DOT=64, PIPE=65, GRAVE_ACCENT=66, APOSTROPHE=67, 
		CIRCUMFLEX=68, TILDE=69, ANGLE_BRACKET_OPEN=70, ANGLE_BRACKET_CLOSE=71, 
		SLASH=72, BACKSLASH=73, UNDERSCORE=74, LEFT_PARENTHESIS=75, RIGHT_PARENTHESIS=76, 
		COLON=77, SEMICOLON=78, COMMA=79, TAB=80, EOL=81, FIELD_TEXT=82, FREE_TEXT_TAB=83, 
		FREE_TEXT_EOL=84, LAYOUT=85, LAYOUT_NOTE_VISUAL_ACCIDENTAL=86, LAYOUT_REST_POSITION=87;
	public static final int
		RULE_start = 0, RULE_anystart = 1, RULE_eol = 2, RULE_header = 3, RULE_headerField = 4, 
		RULE_record = 5, RULE_tab = 6, RULE_fields = 7, RULE_field = 8, RULE_associatedIDS = 9, 
		RULE_placeHolder = 10, RULE_graphicalToken = 11, RULE_tandemInterpretation = 12, 
		RULE_number = 13, RULE_lowerCasePitch = 14, RULE_upperCasePitch = 15, 
		RULE_part = 16, RULE_staff = 17, RULE_clef = 18, RULE_clefValue = 19, 
		RULE_clefNote = 20, RULE_clefLine = 21, RULE_keySignature = 22, RULE_keySignatureNote = 23, 
		RULE_keyAccidental = 24, RULE_keyChange = 25, RULE_minorKey = 26, RULE_majorKey = 27, 
		RULE_fractionalMeter = 28, RULE_numerator = 29, RULE_denominator = 30, 
		RULE_meterSign = 31, RULE_meterSignValue = 32, RULE_maximodus = 33, RULE_modusMinor = 34, 
		RULE_tempus = 35, RULE_prolatio = 36, RULE_metronome = 37, RULE_nullInterpretation = 38, 
		RULE_barLine = 39, RULE_barlineProperties = 40, RULE_spineOperation = 41, 
		RULE_spineTerminator = 42, RULE_spineSplit = 43, RULE_spineJoin = 44, 
		RULE_multirest = 45, RULE_rest = 46, RULE_restLinePosition = 47, RULE_duration = 48, 
		RULE_pause = 49, RULE_mensuralDuration = 50, RULE_mensuralDot = 51, RULE_modernDuration = 52, 
		RULE_coloured = 53, RULE_mensuralFigure = 54, RULE_mensuralPerfection = 55, 
		RULE_augmentationDot = 56, RULE_separationDot = 57, RULE_custos = 58, 
		RULE_note = 59, RULE_beforeNote = 60, RULE_noteName = 61, RULE_trebleNotes = 62, 
		RULE_bassNotes = 63, RULE_alteration = 64, RULE_editorialAccidental = 65, 
		RULE_afterNote = 66, RULE_graceNote = 67, RULE_slurStart = 68, RULE_ligatureStart = 69, 
		RULE_ligatureEnd = 70, RULE_slurEnd = 71, RULE_barLineCrossedNoteStart = 72, 
		RULE_barLineCrossedNoteEnd = 73, RULE_stem = 74, RULE_beam = 75, RULE_layout = 76, 
		RULE_layoutCommand = 77, RULE_layoutVisualAccidental = 78, RULE_layoutRestPosition = 79, 
		RULE_staffPosition = 80, RULE_lineSpace = 81, RULE_lyricsText = 82, RULE_plainChant = 83;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "anystart", "eol", "header", "headerField", "record", "tab", 
			"fields", "field", "associatedIDS", "placeHolder", "graphicalToken", 
			"tandemInterpretation", "number", "lowerCasePitch", "upperCasePitch", 
			"part", "staff", "clef", "clefValue", "clefNote", "clefLine", "keySignature", 
			"keySignatureNote", "keyAccidental", "keyChange", "minorKey", "majorKey", 
			"fractionalMeter", "numerator", "denominator", "meterSign", "meterSignValue", 
			"maximodus", "modusMinor", "tempus", "prolatio", "metronome", "nullInterpretation", 
			"barLine", "barlineProperties", "spineOperation", "spineTerminator", 
			"spineSplit", "spineJoin", "multirest", "rest", "restLinePosition", "duration", 
			"pause", "mensuralDuration", "mensuralDot", "modernDuration", "coloured", 
			"mensuralFigure", "mensuralPerfection", "augmentationDot", "separationDot", 
			"custos", "note", "beforeNote", "noteName", "trebleNotes", "bassNotes", 
			"alteration", "editorialAccidental", "afterNote", "graceNote", "slurStart", 
			"ligatureStart", "ligatureEnd", "slurEnd", "barLineCrossedNoteStart", 
			"barLineCrossedNoteEnd", "stem", "beam", "layout", "layoutCommand", "layoutVisualAccidental", 
			"layoutRestPosition", "staffPosition", "lineSpace", "lyricsText", "plainChant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'I'", 
			"'J'", "'L'", "'M'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'X'", "'Y'", 
			"'T'", "'U'", "'i'", "'m'", "'n'", "'p'", "'q'", "'r'", "'s'", "'t'", 
			"'u'", "'v'", "'x'", "'y'", null, "'0'", "'1'", "'2'", "'3'", "'4'", 
			"'5'", "'6'", "'7'", "'8'", "'9'", null, "'['", "']'", "'#'", "'-'", 
			"'='", "'.'", "'|'", "'`'", "'''", "'^'", "'~'", "'<'", "'>'", "'/'", 
			"'\\'", "'_'", "'('", "')'", "':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SMENS", "SKERN", "TEXT", "TANDEM_PART", "TANDEM_STAFF", "TANDEM_CLEF", 
			"TANDEM_CUSTOS", "TANDEM_KEY", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", 
			"TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", 
			"CHAR_B", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", 
			"CHAR_J", "CHAR_L", "CHAR_M", "CHAR_O", "CHAR_P", "CHAR_Q", "CHAR_R", 
			"CHAR_S", "CHAR_X", "CHAR_Y", "CHAR_T", "CHAR_U", "CHAR_i", "CHAR_m", 
			"CHAR_n", "CHAR_p", "CHAR_q", "CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", 
			"CHAR_v", "CHAR_x", "CHAR_y", "LOWERCASE_PITCH_CHARACTER", "DIGIT_0", 
			"DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", 
			"DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", 
			"MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", "CIRCUMFLEX", 
			"TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", 
			"UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", "SEMICOLON", 
			"COMMA", "TAB", "EOL", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL", 
			"LAYOUT", "LAYOUT_NOTE_VISUAL_ACCIDENTAL", "LAYOUT_REST_POSITION"
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
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode EOF() { return getToken(agnosticParser.EOF, 0); }
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
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
			setState(168);
			header();
			setState(172); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(169);
					eol();
					setState(170);
					record();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(176);
				eol();
				}
			}

			setState(179);
			match(EOF);
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

	public static class AnystartContext extends ParserRuleContext {
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
		}
		public TerminalNode EOF() { return getToken(agnosticParser.EOF, 0); }
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public AnystartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anystart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAnystart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAnystart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAnystart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnystartContext anystart() throws RecognitionException {
		AnystartContext _localctx = new AnystartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anystart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SMENS) | (1L << SKERN) | (1L << TEXT))) != 0)) {
				{
				setState(181);
				header();
				setState(182);
				eol();
				}
			}

			setState(186);
			record();
			setState(190); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(187);
					eol();
					setState(188);
					record();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(192); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(194);
				eol();
				}
			}

			setState(197);
			match(EOF);
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

	public static class EolContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(agnosticParser.EOL, 0); }
		public EolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterEol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitEol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitEol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EolContext eol() throws RecognitionException {
		EolContext _localctx = new EolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(EOL);
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

	public static class HeaderContext extends ParserRuleContext {
		public List<HeaderFieldContext> headerField() {
			return getRuleContexts(HeaderFieldContext.class);
		}
		public HeaderFieldContext headerField(int i) {
			return getRuleContext(HeaderFieldContext.class,i);
		}
		public List<TerminalNode> TAB() { return getTokens(agnosticParser.TAB); }
		public TerminalNode TAB(int i) {
			return getToken(agnosticParser.TAB, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			headerField();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB) {
				{
				{
				setState(202);
				match(TAB);
				setState(203);
				headerField();
				}
				}
				setState(208);
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

	public static class HeaderFieldContext extends ParserRuleContext {
		public TerminalNode SMENS() { return getToken(agnosticParser.SMENS, 0); }
		public TerminalNode SKERN() { return getToken(agnosticParser.SKERN, 0); }
		public TerminalNode TEXT() { return getToken(agnosticParser.TEXT, 0); }
		public HeaderFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterHeaderField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitHeaderField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitHeaderField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderFieldContext headerField() throws RecognitionException {
		HeaderFieldContext _localctx = new HeaderFieldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_headerField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SMENS) | (1L << SKERN) | (1L << TEXT))) != 0)) ) {
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

	public static class RecordContext extends ParserRuleContext {
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitRecord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_record);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			fields();
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

	public static class TabContext extends ParserRuleContext {
		public TerminalNode TAB() { return getToken(agnosticParser.TAB, 0); }
		public TerminalNode FREE_TEXT_TAB() { return getToken(agnosticParser.FREE_TEXT_TAB, 0); }
		public TabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterTab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitTab(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitTab(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TabContext tab() throws RecognitionException {
		TabContext _localctx = new TabContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tab);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !(_la==TAB || _la==FREE_TEXT_TAB) ) {
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

	public static class FieldsContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TabContext> tab() {
			return getRuleContexts(TabContext.class);
		}
		public TabContext tab(int i) {
			return getRuleContext(TabContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			field();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB || _la==FREE_TEXT_TAB) {
				{
				{
				setState(216);
				tab();
				setState(217);
				field();
				}
				}
				setState(223);
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

	public static class FieldContext extends ParserRuleContext {
		public GraphicalTokenContext graphicalToken() {
			return getRuleContext(GraphicalTokenContext.class,0);
		}
		public PlaceHolderContext placeHolder() {
			return getRuleContext(PlaceHolderContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_field);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TANDEM_PART:
			case TANDEM_STAFF:
			case TANDEM_CLEF:
			case TANDEM_CUSTOS:
			case TANDEM_KEY:
			case TANDEM_MET:
			case METRONOME:
			case TANDEM_TIMESIGNATURE:
			case TANDEM_BEGIN_PLAIN_CHANT:
			case TANDEM_END_PLAIN_CHANT:
			case CHAR_L:
			case CHAR_M:
			case CHAR_S:
			case CHAR_X:
			case CHAR_T:
			case CHAR_U:
			case CHAR_m:
			case CHAR_r:
			case CHAR_s:
			case CHAR_u:
			case DIGIT_0:
			case DIGIT_1:
			case DIGIT_2:
			case DIGIT_3:
			case DIGIT_4:
			case DIGIT_5:
			case DIGIT_6:
			case DIGIT_7:
			case DIGIT_8:
			case DIGIT_9:
			case ASTERISK:
			case LEFT_BRACKET:
			case EQUAL:
			case ANGLE_BRACKET_OPEN:
			case LEFT_PARENTHESIS:
			case FIELD_TEXT:
			case LAYOUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				graphicalToken();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				placeHolder();
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

	public static class AssociatedIDSContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(agnosticParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(agnosticParser.COMMA, i);
		}
		public List<AssociatedIDSContext> associatedIDS() {
			return getRuleContexts(AssociatedIDSContext.class);
		}
		public AssociatedIDSContext associatedIDS(int i) {
			return getRuleContext(AssociatedIDSContext.class,i);
		}
		public AssociatedIDSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associatedIDS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAssociatedIDS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAssociatedIDS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAssociatedIDS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociatedIDSContext associatedIDS() throws RecognitionException {
		AssociatedIDSContext _localctx = new AssociatedIDSContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_associatedIDS);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			number();
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229);
					match(COMMA);
					setState(230);
					associatedIDS();
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class PlaceHolderContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(agnosticParser.DOT, 0); }
		public PlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_placeHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPlaceHolder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPlaceHolder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlaceHolderContext placeHolder() throws RecognitionException {
		PlaceHolderContext _localctx = new PlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_placeHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(DOT);
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

	public static class GraphicalTokenContext extends ParserRuleContext {
		public TandemInterpretationContext tandemInterpretation() {
			return getRuleContext(TandemInterpretationContext.class,0);
		}
		public BarLineContext barLine() {
			return getRuleContext(BarLineContext.class,0);
		}
		public LayoutContext layout() {
			return getRuleContext(LayoutContext.class,0);
		}
		public MultirestContext multirest() {
			return getRuleContext(MultirestContext.class,0);
		}
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public SpineOperationContext spineOperation() {
			return getRuleContext(SpineOperationContext.class,0);
		}
		public LyricsTextContext lyricsText() {
			return getRuleContext(LyricsTextContext.class,0);
		}
		public TerminalNode AT() { return getToken(agnosticParser.AT, 0); }
		public AssociatedIDSContext associatedIDS() {
			return getRuleContext(AssociatedIDSContext.class,0);
		}
		public GraphicalTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphicalToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterGraphicalToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitGraphicalToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitGraphicalToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphicalTokenContext graphicalToken() throws RecognitionException {
		GraphicalTokenContext _localctx = new GraphicalTokenContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_graphicalToken);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(238);
				tandemInterpretation();
				}
				break;
			case 2:
				{
				setState(239);
				barLine();
				}
				break;
			case 3:
				{
				setState(240);
				layout();
				}
				break;
			case 4:
				{
				setState(241);
				multirest();
				}
				break;
			case 5:
				{
				setState(242);
				rest();
				}
				break;
			case 6:
				{
				setState(243);
				note();
				}
				break;
			case 7:
				{
				setState(244);
				spineOperation();
				}
				break;
			case 8:
				{
				setState(245);
				lyricsText();
				}
				break;
			}
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(248);
				match(AT);
				setState(249);
				associatedIDS();
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

	public static class TandemInterpretationContext extends ParserRuleContext {
		public PartContext part() {
			return getRuleContext(PartContext.class,0);
		}
		public StaffContext staff() {
			return getRuleContext(StaffContext.class,0);
		}
		public ClefContext clef() {
			return getRuleContext(ClefContext.class,0);
		}
		public KeySignatureContext keySignature() {
			return getRuleContext(KeySignatureContext.class,0);
		}
		public FractionalMeterContext fractionalMeter() {
			return getRuleContext(FractionalMeterContext.class,0);
		}
		public MeterSignContext meterSign() {
			return getRuleContext(MeterSignContext.class,0);
		}
		public KeyChangeContext keyChange() {
			return getRuleContext(KeyChangeContext.class,0);
		}
		public MetronomeContext metronome() {
			return getRuleContext(MetronomeContext.class,0);
		}
		public NullInterpretationContext nullInterpretation() {
			return getRuleContext(NullInterpretationContext.class,0);
		}
		public CustosContext custos() {
			return getRuleContext(CustosContext.class,0);
		}
		public PlainChantContext plainChant() {
			return getRuleContext(PlainChantContext.class,0);
		}
		public TandemInterpretationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tandemInterpretation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterTandemInterpretation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitTandemInterpretation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitTandemInterpretation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TandemInterpretationContext tandemInterpretation() throws RecognitionException {
		TandemInterpretationContext _localctx = new TandemInterpretationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tandemInterpretation);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				part();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				staff();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				clef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
				keySignature();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(256);
				fractionalMeter();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(257);
				meterSign();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(258);
				keyChange();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(259);
				metronome();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(260);
				nullInterpretation();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(261);
				custos();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(262);
				plainChant();
				}
				break;
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

	public static class NumberContext extends ParserRuleContext {
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
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(265);
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
				setState(268); 
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

	public static class LowerCasePitchContext extends ParserRuleContext {
		public TerminalNode LOWERCASE_PITCH_CHARACTER() { return getToken(agnosticParser.LOWERCASE_PITCH_CHARACTER, 0); }
		public LowerCasePitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerCasePitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLowerCasePitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLowerCasePitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLowerCasePitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerCasePitchContext lowerCasePitch() throws RecognitionException {
		LowerCasePitchContext _localctx = new LowerCasePitchContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lowerCasePitch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(LOWERCASE_PITCH_CHARACTER);
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

	public static class UpperCasePitchContext extends ParserRuleContext {
		public TerminalNode CHAR_A() { return getToken(agnosticParser.CHAR_A, 0); }
		public TerminalNode CHAR_B() { return getToken(agnosticParser.CHAR_B, 0); }
		public TerminalNode CHAR_C() { return getToken(agnosticParser.CHAR_C, 0); }
		public TerminalNode CHAR_D() { return getToken(agnosticParser.CHAR_D, 0); }
		public TerminalNode CHAR_E() { return getToken(agnosticParser.CHAR_E, 0); }
		public TerminalNode CHAR_F() { return getToken(agnosticParser.CHAR_F, 0); }
		public TerminalNode CHAR_G() { return getToken(agnosticParser.CHAR_G, 0); }
		public UpperCasePitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upperCasePitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterUpperCasePitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitUpperCasePitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitUpperCasePitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpperCasePitchContext upperCasePitch() throws RecognitionException {
		UpperCasePitchContext _localctx = new UpperCasePitchContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_upperCasePitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_A) | (1L << CHAR_B) | (1L << CHAR_C) | (1L << CHAR_D) | (1L << CHAR_E) | (1L << CHAR_F) | (1L << CHAR_G))) != 0)) ) {
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

	public static class PartContext extends ParserRuleContext {
		public TerminalNode TANDEM_PART() { return getToken(agnosticParser.TANDEM_PART, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_part);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(TANDEM_PART);
			setState(275);
			number();
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
		public TerminalNode TANDEM_STAFF() { return getToken(agnosticParser.TANDEM_STAFF, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
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
		enterRule(_localctx, 34, RULE_staff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(TANDEM_STAFF);
			setState(278);
			number();
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
		public TerminalNode TANDEM_CLEF() { return getToken(agnosticParser.TANDEM_CLEF, 0); }
		public ClefValueContext clefValue() {
			return getRuleContext(ClefValueContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_clef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(TANDEM_CLEF);
			setState(281);
			clefValue();
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

	public static class ClefValueContext extends ParserRuleContext {
		public ClefNoteContext clefNote() {
			return getRuleContext(ClefNoteContext.class,0);
		}
		public ClefLineContext clefLine() {
			return getRuleContext(ClefLineContext.class,0);
		}
		public ClefValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clefValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterClefValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitClefValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitClefValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClefValueContext clefValue() throws RecognitionException {
		ClefValueContext _localctx = new ClefValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_clefValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			clefNote();
			setState(284);
			clefLine();
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

	public static class ClefNoteContext extends ParserRuleContext {
		public TerminalNode CHAR_C() { return getToken(agnosticParser.CHAR_C, 0); }
		public TerminalNode CHAR_F() { return getToken(agnosticParser.CHAR_F, 0); }
		public TerminalNode CHAR_G() { return getToken(agnosticParser.CHAR_G, 0); }
		public ClefNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clefNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterClefNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitClefNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitClefNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClefNoteContext clefNote() throws RecognitionException {
		ClefNoteContext _localctx = new ClefNoteContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_clefNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_C) | (1L << CHAR_F) | (1L << CHAR_G))) != 0)) ) {
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
		enterRule(_localctx, 42, RULE_clefLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
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

	public static class KeySignatureContext extends ParserRuleContext {
		public TerminalNode TANDEM_KEY() { return getToken(agnosticParser.TANDEM_KEY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(agnosticParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(agnosticParser.RIGHT_BRACKET, 0); }
		public List<KeySignatureNoteContext> keySignatureNote() {
			return getRuleContexts(KeySignatureNoteContext.class);
		}
		public KeySignatureNoteContext keySignatureNote(int i) {
			return getRuleContext(KeySignatureNoteContext.class,i);
		}
		public KeySignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keySignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterKeySignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitKeySignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitKeySignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeySignatureContext keySignature() throws RecognitionException {
		KeySignatureContext _localctx = new KeySignatureContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_keySignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(TANDEM_KEY);
			setState(291);
			match(LEFT_BRACKET);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOWERCASE_PITCH_CHARACTER) {
				{
				{
				setState(292);
				keySignatureNote();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			match(RIGHT_BRACKET);
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

	public static class KeySignatureNoteContext extends ParserRuleContext {
		public LowerCasePitchContext lowerCasePitch() {
			return getRuleContext(LowerCasePitchContext.class,0);
		}
		public KeyAccidentalContext keyAccidental() {
			return getRuleContext(KeyAccidentalContext.class,0);
		}
		public KeySignatureNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keySignatureNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterKeySignatureNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitKeySignatureNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitKeySignatureNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeySignatureNoteContext keySignatureNote() throws RecognitionException {
		KeySignatureNoteContext _localctx = new KeySignatureNoteContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_keySignatureNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			lowerCasePitch();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_n) | (1L << OCTOTHORPE) | (1L << MINUS))) != 0)) {
				{
				setState(301);
				keyAccidental();
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

	public static class KeyAccidentalContext extends ParserRuleContext {
		public TerminalNode CHAR_n() { return getToken(agnosticParser.CHAR_n, 0); }
		public TerminalNode OCTOTHORPE() { return getToken(agnosticParser.OCTOTHORPE, 0); }
		public TerminalNode MINUS() { return getToken(agnosticParser.MINUS, 0); }
		public KeyAccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyAccidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterKeyAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitKeyAccidental(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitKeyAccidental(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyAccidentalContext keyAccidental() throws RecognitionException {
		KeyAccidentalContext _localctx = new KeyAccidentalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keyAccidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_n) | (1L << OCTOTHORPE) | (1L << MINUS))) != 0)) ) {
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

	public static class KeyChangeContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(agnosticParser.ASTERISK, 0); }
		public TerminalNode COLON() { return getToken(agnosticParser.COLON, 0); }
		public MinorKeyContext minorKey() {
			return getRuleContext(MinorKeyContext.class,0);
		}
		public MajorKeyContext majorKey() {
			return getRuleContext(MajorKeyContext.class,0);
		}
		public KeyAccidentalContext keyAccidental() {
			return getRuleContext(KeyAccidentalContext.class,0);
		}
		public KeyChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterKeyChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitKeyChange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitKeyChange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyChangeContext keyChange() throws RecognitionException {
		KeyChangeContext _localctx = new KeyChangeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_keyChange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ASTERISK);
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOWERCASE_PITCH_CHARACTER:
				{
				setState(307);
				minorKey();
				}
				break;
			case CHAR_A:
			case CHAR_B:
			case CHAR_C:
			case CHAR_D:
			case CHAR_E:
			case CHAR_F:
			case CHAR_G:
				{
				setState(308);
				majorKey();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_n) | (1L << OCTOTHORPE) | (1L << MINUS))) != 0)) {
				{
				setState(311);
				keyAccidental();
				}
			}

			setState(314);
			match(COLON);
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

	public static class MinorKeyContext extends ParserRuleContext {
		public LowerCasePitchContext lowerCasePitch() {
			return getRuleContext(LowerCasePitchContext.class,0);
		}
		public MinorKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minorKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMinorKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMinorKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMinorKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinorKeyContext minorKey() throws RecognitionException {
		MinorKeyContext _localctx = new MinorKeyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_minorKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			lowerCasePitch();
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

	public static class MajorKeyContext extends ParserRuleContext {
		public UpperCasePitchContext upperCasePitch() {
			return getRuleContext(UpperCasePitchContext.class,0);
		}
		public MajorKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_majorKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMajorKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMajorKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMajorKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MajorKeyContext majorKey() throws RecognitionException {
		MajorKeyContext _localctx = new MajorKeyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_majorKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			upperCasePitch();
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

	public static class FractionalMeterContext extends ParserRuleContext {
		public TerminalNode TANDEM_TIMESIGNATURE() { return getToken(agnosticParser.TANDEM_TIMESIGNATURE, 0); }
		public NumeratorContext numerator() {
			return getRuleContext(NumeratorContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(agnosticParser.SLASH, 0); }
		public DenominatorContext denominator() {
			return getRuleContext(DenominatorContext.class,0);
		}
		public FractionalMeterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fractionalMeter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterFractionalMeter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitFractionalMeter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitFractionalMeter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FractionalMeterContext fractionalMeter() throws RecognitionException {
		FractionalMeterContext _localctx = new FractionalMeterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fractionalMeter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(TANDEM_TIMESIGNATURE);
			setState(321);
			numerator();
			setState(322);
			match(SLASH);
			setState(323);
			denominator();
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

	public static class NumeratorContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNumerator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNumerator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumeratorContext numerator() throws RecognitionException {
		NumeratorContext _localctx = new NumeratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_numerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			number();
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

	public static class DenominatorContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public DenominatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_denominator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterDenominator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitDenominator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitDenominator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DenominatorContext denominator() throws RecognitionException {
		DenominatorContext _localctx = new DenominatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_denominator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			number();
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

	public static class MeterSignContext extends ParserRuleContext {
		public TerminalNode TANDEM_MET() { return getToken(agnosticParser.TANDEM_MET, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(agnosticParser.LEFT_PARENTHESIS, 0); }
		public MeterSignValueContext meterSignValue() {
			return getRuleContext(MeterSignValueContext.class,0);
		}
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(agnosticParser.RIGHT_PARENTHESIS, 0); }
		public TerminalNode UNDERSCORE() { return getToken(agnosticParser.UNDERSCORE, 0); }
		public MaximodusContext maximodus() {
			return getRuleContext(MaximodusContext.class,0);
		}
		public ModusMinorContext modusMinor() {
			return getRuleContext(ModusMinorContext.class,0);
		}
		public TempusContext tempus() {
			return getRuleContext(TempusContext.class,0);
		}
		public ProlatioContext prolatio() {
			return getRuleContext(ProlatioContext.class,0);
		}
		public MeterSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meterSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMeterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMeterSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMeterSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeterSignContext meterSign() throws RecognitionException {
		MeterSignContext _localctx = new MeterSignContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_meterSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(TANDEM_MET);
			setState(330);
			match(LEFT_PARENTHESIS);
			setState(331);
			meterSignValue();
			setState(332);
			match(RIGHT_PARENTHESIS);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDERSCORE) {
				{
				setState(333);
				match(UNDERSCORE);
				setState(334);
				maximodus();
				setState(335);
				modusMinor();
				setState(336);
				tempus();
				setState(337);
				prolatio();
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

	public static class MeterSignValueContext extends ParserRuleContext {
		public TerminalNode CHAR_C() { return getToken(agnosticParser.CHAR_C, 0); }
		public TerminalNode PIPE() { return getToken(agnosticParser.PIPE, 0); }
		public TerminalNode DOT() { return getToken(agnosticParser.DOT, 0); }
		public TerminalNode CHAR_O() { return getToken(agnosticParser.CHAR_O, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnosticParser.DIGIT_3, 0); }
		public TerminalNode SLASH() { return getToken(agnosticParser.SLASH, 0); }
		public TerminalNode DIGIT_2() { return getToken(agnosticParser.DIGIT_2, 0); }
		public MeterSignValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meterSignValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMeterSignValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMeterSignValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMeterSignValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeterSignValueContext meterSignValue() throws RecognitionException {
		MeterSignValueContext _localctx = new MeterSignValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_meterSignValue);
		try {
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				match(CHAR_C);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(CHAR_C);
				setState(343);
				match(PIPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				match(CHAR_C);
				setState(345);
				match(DOT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(346);
				match(CHAR_O);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(347);
				match(CHAR_O);
				setState(348);
				match(DOT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(349);
				match(CHAR_C);
				setState(350);
				match(DIGIT_3);
				setState(351);
				match(SLASH);
				setState(352);
				match(DIGIT_2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(353);
				match(CHAR_C);
				setState(354);
				match(PIPE);
				setState(355);
				match(DIGIT_3);
				setState(356);
				match(SLASH);
				setState(357);
				match(DIGIT_2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(358);
				match(DIGIT_3);
				}
				break;
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

	public static class MaximodusContext extends ParserRuleContext {
		public TerminalNode DIGIT_2() { return getToken(agnosticParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnosticParser.DIGIT_3, 0); }
		public MaximodusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maximodus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMaximodus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMaximodus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMaximodus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaximodusContext maximodus() throws RecognitionException {
		MaximodusContext _localctx = new MaximodusContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_maximodus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !(_la==DIGIT_2 || _la==DIGIT_3) ) {
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

	public static class ModusMinorContext extends ParserRuleContext {
		public TerminalNode DIGIT_2() { return getToken(agnosticParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnosticParser.DIGIT_3, 0); }
		public ModusMinorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modusMinor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterModusMinor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitModusMinor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitModusMinor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModusMinorContext modusMinor() throws RecognitionException {
		ModusMinorContext _localctx = new ModusMinorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_modusMinor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !(_la==DIGIT_2 || _la==DIGIT_3) ) {
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

	public static class TempusContext extends ParserRuleContext {
		public TerminalNode DIGIT_2() { return getToken(agnosticParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnosticParser.DIGIT_3, 0); }
		public TempusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterTempus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitTempus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitTempus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TempusContext tempus() throws RecognitionException {
		TempusContext _localctx = new TempusContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tempus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( !(_la==DIGIT_2 || _la==DIGIT_3) ) {
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

	public static class ProlatioContext extends ParserRuleContext {
		public TerminalNode DIGIT_2() { return getToken(agnosticParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(agnosticParser.DIGIT_3, 0); }
		public ProlatioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prolatio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterProlatio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitProlatio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitProlatio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProlatioContext prolatio() throws RecognitionException {
		ProlatioContext _localctx = new ProlatioContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_prolatio);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_la = _input.LA(1);
			if ( !(_la==DIGIT_2 || _la==DIGIT_3) ) {
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

	public static class MetronomeContext extends ParserRuleContext {
		public TerminalNode METRONOME() { return getToken(agnosticParser.METRONOME, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public MetronomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metronome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMetronome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMetronome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMetronome(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetronomeContext metronome() throws RecognitionException {
		MetronomeContext _localctx = new MetronomeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_metronome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(METRONOME);
			setState(370);
			number();
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

	public static class NullInterpretationContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(agnosticParser.ASTERISK, 0); }
		public NullInterpretationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullInterpretation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNullInterpretation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNullInterpretation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNullInterpretation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullInterpretationContext nullInterpretation() throws RecognitionException {
		NullInterpretationContext _localctx = new NullInterpretationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_nullInterpretation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(ASTERISK);
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

	public static class BarLineContext extends ParserRuleContext {
		public List<TerminalNode> EQUAL() { return getTokens(agnosticParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(agnosticParser.EQUAL, i);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(agnosticParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(agnosticParser.COLON, i);
		}
		public BarlinePropertiesContext barlineProperties() {
			return getRuleContext(BarlinePropertiesContext.class,0);
		}
		public BarLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBarLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBarLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBarLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarLineContext barLine() throws RecognitionException {
		BarLineContext _localctx = new BarLineContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_barLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(374);
				match(EQUAL);
				}
				}
				setState(377); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EQUAL );
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT_0) | (1L << DIGIT_1) | (1L << DIGIT_2) | (1L << DIGIT_3) | (1L << DIGIT_4) | (1L << DIGIT_5) | (1L << DIGIT_6) | (1L << DIGIT_7) | (1L << DIGIT_8) | (1L << DIGIT_9))) != 0)) {
				{
				setState(379);
				number();
				}
			}

			{
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(382);
				match(COLON);
				}
				break;
			}
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (MINUS - 62)) | (1L << (PIPE - 62)) | (1L << (GRAVE_ACCENT - 62)) | (1L << (APOSTROPHE - 62)))) != 0)) {
				{
				setState(385);
				barlineProperties();
				}
			}

			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(388);
				match(COLON);
				}
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

	public static class BarlinePropertiesContext extends ParserRuleContext {
		public TerminalNode GRAVE_ACCENT() { return getToken(agnosticParser.GRAVE_ACCENT, 0); }
		public TerminalNode APOSTROPHE() { return getToken(agnosticParser.APOSTROPHE, 0); }
		public TerminalNode MINUS() { return getToken(agnosticParser.MINUS, 0); }
		public List<TerminalNode> PIPE() { return getTokens(agnosticParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(agnosticParser.PIPE, i);
		}
		public BarlinePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barlineProperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBarlineProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBarlineProperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBarlineProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarlinePropertiesContext barlineProperties() throws RecognitionException {
		BarlinePropertiesContext _localctx = new BarlinePropertiesContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_barlineProperties);
		try {
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GRAVE_ACCENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				match(GRAVE_ACCENT);
				}
				break;
			case APOSTROPHE:
				enterOuterAlt(_localctx, 2);
				{
				setState(392);
				match(APOSTROPHE);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				match(MINUS);
				}
				break;
			case PIPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(394);
				match(PIPE);
				setState(395);
				match(PIPE);
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

	public static class SpineOperationContext extends ParserRuleContext {
		public SpineTerminatorContext spineTerminator() {
			return getRuleContext(SpineTerminatorContext.class,0);
		}
		public SpineSplitContext spineSplit() {
			return getRuleContext(SpineSplitContext.class,0);
		}
		public SpineJoinContext spineJoin() {
			return getRuleContext(SpineJoinContext.class,0);
		}
		public SpineOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSpineOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSpineOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSpineOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpineOperationContext spineOperation() throws RecognitionException {
		SpineOperationContext _localctx = new SpineOperationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_spineOperation);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				spineTerminator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				spineSplit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				spineJoin();
				}
				break;
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

	public static class SpineTerminatorContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(agnosticParser.ASTERISK, 0); }
		public TerminalNode MINUS() { return getToken(agnosticParser.MINUS, 0); }
		public SpineTerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineTerminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSpineTerminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSpineTerminator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSpineTerminator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpineTerminatorContext spineTerminator() throws RecognitionException {
		SpineTerminatorContext _localctx = new SpineTerminatorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_spineTerminator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(ASTERISK);
			setState(404);
			match(MINUS);
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

	public static class SpineSplitContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(agnosticParser.ASTERISK, 0); }
		public TerminalNode CIRCUMFLEX() { return getToken(agnosticParser.CIRCUMFLEX, 0); }
		public SpineSplitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineSplit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSpineSplit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSpineSplit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSpineSplit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpineSplitContext spineSplit() throws RecognitionException {
		SpineSplitContext _localctx = new SpineSplitContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_spineSplit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(ASTERISK);
			setState(407);
			match(CIRCUMFLEX);
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

	public static class SpineJoinContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(agnosticParser.ASTERISK, 0); }
		public TerminalNode CHAR_v() { return getToken(agnosticParser.CHAR_v, 0); }
		public SpineJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSpineJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSpineJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSpineJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpineJoinContext spineJoin() throws RecognitionException {
		SpineJoinContext _localctx = new SpineJoinContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_spineJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(ASTERISK);
			setState(410);
			match(CHAR_v);
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<TerminalNode> CHAR_r() { return getTokens(agnosticParser.CHAR_r); }
		public TerminalNode CHAR_r(int i) {
			return getToken(agnosticParser.CHAR_r, i);
		}
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
		enterRule(_localctx, 90, RULE_multirest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(412);
			match(CHAR_r);
			}
			{
			setState(413);
			match(CHAR_r);
			}
			setState(414);
			number();
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
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public TerminalNode CHAR_r() { return getToken(agnosticParser.CHAR_r, 0); }
		public PauseContext pause() {
			return getRuleContext(PauseContext.class,0);
		}
		public RestLinePositionContext restLinePosition() {
			return getRuleContext(RestLinePositionContext.class,0);
		}
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
		enterRule(_localctx, 92, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			duration();
			{
			setState(417);
			match(CHAR_r);
			}
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(418);
				pause();
				}
			}

			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDERSCORE) {
				{
				setState(421);
				restLinePosition();
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

	public static class RestLinePositionContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(agnosticParser.UNDERSCORE, 0); }
		public ClefLineContext clefLine() {
			return getRuleContext(ClefLineContext.class,0);
		}
		public RestLinePositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restLinePosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterRestLinePosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitRestLinePosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitRestLinePosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestLinePositionContext restLinePosition() throws RecognitionException {
		RestLinePositionContext _localctx = new RestLinePositionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_restLinePosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(UNDERSCORE);
			setState(425);
			clefLine();
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

	public static class DurationContext extends ParserRuleContext {
		public MensuralDurationContext mensuralDuration() {
			return getRuleContext(MensuralDurationContext.class,0);
		}
		public ModernDurationContext modernDuration() {
			return getRuleContext(ModernDurationContext.class,0);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_duration);
		try {
			setState(429);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_L:
			case CHAR_M:
			case CHAR_S:
			case CHAR_X:
			case CHAR_U:
			case CHAR_m:
			case CHAR_s:
			case CHAR_u:
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				mensuralDuration();
				}
				break;
			case DIGIT_0:
			case DIGIT_1:
			case DIGIT_2:
			case DIGIT_3:
			case DIGIT_4:
			case DIGIT_5:
			case DIGIT_6:
			case DIGIT_7:
			case DIGIT_8:
			case DIGIT_9:
				enterOuterAlt(_localctx, 2);
				{
				setState(428);
				modernDuration();
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

	public static class PauseContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(agnosticParser.SEMICOLON, 0); }
		public PauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PauseContext pause() throws RecognitionException {
		PauseContext _localctx = new PauseContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_pause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(SEMICOLON);
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

	public static class MensuralDurationContext extends ParserRuleContext {
		public MensuralFigureContext mensuralFigure() {
			return getRuleContext(MensuralFigureContext.class,0);
		}
		public MensuralDotContext mensuralDot() {
			return getRuleContext(MensuralDotContext.class,0);
		}
		public ColouredContext coloured() {
			return getRuleContext(ColouredContext.class,0);
		}
		public MensuralPerfectionContext mensuralPerfection() {
			return getRuleContext(MensuralPerfectionContext.class,0);
		}
		public MensuralDurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuralDuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMensuralDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMensuralDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMensuralDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MensuralDurationContext mensuralDuration() throws RecognitionException {
		MensuralDurationContext _localctx = new MensuralDurationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_mensuralDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			mensuralFigure();
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TILDE) {
				{
				setState(434);
				coloured();
				}
			}

			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_I) | (1L << CHAR_i) | (1L << CHAR_p))) != 0)) {
				{
				setState(437);
				mensuralPerfection();
				}
			}

			setState(440);
			mensuralDot();
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

	public static class MensuralDotContext extends ParserRuleContext {
		public AugmentationDotContext augmentationDot() {
			return getRuleContext(AugmentationDotContext.class,0);
		}
		public SeparationDotContext separationDot() {
			return getRuleContext(SeparationDotContext.class,0);
		}
		public MensuralDotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuralDot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMensuralDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMensuralDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMensuralDot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MensuralDotContext mensuralDot() throws RecognitionException {
		MensuralDotContext _localctx = new MensuralDotContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_mensuralDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(442);
				augmentationDot();
				}
				break;
			case COLON:
				{
				setState(443);
				separationDot();
				}
				break;
			case CHAR_A:
			case CHAR_B:
			case CHAR_C:
			case CHAR_D:
			case CHAR_E:
			case CHAR_F:
			case CHAR_G:
			case CHAR_r:
			case LOWERCASE_PITCH_CHARACTER:
				break;
			default:
				break;
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

	public static class ModernDurationContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<AugmentationDotContext> augmentationDot() {
			return getRuleContexts(AugmentationDotContext.class);
		}
		public AugmentationDotContext augmentationDot(int i) {
			return getRuleContext(AugmentationDotContext.class,i);
		}
		public ModernDurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modernDuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterModernDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitModernDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitModernDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModernDurationContext modernDuration() throws RecognitionException {
		ModernDurationContext _localctx = new ModernDurationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_modernDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			number();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(447);
				augmentationDot();
				}
				}
				setState(452);
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

	public static class ColouredContext extends ParserRuleContext {
		public TerminalNode TILDE() { return getToken(agnosticParser.TILDE, 0); }
		public ColouredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coloured; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterColoured(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitColoured(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitColoured(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColouredContext coloured() throws RecognitionException {
		ColouredContext _localctx = new ColouredContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_coloured);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(TILDE);
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

	public static class MensuralFigureContext extends ParserRuleContext {
		public TerminalNode CHAR_X() { return getToken(agnosticParser.CHAR_X, 0); }
		public TerminalNode CHAR_L() { return getToken(agnosticParser.CHAR_L, 0); }
		public TerminalNode CHAR_S() { return getToken(agnosticParser.CHAR_S, 0); }
		public TerminalNode CHAR_s() { return getToken(agnosticParser.CHAR_s, 0); }
		public TerminalNode CHAR_M() { return getToken(agnosticParser.CHAR_M, 0); }
		public TerminalNode CHAR_m() { return getToken(agnosticParser.CHAR_m, 0); }
		public TerminalNode CHAR_U() { return getToken(agnosticParser.CHAR_U, 0); }
		public TerminalNode CHAR_u() { return getToken(agnosticParser.CHAR_u, 0); }
		public MensuralFigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuralFigure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMensuralFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMensuralFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMensuralFigure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MensuralFigureContext mensuralFigure() throws RecognitionException {
		MensuralFigureContext _localctx = new MensuralFigureContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_mensuralFigure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_L) | (1L << CHAR_M) | (1L << CHAR_S) | (1L << CHAR_X) | (1L << CHAR_U) | (1L << CHAR_m) | (1L << CHAR_s) | (1L << CHAR_u))) != 0)) ) {
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

	public static class MensuralPerfectionContext extends ParserRuleContext {
		public TerminalNode CHAR_p() { return getToken(agnosticParser.CHAR_p, 0); }
		public TerminalNode CHAR_i() { return getToken(agnosticParser.CHAR_i, 0); }
		public TerminalNode CHAR_I() { return getToken(agnosticParser.CHAR_I, 0); }
		public MensuralPerfectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuralPerfection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterMensuralPerfection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitMensuralPerfection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitMensuralPerfection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MensuralPerfectionContext mensuralPerfection() throws RecognitionException {
		MensuralPerfectionContext _localctx = new MensuralPerfectionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_mensuralPerfection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_I) | (1L << CHAR_i) | (1L << CHAR_p))) != 0)) ) {
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

	public static class AugmentationDotContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(agnosticParser.DOT, 0); }
		public AugmentationDotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augmentationDot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAugmentationDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAugmentationDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAugmentationDot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AugmentationDotContext augmentationDot() throws RecognitionException {
		AugmentationDotContext _localctx = new AugmentationDotContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_augmentationDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(DOT);
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

	public static class SeparationDotContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(agnosticParser.COLON, 0); }
		public SeparationDotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separationDot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSeparationDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSeparationDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSeparationDot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeparationDotContext separationDot() throws RecognitionException {
		SeparationDotContext _localctx = new SeparationDotContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_separationDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(COLON);
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

	public static class CustosContext extends ParserRuleContext {
		public TerminalNode TANDEM_CUSTOS() { return getToken(agnosticParser.TANDEM_CUSTOS, 0); }
		public NoteNameContext noteName() {
			return getRuleContext(NoteNameContext.class,0);
		}
		public AlterationContext alteration() {
			return getRuleContext(AlterationContext.class,0);
		}
		public CustosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_custos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterCustos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitCustos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitCustos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustosContext custos() throws RecognitionException {
		CustosContext _localctx = new CustosContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_custos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(TANDEM_CUSTOS);
			setState(464);
			noteName();
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_n) | (1L << OCTOTHORPE) | (1L << MINUS))) != 0)) {
				{
				setState(465);
				alteration();
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

	public static class NoteContext extends ParserRuleContext {
		public BeforeNoteContext beforeNote() {
			return getRuleContext(BeforeNoteContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public NoteNameContext noteName() {
			return getRuleContext(NoteNameContext.class,0);
		}
		public AfterNoteContext afterNote() {
			return getRuleContext(AfterNoteContext.class,0);
		}
		public AlterationContext alteration() {
			return getRuleContext(AlterationContext.class,0);
		}
		public EditorialAccidentalContext editorialAccidental() {
			return getRuleContext(EditorialAccidentalContext.class,0);
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
		enterRule(_localctx, 118, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			beforeNote();
			setState(469);
			duration();
			setState(470);
			noteName();
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_n) | (1L << OCTOTHORPE) | (1L << MINUS))) != 0)) {
				{
				setState(471);
				alteration();
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_Y || _la==CHAR_y) {
					{
					setState(472);
					editorialAccidental();
					}
				}

				}
			}

			setState(477);
			afterNote();
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

	public static class BeforeNoteContext extends ParserRuleContext {
		public List<SlurStartContext> slurStart() {
			return getRuleContexts(SlurStartContext.class);
		}
		public SlurStartContext slurStart(int i) {
			return getRuleContext(SlurStartContext.class,i);
		}
		public List<LigatureStartContext> ligatureStart() {
			return getRuleContexts(LigatureStartContext.class);
		}
		public LigatureStartContext ligatureStart(int i) {
			return getRuleContext(LigatureStartContext.class,i);
		}
		public List<BarLineCrossedNoteStartContext> barLineCrossedNoteStart() {
			return getRuleContexts(BarLineCrossedNoteStartContext.class);
		}
		public BarLineCrossedNoteStartContext barLineCrossedNoteStart(int i) {
			return getRuleContext(BarLineCrossedNoteStartContext.class,i);
		}
		public BeforeNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBeforeNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBeforeNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBeforeNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeNoteContext beforeNote() throws RecognitionException {
		BeforeNoteContext _localctx = new BeforeNoteContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_beforeNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (CHAR_T - 33)) | (1L << (LEFT_BRACKET - 33)) | (1L << (ANGLE_BRACKET_OPEN - 33)) | (1L << (LEFT_PARENTHESIS - 33)))) != 0)) {
				{
				setState(482);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_PARENTHESIS:
					{
					setState(479);
					slurStart();
					}
					break;
				case LEFT_BRACKET:
				case ANGLE_BRACKET_OPEN:
					{
					setState(480);
					ligatureStart();
					}
					break;
				case CHAR_T:
					{
					setState(481);
					barLineCrossedNoteStart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(486);
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

	public static class NoteNameContext extends ParserRuleContext {
		public BassNotesContext bassNotes() {
			return getRuleContext(BassNotesContext.class,0);
		}
		public TrebleNotesContext trebleNotes() {
			return getRuleContext(TrebleNotesContext.class,0);
		}
		public NoteNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterNoteName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitNoteName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitNoteName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteNameContext noteName() throws RecognitionException {
		NoteNameContext _localctx = new NoteNameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_noteName);
		try {
			setState(489);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_A:
			case CHAR_B:
			case CHAR_C:
			case CHAR_D:
			case CHAR_E:
			case CHAR_F:
			case CHAR_G:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				bassNotes();
				}
				break;
			case LOWERCASE_PITCH_CHARACTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				trebleNotes();
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

	public static class TrebleNotesContext extends ParserRuleContext {
		public List<LowerCasePitchContext> lowerCasePitch() {
			return getRuleContexts(LowerCasePitchContext.class);
		}
		public LowerCasePitchContext lowerCasePitch(int i) {
			return getRuleContext(LowerCasePitchContext.class,i);
		}
		public TrebleNotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trebleNotes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterTrebleNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitTrebleNotes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitTrebleNotes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrebleNotesContext trebleNotes() throws RecognitionException {
		TrebleNotesContext _localctx = new TrebleNotesContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_trebleNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(491);
				lowerCasePitch();
				}
				}
				setState(494); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LOWERCASE_PITCH_CHARACTER );
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

	public static class BassNotesContext extends ParserRuleContext {
		public List<UpperCasePitchContext> upperCasePitch() {
			return getRuleContexts(UpperCasePitchContext.class);
		}
		public UpperCasePitchContext upperCasePitch(int i) {
			return getRuleContext(UpperCasePitchContext.class,i);
		}
		public BassNotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bassNotes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBassNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBassNotes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBassNotes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BassNotesContext bassNotes() throws RecognitionException {
		BassNotesContext _localctx = new BassNotesContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_bassNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(496);
				upperCasePitch();
				}
				}
				setState(499); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_A) | (1L << CHAR_B) | (1L << CHAR_C) | (1L << CHAR_D) | (1L << CHAR_E) | (1L << CHAR_F) | (1L << CHAR_G))) != 0) );
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

	public static class AlterationContext extends ParserRuleContext {
		public List<TerminalNode> OCTOTHORPE() { return getTokens(agnosticParser.OCTOTHORPE); }
		public TerminalNode OCTOTHORPE(int i) {
			return getToken(agnosticParser.OCTOTHORPE, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(agnosticParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(agnosticParser.MINUS, i);
		}
		public TerminalNode CHAR_n() { return getToken(agnosticParser.CHAR_n, 0); }
		public AlterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alteration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAlteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAlteration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAlteration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterationContext alteration() throws RecognitionException {
		AlterationContext _localctx = new AlterationContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_alteration);
		try {
			setState(508);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				match(OCTOTHORPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(502);
				match(OCTOTHORPE);
				setState(503);
				match(OCTOTHORPE);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				match(MINUS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(505);
				match(MINUS);
				setState(506);
				match(MINUS);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(507);
				match(CHAR_n);
				}
				break;
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

	public static class EditorialAccidentalContext extends ParserRuleContext {
		public List<TerminalNode> CHAR_y() { return getTokens(agnosticParser.CHAR_y); }
		public TerminalNode CHAR_y(int i) {
			return getToken(agnosticParser.CHAR_y, i);
		}
		public List<TerminalNode> CHAR_Y() { return getTokens(agnosticParser.CHAR_Y); }
		public TerminalNode CHAR_Y(int i) {
			return getToken(agnosticParser.CHAR_Y, i);
		}
		public EditorialAccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_editorialAccidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterEditorialAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitEditorialAccidental(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitEditorialAccidental(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EditorialAccidentalContext editorialAccidental() throws RecognitionException {
		EditorialAccidentalContext _localctx = new EditorialAccidentalContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_editorialAccidental);
		int _la;
		try {
			setState(518);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_y:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(510);
				match(CHAR_y);
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_y) {
					{
					setState(511);
					match(CHAR_y);
					}
				}

				}
				}
				break;
			case CHAR_Y:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(514);
				match(CHAR_Y);
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_Y) {
					{
					setState(515);
					match(CHAR_Y);
					}
				}

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

	public static class AfterNoteContext extends ParserRuleContext {
		public List<SlurEndContext> slurEnd() {
			return getRuleContexts(SlurEndContext.class);
		}
		public SlurEndContext slurEnd(int i) {
			return getRuleContext(SlurEndContext.class,i);
		}
		public List<StemContext> stem() {
			return getRuleContexts(StemContext.class);
		}
		public StemContext stem(int i) {
			return getRuleContext(StemContext.class,i);
		}
		public List<LigatureEndContext> ligatureEnd() {
			return getRuleContexts(LigatureEndContext.class);
		}
		public LigatureEndContext ligatureEnd(int i) {
			return getRuleContext(LigatureEndContext.class,i);
		}
		public List<BeamContext> beam() {
			return getRuleContexts(BeamContext.class);
		}
		public BeamContext beam(int i) {
			return getRuleContext(BeamContext.class,i);
		}
		public List<PauseContext> pause() {
			return getRuleContexts(PauseContext.class);
		}
		public PauseContext pause(int i) {
			return getRuleContext(PauseContext.class,i);
		}
		public List<BarLineCrossedNoteEndContext> barLineCrossedNoteEnd() {
			return getRuleContexts(BarLineCrossedNoteEndContext.class);
		}
		public BarLineCrossedNoteEndContext barLineCrossedNoteEnd(int i) {
			return getRuleContext(BarLineCrossedNoteEndContext.class,i);
		}
		public List<GraceNoteContext> graceNote() {
			return getRuleContexts(GraceNoteContext.class);
		}
		public GraceNoteContext graceNote(int i) {
			return getRuleContext(GraceNoteContext.class,i);
		}
		public AfterNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterAfterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitAfterNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitAfterNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterNoteContext afterNote() throws RecognitionException {
		AfterNoteContext _localctx = new AfterNoteContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_afterNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (CHAR_J - 23)) | (1L << (CHAR_L - 23)) | (1L << (CHAR_q - 23)) | (1L << (CHAR_t - 23)) | (1L << (RIGHT_BRACKET - 23)) | (1L << (ANGLE_BRACKET_CLOSE - 23)) | (1L << (SLASH - 23)) | (1L << (BACKSLASH - 23)) | (1L << (RIGHT_PARENTHESIS - 23)) | (1L << (SEMICOLON - 23)))) != 0)) {
				{
				setState(527);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RIGHT_PARENTHESIS:
					{
					setState(520);
					slurEnd();
					}
					break;
				case SLASH:
				case BACKSLASH:
					{
					setState(521);
					stem();
					}
					break;
				case RIGHT_BRACKET:
				case ANGLE_BRACKET_CLOSE:
					{
					setState(522);
					ligatureEnd();
					}
					break;
				case CHAR_J:
				case CHAR_L:
					{
					setState(523);
					beam();
					}
					break;
				case SEMICOLON:
					{
					setState(524);
					pause();
					}
					break;
				case CHAR_t:
					{
					setState(525);
					barLineCrossedNoteEnd();
					}
					break;
				case CHAR_q:
					{
					setState(526);
					graceNote();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(531);
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

	public static class GraceNoteContext extends ParserRuleContext {
		public List<TerminalNode> CHAR_q() { return getTokens(agnosticParser.CHAR_q); }
		public TerminalNode CHAR_q(int i) {
			return getToken(agnosticParser.CHAR_q, i);
		}
		public GraceNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graceNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterGraceNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitGraceNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitGraceNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraceNoteContext graceNote() throws RecognitionException {
		GraceNoteContext _localctx = new GraceNoteContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_graceNote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(CHAR_q);
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(533);
				match(CHAR_q);
				}
				break;
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

	public static class SlurStartContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(agnosticParser.LEFT_PARENTHESIS, 0); }
		public SlurStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slurStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSlurStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSlurStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSlurStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlurStartContext slurStart() throws RecognitionException {
		SlurStartContext _localctx = new SlurStartContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_slurStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(LEFT_PARENTHESIS);
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

	public static class LigatureStartContext extends ParserRuleContext {
		public TerminalNode ANGLE_BRACKET_OPEN() { return getToken(agnosticParser.ANGLE_BRACKET_OPEN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(agnosticParser.LEFT_BRACKET, 0); }
		public LigatureStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ligatureStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLigatureStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLigatureStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLigatureStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LigatureStartContext ligatureStart() throws RecognitionException {
		LigatureStartContext _localctx = new LigatureStartContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_ligatureStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_la = _input.LA(1);
			if ( !(_la==LEFT_BRACKET || _la==ANGLE_BRACKET_OPEN) ) {
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

	public static class LigatureEndContext extends ParserRuleContext {
		public TerminalNode ANGLE_BRACKET_CLOSE() { return getToken(agnosticParser.ANGLE_BRACKET_CLOSE, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(agnosticParser.RIGHT_BRACKET, 0); }
		public LigatureEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ligatureEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLigatureEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLigatureEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLigatureEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LigatureEndContext ligatureEnd() throws RecognitionException {
		LigatureEndContext _localctx = new LigatureEndContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_ligatureEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			_la = _input.LA(1);
			if ( !(_la==RIGHT_BRACKET || _la==ANGLE_BRACKET_CLOSE) ) {
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

	public static class SlurEndContext extends ParserRuleContext {
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(agnosticParser.RIGHT_PARENTHESIS, 0); }
		public SlurEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slurEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterSlurEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitSlurEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitSlurEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlurEndContext slurEnd() throws RecognitionException {
		SlurEndContext _localctx = new SlurEndContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_slurEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(RIGHT_PARENTHESIS);
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

	public static class BarLineCrossedNoteStartContext extends ParserRuleContext {
		public TerminalNode CHAR_T() { return getToken(agnosticParser.CHAR_T, 0); }
		public BarLineCrossedNoteStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barLineCrossedNoteStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBarLineCrossedNoteStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBarLineCrossedNoteStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBarLineCrossedNoteStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarLineCrossedNoteStartContext barLineCrossedNoteStart() throws RecognitionException {
		BarLineCrossedNoteStartContext _localctx = new BarLineCrossedNoteStartContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_barLineCrossedNoteStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(CHAR_T);
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

	public static class BarLineCrossedNoteEndContext extends ParserRuleContext {
		public TerminalNode CHAR_t() { return getToken(agnosticParser.CHAR_t, 0); }
		public BarLineCrossedNoteEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barLineCrossedNoteEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterBarLineCrossedNoteEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitBarLineCrossedNoteEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitBarLineCrossedNoteEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarLineCrossedNoteEndContext barLineCrossedNoteEnd() throws RecognitionException {
		BarLineCrossedNoteEndContext _localctx = new BarLineCrossedNoteEndContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_barLineCrossedNoteEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(CHAR_t);
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

	public static class StemContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(agnosticParser.SLASH, 0); }
		public TerminalNode BACKSLASH() { return getToken(agnosticParser.BACKSLASH, 0); }
		public StemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterStem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitStem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitStem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StemContext stem() throws RecognitionException {
		StemContext _localctx = new StemContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_stem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_la = _input.LA(1);
			if ( !(_la==SLASH || _la==BACKSLASH) ) {
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

	public static class BeamContext extends ParserRuleContext {
		public TerminalNode CHAR_L() { return getToken(agnosticParser.CHAR_L, 0); }
		public TerminalNode CHAR_J() { return getToken(agnosticParser.CHAR_J, 0); }
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
		enterRule(_localctx, 150, RULE_beam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_la = _input.LA(1);
			if ( !(_la==CHAR_J || _la==CHAR_L) ) {
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

	public static class LayoutContext extends ParserRuleContext {
		public TerminalNode LAYOUT() { return getToken(agnosticParser.LAYOUT, 0); }
		public LayoutCommandContext layoutCommand() {
			return getRuleContext(LayoutCommandContext.class,0);
		}
		public LayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLayout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLayout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLayout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutContext layout() throws RecognitionException {
		LayoutContext _localctx = new LayoutContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_layout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			match(LAYOUT);
			setState(553);
			layoutCommand();
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

	public static class LayoutCommandContext extends ParserRuleContext {
		public LayoutVisualAccidentalContext layoutVisualAccidental() {
			return getRuleContext(LayoutVisualAccidentalContext.class,0);
		}
		public LayoutRestPositionContext layoutRestPosition() {
			return getRuleContext(LayoutRestPositionContext.class,0);
		}
		public LayoutCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLayoutCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLayoutCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLayoutCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutCommandContext layoutCommand() throws RecognitionException {
		LayoutCommandContext _localctx = new LayoutCommandContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_layoutCommand);
		try {
			setState(557);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LAYOUT_NOTE_VISUAL_ACCIDENTAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(555);
				layoutVisualAccidental();
				}
				break;
			case LAYOUT_REST_POSITION:
				enterOuterAlt(_localctx, 2);
				{
				setState(556);
				layoutRestPosition();
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

	public static class LayoutVisualAccidentalContext extends ParserRuleContext {
		public TerminalNode LAYOUT_NOTE_VISUAL_ACCIDENTAL() { return getToken(agnosticParser.LAYOUT_NOTE_VISUAL_ACCIDENTAL, 0); }
		public AlterationContext alteration() {
			return getRuleContext(AlterationContext.class,0);
		}
		public LayoutVisualAccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutVisualAccidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLayoutVisualAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLayoutVisualAccidental(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLayoutVisualAccidental(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutVisualAccidentalContext layoutVisualAccidental() throws RecognitionException {
		LayoutVisualAccidentalContext _localctx = new LayoutVisualAccidentalContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_layoutVisualAccidental);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(LAYOUT_NOTE_VISUAL_ACCIDENTAL);
			setState(560);
			alteration();
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

	public static class LayoutRestPositionContext extends ParserRuleContext {
		public TerminalNode LAYOUT_REST_POSITION() { return getToken(agnosticParser.LAYOUT_REST_POSITION, 0); }
		public StaffPositionContext staffPosition() {
			return getRuleContext(StaffPositionContext.class,0);
		}
		public LayoutRestPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutRestPosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLayoutRestPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLayoutRestPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLayoutRestPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutRestPositionContext layoutRestPosition() throws RecognitionException {
		LayoutRestPositionContext _localctx = new LayoutRestPositionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_layoutRestPosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(LAYOUT_REST_POSITION);
			setState(563);
			staffPosition();
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

	public static class StaffPositionContext extends ParserRuleContext {
		public LineSpaceContext lineSpace() {
			return getRuleContext(LineSpaceContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StaffPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staffPosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterStaffPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitStaffPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitStaffPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaffPositionContext staffPosition() throws RecognitionException {
		StaffPositionContext _localctx = new StaffPositionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_staffPosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			lineSpace();
			setState(566);
			number();
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

	public static class LineSpaceContext extends ParserRuleContext {
		public TerminalNode CHAR_L() { return getToken(agnosticParser.CHAR_L, 0); }
		public TerminalNode CHAR_S() { return getToken(agnosticParser.CHAR_S, 0); }
		public LineSpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineSpace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLineSpace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLineSpace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLineSpace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineSpaceContext lineSpace() throws RecognitionException {
		LineSpaceContext _localctx = new LineSpaceContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_lineSpace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_la = _input.LA(1);
			if ( !(_la==CHAR_L || _la==CHAR_S) ) {
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

	public static class LyricsTextContext extends ParserRuleContext {
		public TerminalNode FIELD_TEXT() { return getToken(agnosticParser.FIELD_TEXT, 0); }
		public LyricsTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lyricsText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterLyricsText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitLyricsText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitLyricsText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LyricsTextContext lyricsText() throws RecognitionException {
		LyricsTextContext _localctx = new LyricsTextContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_lyricsText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(FIELD_TEXT);
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

	public static class PlainChantContext extends ParserRuleContext {
		public TerminalNode TANDEM_BEGIN_PLAIN_CHANT() { return getToken(agnosticParser.TANDEM_BEGIN_PLAIN_CHANT, 0); }
		public TerminalNode TANDEM_END_PLAIN_CHANT() { return getToken(agnosticParser.TANDEM_END_PLAIN_CHANT, 0); }
		public PlainChantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainChant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).enterPlainChant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof agnosticParserListener ) ((agnosticParserListener)listener).exitPlainChant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof agnosticParserVisitor ) return ((agnosticParserVisitor<? extends T>)visitor).visitPlainChant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlainChantContext plainChant() throws RecognitionException {
		PlainChantContext _localctx = new PlainChantContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_plainChant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_la = _input.LA(1);
			if ( !(_la==TANDEM_BEGIN_PLAIN_CHANT || _la==TANDEM_END_PLAIN_CHANT) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3Y\u0241\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\2\3\2\6\2\u00af\n\2\r\2\16\2\u00b0\3\2\5\2\u00b4\n\2"+
		"\3\2\3\2\3\3\3\3\3\3\5\3\u00bb\n\3\3\3\3\3\3\3\3\3\6\3\u00c1\n\3\r\3\16"+
		"\3\u00c2\3\3\5\3\u00c6\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\7\5\u00cf\n\5\f"+
		"\5\16\5\u00d2\13\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u00de\n"+
		"\t\f\t\16\t\u00e1\13\t\3\n\3\n\5\n\u00e5\n\n\3\13\3\13\3\13\7\13\u00ea"+
		"\n\13\f\13\16\13\u00ed\13\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00f9\n\r\3\r\3\r\5\r\u00fd\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u010a\n\16\3\17\6\17\u010d\n\17\r\17\16\17\u010e"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\7\30\u0128\n\30\f\30\16"+
		"\30\u012b\13\30\3\30\3\30\3\31\3\31\5\31\u0131\n\31\3\32\3\32\3\33\3\33"+
		"\3\33\5\33\u0138\n\33\3\33\5\33\u013b\n\33\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\5!\u0156\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\5\"\u016a\n\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3"+
		"(\3(\3)\6)\u017a\n)\r)\16)\u017b\3)\5)\u017f\n)\3)\5)\u0182\n)\3)\5)\u0185"+
		"\n)\3)\5)\u0188\n)\3*\3*\3*\3*\3*\5*\u018f\n*\3+\3+\3+\5+\u0194\n+\3,"+
		"\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\5\60\u01a6\n\60\3"+
		"\60\5\60\u01a9\n\60\3\61\3\61\3\61\3\62\3\62\5\62\u01b0\n\62\3\63\3\63"+
		"\3\64\3\64\5\64\u01b6\n\64\3\64\5\64\u01b9\n\64\3\64\3\64\3\65\3\65\5"+
		"\65\u01bf\n\65\3\66\3\66\7\66\u01c3\n\66\f\66\16\66\u01c6\13\66\3\67\3"+
		"\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3<\5<\u01d5\n<\3=\3=\3=\3=\3=\5=\u01dc"+
		"\n=\5=\u01de\n=\3=\3=\3>\3>\3>\7>\u01e5\n>\f>\16>\u01e8\13>\3?\3?\5?\u01ec"+
		"\n?\3@\6@\u01ef\n@\r@\16@\u01f0\3A\6A\u01f4\nA\rA\16A\u01f5\3B\3B\3B\3"+
		"B\3B\3B\3B\5B\u01ff\nB\3C\3C\5C\u0203\nC\3C\3C\5C\u0207\nC\5C\u0209\n"+
		"C\3D\3D\3D\3D\3D\3D\3D\7D\u0212\nD\fD\16D\u0215\13D\3E\3E\5E\u0219\nE"+
		"\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3N\3O\3O\5O\u0230"+
		"\nO\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3S\3S\3T\3T\3U\3U\3U\2\2V\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\2\22"+
		"\3\2\3\5\4\2RRUU\3\2\62;\3\2\21\27\4\2\23\23\26\27\3\2\63\67\4\2\'\'?"+
		"@\3\2\64\65\b\2\32\33 !$$&&++--\5\2\30\30%%((\4\2==HH\4\2>>II\3\2JK\3"+
		"\2\31\32\4\2\32\32  \3\2\16\17\2\u023f\2\u00aa\3\2\2\2\4\u00ba\3\2\2\2"+
		"\6\u00c9\3\2\2\2\b\u00cb\3\2\2\2\n\u00d3\3\2\2\2\f\u00d5\3\2\2\2\16\u00d7"+
		"\3\2\2\2\20\u00d9\3\2\2\2\22\u00e4\3\2\2\2\24\u00e6\3\2\2\2\26\u00ee\3"+
		"\2\2\2\30\u00f8\3\2\2\2\32\u0109\3\2\2\2\34\u010c\3\2\2\2\36\u0110\3\2"+
		"\2\2 \u0112\3\2\2\2\"\u0114\3\2\2\2$\u0117\3\2\2\2&\u011a\3\2\2\2(\u011d"+
		"\3\2\2\2*\u0120\3\2\2\2,\u0122\3\2\2\2.\u0124\3\2\2\2\60\u012e\3\2\2\2"+
		"\62\u0132\3\2\2\2\64\u0134\3\2\2\2\66\u013e\3\2\2\28\u0140\3\2\2\2:\u0142"+
		"\3\2\2\2<\u0147\3\2\2\2>\u0149\3\2\2\2@\u014b\3\2\2\2B\u0169\3\2\2\2D"+
		"\u016b\3\2\2\2F\u016d\3\2\2\2H\u016f\3\2\2\2J\u0171\3\2\2\2L\u0173\3\2"+
		"\2\2N\u0176\3\2\2\2P\u0179\3\2\2\2R\u018e\3\2\2\2T\u0193\3\2\2\2V\u0195"+
		"\3\2\2\2X\u0198\3\2\2\2Z\u019b\3\2\2\2\\\u019e\3\2\2\2^\u01a2\3\2\2\2"+
		"`\u01aa\3\2\2\2b\u01af\3\2\2\2d\u01b1\3\2\2\2f\u01b3\3\2\2\2h\u01be\3"+
		"\2\2\2j\u01c0\3\2\2\2l\u01c7\3\2\2\2n\u01c9\3\2\2\2p\u01cb\3\2\2\2r\u01cd"+
		"\3\2\2\2t\u01cf\3\2\2\2v\u01d1\3\2\2\2x\u01d6\3\2\2\2z\u01e6\3\2\2\2|"+
		"\u01eb\3\2\2\2~\u01ee\3\2\2\2\u0080\u01f3\3\2\2\2\u0082\u01fe\3\2\2\2"+
		"\u0084\u0208\3\2\2\2\u0086\u0213\3\2\2\2\u0088\u0216\3\2\2\2\u008a\u021a"+
		"\3\2\2\2\u008c\u021c\3\2\2\2\u008e\u021e\3\2\2\2\u0090\u0220\3\2\2\2\u0092"+
		"\u0222\3\2\2\2\u0094\u0224\3\2\2\2\u0096\u0226\3\2\2\2\u0098\u0228\3\2"+
		"\2\2\u009a\u022a\3\2\2\2\u009c\u022f\3\2\2\2\u009e\u0231\3\2\2\2\u00a0"+
		"\u0234\3\2\2\2\u00a2\u0237\3\2\2\2\u00a4\u023a\3\2\2\2\u00a6\u023c\3\2"+
		"\2\2\u00a8\u023e\3\2\2\2\u00aa\u00ae\5\b\5\2\u00ab\u00ac\5\6\4\2\u00ac"+
		"\u00ad\5\f\7\2\u00ad\u00af\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b4\5\6\4\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\7\2\2\3\u00b6\3\3\2\2\2\u00b7\u00b8\5\b\5\2\u00b8\u00b9"+
		"\5\6\4\2\u00b9\u00bb\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00c0\5\f\7\2\u00bd\u00be\5\6\4\2\u00be\u00bf\5\f"+
		"\7\2\u00bf\u00c1\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c6\5\6"+
		"\4\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\7\2\2\3\u00c8\5\3\2\2\2\u00c9\u00ca\7S\2\2\u00ca\7\3\2\2\2\u00cb"+
		"\u00d0\5\n\6\2\u00cc\u00cd\7R\2\2\u00cd\u00cf\5\n\6\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\t\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\t\2\2\2\u00d4\13\3\2\2\2\u00d5"+
		"\u00d6\5\20\t\2\u00d6\r\3\2\2\2\u00d7\u00d8\t\3\2\2\u00d8\17\3\2\2\2\u00d9"+
		"\u00df\5\22\n\2\u00da\u00db\5\16\b\2\u00db\u00dc\5\22\n\2\u00dc\u00de"+
		"\3\2\2\2\u00dd\u00da\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\21\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\5\30\r"+
		"\2\u00e3\u00e5\5\26\f\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\23\3\2\2\2\u00e6\u00eb\5\34\17\2\u00e7\u00e8\7Q\2\2\u00e8\u00ea\5\24"+
		"\13\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\25\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7B\2\2"+
		"\u00ef\27\3\2\2\2\u00f0\u00f9\5\32\16\2\u00f1\u00f9\5P)\2\u00f2\u00f9"+
		"\5\u009aN\2\u00f3\u00f9\5\\/\2\u00f4\u00f9\5^\60\2\u00f5\u00f9\5x=\2\u00f6"+
		"\u00f9\5T+\2\u00f7\u00f9\5\u00a6T\2\u00f8\u00f0\3\2\2\2\u00f8\u00f1\3"+
		"\2\2\2\u00f8\u00f2\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f8"+
		"\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2"+
		"\2\2\u00fa\u00fb\7\20\2\2\u00fb\u00fd\5\24\13\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\31\3\2\2\2\u00fe\u010a\5\"\22\2\u00ff\u010a\5$\23"+
		"\2\u0100\u010a\5&\24\2\u0101\u010a\5.\30\2\u0102\u010a\5:\36\2\u0103\u010a"+
		"\5@!\2\u0104\u010a\5\64\33\2\u0105\u010a\5L\'\2\u0106\u010a\5N(\2\u0107"+
		"\u010a\5v<\2\u0108\u010a\5\u00a8U\2\u0109\u00fe\3\2\2\2\u0109\u00ff\3"+
		"\2\2\2\u0109\u0100\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0102\3\2\2\2\u0109"+
		"\u0103\3\2\2\2\u0109\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109\u0106\3\2"+
		"\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\33\3\2\2\2\u010b\u010d"+
		"\t\4\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\35\3\2\2\2\u0110\u0111\7\61\2\2\u0111\37\3\2\2\2"+
		"\u0112\u0113\t\5\2\2\u0113!\3\2\2\2\u0114\u0115\7\6\2\2\u0115\u0116\5"+
		"\34\17\2\u0116#\3\2\2\2\u0117\u0118\7\7\2\2\u0118\u0119\5\34\17\2\u0119"+
		"%\3\2\2\2\u011a\u011b\7\b\2\2\u011b\u011c\5(\25\2\u011c\'\3\2\2\2\u011d"+
		"\u011e\5*\26\2\u011e\u011f\5,\27\2\u011f)\3\2\2\2\u0120\u0121\t\6\2\2"+
		"\u0121+\3\2\2\2\u0122\u0123\t\7\2\2\u0123-\3\2\2\2\u0124\u0125\7\n\2\2"+
		"\u0125\u0129\7=\2\2\u0126\u0128\5\60\31\2\u0127\u0126\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012d\7>\2\2\u012d/\3\2\2\2\u012e\u0130\5\36\20\2"+
		"\u012f\u0131\5\62\32\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\61"+
		"\3\2\2\2\u0132\u0133\t\b\2\2\u0133\63\3\2\2\2\u0134\u0137\7<\2\2\u0135"+
		"\u0138\5\66\34\2\u0136\u0138\58\35\2\u0137\u0135\3\2\2\2\u0137\u0136\3"+
		"\2\2\2\u0138\u013a\3\2\2\2\u0139\u013b\5\62\32\2\u013a\u0139\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\7O\2\2\u013d\65\3\2\2\2"+
		"\u013e\u013f\5\36\20\2\u013f\67\3\2\2\2\u0140\u0141\5 \21\2\u01419\3\2"+
		"\2\2\u0142\u0143\7\r\2\2\u0143\u0144\5<\37\2\u0144\u0145\7J\2\2\u0145"+
		"\u0146\5> \2\u0146;\3\2\2\2\u0147\u0148\5\34\17\2\u0148=\3\2\2\2\u0149"+
		"\u014a\5\34\17\2\u014a?\3\2\2\2\u014b\u014c\7\13\2\2\u014c\u014d\7M\2"+
		"\2\u014d\u014e\5B\"\2\u014e\u0155\7N\2\2\u014f\u0150\7L\2\2\u0150\u0151"+
		"\5D#\2\u0151\u0152\5F$\2\u0152\u0153\5H%\2\u0153\u0154\5J&\2\u0154\u0156"+
		"\3\2\2\2\u0155\u014f\3\2\2\2\u0155\u0156\3\2\2\2\u0156A\3\2\2\2\u0157"+
		"\u016a\7\23\2\2\u0158\u0159\7\23\2\2\u0159\u016a\7C\2\2\u015a\u015b\7"+
		"\23\2\2\u015b\u016a\7B\2\2\u015c\u016a\7\34\2\2\u015d\u015e\7\34\2\2\u015e"+
		"\u016a\7B\2\2\u015f\u0160\7\23\2\2\u0160\u0161\7\65\2\2\u0161\u0162\7"+
		"J\2\2\u0162\u016a\7\64\2\2\u0163\u0164\7\23\2\2\u0164\u0165\7C\2\2\u0165"+
		"\u0166\7\65\2\2\u0166\u0167\7J\2\2\u0167\u016a\7\64\2\2\u0168\u016a\7"+
		"\65\2\2\u0169\u0157\3\2\2\2\u0169\u0158\3\2\2\2\u0169\u015a\3\2\2\2\u0169"+
		"\u015c\3\2\2\2\u0169\u015d\3\2\2\2\u0169\u015f\3\2\2\2\u0169\u0163\3\2"+
		"\2\2\u0169\u0168\3\2\2\2\u016aC\3\2\2\2\u016b\u016c\t\t\2\2\u016cE\3\2"+
		"\2\2\u016d\u016e\t\t\2\2\u016eG\3\2\2\2\u016f\u0170\t\t\2\2\u0170I\3\2"+
		"\2\2\u0171\u0172\t\t\2\2\u0172K\3\2\2\2\u0173\u0174\7\f\2\2\u0174\u0175"+
		"\5\34\17\2\u0175M\3\2\2\2\u0176\u0177\7<\2\2\u0177O\3\2\2\2\u0178\u017a"+
		"\7A\2\2\u0179\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0179\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u017f\5\34\17\2\u017e\u017d\3"+
		"\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u0182\7O\2\2\u0181"+
		"\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0185\5R"+
		"*\2\u0184\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186"+
		"\u0188\7O\2\2\u0187\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188Q\3\2\2\2\u0189"+
		"\u018f\7D\2\2\u018a\u018f\7E\2\2\u018b\u018f\7@\2\2\u018c\u018d\7C\2\2"+
		"\u018d\u018f\7C\2\2\u018e\u0189\3\2\2\2\u018e\u018a\3\2\2\2\u018e\u018b"+
		"\3\2\2\2\u018e\u018c\3\2\2\2\u018fS\3\2\2\2\u0190\u0194\5V,\2\u0191\u0194"+
		"\5X-\2\u0192\u0194\5Z.\2\u0193\u0190\3\2\2\2\u0193\u0191\3\2\2\2\u0193"+
		"\u0192\3\2\2\2\u0194U\3\2\2\2\u0195\u0196\7<\2\2\u0196\u0197\7@\2\2\u0197"+
		"W\3\2\2\2\u0198\u0199\7<\2\2\u0199\u019a\7F\2\2\u019aY\3\2\2\2\u019b\u019c"+
		"\7<\2\2\u019c\u019d\7.\2\2\u019d[\3\2\2\2\u019e\u019f\7*\2\2\u019f\u01a0"+
		"\7*\2\2\u01a0\u01a1\5\34\17\2\u01a1]\3\2\2\2\u01a2\u01a3\5b\62\2\u01a3"+
		"\u01a5\7*\2\2\u01a4\u01a6\5d\63\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a9\5`\61\2\u01a8\u01a7\3\2\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a9_\3\2\2\2\u01aa\u01ab\7L\2\2\u01ab\u01ac\5,\27\2\u01ac"+
		"a\3\2\2\2\u01ad\u01b0\5f\64\2\u01ae\u01b0\5j\66\2\u01af\u01ad\3\2\2\2"+
		"\u01af\u01ae\3\2\2\2\u01b0c\3\2\2\2\u01b1\u01b2\7P\2\2\u01b2e\3\2\2\2"+
		"\u01b3\u01b5\5n8\2\u01b4\u01b6\5l\67\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6"+
		"\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7\u01b9\5p9\2\u01b8\u01b7\3\2\2\2\u01b8"+
		"\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\5h\65\2\u01bbg\3\2\2\2"+
		"\u01bc\u01bf\5r:\2\u01bd\u01bf\5t;\2\u01be\u01bc\3\2\2\2\u01be\u01bd\3"+
		"\2\2\2\u01be\u01bf\3\2\2\2\u01bfi\3\2\2\2\u01c0\u01c4\5\34\17\2\u01c1"+
		"\u01c3\5r:\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2"+
		"\2\u01c4\u01c5\3\2\2\2\u01c5k\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8"+
		"\7G\2\2\u01c8m\3\2\2\2\u01c9\u01ca\t\n\2\2\u01cao\3\2\2\2\u01cb\u01cc"+
		"\t\13\2\2\u01ccq\3\2\2\2\u01cd\u01ce\7B\2\2\u01ces\3\2\2\2\u01cf\u01d0"+
		"\7O\2\2\u01d0u\3\2\2\2\u01d1\u01d2\7\t\2\2\u01d2\u01d4\5|?\2\u01d3\u01d5"+
		"\5\u0082B\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5w\3\2\2\2\u01d6"+
		"\u01d7\5z>\2\u01d7\u01d8\5b\62\2\u01d8\u01dd\5|?\2\u01d9\u01db\5\u0082"+
		"B\2\u01da\u01dc\5\u0084C\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01de\3\2\2\2\u01dd\u01d9\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2"+
		"\2\2\u01df\u01e0\5\u0086D\2\u01e0y\3\2\2\2\u01e1\u01e5\5\u008aF\2\u01e2"+
		"\u01e5\5\u008cG\2\u01e3\u01e5\5\u0092J\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2"+
		"\3\2\2\2\u01e4\u01e3\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7{\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ec\5\u0080"+
		"A\2\u01ea\u01ec\5~@\2\u01eb\u01e9\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ec}\3"+
		"\2\2\2\u01ed\u01ef\5\36\20\2\u01ee\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\177\3\2\2\2\u01f2\u01f4\5 \21"+
		"\2\u01f3\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6\u0081\3\2\2\2\u01f7\u01ff\7?\2\2\u01f8\u01f9\7?\2\2\u01f9"+
		"\u01ff\7?\2\2\u01fa\u01ff\7@\2\2\u01fb\u01fc\7@\2\2\u01fc\u01ff\7@\2\2"+
		"\u01fd\u01ff\7\'\2\2\u01fe\u01f7\3\2\2\2\u01fe\u01f8\3\2\2\2\u01fe\u01fa"+
		"\3\2\2\2\u01fe\u01fb\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0083\3\2\2\2\u0200"+
		"\u0202\7\60\2\2\u0201\u0203\7\60\2\2\u0202\u0201\3\2\2\2\u0202\u0203\3"+
		"\2\2\2\u0203\u0209\3\2\2\2\u0204\u0206\7\"\2\2\u0205\u0207\7\"\2\2\u0206"+
		"\u0205\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u0200\3\2"+
		"\2\2\u0208\u0204\3\2\2\2\u0209\u0085\3\2\2\2\u020a\u0212\5\u0090I\2\u020b"+
		"\u0212\5\u0096L\2\u020c\u0212\5\u008eH\2\u020d\u0212\5\u0098M\2\u020e"+
		"\u0212\5d\63\2\u020f\u0212\5\u0094K\2\u0210\u0212\5\u0088E\2\u0211\u020a"+
		"\3\2\2\2\u0211\u020b\3\2\2\2\u0211\u020c\3\2\2\2\u0211\u020d\3\2\2\2\u0211"+
		"\u020e\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0210\3\2\2\2\u0212\u0215\3\2"+
		"\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0087\3\2\2\2\u0215"+
		"\u0213\3\2\2\2\u0216\u0218\7)\2\2\u0217\u0219\7)\2\2\u0218\u0217\3\2\2"+
		"\2\u0218\u0219\3\2\2\2\u0219\u0089\3\2\2\2\u021a\u021b\7M\2\2\u021b\u008b"+
		"\3\2\2\2\u021c\u021d\t\f\2\2\u021d\u008d\3\2\2\2\u021e\u021f\t\r\2\2\u021f"+
		"\u008f\3\2\2\2\u0220\u0221\7N\2\2\u0221\u0091\3\2\2\2\u0222\u0223\7#\2"+
		"\2\u0223\u0093\3\2\2\2\u0224\u0225\7,\2\2\u0225\u0095\3\2\2\2\u0226\u0227"+
		"\t\16\2\2\u0227\u0097\3\2\2\2\u0228\u0229\t\17\2\2\u0229\u0099\3\2\2\2"+
		"\u022a\u022b\7W\2\2\u022b\u022c\5\u009cO\2\u022c\u009b\3\2\2\2\u022d\u0230"+
		"\5\u009eP\2\u022e\u0230\5\u00a0Q\2\u022f\u022d\3\2\2\2\u022f\u022e\3\2"+
		"\2\2\u0230\u009d\3\2\2\2\u0231\u0232\7X\2\2\u0232\u0233\5\u0082B\2\u0233"+
		"\u009f\3\2\2\2\u0234\u0235\7Y\2\2\u0235\u0236\5\u00a2R\2\u0236\u00a1\3"+
		"\2\2\2\u0237\u0238\5\u00a4S\2\u0238\u0239\5\34\17\2\u0239\u00a3\3\2\2"+
		"\2\u023a\u023b\t\20\2\2\u023b\u00a5\3\2\2\2\u023c\u023d\7T\2\2\u023d\u00a7"+
		"\3\2\2\2\u023e\u023f\t\21\2\2\u023f\u00a9\3\2\2\2\63\u00b0\u00b3\u00ba"+
		"\u00c2\u00c5\u00d0\u00df\u00e4\u00eb\u00f8\u00fc\u0109\u010e\u0129\u0130"+
		"\u0137\u013a\u0155\u0169\u017b\u017e\u0181\u0184\u0187\u018e\u0193\u01a5"+
		"\u01a8\u01af\u01b5\u01b8\u01be\u01c4\u01d4\u01db\u01dd\u01e4\u01e6\u01eb"+
		"\u01f0\u01f5\u01fe\u0202\u0206\u0208\u0211\u0213\u0218\u022f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}