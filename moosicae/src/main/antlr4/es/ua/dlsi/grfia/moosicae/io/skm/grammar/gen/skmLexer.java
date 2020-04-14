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
		TANDEM_STAFF=7, TANDEM_CLEF=8, TANDEM_CUSTOS=9, TANDEM_KEY_SIGNATURE=10, 
		TANDEM_KEY=11, TANDEM_MET=12, METRONOME=13, TANDEM_TIMESIGNATURE=14, TANDEM_BEGIN_PLAIN_CHANT=15, 
		TANDEM_END_PLAIN_CHANT=16, AT=17, CHAR_A=18, CHAR_B=19, CHAR_C=20, CHAR_D=21, 
		CHAR_E=22, CHAR_F=23, CHAR_G=24, CHAR_I=25, CHAR_J=26, CHAR_L=27, CHAR_M=28, 
		CHAR_O=29, CHAR_P=30, CHAR_Q=31, CHAR_R=32, CHAR_S=33, CHAR_X=34, CHAR_Y=35, 
		CHAR_T=36, CHAR_U=37, CHAR_a=38, CHAR_b=39, CHAR_c=40, CHAR_d=41, CHAR_e=42, 
		CHAR_f=43, CHAR_g=44, CHAR_i=45, CHAR_m=46, CHAR_n=47, CHAR_p=48, CHAR_r=49, 
		CHAR_s=50, CHAR_t=51, CHAR_u=52, CHAR_v=53, CHAR_x=54, CHAR_y=55, DIGIT_0=56, 
		DIGIT_1=57, DIGIT_2=58, DIGIT_3=59, DIGIT_4=60, DIGIT_5=61, DIGIT_6=62, 
		DIGIT_7=63, DIGIT_8=64, DIGIT_9=65, ASTERISK=66, LEFT_BRACKET=67, RIGHT_BRACKET=68, 
		OCTOTHORPE=69, PLUS=70, MINUS=71, EQUAL=72, DOT=73, PIPE=74, GRAVE_ACCENT=75, 
		APOSTROPHE=76, CIRCUMFLEX=77, TILDE=78, ANGLE_BRACKET_OPEN=79, ANGLE_BRACKET_CLOSE=80, 
		SLASH=81, BACKSLASH=82, UNDERSCORE=83, LEFT_PARENTHESIS=84, RIGHT_PARENTHESIS=85, 
		COLON=86, SEMICOLON=87, COMMA=88, SEP=89, SPACE=90, TAB=91, EOL=92, FIELD_TEXT=93, 
		FREE_TEXT_TAB=94, FREE_TEXT_EOL=95;
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
			"TANDEM_KEY_SIGNATURE", "TANDEM_KEY", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", 
			"TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", 
			"CHAR_B", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", 
			"CHAR_J", "CHAR_L", "CHAR_M", "CHAR_O", "CHAR_P", "CHAR_Q", "CHAR_R", 
			"CHAR_S", "CHAR_X", "CHAR_Y", "CHAR_T", "CHAR_U", "CHAR_a", "CHAR_b", 
			"CHAR_c", "CHAR_d", "CHAR_e", "CHAR_f", "CHAR_g", "CHAR_i", "CHAR_m", 
			"CHAR_n", "CHAR_p", "CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", 
			"CHAR_x", "CHAR_y", "DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", 
			"DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "OCTOTHORPE", "PLUS", "MINUS", "EQUAL", "DOT", "PIPE", 
			"GRAVE_ACCENT", "APOSTROPHE", "CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", 
			"ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", 
			"RIGHT_PARENTHESIS", "COLON", "SEMICOLON", "COMMA", "SEP", "SPACE", "TAB", 
			"EOL", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", 
			"'F'", "'G'", "'I'", "'J'", "'L'", "'M'", "'O'", "'P'", "'Q'", "'R'", 
			"'S'", "'X'", "'Y'", "'T'", "'U'", "'a'", "'b'", "'c'", "'d'", "'e'", 
			"'f'", "'g'", "'i'", "'m'", "'n'", "'p'", "'r'", "'s'", "'t'", "'u'", 
			"'v'", "'x'", "'y'", "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", 
			"'7'", "'8'", "'9'", null, "'['", "']'", "'#'", "'+'", "'-'", "'='", 
			"'.'", "'|'", "'`'", "'''", "'^'", "'~'", "'<'", "'>'", "'/'", "'\\'", 
			"'_'", "'('", "')'", "':'", "';'", "','", "'\u00B7'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EXCLAMATION", "SMENS", "SKERN", "TEXT", "TANDEM_PART", "TANDEM_INSTRUMENT", 
			"TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", "TANDEM_KEY_SIGNATURE", 
			"TANDEM_KEY", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", "TANDEM_BEGIN_PLAIN_CHANT", 
			"TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", "CHAR_B", "CHAR_C", "CHAR_D", 
			"CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", "CHAR_J", "CHAR_L", "CHAR_M", 
			"CHAR_O", "CHAR_P", "CHAR_Q", "CHAR_R", "CHAR_S", "CHAR_X", "CHAR_Y", 
			"CHAR_T", "CHAR_U", "CHAR_a", "CHAR_b", "CHAR_c", "CHAR_d", "CHAR_e", 
			"CHAR_f", "CHAR_g", "CHAR_i", "CHAR_m", "CHAR_n", "CHAR_p", "CHAR_r", 
			"CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", "CHAR_x", "CHAR_y", "DIGIT_0", 
			"DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", 
			"DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", 
			"PLUS", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", 
			"CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", 
			"BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", 
			"SEMICOLON", "COMMA", "SEP", "SPACE", "TAB", "EOL", "FIELD_TEXT", "FREE_TEXT_TAB", 
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
		case 91:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 92:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		case 94:
			FREE_TEXT_TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 95:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2a\u01cc\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@"+
		"\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L"+
		"\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W"+
		"\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3]\3^\5^\u01b8\n^\3^\3^\3^\3_\6"+
		"_\u01be\n_\r_\16_\u01bf\3_\3_\3`\3`\3`\3a\5a\u01c8\na\3a\3a\3a\2\2b\4"+
		"\2\6\3\b\4\n\5\f\6\16\7\20\b\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20"+
		"\"\21$\22&\23(\24*\25,\26.\27\60\30\62\31\64\32\66\338\34:\35<\36>\37"+
		"@ B!D\"F#H$J%L&N\'P(R)T*V+X,Z-\\.^/`\60b\61d\62f\63h\64j\65l\66n\67p8"+
		"r9t:v;x<z=|>~?\u0080@\u0082A\u0084B\u0086C\u0088D\u008aE\u008cF\u008e"+
		"G\u0090H\u0092I\u0094J\u0096K\u0098L\u009aM\u009cN\u009eO\u00a0P\u00a2"+
		"Q\u00a4R\u00a6S\u00a8T\u00aaU\u00acV\u00aeW\u00b0X\u00b2Y\u00b4Z\u00b6"+
		"[\u00b8\\\u00ba]\u00bc^\u00be_\u00c0`\u00c2a\4\2\3\3\4\2\13\f\17\17\2"+
		"\u01cc\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2"+
		"\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3"+
		"\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&"+
		"\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62"+
		"\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2"+
		">\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3"+
		"\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2"+
		"\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2"+
		"\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p"+
		"\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2"+
		"\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086"+
		"\3\2\2\2\2\u0088\3\2\2\2\2\u008a\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2"+
		"\2\2\u0090\3\2\2\2\2\u0092\3\2\2\2\2\u0094\3\2\2\2\2\u0096\3\2\2\2\2\u0098"+
		"\3\2\2\2\2\u009a\3\2\2\2\2\u009c\3\2\2\2\2\u009e\3\2\2\2\2\u00a0\3\2\2"+
		"\2\2\u00a2\3\2\2\2\2\u00a4\3\2\2\2\2\u00a6\3\2\2\2\2\u00a8\3\2\2\2\2\u00aa"+
		"\3\2\2\2\2\u00ac\3\2\2\2\2\u00ae\3\2\2\2\2\u00b0\3\2\2\2\2\u00b2\3\2\2"+
		"\2\2\u00b4\3\2\2\2\2\u00b6\3\2\2\2\2\u00b8\3\2\2\2\2\u00ba\3\2\2\2\2\u00bc"+
		"\3\2\2\2\3\u00be\3\2\2\2\3\u00c0\3\2\2\2\3\u00c2\3\2\2\2\4\u00c4\3\2\2"+
		"\2\6\u00c6\3\2\2\2\b\u00c8\3\2\2\2\n\u00d2\3\2\2\2\f\u00dc\3\2\2\2\16"+
		"\u00e5\3\2\2\2\20\u00eb\3\2\2\2\22\u00ee\3\2\2\2\24\u00f5\3\2\2\2\26\u00fb"+
		"\3\2\2\2\30\u0103\3\2\2\2\32\u0106\3\2\2\2\34\u0109\3\2\2\2\36\u010e\3"+
		"\2\2\2 \u0112\3\2\2\2\"\u0115\3\2\2\2$\u011a\3\2\2\2&\u011f\3\2\2\2(\u0121"+
		"\3\2\2\2*\u0123\3\2\2\2,\u0125\3\2\2\2.\u0127\3\2\2\2\60\u0129\3\2\2\2"+
		"\62\u012b\3\2\2\2\64\u012d\3\2\2\2\66\u012f\3\2\2\28\u0131\3\2\2\2:\u0133"+
		"\3\2\2\2<\u0135\3\2\2\2>\u0137\3\2\2\2@\u0139\3\2\2\2B\u013b\3\2\2\2D"+
		"\u013d\3\2\2\2F\u013f\3\2\2\2H\u0141\3\2\2\2J\u0143\3\2\2\2L\u0145\3\2"+
		"\2\2N\u0147\3\2\2\2P\u0149\3\2\2\2R\u014b\3\2\2\2T\u014d\3\2\2\2V\u014f"+
		"\3\2\2\2X\u0151\3\2\2\2Z\u0153\3\2\2\2\\\u0155\3\2\2\2^\u0157\3\2\2\2"+
		"`\u0159\3\2\2\2b\u015b\3\2\2\2d\u015d\3\2\2\2f\u015f\3\2\2\2h\u0161\3"+
		"\2\2\2j\u0163\3\2\2\2l\u0165\3\2\2\2n\u0167\3\2\2\2p\u0169\3\2\2\2r\u016b"+
		"\3\2\2\2t\u016d\3\2\2\2v\u016f\3\2\2\2x\u0171\3\2\2\2z\u0173\3\2\2\2|"+
		"\u0175\3\2\2\2~\u0177\3\2\2\2\u0080\u0179\3\2\2\2\u0082\u017b\3\2\2\2"+
		"\u0084\u017d\3\2\2\2\u0086\u017f\3\2\2\2\u0088\u0181\3\2\2\2\u008a\u0183"+
		"\3\2\2\2\u008c\u0185\3\2\2\2\u008e\u0187\3\2\2\2\u0090\u0189\3\2\2\2\u0092"+
		"\u018b\3\2\2\2\u0094\u018d\3\2\2\2\u0096\u018f\3\2\2\2\u0098\u0191\3\2"+
		"\2\2\u009a\u0193\3\2\2\2\u009c\u0195\3\2\2\2\u009e\u0197\3\2\2\2\u00a0"+
		"\u0199\3\2\2\2\u00a2\u019b\3\2\2\2\u00a4\u019d\3\2\2\2\u00a6\u019f\3\2"+
		"\2\2\u00a8\u01a1\3\2\2\2\u00aa\u01a3\3\2\2\2\u00ac\u01a5\3\2\2\2\u00ae"+
		"\u01a7\3\2\2\2\u00b0\u01a9\3\2\2\2\u00b2\u01ab\3\2\2\2\u00b4\u01ad\3\2"+
		"\2\2\u00b6\u01af\3\2\2\2\u00b8\u01b1\3\2\2\2\u00ba\u01b3\3\2\2\2\u00bc"+
		"\u01b7\3\2\2\2\u00be\u01bd\3\2\2\2\u00c0\u01c3\3\2\2\2\u00c2\u01c7\3\2"+
		"\2\2\u00c4\u00c5\7,\2\2\u00c5\5\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\7\3\2"+
		"\2\2\u00c8\u00c9\5\4\2\2\u00c9\u00ca\5\4\2\2\u00ca\u00cb\7u\2\2\u00cb"+
		"\u00cc\7o\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7u\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00d0\u00d1\b\4\2\2\u00d1\t\3\2\2\2\u00d2\u00d3\5"+
		"\4\2\2\u00d3\u00d4\5\4\2\2\u00d4\u00d5\7u\2\2\u00d5\u00d6\7m\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\3\2\2"+
		"\2\u00da\u00db\b\5\3\2\u00db\13\3\2\2\2\u00dc\u00dd\5\4\2\2\u00dd\u00de"+
		"\5\4\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7z\2\2\u00e1"+
		"\u00e2\7v\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\6\4\2\u00e4\r\3\2\2\2"+
		"\u00e5\u00e6\5\4\2\2\u00e6\u00e7\7r\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9"+
		"\7t\2\2\u00e9\u00ea\7v\2\2\u00ea\17\3\2\2\2\u00eb\u00ec\5\4\2\2\u00ec"+
		"\u00ed\5\66\33\2\u00ed\21\3\2\2\2\u00ee\u00ef\5\4\2\2\u00ef\u00f0\7u\2"+
		"\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4"+
		"\7h\2\2\u00f4\23\3\2\2\2\u00f5\u00f6\5\4\2\2\u00f6\u00f7\7e\2\2\u00f7"+
		"\u00f8\7n\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7h\2\2\u00fa\25\3\2\2\2\u00fb"+
		"\u00fc\5\4\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe\7w\2\2\u00fe\u00ff\7u\2"+
		"\2\u00ff\u0100\7v\2\2\u0100\u0101\7q\2\2\u0101\u0102\7u\2\2\u0102\27\3"+
		"\2\2\2\u0103\u0104\5\4\2\2\u0104\u0105\7m\2\2\u0105\31\3\2\2\2\u0106\u0107"+
		"\5\4\2\2\u0107\u0108\7M\2\2\u0108\33\3\2\2\2\u0109\u010a\5\4\2\2\u010a"+
		"\u010b\7o\2\2\u010b\u010c\7g\2\2\u010c\u010d\7v\2\2\u010d\35\3\2\2\2\u010e"+
		"\u010f\5\4\2\2\u010f\u0110\7O\2\2\u0110\u0111\7O\2\2\u0111\37\3\2\2\2"+
		"\u0112\u0113\5\4\2\2\u0113\u0114\7O\2\2\u0114!\3\2\2\2\u0115\u0116\5\4"+
		"\2\2\u0116\u0117\7d\2\2\u0117\u0118\7r\2\2\u0118\u0119\7e\2\2\u0119#\3"+
		"\2\2\2\u011a\u011b\5\4\2\2\u011b\u011c\7g\2\2\u011c\u011d\7r\2\2\u011d"+
		"\u011e\7e\2\2\u011e%\3\2\2\2\u011f\u0120\7B\2\2\u0120\'\3\2\2\2\u0121"+
		"\u0122\7C\2\2\u0122)\3\2\2\2\u0123\u0124\7D\2\2\u0124+\3\2\2\2\u0125\u0126"+
		"\7E\2\2\u0126-\3\2\2\2\u0127\u0128\7F\2\2\u0128/\3\2\2\2\u0129\u012a\7"+
		"G\2\2\u012a\61\3\2\2\2\u012b\u012c\7H\2\2\u012c\63\3\2\2\2\u012d\u012e"+
		"\7I\2\2\u012e\65\3\2\2\2\u012f\u0130\7K\2\2\u0130\67\3\2\2\2\u0131\u0132"+
		"\7L\2\2\u01329\3\2\2\2\u0133\u0134\7N\2\2\u0134;\3\2\2\2\u0135\u0136\7"+
		"O\2\2\u0136=\3\2\2\2\u0137\u0138\7Q\2\2\u0138?\3\2\2\2\u0139\u013a\7R"+
		"\2\2\u013aA\3\2\2\2\u013b\u013c\7S\2\2\u013cC\3\2\2\2\u013d\u013e\7T\2"+
		"\2\u013eE\3\2\2\2\u013f\u0140\7U\2\2\u0140G\3\2\2\2\u0141\u0142\7Z\2\2"+
		"\u0142I\3\2\2\2\u0143\u0144\7[\2\2\u0144K\3\2\2\2\u0145\u0146\7V\2\2\u0146"+
		"M\3\2\2\2\u0147\u0148\7W\2\2\u0148O\3\2\2\2\u0149\u014a\7c\2\2\u014aQ"+
		"\3\2\2\2\u014b\u014c\7d\2\2\u014cS\3\2\2\2\u014d\u014e\7e\2\2\u014eU\3"+
		"\2\2\2\u014f\u0150\7f\2\2\u0150W\3\2\2\2\u0151\u0152\7g\2\2\u0152Y\3\2"+
		"\2\2\u0153\u0154\7h\2\2\u0154[\3\2\2\2\u0155\u0156\7i\2\2\u0156]\3\2\2"+
		"\2\u0157\u0158\7k\2\2\u0158_\3\2\2\2\u0159\u015a\7o\2\2\u015aa\3\2\2\2"+
		"\u015b\u015c\7p\2\2\u015cc\3\2\2\2\u015d\u015e\7r\2\2\u015ee\3\2\2\2\u015f"+
		"\u0160\7t\2\2\u0160g\3\2\2\2\u0161\u0162\7u\2\2\u0162i\3\2\2\2\u0163\u0164"+
		"\7v\2\2\u0164k\3\2\2\2\u0165\u0166\7w\2\2\u0166m\3\2\2\2\u0167\u0168\7"+
		"x\2\2\u0168o\3\2\2\2\u0169\u016a\7z\2\2\u016aq\3\2\2\2\u016b\u016c\7{"+
		"\2\2\u016cs\3\2\2\2\u016d\u016e\7\62\2\2\u016eu\3\2\2\2\u016f\u0170\7"+
		"\63\2\2\u0170w\3\2\2\2\u0171\u0172\7\64\2\2\u0172y\3\2\2\2\u0173\u0174"+
		"\7\65\2\2\u0174{\3\2\2\2\u0175\u0176\7\66\2\2\u0176}\3\2\2\2\u0177\u0178"+
		"\7\67\2\2\u0178\177\3\2\2\2\u0179\u017a\78\2\2\u017a\u0081\3\2\2\2\u017b"+
		"\u017c\79\2\2\u017c\u0083\3\2\2\2\u017d\u017e\7:\2\2\u017e\u0085\3\2\2"+
		"\2\u017f\u0180\7;\2\2\u0180\u0087\3\2\2\2\u0181\u0182\5\4\2\2\u0182\u0089"+
		"\3\2\2\2\u0183\u0184\7]\2\2\u0184\u008b\3\2\2\2\u0185\u0186\7_\2\2\u0186"+
		"\u008d\3\2\2\2\u0187\u0188\7%\2\2\u0188\u008f\3\2\2\2\u0189\u018a\7-\2"+
		"\2\u018a\u0091\3\2\2\2\u018b\u018c\7/\2\2\u018c\u0093\3\2\2\2\u018d\u018e"+
		"\7?\2\2\u018e\u0095\3\2\2\2\u018f\u0190\7\60\2\2\u0190\u0097\3\2\2\2\u0191"+
		"\u0192\7~\2\2\u0192\u0099\3\2\2\2\u0193\u0194\7b\2\2\u0194\u009b\3\2\2"+
		"\2\u0195\u0196\7)\2\2\u0196\u009d\3\2\2\2\u0197\u0198\7`\2\2\u0198\u009f"+
		"\3\2\2\2\u0199\u019a\7\u0080\2\2\u019a\u00a1\3\2\2\2\u019b\u019c\7>\2"+
		"\2\u019c\u00a3\3\2\2\2\u019d\u019e\7@\2\2\u019e\u00a5\3\2\2\2\u019f\u01a0"+
		"\7\61\2\2\u01a0\u00a7\3\2\2\2\u01a1\u01a2\7^\2\2\u01a2\u00a9\3\2\2\2\u01a3"+
		"\u01a4\7a\2\2\u01a4\u00ab\3\2\2\2\u01a5\u01a6\7*\2\2\u01a6\u00ad\3\2\2"+
		"\2\u01a7\u01a8\7+\2\2\u01a8\u00af\3\2\2\2\u01a9\u01aa\7<\2\2\u01aa\u00b1"+
		"\3\2\2\2\u01ab\u01ac\7=\2\2\u01ac\u00b3\3\2\2\2\u01ad\u01ae\7.\2\2\u01ae"+
		"\u00b5\3\2\2\2\u01af\u01b0\7\u00b9\2\2\u01b0\u00b7\3\2\2\2\u01b1\u01b2"+
		"\7\"\2\2\u01b2\u00b9\3\2\2\2\u01b3\u01b4\7\13\2\2\u01b4\u01b5\b]\5\2\u01b5"+
		"\u00bb\3\2\2\2\u01b6\u01b8\7\17\2\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3"+
		"\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\7\f\2\2\u01ba\u01bb\b^\6\2\u01bb"+
		"\u00bd\3\2\2\2\u01bc\u01be\n\2\2\2\u01bd\u01bc\3\2\2\2\u01be\u01bf\3\2"+
		"\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"\u01c2\b_\7\2\u01c2\u00bf\3\2\2\2\u01c3\u01c4\7\13\2\2\u01c4\u01c5\b`"+
		"\b\2\u01c5\u00c1\3\2\2\2\u01c6\u01c8\7\17\2\2\u01c7\u01c6\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\7\f\2\2\u01ca\u01cb\ba"+
		"\t\2\u01cb\u00c3\3\2\2\2\7\2\3\u01b7\u01bf\u01c7\n\3\4\2\3\5\3\3\6\4\3"+
		"]\5\3^\6\4\2\2\3`\7\3a\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}