/*
@author: David Rizo (drizo@dlsi.ua.es) Jan, 2020.
Semantic encoding for OMR based on **kern and **mens
*/
parser grammar sKernMensParser;
options { tokenVocab=sKernMensLexer; } // use tokens from sKernMensLexer.g4

@parser::header {
}

@rulecatch {
    // ANTLR does not generate its normal rule try/catch
    catch(RecognitionException e) {
        throw e;
    }
}

// start rule
start: header (eol record)+ eol? EOF;

anystart: (header eol)? record (eol record)+ eol? EOF;

eol: EOL;

header: headerField (TAB headerField)*;

headerField: SMENS | SKERN | TEXT;

record: fields;

tab: TAB | FREE_TEXT_TAB;
fields: field (tab field)*;

field
    :
    graphicalToken
     |
     placeHolder; // nothing is done, it is just a placeholder

associatedIDS: number (COMMA associatedIDS)*; // used for agnostic IDS in semantic mens

placeHolder: DOT;

graphicalToken:
    (tandemInterpretation
    |
    barLine
    |
    layout
    |
    rest
    |
    note
    |
    spineOperation
    |
    lyricsText
    )
     (AT associatedIDS)?
    ;

tandemInterpretation:
    part
    |
    staff
    |
    clef
    |
    keySignature
    |
    fractionalMeter
    |
    meterSign
    |
    keyChange
    |
    metronome
    |
    nullInterpretation
    |
    custos
    |
    plainChant
    ;

number: (DIGIT_0 | DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5 | DIGIT_6 | DIGIT_7 | DIGIT_8 | DIGIT_9)+;
lowerCasePitch: LOWERCASE_PITCH_CHARACTER;
upperCasePitch: (CHAR_A | CHAR_B | CHAR_C | CHAR_D | CHAR_E | CHAR_F | CHAR_G);

part: TANDEM_PART number;

staff: TANDEM_STAFF number;

clef: TANDEM_CLEF clefValue;
clefValue: clefNote clefLine;
clefNote: CHAR_C | CHAR_F | CHAR_G;
clefLine: DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5;

keySignature: TANDEM_KEY LEFT_BRACKET keySignatureNote* RIGHT_BRACKET;
keySignatureNote: lowerCasePitch keyAccidental?;

keyAccidental: (CHAR_n | OCTOTHORPE | MINUS);
keyChange: ASTERISK (minorKey | majorKey) keyAccidental? COLON;
minorKey: lowerCasePitch;
majorKey: upperCasePitch;

fractionalMeter: TANDEM_TIMESIGNATURE numerator SLASH denominator;

numerator: number;

denominator: number;

meterSign: TANDEM_MET LEFT_PARENTHESIS meterSignValue RIGHT_PARENTHESIS;
meterSignValue: CHAR_C | CHAR_C PIPE | CHAR_C DOT | CHAR_O | CHAR_O DOT | CHAR_C DIGIT_3 SLASH DIGIT_2 | CHAR_C PIPE DIGIT_3 SLASH DIGIT_2 | DIGIT_3;

metronome: METRONOME number;

nullInterpretation: ASTERISK; // a null interpretation (placeholder) will have just an ASTERISK_FRAGMENT

//barline: EQUAL+ (NUMBER)? (COLON? barlineWidth? partialBarLine? COLON?) ; // COLON = repetition mark
barLine: EQUAL+ number? (COLON? barlineProperties? COLON?); // COLON = repetition mark

//barlineWidth: (EXCLAMATION? PIPE EXCLAMATION?);

barlineProperties:
    GRAVE_ACCENT // partialBarLineTop
    |
    APOSTROPHE // partialBarLineMid
    |
    MINUS // no bar line;
    |
    PIPE PIPE // double bar line
	;

spineOperation:
    spineTerminator
     |
     spineSplit
     |
     spineJoin
     ;

spineTerminator: ASTERISK MINUS;
spineSplit: ASTERISK CIRCUMFLEX;
spineJoin: ASTERISK CHAR_v;

rest: duration (CHAR_r) pause? restLinePosition?;

restLinePosition: UNDERSCORE clefLine;

duration: mensuralDuration | modernDuration;
// dot: separationDot | augmentationDot;

pause: SEMICOLON; // fermata

mensuralDuration: mensuralFigure coloured? mensuralPerfection? mensuralDot;

mensuralDot: (augmentationDot | separationDot)?;

modernDuration: number augmentationDot*;

coloured: TILDE;

mensuralFigure: CHAR_X | CHAR_L | CHAR_S | CHAR_s | CHAR_M | CHAR_m | CHAR_U | CHAR_u;

// p=perfect, i=imperfect, I=imperfect by alteratio
mensuralPerfection: CHAR_p | CHAR_i | CHAR_I;

augmentationDot: DOT;

separationDot: COLON;

custos: TANDEM_CUSTOS noteName alteration?;

//note:  beforeNote duration noteName (alteration alterationVisualMode?)? afterNote;
note:  beforeNote duration noteName (alteration editorialAccidental?)? afterNote;

beforeNote:  //TODO Regla semantica (boolean) para que no se repitan
    (slurStart
    | ligatureStart
    | barLineCrossedNoteStart
    )*
    ;

noteName:
    bassNotes // BASS
    |
    trebleNotes
	;

trebleNotes: lowerCasePitch+;
bassNotes: upperCasePitch+;

alteration: OCTOTHORPE | (OCTOTHORPE OCTOTHORPE) | MINUS | (MINUS MINUS) | CHAR_n;

// x is show, xx is shows editorial
//alterationVisualMode: CHAR_x CHAR_x?;
editorialAccidental: (CHAR_y CHAR_y?) | (CHAR_Y CHAR_Y?);

afterNote:
	     (slurEnd | stem| ligatureEnd | beam | pause | barLineCrossedNoteEnd)*;

slurStart: LEFT_PARENTHESIS;
ligatureStart: ANGLE_BRACKET_OPEN | LEFT_BRACKET;
ligatureEnd: ANGLE_BRACKET_CLOSE | RIGHT_BRACKET;
slurEnd: RIGHT_PARENTHESIS;
barLineCrossedNoteStart: CHAR_T;
barLineCrossedNoteEnd: CHAR_t;

stem:
    SLASH  // STEM_UP
    |
    BACKSLASH // STEM_DOWN;
    ;

beam:
    CHAR_L //BEAM_START
    |
    CHAR_J; // BEAM_END

layout: LAYOUT layoutCommand;

layoutCommand: layoutVisualAccidental | layoutRestPosition;

layoutVisualAccidental: LAYOUT_NOTE_VISUAL_ACCIDENTAL alteration;
layoutRestPosition: LAYOUT_REST_POSITION staffPosition;

// bottom line = L1, bottom space = S1, first bottom ledger line = L0, space between first ledger line and bottom line = S0, second bottom ledger line = L-1, first top ledger line = L6
staffPosition: lineSpace number;

lineSpace: CHAR_L | CHAR_S; // l = line, s = space

lyricsText: FIELD_TEXT;

plainChant: TANDEM_BEGIN_PLAIN_CHANT | TANDEM_END_PLAIN_CHANT;


