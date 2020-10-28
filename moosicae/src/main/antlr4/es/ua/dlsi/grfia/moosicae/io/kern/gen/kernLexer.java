// Generated from /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/moosicae/src/main/antlr4/es/ua/dlsi/grfia/moosicae/io/kern/kernLexer.g4 by ANTLR 4.8

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
public class kernLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EXCLAMATION=1, MENS=2, KERN=3, TEXT=4, HARM=5, ROOT=6, TANDEM_PART=7, 
		TANDEM_INSTRUMENT=8, TANDEM_STAFF=9, TANDEM_CLEF=10, TANDEM_CUSTOS=11, 
		TANDEM_KEY_SIGNATURE=12, TANDEM_MET=13, METRONOME=14, TANDEM_TIMESIGNATURE=15, 
		TANDEM_BEGIN_PLAIN_CHANT=16, TANDEM_END_PLAIN_CHANT=17, AT=18, CHAR_A=19, 
		CHAR_B=20, CHAR_C=21, CHAR_D=22, CHAR_E=23, CHAR_F=24, CHAR_G=25, CHAR_I=26, 
		CHAR_J=27, CHAR_K=28, CHAR_L=29, CHAR_M=30, CHAR_O=31, CHAR_P=32, CHAR_Q=33, 
		CHAR_R=34, CHAR_S=35, CHAR_X=36, CHAR_Y=37, CHAR_T=38, CHAR_U=39, CHAR_W=40, 
		CHAR_a=41, CHAR_b=42, CHAR_c=43, CHAR_d=44, CHAR_e=45, CHAR_f=46, CHAR_g=47, 
		CHAR_i=48, CHAR_k=49, CHAR_m=50, CHAR_n=51, CHAR_p=52, CHAR_r=53, CHAR_s=54, 
		CHAR_t=55, CHAR_u=56, CHAR_v=57, CHAR_w=58, CHAR_x=59, CHAR_y=60, DIGIT_0=61, 
		DIGIT_1=62, DIGIT_2=63, DIGIT_3=64, DIGIT_4=65, DIGIT_5=66, DIGIT_6=67, 
		DIGIT_7=68, DIGIT_8=69, DIGIT_9=70, ASTERISK=71, LEFT_BRACKET=72, RIGHT_BRACKET=73, 
		OCTOTHORPE=74, PLUS=75, MINUS=76, EQUAL=77, DOT=78, PIPE=79, GRAVE_ACCENT=80, 
		APOSTROPHE=81, CIRCUMFLEX=82, TILDE=83, ANGLE_BRACKET_OPEN=84, ANGLE_BRACKET_CLOSE=85, 
		SLASH=86, BACKSLASH=87, UNDERSCORE=88, LEFT_PARENTHESIS=89, RIGHT_PARENTHESIS=90, 
		COLON=91, SEMICOLON=92, COMMA=93, SEP=94, SPACE=95, TAB=96, EOL=97, METADATACOMMENT=98, 
		FIELDCCOMMENT=99, FIELD_TEXT=100, FREE_TEXT_TAB=101, FREE_TEXT_EOL=102;
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
			"ASTERISK_FRAGMENT", "EXCLAMATION", "MENS", "KERN", "TEXT", "HARM", "ROOT", 
			"TANDEM_PART", "TANDEM_INSTRUMENT", "TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", 
			"TANDEM_KEY_SIGNATURE", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", 
			"TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", 
			"CHAR_B", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", 
			"CHAR_J", "CHAR_K", "CHAR_L", "CHAR_M", "CHAR_O", "CHAR_P", "CHAR_Q", 
			"CHAR_R", "CHAR_S", "CHAR_X", "CHAR_Y", "CHAR_T", "CHAR_U", "CHAR_W", 
			"CHAR_a", "CHAR_b", "CHAR_c", "CHAR_d", "CHAR_e", "CHAR_f", "CHAR_g", 
			"CHAR_i", "CHAR_k", "CHAR_m", "CHAR_n", "CHAR_p", "CHAR_r", "CHAR_s", 
			"CHAR_t", "CHAR_u", "CHAR_v", "CHAR_w", "CHAR_x", "CHAR_y", "DIGIT_0", 
			"DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", 
			"DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", 
			"PLUS", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", 
			"CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", 
			"BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", 
			"SEMICOLON", "COMMA", "SEP", "SPACE", "TAB", "EOL", "METADATACOMMENT", 
			"FIELDCCOMMENT", "COMMENTTEXT", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'@'", "'A'", "'B'", "'C'", "'D'", 
			"'E'", "'F'", "'G'", "'I'", "'J'", "'K'", "'L'", "'M'", "'O'", "'P'", 
			"'Q'", "'R'", "'S'", "'X'", "'Y'", "'T'", "'U'", "'W'", "'a'", "'b'", 
			"'c'", "'d'", "'e'", "'f'", "'g'", "'i'", "'k'", "'m'", "'n'", "'p'", 
			"'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'0'", "'1'", 
			"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", null, "'['", 
			"']'", "'#'", "'+'", "'-'", "'='", "'.'", "'|'", "'`'", "'''", "'^'", 
			"'~'", "'<'", "'>'", "'/'", "'\\'", "'_'", "'('", "')'", "':'", "';'", 
			"','", "'\u00B7'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EXCLAMATION", "MENS", "KERN", "TEXT", "HARM", "ROOT", "TANDEM_PART", 
			"TANDEM_INSTRUMENT", "TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", 
			"TANDEM_KEY_SIGNATURE", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", 
			"TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", "AT", "CHAR_A", 
			"CHAR_B", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", "CHAR_I", 
			"CHAR_J", "CHAR_K", "CHAR_L", "CHAR_M", "CHAR_O", "CHAR_P", "CHAR_Q", 
			"CHAR_R", "CHAR_S", "CHAR_X", "CHAR_Y", "CHAR_T", "CHAR_U", "CHAR_W", 
			"CHAR_a", "CHAR_b", "CHAR_c", "CHAR_d", "CHAR_e", "CHAR_f", "CHAR_g", 
			"CHAR_i", "CHAR_k", "CHAR_m", "CHAR_n", "CHAR_p", "CHAR_r", "CHAR_s", 
			"CHAR_t", "CHAR_u", "CHAR_v", "CHAR_w", "CHAR_x", "CHAR_y", "DIGIT_0", 
			"DIGIT_1", "DIGIT_2", "DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", 
			"DIGIT_8", "DIGIT_9", "ASTERISK", "LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", 
			"PLUS", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "APOSTROPHE", 
			"CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", 
			"BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", 
			"SEMICOLON", "COMMA", "SEP", "SPACE", "TAB", "EOL", "METADATACOMMENT", 
			"FIELDCCOMMENT", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
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



	public kernLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "kernLexer.g4"; }

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
			MENS_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			KERN_action((RuleContext)_localctx, actionIndex);
			break;
		case 4:
			TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		case 5:
			HARM_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			ROOT_action((RuleContext)_localctx, actionIndex);
			break;
		case 96:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 97:
			EOL_action((RuleContext)_localctx, actionIndex);
			break;
		case 102:
			FREE_TEXT_TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 103:
			FREE_TEXT_EOL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void MENS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			addMusicSpine();
			break;
		}
	}
	private void KERN_action(RuleContext _localctx, int actionIndex) {
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
	private void HARM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			addTextSpine();
			break;
		}
	}
	private void ROOT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			addTextSpine();
			break;
		}
	}
	private void TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			incSpine();
			break;
		}
	}
	private void EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			resetSpineAndMode();
			break;
		}
	}
	private void FREE_TEXT_TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			incSpine();
			break;
		}
	}
	private void FREE_TEXT_EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			resetSpineAndMode();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2h\u0200\b\1\b\1\4"+
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
		"\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3"+
		"<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3"+
		"H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3"+
		"S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^"+
		"\3_\3_\3`\3`\3a\3a\3b\3b\3b\3c\5c\u01dd\nc\3c\3c\3c\3d\3d\3d\3d\3d\3d"+
		"\3e\3e\5e\u01ea\ne\3f\6f\u01ed\nf\rf\16f\u01ee\3g\6g\u01f2\ng\rg\16g\u01f3"+
		"\3g\3g\3h\3h\3h\3i\5i\u01fc\ni\3i\3i\3i\2\2j\4\2\6\3\b\4\n\5\f\6\16\7"+
		"\20\b\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25,"+
		"\26.\27\60\30\62\31\64\32\66\338\34:\35<\36>\37@ B!D\"F#H$J%L&N\'P(R)"+
		"T*V+X,Z-\\.^/`\60b\61d\62f\63h\64j\65l\66n\67p8r9t:v;x<z=|>~?\u0080@\u0082"+
		"A\u0084B\u0086C\u0088D\u008aE\u008cF\u008eG\u0090H\u0092I\u0094J\u0096"+
		"K\u0098L\u009aM\u009cN\u009eO\u00a0P\u00a2Q\u00a4R\u00a6S\u00a8T\u00aa"+
		"U\u00acV\u00aeW\u00b0X\u00b2Y\u00b4Z\u00b6[\u00b8\\\u00ba]\u00bc^\u00be"+
		"_\u00c0`\u00c2a\u00c4b\u00c6c\u00c8d\u00cae\u00cc\2\u00cef\u00d0g\u00d2"+
		"h\4\2\3\4\6\2\13\f\17\17##~~\4\2\13\f\17\17\2\u0201\2\6\3\2\2\2\2\b\3"+
		"\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2"+
		"\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36"+
		"\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3"+
		"\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2"+
		"\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B"+
		"\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2"+
		"\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2"+
		"\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2"+
		"h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3"+
		"\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080"+
		"\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2"+
		"\2\2\u008a\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090\3\2\2\2\2\u0092"+
		"\3\2\2\2\2\u0094\3\2\2\2\2\u0096\3\2\2\2\2\u0098\3\2\2\2\2\u009a\3\2\2"+
		"\2\2\u009c\3\2\2\2\2\u009e\3\2\2\2\2\u00a0\3\2\2\2\2\u00a2\3\2\2\2\2\u00a4"+
		"\3\2\2\2\2\u00a6\3\2\2\2\2\u00a8\3\2\2\2\2\u00aa\3\2\2\2\2\u00ac\3\2\2"+
		"\2\2\u00ae\3\2\2\2\2\u00b0\3\2\2\2\2\u00b2\3\2\2\2\2\u00b4\3\2\2\2\2\u00b6"+
		"\3\2\2\2\2\u00b8\3\2\2\2\2\u00ba\3\2\2\2\2\u00bc\3\2\2\2\2\u00be\3\2\2"+
		"\2\2\u00c0\3\2\2\2\2\u00c2\3\2\2\2\2\u00c4\3\2\2\2\2\u00c6\3\2\2\2\2\u00c8"+
		"\3\2\2\2\2\u00ca\3\2\2\2\3\u00ce\3\2\2\2\3\u00d0\3\2\2\2\3\u00d2\3\2\2"+
		"\2\4\u00d4\3\2\2\2\6\u00d6\3\2\2\2\b\u00d8\3\2\2\2\n\u00e1\3\2\2\2\f\u00ea"+
		"\3\2\2\2\16\u00f3\3\2\2\2\20\u00fc\3\2\2\2\22\u0105\3\2\2\2\24\u010b\3"+
		"\2\2\2\26\u010e\3\2\2\2\30\u0115\3\2\2\2\32\u011b\3\2\2\2\34\u0123\3\2"+
		"\2\2\36\u0126\3\2\2\2 \u012b\3\2\2\2\"\u012f\3\2\2\2$\u0132\3\2\2\2&\u0137"+
		"\3\2\2\2(\u013c\3\2\2\2*\u013e\3\2\2\2,\u0140\3\2\2\2.\u0142\3\2\2\2\60"+
		"\u0144\3\2\2\2\62\u0146\3\2\2\2\64\u0148\3\2\2\2\66\u014a\3\2\2\28\u014c"+
		"\3\2\2\2:\u014e\3\2\2\2<\u0150\3\2\2\2>\u0152\3\2\2\2@\u0154\3\2\2\2B"+
		"\u0156\3\2\2\2D\u0158\3\2\2\2F\u015a\3\2\2\2H\u015c\3\2\2\2J\u015e\3\2"+
		"\2\2L\u0160\3\2\2\2N\u0162\3\2\2\2P\u0164\3\2\2\2R\u0166\3\2\2\2T\u0168"+
		"\3\2\2\2V\u016a\3\2\2\2X\u016c\3\2\2\2Z\u016e\3\2\2\2\\\u0170\3\2\2\2"+
		"^\u0172\3\2\2\2`\u0174\3\2\2\2b\u0176\3\2\2\2d\u0178\3\2\2\2f\u017a\3"+
		"\2\2\2h\u017c\3\2\2\2j\u017e\3\2\2\2l\u0180\3\2\2\2n\u0182\3\2\2\2p\u0184"+
		"\3\2\2\2r\u0186\3\2\2\2t\u0188\3\2\2\2v\u018a\3\2\2\2x\u018c\3\2\2\2z"+
		"\u018e\3\2\2\2|\u0190\3\2\2\2~\u0192\3\2\2\2\u0080\u0194\3\2\2\2\u0082"+
		"\u0196\3\2\2\2\u0084\u0198\3\2\2\2\u0086\u019a\3\2\2\2\u0088\u019c\3\2"+
		"\2\2\u008a\u019e\3\2\2\2\u008c\u01a0\3\2\2\2\u008e\u01a2\3\2\2\2\u0090"+
		"\u01a4\3\2\2\2\u0092\u01a6\3\2\2\2\u0094\u01a8\3\2\2\2\u0096\u01aa\3\2"+
		"\2\2\u0098\u01ac\3\2\2\2\u009a\u01ae\3\2\2\2\u009c\u01b0\3\2\2\2\u009e"+
		"\u01b2\3\2\2\2\u00a0\u01b4\3\2\2\2\u00a2\u01b6\3\2\2\2\u00a4\u01b8\3\2"+
		"\2\2\u00a6\u01ba\3\2\2\2\u00a8\u01bc\3\2\2\2\u00aa\u01be\3\2\2\2\u00ac"+
		"\u01c0\3\2\2\2\u00ae\u01c2\3\2\2\2\u00b0\u01c4\3\2\2\2\u00b2\u01c6\3\2"+
		"\2\2\u00b4\u01c8\3\2\2\2\u00b6\u01ca\3\2\2\2\u00b8\u01cc\3\2\2\2\u00ba"+
		"\u01ce\3\2\2\2\u00bc\u01d0\3\2\2\2\u00be\u01d2\3\2\2\2\u00c0\u01d4\3\2"+
		"\2\2\u00c2\u01d6\3\2\2\2\u00c4\u01d8\3\2\2\2\u00c6\u01dc\3\2\2\2\u00c8"+
		"\u01e1\3\2\2\2\u00ca\u01e7\3\2\2\2\u00cc\u01ec\3\2\2\2\u00ce\u01f1\3\2"+
		"\2\2\u00d0\u01f7\3\2\2\2\u00d2\u01fb\3\2\2\2\u00d4\u00d5\7,\2\2\u00d5"+
		"\5\3\2\2\2\u00d6\u00d7\7#\2\2\u00d7\7\3\2\2\2\u00d8\u00d9\5\4\2\2\u00d9"+
		"\u00da\5\4\2\2\u00da\u00db\7o\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7p\2"+
		"\2\u00dd\u00de\7u\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b\4\2\2\u00e0\t"+
		"\3\2\2\2\u00e1\u00e2\5\4\2\2\u00e2\u00e3\5\4\2\2\u00e3\u00e4\7m\2\2\u00e4"+
		"\u00e5\7g\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8\3\2\2"+
		"\2\u00e8\u00e9\b\5\3\2\u00e9\13\3\2\2\2\u00ea\u00eb\5\4\2\2\u00eb\u00ec"+
		"\5\4\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7z\2\2\u00ef"+
		"\u00f0\7v\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\6\4\2\u00f2\r\3\2\2\2"+
		"\u00f3\u00f4\5\4\2\2\u00f4\u00f5\5\4\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7"+
		"\7c\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7o\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\b\7\5\2\u00fb\17\3\2\2\2\u00fc\u00fd\5\4\2\2\u00fd\u00fe\5\4\2"+
		"\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7q\2\2\u0101\u0102"+
		"\7v\2\2\u0102\u0103\3\2\2\2\u0103\u0104\b\b\6\2\u0104\21\3\2\2\2\u0105"+
		"\u0106\5\4\2\2\u0106\u0107\7r\2\2\u0107\u0108\7c\2\2\u0108\u0109\7t\2"+
		"\2\u0109\u010a\7v\2\2\u010a\23\3\2\2\2\u010b\u010c\5\4\2\2\u010c\u010d"+
		"\58\34\2\u010d\25\3\2\2\2\u010e\u010f\5\4\2\2\u010f\u0110\7u\2\2\u0110"+
		"\u0111\7v\2\2\u0111\u0112\7c\2\2\u0112\u0113\7h\2\2\u0113\u0114\7h\2\2"+
		"\u0114\27\3\2\2\2\u0115\u0116\5\4\2\2\u0116\u0117\7e\2\2\u0117\u0118\7"+
		"n\2\2\u0118\u0119\7g\2\2\u0119\u011a\7h\2\2\u011a\31\3\2\2\2\u011b\u011c"+
		"\5\4\2\2\u011c\u011d\7e\2\2\u011d\u011e\7w\2\2\u011e\u011f\7u\2\2\u011f"+
		"\u0120\7v\2\2\u0120\u0121\7q\2\2\u0121\u0122\7u\2\2\u0122\33\3\2\2\2\u0123"+
		"\u0124\5\4\2\2\u0124\u0125\7m\2\2\u0125\35\3\2\2\2\u0126\u0127\5\4\2\2"+
		"\u0127\u0128\7o\2\2\u0128\u0129\7g\2\2\u0129\u012a\7v\2\2\u012a\37\3\2"+
		"\2\2\u012b\u012c\5\4\2\2\u012c\u012d\7O\2\2\u012d\u012e\7O\2\2\u012e!"+
		"\3\2\2\2\u012f\u0130\5\4\2\2\u0130\u0131\7O\2\2\u0131#\3\2\2\2\u0132\u0133"+
		"\5\4\2\2\u0133\u0134\7d\2\2\u0134\u0135\7r\2\2\u0135\u0136\7e\2\2\u0136"+
		"%\3\2\2\2\u0137\u0138\5\4\2\2\u0138\u0139\7g\2\2\u0139\u013a\7r\2\2\u013a"+
		"\u013b\7e\2\2\u013b\'\3\2\2\2\u013c\u013d\7B\2\2\u013d)\3\2\2\2\u013e"+
		"\u013f\7C\2\2\u013f+\3\2\2\2\u0140\u0141\7D\2\2\u0141-\3\2\2\2\u0142\u0143"+
		"\7E\2\2\u0143/\3\2\2\2\u0144\u0145\7F\2\2\u0145\61\3\2\2\2\u0146\u0147"+
		"\7G\2\2\u0147\63\3\2\2\2\u0148\u0149\7H\2\2\u0149\65\3\2\2\2\u014a\u014b"+
		"\7I\2\2\u014b\67\3\2\2\2\u014c\u014d\7K\2\2\u014d9\3\2\2\2\u014e\u014f"+
		"\7L\2\2\u014f;\3\2\2\2\u0150\u0151\7M\2\2\u0151=\3\2\2\2\u0152\u0153\7"+
		"N\2\2\u0153?\3\2\2\2\u0154\u0155\7O\2\2\u0155A\3\2\2\2\u0156\u0157\7Q"+
		"\2\2\u0157C\3\2\2\2\u0158\u0159\7R\2\2\u0159E\3\2\2\2\u015a\u015b\7S\2"+
		"\2\u015bG\3\2\2\2\u015c\u015d\7T\2\2\u015dI\3\2\2\2\u015e\u015f\7U\2\2"+
		"\u015fK\3\2\2\2\u0160\u0161\7Z\2\2\u0161M\3\2\2\2\u0162\u0163\7[\2\2\u0163"+
		"O\3\2\2\2\u0164\u0165\7V\2\2\u0165Q\3\2\2\2\u0166\u0167\7W\2\2\u0167S"+
		"\3\2\2\2\u0168\u0169\7Y\2\2\u0169U\3\2\2\2\u016a\u016b\7c\2\2\u016bW\3"+
		"\2\2\2\u016c\u016d\7d\2\2\u016dY\3\2\2\2\u016e\u016f\7e\2\2\u016f[\3\2"+
		"\2\2\u0170\u0171\7f\2\2\u0171]\3\2\2\2\u0172\u0173\7g\2\2\u0173_\3\2\2"+
		"\2\u0174\u0175\7h\2\2\u0175a\3\2\2\2\u0176\u0177\7i\2\2\u0177c\3\2\2\2"+
		"\u0178\u0179\7k\2\2\u0179e\3\2\2\2\u017a\u017b\7m\2\2\u017bg\3\2\2\2\u017c"+
		"\u017d\7o\2\2\u017di\3\2\2\2\u017e\u017f\7p\2\2\u017fk\3\2\2\2\u0180\u0181"+
		"\7r\2\2\u0181m\3\2\2\2\u0182\u0183\7t\2\2\u0183o\3\2\2\2\u0184\u0185\7"+
		"u\2\2\u0185q\3\2\2\2\u0186\u0187\7v\2\2\u0187s\3\2\2\2\u0188\u0189\7w"+
		"\2\2\u0189u\3\2\2\2\u018a\u018b\7x\2\2\u018bw\3\2\2\2\u018c\u018d\7y\2"+
		"\2\u018dy\3\2\2\2\u018e\u018f\7z\2\2\u018f{\3\2\2\2\u0190\u0191\7{\2\2"+
		"\u0191}\3\2\2\2\u0192\u0193\7\62\2\2\u0193\177\3\2\2\2\u0194\u0195\7\63"+
		"\2\2\u0195\u0081\3\2\2\2\u0196\u0197\7\64\2\2\u0197\u0083\3\2\2\2\u0198"+
		"\u0199\7\65\2\2\u0199\u0085\3\2\2\2\u019a\u019b\7\66\2\2\u019b\u0087\3"+
		"\2\2\2\u019c\u019d\7\67\2\2\u019d\u0089\3\2\2\2\u019e\u019f\78\2\2\u019f"+
		"\u008b\3\2\2\2\u01a0\u01a1\79\2\2\u01a1\u008d\3\2\2\2\u01a2\u01a3\7:\2"+
		"\2\u01a3\u008f\3\2\2\2\u01a4\u01a5\7;\2\2\u01a5\u0091\3\2\2\2\u01a6\u01a7"+
		"\5\4\2\2\u01a7\u0093\3\2\2\2\u01a8\u01a9\7]\2\2\u01a9\u0095\3\2\2\2\u01aa"+
		"\u01ab\7_\2\2\u01ab\u0097\3\2\2\2\u01ac\u01ad\7%\2\2\u01ad\u0099\3\2\2"+
		"\2\u01ae\u01af\7-\2\2\u01af\u009b\3\2\2\2\u01b0\u01b1\7/\2\2\u01b1\u009d"+
		"\3\2\2\2\u01b2\u01b3\7?\2\2\u01b3\u009f\3\2\2\2\u01b4\u01b5\7\60\2\2\u01b5"+
		"\u00a1\3\2\2\2\u01b6\u01b7\7~\2\2\u01b7\u00a3\3\2\2\2\u01b8\u01b9\7b\2"+
		"\2\u01b9\u00a5\3\2\2\2\u01ba\u01bb\7)\2\2\u01bb\u00a7\3\2\2\2\u01bc\u01bd"+
		"\7`\2\2\u01bd\u00a9\3\2\2\2\u01be\u01bf\7\u0080\2\2\u01bf\u00ab\3\2\2"+
		"\2\u01c0\u01c1\7>\2\2\u01c1\u00ad\3\2\2\2\u01c2\u01c3\7@\2\2\u01c3\u00af"+
		"\3\2\2\2\u01c4\u01c5\7\61\2\2\u01c5\u00b1\3\2\2\2\u01c6\u01c7\7^\2\2\u01c7"+
		"\u00b3\3\2\2\2\u01c8\u01c9\7a\2\2\u01c9\u00b5\3\2\2\2\u01ca\u01cb\7*\2"+
		"\2\u01cb\u00b7\3\2\2\2\u01cc\u01cd\7+\2\2\u01cd\u00b9\3\2\2\2\u01ce\u01cf"+
		"\7<\2\2\u01cf\u00bb\3\2\2\2\u01d0\u01d1\7=\2\2\u01d1\u00bd\3\2\2\2\u01d2"+
		"\u01d3\7.\2\2\u01d3\u00bf\3\2\2\2\u01d4\u01d5\7\u00b9\2\2\u01d5\u00c1"+
		"\3\2\2\2\u01d6\u01d7\7\"\2\2\u01d7\u00c3\3\2\2\2\u01d8\u01d9\7\13\2\2"+
		"\u01d9\u01da\bb\7\2\u01da\u00c5\3\2\2\2\u01db\u01dd\7\17\2\2\u01dc\u01db"+
		"\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\7\f\2\2\u01df"+
		"\u01e0\bc\b\2\u01e0\u00c7\3\2\2\2\u01e1\u01e2\7#\2\2\u01e2\u01e3\7#\2"+
		"\2\u01e3\u01e4\7#\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\5\u00ccf\2\u01e6"+
		"\u00c9\3\2\2\2\u01e7\u01e9\5\6\3\2\u01e8\u01ea\5\u00ccf\2\u01e9\u01e8"+
		"\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u00cb\3\2\2\2\u01eb\u01ed\n\2\2\2\u01ec"+
		"\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2"+
		"\2\2\u01ef\u00cd\3\2\2\2\u01f0\u01f2\n\3\2\2\u01f1\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\3\2"+
		"\2\2\u01f5\u01f6\bg\t\2\u01f6\u00cf\3\2\2\2\u01f7\u01f8\7\13\2\2\u01f8"+
		"\u01f9\bh\n\2\u01f9\u00d1\3\2\2\2\u01fa\u01fc\7\17\2\2\u01fb\u01fa\3\2"+
		"\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7\f\2\2\u01fe"+
		"\u01ff\bi\13\2\u01ff\u00d3\3\2\2\2\t\2\3\u01dc\u01e9\u01ee\u01f3\u01fb"+
		"\f\3\4\2\3\5\3\3\6\4\3\7\5\3\b\6\3b\7\3c\b\4\2\2\3h\t\3i\n";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}