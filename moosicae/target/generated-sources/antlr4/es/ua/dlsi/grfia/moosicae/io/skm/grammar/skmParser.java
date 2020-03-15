// Generated from es/ua/dlsi/grfia/moosicae/io/skm/grammar/skmParser.g4 by ANTLR 4.8
package es.ua.dlsi.grfia.moosicae.io.skm.grammar;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class skmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EXCLAMATION=1, SMENS=2, SKERN=3, TEXT=4, TANDEM_PART=5, TANDEM_INSTRUMENT=6, 
		TANDEM_STAFF=7, TANDEM_CLEF=8, TANDEM_CUSTOS=9, TANDEM_KEY=10, TANDEM_MET=11, 
		METRONOME=12, TANDEM_TIMESIGNATURE=13, TANDEM_BEGIN_PLAIN_CHANT=14, TANDEM_END_PLAIN_CHANT=15, 
		AT=16, CHAR_A=17, CHAR_B=18, CHAR_C=19, CHAR_D=20, CHAR_E=21, CHAR_F=22, 
		CHAR_G=23, CHAR_I=24, CHAR_J=25, CHAR_L=26, CHAR_M=27, CHAR_O=28, CHAR_P=29, 
		CHAR_Q=30, CHAR_R=31, CHAR_S=32, CHAR_X=33, CHAR_Y=34, CHAR_T=35, CHAR_U=36, 
		CHAR_a=37, CHAR_b=38, CHAR_c=39, CHAR_d=40, CHAR_e=41, CHAR_f=42, CHAR_g=43, 
		CHAR_i=44, CHAR_m=45, CHAR_n=46, CHAR_p=47, CHAR_r=48, CHAR_s=49, CHAR_t=50, 
		CHAR_u=51, CHAR_v=52, CHAR_x=53, CHAR_y=54, DIGIT_0=55, DIGIT_1=56, DIGIT_2=57, 
		DIGIT_3=58, DIGIT_4=59, DIGIT_5=60, DIGIT_6=61, DIGIT_7=62, DIGIT_8=63, 
		DIGIT_9=64, ASTERISK=65, LEFT_BRACKET=66, RIGHT_BRACKET=67, OCTOTHORPE=68, 
		PLUS=69, MINUS=70, EQUAL=71, DOT=72, PIPE=73, GRAVE_ACCENT=74, APOSTROPHE=75, 
		CIRCUMFLEX=76, TILDE=77, ANGLE_BRACKET_OPEN=78, ANGLE_BRACKET_CLOSE=79, 
		SLASH=80, BACKSLASH=81, UNDERSCORE=82, LEFT_PARENTHESIS=83, RIGHT_PARENTHESIS=84, 
		COLON=85, SEMICOLON=86, COMMA=87, SPACE=88, TAB=89, EOL=90, FIELD_TEXT=91, 
		FREE_TEXT_TAB=92, FREE_TEXT_EOL=93;
	public static final int
		RULE_start = 0, RULE_eol = 1, RULE_header = 2, RULE_headerField = 3, RULE_record = 4, 
		RULE_tab = 5, RULE_fields = 6, RULE_field = 7, RULE_associatedIDS = 8, 
		RULE_placeHolder = 9, RULE_graphicalToken = 10, RULE_tandemInterpretation = 11, 
		RULE_number = 12, RULE_lowerCasePitch = 13, RULE_upperCasePitch = 14, 
		RULE_pitchClass = 15, RULE_part = 16, RULE_staff = 17, RULE_clef = 18, 
		RULE_clefValue = 19, RULE_clefSign = 20, RULE_clefLine = 21, RULE_keySignature = 22, 
		RULE_keySignaturePitchClass = 23, RULE_key = 24, RULE_minorKey = 25, RULE_majorKey = 26, 
		RULE_fractionalTimeSignature = 27, RULE_numerator = 28, RULE_denominator = 29, 
		RULE_meterSymbol = 30, RULE_modernMeterSymbolSign = 31, RULE_mensuration = 32, 
		RULE_metronome = 33, RULE_nullInterpretation = 34, RULE_barline = 35, 
		RULE_barLineType = 36, RULE_spineOperation = 37, RULE_spineTerminator = 38, 
		RULE_spineAdd = 39, RULE_spineSplit = 40, RULE_spineJoin = 41, RULE_rest = 42, 
		RULE_restLinePosition = 43, RULE_duration = 44, RULE_fermata = 45, RULE_mensuralDuration = 46, 
		RULE_mensuralDot = 47, RULE_modernDuration = 48, RULE_coloured = 49, RULE_mensuralFigure = 50, 
		RULE_mensuralPerfection = 51, RULE_augmentationDot = 52, RULE_separationDot = 53, 
		RULE_custos = 54, RULE_pitch = 55, RULE_alteration = 56, RULE_note = 57, 
		RULE_chord = 58, RULE_beforeNote = 59, RULE_diatonicPitch = 60, RULE_trebleNotes = 61, 
		RULE_bassNotes = 62, RULE_accidental = 63, RULE_alterationDisplay = 64, 
		RULE_afterNote = 65, RULE_slurStart = 66, RULE_ligatureStart = 67, RULE_ligatureEnd = 68, 
		RULE_slurEnd = 69, RULE_barLineCrossedNoteStart = 70, RULE_barLineCrossedNoteEnd = 71, 
		RULE_stem = 72, RULE_beam = 73, RULE_staffPosition = 74, RULE_lineSpace = 75, 
		RULE_lyricsText = 76, RULE_plainChant = 77;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "eol", "header", "headerField", "record", "tab", "fields", "field", 
			"associatedIDS", "placeHolder", "graphicalToken", "tandemInterpretation", 
			"number", "lowerCasePitch", "upperCasePitch", "pitchClass", "part", "staff", 
			"clef", "clefValue", "clefSign", "clefLine", "keySignature", "keySignaturePitchClass", 
			"key", "minorKey", "majorKey", "fractionalTimeSignature", "numerator", 
			"denominator", "meterSymbol", "modernMeterSymbolSign", "mensuration", 
			"metronome", "nullInterpretation", "barline", "barLineType", "spineOperation", 
			"spineTerminator", "spineAdd", "spineSplit", "spineJoin", "rest", "restLinePosition", 
			"duration", "fermata", "mensuralDuration", "mensuralDot", "modernDuration", 
			"coloured", "mensuralFigure", "mensuralPerfection", "augmentationDot", 
			"separationDot", "custos", "pitch", "alteration", "note", "chord", "beforeNote", 
			"diatonicPitch", "trebleNotes", "bassNotes", "accidental", "alterationDisplay", 
			"afterNote", "slurStart", "ligatureStart", "ligatureEnd", "slurEnd", 
			"barLineCrossedNoteStart", "barLineCrossedNoteEnd", "stem", "beam", "staffPosition", 
			"lineSpace", "lyricsText", "plainChant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", 
			"'G'", "'I'", "'J'", "'L'", "'M'", "'O'", "'P'", "'Q'", "'R'", "'S'", 
			"'X'", "'Y'", "'T'", "'U'", "'a'", "'b'", "'c'", "'d'", "'e'", "'f'", 
			"'g'", "'i'", "'m'", "'n'", "'p'", "'r'", "'s'", "'t'", "'u'", "'v'", 
			"'x'", "'y'", "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", 
			"'8'", "'9'", null, "'['", "']'", "'#'", "'+'", "'-'", "'='", "'.'", 
			"'|'", "'`'", "'''", "'^'", "'~'", "'<'", "'>'", "'/'", "'\\'", "'_'", 
			"'('", "')'", "':'", "';'", "','", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EXCLAMATION", "SMENS", "SKERN", "TEXT", "TANDEM_PART", "TANDEM_INSTRUMENT", 
			"TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", "TANDEM_KEY", "TANDEM_MET", 
			"METRONOME", "TANDEM_TIMESIGNATURE", "TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", 
			"AT", "CHAR_A", "CHAR_B", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", 
			"CHAR_I", "CHAR_J", "CHAR_L", "CHAR_M", "CHAR_O", "CHAR_P", "CHAR_Q", 
			"CHAR_R", "CHAR_S", "CHAR_X", "CHAR_Y", "CHAR_T", "CHAR_U", "CHAR_a", 
			"CHAR_b", "CHAR_c", "CHAR_d", "CHAR_e", "CHAR_f", "CHAR_g", "CHAR_i", 
			"CHAR_m", "CHAR_n", "CHAR_p", "CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", 
			"CHAR_v", "CHAR_x", "CHAR_y", "DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", 
			"DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", "PLUS", "MINUS", "EQUAL", 
			"DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", "CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", 
			"ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "COLON", "SEMICOLON", "COMMA", "SPACE", "TAB", "EOL", 
			"FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
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
	public String getGrammarFileName() { return "skmParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public skmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode EOF() { return getToken(skmParser.EOF, 0); }
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitStart(this);
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
			setState(156);
			header();
			setState(160); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(157);
					eol();
					setState(158);
					record();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(162); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(164);
				eol();
				}
			}

			setState(167);
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
		public TerminalNode EOL() { return getToken(skmParser.EOL, 0); }
		public EolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterEol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitEol(this);
		}
	}

	public final EolContext eol() throws RecognitionException {
		EolContext _localctx = new EolContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
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
		public List<TerminalNode> TAB() { return getTokens(skmParser.TAB); }
		public TerminalNode TAB(int i) {
			return getToken(skmParser.TAB, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			headerField();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB) {
				{
				{
				setState(172);
				match(TAB);
				setState(173);
				headerField();
				}
				}
				setState(178);
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
		public TerminalNode SMENS() { return getToken(skmParser.SMENS, 0); }
		public TerminalNode SKERN() { return getToken(skmParser.SKERN, 0); }
		public TerminalNode TEXT() { return getToken(skmParser.TEXT, 0); }
		public HeaderFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterHeaderField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitHeaderField(this);
		}
	}

	public final HeaderFieldContext headerField() throws RecognitionException {
		HeaderFieldContext _localctx = new HeaderFieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_headerField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitRecord(this);
		}
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_record);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
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
		public TerminalNode TAB() { return getToken(skmParser.TAB, 0); }
		public TerminalNode FREE_TEXT_TAB() { return getToken(skmParser.FREE_TEXT_TAB, 0); }
		public TabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterTab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitTab(this);
		}
	}

	public final TabContext tab() throws RecognitionException {
		TabContext _localctx = new TabContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tab);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitFields(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			field();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB || _la==FREE_TEXT_TAB) {
				{
				{
				setState(186);
				tab();
				setState(187);
				field();
				}
				}
				setState(193);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		try {
			setState(196);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				graphicalToken();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
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
		public List<TerminalNode> COMMA() { return getTokens(skmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(skmParser.COMMA, i);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterAssociatedIDS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitAssociatedIDS(this);
		}
	}

	public final AssociatedIDSContext associatedIDS() throws RecognitionException {
		AssociatedIDSContext _localctx = new AssociatedIDSContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_associatedIDS);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			number();
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(199);
					match(COMMA);
					setState(200);
					associatedIDS();
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public TerminalNode DOT() { return getToken(skmParser.DOT, 0); }
		public PlaceHolderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_placeHolder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterPlaceHolder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitPlaceHolder(this);
		}
	}

	public final PlaceHolderContext placeHolder() throws RecognitionException {
		PlaceHolderContext _localctx = new PlaceHolderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_placeHolder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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
		public PartContext part() {
			return getRuleContext(PartContext.class,0);
		}
		public BarlineContext barline() {
			return getRuleContext(BarlineContext.class,0);
		}
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public SpineOperationContext spineOperation() {
			return getRuleContext(SpineOperationContext.class,0);
		}
		public LyricsTextContext lyricsText() {
			return getRuleContext(LyricsTextContext.class,0);
		}
		public TerminalNode AT() { return getToken(skmParser.AT, 0); }
		public AssociatedIDSContext associatedIDS() {
			return getRuleContext(AssociatedIDSContext.class,0);
		}
		public GraphicalTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphicalToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterGraphicalToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitGraphicalToken(this);
		}
	}

	public final GraphicalTokenContext graphicalToken() throws RecognitionException {
		GraphicalTokenContext _localctx = new GraphicalTokenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_graphicalToken);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(208);
				tandemInterpretation();
				}
				break;
			case 2:
				{
				setState(209);
				part();
				}
				break;
			case 3:
				{
				setState(210);
				barline();
				}
				break;
			case 4:
				{
				setState(211);
				rest();
				}
				break;
			case 5:
				{
				setState(212);
				note();
				}
				break;
			case 6:
				{
				setState(213);
				chord();
				}
				break;
			case 7:
				{
				setState(214);
				spineOperation();
				}
				break;
			case 8:
				{
				setState(215);
				lyricsText();
				}
				break;
			}
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(218);
				match(AT);
				setState(219);
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
		public StaffContext staff() {
			return getRuleContext(StaffContext.class,0);
		}
		public ClefContext clef() {
			return getRuleContext(ClefContext.class,0);
		}
		public KeySignatureContext keySignature() {
			return getRuleContext(KeySignatureContext.class,0);
		}
		public FractionalTimeSignatureContext fractionalTimeSignature() {
			return getRuleContext(FractionalTimeSignatureContext.class,0);
		}
		public MeterSymbolContext meterSymbol() {
			return getRuleContext(MeterSymbolContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterTandemInterpretation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitTandemInterpretation(this);
		}
	}

	public final TandemInterpretationContext tandemInterpretation() throws RecognitionException {
		TandemInterpretationContext _localctx = new TandemInterpretationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tandemInterpretation);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				staff();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				clef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				keySignature();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				fractionalTimeSignature();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				meterSymbol();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				key();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				metronome();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(229);
				nullInterpretation();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(230);
				custos();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(231);
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
		public List<TerminalNode> DIGIT_0() { return getTokens(skmParser.DIGIT_0); }
		public TerminalNode DIGIT_0(int i) {
			return getToken(skmParser.DIGIT_0, i);
		}
		public List<TerminalNode> DIGIT_1() { return getTokens(skmParser.DIGIT_1); }
		public TerminalNode DIGIT_1(int i) {
			return getToken(skmParser.DIGIT_1, i);
		}
		public List<TerminalNode> DIGIT_2() { return getTokens(skmParser.DIGIT_2); }
		public TerminalNode DIGIT_2(int i) {
			return getToken(skmParser.DIGIT_2, i);
		}
		public List<TerminalNode> DIGIT_3() { return getTokens(skmParser.DIGIT_3); }
		public TerminalNode DIGIT_3(int i) {
			return getToken(skmParser.DIGIT_3, i);
		}
		public List<TerminalNode> DIGIT_4() { return getTokens(skmParser.DIGIT_4); }
		public TerminalNode DIGIT_4(int i) {
			return getToken(skmParser.DIGIT_4, i);
		}
		public List<TerminalNode> DIGIT_5() { return getTokens(skmParser.DIGIT_5); }
		public TerminalNode DIGIT_5(int i) {
			return getToken(skmParser.DIGIT_5, i);
		}
		public List<TerminalNode> DIGIT_6() { return getTokens(skmParser.DIGIT_6); }
		public TerminalNode DIGIT_6(int i) {
			return getToken(skmParser.DIGIT_6, i);
		}
		public List<TerminalNode> DIGIT_7() { return getTokens(skmParser.DIGIT_7); }
		public TerminalNode DIGIT_7(int i) {
			return getToken(skmParser.DIGIT_7, i);
		}
		public List<TerminalNode> DIGIT_8() { return getTokens(skmParser.DIGIT_8); }
		public TerminalNode DIGIT_8(int i) {
			return getToken(skmParser.DIGIT_8, i);
		}
		public List<TerminalNode> DIGIT_9() { return getTokens(skmParser.DIGIT_9); }
		public TerminalNode DIGIT_9(int i) {
			return getToken(skmParser.DIGIT_9, i);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(234);
				_la = _input.LA(1);
				if ( !(((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & ((1L << (DIGIT_0 - 55)) | (1L << (DIGIT_1 - 55)) | (1L << (DIGIT_2 - 55)) | (1L << (DIGIT_3 - 55)) | (1L << (DIGIT_4 - 55)) | (1L << (DIGIT_5 - 55)) | (1L << (DIGIT_6 - 55)) | (1L << (DIGIT_7 - 55)) | (1L << (DIGIT_8 - 55)) | (1L << (DIGIT_9 - 55)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & ((1L << (DIGIT_0 - 55)) | (1L << (DIGIT_1 - 55)) | (1L << (DIGIT_2 - 55)) | (1L << (DIGIT_3 - 55)) | (1L << (DIGIT_4 - 55)) | (1L << (DIGIT_5 - 55)) | (1L << (DIGIT_6 - 55)) | (1L << (DIGIT_7 - 55)) | (1L << (DIGIT_8 - 55)) | (1L << (DIGIT_9 - 55)))) != 0) );
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
		public TerminalNode CHAR_a() { return getToken(skmParser.CHAR_a, 0); }
		public TerminalNode CHAR_b() { return getToken(skmParser.CHAR_b, 0); }
		public TerminalNode CHAR_c() { return getToken(skmParser.CHAR_c, 0); }
		public TerminalNode CHAR_d() { return getToken(skmParser.CHAR_d, 0); }
		public TerminalNode CHAR_e() { return getToken(skmParser.CHAR_e, 0); }
		public TerminalNode CHAR_f() { return getToken(skmParser.CHAR_f, 0); }
		public TerminalNode CHAR_g() { return getToken(skmParser.CHAR_g, 0); }
		public LowerCasePitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerCasePitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterLowerCasePitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitLowerCasePitch(this);
		}
	}

	public final LowerCasePitchContext lowerCasePitch() throws RecognitionException {
		LowerCasePitchContext _localctx = new LowerCasePitchContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lowerCasePitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_a) | (1L << CHAR_b) | (1L << CHAR_c) | (1L << CHAR_d) | (1L << CHAR_e) | (1L << CHAR_f) | (1L << CHAR_g))) != 0)) ) {
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

	public static class UpperCasePitchContext extends ParserRuleContext {
		public TerminalNode CHAR_A() { return getToken(skmParser.CHAR_A, 0); }
		public TerminalNode CHAR_B() { return getToken(skmParser.CHAR_B, 0); }
		public TerminalNode CHAR_C() { return getToken(skmParser.CHAR_C, 0); }
		public TerminalNode CHAR_D() { return getToken(skmParser.CHAR_D, 0); }
		public TerminalNode CHAR_E() { return getToken(skmParser.CHAR_E, 0); }
		public TerminalNode CHAR_F() { return getToken(skmParser.CHAR_F, 0); }
		public TerminalNode CHAR_G() { return getToken(skmParser.CHAR_G, 0); }
		public UpperCasePitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upperCasePitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterUpperCasePitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitUpperCasePitch(this);
		}
	}

	public final UpperCasePitchContext upperCasePitch() throws RecognitionException {
		UpperCasePitchContext _localctx = new UpperCasePitchContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_upperCasePitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
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

	public static class PitchClassContext extends ParserRuleContext {
		public LowerCasePitchContext lowerCasePitch() {
			return getRuleContext(LowerCasePitchContext.class,0);
		}
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
		}
		public PitchClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pitchClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterPitchClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitPitchClass(this);
		}
	}

	public final PitchClassContext pitchClass() throws RecognitionException {
		PitchClassContext _localctx = new PitchClassContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pitchClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			lowerCasePitch();
			setState(244);
			accidental();
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
		public TerminalNode TANDEM_PART() { return getToken(skmParser.TANDEM_PART, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitPart(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_part);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(TANDEM_PART);
			setState(247);
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
		public TerminalNode TANDEM_STAFF() { return getToken(skmParser.TANDEM_STAFF, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StaffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitStaff(this);
		}
	}

	public final StaffContext staff() throws RecognitionException {
		StaffContext _localctx = new StaffContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_staff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(TANDEM_STAFF);
			setState(250);
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
		public TerminalNode TANDEM_CLEF() { return getToken(skmParser.TANDEM_CLEF, 0); }
		public ClefValueContext clefValue() {
			return getRuleContext(ClefValueContext.class,0);
		}
		public ClefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterClef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitClef(this);
		}
	}

	public final ClefContext clef() throws RecognitionException {
		ClefContext _localctx = new ClefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_clef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(TANDEM_CLEF);
			setState(253);
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
		public ClefSignContext clefSign() {
			return getRuleContext(ClefSignContext.class,0);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterClefValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitClefValue(this);
		}
	}

	public final ClefValueContext clefValue() throws RecognitionException {
		ClefValueContext _localctx = new ClefValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_clefValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			clefSign();
			setState(256);
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

	public static class ClefSignContext extends ParserRuleContext {
		public TerminalNode CHAR_C() { return getToken(skmParser.CHAR_C, 0); }
		public TerminalNode CHAR_F() { return getToken(skmParser.CHAR_F, 0); }
		public TerminalNode CHAR_G() { return getToken(skmParser.CHAR_G, 0); }
		public ClefSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clefSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterClefSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitClefSign(this);
		}
	}

	public final ClefSignContext clefSign() throws RecognitionException {
		ClefSignContext _localctx = new ClefSignContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_clefSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
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
		public TerminalNode DIGIT_1() { return getToken(skmParser.DIGIT_1, 0); }
		public TerminalNode DIGIT_2() { return getToken(skmParser.DIGIT_2, 0); }
		public TerminalNode DIGIT_3() { return getToken(skmParser.DIGIT_3, 0); }
		public TerminalNode DIGIT_4() { return getToken(skmParser.DIGIT_4, 0); }
		public TerminalNode DIGIT_5() { return getToken(skmParser.DIGIT_5, 0); }
		public ClefLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clefLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterClefLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitClefLine(this);
		}
	}

	public final ClefLineContext clefLine() throws RecognitionException {
		ClefLineContext _localctx = new ClefLineContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_clefLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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
		public TerminalNode TANDEM_KEY() { return getToken(skmParser.TANDEM_KEY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(skmParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(skmParser.RIGHT_BRACKET, 0); }
		public List<KeySignaturePitchClassContext> keySignaturePitchClass() {
			return getRuleContexts(KeySignaturePitchClassContext.class);
		}
		public KeySignaturePitchClassContext keySignaturePitchClass(int i) {
			return getRuleContext(KeySignaturePitchClassContext.class,i);
		}
		public KeySignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keySignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterKeySignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitKeySignature(this);
		}
	}

	public final KeySignatureContext keySignature() throws RecognitionException {
		KeySignatureContext _localctx = new KeySignatureContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_keySignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(TANDEM_KEY);
			setState(263);
			match(LEFT_BRACKET);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_a) | (1L << CHAR_b) | (1L << CHAR_c) | (1L << CHAR_d) | (1L << CHAR_e) | (1L << CHAR_f) | (1L << CHAR_g))) != 0)) {
				{
				{
				setState(264);
				keySignaturePitchClass();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
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

	public static class KeySignaturePitchClassContext extends ParserRuleContext {
		public PitchClassContext pitchClass() {
			return getRuleContext(PitchClassContext.class,0);
		}
		public KeySignaturePitchClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keySignaturePitchClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterKeySignaturePitchClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitKeySignaturePitchClass(this);
		}
	}

	public final KeySignaturePitchClassContext keySignaturePitchClass() throws RecognitionException {
		KeySignaturePitchClassContext _localctx = new KeySignaturePitchClassContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_keySignaturePitchClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			pitchClass();
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

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public TerminalNode COLON() { return getToken(skmParser.COLON, 0); }
		public MinorKeyContext minorKey() {
			return getRuleContext(MinorKeyContext.class,0);
		}
		public MajorKeyContext majorKey() {
			return getRuleContext(MajorKeyContext.class,0);
		}
		public PitchClassContext pitchClass() {
			return getRuleContext(PitchClassContext.class,0);
		}
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(ASTERISK);
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_a:
			case CHAR_b:
			case CHAR_c:
			case CHAR_d:
			case CHAR_e:
			case CHAR_f:
			case CHAR_g:
				{
				setState(275);
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
				setState(276);
				majorKey();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_a) | (1L << CHAR_b) | (1L << CHAR_c) | (1L << CHAR_d) | (1L << CHAR_e) | (1L << CHAR_f) | (1L << CHAR_g))) != 0)) {
				{
				setState(279);
				pitchClass();
				}
			}

			setState(282);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMinorKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMinorKey(this);
		}
	}

	public final MinorKeyContext minorKey() throws RecognitionException {
		MinorKeyContext _localctx = new MinorKeyContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_minorKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMajorKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMajorKey(this);
		}
	}

	public final MajorKeyContext majorKey() throws RecognitionException {
		MajorKeyContext _localctx = new MajorKeyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_majorKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
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

	public static class FractionalTimeSignatureContext extends ParserRuleContext {
		public TerminalNode TANDEM_TIMESIGNATURE() { return getToken(skmParser.TANDEM_TIMESIGNATURE, 0); }
		public NumeratorContext numerator() {
			return getRuleContext(NumeratorContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(skmParser.SLASH, 0); }
		public DenominatorContext denominator() {
			return getRuleContext(DenominatorContext.class,0);
		}
		public FractionalTimeSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fractionalTimeSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterFractionalTimeSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitFractionalTimeSignature(this);
		}
	}

	public final FractionalTimeSignatureContext fractionalTimeSignature() throws RecognitionException {
		FractionalTimeSignatureContext _localctx = new FractionalTimeSignatureContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fractionalTimeSignature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(TANDEM_TIMESIGNATURE);
			setState(289);
			numerator();
			setState(290);
			match(SLASH);
			setState(291);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterNumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitNumerator(this);
		}
	}

	public final NumeratorContext numerator() throws RecognitionException {
		NumeratorContext _localctx = new NumeratorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterDenominator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitDenominator(this);
		}
	}

	public final DenominatorContext denominator() throws RecognitionException {
		DenominatorContext _localctx = new DenominatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_denominator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
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

	public static class MeterSymbolContext extends ParserRuleContext {
		public TerminalNode TANDEM_MET() { return getToken(skmParser.TANDEM_MET, 0); }
		public TerminalNode LEFT_PARENTHESIS() { return getToken(skmParser.LEFT_PARENTHESIS, 0); }
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(skmParser.RIGHT_PARENTHESIS, 0); }
		public ModernMeterSymbolSignContext modernMeterSymbolSign() {
			return getRuleContext(ModernMeterSymbolSignContext.class,0);
		}
		public MensurationContext mensuration() {
			return getRuleContext(MensurationContext.class,0);
		}
		public MeterSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meterSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMeterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMeterSymbol(this);
		}
	}

	public final MeterSymbolContext meterSymbol() throws RecognitionException {
		MeterSymbolContext _localctx = new MeterSymbolContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_meterSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(TANDEM_MET);
			setState(298);
			match(LEFT_PARENTHESIS);
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_c:
				{
				setState(299);
				modernMeterSymbolSign();
				}
				break;
			case CHAR_C:
			case CHAR_O:
			case DIGIT_3:
				{
				setState(300);
				mensuration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(303);
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

	public static class ModernMeterSymbolSignContext extends ParserRuleContext {
		public TerminalNode CHAR_c() { return getToken(skmParser.CHAR_c, 0); }
		public TerminalNode PIPE() { return getToken(skmParser.PIPE, 0); }
		public ModernMeterSymbolSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modernMeterSymbolSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterModernMeterSymbolSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitModernMeterSymbolSign(this);
		}
	}

	public final ModernMeterSymbolSignContext modernMeterSymbolSign() throws RecognitionException {
		ModernMeterSymbolSignContext _localctx = new ModernMeterSymbolSignContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_modernMeterSymbolSign);
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(CHAR_c);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				match(CHAR_c);
				setState(307);
				match(PIPE);
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

	public static class MensurationContext extends ParserRuleContext {
		public TerminalNode CHAR_C() { return getToken(skmParser.CHAR_C, 0); }
		public TerminalNode PIPE() { return getToken(skmParser.PIPE, 0); }
		public TerminalNode DOT() { return getToken(skmParser.DOT, 0); }
		public TerminalNode CHAR_O() { return getToken(skmParser.CHAR_O, 0); }
		public TerminalNode DIGIT_3() { return getToken(skmParser.DIGIT_3, 0); }
		public TerminalNode SLASH() { return getToken(skmParser.SLASH, 0); }
		public TerminalNode DIGIT_2() { return getToken(skmParser.DIGIT_2, 0); }
		public MensurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMensuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMensuration(this);
		}
	}

	public final MensurationContext mensuration() throws RecognitionException {
		MensurationContext _localctx = new MensurationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_mensuration);
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(CHAR_C);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(CHAR_C);
				setState(312);
				match(PIPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				match(CHAR_C);
				setState(314);
				match(DOT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				match(CHAR_O);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(316);
				match(CHAR_O);
				setState(317);
				match(DOT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(318);
				match(CHAR_C);
				setState(319);
				match(DIGIT_3);
				setState(320);
				match(SLASH);
				setState(321);
				match(DIGIT_2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(322);
				match(CHAR_C);
				setState(323);
				match(PIPE);
				setState(324);
				match(DIGIT_3);
				setState(325);
				match(SLASH);
				setState(326);
				match(DIGIT_2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(327);
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

	public static class MetronomeContext extends ParserRuleContext {
		public TerminalNode METRONOME() { return getToken(skmParser.METRONOME, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public MetronomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metronome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMetronome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMetronome(this);
		}
	}

	public final MetronomeContext metronome() throws RecognitionException {
		MetronomeContext _localctx = new MetronomeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_metronome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(METRONOME);
			setState(331);
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
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public NullInterpretationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullInterpretation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterNullInterpretation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitNullInterpretation(this);
		}
	}

	public final NullInterpretationContext nullInterpretation() throws RecognitionException {
		NullInterpretationContext _localctx = new NullInterpretationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_nullInterpretation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
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

	public static class BarlineContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(skmParser.EQUAL, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BarLineTypeContext barLineType() {
			return getRuleContext(BarLineTypeContext.class,0);
		}
		public BarlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBarline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBarline(this);
		}
	}

	public final BarlineContext barline() throws RecognitionException {
		BarlineContext _localctx = new BarlineContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_barline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(EQUAL);
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & ((1L << (DIGIT_0 - 55)) | (1L << (DIGIT_1 - 55)) | (1L << (DIGIT_2 - 55)) | (1L << (DIGIT_3 - 55)) | (1L << (DIGIT_4 - 55)) | (1L << (DIGIT_5 - 55)) | (1L << (DIGIT_6 - 55)) | (1L << (DIGIT_7 - 55)) | (1L << (DIGIT_8 - 55)) | (1L << (DIGIT_9 - 55)))) != 0)) {
				{
				setState(336);
				number();
				}
			}

			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (MINUS - 70)) | (1L << (EQUAL - 70)) | (1L << (PIPE - 70)) | (1L << (COLON - 70)))) != 0)) {
				{
				setState(339);
				barLineType();
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

	public static class BarLineTypeContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(skmParser.MINUS, 0); }
		public List<TerminalNode> PIPE() { return getTokens(skmParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(skmParser.PIPE, i);
		}
		public TerminalNode EQUAL() { return getToken(skmParser.EQUAL, 0); }
		public TerminalNode EXCLAMATION() { return getToken(skmParser.EXCLAMATION, 0); }
		public List<TerminalNode> COLON() { return getTokens(skmParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(skmParser.COLON, i);
		}
		public BarLineTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barLineType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBarLineType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBarLineType(this);
		}
	}

	public final BarLineTypeContext barLineType() throws RecognitionException {
		BarLineTypeContext _localctx = new BarLineTypeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_barLineType);
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(MINUS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(PIPE);
				setState(344);
				match(PIPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
				match(EQUAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(346);
				match(EXCLAMATION);
				setState(347);
				match(PIPE);
				setState(348);
				match(COLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(349);
				match(COLON);
				setState(350);
				match(PIPE);
				setState(351);
				match(EXCLAMATION);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				match(COLON);
				setState(353);
				match(PIPE);
				setState(354);
				match(EXCLAMATION);
				setState(355);
				match(PIPE);
				setState(356);
				match(COLON);
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

	public static class SpineOperationContext extends ParserRuleContext {
		public SpineTerminatorContext spineTerminator() {
			return getRuleContext(SpineTerminatorContext.class,0);
		}
		public SpineAddContext spineAdd() {
			return getRuleContext(SpineAddContext.class,0);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSpineOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSpineOperation(this);
		}
	}

	public final SpineOperationContext spineOperation() throws RecognitionException {
		SpineOperationContext _localctx = new SpineOperationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_spineOperation);
		try {
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				spineTerminator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				spineAdd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				spineSplit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
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
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public TerminalNode MINUS() { return getToken(skmParser.MINUS, 0); }
		public SpineTerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineTerminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSpineTerminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSpineTerminator(this);
		}
	}

	public final SpineTerminatorContext spineTerminator() throws RecognitionException {
		SpineTerminatorContext _localctx = new SpineTerminatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_spineTerminator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(ASTERISK);
			setState(366);
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

	public static class SpineAddContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public TerminalNode PLUS() { return getToken(skmParser.PLUS, 0); }
		public SpineAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineAdd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSpineAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSpineAdd(this);
		}
	}

	public final SpineAddContext spineAdd() throws RecognitionException {
		SpineAddContext _localctx = new SpineAddContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_spineAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(ASTERISK);
			setState(369);
			match(PLUS);
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
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public TerminalNode CIRCUMFLEX() { return getToken(skmParser.CIRCUMFLEX, 0); }
		public SpineSplitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineSplit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSpineSplit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSpineSplit(this);
		}
	}

	public final SpineSplitContext spineSplit() throws RecognitionException {
		SpineSplitContext _localctx = new SpineSplitContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_spineSplit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(ASTERISK);
			setState(372);
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
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public TerminalNode CHAR_v() { return getToken(skmParser.CHAR_v, 0); }
		public SpineJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spineJoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSpineJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSpineJoin(this);
		}
	}

	public final SpineJoinContext spineJoin() throws RecognitionException {
		SpineJoinContext _localctx = new SpineJoinContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_spineJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(ASTERISK);
			setState(375);
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

	public static class RestContext extends ParserRuleContext {
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public TerminalNode CHAR_r() { return getToken(skmParser.CHAR_r, 0); }
		public FermataContext fermata() {
			return getRuleContext(FermataContext.class,0);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitRest(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			duration();
			{
			setState(378);
			match(CHAR_r);
			}
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(379);
				fermata();
				}
			}

			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDERSCORE) {
				{
				setState(382);
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
		public TerminalNode UNDERSCORE() { return getToken(skmParser.UNDERSCORE, 0); }
		public ClefLineContext clefLine() {
			return getRuleContext(ClefLineContext.class,0);
		}
		public RestLinePositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restLinePosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterRestLinePosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitRestLinePosition(this);
		}
	}

	public final RestLinePositionContext restLinePosition() throws RecognitionException {
		RestLinePositionContext _localctx = new RestLinePositionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_restLinePosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(UNDERSCORE);
			setState(386);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitDuration(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_duration);
		try {
			setState(390);
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
				setState(388);
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
				setState(389);
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

	public static class FermataContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(skmParser.SEMICOLON, 0); }
		public FermataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fermata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterFermata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitFermata(this);
		}
	}

	public final FermataContext fermata() throws RecognitionException {
		FermataContext _localctx = new FermataContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_fermata);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMensuralDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMensuralDuration(this);
		}
	}

	public final MensuralDurationContext mensuralDuration() throws RecognitionException {
		MensuralDurationContext _localctx = new MensuralDurationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_mensuralDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			mensuralFigure();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TILDE) {
				{
				setState(395);
				coloured();
				}
			}

			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_I) | (1L << CHAR_i) | (1L << CHAR_p))) != 0)) {
				{
				setState(398);
				mensuralPerfection();
				}
			}

			setState(401);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMensuralDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMensuralDot(this);
		}
	}

	public final MensuralDotContext mensuralDot() throws RecognitionException {
		MensuralDotContext _localctx = new MensuralDotContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_mensuralDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(403);
				augmentationDot();
				}
				break;
			case COLON:
				{
				setState(404);
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
			case CHAR_a:
			case CHAR_b:
			case CHAR_c:
			case CHAR_d:
			case CHAR_e:
			case CHAR_f:
			case CHAR_g:
			case CHAR_r:
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterModernDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitModernDuration(this);
		}
	}

	public final ModernDurationContext modernDuration() throws RecognitionException {
		ModernDurationContext _localctx = new ModernDurationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_modernDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			number();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(408);
				augmentationDot();
				}
				}
				setState(413);
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
		public TerminalNode TILDE() { return getToken(skmParser.TILDE, 0); }
		public ColouredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coloured; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterColoured(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitColoured(this);
		}
	}

	public final ColouredContext coloured() throws RecognitionException {
		ColouredContext _localctx = new ColouredContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_coloured);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
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
		public TerminalNode CHAR_X() { return getToken(skmParser.CHAR_X, 0); }
		public TerminalNode CHAR_L() { return getToken(skmParser.CHAR_L, 0); }
		public TerminalNode CHAR_S() { return getToken(skmParser.CHAR_S, 0); }
		public TerminalNode CHAR_s() { return getToken(skmParser.CHAR_s, 0); }
		public TerminalNode CHAR_M() { return getToken(skmParser.CHAR_M, 0); }
		public TerminalNode CHAR_m() { return getToken(skmParser.CHAR_m, 0); }
		public TerminalNode CHAR_U() { return getToken(skmParser.CHAR_U, 0); }
		public TerminalNode CHAR_u() { return getToken(skmParser.CHAR_u, 0); }
		public MensuralFigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuralFigure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMensuralFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMensuralFigure(this);
		}
	}

	public final MensuralFigureContext mensuralFigure() throws RecognitionException {
		MensuralFigureContext _localctx = new MensuralFigureContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_mensuralFigure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
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
		public TerminalNode CHAR_p() { return getToken(skmParser.CHAR_p, 0); }
		public TerminalNode CHAR_i() { return getToken(skmParser.CHAR_i, 0); }
		public TerminalNode CHAR_I() { return getToken(skmParser.CHAR_I, 0); }
		public MensuralPerfectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mensuralPerfection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterMensuralPerfection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitMensuralPerfection(this);
		}
	}

	public final MensuralPerfectionContext mensuralPerfection() throws RecognitionException {
		MensuralPerfectionContext _localctx = new MensuralPerfectionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_mensuralPerfection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
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
		public TerminalNode DOT() { return getToken(skmParser.DOT, 0); }
		public AugmentationDotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augmentationDot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterAugmentationDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitAugmentationDot(this);
		}
	}

	public final AugmentationDotContext augmentationDot() throws RecognitionException {
		AugmentationDotContext _localctx = new AugmentationDotContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_augmentationDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
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
		public TerminalNode COLON() { return getToken(skmParser.COLON, 0); }
		public SeparationDotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separationDot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSeparationDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSeparationDot(this);
		}
	}

	public final SeparationDotContext separationDot() throws RecognitionException {
		SeparationDotContext _localctx = new SeparationDotContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_separationDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
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
		public TerminalNode TANDEM_CUSTOS() { return getToken(skmParser.TANDEM_CUSTOS, 0); }
		public PitchContext pitch() {
			return getRuleContext(PitchContext.class,0);
		}
		public CustosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_custos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterCustos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitCustos(this);
		}
	}

	public final CustosContext custos() throws RecognitionException {
		CustosContext _localctx = new CustosContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_custos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(TANDEM_CUSTOS);
			setState(425);
			pitch();
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

	public static class PitchContext extends ParserRuleContext {
		public DiatonicPitchContext diatonicPitch() {
			return getRuleContext(DiatonicPitchContext.class,0);
		}
		public AlterationContext alteration() {
			return getRuleContext(AlterationContext.class,0);
		}
		public PitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterPitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitPitch(this);
		}
	}

	public final PitchContext pitch() throws RecognitionException {
		PitchContext _localctx = new PitchContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_pitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			diatonicPitch();
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (CHAR_n - 46)) | (1L << (OCTOTHORPE - 46)) | (1L << (MINUS - 46)))) != 0)) {
				{
				setState(428);
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

	public static class AlterationContext extends ParserRuleContext {
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
		}
		public AlterationDisplayContext alterationDisplay() {
			return getRuleContext(AlterationDisplayContext.class,0);
		}
		public AlterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alteration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterAlteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitAlteration(this);
		}
	}

	public final AlterationContext alteration() throws RecognitionException {
		AlterationContext _localctx = new AlterationContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_alteration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			accidental();
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHAR_Y || _la==CHAR_y) {
				{
				setState(432);
				alterationDisplay();
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
		public PitchContext pitch() {
			return getRuleContext(PitchContext.class,0);
		}
		public AfterNoteContext afterNote() {
			return getRuleContext(AfterNoteContext.class,0);
		}
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitNote(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_note);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			beforeNote();
			setState(436);
			duration();
			setState(437);
			pitch();
			setState(438);
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

	public static class ChordContext extends ParserRuleContext {
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(skmParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(skmParser.SPACE, i);
		}
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitChord(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			note();
			setState(443); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(441);
				match(SPACE);
				setState(442);
				note();
				}
				}
				setState(445); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE );
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBeforeNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBeforeNote(this);
		}
	}

	public final BeforeNoteContext beforeNote() throws RecognitionException {
		BeforeNoteContext _localctx = new BeforeNoteContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_beforeNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (CHAR_T - 35)) | (1L << (LEFT_BRACKET - 35)) | (1L << (ANGLE_BRACKET_OPEN - 35)) | (1L << (LEFT_PARENTHESIS - 35)))) != 0)) {
				{
				setState(450);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_PARENTHESIS:
					{
					setState(447);
					slurStart();
					}
					break;
				case LEFT_BRACKET:
				case ANGLE_BRACKET_OPEN:
					{
					setState(448);
					ligatureStart();
					}
					break;
				case CHAR_T:
					{
					setState(449);
					barLineCrossedNoteStart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(454);
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

	public static class DiatonicPitchContext extends ParserRuleContext {
		public BassNotesContext bassNotes() {
			return getRuleContext(BassNotesContext.class,0);
		}
		public TrebleNotesContext trebleNotes() {
			return getRuleContext(TrebleNotesContext.class,0);
		}
		public DiatonicPitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diatonicPitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterDiatonicPitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitDiatonicPitch(this);
		}
	}

	public final DiatonicPitchContext diatonicPitch() throws RecognitionException {
		DiatonicPitchContext _localctx = new DiatonicPitchContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_diatonicPitch);
		try {
			setState(457);
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
				setState(455);
				bassNotes();
				}
				break;
			case CHAR_a:
			case CHAR_b:
			case CHAR_c:
			case CHAR_d:
			case CHAR_e:
			case CHAR_f:
			case CHAR_g:
				enterOuterAlt(_localctx, 2);
				{
				setState(456);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterTrebleNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitTrebleNotes(this);
		}
	}

	public final TrebleNotesContext trebleNotes() throws RecognitionException {
		TrebleNotesContext _localctx = new TrebleNotesContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_trebleNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(459);
				lowerCasePitch();
				}
				}
				setState(462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_a) | (1L << CHAR_b) | (1L << CHAR_c) | (1L << CHAR_d) | (1L << CHAR_e) | (1L << CHAR_f) | (1L << CHAR_g))) != 0) );
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBassNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBassNotes(this);
		}
	}

	public final BassNotesContext bassNotes() throws RecognitionException {
		BassNotesContext _localctx = new BassNotesContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_bassNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(464);
				upperCasePitch();
				}
				}
				setState(467); 
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

	public static class AccidentalContext extends ParserRuleContext {
		public List<TerminalNode> OCTOTHORPE() { return getTokens(skmParser.OCTOTHORPE); }
		public TerminalNode OCTOTHORPE(int i) {
			return getToken(skmParser.OCTOTHORPE, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(skmParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(skmParser.MINUS, i);
		}
		public TerminalNode CHAR_n() { return getToken(skmParser.CHAR_n, 0); }
		public AccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitAccidental(this);
		}
	}

	public final AccidentalContext accidental() throws RecognitionException {
		AccidentalContext _localctx = new AccidentalContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_accidental);
		try {
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				match(OCTOTHORPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(470);
				match(OCTOTHORPE);
				setState(471);
				match(OCTOTHORPE);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(472);
				match(MINUS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(473);
				match(MINUS);
				setState(474);
				match(MINUS);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(475);
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

	public static class AlterationDisplayContext extends ParserRuleContext {
		public List<TerminalNode> CHAR_y() { return getTokens(skmParser.CHAR_y); }
		public TerminalNode CHAR_y(int i) {
			return getToken(skmParser.CHAR_y, i);
		}
		public List<TerminalNode> CHAR_Y() { return getTokens(skmParser.CHAR_Y); }
		public TerminalNode CHAR_Y(int i) {
			return getToken(skmParser.CHAR_Y, i);
		}
		public AlterationDisplayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterationDisplay; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterAlterationDisplay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitAlterationDisplay(this);
		}
	}

	public final AlterationDisplayContext alterationDisplay() throws RecognitionException {
		AlterationDisplayContext _localctx = new AlterationDisplayContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_alterationDisplay);
		int _la;
		try {
			setState(486);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_y:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(478);
				match(CHAR_y);
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_y) {
					{
					setState(479);
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
				setState(482);
				match(CHAR_Y);
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_Y) {
					{
					setState(483);
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
		public List<FermataContext> fermata() {
			return getRuleContexts(FermataContext.class);
		}
		public FermataContext fermata(int i) {
			return getRuleContext(FermataContext.class,i);
		}
		public List<BarLineCrossedNoteEndContext> barLineCrossedNoteEnd() {
			return getRuleContexts(BarLineCrossedNoteEndContext.class);
		}
		public BarLineCrossedNoteEndContext barLineCrossedNoteEnd(int i) {
			return getRuleContext(BarLineCrossedNoteEndContext.class,i);
		}
		public AfterNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterNote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterAfterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitAfterNote(this);
		}
	}

	public final AfterNoteContext afterNote() throws RecognitionException {
		AfterNoteContext _localctx = new AfterNoteContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_afterNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (CHAR_J - 25)) | (1L << (CHAR_L - 25)) | (1L << (CHAR_t - 25)) | (1L << (RIGHT_BRACKET - 25)) | (1L << (ANGLE_BRACKET_CLOSE - 25)) | (1L << (SLASH - 25)) | (1L << (BACKSLASH - 25)) | (1L << (RIGHT_PARENTHESIS - 25)) | (1L << (SEMICOLON - 25)))) != 0)) {
				{
				setState(494);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RIGHT_PARENTHESIS:
					{
					setState(488);
					slurEnd();
					}
					break;
				case SLASH:
				case BACKSLASH:
					{
					setState(489);
					stem();
					}
					break;
				case RIGHT_BRACKET:
				case ANGLE_BRACKET_CLOSE:
					{
					setState(490);
					ligatureEnd();
					}
					break;
				case CHAR_J:
				case CHAR_L:
					{
					setState(491);
					beam();
					}
					break;
				case SEMICOLON:
					{
					setState(492);
					fermata();
					}
					break;
				case CHAR_t:
					{
					setState(493);
					barLineCrossedNoteEnd();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(498);
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

	public static class SlurStartContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESIS() { return getToken(skmParser.LEFT_PARENTHESIS, 0); }
		public SlurStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slurStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSlurStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSlurStart(this);
		}
	}

	public final SlurStartContext slurStart() throws RecognitionException {
		SlurStartContext _localctx = new SlurStartContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_slurStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
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
		public TerminalNode ANGLE_BRACKET_OPEN() { return getToken(skmParser.ANGLE_BRACKET_OPEN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(skmParser.LEFT_BRACKET, 0); }
		public LigatureStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ligatureStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterLigatureStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitLigatureStart(this);
		}
	}

	public final LigatureStartContext ligatureStart() throws RecognitionException {
		LigatureStartContext _localctx = new LigatureStartContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_ligatureStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
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
		public TerminalNode ANGLE_BRACKET_CLOSE() { return getToken(skmParser.ANGLE_BRACKET_CLOSE, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(skmParser.RIGHT_BRACKET, 0); }
		public LigatureEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ligatureEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterLigatureEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitLigatureEnd(this);
		}
	}

	public final LigatureEndContext ligatureEnd() throws RecognitionException {
		LigatureEndContext _localctx = new LigatureEndContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_ligatureEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
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
		public TerminalNode RIGHT_PARENTHESIS() { return getToken(skmParser.RIGHT_PARENTHESIS, 0); }
		public SlurEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slurEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterSlurEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitSlurEnd(this);
		}
	}

	public final SlurEndContext slurEnd() throws RecognitionException {
		SlurEndContext _localctx = new SlurEndContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_slurEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
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
		public TerminalNode CHAR_T() { return getToken(skmParser.CHAR_T, 0); }
		public BarLineCrossedNoteStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barLineCrossedNoteStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBarLineCrossedNoteStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBarLineCrossedNoteStart(this);
		}
	}

	public final BarLineCrossedNoteStartContext barLineCrossedNoteStart() throws RecognitionException {
		BarLineCrossedNoteStartContext _localctx = new BarLineCrossedNoteStartContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_barLineCrossedNoteStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
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
		public TerminalNode CHAR_t() { return getToken(skmParser.CHAR_t, 0); }
		public BarLineCrossedNoteEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barLineCrossedNoteEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBarLineCrossedNoteEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBarLineCrossedNoteEnd(this);
		}
	}

	public final BarLineCrossedNoteEndContext barLineCrossedNoteEnd() throws RecognitionException {
		BarLineCrossedNoteEndContext _localctx = new BarLineCrossedNoteEndContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_barLineCrossedNoteEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
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
		public TerminalNode SLASH() { return getToken(skmParser.SLASH, 0); }
		public TerminalNode BACKSLASH() { return getToken(skmParser.BACKSLASH, 0); }
		public StemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterStem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitStem(this);
		}
	}

	public final StemContext stem() throws RecognitionException {
		StemContext _localctx = new StemContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_stem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
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
		public TerminalNode CHAR_L() { return getToken(skmParser.CHAR_L, 0); }
		public TerminalNode CHAR_J() { return getToken(skmParser.CHAR_J, 0); }
		public BeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterBeam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitBeam(this);
		}
	}

	public final BeamContext beam() throws RecognitionException {
		BeamContext _localctx = new BeamContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_beam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
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
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterStaffPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitStaffPosition(this);
		}
	}

	public final StaffPositionContext staffPosition() throws RecognitionException {
		StaffPositionContext _localctx = new StaffPositionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_staffPosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			lineSpace();
			setState(516);
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
		public TerminalNode CHAR_L() { return getToken(skmParser.CHAR_L, 0); }
		public TerminalNode CHAR_S() { return getToken(skmParser.CHAR_S, 0); }
		public LineSpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineSpace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterLineSpace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitLineSpace(this);
		}
	}

	public final LineSpaceContext lineSpace() throws RecognitionException {
		LineSpaceContext _localctx = new LineSpaceContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_lineSpace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
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
		public TerminalNode FIELD_TEXT() { return getToken(skmParser.FIELD_TEXT, 0); }
		public LyricsTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lyricsText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterLyricsText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitLyricsText(this);
		}
	}

	public final LyricsTextContext lyricsText() throws RecognitionException {
		LyricsTextContext _localctx = new LyricsTextContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_lyricsText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
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
		public TerminalNode TANDEM_BEGIN_PLAIN_CHANT() { return getToken(skmParser.TANDEM_BEGIN_PLAIN_CHANT, 0); }
		public TerminalNode TANDEM_END_PLAIN_CHANT() { return getToken(skmParser.TANDEM_END_PLAIN_CHANT, 0); }
		public PlainChantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plainChant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterPlainChant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitPlainChant(this);
		}
	}

	public final PlainChantContext plainChant() throws RecognitionException {
		PlainChantContext _localctx = new PlainChantContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_plainChant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3_\u020f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\2\3\2\6\2\u00a3\n\2"+
		"\r\2\16\2\u00a4\3\2\5\2\u00a8\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4\u00b1"+
		"\n\4\f\4\16\4\u00b4\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00c0"+
		"\n\b\f\b\16\b\u00c3\13\b\3\t\3\t\5\t\u00c7\n\t\3\n\3\n\3\n\7\n\u00cc\n"+
		"\n\f\n\16\n\u00cf\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00db"+
		"\n\f\3\f\3\f\5\f\u00df\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00eb\n\r\3\16\6\16\u00ee\n\16\r\16\16\16\u00ef\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\7\30\u010c\n\30\f\30\16\30\u010f"+
		"\13\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u0118\n\32\3\32\5\32\u011b"+
		"\n\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3 \3 \5 \u0130\n \3 \3 \3!\3!\3!\5!\u0137\n!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u014b"+
		"\n\"\3#\3#\3#\3$\3$\3%\3%\5%\u0154\n%\3%\5%\u0157\n%\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0168\n&\3\'\3\'\3\'\3\'\5\'\u016e\n\'"+
		"\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\5,\u017f\n,\3,\5,\u0182"+
		"\n,\3-\3-\3-\3.\3.\5.\u0189\n.\3/\3/\3\60\3\60\5\60\u018f\n\60\3\60\5"+
		"\60\u0192\n\60\3\60\3\60\3\61\3\61\5\61\u0198\n\61\3\62\3\62\7\62\u019c"+
		"\n\62\f\62\16\62\u019f\13\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\38\38\38\39\39\59\u01b0\n9\3:\3:\5:\u01b4\n:\3;\3;\3;\3;\3;\3"+
		"<\3<\3<\6<\u01be\n<\r<\16<\u01bf\3=\3=\3=\7=\u01c5\n=\f=\16=\u01c8\13"+
		"=\3>\3>\5>\u01cc\n>\3?\6?\u01cf\n?\r?\16?\u01d0\3@\6@\u01d4\n@\r@\16@"+
		"\u01d5\3A\3A\3A\3A\3A\3A\3A\5A\u01df\nA\3B\3B\5B\u01e3\nB\3B\3B\5B\u01e7"+
		"\nB\5B\u01e9\nB\3C\3C\3C\3C\3C\3C\7C\u01f1\nC\fC\16C\u01f4\13C\3D\3D\3"+
		"E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3L\3M\3M\3N\3N\3O\3O\3"+
		"O\2\2P\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\2\21\3\2\4\6\4"+
		"\2[[^^\3\29B\3\2\'-\3\2\23\31\4\2\25\25\30\31\3\2:>\b\2\34\35\"#&&//\63"+
		"\63\65\65\5\2\32\32..\61\61\4\2DDPP\4\2EEQQ\3\2RS\3\2\33\34\4\2\34\34"+
		"\"\"\3\2\20\21\2\u020c\2\u009e\3\2\2\2\4\u00ab\3\2\2\2\6\u00ad\3\2\2\2"+
		"\b\u00b5\3\2\2\2\n\u00b7\3\2\2\2\f\u00b9\3\2\2\2\16\u00bb\3\2\2\2\20\u00c6"+
		"\3\2\2\2\22\u00c8\3\2\2\2\24\u00d0\3\2\2\2\26\u00da\3\2\2\2\30\u00ea\3"+
		"\2\2\2\32\u00ed\3\2\2\2\34\u00f1\3\2\2\2\36\u00f3\3\2\2\2 \u00f5\3\2\2"+
		"\2\"\u00f8\3\2\2\2$\u00fb\3\2\2\2&\u00fe\3\2\2\2(\u0101\3\2\2\2*\u0104"+
		"\3\2\2\2,\u0106\3\2\2\2.\u0108\3\2\2\2\60\u0112\3\2\2\2\62\u0114\3\2\2"+
		"\2\64\u011e\3\2\2\2\66\u0120\3\2\2\28\u0122\3\2\2\2:\u0127\3\2\2\2<\u0129"+
		"\3\2\2\2>\u012b\3\2\2\2@\u0136\3\2\2\2B\u014a\3\2\2\2D\u014c\3\2\2\2F"+
		"\u014f\3\2\2\2H\u0151\3\2\2\2J\u0167\3\2\2\2L\u016d\3\2\2\2N\u016f\3\2"+
		"\2\2P\u0172\3\2\2\2R\u0175\3\2\2\2T\u0178\3\2\2\2V\u017b\3\2\2\2X\u0183"+
		"\3\2\2\2Z\u0188\3\2\2\2\\\u018a\3\2\2\2^\u018c\3\2\2\2`\u0197\3\2\2\2"+
		"b\u0199\3\2\2\2d\u01a0\3\2\2\2f\u01a2\3\2\2\2h\u01a4\3\2\2\2j\u01a6\3"+
		"\2\2\2l\u01a8\3\2\2\2n\u01aa\3\2\2\2p\u01ad\3\2\2\2r\u01b1\3\2\2\2t\u01b5"+
		"\3\2\2\2v\u01ba\3\2\2\2x\u01c6\3\2\2\2z\u01cb\3\2\2\2|\u01ce\3\2\2\2~"+
		"\u01d3\3\2\2\2\u0080\u01de\3\2\2\2\u0082\u01e8\3\2\2\2\u0084\u01f2\3\2"+
		"\2\2\u0086\u01f5\3\2\2\2\u0088\u01f7\3\2\2\2\u008a\u01f9\3\2\2\2\u008c"+
		"\u01fb\3\2\2\2\u008e\u01fd\3\2\2\2\u0090\u01ff\3\2\2\2\u0092\u0201\3\2"+
		"\2\2\u0094\u0203\3\2\2\2\u0096\u0205\3\2\2\2\u0098\u0208\3\2\2\2\u009a"+
		"\u020a\3\2\2\2\u009c\u020c\3\2\2\2\u009e\u00a2\5\6\4\2\u009f\u00a0\5\4"+
		"\3\2\u00a0\u00a1\5\n\6\2\u00a1\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a8\5\4\3\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\7\2\2\3\u00aa\3\3\2\2\2\u00ab\u00ac\7\\\2\2"+
		"\u00ac\5\3\2\2\2\u00ad\u00b2\5\b\5\2\u00ae\u00af\7[\2\2\u00af\u00b1\5"+
		"\b\5\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\7\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\t\2\2\2"+
		"\u00b6\t\3\2\2\2\u00b7\u00b8\5\16\b\2\u00b8\13\3\2\2\2\u00b9\u00ba\t\3"+
		"\2\2\u00ba\r\3\2\2\2\u00bb\u00c1\5\20\t\2\u00bc\u00bd\5\f\7\2\u00bd\u00be"+
		"\5\20\t\2\u00be\u00c0\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2"+
		"\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\17\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c7\5\26\f\2\u00c5\u00c7\5\24\13\2\u00c6\u00c4\3\2\2"+
		"\2\u00c6\u00c5\3\2\2\2\u00c7\21\3\2\2\2\u00c8\u00cd\5\32\16\2\u00c9\u00ca"+
		"\7Y\2\2\u00ca\u00cc\5\22\n\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\23\3\2\2\2\u00cf\u00cd\3\2\2"+
		"\2\u00d0\u00d1\7J\2\2\u00d1\25\3\2\2\2\u00d2\u00db\5\30\r\2\u00d3\u00db"+
		"\5\"\22\2\u00d4\u00db\5H%\2\u00d5\u00db\5V,\2\u00d6\u00db\5t;\2\u00d7"+
		"\u00db\5v<\2\u00d8\u00db\5L\'\2\u00d9\u00db\5\u009aN\2\u00da\u00d2\3\2"+
		"\2\2\u00da\u00d3\3\2\2\2\u00da\u00d4\3\2\2\2\u00da\u00d5\3\2\2\2\u00da"+
		"\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2"+
		"\2\2\u00db\u00de\3\2\2\2\u00dc\u00dd\7\22\2\2\u00dd\u00df\5\22\n\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\27\3\2\2\2\u00e0\u00eb\5$\23"+
		"\2\u00e1\u00eb\5&\24\2\u00e2\u00eb\5.\30\2\u00e3\u00eb\58\35\2\u00e4\u00eb"+
		"\5> \2\u00e5\u00eb\5\62\32\2\u00e6\u00eb\5D#\2\u00e7\u00eb\5F$\2\u00e8"+
		"\u00eb\5n8\2\u00e9\u00eb\5\u009cO\2\u00ea\u00e0\3\2\2\2\u00ea\u00e1\3"+
		"\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00e3\3\2\2\2\u00ea\u00e4\3\2\2\2\u00ea"+
		"\u00e5\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e7\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00ea\u00e9\3\2\2\2\u00eb\31\3\2\2\2\u00ec\u00ee\t\4\2\2\u00ed\u00ec"+
		"\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\33\3\2\2\2\u00f1\u00f2\t\5\2\2\u00f2\35\3\2\2\2\u00f3\u00f4\t\6\2\2\u00f4"+
		"\37\3\2\2\2\u00f5\u00f6\5\34\17\2\u00f6\u00f7\5\u0080A\2\u00f7!\3\2\2"+
		"\2\u00f8\u00f9\7\7\2\2\u00f9\u00fa\5\32\16\2\u00fa#\3\2\2\2\u00fb\u00fc"+
		"\7\t\2\2\u00fc\u00fd\5\32\16\2\u00fd%\3\2\2\2\u00fe\u00ff\7\n\2\2\u00ff"+
		"\u0100\5(\25\2\u0100\'\3\2\2\2\u0101\u0102\5*\26\2\u0102\u0103\5,\27\2"+
		"\u0103)\3\2\2\2\u0104\u0105\t\7\2\2\u0105+\3\2\2\2\u0106\u0107\t\b\2\2"+
		"\u0107-\3\2\2\2\u0108\u0109\7\f\2\2\u0109\u010d\7D\2\2\u010a\u010c\5\60"+
		"\31\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7E"+
		"\2\2\u0111/\3\2\2\2\u0112\u0113\5 \21\2\u0113\61\3\2\2\2\u0114\u0117\7"+
		"C\2\2\u0115\u0118\5\64\33\2\u0116\u0118\5\66\34\2\u0117\u0115\3\2\2\2"+
		"\u0117\u0116\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u011b\5 \21\2\u011a\u0119"+
		"\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7W\2\2\u011d"+
		"\63\3\2\2\2\u011e\u011f\5\34\17\2\u011f\65\3\2\2\2\u0120\u0121\5\36\20"+
		"\2\u0121\67\3\2\2\2\u0122\u0123\7\17\2\2\u0123\u0124\5:\36\2\u0124\u0125"+
		"\7R\2\2\u0125\u0126\5<\37\2\u01269\3\2\2\2\u0127\u0128\5\32\16\2\u0128"+
		";\3\2\2\2\u0129\u012a\5\32\16\2\u012a=\3\2\2\2\u012b\u012c\7\r\2\2\u012c"+
		"\u012f\7U\2\2\u012d\u0130\5@!\2\u012e\u0130\5B\"\2\u012f\u012d\3\2\2\2"+
		"\u012f\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\7V\2\2\u0132?\3\2"+
		"\2\2\u0133\u0137\7)\2\2\u0134\u0135\7)\2\2\u0135\u0137\7K\2\2\u0136\u0133"+
		"\3\2\2\2\u0136\u0134\3\2\2\2\u0137A\3\2\2\2\u0138\u014b\7\25\2\2\u0139"+
		"\u013a\7\25\2\2\u013a\u014b\7K\2\2\u013b\u013c\7\25\2\2\u013c\u014b\7"+
		"J\2\2\u013d\u014b\7\36\2\2\u013e\u013f\7\36\2\2\u013f\u014b\7J\2\2\u0140"+
		"\u0141\7\25\2\2\u0141\u0142\7<\2\2\u0142\u0143\7R\2\2\u0143\u014b\7;\2"+
		"\2\u0144\u0145\7\25\2\2\u0145\u0146\7K\2\2\u0146\u0147\7<\2\2\u0147\u0148"+
		"\7R\2\2\u0148\u014b\7;\2\2\u0149\u014b\7<\2\2\u014a\u0138\3\2\2\2\u014a"+
		"\u0139\3\2\2\2\u014a\u013b\3\2\2\2\u014a\u013d\3\2\2\2\u014a\u013e\3\2"+
		"\2\2\u014a\u0140\3\2\2\2\u014a\u0144\3\2\2\2\u014a\u0149\3\2\2\2\u014b"+
		"C\3\2\2\2\u014c\u014d\7\16\2\2\u014d\u014e\5\32\16\2\u014eE\3\2\2\2\u014f"+
		"\u0150\7C\2\2\u0150G\3\2\2\2\u0151\u0153\7I\2\2\u0152\u0154\5\32\16\2"+
		"\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0157"+
		"\5J&\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157I\3\2\2\2\u0158\u0168"+
		"\7H\2\2\u0159\u015a\7K\2\2\u015a\u0168\7K\2\2\u015b\u0168\7I\2\2\u015c"+
		"\u015d\7\3\2\2\u015d\u015e\7K\2\2\u015e\u0168\7W\2\2\u015f\u0160\7W\2"+
		"\2\u0160\u0161\7K\2\2\u0161\u0168\7\3\2\2\u0162\u0163\7W\2\2\u0163\u0164"+
		"\7K\2\2\u0164\u0165\7\3\2\2\u0165\u0166\7K\2\2\u0166\u0168\7W\2\2\u0167"+
		"\u0158\3\2\2\2\u0167\u0159\3\2\2\2\u0167\u015b\3\2\2\2\u0167\u015c\3\2"+
		"\2\2\u0167\u015f\3\2\2\2\u0167\u0162\3\2\2\2\u0168K\3\2\2\2\u0169\u016e"+
		"\5N(\2\u016a\u016e\5P)\2\u016b\u016e\5R*\2\u016c\u016e\5T+\2\u016d\u0169"+
		"\3\2\2\2\u016d\u016a\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016c\3\2\2\2\u016e"+
		"M\3\2\2\2\u016f\u0170\7C\2\2\u0170\u0171\7H\2\2\u0171O\3\2\2\2\u0172\u0173"+
		"\7C\2\2\u0173\u0174\7G\2\2\u0174Q\3\2\2\2\u0175\u0176\7C\2\2\u0176\u0177"+
		"\7N\2\2\u0177S\3\2\2\2\u0178\u0179\7C\2\2\u0179\u017a\7\66\2\2\u017aU"+
		"\3\2\2\2\u017b\u017c\5Z.\2\u017c\u017e\7\62\2\2\u017d\u017f\5\\/\2\u017e"+
		"\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u0182\5X"+
		"-\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182W\3\2\2\2\u0183\u0184"+
		"\7T\2\2\u0184\u0185\5,\27\2\u0185Y\3\2\2\2\u0186\u0189\5^\60\2\u0187\u0189"+
		"\5b\62\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189[\3\2\2\2\u018a"+
		"\u018b\7X\2\2\u018b]\3\2\2\2\u018c\u018e\5f\64\2\u018d\u018f\5d\63\2\u018e"+
		"\u018d\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u0192\5h"+
		"\65\2\u0191\u0190\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0194\5`\61\2\u0194_\3\2\2\2\u0195\u0198\5j\66\2\u0196\u0198\5l\67\2"+
		"\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198a\3"+
		"\2\2\2\u0199\u019d\5\32\16\2\u019a\u019c\5j\66\2\u019b\u019a\3\2\2\2\u019c"+
		"\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019ec\3\2\2\2"+
		"\u019f\u019d\3\2\2\2\u01a0\u01a1\7O\2\2\u01a1e\3\2\2\2\u01a2\u01a3\t\t"+
		"\2\2\u01a3g\3\2\2\2\u01a4\u01a5\t\n\2\2\u01a5i\3\2\2\2\u01a6\u01a7\7J"+
		"\2\2\u01a7k\3\2\2\2\u01a8\u01a9\7W\2\2\u01a9m\3\2\2\2\u01aa\u01ab\7\13"+
		"\2\2\u01ab\u01ac\5p9\2\u01aco\3\2\2\2\u01ad\u01af\5z>\2\u01ae\u01b0\5"+
		"r:\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0q\3\2\2\2\u01b1\u01b3"+
		"\5\u0080A\2\u01b2\u01b4\5\u0082B\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2"+
		"\2\2\u01b4s\3\2\2\2\u01b5\u01b6\5x=\2\u01b6\u01b7\5Z.\2\u01b7\u01b8\5"+
		"p9\2\u01b8\u01b9\5\u0084C\2\u01b9u\3\2\2\2\u01ba\u01bd\5t;\2\u01bb\u01bc"+
		"\7Z\2\2\u01bc\u01be\5t;\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0w\3\2\2\2\u01c1\u01c5\5\u0086"+
		"D\2\u01c2\u01c5\5\u0088E\2\u01c3\u01c5\5\u008eH\2\u01c4\u01c1\3\2\2\2"+
		"\u01c4\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7y\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9"+
		"\u01cc\5~@\2\u01ca\u01cc\5|?\2\u01cb\u01c9\3\2\2\2\u01cb\u01ca\3\2\2\2"+
		"\u01cc{\3\2\2\2\u01cd\u01cf\5\34\17\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1}\3\2\2\2\u01d2"+
		"\u01d4\5\36\20\2\u01d3\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d3\3"+
		"\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\177\3\2\2\2\u01d7\u01df\7F\2\2\u01d8"+
		"\u01d9\7F\2\2\u01d9\u01df\7F\2\2\u01da\u01df\7H\2\2\u01db\u01dc\7H\2\2"+
		"\u01dc\u01df\7H\2\2\u01dd\u01df\7\60\2\2\u01de\u01d7\3\2\2\2\u01de\u01d8"+
		"\3\2\2\2\u01de\u01da\3\2\2\2\u01de\u01db\3\2\2\2\u01de\u01dd\3\2\2\2\u01df"+
		"\u0081\3\2\2\2\u01e0\u01e2\78\2\2\u01e1\u01e3\78\2\2\u01e2\u01e1\3\2\2"+
		"\2\u01e2\u01e3\3\2\2\2\u01e3\u01e9\3\2\2\2\u01e4\u01e6\7$\2\2\u01e5\u01e7"+
		"\7$\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8"+
		"\u01e0\3\2\2\2\u01e8\u01e4\3\2\2\2\u01e9\u0083\3\2\2\2\u01ea\u01f1\5\u008c"+
		"G\2\u01eb\u01f1\5\u0092J\2\u01ec\u01f1\5\u008aF\2\u01ed\u01f1\5\u0094"+
		"K\2\u01ee\u01f1\5\\/\2\u01ef\u01f1\5\u0090I\2\u01f0\u01ea\3\2\2\2\u01f0"+
		"\u01eb\3\2\2\2\u01f0\u01ec\3\2\2\2\u01f0\u01ed\3\2\2\2\u01f0\u01ee\3\2"+
		"\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u0085\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\7U"+
		"\2\2\u01f6\u0087\3\2\2\2\u01f7\u01f8\t\13\2\2\u01f8\u0089\3\2\2\2\u01f9"+
		"\u01fa\t\f\2\2\u01fa\u008b\3\2\2\2\u01fb\u01fc\7V\2\2\u01fc\u008d\3\2"+
		"\2\2\u01fd\u01fe\7%\2\2\u01fe\u008f\3\2\2\2\u01ff\u0200\7\64\2\2\u0200"+
		"\u0091\3\2\2\2\u0201\u0202\t\r\2\2\u0202\u0093\3\2\2\2\u0203\u0204\t\16"+
		"\2\2\u0204\u0095\3\2\2\2\u0205\u0206\5\u0098M\2\u0206\u0207\5\32\16\2"+
		"\u0207\u0097\3\2\2\2\u0208\u0209\t\17\2\2\u0209\u0099\3\2\2\2\u020a\u020b"+
		"\7]\2\2\u020b\u009b\3\2\2\2\u020c\u020d\t\20\2\2\u020d\u009d\3\2\2\2+"+
		"\u00a4\u00a7\u00b2\u00c1\u00c6\u00cd\u00da\u00de\u00ea\u00ef\u010d\u0117"+
		"\u011a\u012f\u0136\u014a\u0153\u0156\u0167\u016d\u017e\u0181\u0188\u018e"+
		"\u0191\u0197\u019d\u01af\u01b3\u01bf\u01c4\u01c6\u01cb\u01d0\u01d5\u01de"+
		"\u01e2\u01e6\u01e8\u01f0\u01f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}