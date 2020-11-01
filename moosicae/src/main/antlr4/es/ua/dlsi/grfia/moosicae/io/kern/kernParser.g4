/*
@author: David Rizo (drizo@dlsi.ua.es) Oct, 2020.
*/
parser grammar kernParser;
options { tokenVocab=kernLexer; } // use tokens from kernLexer.g4

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
start: (METADATACOMMENT EOL)* header (eol record)+ eol? (METADATACOMMENT EOL?)* EOF;

// anystart: (header eol)? record (eol record)+ eol? EOF;

eol: EOL;

header: headerField (TAB headerField)*;

headerField: MENS | KERN | TEXT | HARM | ROOT | DYN | DYNAM;

record:
    EXCLAMATION FIELDCCOMMENT // !! record comment
    |
    fields;

tab: TAB | FREE_TEXT_TAB;
fields: field (tab field)*;

field
    :
    graphicalToken
    |
    fieldComment // it includes an empty comment
    |
    placeHolder; // nothing is done, it is just a placeholder

fieldComment: FIELDCCOMMENT;

associatedIDS: number (COMMA associatedIDS)*; // used for agnostic IDS in semantic mens

placeHolder: DOT;

graphicalToken:
    (tandemInterpretation
    |
    part
    |
    barline
    |
    spineOperation
    |
    lyricsText
    |
    rest
    |
    note
    |
    chord
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
    key
    |
    timeSignature
    |
    meterSymbol
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

part: TANDEM_PART sep number;

//sep: SEP; //TODO Que lo coja sólo si es SKM
sep: SEP?;

staff: TANDEM_STAFF sep number;

clef: TANDEM_CLEF sep clefValue;
clefValue: clefSign (sep clefLine)? (sep clefOctave)?;
clefSign: CHAR_C | CHAR_F | CHAR_G | CHAR_P | CHAR_T;
clefLine: DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5;
clefOctave: CHAR_v CHAR_v? DIGIT_2 | CIRCUMFLEX CIRCUMFLEX? DIGIT_2;

keySignature: TANDEM_KEY_SIGNATURE sep LEFT_BRACKET keySignaturePitchClass* RIGHT_BRACKET keySignatureCancel?;
keySignaturePitchClass: pitchClass;
keySignatureCancel: sep CHAR_X;

keyMode: (minorKey | majorKey);
//key: ASTERISK keyMode COLON;
key: ASTERISK sep keyMode keySignatureCancel? COLON;
minorKey: lowerCasePitch accidental?;
majorKey: upperCasePitch accidental?;

timeSignature: TANDEM_TIMESIGNATURE sep (standardTimeSignature | additiveTimeSignature | mixedTimeSignature | alternatingTimeSignature | interchangingTimeSignature);
numerator: number;
denominator: number;
standardTimeSignature: numerator SLASH denominator;
additiveTimeSignature: numerator (PLUS numerator)+ SLASH denominator;
mixedTimeSignature: standardTimeSignature (PLUS standardTimeSignature)+;
alternatingTimeSignature: alternatingTimeSignatureItem (COLON alternatingTimeSignatureItem)+;
alternatingTimeSignatureItem: standardTimeSignature (SEMICOLON number)?;
interchangingTimeSignature: standardTimeSignature PIPE standardTimeSignature;

//meterSymbol: TANDEM_MET LEFT_PARENTHESIS (modernMeterSymbolSign | mensuration) RIGHT_PARENTHESIS;
meterSymbol: TANDEM_TIMESIGNATURE sep LEFT_PARENTHESIS (modernMeterSymbolSign | mensuration) RIGHT_PARENTHESIS;
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
spineAdd: ASTERISK PLUS+;
spineSplit: ASTERISK CIRCUMFLEX+;
spineJoin: ASTERISK CHAR_v;

rest: duration CHAR_r CHAR_r? fermata? restLinePosition?;

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
pitch: diatonicPitchAndOctave alteration?;
alteration: accidental alterationDisplay?;

//note:  beforeNote duration noteName (alteration alterationVisualMode?)? afterNote;
note:  beforeNote duration sep pitch afterNote;

chord: note (chordSpace note)+;

chordSpace: SPACE; // required for ekern translation

beforeNote:  //TODO Regla semantica (boolean) para que no se repitan
    (slurStart
    | ligatureStart
    | barLineCrossedNoteStart
    )*
    ;

diatonicPitchAndOctave:
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
	     (slurEnd | stem| ligatureEnd | beam | fermata | barLineCrossedNoteEnd | mordent | trill | tenuto )*;

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
    (CHAR_L+ //BEAM_START
    |
    CHAR_J+) // BEAM_END
    (
    CHAR_K+ // partial beam that extends to the right
    |
    CHAR_k+ // partial beam that extends to the left
    )?
    ;


// bottom line = L1, bottom space = S1, first bottom ledger line = L0, space between first ledger line and bottom line = S0, second bottom ledger line = L-1, first top ledger line = L6
staffPosition: lineSpace number;

lineSpace: CHAR_L | CHAR_S; // l = line, s = space

lyricsText: FIELD_TEXT;

plainChant: TANDEM_BEGIN_PLAIN_CHANT | TANDEM_END_PLAIN_CHANT;

mordent:
    //LETTER_W
	   CHAR_W // MORDENT_INVERTED_TONE
	   CHAR_w?; // MORDENT_INVERTED_TONE

trill:
	 CHAR_T
     |
     CHAR_t;

tenuto: TILDE;
