/*
@author: David Rizo (drizo@dlsi.ua.es) Oct, 2020.
*/
lexer grammar kernLexer;

@lexer::header {
import java.util.ArrayList;
}

// Non context free grammar needs semantic predicates to handle text spines
// TODO - something similar for HARM
@lexer::members {
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

}


fragment ASTERISK_FRAGMENT : '*';

EXCLAMATION : '!';
MENS: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'mens' {addMusicSpine();};
KERN: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'kern' {addMusicSpine();};
TEXT: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'text' {addTextSpine();};
HARM: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'harm' {addTextSpine();};
ROOT: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'root' {addTextSpine();};
DYN: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'dyn' {addTextSpine();};
DYNAM: ASTERISK_FRAGMENT ASTERISK_FRAGMENT 'dynam' {addTextSpine();};

TANDEM_PART: ASTERISK_FRAGMENT 'part';
TANDEM_INSTRUMENT: ASTERISK_FRAGMENT CHAR_I;
TANDEM_STAFF: ASTERISK_FRAGMENT 'staff';
TANDEM_CLEF: ASTERISK_FRAGMENT 'clef';
TANDEM_CUSTOS: ASTERISK_FRAGMENT 'custos';
TANDEM_KEY_SIGNATURE: ASTERISK_FRAGMENT 'k';
//TANDEM_KEY: ASTERISK_FRAGMENT 'K';
TANDEM_MET: ASTERISK_FRAGMENT 'met';
METRONOME: ASTERISK_FRAGMENT 'MM';
TANDEM_TIMESIGNATURE: ASTERISK_FRAGMENT 'M';
TANDEM_BEGIN_PLAIN_CHANT: ASTERISK_FRAGMENT 'bpc';
TANDEM_END_PLAIN_CHANT: ASTERISK_FRAGMENT 'epc';

AT: '@';
CHAR_A: 'A';
CHAR_B: 'B';
CHAR_C: 'C';
CHAR_D: 'D';
CHAR_E: 'E';
CHAR_F: 'F';
CHAR_G: 'G';
CHAR_I: 'I';
CHAR_J: 'J';
CHAR_K: 'K';
CHAR_L: 'L';
CHAR_M: 'M';
CHAR_O: 'O';
CHAR_P: 'P';
CHAR_Q: 'Q';
CHAR_R: 'R';
CHAR_S: 'S';
CHAR_X: 'X';
CHAR_Y: 'Y';
CHAR_T: 'T';
CHAR_U: 'U';
CHAR_W: 'W';
CHAR_a: 'a';
CHAR_b: 'b';
CHAR_c: 'c';
CHAR_d: 'd';
CHAR_e: 'e';
CHAR_f: 'f';
CHAR_g: 'g';
CHAR_i: 'i';
CHAR_k: 'k';
CHAR_m: 'm';
CHAR_n: 'n';
CHAR_p: 'p';
CHAR_r: 'r';
CHAR_s: 's';
CHAR_t: 't';
CHAR_u: 'u';
CHAR_v: 'v';
CHAR_w: 'w';
CHAR_x: 'x';
CHAR_y: 'y';



DIGIT_0: '0';
DIGIT_1: '1';
DIGIT_2: '2';
DIGIT_3: '3';
DIGIT_4: '4';
DIGIT_5: '5';
DIGIT_6: '6';
DIGIT_7: '7';
DIGIT_8: '8';
DIGIT_9: '9';

ASTERISK: ASTERISK_FRAGMENT;

LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
OCTOTHORPE: '#';
PLUS: '+';
MINUS: '-';
EQUAL: '=';
DOT: '.';
PIPE: '|';
GRAVE_ACCENT: '`';
APOSTROPHE: '\'';
CIRCUMFLEX: '^';
TILDE: '~';
ANGLE_BRACKET_OPEN: '<';
ANGLE_BRACKET_CLOSE: '>';
SLASH: '/';
BACKSLASH: '\\';
UNDERSCORE: '_';

LEFT_PARENTHESIS: '(';
RIGHT_PARENTHESIS: ')';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';
SEP: '·'; // only used in SKM


// with pushMode, the lexer uses the rules below FREE_TEXT
SPACE: ' ';
TAB: '\t' {incSpine();}; // incSpine changes mode depending on the spine type
EOL : '\r'?'\n' {resetSpineAndMode();};

METADATACOMMENT: '!!!' COMMENTTEXT;
FIELDCCOMMENT: EXCLAMATION COMMENTTEXT?;
fragment COMMENTTEXT: ~[\t\n\r!|]+ ; // | and ! to avoid confusing a comment with a bar line

mode FREE_TEXT;
FIELD_TEXT: ~[\t\n\r]+ -> mode(0); // must reset mode here to let lexer recognize the tab or newline
FREE_TEXT_TAB: '\t' {incSpine();}; // incSpine changes mode depending on the spine type
FREE_TEXT_EOL : '\r'?'\n' {resetSpineAndMode();};

