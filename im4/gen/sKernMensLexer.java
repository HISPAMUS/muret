// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/im4/src/main/antlr4/es/ua/dlsi/grfia/im4/core/semantic/grammar/skmLexer.g4 by ANTLR 4.8

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
public class sKernMensLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
		CHAR_n=37, CHAR_p=38, CHAR_r=39, CHAR_s=40, CHAR_t=41, CHAR_u=42, CHAR_v=43, 
		CHAR_x=44, CHAR_y=45, LOWERCASE_PITCH_CHARACTER=46, DIGIT_0=47, DIGIT_1=48, 
		DIGIT_2=49, DIGIT_3=50, DIGIT_4=51, DIGIT_5=52, DIGIT_6=53, DIGIT_7=54, 
		DIGIT_8=55, DIGIT_9=56, ASTERISK=57, LEFT_BRACKET=58, RIGHT_BRACKET=59, 
		OCTOTHORPE=60, MINUS=61, EQUAL=62, DOT=63, PIPE=64, GRAVE_ACCENT=65, APOSTROPHE=66, 
		CIRCUMFLEX=67, TILDE=68, ANGLE_BRACKET_OPEN=69, ANGLE_BRACKET_CLOSE=70, 
		SLASH=71, BACKSLASH=72, UNDERSCORE=73, LEFT_PARENTHESIS=74, RIGHT_PARENTHESIS=75, 
		COLON=76, SEMICOLON=77, COMMA=78, TAB=79, EOL=80, FIELD_TEXT=81, FREE_TEXT_TAB=82, 
		FREE_TEXT_EOL=83;
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
			"ASTERISK_FRAGMENT", "EXCLAMATION_FRAGMENT", "SMENS", "SKERN", "TEXT", 
			"TANDEM_PART", "TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", "TANDEM_KEY", 
			"TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", "TANDEM_BEGIN_PLAIN_CHANT", 
			"TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", "CHAR_B", "CHAR_C", "CHAR_D", 
			"CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", "CHAR_J", "CHAR_L", "CHAR_M", 
			"CHAR_O", "CHAR_P", "CHAR_Q", "CHAR_R", "CHAR_S", "CHAR_X", "CHAR_Y", 
			"CHAR_T", "CHAR_U", "CHAR_i", "CHAR_m", "CHAR_n", "CHAR_p", "CHAR_r", 
			"CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", "CHAR_x", "CHAR_y", "LOWERCASE_PITCH_CHARACTER", 
			"DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", 
			"DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"OCTOTHORPE", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", 
			"CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", 
			"BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", 
			"SEMICOLON", "COMMA", "TAB", "EOL", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'I'", 
			"'J'", "'L'", "'M'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'X'", "'Y'", 
			"'T'", "'U'", "'i'", "'m'", "'n'", "'p'", null, "'s'", null, "'u'", "'v'", 
			"'x'", "'y'", null, "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", 
			"'7'", "'8'", "'9'", null, "'['", "']'", "'#'", "'-'", "'='", "'.'", 
			"'|'", "'`'", "'''", "'^'", "'~'", "'<'", "'>'", "'/'", "'\\'", "'_'", 
			"'('", "')'", "':'", "';'", "','"
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
			"CHAR_n", "CHAR_p", "CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", 
			"CHAR_x", "CHAR_y", "LOWERCASE_PITCH_CHARACTER", "DIGIT_0", "DIGIT_1", 
			"DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", 
			"DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", 
			"MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", "CIRCUMFLEX", 
			"TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", 
			"UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", "SEMICOLON", 
			"COMMA", "TAB", "EOL", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
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



	public sKernMensLexer(CharStream input) {
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
		case 80:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 81:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		case 83:
			FREE_TEXT_TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 84:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2U\u019e\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C"+
		"\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N"+
		"\3O\3O\3P\3P\3Q\3Q\3R\3R\3R\3S\5S\u018a\nS\3S\3S\3S\3T\6T\u0190\nT\rT"+
		"\16T\u0191\3T\3T\3U\3U\3U\3V\5V\u019a\nV\3V\3V\3V\2\2W\4\2\6\2\b\3\n\4"+
		"\f\5\16\6\20\7\22\b\24\t\26\n\30\13\32\f\34\r\36\16 \17\"\20$\21&\22("+
		"\23*\24,\25.\26\60\27\62\30\64\31\66\328\33:\34<\35>\36@\37B D!F\"H#J"+
		"$L%N&P\'R(T)V*X+Z,\\-^.`/b\60d\61f\62h\63j\64l\65n\66p\67r8t9v:x;z<|="+
		"~>\u0080?\u0082@\u0084A\u0086B\u0088C\u008aD\u008cE\u008eF\u0090G\u0092"+
		"H\u0094I\u0096J\u0098K\u009aL\u009cM\u009eN\u00a0O\u00a2P\u00a4Q\u00a6"+
		"R\u00a8S\u00aaT\u00acU\4\2\3\3\4\2\13\f\17\17\2\u019d\2\b\3\2\2\2\2\n"+
		"\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2"+
		"\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2"+
		" \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3"+
		"\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2"+
		"\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D"+
		"\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2"+
		"\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2"+
		"\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2"+
		"j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3"+
		"\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082"+
		"\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\2\u008a\3\2\2"+
		"\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090\3\2\2\2\2\u0092\3\2\2\2\2\u0094"+
		"\3\2\2\2\2\u0096\3\2\2\2\2\u0098\3\2\2\2\2\u009a\3\2\2\2\2\u009c\3\2\2"+
		"\2\2\u009e\3\2\2\2\2\u00a0\3\2\2\2\2\u00a2\3\2\2\2\2\u00a4\3\2\2\2\2\u00a6"+
		"\3\2\2\2\3\u00a8\3\2\2\2\3\u00aa\3\2\2\2\3\u00ac\3\2\2\2\4\u00ae\3\2\2"+
		"\2\6\u00b0\3\2\2\2\b\u00b2\3\2\2\2\n\u00bc\3\2\2\2\f\u00c6\3\2\2\2\16"+
		"\u00cf\3\2\2\2\20\u00d5\3\2\2\2\22\u00dc\3\2\2\2\24\u00e2\3\2\2\2\26\u00ea"+
		"\3\2\2\2\30\u00ed\3\2\2\2\32\u00f2\3\2\2\2\34\u00f6\3\2\2\2\36\u00f9\3"+
		"\2\2\2 \u00fe\3\2\2\2\"\u0103\3\2\2\2$\u0105\3\2\2\2&\u0107\3\2\2\2(\u0109"+
		"\3\2\2\2*\u010b\3\2\2\2,\u010d\3\2\2\2.\u010f\3\2\2\2\60\u0111\3\2\2\2"+
		"\62\u0113\3\2\2\2\64\u0115\3\2\2\2\66\u0117\3\2\2\28\u0119\3\2\2\2:\u011b"+
		"\3\2\2\2<\u011d\3\2\2\2>\u011f\3\2\2\2@\u0121\3\2\2\2B\u0123\3\2\2\2D"+
		"\u0125\3\2\2\2F\u0127\3\2\2\2H\u0129\3\2\2\2J\u012b\3\2\2\2L\u012d\3\2"+
		"\2\2N\u012f\3\2\2\2P\u0131\3\2\2\2R\u0133\3\2\2\2T\u0135\3\2\2\2V\u0137"+
		"\3\2\2\2X\u0139\3\2\2\2Z\u013b\3\2\2\2\\\u013d\3\2\2\2^\u013f\3\2\2\2"+
		"`\u0141\3\2\2\2b\u0143\3\2\2\2d\u0145\3\2\2\2f\u0147\3\2\2\2h\u0149\3"+
		"\2\2\2j\u014b\3\2\2\2l\u014d\3\2\2\2n\u014f\3\2\2\2p\u0151\3\2\2\2r\u0153"+
		"\3\2\2\2t\u0155\3\2\2\2v\u0157\3\2\2\2x\u0159\3\2\2\2z\u015b\3\2\2\2|"+
		"\u015d\3\2\2\2~\u015f\3\2\2\2\u0080\u0161\3\2\2\2\u0082\u0163\3\2\2\2"+
		"\u0084\u0165\3\2\2\2\u0086\u0167\3\2\2\2\u0088\u0169\3\2\2\2\u008a\u016b"+
		"\3\2\2\2\u008c\u016d\3\2\2\2\u008e\u016f\3\2\2\2\u0090\u0171\3\2\2\2\u0092"+
		"\u0173\3\2\2\2\u0094\u0175\3\2\2\2\u0096\u0177\3\2\2\2\u0098\u0179\3\2"+
		"\2\2\u009a\u017b\3\2\2\2\u009c\u017d\3\2\2\2\u009e\u017f\3\2\2\2\u00a0"+
		"\u0181\3\2\2\2\u00a2\u0183\3\2\2\2\u00a4\u0185\3\2\2\2\u00a6\u0189\3\2"+
		"\2\2\u00a8\u018f\3\2\2\2\u00aa\u0195\3\2\2\2\u00ac\u0199\3\2\2\2\u00ae"+
		"\u00af\7,\2\2\u00af\5\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1\7\3\2\2\2\u00b2"+
		"\u00b3\5\4\2\2\u00b3\u00b4\5\4\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7o\2"+
		"\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bb\b\4\2\2\u00bb\t\3\2\2\2\u00bc\u00bd\5\4\2\2\u00bd"+
		"\u00be\5\4\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7m\2\2\u00c0\u00c1\7g\2"+
		"\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5"+
		"\b\5\3\2\u00c5\13\3\2\2\2\u00c6\u00c7\5\4\2\2\u00c7\u00c8\5\4\2\2\u00c8"+
		"\u00c9\7v\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7z\2\2\u00cb\u00cc\7v\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\6\4\2\u00ce\r\3\2\2\2\u00cf\u00d0\5"+
		"\4\2\2\u00d0\u00d1\7r\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7t\2\2\u00d3"+
		"\u00d4\7v\2\2\u00d4\17\3\2\2\2\u00d5\u00d6\5\4\2\2\u00d6\u00d7\7u\2\2"+
		"\u00d7\u00d8\7v\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7h\2\2\u00da\u00db"+
		"\7h\2\2\u00db\21\3\2\2\2\u00dc\u00dd\5\4\2\2\u00dd\u00de\7e\2\2\u00de"+
		"\u00df\7n\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7h\2\2\u00e1\23\3\2\2\2\u00e2"+
		"\u00e3\5\4\2\2\u00e3\u00e4\7e\2\2\u00e4\u00e5\7w\2\2\u00e5\u00e6\7u\2"+
		"\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7u\2\2\u00e9\25\3"+
		"\2\2\2\u00ea\u00eb\5\4\2\2\u00eb\u00ec\7m\2\2\u00ec\27\3\2\2\2\u00ed\u00ee"+
		"\5\4\2\2\u00ee\u00ef\7o\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7v\2\2\u00f1"+
		"\31\3\2\2\2\u00f2\u00f3\5\4\2\2\u00f3\u00f4\7O\2\2\u00f4\u00f5\7O\2\2"+
		"\u00f5\33\3\2\2\2\u00f6\u00f7\5\4\2\2\u00f7\u00f8\7O\2\2\u00f8\35\3\2"+
		"\2\2\u00f9\u00fa\5\4\2\2\u00fa\u00fb\7d\2\2\u00fb\u00fc\7r\2\2\u00fc\u00fd"+
		"\7e\2\2\u00fd\37\3\2\2\2\u00fe\u00ff\5\4\2\2\u00ff\u0100\7g\2\2\u0100"+
		"\u0101\7r\2\2\u0101\u0102\7e\2\2\u0102!\3\2\2\2\u0103\u0104\7B\2\2\u0104"+
		"#\3\2\2\2\u0105\u0106\7C\2\2\u0106%\3\2\2\2\u0107\u0108\7D\2\2\u0108\'"+
		"\3\2\2\2\u0109\u010a\7E\2\2\u010a)\3\2\2\2\u010b\u010c\7F\2\2\u010c+\3"+
		"\2\2\2\u010d\u010e\7G\2\2\u010e-\3\2\2\2\u010f\u0110\7H\2\2\u0110/\3\2"+
		"\2\2\u0111\u0112\7I\2\2\u0112\61\3\2\2\2\u0113\u0114\7K\2\2\u0114\63\3"+
		"\2\2\2\u0115\u0116\7L\2\2\u0116\65\3\2\2\2\u0117\u0118\7N\2\2\u0118\67"+
		"\3\2\2\2\u0119\u011a\7O\2\2\u011a9\3\2\2\2\u011b\u011c\7Q\2\2\u011c;\3"+
		"\2\2\2\u011d\u011e\7R\2\2\u011e=\3\2\2\2\u011f\u0120\7S\2\2\u0120?\3\2"+
		"\2\2\u0121\u0122\7T\2\2\u0122A\3\2\2\2\u0123\u0124\7U\2\2\u0124C\3\2\2"+
		"\2\u0125\u0126\7Z\2\2\u0126E\3\2\2\2\u0127\u0128\7[\2\2\u0128G\3\2\2\2"+
		"\u0129\u012a\7V\2\2\u012aI\3\2\2\2\u012b\u012c\7W\2\2\u012cK\3\2\2\2\u012d"+
		"\u012e\7k\2\2\u012eM\3\2\2\2\u012f\u0130\7o\2\2\u0130O\3\2\2\2\u0131\u0132"+
		"\7p\2\2\u0132Q\3\2\2\2\u0133\u0134\7r\2\2\u0134S\3\2\2\2\u0135\u0136\7"+
		"t\2\2\u0136U\3\2\2\2\u0137\u0138\7u\2\2\u0138W\3\2\2\2\u0139\u013a\7t"+
		"\2\2\u013aY\3\2\2\2\u013b\u013c\7w\2\2\u013c[\3\2\2\2\u013d\u013e\7x\2"+
		"\2\u013e]\3\2\2\2\u013f\u0140\7z\2\2\u0140_\3\2\2\2\u0141\u0142\7{\2\2"+
		"\u0142a\3\2\2\2\u0143\u0144\4ci\2\u0144c\3\2\2\2\u0145\u0146\7\62\2\2"+
		"\u0146e\3\2\2\2\u0147\u0148\7\63\2\2\u0148g\3\2\2\2\u0149\u014a\7\64\2"+
		"\2\u014ai\3\2\2\2\u014b\u014c\7\65\2\2\u014ck\3\2\2\2\u014d\u014e\7\66"+
		"\2\2\u014em\3\2\2\2\u014f\u0150\7\67\2\2\u0150o\3\2\2\2\u0151\u0152\7"+
		"8\2\2\u0152q\3\2\2\2\u0153\u0154\79\2\2\u0154s\3\2\2\2\u0155\u0156\7:"+
		"\2\2\u0156u\3\2\2\2\u0157\u0158\7;\2\2\u0158w\3\2\2\2\u0159\u015a\5\4"+
		"\2\2\u015ay\3\2\2\2\u015b\u015c\7]\2\2\u015c{\3\2\2\2\u015d\u015e\7_\2"+
		"\2\u015e}\3\2\2\2\u015f\u0160\7%\2\2\u0160\177\3\2\2\2\u0161\u0162\7/"+
		"\2\2\u0162\u0081\3\2\2\2\u0163\u0164\7?\2\2\u0164\u0083\3\2\2\2\u0165"+
		"\u0166\7\60\2\2\u0166\u0085\3\2\2\2\u0167\u0168\7~\2\2\u0168\u0087\3\2"+
		"\2\2\u0169\u016a\7b\2\2\u016a\u0089\3\2\2\2\u016b\u016c\7)\2\2\u016c\u008b"+
		"\3\2\2\2\u016d\u016e\7`\2\2\u016e\u008d\3\2\2\2\u016f\u0170\7\u0080\2"+
		"\2\u0170\u008f\3\2\2\2\u0171\u0172\7>\2\2\u0172\u0091\3\2\2\2\u0173\u0174"+
		"\7@\2\2\u0174\u0093\3\2\2\2\u0175\u0176\7\61\2\2\u0176\u0095\3\2\2\2\u0177"+
		"\u0178\7^\2\2\u0178\u0097\3\2\2\2\u0179\u017a\7a\2\2\u017a\u0099\3\2\2"+
		"\2\u017b\u017c\7*\2\2\u017c\u009b\3\2\2\2\u017d\u017e\7+\2\2\u017e\u009d"+
		"\3\2\2\2\u017f\u0180\7<\2\2\u0180\u009f\3\2\2\2\u0181\u0182\7=\2\2\u0182"+
		"\u00a1\3\2\2\2\u0183\u0184\7.\2\2\u0184\u00a3\3\2\2\2\u0185\u0186\7\13"+
		"\2\2\u0186\u0187\bR\5\2\u0187\u00a5\3\2\2\2\u0188\u018a\7\17\2\2\u0189"+
		"\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\7\f"+
		"\2\2\u018c\u018d\bS\6\2\u018d\u00a7\3\2\2\2\u018e\u0190\n\2\2\2\u018f"+
		"\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193\u0194\bT\7\2\u0194\u00a9\3\2\2\2\u0195"+
		"\u0196\7\13\2\2\u0196\u0197\bU\b\2\u0197\u00ab\3\2\2\2\u0198\u019a\7\17"+
		"\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019c\7\f\2\2\u019c\u019d\bV\t\2\u019d\u00ad\3\2\2\2\7\2\3\u0189\u0191"+
		"\u0199\n\3\4\2\3\5\3\3\6\4\3R\5\3S\6\4\2\2\3U\7\3V\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
