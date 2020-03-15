// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/moosicae/src/main/antlr4/es/ua/dlsi/grfia/moosicae/io/skm/grammar/skmLexer.g4 by ANTLR 4.8

import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class skmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EXCLAMATION=1, SMENS=2, SKERN=3, TEXT=4, TANDEM_PART=5, TANDEM_INSTRUMENT=6, 
		TANDEM_STAFF=7, TANDEM_CLEF=8, TANDEM_CUSTOS=9, TANDEM_KEY=10, TANDEM_MET=11, 
		METRONOME=12, TANDEM_TIMESIGNATURE=13, TANDEM_BEGIN_PLAIN_CHANT=14, TANDEM_END_PLAIN_CHANT=15, 
		AT=16, CHAR_A=17, CHAR_B=18, CHAR_c=19, CHAR_C=20, CHAR_D=21, CHAR_E=22, 
		CHAR_F=23, CHAR_G=24, CHAR_I=25, CHAR_J=26, CHAR_L=27, CHAR_M=28, CHAR_O=29, 
		CHAR_P=30, CHAR_Q=31, CHAR_R=32, CHAR_S=33, CHAR_X=34, CHAR_Y=35, CHAR_T=36, 
		CHAR_U=37, CHAR_i=38, CHAR_m=39, CHAR_n=40, CHAR_p=41, CHAR_r=42, CHAR_s=43, 
		CHAR_t=44, CHAR_u=45, CHAR_v=46, CHAR_x=47, CHAR_y=48, LOWERCASE_PITCH_CHARACTER=49, 
		DIGIT_0=50, DIGIT_1=51, DIGIT_2=52, DIGIT_3=53, DIGIT_4=54, DIGIT_5=55, 
		DIGIT_6=56, DIGIT_7=57, DIGIT_8=58, DIGIT_9=59, ASTERISK=60, LEFT_BRACKET=61, 
		RIGHT_BRACKET=62, OCTOTHORPE=63, PLUS=64, MINUS=65, EQUAL=66, DOT=67, 
		PIPE=68, GRAVE_ACCENT=69, APOSTROPHE=70, CIRCUMFLEX=71, TILDE=72, ANGLE_BRACKET_OPEN=73, 
		ANGLE_BRACKET_CLOSE=74, SLASH=75, BACKSLASH=76, UNDERSCORE=77, LEFT_PARENTHESIS=78, 
		RIGHT_PARENTHESIS=79, COLON=80, SEMICOLON=81, COMMA=82, SPACE=83, TAB=84, 
		EOL=85, FIELD_TEXT=86, FREE_TEXT_TAB=87, FREE_TEXT_EOL=88;
	public static final int
		FREE_TEXT=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "FREE_TEXT"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ASTERISK_FRAGMENT", "EXCLAMATION", "SMENS", "SKERN", "TEXT", "TANDEM_PART", 
			"TANDEM_INSTRUMENT", "TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", 
			"TANDEM_KEY", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", "TANDEM_BEGIN_PLAIN_CHANT", 
			"TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", "CHAR_B", "CHAR_c", "CHAR_C", 
			"CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", "CHAR_J", "CHAR_L", 
			"CHAR_M", "CHAR_O", "CHAR_P", "CHAR_Q", "CHAR_R", "CHAR_S", "CHAR_X", 
			"CHAR_Y", "CHAR_T", "CHAR_U", "CHAR_i", "CHAR_m", "CHAR_n", "CHAR_p", 
			"CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", "CHAR_x", "CHAR_y", 
			"LOWERCASE_PITCH_CHARACTER", "DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", 
			"DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", "PLUS", "MINUS", "EQUAL", 
			"DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", "CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", 
			"ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "COLON", "SEMICOLON", "COMMA", "SPACE", "TAB", "EOL", 
			"FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'@'", "'A'", "'B'", "'c'", "'C'", "'D'", "'E'", 
			"'F'", "'G'", "'I'", "'J'", "'L'", "'M'", "'O'", "'P'", "'Q'", "'R'", 
			"'S'", "'X'", "'Y'", "'T'", "'U'", "'i'", "'m'", "'n'", "'p'", "'r'", 
			"'s'", "'t'", "'u'", "'v'", "'x'", "'y'", null, "'0'", "'1'", "'2'", 
			"'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", null, "'['", "']'", 
			"'#'", "'+'", "'-'", "'='", "'.'", "'|'", "'`'", "'''", "'^'", "'~'", 
			"'<'", "'>'", "'/'", "'\\'", "'_'", "'('", "')'", "':'", "';'", "','", 
			"' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EXCLAMATION", "SMENS", "SKERN", "TEXT", "TANDEM_PART", "TANDEM_INSTRUMENT", 
			"TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", "TANDEM_KEY", "TANDEM_MET", 
			"METRONOME", "TANDEM_TIMESIGNATURE", "TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", 
			"AT", "CHAR_A", "CHAR_B", "CHAR_c", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", 
			"CHAR_G", "CHAR_I", "CHAR_J", "CHAR_L", "CHAR_M", "CHAR_O", "CHAR_P", 
			"CHAR_Q", "CHAR_R", "CHAR_S", "CHAR_X", "CHAR_Y", "CHAR_T", "CHAR_U", 
			"CHAR_i", "CHAR_m", "CHAR_n", "CHAR_p", "CHAR_r", "CHAR_s", "CHAR_t", 
			"CHAR_u", "CHAR_v", "CHAR_x", "CHAR_y", "LOWERCASE_PITCH_CHARACTER", 
			"DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", 
			"DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"OCTOTHORPE", "PLUS", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", 
			"APOSTROPHE", "CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", 
			"SLASH", "BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", 
			"COLON", "SEMICOLON", "COMMA", "SPACE", "TAB", "EOL", "FIELD_TEXT", "FREE_TEXT_TAB", 
			"FREE_TEXT_EOL"
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


	    // record whether each spine is **text
	    private ArrayList<Boolean> textSpines = new ArrayList<>();
	    private int currentSpine;

	    public boolean inTextSpine() {
	        if (currentSpine >= textSpines.size()) {
	            return false;
	        } else {
	            return textSpines.get(currentSpine);
	        }
	    }
	    private void incSpine() {
	        currentSpine++;
	        if (inTextSpine()) {
	            mode(FREE_TEXT);
	        } else {
	            mode(0);
	        }
	    }
	    private void splitSpine() {
	        textSpines.add(currentSpine, inTextSpine());
	    }
	    private void joinSpine() {
	        textSpines.remove(currentSpine);
	    }

	    private void resetMode() {
	        mode(0);
	    }

	    private void resetSpineAndMode() {
	        resetMode();
	        currentSpine=-1; // incSpine increments it
	        incSpine();
	    }
	    public void addMusicSpine() {
	        textSpines.add(false);
	    }
	    public void addTextSpine() {
	        textSpines.add(true);
	    }



	public skmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "skmLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 2:
			SMENS_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			SKERN_action((RuleContext)_localctx, actionIndex);
			break;
		case 4:
			TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		case 84:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 85:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		case 87:
			FREE_TEXT_TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 88:
			FREE_TEXT_EOL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void SMENS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			addMusicSpine();
			break;
		}
	}
	private void SKERN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			addMusicSpine();
			break;
		}
	}
	private void TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			addTextSpine();
			break;
		}
	}
	private void TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			incSpine();
			break;
		}
	}
	private void EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			resetSpineAndMode();
			break;
		}
	}
	private void FREE_TEXT_TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			incSpine();
			break;
		}
	}
	private void FREE_TEXT_EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			resetSpineAndMode();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2Z\u01af\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3"+
		"I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3"+
		"T\3U\3U\3V\3V\3V\3W\5W\u019b\nW\3W\3W\3W\3X\6X\u01a1\nX\rX\16X\u01a2\3"+
		"X\3X\3Y\3Y\3Y\3Z\5Z\u01ab\nZ\3Z\3Z\3Z\2\2[\4\2\6\3\b\4\n\5\f\6\16\7\20"+
		"\b\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25,\26"+
		".\27\60\30\62\31\64\32\66\338\34:\35<\36>\37@ B!D\"F#H$J%L&N\'P(R)T*V"+
		"+X,Z-\\.^/`\60b\61d\62f\63h\64j\65l\66n\67p8r9t:v;x<z=|>~?\u0080@\u0082"+
		"A\u0084B\u0086C\u0088D\u008aE\u008cF\u008eG\u0090H\u0092I\u0094J\u0096"+
		"K\u0098L\u009aM\u009cN\u009eO\u00a0P\u00a2Q\u00a4R\u00a6S\u00a8T\u00aa"+
		"U\u00acV\u00aeW\u00b0X\u00b2Y\u00b4Z\4\2\3\3\4\2\13\f\17\17\2\u01af\2"+
		"\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2"+
		"\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2"+
		"\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2"+
		"\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2"+
		"\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2"+
		"\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L"+
		"\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2"+
		"\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2"+
		"\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2"+
		"r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3"+
		"\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2"+
		"\2\u0088\3\2\2\2\2\u008a\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090"+
		"\3\2\2\2\2\u0092\3\2\2\2\2\u0094\3\2\2\2\2\u0096\3\2\2\2\2\u0098\3\2\2"+
		"\2\2\u009a\3\2\2\2\2\u009c\3\2\2\2\2\u009e\3\2\2\2\2\u00a0\3\2\2\2\2\u00a2"+
		"\3\2\2\2\2\u00a4\3\2\2\2\2\u00a6\3\2\2\2\2\u00a8\3\2\2\2\2\u00aa\3\2\2"+
		"\2\2\u00ac\3\2\2\2\2\u00ae\3\2\2\2\3\u00b0\3\2\2\2\3\u00b2\3\2\2\2\3\u00b4"+
		"\3\2\2\2\4\u00b6\3\2\2\2\6\u00b8\3\2\2\2\b\u00ba\3\2\2\2\n\u00c4\3\2\2"+
		"\2\f\u00ce\3\2\2\2\16\u00d7\3\2\2\2\20\u00dd\3\2\2\2\22\u00e0\3\2\2\2"+
		"\24\u00e7\3\2\2\2\26\u00ed\3\2\2\2\30\u00f5\3\2\2\2\32\u00f8\3\2\2\2\34"+
		"\u00fd\3\2\2\2\36\u0101\3\2\2\2 \u0104\3\2\2\2\"\u0109\3\2\2\2$\u010e"+
		"\3\2\2\2&\u0110\3\2\2\2(\u0112\3\2\2\2*\u0114\3\2\2\2,\u0116\3\2\2\2."+
		"\u0118\3\2\2\2\60\u011a\3\2\2\2\62\u011c\3\2\2\2\64\u011e\3\2\2\2\66\u0120"+
		"\3\2\2\28\u0122\3\2\2\2:\u0124\3\2\2\2<\u0126\3\2\2\2>\u0128\3\2\2\2@"+
		"\u012a\3\2\2\2B\u012c\3\2\2\2D\u012e\3\2\2\2F\u0130\3\2\2\2H\u0132\3\2"+
		"\2\2J\u0134\3\2\2\2L\u0136\3\2\2\2N\u0138\3\2\2\2P\u013a\3\2\2\2R\u013c"+
		"\3\2\2\2T\u013e\3\2\2\2V\u0140\3\2\2\2X\u0142\3\2\2\2Z\u0144\3\2\2\2\\"+
		"\u0146\3\2\2\2^\u0148\3\2\2\2`\u014a\3\2\2\2b\u014c\3\2\2\2d\u014e\3\2"+
		"\2\2f\u0150\3\2\2\2h\u0152\3\2\2\2j\u0154\3\2\2\2l\u0156\3\2\2\2n\u0158"+
		"\3\2\2\2p\u015a\3\2\2\2r\u015c\3\2\2\2t\u015e\3\2\2\2v\u0160\3\2\2\2x"+
		"\u0162\3\2\2\2z\u0164\3\2\2\2|\u0166\3\2\2\2~\u0168\3\2\2\2\u0080\u016a"+
		"\3\2\2\2\u0082\u016c\3\2\2\2\u0084\u016e\3\2\2\2\u0086\u0170\3\2\2\2\u0088"+
		"\u0172\3\2\2\2\u008a\u0174\3\2\2\2\u008c\u0176\3\2\2\2\u008e\u0178\3\2"+
		"\2\2\u0090\u017a\3\2\2\2\u0092\u017c\3\2\2\2\u0094\u017e\3\2\2\2\u0096"+
		"\u0180\3\2\2\2\u0098\u0182\3\2\2\2\u009a\u0184\3\2\2\2\u009c\u0186\3\2"+
		"\2\2\u009e\u0188\3\2\2\2\u00a0\u018a\3\2\2\2\u00a2\u018c\3\2\2\2\u00a4"+
		"\u018e\3\2\2\2\u00a6\u0190\3\2\2\2\u00a8\u0192\3\2\2\2\u00aa\u0194\3\2"+
		"\2\2\u00ac\u0196\3\2\2\2\u00ae\u019a\3\2\2\2\u00b0\u01a0\3\2\2\2\u00b2"+
		"\u01a6\3\2\2\2\u00b4\u01aa\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7\5\3\2\2\2"+
		"\u00b8\u00b9\7#\2\2\u00b9\7\3\2\2\2\u00ba\u00bb\5\4\2\2\u00bb\u00bc\5"+
		"\4\2\2\u00bc\u00bd\7u\2\2\u00bd\u00be\7o\2\2\u00be\u00bf\7g\2\2\u00bf"+
		"\u00c0\7p\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\b\4\2"+
		"\2\u00c3\t\3\2\2\2\u00c4\u00c5\5\4\2\2\u00c5\u00c6\5\4\2\2\u00c6\u00c7"+
		"\7u\2\2\u00c7\u00c8\7m\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7p\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\5\3\2\u00cd\13\3\2\2\2"+
		"\u00ce\u00cf\5\4\2\2\u00cf\u00d0\5\4\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2"+
		"\7g\2\2\u00d2\u00d3\7z\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d6\b\6\4\2\u00d6\r\3\2\2\2\u00d7\u00d8\5\4\2\2\u00d8\u00d9\7r\2\2"+
		"\u00d9\u00da\7c\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7v\2\2\u00dc\17\3\2"+
		"\2\2\u00dd\u00de\5\4\2\2\u00de\u00df\5\66\33\2\u00df\21\3\2\2\2\u00e0"+
		"\u00e1\5\4\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7c\2"+
		"\2\u00e4\u00e5\7h\2\2\u00e5\u00e6\7h\2\2\u00e6\23\3\2\2\2\u00e7\u00e8"+
		"\5\4\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7n\2\2\u00ea\u00eb\7g\2\2\u00eb"+
		"\u00ec\7h\2\2\u00ec\25\3\2\2\2\u00ed\u00ee\5\4\2\2\u00ee\u00ef\7e\2\2"+
		"\u00ef\u00f0\7w\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3"+
		"\7q\2\2\u00f3\u00f4\7u\2\2\u00f4\27\3\2\2\2\u00f5\u00f6\5\4\2\2\u00f6"+
		"\u00f7\7m\2\2\u00f7\31\3\2\2\2\u00f8\u00f9\5\4\2\2\u00f9\u00fa\7o\2\2"+
		"\u00fa\u00fb\7g\2\2\u00fb\u00fc\7v\2\2\u00fc\33\3\2\2\2\u00fd\u00fe\5"+
		"\4\2\2\u00fe\u00ff\7O\2\2\u00ff\u0100\7O\2\2\u0100\35\3\2\2\2\u0101\u0102"+
		"\5\4\2\2\u0102\u0103\7O\2\2\u0103\37\3\2\2\2\u0104\u0105\5\4\2\2\u0105"+
		"\u0106\7d\2\2\u0106\u0107\7r\2\2\u0107\u0108\7e\2\2\u0108!\3\2\2\2\u0109"+
		"\u010a\5\4\2\2\u010a\u010b\7g\2\2\u010b\u010c\7r\2\2\u010c\u010d\7e\2"+
		"\2\u010d#\3\2\2\2\u010e\u010f\7B\2\2\u010f%\3\2\2\2\u0110\u0111\7C\2\2"+
		"\u0111\'\3\2\2\2\u0112\u0113\7D\2\2\u0113)\3\2\2\2\u0114\u0115\7e\2\2"+
		"\u0115+\3\2\2\2\u0116\u0117\7E\2\2\u0117-\3\2\2\2\u0118\u0119\7F\2\2\u0119"+
		"/\3\2\2\2\u011a\u011b\7G\2\2\u011b\61\3\2\2\2\u011c\u011d\7H\2\2\u011d"+
		"\63\3\2\2\2\u011e\u011f\7I\2\2\u011f\65\3\2\2\2\u0120\u0121\7K\2\2\u0121"+
		"\67\3\2\2\2\u0122\u0123\7L\2\2\u01239\3\2\2\2\u0124\u0125\7N\2\2\u0125"+
		";\3\2\2\2\u0126\u0127\7O\2\2\u0127=\3\2\2\2\u0128\u0129\7Q\2\2\u0129?"+
		"\3\2\2\2\u012a\u012b\7R\2\2\u012bA\3\2\2\2\u012c\u012d\7S\2\2\u012dC\3"+
		"\2\2\2\u012e\u012f\7T\2\2\u012fE\3\2\2\2\u0130\u0131\7U\2\2\u0131G\3\2"+
		"\2\2\u0132\u0133\7Z\2\2\u0133I\3\2\2\2\u0134\u0135\7[\2\2\u0135K\3\2\2"+
		"\2\u0136\u0137\7V\2\2\u0137M\3\2\2\2\u0138\u0139\7W\2\2\u0139O\3\2\2\2"+
		"\u013a\u013b\7k\2\2\u013bQ\3\2\2\2\u013c\u013d\7o\2\2\u013dS\3\2\2\2\u013e"+
		"\u013f\7p\2\2\u013fU\3\2\2\2\u0140\u0141\7r\2\2\u0141W\3\2\2\2\u0142\u0143"+
		"\7t\2\2\u0143Y\3\2\2\2\u0144\u0145\7u\2\2\u0145[\3\2\2\2\u0146\u0147\7"+
		"v\2\2\u0147]\3\2\2\2\u0148\u0149\7w\2\2\u0149_\3\2\2\2\u014a\u014b\7x"+
		"\2\2\u014ba\3\2\2\2\u014c\u014d\7z\2\2\u014dc\3\2\2\2\u014e\u014f\7{\2"+
		"\2\u014fe\3\2\2\2\u0150\u0151\4ci\2\u0151g\3\2\2\2\u0152\u0153\7\62\2"+
		"\2\u0153i\3\2\2\2\u0154\u0155\7\63\2\2\u0155k\3\2\2\2\u0156\u0157\7\64"+
		"\2\2\u0157m\3\2\2\2\u0158\u0159\7\65\2\2\u0159o\3\2\2\2\u015a\u015b\7"+
		"\66\2\2\u015bq\3\2\2\2\u015c\u015d\7\67\2\2\u015ds\3\2\2\2\u015e\u015f"+
		"\78\2\2\u015fu\3\2\2\2\u0160\u0161\79\2\2\u0161w\3\2\2\2\u0162\u0163\7"+
		":\2\2\u0163y\3\2\2\2\u0164\u0165\7;\2\2\u0165{\3\2\2\2\u0166\u0167\5\4"+
		"\2\2\u0167}\3\2\2\2\u0168\u0169\7]\2\2\u0169\177\3\2\2\2\u016a\u016b\7"+
		"_\2\2\u016b\u0081\3\2\2\2\u016c\u016d\7%\2\2\u016d\u0083\3\2\2\2\u016e"+
		"\u016f\7-\2\2\u016f\u0085\3\2\2\2\u0170\u0171\7/\2\2\u0171\u0087\3\2\2"+
		"\2\u0172\u0173\7?\2\2\u0173\u0089\3\2\2\2\u0174\u0175\7\60\2\2\u0175\u008b"+
		"\3\2\2\2\u0176\u0177\7~\2\2\u0177\u008d\3\2\2\2\u0178\u0179\7b\2\2\u0179"+
		"\u008f\3\2\2\2\u017a\u017b\7)\2\2\u017b\u0091\3\2\2\2\u017c\u017d\7`\2"+
		"\2\u017d\u0093\3\2\2\2\u017e\u017f\7\u0080\2\2\u017f\u0095\3\2\2\2\u0180"+
		"\u0181\7>\2\2\u0181\u0097\3\2\2\2\u0182\u0183\7@\2\2\u0183\u0099\3\2\2"+
		"\2\u0184\u0185\7\61\2\2\u0185\u009b\3\2\2\2\u0186\u0187\7^\2\2\u0187\u009d"+
		"\3\2\2\2\u0188\u0189\7a\2\2\u0189\u009f\3\2\2\2\u018a\u018b\7*\2\2\u018b"+
		"\u00a1\3\2\2\2\u018c\u018d\7+\2\2\u018d\u00a3\3\2\2\2\u018e\u018f\7<\2"+
		"\2\u018f\u00a5\3\2\2\2\u0190\u0191\7=\2\2\u0191\u00a7\3\2\2\2\u0192\u0193"+
		"\7.\2\2\u0193\u00a9\3\2\2\2\u0194\u0195\7\"\2\2\u0195\u00ab\3\2\2\2\u0196"+
		"\u0197\7\13\2\2\u0197\u0198\bV\5\2\u0198\u00ad\3\2\2\2\u0199\u019b\7\17"+
		"\2\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019d\7\f\2\2\u019d\u019e\bW\6\2\u019e\u00af\3\2\2\2\u019f\u01a1\n\2"+
		"\2\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\bX\7\2\u01a5\u00b1\3\2"+
		"\2\2\u01a6\u01a7\7\13\2\2\u01a7\u01a8\bY\b\2\u01a8\u00b3\3\2\2\2\u01a9"+
		"\u01ab\7\17\2\2\u01aa\u01a9\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\3"+
		"\2\2\2\u01ac\u01ad\7\f\2\2\u01ad\u01ae\bZ\t\2\u01ae\u00b5\3\2\2\2\7\2"+
		"\3\u019a\u01a2\u01aa\n\3\4\2\3\5\3\3\6\4\3V\5\3W\6\4\2\2\3Y\7\3Z\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}