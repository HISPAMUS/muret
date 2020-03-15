/*
@author: David Rizo (drizo@dlsi.ua.es) Jan, 2020.
Semantic encoding for OMR based on **kern and **mens
*/
parser grammar skmParser;
options { tokenVocab=skmLexer; } // use tokens from skmLexer.g4

@parser::header {
}

@rulecatch {
    // ANTLR does not generate its normal rule try/catch
    catch(RecognitionException e) {
        throw e;
    }
}

//TODO - cuidado porque hay veces que puede aparecer esto
//**kern	**kern	**dynam
//*staff2	*staff1	*staff1/2 - véase sonata07-1.krn de humdrum-data

// start rule - in this version of **skm we are forcing each column starts with a *part after the **smens or **kern
start: header (eol record)+ eol? EOF;

// anystart: (header eol)? record (eol record)+ eol? EOF;

eol: EOL;

header: headerField (TAB headerField)*;

headerField: SMENS | SKERN | TEXT; //TODO dinámica, armonía ...

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
    part
    |
    barline
    |
    rest
    |
    note
    |
    chord
    |
    spineOperation
    |
    lyricsText
    )
     (AT associatedIDS)?
    ;


tandemInterpretation:
    staff
    |
    clef
    |
    keySignature
    |
    fractionalTimeSignature
    |
    meterSymbol
    |
    key
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
lowerCasePitch: (CHAR_a | CHAR_b | CHAR_c | CHAR_d | CHAR_e | CHAR_f | CHAR_g); // we cannot use a generic rule because c is used both pitch and as common time symbol
upperCasePitch: (CHAR_A | CHAR_B | CHAR_C | CHAR_D | CHAR_E | CHAR_F | CHAR_G);

pitchClass: lowerCasePitch accidental;

part: TANDEM_PART number;

staff: TANDEM_STAFF number;

clef: TANDEM_CLEF clefValue;
clefValue: clefSign clefLine;
clefSign: CHAR_C | CHAR_F | CHAR_G;
clefLine: DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5;

keySignature: TANDEM_KEY LEFT_BRACKET keySignaturePitchClass* RIGHT_BRACKET;
keySignaturePitchClass: pitchClass;

key: ASTERISK (minorKey | majorKey) pitchClass? COLON;
minorKey: lowerCasePitch;
majorKey: upperCasePitch;

fractionalTimeSignature: TANDEM_TIMESIGNATURE numerator SLASH denominator;
numerator: number;
denominator: number;

meterSymbol: TANDEM_MET LEFT_PARENTHESIS (modernMeterSymbolSign | mensuration) RIGHT_PARENTHESIS;
modernMeterSymbolSign: CHAR_c | CHAR_c PIPE;
mensuration: CHAR_C | CHAR_C PIPE | CHAR_C DOT | CHAR_O | CHAR_O DOT | CHAR_C DIGIT_3 SLASH DIGIT_2 | CHAR_C PIPE DIGIT_3 SLASH DIGIT_2 | DIGIT_3;

metronome: METRONOME number;

nullInterpretation: ASTERISK; // a null interpretation (placeholder) will have just an ASTERISK_FRAGMENT

//barline: EQUAL+ (NUMBER)? (COLON? barlineWidth? partialBarLine? COLON?) ; // COLON = repetition mark
barline: EQUAL number? barLineType?;

//barlineWidth: (EXCLAMATION? PIPE EXCLAMATION?);

barLineType:
    MINUS // hidden
    |
    PIPE PIPE // double thin bar line
    |
    EQUAL // end bar line (the first equal is encoded in the skmBarLine rule)
    |
    EXCLAMATION PIPE COLON // left-repeat
    |
    COLON PIPE EXCLAMATION // right-repeat
    |
    COLON PIPE EXCLAMATION PIPE COLON // left-right repeat
    ;



spineOperation:
     spineTerminator
     |
     spineAdd
     |
     spineSplit
     |
     spineJoin
     ;

spineTerminator: ASTERISK MINUS;
spineAdd: ASTERISK PLUS;
spineSplit: ASTERISK CIRCUMFLEX;
spineJoin: ASTERISK CHAR_v;

rest: duration (CHAR_r) fermata? restLinePosition?;

restLinePosition: UNDERSCORE clefLine;

duration: mensuralDuration | modernDuration;
// dot: separationDot | augmentationDot;

fermata: SEMICOLON; // pause

mensuralDuration: mensuralFigure coloured? mensuralPerfection? mensuralDot;

mensuralDot: (augmentationDot | separationDot)?;

modernDuration: number augmentationDot*;

coloured: TILDE;

mensuralFigure: CHAR_X | CHAR_L | CHAR_S | CHAR_s | CHAR_M | CHAR_m | CHAR_U | CHAR_u;

// p=perfect, i=imperfect, I=imperfect by alteratio
mensuralPerfection: CHAR_p | CHAR_i | CHAR_I;

augmentationDot: DOT;

separationDot: COLON;

custos: TANDEM_CUSTOS pitch;
pitch: diatonicPitch alteration?;
alteration: accidental alterationDisplay?;

//note:  beforeNote duration noteName (alteration alterationVisualMode?)? afterNote;
note:  beforeNote duration pitch afterNote;

chord: note (SPACE note)+;

beforeNote:  //TODO Regla semantica (boolean) para que no se repitan
    (slurStart
    | ligatureStart
    | barLineCrossedNoteStart
    )*
    ;

diatonicPitch:
    bassNotes // BASS
    |
    trebleNotes
	;

trebleNotes: lowerCasePitch+;
bassNotes: upperCasePitch+;

accidental: OCTOTHORPE | (OCTOTHORPE OCTOTHORPE) | MINUS | (MINUS MINUS) | CHAR_n;

// x is show, xx is shows editorial
//alterationVisualMode: CHAR_x CHAR_x?;
alterationDisplay: (CHAR_y CHAR_y?) | (CHAR_Y CHAR_Y?);

afterNote:
	     (slurEnd | stem| ligatureEnd | beam | fermata | barLineCrossedNoteEnd)*;

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


// bottom line = L1, bottom space = S1, first bottom ledger line = L0, space between first ledger line and bottom line = S0, second bottom ledger line = L-1, first top ledger line = L6
staffPosition: lineSpace number;

lineSpace: CHAR_L | CHAR_S; // l = line, s = space

lyricsText: FIELD_TEXT;

plainChant: TANDEM_BEGIN_PLAIN_CHANT | TANDEM_END_PLAIN_CHANT;


