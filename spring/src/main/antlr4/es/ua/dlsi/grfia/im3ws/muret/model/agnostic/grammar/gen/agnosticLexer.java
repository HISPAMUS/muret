// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/spring/src/main/antlr4/es/ua/dlsi/grfia/im3ws/muret/model/agnostic/grammar/agnosticLexer.g4 by ANTLR 4.9.1

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
public class agnosticLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VERSION=1, TACCIDENTAL=2, TBRACKET=3, TCLEF=4, TCOLONT=5, TDIGIT=6, TMARK=7, 
		TMETERSIGN=8, TMULTIREST=9, TNOTE=10, TREST=11, TSLUR=12, TVERTICAL_LINE=13, 
		SEPSYMBOL=14, STACCIDENTALS=15, STMETERSIGNS=16, STCOMMON_FIGURES=17, 
		STMENSURAL_NOTE_FIGURES=18, STMENSURAL_REST_FIGURES=19, ST_START=20, ST_END=21, 
		ST_DOWN=22, ST_UP=23, COLON=24, CHAR_C=25, CHAR_F=26, CHAR_G=27, DIGIT_0=28, 
		DIGIT_1=29, DIGIT_2=30, DIGIT_3=31, DIGIT_4=32, DIGIT_5=33, DIGIT_6=34, 
		DIGIT_7=35, DIGIT_8=36, DIGIT_9=37, EOL=38, HYPHEN=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VERSION", "TACCIDENTAL", "TBRACKET", "TCLEF", "TCOLONT", "TDIGIT", "TMARK", 
			"TMETERSIGN", "TMULTIREST", "TNOTE", "TREST", "TSLUR", "TVERTICAL_LINE", 
			"SEPSYMBOL", "STACCIDENTALS", "STMETERSIGNS", "STCOMMON_FIGURES", "STMENSURAL_NOTE_FIGURES", 
			"STMENSURAL_REST_FIGURES", "ST_START", "ST_END", "ST_DOWN", "ST_UP", 
			"COLON", "CHAR_C", "CHAR_F", "CHAR_G", "DIGIT_0", "DIGIT_1", "DIGIT_2", 
			"DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", 
			"EOL", "HYPHEN", "DOT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'version'", "'accidental'", "'bracket'", "'clef'", "'colon'", 
			"'digit'", "'mark'", "'metersign'", "'multirest'", "'note'", "'rest'", 
			"'slur'", "'verticalLine'", null, null, null, null, null, null, "'start'", 
			"'end'", "'down'", "'up'", "':'", "'C'", "'F'", "'G'", "'0'", "'1'", 
			"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", null, "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VERSION", "TACCIDENTAL", "TBRACKET", "TCLEF", "TCOLONT", "TDIGIT", 
			"TMARK", "TMETERSIGN", "TMULTIREST", "TNOTE", "TREST", "TSLUR", "TVERTICAL_LINE", 
			"SEPSYMBOL", "STACCIDENTALS", "STMETERSIGNS", "STCOMMON_FIGURES", "STMENSURAL_NOTE_FIGURES", 
			"STMENSURAL_REST_FIGURES", "ST_START", "ST_END", "ST_DOWN", "ST_UP", 
			"COLON", "CHAR_C", "CHAR_F", "CHAR_G", "DIGIT_0", "DIGIT_1", "DIGIT_2", 
			"DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", 
			"EOL", "HYPHEN"
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


	public agnosticLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "agnosticLexer.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u022e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d3\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00eb\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u0151\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u01e0\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01f6"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3\'\5\'\u0227\n\'\3\'\3\'\3(\3(\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2\3"+
		"\2\2\2\u024c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3S\3\2\2\2\5"+
		"[\3\2\2\2\7f\3\2\2\2\tn\3\2\2\2\13s\3\2\2\2\ry\3\2\2\2\17\177\3\2\2\2"+
		"\21\u0084\3\2\2\2\23\u008e\3\2\2\2\25\u0098\3\2\2\2\27\u009d\3\2\2\2\31"+
		"\u00a2\3\2\2\2\33\u00a7\3\2\2\2\35\u00b4\3\2\2\2\37\u00d2\3\2\2\2!\u00ea"+
		"\3\2\2\2#\u0150\3\2\2\2%\u01df\3\2\2\2\'\u01f5\3\2\2\2)\u01f7\3\2\2\2"+
		"+\u01fd\3\2\2\2-\u0201\3\2\2\2/\u0206\3\2\2\2\61\u0209\3\2\2\2\63\u020b"+
		"\3\2\2\2\65\u020d\3\2\2\2\67\u020f\3\2\2\29\u0211\3\2\2\2;\u0213\3\2\2"+
		"\2=\u0215\3\2\2\2?\u0217\3\2\2\2A\u0219\3\2\2\2C\u021b\3\2\2\2E\u021d"+
		"\3\2\2\2G\u021f\3\2\2\2I\u0221\3\2\2\2K\u0223\3\2\2\2M\u0226\3\2\2\2O"+
		"\u022a\3\2\2\2Q\u022c\3\2\2\2ST\7x\2\2TU\7g\2\2UV\7t\2\2VW\7u\2\2WX\7"+
		"k\2\2XY\7q\2\2YZ\7p\2\2Z\4\3\2\2\2[\\\7c\2\2\\]\7e\2\2]^\7e\2\2^_\7k\2"+
		"\2_`\7f\2\2`a\7g\2\2ab\7p\2\2bc\7v\2\2cd\7c\2\2de\7n\2\2e\6\3\2\2\2fg"+
		"\7d\2\2gh\7t\2\2hi\7c\2\2ij\7e\2\2jk\7m\2\2kl\7g\2\2lm\7v\2\2m\b\3\2\2"+
		"\2no\7e\2\2op\7n\2\2pq\7g\2\2qr\7h\2\2r\n\3\2\2\2st\7e\2\2tu\7q\2\2uv"+
		"\7n\2\2vw\7q\2\2wx\7p\2\2x\f\3\2\2\2yz\7f\2\2z{\7k\2\2{|\7i\2\2|}\7k\2"+
		"\2}~\7v\2\2~\16\3\2\2\2\177\u0080\7o\2\2\u0080\u0081\7c\2\2\u0081\u0082"+
		"\7t\2\2\u0082\u0083\7m\2\2\u0083\20\3\2\2\2\u0084\u0085\7o\2\2\u0085\u0086"+
		"\7g\2\2\u0086\u0087\7v\2\2\u0087\u0088\7g\2\2\u0088\u0089\7t\2\2\u0089"+
		"\u008a\7u\2\2\u008a\u008b\7k\2\2\u008b\u008c\7i\2\2\u008c\u008d\7p\2\2"+
		"\u008d\22\3\2\2\2\u008e\u008f\7o\2\2\u008f\u0090\7w\2\2\u0090\u0091\7"+
		"n\2\2\u0091\u0092\7v\2\2\u0092\u0093\7k\2\2\u0093\u0094\7t\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u0096\7u\2\2\u0096\u0097\7v\2\2\u0097\24\3\2\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7q\2\2\u009a\u009b\7v\2\2\u009b\u009c\7g\2\2\u009c"+
		"\26\3\2\2\2\u009d\u009e\7t\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7u\2\2\u00a0"+
		"\u00a1\7v\2\2\u00a1\30\3\2\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7n\2\2\u00a4"+
		"\u00a5\7w\2\2\u00a5\u00a6\7t\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7x\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac\7k\2\2"+
		"\u00ac\u00ad\7e\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7n\2\2\u00af\u00b0"+
		"\7N\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\34\3\2\2\2\u00b4\u00b5\5Q)\2\u00b5\36\3\2\2\2\u00b6\u00b7\7h\2\2\u00b7"+
		"\u00b8\7n\2\2\u00b8\u00b9\7c\2\2\u00b9\u00d3\7v\2\2\u00ba\u00bb\7p\2\2"+
		"\u00bb\u00bc\7c\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7w\2\2\u00be\u00bf"+
		"\7t\2\2\u00bf\u00c0\7c\2\2\u00c0\u00d3\7n\2\2\u00c1\u00c2\7u\2\2\u00c2"+
		"\u00c3\7j\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7t\2\2\u00c5\u00d3\7r\2\2"+
		"\u00c6\u00c7\7f\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca"+
		"\7d\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7a\2\2\u00cd"+
		"\u00ce\7u\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7t\2\2"+
		"\u00d1\u00d3\7r\2\2\u00d2\u00b6\3\2\2\2\u00d2\u00ba\3\2\2\2\u00d2\u00c1"+
		"\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d3 \3\2\2\2\u00d4\u00d5\7E\2\2\u00d5\u00eb"+
		"\7v\2\2\u00d6\u00d7\7E\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9\7w\2\2\u00d9"+
		"\u00eb\7v\2\2\u00da\u00db\7E\2\2\u00db\u00eb\7\\\2\2\u00dc\u00dd\7E\2"+
		"\2\u00dd\u00de\7e\2\2\u00de\u00df\7w\2\2\u00df\u00e0\7v\2\2\u00e0\u00eb"+
		"\7\\\2\2\u00e1\u00eb\7Q\2\2\u00e2\u00e3\7Q\2\2\u00e3\u00e4\7f\2\2\u00e4"+
		"\u00e5\7q\2\2\u00e5\u00eb\7v\2\2\u00e6\u00e7\7E\2\2\u00e7\u00e8\7f\2\2"+
		"\u00e8\u00e9\7q\2\2\u00e9\u00eb\7v\2\2\u00ea\u00d4\3\2\2\2\u00ea\u00d6"+
		"\3\2\2\2\u00ea\u00da\3\2\2\2\u00ea\u00dc\3\2\2\2\u00ea\u00e1\3\2\2\2\u00ea"+
		"\u00e2\3\2\2\2\u00ea\u00e6\3\2\2\2\u00eb\"\3\2\2\2\u00ec\u00ed\7n\2\2"+
		"\u00ed\u00ee\7q\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7i\2\2\u00f0\u0151"+
		"\7c\2\2\u00f1\u00f2\7d\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7g\2\2\u00f4"+
		"\u00f5\7x\2\2\u00f5\u0151\7g\2\2\u00f6\u00f7\7y\2\2\u00f7\u00f8\7j\2\2"+
		"\u00f8\u00f9\7q\2\2\u00f9\u00fa\7n\2\2\u00fa\u0151\7g\2\2\u00fb\u00fc"+
		"\7j\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7n\2\2\u00fe\u0151\7h\2\2\u00ff"+
		"\u0100\7s\2\2\u0100\u0101\7w\2\2\u0101\u0102\7c\2\2\u0102\u0103\7t\2\2"+
		"\u0103\u0104\7v\2\2\u0104\u0105\7g\2\2\u0105\u0151\7t\2\2\u0106\u0107"+
		"\7g\2\2\u0107\u0108\7k\2\2\u0108\u0109\7i\2\2\u0109\u010a\7j\2\2\u010a"+
		"\u010b\7v\2\2\u010b\u0151\7j\2\2\u010c\u010d\7u\2\2\u010d\u010e\7k\2\2"+
		"\u010e\u010f\7z\2\2\u010f\u0110\7v\2\2\u0110\u0111\7g\2\2\u0111\u0112"+
		"\7g\2\2\u0112\u0113\7p\2\2\u0113\u0114\7v\2\2\u0114\u0151\7j\2\2\u0115"+
		"\u0116\7v\2\2\u0116\u0117\7j\2\2\u0117\u0118\7k\2\2\u0118\u0119\7t\2\2"+
		"\u0119\u011a\7v\2\2\u011a\u011b\7{\2\2\u011b\u011c\7U\2\2\u011c\u011d"+
		"\7g\2\2\u011d\u011e\7e\2\2\u011e\u011f\7q\2\2\u011f\u0120\7p\2\2\u0120"+
		"\u0151\7f\2\2\u0121\u0122\7u\2\2\u0122\u0123\7k\2\2\u0123\u0124\7z\2\2"+
		"\u0124\u0125\7v\2\2\u0125\u0126\7{\2\2\u0126\u0127\7H\2\2\u0127\u0128"+
		"\7q\2\2\u0128\u0129\7w\2\2\u0129\u012a\7t\2\2\u012a\u012b\7v\2\2\u012b"+
		"\u0151\7j\2\2\u012c\u012d\7j\2\2\u012d\u012e\7w\2\2\u012e\u012f\7p\2\2"+
		"\u012f\u0130\7f\2\2\u0130\u0131\7t\2\2\u0131\u0132\7g\2\2\u0132\u0133"+
		"\7f\2\2\u0133\u0134\7V\2\2\u0134\u0135\7y\2\2\u0135\u0136\7g\2\2\u0136"+
		"\u0137\7p\2\2\u0137\u0138\7v\2\2\u0138\u0139\7G\2\2\u0139\u013a\7k\2\2"+
		"\u013a\u013b\7i\2\2\u013b\u013c\7j\2\2\u013c\u013d\7v\2\2\u013d\u0151"+
		"\7j\2\2\u013e\u013f\7v\2\2\u013f\u0140\7y\2\2\u0140\u0141\7q\2\2\u0141"+
		"\u0142\7J\2\2\u0142\u0143\7w\2\2\u0143\u0144\7p\2\2\u0144\u0145\7f\2\2"+
		"\u0145\u0146\7t\2\2\u0146\u0147\7g\2\2\u0147\u0148\7f\2\2\u0148\u0149"+
		"\7H\2\2\u0149\u014a\7k\2\2\u014a\u014b\7h\2\2\u014b\u014c\7v\2\2\u014c"+
		"\u014d\7{\2\2\u014d\u014e\7U\2\2\u014e\u014f\7k\2\2\u014f\u0151\7z\2\2"+
		"\u0150\u00ec\3\2\2\2\u0150\u00f1\3\2\2\2\u0150\u00f6\3\2\2\2\u0150\u00fb"+
		"\3\2\2\2\u0150\u00ff\3\2\2\2\u0150\u0106\3\2\2\2\u0150\u010c\3\2\2\2\u0150"+
		"\u0115\3\2\2\2\u0150\u0121\3\2\2\2\u0150\u012c\3\2\2\2\u0150\u013e\3\2"+
		"\2\2\u0151$\3\2\2\2\u0152\u0153\7s\2\2\u0153\u0154\7w\2\2\u0154\u0155"+
		"\7c\2\2\u0155\u0156\7f\2\2\u0156\u0157\7t\2\2\u0157\u0158\7w\2\2\u0158"+
		"\u0159\7r\2\2\u0159\u015a\7n\2\2\u015a\u015b\7g\2\2\u015b\u015c\7Y\2\2"+
		"\u015c\u015d\7j\2\2\u015d\u015e\7q\2\2\u015e\u015f\7n\2\2\u015f\u0160"+
		"\7g\2\2\u0160\u0161\7U\2\2\u0161\u0162\7v\2\2\u0162\u0163\7g\2\2\u0163"+
		"\u01e0\7o\2\2\u0164\u0165\7v\2\2\u0165\u0166\7t\2\2\u0166\u0167\7k\2\2"+
		"\u0167\u0168\7r\2\2\u0168\u0169\7n\2\2\u0169\u016a\7g\2\2\u016a\u016b"+
		"\7Y\2\2\u016b\u016c\7j\2\2\u016c\u016d\7q\2\2\u016d\u016e\7n\2\2\u016e"+
		"\u016f\7g\2\2\u016f\u0170\7U\2\2\u0170\u0171\7v\2\2\u0171\u0172\7g\2\2"+
		"\u0172\u01e0\7o\2\2\u0173\u0174\7f\2\2\u0174\u0175\7q\2\2\u0175\u0176"+
		"\7w\2\2\u0176\u0177\7d\2\2\u0177\u0178\7n\2\2\u0178\u0179\7g\2\2\u0179"+
		"\u017a\7Y\2\2\u017a\u017b\7j\2\2\u017b\u017c\7q\2\2\u017c\u017d\7n\2\2"+
		"\u017d\u017e\7g\2\2\u017e\u017f\7U\2\2\u017f\u0180\7v\2\2\u0180\u0181"+
		"\7g\2\2\u0181\u01e0\7o\2\2\u0182\u0183\7f\2\2\u0183\u0184\7q\2\2\u0184"+
		"\u0185\7w\2\2\u0185\u0186\7d\2\2\u0186\u0187\7n\2\2\u0187\u0188\7g\2\2"+
		"\u0188\u0189\7Y\2\2\u0189\u018a\7j\2\2\u018a\u018b\7q\2\2\u018b\u018c"+
		"\7n\2\2\u018c\u018d\7g\2\2\u018d\u018e\7D\2\2\u018e\u018f\7n\2\2\u018f"+
		"\u0190\7c\2\2\u0190\u0191\7e\2\2\u0191\u0192\7m\2\2\u0192\u0193\7U\2\2"+
		"\u0193\u0194\7v\2\2\u0194\u0195\7g\2\2\u0195\u01e0\7o\2\2\u0196\u0197"+
		"\7f\2\2\u0197\u0198\7q\2\2\u0198\u0199\7w\2\2\u0199\u019a\7d\2\2\u019a"+
		"\u019b\7n\2\2\u019b\u019c\7g\2\2\u019c\u019d\7Y\2\2\u019d\u019e\7j\2\2"+
		"\u019e\u019f\7q\2\2\u019f\u01a0\7n\2\2\u01a0\u01e0\7g\2\2\u01a1\u01a2"+
		"\7n\2\2\u01a2\u01a3\7q\2\2\u01a3\u01a4\7p\2\2\u01a4\u01a5\7i\2\2\u01a5"+
		"\u01a6\7c\2\2\u01a6\u01a7\7D\2\2\u01a7\u01a8\7n\2\2\u01a8\u01a9\7c\2\2"+
		"\u01a9\u01aa\7e\2\2\u01aa\u01e0\7m\2\2\u01ab\u01ac\7d\2\2\u01ac\u01ad"+
		"\7t\2\2\u01ad\u01ae\7g\2\2\u01ae\u01af\7x\2\2\u01af\u01b0\7g\2\2\u01b0"+
		"\u01b1\7D\2\2\u01b1\u01b2\7n\2\2\u01b2\u01b3\7c\2\2\u01b3\u01b4\7e\2\2"+
		"\u01b4\u01e0\7m\2\2\u01b5\u01b6\7y\2\2\u01b6\u01b7\7j\2\2\u01b7\u01b8"+
		"\7q\2\2\u01b8\u01b9\7n\2\2\u01b9\u01ba\7g\2\2\u01ba\u01bb\7D\2\2\u01bb"+
		"\u01bc\7n\2\2\u01bc\u01bd\7c\2\2\u01bd\u01be\7e\2\2\u01be\u01e0\7m\2\2"+
		"\u01bf\u01c0\7g\2\2\u01c0\u01c1\7k\2\2\u01c1\u01c2\7i\2\2\u01c2\u01c3"+
		"\7j\2\2\u01c3\u01c4\7v\2\2\u01c4\u01c5\7j\2\2\u01c5\u01c6\7E\2\2\u01c6"+
		"\u01c7\7w\2\2\u01c7\u01e0\7v\2\2\u01c8\u01c9\7g\2\2\u01c9\u01ca\7k\2\2"+
		"\u01ca\u01cb\7i\2\2\u01cb\u01cc\7j\2\2\u01cc\u01cd\7v\2\2\u01cd\u01ce"+
		"\7j\2\2\u01ce\u01cf\7X\2\2\u01cf\u01d0\7q\2\2\u01d0\u01d1\7k\2\2\u01d1"+
		"\u01e0\7f\2\2\u01d2\u01d3\7u\2\2\u01d3\u01d4\7k\2\2\u01d4\u01d5\7z\2\2"+
		"\u01d5\u01d6\7v\2\2\u01d6\u01d7\7g\2\2\u01d7\u01d8\7g\2\2\u01d8\u01d9"+
		"\7p\2\2\u01d9\u01da\7v\2\2\u01da\u01db\7j\2\2\u01db\u01dc\7X\2\2\u01dc"+
		"\u01dd\7q\2\2\u01dd\u01de\7k\2\2\u01de\u01e0\7f\2\2\u01df\u0152\3\2\2"+
		"\2\u01df\u0164\3\2\2\2\u01df\u0173\3\2\2\2\u01df\u0182\3\2\2\2\u01df\u0196"+
		"\3\2\2\2\u01df\u01a1\3\2\2\2\u01df\u01ab\3\2\2\2\u01df\u01b5\3\2\2\2\u01df"+
		"\u01bf\3\2\2\2\u01df\u01c8\3\2\2\2\u01df\u01d2\3\2\2\2\u01e0&\3\2\2\2"+
		"\u01e1\u01e2\7u\2\2\u01e2\u01e3\7g\2\2\u01e3\u01e4\7o\2\2\u01e4\u01e5"+
		"\7k\2\2\u01e5\u01e6\7p\2\2\u01e6\u01e7\7k\2\2\u01e7\u01e8\7o\2\2\u01e8"+
		"\u01f6\7c\2\2\u01e9\u01ea\7h\2\2\u01ea\u01eb\7w\2\2\u01eb\u01ec\7u\2\2"+
		"\u01ec\u01f6\7c\2\2\u01ed\u01ee\7u\2\2\u01ee\u01ef\7g\2\2\u01ef\u01f0"+
		"\7o\2\2\u01f0\u01f1\7k\2\2\u01f1\u01f2\7h\2\2\u01f2\u01f3\7w\2\2\u01f3"+
		"\u01f4\7u\2\2\u01f4\u01f6\7c\2\2\u01f5\u01e1\3\2\2\2\u01f5\u01e9\3\2\2"+
		"\2\u01f5\u01ed\3\2\2\2\u01f6(\3\2\2\2\u01f7\u01f8\7u\2\2\u01f8\u01f9\7"+
		"v\2\2\u01f9\u01fa\7c\2\2\u01fa\u01fb\7t\2\2\u01fb\u01fc\7v\2\2\u01fc*"+
		"\3\2\2\2\u01fd\u01fe\7g\2\2\u01fe\u01ff\7p\2\2\u01ff\u0200\7f\2\2\u0200"+
		",\3\2\2\2\u0201\u0202\7f\2\2\u0202\u0203\7q\2\2\u0203\u0204\7y\2\2\u0204"+
		"\u0205\7p\2\2\u0205.\3\2\2\2\u0206\u0207\7w\2\2\u0207\u0208\7r\2\2\u0208"+
		"\60\3\2\2\2\u0209\u020a\7<\2\2\u020a\62\3\2\2\2\u020b\u020c\7E\2\2\u020c"+
		"\64\3\2\2\2\u020d\u020e\7H\2\2\u020e\66\3\2\2\2\u020f\u0210\7I\2\2\u0210"+
		"8\3\2\2\2\u0211\u0212\7\62\2\2\u0212:\3\2\2\2\u0213\u0214\7\63\2\2\u0214"+
		"<\3\2\2\2\u0215\u0216\7\64\2\2\u0216>\3\2\2\2\u0217\u0218\7\65\2\2\u0218"+
		"@\3\2\2\2\u0219\u021a\7\66\2\2\u021aB\3\2\2\2\u021b\u021c\7\67\2\2\u021c"+
		"D\3\2\2\2\u021d\u021e\78\2\2\u021eF\3\2\2\2\u021f\u0220\79\2\2\u0220H"+
		"\3\2\2\2\u0221\u0222\7:\2\2\u0222J\3\2\2\2\u0223\u0224\7;\2\2\u0224L\3"+
		"\2\2\2\u0225\u0227\7\17\2\2\u0226\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228\u0229\7\f\2\2\u0229N\3\2\2\2\u022a\u022b\7/\2\2\u022b"+
		"P\3\2\2\2\u022c\u022d\7\60\2\2\u022dR\3\2\2\2\t\2\u00d2\u00ea\u0150\u01df"+
		"\u01f5\u0226\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}