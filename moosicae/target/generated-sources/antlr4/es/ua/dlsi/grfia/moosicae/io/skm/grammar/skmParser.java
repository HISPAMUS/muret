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
		RULE_keySignaturePitchClass = 23, RULE_keyMode = 24, RULE_key = 25, RULE_minorKey = 26, 
		RULE_majorKey = 27, RULE_fractionalTimeSignature = 28, RULE_numerator = 29, 
		RULE_denominator = 30, RULE_meterSymbol = 31, RULE_modernMeterSymbolSign = 32, 
		RULE_mensuration = 33, RULE_metronome = 34, RULE_nullInterpretation = 35, 
		RULE_barline = 36, RULE_barLineType = 37, RULE_spineOperation = 38, RULE_spineTerminator = 39, 
		RULE_spineAdd = 40, RULE_spineSplit = 41, RULE_spineJoin = 42, RULE_rest = 43, 
		RULE_restLinePosition = 44, RULE_duration = 45, RULE_fermata = 46, RULE_mensuralDuration = 47, 
		RULE_mensuralDot = 48, RULE_modernDuration = 49, RULE_coloured = 50, RULE_mensuralFigure = 51, 
		RULE_mensuralPerfection = 52, RULE_augmentationDot = 53, RULE_separationDot = 54, 
		RULE_custos = 55, RULE_pitch = 56, RULE_alteration = 57, RULE_note = 58, 
		RULE_chord = 59, RULE_beforeNote = 60, RULE_diatonicPitchAndOctave = 61, 
		RULE_trebleNotes = 62, RULE_bassNotes = 63, RULE_accidental = 64, RULE_alterationDisplay = 65, 
		RULE_afterNote = 66, RULE_slurStart = 67, RULE_ligatureStart = 68, RULE_ligatureEnd = 69, 
		RULE_slurEnd = 70, RULE_barLineCrossedNoteStart = 71, RULE_barLineCrossedNoteEnd = 72, 
		RULE_stem = 73, RULE_beam = 74, RULE_staffPosition = 75, RULE_lineSpace = 76, 
		RULE_lyricsText = 77, RULE_plainChant = 78;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "eol", "header", "headerField", "record", "tab", "fields", "field", 
			"associatedIDS", "placeHolder", "graphicalToken", "tandemInterpretation", 
			"number", "lowerCasePitch", "upperCasePitch", "pitchClass", "part", "staff", 
			"clef", "clefValue", "clefSign", "clefLine", "keySignature", "keySignaturePitchClass", 
			"keyMode", "key", "minorKey", "majorKey", "fractionalTimeSignature", 
			"numerator", "denominator", "meterSymbol", "modernMeterSymbolSign", "mensuration", 
			"metronome", "nullInterpretation", "barline", "barLineType", "spineOperation", 
			"spineTerminator", "spineAdd", "spineSplit", "spineJoin", "rest", "restLinePosition", 
			"duration", "fermata", "mensuralDuration", "mensuralDot", "modernDuration", 
			"coloured", "mensuralFigure", "mensuralPerfection", "augmentationDot", 
			"separationDot", "custos", "pitch", "alteration", "note", "chord", "beforeNote", 
			"diatonicPitchAndOctave", "trebleNotes", "bassNotes", "accidental", "alterationDisplay", 
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
			setState(158);
			header();
			setState(162); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(159);
					eol();
					setState(160);
					record();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(164); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(166);
				eol();
				}
			}

			setState(169);
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
			setState(171);
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
			setState(173);
			headerField();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB) {
				{
				{
				setState(174);
				match(TAB);
				setState(175);
				headerField();
				}
				}
				setState(180);
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
			setState(181);
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
			setState(183);
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
			setState(185);
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
			setState(187);
			field();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAB || _la==FREE_TEXT_TAB) {
				{
				{
				setState(188);
				tab();
				setState(189);
				field();
				}
				}
				setState(195);
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
			setState(198);
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
				setState(196);
				graphicalToken();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
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
			setState(200);
			number();
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					match(COMMA);
					setState(202);
					associatedIDS();
					}
					} 
				}
				setState(207);
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
			setState(208);
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
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(210);
				tandemInterpretation();
				}
				break;
			case 2:
				{
				setState(211);
				part();
				}
				break;
			case 3:
				{
				setState(212);
				barline();
				}
				break;
			case 4:
				{
				setState(213);
				rest();
				}
				break;
			case 5:
				{
				setState(214);
				note();
				}
				break;
			case 6:
				{
				setState(215);
				chord();
				}
				break;
			case 7:
				{
				setState(216);
				spineOperation();
				}
				break;
			case 8:
				{
				setState(217);
				lyricsText();
				}
				break;
			}
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(220);
				match(AT);
				setState(221);
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
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				staff();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				clef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				keySignature();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				fractionalTimeSignature();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				meterSymbol();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(229);
				key();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(230);
				metronome();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(231);
				nullInterpretation();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(232);
				custos();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(233);
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
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236);
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
				setState(239); 
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
			setState(241);
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
			setState(243);
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
			setState(245);
			lowerCasePitch();
			setState(246);
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
			setState(248);
			match(TANDEM_PART);
			setState(249);
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
			setState(251);
			match(TANDEM_STAFF);
			setState(252);
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
			setState(254);
			match(TANDEM_CLEF);
			setState(255);
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
			setState(257);
			clefSign();
			setState(258);
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
			setState(260);
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
			setState(262);
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
			setState(264);
			match(TANDEM_KEY);
			setState(265);
			match(LEFT_BRACKET);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_a) | (1L << CHAR_b) | (1L << CHAR_c) | (1L << CHAR_d) | (1L << CHAR_e) | (1L << CHAR_f) | (1L << CHAR_g))) != 0)) {
				{
				{
				setState(266);
				keySignaturePitchClass();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
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
			setState(274);
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

	public static class KeyModeContext extends ParserRuleContext {
		public MinorKeyContext minorKey() {
			return getRuleContext(MinorKeyContext.class,0);
		}
		public MajorKeyContext majorKey() {
			return getRuleContext(MajorKeyContext.class,0);
		}
		public KeyModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterKeyMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitKeyMode(this);
		}
	}

	public final KeyModeContext keyMode() throws RecognitionException {
		KeyModeContext _localctx = new KeyModeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keyMode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
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
				setState(276);
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
				setState(277);
				majorKey();
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

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(skmParser.ASTERISK, 0); }
		public KeyModeContext keyMode() {
			return getRuleContext(KeyModeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(skmParser.COLON, 0); }
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
		enterRule(_localctx, 50, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(ASTERISK);
			setState(281);
			keyMode();
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
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
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
		enterRule(_localctx, 52, RULE_minorKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			lowerCasePitch();
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (CHAR_n - 46)) | (1L << (OCTOTHORPE - 46)) | (1L << (MINUS - 46)))) != 0)) {
				{
				setState(285);
				accidental();
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

	public static class MajorKeyContext extends ParserRuleContext {
		public UpperCasePitchContext upperCasePitch() {
			return getRuleContext(UpperCasePitchContext.class,0);
		}
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
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
		enterRule(_localctx, 54, RULE_majorKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			upperCasePitch();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (CHAR_n - 46)) | (1L << (OCTOTHORPE - 46)) | (1L << (MINUS - 46)))) != 0)) {
				{
				setState(289);
				accidental();
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
		enterRule(_localctx, 56, RULE_fractionalTimeSignature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(TANDEM_TIMESIGNATURE);
			setState(293);
			numerator();
			setState(294);
			match(SLASH);
			setState(295);
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
		enterRule(_localctx, 58, RULE_numerator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
		enterRule(_localctx, 60, RULE_denominator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
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
		enterRule(_localctx, 62, RULE_meterSymbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(TANDEM_MET);
			setState(302);
			match(LEFT_PARENTHESIS);
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_c:
				{
				setState(303);
				modernMeterSymbolSign();
				}
				break;
			case CHAR_C:
			case CHAR_O:
			case DIGIT_3:
				{
				setState(304);
				mensuration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(307);
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
		enterRule(_localctx, 64, RULE_modernMeterSymbolSign);
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(CHAR_c);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				match(CHAR_c);
				setState(311);
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
		enterRule(_localctx, 66, RULE_mensuration);
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(CHAR_C);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(CHAR_C);
				setState(316);
				match(PIPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				match(CHAR_C);
				setState(318);
				match(DOT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				match(CHAR_O);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(320);
				match(CHAR_O);
				setState(321);
				match(DOT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(322);
				match(CHAR_C);
				setState(323);
				match(DIGIT_3);
				setState(324);
				match(SLASH);
				setState(325);
				match(DIGIT_2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(326);
				match(CHAR_C);
				setState(327);
				match(PIPE);
				setState(328);
				match(DIGIT_3);
				setState(329);
				match(SLASH);
				setState(330);
				match(DIGIT_2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(331);
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
		enterRule(_localctx, 68, RULE_metronome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(METRONOME);
			setState(335);
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
		enterRule(_localctx, 70, RULE_nullInterpretation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
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
		enterRule(_localctx, 72, RULE_barline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(EQUAL);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & ((1L << (DIGIT_0 - 55)) | (1L << (DIGIT_1 - 55)) | (1L << (DIGIT_2 - 55)) | (1L << (DIGIT_3 - 55)) | (1L << (DIGIT_4 - 55)) | (1L << (DIGIT_5 - 55)) | (1L << (DIGIT_6 - 55)) | (1L << (DIGIT_7 - 55)) | (1L << (DIGIT_8 - 55)) | (1L << (DIGIT_9 - 55)))) != 0)) {
				{
				setState(340);
				number();
				}
			}

			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (MINUS - 70)) | (1L << (EQUAL - 70)) | (1L << (PIPE - 70)) | (1L << (COLON - 70)))) != 0)) {
				{
				setState(343);
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
		enterRule(_localctx, 74, RULE_barLineType);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				match(MINUS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(PIPE);
				setState(348);
				match(PIPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				match(EQUAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				match(EXCLAMATION);
				setState(351);
				match(PIPE);
				setState(352);
				match(COLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(353);
				match(COLON);
				setState(354);
				match(PIPE);
				setState(355);
				match(EXCLAMATION);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(356);
				match(COLON);
				setState(357);
				match(PIPE);
				setState(358);
				match(EXCLAMATION);
				setState(359);
				match(PIPE);
				setState(360);
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
		enterRule(_localctx, 76, RULE_spineOperation);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				spineTerminator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				spineAdd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				spineSplit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
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
		enterRule(_localctx, 78, RULE_spineTerminator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(ASTERISK);
			setState(370);
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
		enterRule(_localctx, 80, RULE_spineAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(ASTERISK);
			setState(373);
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
		enterRule(_localctx, 82, RULE_spineSplit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(ASTERISK);
			setState(376);
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
		enterRule(_localctx, 84, RULE_spineJoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(ASTERISK);
			setState(379);
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
		enterRule(_localctx, 86, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			duration();
			{
			setState(382);
			match(CHAR_r);
			}
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(383);
				fermata();
				}
			}

			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDERSCORE) {
				{
				setState(386);
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
		enterRule(_localctx, 88, RULE_restLinePosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(UNDERSCORE);
			setState(390);
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
		enterRule(_localctx, 90, RULE_duration);
		try {
			setState(394);
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
				setState(392);
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
				setState(393);
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
		enterRule(_localctx, 92, RULE_fermata);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
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
		enterRule(_localctx, 94, RULE_mensuralDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			mensuralFigure();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TILDE) {
				{
				setState(399);
				coloured();
				}
			}

			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_I) | (1L << CHAR_i) | (1L << CHAR_p))) != 0)) {
				{
				setState(402);
				mensuralPerfection();
				}
			}

			setState(405);
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
		enterRule(_localctx, 96, RULE_mensuralDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(407);
				augmentationDot();
				}
				break;
			case COLON:
				{
				setState(408);
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
		enterRule(_localctx, 98, RULE_modernDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			number();
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(412);
				augmentationDot();
				}
				}
				setState(417);
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
		enterRule(_localctx, 100, RULE_coloured);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
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
		enterRule(_localctx, 102, RULE_mensuralFigure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
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
		enterRule(_localctx, 104, RULE_mensuralPerfection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
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
		enterRule(_localctx, 106, RULE_augmentationDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
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
		enterRule(_localctx, 108, RULE_separationDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
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
		enterRule(_localctx, 110, RULE_custos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(TANDEM_CUSTOS);
			setState(429);
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
		public DiatonicPitchAndOctaveContext diatonicPitchAndOctave() {
			return getRuleContext(DiatonicPitchAndOctaveContext.class,0);
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
		enterRule(_localctx, 112, RULE_pitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			diatonicPitchAndOctave();
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (CHAR_n - 46)) | (1L << (OCTOTHORPE - 46)) | (1L << (MINUS - 46)))) != 0)) {
				{
				setState(432);
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
		enterRule(_localctx, 114, RULE_alteration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			accidental();
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CHAR_Y || _la==CHAR_y) {
				{
				setState(436);
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
		enterRule(_localctx, 116, RULE_note);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			beforeNote();
			setState(440);
			duration();
			setState(441);
			pitch();
			setState(442);
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
		enterRule(_localctx, 118, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			note();
			setState(447); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(445);
				match(SPACE);
				setState(446);
				note();
				}
				}
				setState(449); 
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
		enterRule(_localctx, 120, RULE_beforeNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (CHAR_T - 35)) | (1L << (LEFT_BRACKET - 35)) | (1L << (ANGLE_BRACKET_OPEN - 35)) | (1L << (LEFT_PARENTHESIS - 35)))) != 0)) {
				{
				setState(454);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_PARENTHESIS:
					{
					setState(451);
					slurStart();
					}
					break;
				case LEFT_BRACKET:
				case ANGLE_BRACKET_OPEN:
					{
					setState(452);
					ligatureStart();
					}
					break;
				case CHAR_T:
					{
					setState(453);
					barLineCrossedNoteStart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(458);
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

	public static class DiatonicPitchAndOctaveContext extends ParserRuleContext {
		public BassNotesContext bassNotes() {
			return getRuleContext(BassNotesContext.class,0);
		}
		public TrebleNotesContext trebleNotes() {
			return getRuleContext(TrebleNotesContext.class,0);
		}
		public DiatonicPitchAndOctaveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diatonicPitchAndOctave; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).enterDiatonicPitchAndOctave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skmParserListener ) ((skmParserListener)listener).exitDiatonicPitchAndOctave(this);
		}
	}

	public final DiatonicPitchAndOctaveContext diatonicPitchAndOctave() throws RecognitionException {
		DiatonicPitchAndOctaveContext _localctx = new DiatonicPitchAndOctaveContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_diatonicPitchAndOctave);
		try {
			setState(461);
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
				setState(459);
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
				setState(460);
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
		enterRule(_localctx, 124, RULE_trebleNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(463);
				lowerCasePitch();
				}
				}
				setState(466); 
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
		enterRule(_localctx, 126, RULE_bassNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(468);
				upperCasePitch();
				}
				}
				setState(471); 
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
		enterRule(_localctx, 128, RULE_accidental);
		try {
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				match(OCTOTHORPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(474);
				match(OCTOTHORPE);
				setState(475);
				match(OCTOTHORPE);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(476);
				match(MINUS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(477);
				match(MINUS);
				setState(478);
				match(MINUS);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(479);
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
		enterRule(_localctx, 130, RULE_alterationDisplay);
		int _la;
		try {
			setState(490);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR_y:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(482);
				match(CHAR_y);
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_y) {
					{
					setState(483);
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
				setState(486);
				match(CHAR_Y);
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHAR_Y) {
					{
					setState(487);
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
		enterRule(_localctx, 132, RULE_afterNote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (CHAR_J - 25)) | (1L << (CHAR_L - 25)) | (1L << (CHAR_t - 25)) | (1L << (RIGHT_BRACKET - 25)) | (1L << (ANGLE_BRACKET_CLOSE - 25)) | (1L << (SLASH - 25)) | (1L << (BACKSLASH - 25)) | (1L << (RIGHT_PARENTHESIS - 25)) | (1L << (SEMICOLON - 25)))) != 0)) {
				{
				setState(498);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RIGHT_PARENTHESIS:
					{
					setState(492);
					slurEnd();
					}
					break;
				case SLASH:
				case BACKSLASH:
					{
					setState(493);
					stem();
					}
					break;
				case RIGHT_BRACKET:
				case ANGLE_BRACKET_CLOSE:
					{
					setState(494);
					ligatureEnd();
					}
					break;
				case CHAR_J:
				case CHAR_L:
					{
					setState(495);
					beam();
					}
					break;
				case SEMICOLON:
					{
					setState(496);
					fermata();
					}
					break;
				case CHAR_t:
					{
					setState(497);
					barLineCrossedNoteEnd();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(502);
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
		enterRule(_localctx, 134, RULE_slurStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
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
		enterRule(_localctx, 136, RULE_ligatureStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
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
		enterRule(_localctx, 138, RULE_ligatureEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
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
		enterRule(_localctx, 140, RULE_slurEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
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
		enterRule(_localctx, 142, RULE_barLineCrossedNoteStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
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
		enterRule(_localctx, 144, RULE_barLineCrossedNoteEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
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
		enterRule(_localctx, 146, RULE_stem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
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
		enterRule(_localctx, 148, RULE_beam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
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
		enterRule(_localctx, 150, RULE_staffPosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			lineSpace();
			setState(520);
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
		enterRule(_localctx, 152, RULE_lineSpace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
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
		enterRule(_localctx, 154, RULE_lyricsText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
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
		enterRule(_localctx, 156, RULE_plainChant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3_\u0213\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3\2\3\2\3\2\3\2\6\2\u00a5"+
		"\n\2\r\2\16\2\u00a6\3\2\5\2\u00aa\n\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4"+
		"\u00b3\n\4\f\4\16\4\u00b6\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\7\b\u00c2\n\b\f\b\16\b\u00c5\13\b\3\t\3\t\5\t\u00c9\n\t\3\n\3\n\3\n\7"+
		"\n\u00ce\n\n\f\n\16\n\u00d1\13\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00dd\n\f\3\f\3\f\5\f\u00e1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00ed\n\r\3\16\6\16\u00f0\n\16\r\16\16\16\u00f1\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\7\30\u010e\n\30"+
		"\f\30\16\30\u0111\13\30\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u0119\n\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\5\34\u0121\n\34\3\35\3\35\5\35\u0125\n"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u0134\n!\3"+
		"!\3!\3\"\3\"\3\"\5\"\u013b\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\5#\u014f\n#\3$\3$\3$\3%\3%\3&\3&\5&\u0158\n&\3&\5&\u015b"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u016c"+
		"\n\'\3(\3(\3(\3(\5(\u0172\n(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3"+
		"-\3-\5-\u0183\n-\3-\5-\u0186\n-\3.\3.\3.\3/\3/\5/\u018d\n/\3\60\3\60\3"+
		"\61\3\61\5\61\u0193\n\61\3\61\5\61\u0196\n\61\3\61\3\61\3\62\3\62\5\62"+
		"\u019c\n\62\3\63\3\63\7\63\u01a0\n\63\f\63\16\63\u01a3\13\63\3\64\3\64"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\5:\u01b4\n:\3;\3;"+
		"\5;\u01b8\n;\3<\3<\3<\3<\3<\3=\3=\3=\6=\u01c2\n=\r=\16=\u01c3\3>\3>\3"+
		">\7>\u01c9\n>\f>\16>\u01cc\13>\3?\3?\5?\u01d0\n?\3@\6@\u01d3\n@\r@\16"+
		"@\u01d4\3A\6A\u01d8\nA\rA\16A\u01d9\3B\3B\3B\3B\3B\3B\3B\5B\u01e3\nB\3"+
		"C\3C\5C\u01e7\nC\3C\3C\5C\u01eb\nC\5C\u01ed\nC\3D\3D\3D\3D\3D\3D\7D\u01f5"+
		"\nD\fD\16D\u01f8\13D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3"+
		"M\3M\3M\3N\3N\3O\3O\3P\3P\3P\2\2Q\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\2\21\3\2\4\6\4\2[[^^\3\29B\3\2\'-\3\2\23\31\4\2\25\25\30"+
		"\31\3\2:>\b\2\34\35\"#&&//\63\63\65\65\5\2\32\32..\61\61\4\2DDPP\4\2E"+
		"EQQ\3\2RS\3\2\33\34\4\2\34\34\"\"\3\2\20\21\2\u0210\2\u00a0\3\2\2\2\4"+
		"\u00ad\3\2\2\2\6\u00af\3\2\2\2\b\u00b7\3\2\2\2\n\u00b9\3\2\2\2\f\u00bb"+
		"\3\2\2\2\16\u00bd\3\2\2\2\20\u00c8\3\2\2\2\22\u00ca\3\2\2\2\24\u00d2\3"+
		"\2\2\2\26\u00dc\3\2\2\2\30\u00ec\3\2\2\2\32\u00ef\3\2\2\2\34\u00f3\3\2"+
		"\2\2\36\u00f5\3\2\2\2 \u00f7\3\2\2\2\"\u00fa\3\2\2\2$\u00fd\3\2\2\2&\u0100"+
		"\3\2\2\2(\u0103\3\2\2\2*\u0106\3\2\2\2,\u0108\3\2\2\2.\u010a\3\2\2\2\60"+
		"\u0114\3\2\2\2\62\u0118\3\2\2\2\64\u011a\3\2\2\2\66\u011e\3\2\2\28\u0122"+
		"\3\2\2\2:\u0126\3\2\2\2<\u012b\3\2\2\2>\u012d\3\2\2\2@\u012f\3\2\2\2B"+
		"\u013a\3\2\2\2D\u014e\3\2\2\2F\u0150\3\2\2\2H\u0153\3\2\2\2J\u0155\3\2"+
		"\2\2L\u016b\3\2\2\2N\u0171\3\2\2\2P\u0173\3\2\2\2R\u0176\3\2\2\2T\u0179"+
		"\3\2\2\2V\u017c\3\2\2\2X\u017f\3\2\2\2Z\u0187\3\2\2\2\\\u018c\3\2\2\2"+
		"^\u018e\3\2\2\2`\u0190\3\2\2\2b\u019b\3\2\2\2d\u019d\3\2\2\2f\u01a4\3"+
		"\2\2\2h\u01a6\3\2\2\2j\u01a8\3\2\2\2l\u01aa\3\2\2\2n\u01ac\3\2\2\2p\u01ae"+
		"\3\2\2\2r\u01b1\3\2\2\2t\u01b5\3\2\2\2v\u01b9\3\2\2\2x\u01be\3\2\2\2z"+
		"\u01ca\3\2\2\2|\u01cf\3\2\2\2~\u01d2\3\2\2\2\u0080\u01d7\3\2\2\2\u0082"+
		"\u01e2\3\2\2\2\u0084\u01ec\3\2\2\2\u0086\u01f6\3\2\2\2\u0088\u01f9\3\2"+
		"\2\2\u008a\u01fb\3\2\2\2\u008c\u01fd\3\2\2\2\u008e\u01ff\3\2\2\2\u0090"+
		"\u0201\3\2\2\2\u0092\u0203\3\2\2\2\u0094\u0205\3\2\2\2\u0096\u0207\3\2"+
		"\2\2\u0098\u0209\3\2\2\2\u009a\u020c\3\2\2\2\u009c\u020e\3\2\2\2\u009e"+
		"\u0210\3\2\2\2\u00a0\u00a4\5\6\4\2\u00a1\u00a2\5\4\3\2\u00a2\u00a3\5\n"+
		"\6\2\u00a3\u00a5\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00aa\5\4"+
		"\3\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\7\2\2\3\u00ac\3\3\2\2\2\u00ad\u00ae\7\\\2\2\u00ae\5\3\2\2\2\u00af"+
		"\u00b4\5\b\5\2\u00b0\u00b1\7[\2\2\u00b1\u00b3\5\b\5\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\t\2\2\2\u00b8\t\3\2\2\2\u00b9"+
		"\u00ba\5\16\b\2\u00ba\13\3\2\2\2\u00bb\u00bc\t\3\2\2\u00bc\r\3\2\2\2\u00bd"+
		"\u00c3\5\20\t\2\u00be\u00bf\5\f\7\2\u00bf\u00c0\5\20\t\2\u00c0\u00c2\3"+
		"\2\2\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\17\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\5\26\f"+
		"\2\u00c7\u00c9\5\24\13\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\21\3\2\2\2\u00ca\u00cf\5\32\16\2\u00cb\u00cc\7Y\2\2\u00cc\u00ce\5\22"+
		"\n\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\23\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7J\2\2"+
		"\u00d3\25\3\2\2\2\u00d4\u00dd\5\30\r\2\u00d5\u00dd\5\"\22\2\u00d6\u00dd"+
		"\5J&\2\u00d7\u00dd\5X-\2\u00d8\u00dd\5v<\2\u00d9\u00dd\5x=\2\u00da\u00dd"+
		"\5N(\2\u00db\u00dd\5\u009cO\2\u00dc\u00d4\3\2\2\2\u00dc\u00d5\3\2\2\2"+
		"\u00dc\u00d6\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00df\7\22\2\2\u00df\u00e1\5\22\n\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\27\3\2\2\2\u00e2\u00ed\5$\23\2\u00e3\u00ed\5&\24\2\u00e4"+
		"\u00ed\5.\30\2\u00e5\u00ed\5:\36\2\u00e6\u00ed\5@!\2\u00e7\u00ed\5\64"+
		"\33\2\u00e8\u00ed\5F$\2\u00e9\u00ed\5H%\2\u00ea\u00ed\5p9\2\u00eb\u00ed"+
		"\5\u009eP\2\u00ec\u00e2\3\2\2\2\u00ec\u00e3\3\2\2\2\u00ec\u00e4\3\2\2"+
		"\2\u00ec\u00e5\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec\u00e8"+
		"\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\31\3\2\2\2\u00ee\u00f0\t\4\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2"+
		"\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\33\3\2\2\2\u00f3\u00f4"+
		"\t\5\2\2\u00f4\35\3\2\2\2\u00f5\u00f6\t\6\2\2\u00f6\37\3\2\2\2\u00f7\u00f8"+
		"\5\34\17\2\u00f8\u00f9\5\u0082B\2\u00f9!\3\2\2\2\u00fa\u00fb\7\7\2\2\u00fb"+
		"\u00fc\5\32\16\2\u00fc#\3\2\2\2\u00fd\u00fe\7\t\2\2\u00fe\u00ff\5\32\16"+
		"\2\u00ff%\3\2\2\2\u0100\u0101\7\n\2\2\u0101\u0102\5(\25\2\u0102\'\3\2"+
		"\2\2\u0103\u0104\5*\26\2\u0104\u0105\5,\27\2\u0105)\3\2\2\2\u0106\u0107"+
		"\t\7\2\2\u0107+\3\2\2\2\u0108\u0109\t\b\2\2\u0109-\3\2\2\2\u010a\u010b"+
		"\7\f\2\2\u010b\u010f\7D\2\2\u010c\u010e\5\60\31\2\u010d\u010c\3\2\2\2"+
		"\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112"+
		"\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7E\2\2\u0113/\3\2\2\2\u0114\u0115"+
		"\5 \21\2\u0115\61\3\2\2\2\u0116\u0119\5\66\34\2\u0117\u0119\58\35\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119\63\3\2\2\2\u011a\u011b\7C\2\2"+
		"\u011b\u011c\5\62\32\2\u011c\u011d\7W\2\2\u011d\65\3\2\2\2\u011e\u0120"+
		"\5\34\17\2\u011f\u0121\5\u0082B\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\67\3\2\2\2\u0122\u0124\5\36\20\2\u0123\u0125\5\u0082B\2\u0124"+
		"\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u01259\3\2\2\2\u0126\u0127\7\17\2\2"+
		"\u0127\u0128\5<\37\2\u0128\u0129\7R\2\2\u0129\u012a\5> \2\u012a;\3\2\2"+
		"\2\u012b\u012c\5\32\16\2\u012c=\3\2\2\2\u012d\u012e\5\32\16\2\u012e?\3"+
		"\2\2\2\u012f\u0130\7\r\2\2\u0130\u0133\7U\2\2\u0131\u0134\5B\"\2\u0132"+
		"\u0134\5D#\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2"+
		"\2\u0135\u0136\7V\2\2\u0136A\3\2\2\2\u0137\u013b\7)\2\2\u0138\u0139\7"+
		")\2\2\u0139\u013b\7K\2\2\u013a\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"C\3\2\2\2\u013c\u014f\7\25\2\2\u013d\u013e\7\25\2\2\u013e\u014f\7K\2\2"+
		"\u013f\u0140\7\25\2\2\u0140\u014f\7J\2\2\u0141\u014f\7\36\2\2\u0142\u0143"+
		"\7\36\2\2\u0143\u014f\7J\2\2\u0144\u0145\7\25\2\2\u0145\u0146\7<\2\2\u0146"+
		"\u0147\7R\2\2\u0147\u014f\7;\2\2\u0148\u0149\7\25\2\2\u0149\u014a\7K\2"+
		"\2\u014a\u014b\7<\2\2\u014b\u014c\7R\2\2\u014c\u014f\7;\2\2\u014d\u014f"+
		"\7<\2\2\u014e\u013c\3\2\2\2\u014e\u013d\3\2\2\2\u014e\u013f\3\2\2\2\u014e"+
		"\u0141\3\2\2\2\u014e\u0142\3\2\2\2\u014e\u0144\3\2\2\2\u014e\u0148\3\2"+
		"\2\2\u014e\u014d\3\2\2\2\u014fE\3\2\2\2\u0150\u0151\7\16\2\2\u0151\u0152"+
		"\5\32\16\2\u0152G\3\2\2\2\u0153\u0154\7C\2\2\u0154I\3\2\2\2\u0155\u0157"+
		"\7I\2\2\u0156\u0158\5\32\16\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2"+
		"\u0158\u015a\3\2\2\2\u0159\u015b\5L\'\2\u015a\u0159\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015bK\3\2\2\2\u015c\u016c\7H\2\2\u015d\u015e\7K\2\2\u015e\u016c"+
		"\7K\2\2\u015f\u016c\7I\2\2\u0160\u0161\7\3\2\2\u0161\u0162\7K\2\2\u0162"+
		"\u016c\7W\2\2\u0163\u0164\7W\2\2\u0164\u0165\7K\2\2\u0165\u016c\7\3\2"+
		"\2\u0166\u0167\7W\2\2\u0167\u0168\7K\2\2\u0168\u0169\7\3\2\2\u0169\u016a"+
		"\7K\2\2\u016a\u016c\7W\2\2\u016b\u015c\3\2\2\2\u016b\u015d\3\2\2\2\u016b"+
		"\u015f\3\2\2\2\u016b\u0160\3\2\2\2\u016b\u0163\3\2\2\2\u016b\u0166\3\2"+
		"\2\2\u016cM\3\2\2\2\u016d\u0172\5P)\2\u016e\u0172\5R*\2\u016f\u0172\5"+
		"T+\2\u0170\u0172\5V,\2\u0171\u016d\3\2\2\2\u0171\u016e\3\2\2\2\u0171\u016f"+
		"\3\2\2\2\u0171\u0170\3\2\2\2\u0172O\3\2\2\2\u0173\u0174\7C\2\2\u0174\u0175"+
		"\7H\2\2\u0175Q\3\2\2\2\u0176\u0177\7C\2\2\u0177\u0178\7G\2\2\u0178S\3"+
		"\2\2\2\u0179\u017a\7C\2\2\u017a\u017b\7N\2\2\u017bU\3\2\2\2\u017c\u017d"+
		"\7C\2\2\u017d\u017e\7\66\2\2\u017eW\3\2\2\2\u017f\u0180\5\\/\2\u0180\u0182"+
		"\7\62\2\2\u0181\u0183\5^\60\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2"+
		"\u0183\u0185\3\2\2\2\u0184\u0186\5Z.\2\u0185\u0184\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186Y\3\2\2\2\u0187\u0188\7T\2\2\u0188\u0189\5,\27\2\u0189["+
		"\3\2\2\2\u018a\u018d\5`\61\2\u018b\u018d\5d\63\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018b\3\2\2\2\u018d]\3\2\2\2\u018e\u018f\7X\2\2\u018f_\3\2\2\2\u0190"+
		"\u0192\5h\65\2\u0191\u0193\5f\64\2\u0192\u0191\3\2\2\2\u0192\u0193\3\2"+
		"\2\2\u0193\u0195\3\2\2\2\u0194\u0196\5j\66\2\u0195\u0194\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\5b\62\2\u0198a\3\2\2\2"+
		"\u0199\u019c\5l\67\2\u019a\u019c\5n8\2\u019b\u0199\3\2\2\2\u019b\u019a"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019cc\3\2\2\2\u019d\u01a1\5\32\16\2\u019e"+
		"\u01a0\5l\67\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2e\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a5"+
		"\7O\2\2\u01a5g\3\2\2\2\u01a6\u01a7\t\t\2\2\u01a7i\3\2\2\2\u01a8\u01a9"+
		"\t\n\2\2\u01a9k\3\2\2\2\u01aa\u01ab\7J\2\2\u01abm\3\2\2\2\u01ac\u01ad"+
		"\7W\2\2\u01ado\3\2\2\2\u01ae\u01af\7\13\2\2\u01af\u01b0\5r:\2\u01b0q\3"+
		"\2\2\2\u01b1\u01b3\5|?\2\u01b2\u01b4\5t;\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4"+
		"\3\2\2\2\u01b4s\3\2\2\2\u01b5\u01b7\5\u0082B\2\u01b6\u01b8\5\u0084C\2"+
		"\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8u\3\2\2\2\u01b9\u01ba\5"+
		"z>\2\u01ba\u01bb\5\\/\2\u01bb\u01bc\5r:\2\u01bc\u01bd\5\u0086D\2\u01bd"+
		"w\3\2\2\2\u01be\u01c1\5v<\2\u01bf\u01c0\7Z\2\2\u01c0\u01c2\5v<\2\u01c1"+
		"\u01bf\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2"+
		"\2\2\u01c4y\3\2\2\2\u01c5\u01c9\5\u0088E\2\u01c6\u01c9\5\u008aF\2\u01c7"+
		"\u01c9\5\u0090I\2\u01c8\u01c5\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c7"+
		"\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"{\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\5\u0080A\2\u01ce\u01d0\5~@\2"+
		"\u01cf\u01cd\3\2\2\2\u01cf\u01ce\3\2\2\2\u01d0}\3\2\2\2\u01d1\u01d3\5"+
		"\34\17\2\u01d2\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\177\3\2\2\2\u01d6\u01d8\5\36\20\2\u01d7\u01d6\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u0081\3\2\2\2\u01db\u01e3\7F\2\2\u01dc\u01dd\7F\2\2\u01dd\u01e3\7F\2"+
		"\2\u01de\u01e3\7H\2\2\u01df\u01e0\7H\2\2\u01e0\u01e3\7H\2\2\u01e1\u01e3"+
		"\7\60\2\2\u01e2\u01db\3\2\2\2\u01e2\u01dc\3\2\2\2\u01e2\u01de\3\2\2\2"+
		"\u01e2\u01df\3\2\2\2\u01e2\u01e1\3\2\2\2\u01e3\u0083\3\2\2\2\u01e4\u01e6"+
		"\78\2\2\u01e5\u01e7\78\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u01ed\3\2\2\2\u01e8\u01ea\7$\2\2\u01e9\u01eb\7$\2\2\u01ea\u01e9\3\2\2"+
		"\2\u01ea\u01eb\3\2\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01e4\3\2\2\2\u01ec\u01e8"+
		"\3\2\2\2\u01ed\u0085\3\2\2\2\u01ee\u01f5\5\u008eH\2\u01ef\u01f5\5\u0094"+
		"K\2\u01f0\u01f5\5\u008cG\2\u01f1\u01f5\5\u0096L\2\u01f2\u01f5\5^\60\2"+
		"\u01f3\u01f5\5\u0092J\2\u01f4\u01ee\3\2\2\2\u01f4\u01ef\3\2\2\2\u01f4"+
		"\u01f0\3\2\2\2\u01f4\u01f1\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f3\3\2"+
		"\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u0087\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fa\7U\2\2\u01fa\u0089\3\2"+
		"\2\2\u01fb\u01fc\t\13\2\2\u01fc\u008b\3\2\2\2\u01fd\u01fe\t\f\2\2\u01fe"+
		"\u008d\3\2\2\2\u01ff\u0200\7V\2\2\u0200\u008f\3\2\2\2\u0201\u0202\7%\2"+
		"\2\u0202\u0091\3\2\2\2\u0203\u0204\7\64\2\2\u0204\u0093\3\2\2\2\u0205"+
		"\u0206\t\r\2\2\u0206\u0095\3\2\2\2\u0207\u0208\t\16\2\2\u0208\u0097\3"+
		"\2\2\2\u0209\u020a\5\u009aN\2\u020a\u020b\5\32\16\2\u020b\u0099\3\2\2"+
		"\2\u020c\u020d\t\17\2\2\u020d\u009b\3\2\2\2\u020e\u020f\7]\2\2\u020f\u009d"+
		"\3\2\2\2\u0210\u0211\t\20\2\2\u0211\u009f\3\2\2\2,\u00a6\u00a9\u00b4\u00c3"+
		"\u00c8\u00cf\u00dc\u00e0\u00ec\u00f1\u010f\u0118\u0120\u0124\u0133\u013a"+
		"\u014e\u0157\u015a\u016b\u0171\u0182\u0185\u018c\u0192\u0195\u019b\u01a1"+
		"\u01b3\u01b7\u01c3\u01c8\u01ca\u01cf\u01d4\u01d9\u01e2\u01e6\u01ea\u01ec"+
		"\u01f4\u01f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}