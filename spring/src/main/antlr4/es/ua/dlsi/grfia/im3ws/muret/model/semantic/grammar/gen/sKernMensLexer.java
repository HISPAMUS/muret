// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/semantic/grammar/sKernMensLexer.g4 by ANTLR 4.9.1

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
		FREE_TEXT_EOL=84;
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
			"CHAR_T", "CHAR_U", "CHAR_i", "CHAR_m", "CHAR_n", "CHAR_p", "CHAR_q", 
			"CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", "CHAR_x", "CHAR_y", 
			"LOWERCASE_PITCH_CHARACTER", "DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", 
			"DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", "MINUS", "EQUAL", "DOT", 
			"PIPE", "GRAVE_ACCENT", "APOSTROPHE", "CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", 
			"ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "COLON", "SEMICOLON", "COMMA", "TAB", "EOL", "FIELD_TEXT", 
			"FREE_TEXT_TAB", "FREE_TEXT_EOL"
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
	public String getGrammarFileName() { return "sKernMensLexer.g4"; }

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
		case 81:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 82:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		case 84:
			FREE_TEXT_TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 85:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2V\u01a2\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3"+
		"A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3"+
		"M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3S\3T\5T\u018e\nT\3T\3T\3T\3"+
		"U\6U\u0194\nU\rU\16U\u0195\3U\3U\3V\3V\3V\3W\5W\u019e\nW\3W\3W\3W\2\2"+
		"X\4\2\6\2\b\3\n\4\f\5\16\6\20\7\22\b\24\t\26\n\30\13\32\f\34\r\36\16 "+
		"\17\"\20$\21&\22(\23*\24,\25.\26\60\27\62\30\64\31\66\328\33:\34<\35>"+
		"\36@\37B D!F\"H#J$L%N&P\'R(T)V*X+Z,\\-^.`/b\60d\61f\62h\63j\64l\65n\66"+
		"p\67r8t9v:x;z<|=~>\u0080?\u0082@\u0084A\u0086B\u0088C\u008aD\u008cE\u008e"+
		"F\u0090G\u0092H\u0094I\u0096J\u0098K\u009aL\u009cM\u009eN\u00a0O\u00a2"+
		"P\u00a4Q\u00a6R\u00a8S\u00aaT\u00acU\u00aeV\4\2\3\3\4\2\13\f\17\17\2\u01a1"+
		"\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3"+
		"\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2"+
		"\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2"+
		"\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2"+
		"\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2"+
		"\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2"+
		"N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3"+
		"\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2"+
		"\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2"+
		"\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080"+
		"\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2"+
		"\2\2\u008a\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090\3\2\2\2\2\u0092"+
		"\3\2\2\2\2\u0094\3\2\2\2\2\u0096\3\2\2\2\2\u0098\3\2\2\2\2\u009a\3\2\2"+
		"\2\2\u009c\3\2\2\2\2\u009e\3\2\2\2\2\u00a0\3\2\2\2\2\u00a2\3\2\2\2\2\u00a4"+
		"\3\2\2\2\2\u00a6\3\2\2\2\2\u00a8\3\2\2\2\3\u00aa\3\2\2\2\3\u00ac\3\2\2"+
		"\2\3\u00ae\3\2\2\2\4\u00b0\3\2\2\2\6\u00b2\3\2\2\2\b\u00b4\3\2\2\2\n\u00be"+
		"\3\2\2\2\f\u00c8\3\2\2\2\16\u00d1\3\2\2\2\20\u00d7\3\2\2\2\22\u00de\3"+
		"\2\2\2\24\u00e4\3\2\2\2\26\u00ec\3\2\2\2\30\u00ef\3\2\2\2\32\u00f4\3\2"+
		"\2\2\34\u00f8\3\2\2\2\36\u00fb\3\2\2\2 \u0100\3\2\2\2\"\u0105\3\2\2\2"+
		"$\u0107\3\2\2\2&\u0109\3\2\2\2(\u010b\3\2\2\2*\u010d\3\2\2\2,\u010f\3"+
		"\2\2\2.\u0111\3\2\2\2\60\u0113\3\2\2\2\62\u0115\3\2\2\2\64\u0117\3\2\2"+
		"\2\66\u0119\3\2\2\28\u011b\3\2\2\2:\u011d\3\2\2\2<\u011f\3\2\2\2>\u0121"+
		"\3\2\2\2@\u0123\3\2\2\2B\u0125\3\2\2\2D\u0127\3\2\2\2F\u0129\3\2\2\2H"+
		"\u012b\3\2\2\2J\u012d\3\2\2\2L\u012f\3\2\2\2N\u0131\3\2\2\2P\u0133\3\2"+
		"\2\2R\u0135\3\2\2\2T\u0137\3\2\2\2V\u0139\3\2\2\2X\u013b\3\2\2\2Z\u013d"+
		"\3\2\2\2\\\u013f\3\2\2\2^\u0141\3\2\2\2`\u0143\3\2\2\2b\u0145\3\2\2\2"+
		"d\u0147\3\2\2\2f\u0149\3\2\2\2h\u014b\3\2\2\2j\u014d\3\2\2\2l\u014f\3"+
		"\2\2\2n\u0151\3\2\2\2p\u0153\3\2\2\2r\u0155\3\2\2\2t\u0157\3\2\2\2v\u0159"+
		"\3\2\2\2x\u015b\3\2\2\2z\u015d\3\2\2\2|\u015f\3\2\2\2~\u0161\3\2\2\2\u0080"+
		"\u0163\3\2\2\2\u0082\u0165\3\2\2\2\u0084\u0167\3\2\2\2\u0086\u0169\3\2"+
		"\2\2\u0088\u016b\3\2\2\2\u008a\u016d\3\2\2\2\u008c\u016f\3\2\2\2\u008e"+
		"\u0171\3\2\2\2\u0090\u0173\3\2\2\2\u0092\u0175\3\2\2\2\u0094\u0177\3\2"+
		"\2\2\u0096\u0179\3\2\2\2\u0098\u017b\3\2\2\2\u009a\u017d\3\2\2\2\u009c"+
		"\u017f\3\2\2\2\u009e\u0181\3\2\2\2\u00a0\u0183\3\2\2\2\u00a2\u0185\3\2"+
		"\2\2\u00a4\u0187\3\2\2\2\u00a6\u0189\3\2\2\2\u00a8\u018d\3\2\2\2\u00aa"+
		"\u0193\3\2\2\2\u00ac\u0199\3\2\2\2\u00ae\u019d\3\2\2\2\u00b0\u00b1\7,"+
		"\2\2\u00b1\5\3\2\2\2\u00b2\u00b3\7#\2\2\u00b3\7\3\2\2\2\u00b4\u00b5\5"+
		"\4\2\2\u00b5\u00b6\5\4\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7o\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\3\2\2"+
		"\2\u00bc\u00bd\b\4\2\2\u00bd\t\3\2\2\2\u00be\u00bf\5\4\2\2\u00bf\u00c0"+
		"\5\4\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7m\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\u00c4\7t\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\5\3"+
		"\2\u00c7\13\3\2\2\2\u00c8\u00c9\5\4\2\2\u00c9\u00ca\5\4\2\2\u00ca\u00cb"+
		"\7v\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7z\2\2\u00cd\u00ce\7v\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\b\6\4\2\u00d0\r\3\2\2\2\u00d1\u00d2\5\4\2\2"+
		"\u00d2\u00d3\7r\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6"+
		"\7v\2\2\u00d6\17\3\2\2\2\u00d7\u00d8\5\4\2\2\u00d8\u00d9\7u\2\2\u00d9"+
		"\u00da\7v\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd\7h\2\2"+
		"\u00dd\21\3\2\2\2\u00de\u00df\5\4\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7"+
		"n\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7h\2\2\u00e3\23\3\2\2\2\u00e4\u00e5"+
		"\5\4\2\2\u00e5\u00e6\7e\2\2\u00e6\u00e7\7w\2\2\u00e7\u00e8\7u\2\2\u00e8"+
		"\u00e9\7v\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb\7u\2\2\u00eb\25\3\2\2\2\u00ec"+
		"\u00ed\5\4\2\2\u00ed\u00ee\7m\2\2\u00ee\27\3\2\2\2\u00ef\u00f0\5\4\2\2"+
		"\u00f0\u00f1\7o\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7v\2\2\u00f3\31\3\2"+
		"\2\2\u00f4\u00f5\5\4\2\2\u00f5\u00f6\7O\2\2\u00f6\u00f7\7O\2\2\u00f7\33"+
		"\3\2\2\2\u00f8\u00f9\5\4\2\2\u00f9\u00fa\7O\2\2\u00fa\35\3\2\2\2\u00fb"+
		"\u00fc\5\4\2\2\u00fc\u00fd\7d\2\2\u00fd\u00fe\7r\2\2\u00fe\u00ff\7e\2"+
		"\2\u00ff\37\3\2\2\2\u0100\u0101\5\4\2\2\u0101\u0102\7g\2\2\u0102\u0103"+
		"\7r\2\2\u0103\u0104\7e\2\2\u0104!\3\2\2\2\u0105\u0106\7B\2\2\u0106#\3"+
		"\2\2\2\u0107\u0108\7C\2\2\u0108%\3\2\2\2\u0109\u010a\7D\2\2\u010a\'\3"+
		"\2\2\2\u010b\u010c\7E\2\2\u010c)\3\2\2\2\u010d\u010e\7F\2\2\u010e+\3\2"+
		"\2\2\u010f\u0110\7G\2\2\u0110-\3\2\2\2\u0111\u0112\7H\2\2\u0112/\3\2\2"+
		"\2\u0113\u0114\7I\2\2\u0114\61\3\2\2\2\u0115\u0116\7K\2\2\u0116\63\3\2"+
		"\2\2\u0117\u0118\7L\2\2\u0118\65\3\2\2\2\u0119\u011a\7N\2\2\u011a\67\3"+
		"\2\2\2\u011b\u011c\7O\2\2\u011c9\3\2\2\2\u011d\u011e\7Q\2\2\u011e;\3\2"+
		"\2\2\u011f\u0120\7R\2\2\u0120=\3\2\2\2\u0121\u0122\7S\2\2\u0122?\3\2\2"+
		"\2\u0123\u0124\7T\2\2\u0124A\3\2\2\2\u0125\u0126\7U\2\2\u0126C\3\2\2\2"+
		"\u0127\u0128\7Z\2\2\u0128E\3\2\2\2\u0129\u012a\7[\2\2\u012aG\3\2\2\2\u012b"+
		"\u012c\7V\2\2\u012cI\3\2\2\2\u012d\u012e\7W\2\2\u012eK\3\2\2\2\u012f\u0130"+
		"\7k\2\2\u0130M\3\2\2\2\u0131\u0132\7o\2\2\u0132O\3\2\2\2\u0133\u0134\7"+
		"p\2\2\u0134Q\3\2\2\2\u0135\u0136\7r\2\2\u0136S\3\2\2\2\u0137\u0138\7s"+
		"\2\2\u0138U\3\2\2\2\u0139\u013a\7t\2\2\u013aW\3\2\2\2\u013b\u013c\7u\2"+
		"\2\u013cY\3\2\2\2\u013d\u013e\7v\2\2\u013e[\3\2\2\2\u013f\u0140\7w\2\2"+
		"\u0140]\3\2\2\2\u0141\u0142\7x\2\2\u0142_\3\2\2\2\u0143\u0144\7z\2\2\u0144"+
		"a\3\2\2\2\u0145\u0146\7{\2\2\u0146c\3\2\2\2\u0147\u0148\4ci\2\u0148e\3"+
		"\2\2\2\u0149\u014a\7\62\2\2\u014ag\3\2\2\2\u014b\u014c\7\63\2\2\u014c"+
		"i\3\2\2\2\u014d\u014e\7\64\2\2\u014ek\3\2\2\2\u014f\u0150\7\65\2\2\u0150"+
		"m\3\2\2\2\u0151\u0152\7\66\2\2\u0152o\3\2\2\2\u0153\u0154\7\67\2\2\u0154"+
		"q\3\2\2\2\u0155\u0156\78\2\2\u0156s\3\2\2\2\u0157\u0158\79\2\2\u0158u"+
		"\3\2\2\2\u0159\u015a\7:\2\2\u015aw\3\2\2\2\u015b\u015c\7;\2\2\u015cy\3"+
		"\2\2\2\u015d\u015e\5\4\2\2\u015e{\3\2\2\2\u015f\u0160\7]\2\2\u0160}\3"+
		"\2\2\2\u0161\u0162\7_\2\2\u0162\177\3\2\2\2\u0163\u0164\7%\2\2\u0164\u0081"+
		"\3\2\2\2\u0165\u0166\7/\2\2\u0166\u0083\3\2\2\2\u0167\u0168\7?\2\2\u0168"+
		"\u0085\3\2\2\2\u0169\u016a\7\60\2\2\u016a\u0087\3\2\2\2\u016b\u016c\7"+
		"~\2\2\u016c\u0089\3\2\2\2\u016d\u016e\7b\2\2\u016e\u008b\3\2\2\2\u016f"+
		"\u0170\7)\2\2\u0170\u008d\3\2\2\2\u0171\u0172\7`\2\2\u0172\u008f\3\2\2"+
		"\2\u0173\u0174\7\u0080\2\2\u0174\u0091\3\2\2\2\u0175\u0176\7>\2\2\u0176"+
		"\u0093\3\2\2\2\u0177\u0178\7@\2\2\u0178\u0095\3\2\2\2\u0179\u017a\7\61"+
		"\2\2\u017a\u0097\3\2\2\2\u017b\u017c\7^\2\2\u017c\u0099\3\2\2\2\u017d"+
		"\u017e\7a\2\2\u017e\u009b\3\2\2\2\u017f\u0180\7*\2\2\u0180\u009d\3\2\2"+
		"\2\u0181\u0182\7+\2\2\u0182\u009f\3\2\2\2\u0183\u0184\7<\2\2\u0184\u00a1"+
		"\3\2\2\2\u0185\u0186\7=\2\2\u0186\u00a3\3\2\2\2\u0187\u0188\7.\2\2\u0188"+
		"\u00a5\3\2\2\2\u0189\u018a\7\13\2\2\u018a\u018b\bS\5\2\u018b\u00a7\3\2"+
		"\2\2\u018c\u018e\7\17\2\2\u018d\u018c\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0190\7\f\2\2\u0190\u0191\bT\6\2\u0191\u00a9\3\2"+
		"\2\2\u0192\u0194\n\2\2\2\u0193\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\bU"+
		"\7\2\u0198\u00ab\3\2\2\2\u0199\u019a\7\13\2\2\u019a\u019b\bV\b\2\u019b"+
		"\u00ad\3\2\2\2\u019c\u019e\7\17\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3"+
		"\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\7\f\2\2\u01a0\u01a1\bW\t\2\u01a1"+
		"\u00af\3\2\2\2\7\2\3\u018d\u0195\u019d\n\3\4\2\3\5\3\3\6\4\3S\5\3T\6\4"+
		"\2\2\3V\7\3W\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}