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
		EXCLAMATION=1, MENS=2, KERN=3, TEXT=4, HARM=5, MXHM=6, ROOT=7, DYN=8, 
		DYNAM=9, SPINE_TERMINATOR=10, SPINE_ADD=11, SPINE_SPLIT=12, SPINE_JOIN=13, 
		TANDEM_PART=14, TANDEM_STAFF=15, TANDEM_CLEF=16, TANDEM_CUSTOS=17, TANDEM_KEY_SIGNATURE=18, 
		TANDEM_MET=19, METRONOME=20, TANDEM_TIMESIGNATURE=21, TANDEM_BEGIN_PLAIN_CHANT=22, 
		TANDEM_END_PLAIN_CHANT=23, LAYOUT=24, OCTAVE_UP_START=25, OCTAVE_UP_END=26, 
		OCTAVE_DOWN_START=27, OCTAVE_DOWN_END=28, PERCENT=29, AT=30, CHAR_A=31, 
		CHAR_B=32, CHAR_C=33, CHAR_D=34, CHAR_E=35, CHAR_F=36, CHAR_G=37, CHAR_H=38, 
		CHAR_I=39, CHAR_J=40, CHAR_K=41, CHAR_L=42, CHAR_M=43, CHAR_N=44, CHAR_O=45, 
		CHAR_P=46, CHAR_Q=47, CHAR_R=48, CHAR_S=49, CHAR_T=50, CHAR_U=51, CHAR_V=52, 
		CHAR_W=53, CHAR_X=54, CHAR_Y=55, CHAR_Z=56, CHAR_a=57, CHAR_b=58, CHAR_c=59, 
		CHAR_d=60, CHAR_e=61, CHAR_f=62, CHAR_g=63, CHAR_h=64, CHAR_i=65, CHAR_j=66, 
		CHAR_k=67, CHAR_l=68, CHAR_m=69, CHAR_n=70, CHAR_o=71, CHAR_p=72, CHAR_q=73, 
		CHAR_r=74, CHAR_s=75, CHAR_t=76, CHAR_u=77, CHAR_v=78, CHAR_w=79, CHAR_x=80, 
		CHAR_y=81, CHAR_z=82, NON_ENGLISH=83, DIGIT_0=84, DIGIT_1=85, DIGIT_2=86, 
		DIGIT_3=87, DIGIT_4=88, DIGIT_5=89, DIGIT_6=90, DIGIT_7=91, DIGIT_8=92, 
		DIGIT_9=93, ASTERISK=94, QUOTATION_MARK=95, APOSTROPHE=96, LEFT_BRACKET=97, 
		RIGHT_BRACKET=98, OCTOTHORPE=99, PLUS=100, MINUS=101, EQUAL=102, DOT=103, 
		PIPE=104, GRAVE_ACCENT=105, CIRCUMFLEX=106, TILDE=107, ANGLE_BRACKET_OPEN=108, 
		ANGLE_BRACKET_CLOSE=109, SLASH=110, BACKSLASH=111, UNDERSCORE=112, LEFT_PARENTHESIS=113, 
		RIGHT_PARENTHESIS=114, COLON=115, SEMICOLON=116, COMMA=117, SEP=118, QUESTION_MARK=119, 
		SPACE=120, TAB=121, EOL=122, INSTRUMENT=123, METACOMMENT=124, FIELDCOMMENT=125, 
		ANY=126, FIELD_TEXT=127, FREE_TEXT_TAB=128, FREE_TEXT_EOL=129;
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
			"ASTERISK_FRAGMENT", "EXCLAMATION", "MENS", "KERN", "TEXT", "HARM", "MXHM", 
			"ROOT", "DYN", "DYNAM", "SPINE_TERMINATOR", "SPINE_ADD", "SPINE_SPLIT", 
			"SPINE_JOIN", "TANDEM_PART", "TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", 
			"TANDEM_KEY_SIGNATURE", "TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", 
			"TANDEM_BEGIN_PLAIN_CHANT", "TANDEM_END_PLAIN_CHANT", "LAYOUT", "OCTAVE_UP_START", 
			"OCTAVE_UP_END", "OCTAVE_DOWN_START", "OCTAVE_DOWN_END", "PERCENT", "AT", 
			"CHAR_A", "CHAR_B", "CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", 
			"CHAR_H", "CHAR_I", "CHAR_J", "CHAR_K", "CHAR_L", "CHAR_M", "CHAR_N", 
			"CHAR_O", "CHAR_P", "CHAR_Q", "CHAR_R", "CHAR_S", "CHAR_T", "CHAR_U", 
			"CHAR_V", "CHAR_W", "CHAR_X", "CHAR_Y", "CHAR_Z", "CHAR_a", "CHAR_b", 
			"CHAR_c", "CHAR_d", "CHAR_e", "CHAR_f", "CHAR_g", "CHAR_h", "CHAR_i", 
			"CHAR_j", "CHAR_k", "CHAR_l", "CHAR_m", "CHAR_n", "CHAR_o", "CHAR_p", 
			"CHAR_q", "CHAR_r", "CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", "CHAR_w", 
			"CHAR_x", "CHAR_y", "CHAR_z", "NON_ENGLISH", "DIGIT_0", "DIGIT_1", "DIGIT_2", 
			"DIGIT_3", "DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", 
			"ASTERISK", "QUOTATION_MARK", "APOSTROPHE", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"OCTOTHORPE", "PLUS", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", 
			"CIRCUMFLEX", "TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", 
			"BACKSLASH", "UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", 
			"SEMICOLON", "COMMA", "SEP", "QUESTION_MARK", "SPACE", "TAB", "EOL", 
			"INSTRUMENT", "METACOMMENT", "FIELDCOMMENT", "RAW_TEXT", "RAW_TEXT_NOT_BARLINE", 
			"ANY", "FIELD_TEXT", "FREE_TEXT_TAB", "FREE_TEXT_EOL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'8va'", "'X8va'", "'8ba'", "'X8ba'", "'%'", "'@'", "'A'", "'B'", 
			"'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", 
			"'M'", "'N'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'T'", "'U'", "'V'", 
			"'W'", "'X'", "'Y'", "'Z'", "'a'", "'b'", "'c'", "'d'", "'e'", "'f'", 
			"'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'", "'n'", "'o'", "'p'", 
			"'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'z'", 
			null, "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", 
			"'9'", null, "'\"'", "'''", "'['", "']'", "'#'", "'+'", "'-'", "'='", 
			"'.'", "'|'", "'`'", "'^'", "'~'", "'<'", "'>'", "'/'", "'\\'", "'_'", 
			"'('", "')'", "':'", "';'", "','", "'\u00B7'", "'?'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EXCLAMATION", "MENS", "KERN", "TEXT", "HARM", "MXHM", "ROOT", 
			"DYN", "DYNAM", "SPINE_TERMINATOR", "SPINE_ADD", "SPINE_SPLIT", "SPINE_JOIN", 
			"TANDEM_PART", "TANDEM_STAFF", "TANDEM_CLEF", "TANDEM_CUSTOS", "TANDEM_KEY_SIGNATURE", 
			"TANDEM_MET", "METRONOME", "TANDEM_TIMESIGNATURE", "TANDEM_BEGIN_PLAIN_CHANT", 
			"TANDEM_END_PLAIN_CHANT", "LAYOUT", "OCTAVE_UP_START", "OCTAVE_UP_END", 
			"OCTAVE_DOWN_START", "OCTAVE_DOWN_END", "PERCENT", "AT", "CHAR_A", "CHAR_B", 
			"CHAR_C", "CHAR_D", "CHAR_E", "CHAR_F", "CHAR_G", "CHAR_H", "CHAR_I", 
			"CHAR_J", "CHAR_K", "CHAR_L", "CHAR_M", "CHAR_N", "CHAR_O", "CHAR_P", 
			"CHAR_Q", "CHAR_R", "CHAR_S", "CHAR_T", "CHAR_U", "CHAR_V", "CHAR_W", 
			"CHAR_X", "CHAR_Y", "CHAR_Z", "CHAR_a", "CHAR_b", "CHAR_c", "CHAR_d", 
			"CHAR_e", "CHAR_f", "CHAR_g", "CHAR_h", "CHAR_i", "CHAR_j", "CHAR_k", 
			"CHAR_l", "CHAR_m", "CHAR_n", "CHAR_o", "CHAR_p", "CHAR_q", "CHAR_r", 
			"CHAR_s", "CHAR_t", "CHAR_u", "CHAR_v", "CHAR_w", "CHAR_x", "CHAR_y", 
			"CHAR_z", "NON_ENGLISH", "DIGIT_0", "DIGIT_1", "DIGIT_2", "DIGIT_3", 
			"DIGIT_4", "DIGIT_5", "DIGIT_6", "DIGIT_7", "DIGIT_8", "DIGIT_9", "ASTERISK", 
			"QUOTATION_MARK", "APOSTROPHE", "LEFT_BRACKET", "RIGHT_BRACKET", "OCTOTHORPE", 
			"PLUS", "MINUS", "EQUAL", "DOT", "PIPE", "GRAVE_ACCENT", "CIRCUMFLEX", 
			"TILDE", "ANGLE_BRACKET_OPEN", "ANGLE_BRACKET_CLOSE", "SLASH", "BACKSLASH", 
			"UNDERSCORE", "LEFT_PARENTHESIS", "RIGHT_PARENTHESIS", "COLON", "SEMICOLON", 
			"COMMA", "SEP", "QUESTION_MARK", "SPACE", "TAB", "EOL", "INSTRUMENT", 
			"METACOMMENT", "FIELDCOMMENT", "ANY", "FIELD_TEXT", "FREE_TEXT_TAB", 
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
	    private void decSpine() {
	        currentSpine--;
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
	    public void addSpine() {
	        textSpines.add(textSpines.get(currentSpine)); // add a spine of the same type as current one
	    }

	    public void removeSpine() {
	        textSpines.remove(currentSpine);
	        decSpine(); // because we have removed it
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
			MXHM_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			ROOT_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			DYN_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			DYNAM_action((RuleContext)_localctx, actionIndex);
			break;
		case 10:
			SPINE_TERMINATOR_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
			SPINE_ADD_action((RuleContext)_localctx, actionIndex);
			break;
		case 12:
			SPINE_SPLIT_action((RuleContext)_localctx, actionIndex);
			break;
		case 13:
			SPINE_JOIN_action((RuleContext)_localctx, actionIndex);
			break;
		case 130:
			FREE_TEXT_TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 131:
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
	private void MXHM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			addTextSpine();
			break;
		}
	}
	private void ROOT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			addTextSpine();
			break;
		}
	}
	private void DYN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			addMusicSpine();
			break;
		}
	}
	private void DYNAM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			addMusicSpine();
			break;
		}
	}
	private void SPINE_TERMINATOR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			removeSpine();
			break;
		}
	}
	private void SPINE_ADD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			addSpine();
			break;
		}
	}
	private void SPINE_SPLIT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			addSpine();
			break;
		}
	}
	private void SPINE_JOIN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			removeSpine();
			break;
		}
	}
	private void FREE_TEXT_TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			incSpine();
			break;
		}
	}
	private void FREE_TEXT_EOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			resetSpineAndMode();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u0083\u02a6\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^"+
		"\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j"+
		"\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu"+
		"\4v\tv\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080"+
		"\t\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&"+
		"\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C"+
		"\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N"+
		"\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z"+
		"\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3"+
		"e\3f\3f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3"+
		"q\3q\3r\3r\3s\3s\3t\3t\3u\3u\3v\3v\3w\3w\3x\3x\3y\3y\3z\3z\3{\3{\3|\5"+
		"|\u0271\n|\3|\3|\3}\3}\3}\3}\5}\u0279\n}\3}\3}\3~\3~\3~\3~\5~\u0281\n"+
		"~\3~\5~\u0284\n~\3\177\3\177\3\177\3\u0080\6\u0080\u028a\n\u0080\r\u0080"+
		"\16\u0080\u028b\3\u0081\3\u0081\7\u0081\u0290\n\u0081\f\u0081\16\u0081"+
		"\u0293\13\u0081\3\u0082\3\u0082\3\u0083\6\u0083\u0298\n\u0083\r\u0083"+
		"\16\u0083\u0299\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084\3\u0085\5\u0085"+
		"\u02a2\n\u0085\3\u0085\3\u0085\3\u0085\2\2\u0086\4\2\6\3\b\4\n\5\f\6\16"+
		"\7\20\b\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25"+
		",\26.\27\60\30\62\31\64\32\66\338\34:\35<\36>\37@ B!D\"F#H$J%L&N\'P(R"+
		")T*V+X,Z-\\.^/`\60b\61d\62f\63h\64j\65l\66n\67p8r9t:v;x<z=|>~?\u0080@"+
		"\u0082A\u0084B\u0086C\u0088D\u008aE\u008cF\u008eG\u0090H\u0092I\u0094"+
		"J\u0096K\u0098L\u009aM\u009cN\u009eO\u00a0P\u00a2Q\u00a4R\u00a6S\u00a8"+
		"T\u00aaU\u00acV\u00aeW\u00b0X\u00b2Y\u00b4Z\u00b6[\u00b8\\\u00ba]\u00bc"+
		"^\u00be_\u00c0`\u00c2a\u00c4b\u00c6c\u00c8d\u00cae\u00ccf\u00ceg\u00d0"+
		"h\u00d2i\u00d4j\u00d6k\u00d8l\u00dam\u00dcn\u00deo\u00e0p\u00e2q\u00e4"+
		"r\u00e6s\u00e8t\u00eau\u00ecv\u00eew\u00f0x\u00f2y\u00f4z\u00f6{\u00f8"+
		"|\u00fa}\u00fc~\u00fe\177\u0100\2\u0102\2\u0104\u0080\u0106\u0081\u0108"+
		"\u0082\u010a\u0083\4\2\3\5\f\2\u00c2\u00c3\u00c9\u00cb\u00ce\u00cf\u00d3"+
		"\u00d5\u00db\u00dc\u00e2\u00e3\u00e9\u00eb\u00ee\u00ef\u00f3\u00f5\u00fb"+
		"\u00fc\4\2\13\f\17\17\6\2\13\f\17\17##~~\2\u02a9\2\6\3\2\2\2\2\b\3\2\2"+
		"\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24"+
		"\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2"+
		"\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2"+
		"\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3"+
		"\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2"+
		"\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2"+
		"P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3"+
		"\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2"+
		"\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2"+
		"v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2"+
		"\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\2\u008a"+
		"\3\2\2\2\2\u008c\3\2\2\2\2\u008e\3\2\2\2\2\u0090\3\2\2\2\2\u0092\3\2\2"+
		"\2\2\u0094\3\2\2\2\2\u0096\3\2\2\2\2\u0098\3\2\2\2\2\u009a\3\2\2\2\2\u009c"+
		"\3\2\2\2\2\u009e\3\2\2\2\2\u00a0\3\2\2\2\2\u00a2\3\2\2\2\2\u00a4\3\2\2"+
		"\2\2\u00a6\3\2\2\2\2\u00a8\3\2\2\2\2\u00aa\3\2\2\2\2\u00ac\3\2\2\2\2\u00ae"+
		"\3\2\2\2\2\u00b0\3\2\2\2\2\u00b2\3\2\2\2\2\u00b4\3\2\2\2\2\u00b6\3\2\2"+
		"\2\2\u00b8\3\2\2\2\2\u00ba\3\2\2\2\2\u00bc\3\2\2\2\2\u00be\3\2\2\2\2\u00c0"+
		"\3\2\2\2\2\u00c2\3\2\2\2\2\u00c4\3\2\2\2\2\u00c6\3\2\2\2\2\u00c8\3\2\2"+
		"\2\2\u00ca\3\2\2\2\2\u00cc\3\2\2\2\2\u00ce\3\2\2\2\2\u00d0\3\2\2\2\2\u00d2"+
		"\3\2\2\2\2\u00d4\3\2\2\2\2\u00d6\3\2\2\2\2\u00d8\3\2\2\2\2\u00da\3\2\2"+
		"\2\2\u00dc\3\2\2\2\2\u00de\3\2\2\2\2\u00e0\3\2\2\2\2\u00e2\3\2\2\2\2\u00e4"+
		"\3\2\2\2\2\u00e6\3\2\2\2\2\u00e8\3\2\2\2\2\u00ea\3\2\2\2\2\u00ec\3\2\2"+
		"\2\2\u00ee\3\2\2\2\2\u00f0\3\2\2\2\2\u00f2\3\2\2\2\2\u00f4\3\2\2\2\2\u00f6"+
		"\3\2\2\2\2\u00f8\3\2\2\2\2\u00fa\3\2\2\2\2\u00fc\3\2\2\2\2\u00fe\3\2\2"+
		"\2\2\u0104\3\2\2\2\3\u0106\3\2\2\2\3\u0108\3\2\2\2\3\u010a\3\2\2\2\4\u010c"+
		"\3\2\2\2\6\u010e\3\2\2\2\b\u0110\3\2\2\2\n\u0119\3\2\2\2\f\u0122\3\2\2"+
		"\2\16\u012b\3\2\2\2\20\u0134\3\2\2\2\22\u013d\3\2\2\2\24\u0146\3\2\2\2"+
		"\26\u014e\3\2\2\2\30\u0158\3\2\2\2\32\u015c\3\2\2\2\34\u0160\3\2\2\2\36"+
		"\u0164\3\2\2\2 \u0168\3\2\2\2\"\u016e\3\2\2\2$\u0175\3\2\2\2&\u017b\3"+
		"\2\2\2(\u0183\3\2\2\2*\u0186\3\2\2\2,\u018b\3\2\2\2.\u018f\3\2\2\2\60"+
		"\u0192\3\2\2\2\62\u0197\3\2\2\2\64\u019c\3\2\2\2\66\u01a3\3\2\2\28\u01a7"+
		"\3\2\2\2:\u01ac\3\2\2\2<\u01b0\3\2\2\2>\u01b5\3\2\2\2@\u01b7\3\2\2\2B"+
		"\u01b9\3\2\2\2D\u01bb\3\2\2\2F\u01bd\3\2\2\2H\u01bf\3\2\2\2J\u01c1\3\2"+
		"\2\2L\u01c3\3\2\2\2N\u01c5\3\2\2\2P\u01c7\3\2\2\2R\u01c9\3\2\2\2T\u01cb"+
		"\3\2\2\2V\u01cd\3\2\2\2X\u01cf\3\2\2\2Z\u01d1\3\2\2\2\\\u01d3\3\2\2\2"+
		"^\u01d5\3\2\2\2`\u01d7\3\2\2\2b\u01d9\3\2\2\2d\u01db\3\2\2\2f\u01dd\3"+
		"\2\2\2h\u01df\3\2\2\2j\u01e1\3\2\2\2l\u01e3\3\2\2\2n\u01e5\3\2\2\2p\u01e7"+
		"\3\2\2\2r\u01e9\3\2\2\2t\u01eb\3\2\2\2v\u01ed\3\2\2\2x\u01ef\3\2\2\2z"+
		"\u01f1\3\2\2\2|\u01f3\3\2\2\2~\u01f5\3\2\2\2\u0080\u01f7\3\2\2\2\u0082"+
		"\u01f9\3\2\2\2\u0084\u01fb\3\2\2\2\u0086\u01fd\3\2\2\2\u0088\u01ff\3\2"+
		"\2\2\u008a\u0201\3\2\2\2\u008c\u0203\3\2\2\2\u008e\u0205\3\2\2\2\u0090"+
		"\u0207\3\2\2\2\u0092\u0209\3\2\2\2\u0094\u020b\3\2\2\2\u0096\u020d\3\2"+
		"\2\2\u0098\u020f\3\2\2\2\u009a\u0211\3\2\2\2\u009c\u0213\3\2\2\2\u009e"+
		"\u0215\3\2\2\2\u00a0\u0217\3\2\2\2\u00a2\u0219\3\2\2\2\u00a4\u021b\3\2"+
		"\2\2\u00a6\u021d\3\2\2\2\u00a8\u021f\3\2\2\2\u00aa\u0221\3\2\2\2\u00ac"+
		"\u0223\3\2\2\2\u00ae\u0225\3\2\2\2\u00b0\u0227\3\2\2\2\u00b2\u0229\3\2"+
		"\2\2\u00b4\u022b\3\2\2\2\u00b6\u022d\3\2\2\2\u00b8\u022f\3\2\2\2\u00ba"+
		"\u0231\3\2\2\2\u00bc\u0233\3\2\2\2\u00be\u0235\3\2\2\2\u00c0\u0237\3\2"+
		"\2\2\u00c2\u0239\3\2\2\2\u00c4\u023b\3\2\2\2\u00c6\u023d\3\2\2\2\u00c8"+
		"\u023f\3\2\2\2\u00ca\u0241\3\2\2\2\u00cc\u0243\3\2\2\2\u00ce\u0245\3\2"+
		"\2\2\u00d0\u0247\3\2\2\2\u00d2\u0249\3\2\2\2\u00d4\u024b\3\2\2\2\u00d6"+
		"\u024d\3\2\2\2\u00d8\u024f\3\2\2\2\u00da\u0251\3\2\2\2\u00dc\u0253\3\2"+
		"\2\2\u00de\u0255\3\2\2\2\u00e0\u0257\3\2\2\2\u00e2\u0259\3\2\2\2\u00e4"+
		"\u025b\3\2\2\2\u00e6\u025d\3\2\2\2\u00e8\u025f\3\2\2\2\u00ea\u0261\3\2"+
		"\2\2\u00ec\u0263\3\2\2\2\u00ee\u0265\3\2\2\2\u00f0\u0267\3\2\2\2\u00f2"+
		"\u0269\3\2\2\2\u00f4\u026b\3\2\2\2\u00f6\u026d\3\2\2\2\u00f8\u0270\3\2"+
		"\2\2\u00fa\u0274\3\2\2\2\u00fc\u027c\3\2\2\2\u00fe\u0285\3\2\2\2\u0100"+
		"\u0289\3\2\2\2\u0102\u028d\3\2\2\2\u0104\u0294\3\2\2\2\u0106\u0297\3\2"+
		"\2\2\u0108\u029d\3\2\2\2\u010a\u02a1\3\2\2\2\u010c\u010d\7,\2\2\u010d"+
		"\5\3\2\2\2\u010e\u010f\7#\2\2\u010f\7\3\2\2\2\u0110\u0111\5\4\2\2\u0111"+
		"\u0112\5\4\2\2\u0112\u0113\7o\2\2\u0113\u0114\7g\2\2\u0114\u0115\7p\2"+
		"\2\u0115\u0116\7u\2\2\u0116\u0117\3\2\2\2\u0117\u0118\b\4\2\2\u0118\t"+
		"\3\2\2\2\u0119\u011a\5\4\2\2\u011a\u011b\5\4\2\2\u011b\u011c\7m\2\2\u011c"+
		"\u011d\7g\2\2\u011d\u011e\7t\2\2\u011e\u011f\7p\2\2\u011f\u0120\3\2\2"+
		"\2\u0120\u0121\b\5\3\2\u0121\13\3\2\2\2\u0122\u0123\5\4\2\2\u0123\u0124"+
		"\5\4\2\2\u0124\u0125\7v\2\2\u0125\u0126\7g\2\2\u0126\u0127\7z\2\2\u0127"+
		"\u0128\7v\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b\6\4\2\u012a\r\3\2\2\2"+
		"\u012b\u012c\5\4\2\2\u012c\u012d\5\4\2\2\u012d\u012e\7j\2\2\u012e\u012f"+
		"\7c\2\2\u012f\u0130\7t\2\2\u0130\u0131\7o\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\b\7\5\2\u0133\17\3\2\2\2\u0134\u0135\5\4\2\2\u0135\u0136\5\4\2"+
		"\2\u0136\u0137\7o\2\2\u0137\u0138\7z\2\2\u0138\u0139\7j\2\2\u0139\u013a"+
		"\7o\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b\b\6\2\u013c\21\3\2\2\2\u013d"+
		"\u013e\5\4\2\2\u013e\u013f\5\4\2\2\u013f\u0140\7t\2\2\u0140\u0141\7q\2"+
		"\2\u0141\u0142\7q\2\2\u0142\u0143\7v\2\2\u0143\u0144\3\2\2\2\u0144\u0145"+
		"\b\t\7\2\u0145\23\3\2\2\2\u0146\u0147\5\4\2\2\u0147\u0148\5\4\2\2\u0148"+
		"\u0149\7f\2\2\u0149\u014a\7{\2\2\u014a\u014b\7p\2\2\u014b\u014c\3\2\2"+
		"\2\u014c\u014d\b\n\b\2\u014d\25\3\2\2\2\u014e\u014f\5\4\2\2\u014f\u0150"+
		"\5\4\2\2\u0150\u0151\7f\2\2\u0151\u0152\7{\2\2\u0152\u0153\7p\2\2\u0153"+
		"\u0154\7c\2\2\u0154\u0155\7o\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b\13"+
		"\t\2\u0157\27\3\2\2\2\u0158\u0159\5\4\2\2\u0159\u015a\5\u00ceg\2\u015a"+
		"\u015b\b\f\n\2\u015b\31\3\2\2\2\u015c\u015d\5\u00c0`\2\u015d\u015e\5\u00cc"+
		"f\2\u015e\u015f\b\r\13\2\u015f\33\3\2\2\2\u0160\u0161\5\u00c0`\2\u0161"+
		"\u0162\5\u00d8l\2\u0162\u0163\b\16\f\2\u0163\35\3\2\2\2\u0164\u0165\5"+
		"\u00c0`\2\u0165\u0166\5\u00a0P\2\u0166\u0167\b\17\r\2\u0167\37\3\2\2\2"+
		"\u0168\u0169\5\4\2\2\u0169\u016a\7r\2\2\u016a\u016b\7c\2\2\u016b\u016c"+
		"\7t\2\2\u016c\u016d\7v\2\2\u016d!\3\2\2\2\u016e\u016f\5\4\2\2\u016f\u0170"+
		"\7u\2\2\u0170\u0171\7v\2\2\u0171\u0172\7c\2\2\u0172\u0173\7h\2\2\u0173"+
		"\u0174\7h\2\2\u0174#\3\2\2\2\u0175\u0176\5\4\2\2\u0176\u0177\7e\2\2\u0177"+
		"\u0178\7n\2\2\u0178\u0179\7g\2\2\u0179\u017a\7h\2\2\u017a%\3\2\2\2\u017b"+
		"\u017c\5\4\2\2\u017c\u017d\7e\2\2\u017d\u017e\7w\2\2\u017e\u017f\7u\2"+
		"\2\u017f\u0180\7v\2\2\u0180\u0181\7q\2\2\u0181\u0182\7u\2\2\u0182\'\3"+
		"\2\2\2\u0183\u0184\5\4\2\2\u0184\u0185\7m\2\2\u0185)\3\2\2\2\u0186\u0187"+
		"\5\4\2\2\u0187\u0188\7o\2\2\u0188\u0189\7g\2\2\u0189\u018a\7v\2\2\u018a"+
		"+\3\2\2\2\u018b\u018c\5\4\2\2\u018c\u018d\7O\2\2\u018d\u018e\7O\2\2\u018e"+
		"-\3\2\2\2\u018f\u0190\5\4\2\2\u0190\u0191\7O\2\2\u0191/\3\2\2\2\u0192"+
		"\u0193\5\4\2\2\u0193\u0194\7d\2\2\u0194\u0195\7r\2\2\u0195\u0196\7e\2"+
		"\2\u0196\61\3\2\2\2\u0197\u0198\5\4\2\2\u0198\u0199\7g\2\2\u0199\u019a"+
		"\7r\2\2\u019a\u019b\7e\2\2\u019b\63\3\2\2\2\u019c\u019d\5\6\3\2\u019d"+
		"\u019e\7N\2\2\u019e\u019f\7Q\2\2\u019f\u01a0\7<\2\2\u01a0\u01a1\3\2\2"+
		"\2\u01a1\u01a2\5\u0100\u0080\2\u01a2\65\3\2\2\2\u01a3\u01a4\7:\2\2\u01a4"+
		"\u01a5\7x\2\2\u01a5\u01a6\7c\2\2\u01a6\67\3\2\2\2\u01a7\u01a8\7Z\2\2\u01a8"+
		"\u01a9\7:\2\2\u01a9\u01aa\7x\2\2\u01aa\u01ab\7c\2\2\u01ab9\3\2\2\2\u01ac"+
		"\u01ad\7:\2\2\u01ad\u01ae\7d\2\2\u01ae\u01af\7c\2\2\u01af;\3\2\2\2\u01b0"+
		"\u01b1\7Z\2\2\u01b1\u01b2\7:\2\2\u01b2\u01b3\7d\2\2\u01b3\u01b4\7c\2\2"+
		"\u01b4=\3\2\2\2\u01b5\u01b6\7\'\2\2\u01b6?\3\2\2\2\u01b7\u01b8\7B\2\2"+
		"\u01b8A\3\2\2\2\u01b9\u01ba\7C\2\2\u01baC\3\2\2\2\u01bb\u01bc\7D\2\2\u01bc"+
		"E\3\2\2\2\u01bd\u01be\7E\2\2\u01beG\3\2\2\2\u01bf\u01c0\7F\2\2\u01c0I"+
		"\3\2\2\2\u01c1\u01c2\7G\2\2\u01c2K\3\2\2\2\u01c3\u01c4\7H\2\2\u01c4M\3"+
		"\2\2\2\u01c5\u01c6\7I\2\2\u01c6O\3\2\2\2\u01c7\u01c8\7J\2\2\u01c8Q\3\2"+
		"\2\2\u01c9\u01ca\7K\2\2\u01caS\3\2\2\2\u01cb\u01cc\7L\2\2\u01ccU\3\2\2"+
		"\2\u01cd\u01ce\7M\2\2\u01ceW\3\2\2\2\u01cf\u01d0\7N\2\2\u01d0Y\3\2\2\2"+
		"\u01d1\u01d2\7O\2\2\u01d2[\3\2\2\2\u01d3\u01d4\7P\2\2\u01d4]\3\2\2\2\u01d5"+
		"\u01d6\7Q\2\2\u01d6_\3\2\2\2\u01d7\u01d8\7R\2\2\u01d8a\3\2\2\2\u01d9\u01da"+
		"\7S\2\2\u01dac\3\2\2\2\u01db\u01dc\7T\2\2\u01dce\3\2\2\2\u01dd\u01de\7"+
		"U\2\2\u01deg\3\2\2\2\u01df\u01e0\7V\2\2\u01e0i\3\2\2\2\u01e1\u01e2\7W"+
		"\2\2\u01e2k\3\2\2\2\u01e3\u01e4\7X\2\2\u01e4m\3\2\2\2\u01e5\u01e6\7Y\2"+
		"\2\u01e6o\3\2\2\2\u01e7\u01e8\7Z\2\2\u01e8q\3\2\2\2\u01e9\u01ea\7[\2\2"+
		"\u01eas\3\2\2\2\u01eb\u01ec\7\\\2\2\u01ecu\3\2\2\2\u01ed\u01ee\7c\2\2"+
		"\u01eew\3\2\2\2\u01ef\u01f0\7d\2\2\u01f0y\3\2\2\2\u01f1\u01f2\7e\2\2\u01f2"+
		"{\3\2\2\2\u01f3\u01f4\7f\2\2\u01f4}\3\2\2\2\u01f5\u01f6\7g\2\2\u01f6\177"+
		"\3\2\2\2\u01f7\u01f8\7h\2\2\u01f8\u0081\3\2\2\2\u01f9\u01fa\7i\2\2\u01fa"+
		"\u0083\3\2\2\2\u01fb\u01fc\7j\2\2\u01fc\u0085\3\2\2\2\u01fd\u01fe\7k\2"+
		"\2\u01fe\u0087\3\2\2\2\u01ff\u0200\7l\2\2\u0200\u0089\3\2\2\2\u0201\u0202"+
		"\7m\2\2\u0202\u008b\3\2\2\2\u0203\u0204\7n\2\2\u0204\u008d\3\2\2\2\u0205"+
		"\u0206\7o\2\2\u0206\u008f\3\2\2\2\u0207\u0208\7p\2\2\u0208\u0091\3\2\2"+
		"\2\u0209\u020a\7q\2\2\u020a\u0093\3\2\2\2\u020b\u020c\7r\2\2\u020c\u0095"+
		"\3\2\2\2\u020d\u020e\7s\2\2\u020e\u0097\3\2\2\2\u020f\u0210\7t\2\2\u0210"+
		"\u0099\3\2\2\2\u0211\u0212\7u\2\2\u0212\u009b\3\2\2\2\u0213\u0214\7v\2"+
		"\2\u0214\u009d\3\2\2\2\u0215\u0216\7w\2\2\u0216\u009f\3\2\2\2\u0217\u0218"+
		"\7x\2\2\u0218\u00a1\3\2\2\2\u0219\u021a\7y\2\2\u021a\u00a3\3\2\2\2\u021b"+
		"\u021c\7z\2\2\u021c\u00a5\3\2\2\2\u021d\u021e\7{\2\2\u021e\u00a7\3\2\2"+
		"\2\u021f\u0220\7|\2\2\u0220\u00a9\3\2\2\2\u0221\u0222\t\2\2\2\u0222\u00ab"+
		"\3\2\2\2\u0223\u0224\7\62\2\2\u0224\u00ad\3\2\2\2\u0225\u0226\7\63\2\2"+
		"\u0226\u00af\3\2\2\2\u0227\u0228\7\64\2\2\u0228\u00b1\3\2\2\2\u0229\u022a"+
		"\7\65\2\2\u022a\u00b3\3\2\2\2\u022b\u022c\7\66\2\2\u022c\u00b5\3\2\2\2"+
		"\u022d\u022e\7\67\2\2\u022e\u00b7\3\2\2\2\u022f\u0230\78\2\2\u0230\u00b9"+
		"\3\2\2\2\u0231\u0232\79\2\2\u0232\u00bb\3\2\2\2\u0233\u0234\7:\2\2\u0234"+
		"\u00bd\3\2\2\2\u0235\u0236\7;\2\2\u0236\u00bf\3\2\2\2\u0237\u0238\5\4"+
		"\2\2\u0238\u00c1\3\2\2\2\u0239\u023a\7$\2\2\u023a\u00c3\3\2\2\2\u023b"+
		"\u023c\7)\2\2\u023c\u00c5\3\2\2\2\u023d\u023e\7]\2\2\u023e\u00c7\3\2\2"+
		"\2\u023f\u0240\7_\2\2\u0240\u00c9\3\2\2\2\u0241\u0242\7%\2\2\u0242\u00cb"+
		"\3\2\2\2\u0243\u0244\7-\2\2\u0244\u00cd\3\2\2\2\u0245\u0246\7/\2\2\u0246"+
		"\u00cf\3\2\2\2\u0247\u0248\7?\2\2\u0248\u00d1\3\2\2\2\u0249\u024a\7\60"+
		"\2\2\u024a\u00d3\3\2\2\2\u024b\u024c\7~\2\2\u024c\u00d5\3\2\2\2\u024d"+
		"\u024e\7b\2\2\u024e\u00d7\3\2\2\2\u024f\u0250\7`\2\2\u0250\u00d9\3\2\2"+
		"\2\u0251\u0252\7\u0080\2\2\u0252\u00db\3\2\2\2\u0253\u0254\7>\2\2\u0254"+
		"\u00dd\3\2\2\2\u0255\u0256\7@\2\2\u0256\u00df\3\2\2\2\u0257\u0258\7\61"+
		"\2\2\u0258\u00e1\3\2\2\2\u0259\u025a\7^\2\2\u025a\u00e3\3\2\2\2\u025b"+
		"\u025c\7a\2\2\u025c\u00e5\3\2\2\2\u025d\u025e\7*\2\2\u025e\u00e7\3\2\2"+
		"\2\u025f\u0260\7+\2\2\u0260\u00e9\3\2\2\2\u0261\u0262\7<\2\2\u0262\u00eb"+
		"\3\2\2\2\u0263\u0264\7=\2\2\u0264\u00ed\3\2\2\2\u0265\u0266\7.\2\2\u0266"+
		"\u00ef\3\2\2\2\u0267\u0268\7\u00b9\2\2\u0268\u00f1\3\2\2\2\u0269\u026a"+
		"\7A\2\2\u026a\u00f3\3\2\2\2\u026b\u026c\7\"\2\2\u026c\u00f5\3\2\2\2\u026d"+
		"\u026e\7\13\2\2\u026e\u00f7\3\2\2\2\u026f\u0271\7\17\2\2\u0270\u026f\3"+
		"\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\7\f\2\2\u0273"+
		"\u00f9\3\2\2\2\u0274\u0275\7,\2\2\u0275\u0276\7K\2\2\u0276\u0278\3\2\2"+
		"\2\u0277\u0279\7$\2\2\u0278\u0277\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a"+
		"\3\2\2\2\u027a\u027b\5\u0100\u0080\2\u027b\u00fb\3\2\2\2\u027c\u027d\7"+
		"#\2\2\u027d\u027e\7#\2\2\u027e\u0280\3\2\2\2\u027f\u0281\7#\2\2\u0280"+
		"\u027f\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0283\3\2\2\2\u0282\u0284\5\u0100"+
		"\u0080\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u00fd\3\2\2\2\u0285"+
		"\u0286\7#\2\2\u0286\u0287\5\u0102\u0081\2\u0287\u00ff\3\2\2\2\u0288\u028a"+
		"\n\3\2\2\u0289\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u0289\3\2\2\2\u028b"+
		"\u028c\3\2\2\2\u028c\u0101\3\2\2\2\u028d\u0291\n\4\2\2\u028e\u0290\n\3"+
		"\2\2\u028f\u028e\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0103\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u0295\13"+
		"\2\2\2\u0295\u0105\3\2\2\2\u0296\u0298\n\3\2\2\u0297\u0296\3\2\2\2\u0298"+
		"\u0299\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029b\3\2"+
		"\2\2\u029b\u029c\b\u0083\16\2\u029c\u0107\3\2\2\2\u029d\u029e\7\13\2\2"+
		"\u029e\u029f\b\u0084\17\2\u029f\u0109\3\2\2\2\u02a0\u02a2\7\17\2\2\u02a1"+
		"\u02a0\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a4\7\f"+
		"\2\2\u02a4\u02a5\b\u0085\20\2\u02a5\u010b\3\2\2\2\f\2\3\u0270\u0278\u0280"+
		"\u0283\u028b\u0291\u0299\u02a1\21\3\4\2\3\5\3\3\6\4\3\7\5\3\b\6\3\t\7"+
		"\3\n\b\3\13\t\3\f\n\3\r\13\3\16\f\3\17\r\4\2\2\3\u0084\16\3\u0085\17";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}