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

// The rule .*? is used as a non-greedy lexer rule (see the ? is used to set the non greedy mode (https://github.com/antlr/antlr4/blob/master/doc/wildcard.md)
//TODO - cuidado porque hay veces que puede aparecer esto
//**kern	**kern	**dynam
//*staff2	*staff1	*staff1/2 - véase sonata07-1.krn de humdrum-data

// start rule - in this version of **skm we are forcing each column starts with a *part after the **smens or **kern
start: (METACOMMENT EOL)* header (EOL (record | METACOMMENT))* EOL* EOF;

header: headerField (TAB headerField)*;

record: fields | spineOperations;

headerField: MENS | KERN | TEXT | HARM | MXHM | ROOT | DYN | DYNAM;

//tab: TAB | FREE_TEXT_TAB;

fields: field (TAB field)*;

spineOperations:  spineOperation (TAB | spineOperation)*;

field
    :
    graphicalToken
    |
    fieldComment // it includes an empty comment
    |
    placeHolder
    |
    dynamics
    ;


fieldComment:
    LAYOUT
    | FIELDCOMMENT
    | EXCLAMATION; // empty comment

associatedIDS: number (COMMA associatedIDS)*; // used for agnostic IDS in semantic mens

placeHolder: DOT;

graphicalToken:
    (tandemInterpretation
    |
    part
    |
    barline
    |
    octaveShift
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

octaveShift: OCTAVE_SHIFT;


tandemInterpretation:
    visualTandemInterpretation
    |
    nonVisualTandemInterpretation;

// those ones that are not engraved
nonVisualTandemInterpretation:
    instrument
    |
    transposition
    |
    tandemTuplet // sometimes found
    |
    sections
    |
    pianoHand
    ;

pianoHand: TANDEM_LEFT_HAND | TANDEM_RIGHT_HAND;

tandemTuplet: TANDEM_TUPLET_START | TANDEM_TUPLET_END;

tandemCue: TANDEM_CUE_START | TANDEM_CUE_END;

tandemTremolo: TANDEM_TREMOLO_START | TANDEM_TREMOLO_END;

// those ones that are engraved
visualTandemInterpretation:
    dynamics_position // TODO: what is it for?
    |
    tandemCue
    |
    tandemTremolo
    |
    rscale
    |
    pedal
    |
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
    nullInterpretation // it is not engraved, but required to correctly engrave the score
    |
    custos
    |
    plainChant
    ;

rscale: TANDEM_RSCALE COLON number (SLASH number)?;

pedal: TANDEM_PEDAL_START | TANDEM_PEDAL_END;

dynamics_position: TANDEM_ABOVE | TANDEM_BELOW | TANDEM_CENTERED; //TODO It is not rendered in VHV


sections: TANDEM_SECTION
    (
        (NO_REPEAT? LEFT_BRACKET sectionNames RIGHT_BRACKET)
        |
        (sectionName)
    );

sectionNames: sectionName (COMMA sectionName)*;

// TODO
sectionName: (CHAR_A | CHAR_B | CHAR_C | CHAR_D | CHAR_E | CHAR_F | CHAR_G | CHAR_H | CHAR_I | CHAR_J | CHAR_K | CHAR_L |
    CHAR_M | CHAR_N | CHAR_O | CHAR_P | CHAR_Q | CHAR_R | CHAR_S | CHAR_T |
    CHAR_U | CHAR_V | CHAR_W | CHAR_X | CHAR_Y | CHAR_Z |
    CHAR_a | CHAR_b | CHAR_c | CHAR_d | CHAR_e | CHAR_f | CHAR_g | CHAR_h | CHAR_i | CHAR_j | CHAR_k | CHAR_l |
    CHAR_m | CHAR_n | CHAR_o | CHAR_p | CHAR_q | CHAR_r | CHAR_s | CHAR_t |
    CHAR_u | CHAR_v | CHAR_w | CHAR_x | CHAR_y | CHAR_z |
    number)+;

transposition: TANDEM_TRANSPOSITION CHAR_d MINUS? number CHAR_c MINUS? number;

instrument: INSTRUMENT;

number: (DIGIT_0 | DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5 | DIGIT_6 | DIGIT_7 | DIGIT_8 | DIGIT_9)+;
lowerCasePitch: (CHAR_a | CHAR_b | CHAR_c | CHAR_d | CHAR_e | CHAR_f | CHAR_g); // we cannot use a generic rule because c is used both pitch and as common time symbol
upperCasePitch: (CHAR_A | CHAR_B | CHAR_C | CHAR_D | CHAR_E | CHAR_F | CHAR_G);

pitchClass: lowerCasePitch accidental;

part: TANDEM_PART  number;

staff: TANDEM_STAFF  number (SLASH number)?;

clef: TANDEM_CLEF  clefValue;
clefValue: clefSign ( clefLine)? ( clefOctave)?;
clefSign: CHAR_C | CHAR_F | CHAR_G | CHAR_P | CHAR_T;
clefLine: DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5;
clefOctave: CHAR_v CHAR_v? DIGIT_2 | CIRCUMFLEX CIRCUMFLEX? DIGIT_2;

keySignature: TANDEM_KEY_SIGNATURE  LEFT_BRACKET keySignaturePitchClass* RIGHT_BRACKET keySignatureCancel?;
keySignaturePitchClass: pitchClass;
keySignatureCancel:  CHAR_X;

keyMode: (minorKey | majorKey);
key: ASTERISK  keyMode keySignatureCancel? COLON;
minorKey: lowerCasePitch accidental?;
majorKey: upperCasePitch accidental?;

timeSignature: TANDEM_TIMESIGNATURE  (standardTimeSignature | additiveTimeSignature | mixedTimeSignature | alternatingTimeSignature | interchangingTimeSignature);
numerator: number;
denominator: number;
standardTimeSignature: numerator SLASH denominator;
additiveTimeSignature: numerator (PLUS numerator)+ SLASH denominator;
mixedTimeSignature: standardTimeSignature (PLUS standardTimeSignature)+;
alternatingTimeSignature: alternatingTimeSignatureItem (COLON alternatingTimeSignatureItem)+;
alternatingTimeSignatureItem: standardTimeSignature (SEMICOLON number)?;
interchangingTimeSignature: standardTimeSignature PIPE standardTimeSignature;

//meterSymbol: TANDEM_MET LEFT_PARENTHESIS (modernMeterSymbolSign | mensuration) RIGHT_PARENTHESIS;
meterSymbol: (TANDEM_TIMESIGNATURE | TANDEM_MET)  LEFT_PARENTHESIS (modernMeterSymbolSign | mensuration) RIGHT_PARENTHESIS;
modernMeterSymbolSign: CHAR_c | CHAR_c PIPE;
mensuration: CHAR_C | CHAR_C PIPE | CHAR_C DOT | CHAR_O | CHAR_O DOT | CHAR_C DIGIT_3 SLASH DIGIT_2 | CHAR_C PIPE DIGIT_3 SLASH DIGIT_2 | DIGIT_3;

metronome: METRONOME number (DOT number)?;

nullInterpretation: ASTERISK; // a null interpretation (placeholder) will have just an ASTERISK_FRAGMENT

//barline: EQUAL+ (NUMBER)? (COLON? barlineWidth? partialBarLine? COLON?) ; // COLON = repetition mark
barline: EQUAL
    number?
    MINUS? // hidden
    barLineType?
    fermata?
    CHAR_j?; // sometimes found

//barlineWidth: (EXCLAMATION? PIPE EXCLAMATION?);

barLineType:
    PIPE PIPE // double thin bar line
    |
    PIPE EXCLAMATION // found sometimes
    |
    EXCLAMATION PIPE COLON // left-repeat
    |
    EQUAL? COLON PIPE EXCLAMATION // right-repeat -- sometimes we've found the structure ==:|!
    |
    COLON PIPE EXCLAMATION PIPE COLON // left-right repeat
    |
    EQUAL // end bar line (the first equal is encoded in the skmBarLine rule)
    ;



spineOperation:
     spineTerminator
     |
     spineAdd
     |
     spineSplit
     |
     spineJoin
     |
     spinePlaceholder
     ;


spineTerminator: SPINE_TERMINATOR;
spineAdd: SPINE_ADD;
spineSplit: SPINE_SPLIT;
spineJoin: SPINE_JOIN;
spinePlaceholder: ASTERISK | FIELD_TEXT; // when no operation is done in this spine but there are operations on other spines

//rest: duration CHAR_r CHAR_r? fermata? restLinePosition?;
rest: slurStart? duration CHAR_r CHAR_r?  staffChange? restPosition? fermata? editorialIntervention?
    CHAR_j?; // sometimes found - user assignable?;

restPosition: diatonicPitchAndOctave;
//restLinePosition: UNDERSCORE clefLine;

//duration: mensuralDuration | modernDuration;
duration: modernDuration graceNote?; // sometimes we've found a grace note between the duration and the pitch
//TODO Cambiar de modo cuando estemos en mensural, no aparecerán dynamics y no se confundirá con la dinámica sf
// dot: arationDot | augmentationDot;

fermata: SEMICOLON; // pause

mensuralDuration: mensuralFigure coloured? mensuralPerfection? mensuralDot;

mensuralDot: (augmentationDot | arationDot)?;

modernDuration: number (PERCENT number)? augmentationDot*; //TODO 40%3...

coloured: TILDE;

mensuralFigure: CHAR_X | CHAR_L | CHAR_S | CHAR_s | CHAR_M | CHAR_m | CHAR_U | CHAR_u;

// p=perfect, i=imperfect, I=imperfect by alteratio
mensuralPerfection: CHAR_p | CHAR_i | CHAR_I;

augmentationDot: DOT;

arationDot: COLON;

custos: TANDEM_CUSTOS pitch;
pitch: diatonicPitchAndOctave
    graceNote? // sometimes found here
    staffChange? // sometimes found here
    accent? // sometimes found here
    fermata? // sometimes found here
    trill? // sometimes found here
    alteration?
    CHAR_x?; // sometimes found
alteration: accidental alterationDisplay?;

// The correct order of notes is: beforeNote duration pitch staffChange afterNote, however, if changes in some encodings

note:
    beforeNote
    duration? // grace notes can be specified without durations
    staffChange? // not correct here, but sometimes found
    slurStart? // sometimes found here
    pitch
    staffChange? // it must be placed immediately after the pitch+accidental tokens. This is because they also can modify the beam, as well as articulation, slur and tie positions
    afterNote;

staffChange: ANGLE_BRACKET_OPEN | ANGLE_BRACKET_CLOSE;

chord: note (chordSpace note)+;

chordSpace: SPACE; // required for ekern translation

// it may appear after or before the note
// sometimes the duration is found before or after the note
graceNote:
    duration? CHAR_q CHAR_q? duration?;

beforeNote:  //TODO Regla semantica (boolean) para que no se repitan
    (
    accent // sometimes found here
    | beam // sometimes found here
    | slurStart staffChange?
    | slurEnd  // sometimes found here
    | ligatureTieStart staffChange?
    | barLineCrossedNoteStart
    | graceNote
    | stem
    | staffChange // sometimes found here
    | articulation // sometimes found here
    | CHAR_N // sometimes found - user assignable?
    | CHAR_j // sometimes found - user assignable?
    )*
    ;


afterNote:
	     (slurEnd | stem| ligatureTieEnd | tieContinue | beam | fermata | barLineCrossedNoteEnd | mordent | turn | trill | articulation | glissando | editorialIntervention | userAssignable |
	     graceNote duration? // sometimes we've found the duration of the graceNote after it
	     |
	     sforzando // sforzando should be in a dynanics spine, but it is sometimes found here
	     | staffChange // it should never be here, but we've found in some files
	     | CHAR_N // sometimes found - user assignable?
	     | CHAR_j // sometimes found - user assignable?
	     | CHAR_Z // sometimes found - user assignable?
	     | CHAR_O // sometimes found - generic ornament
	     )*;


diatonicPitchAndOctave:
    bassNotes // BASS
    |
    trebleNotes
	;

trebleNotes: lowerCasePitch+;
bassNotes: upperCasePitch+;

accidental: OCTOTHORPE (OCTOTHORPE OCTOTHORPE?)? | MINUS MINUS? | CHAR_n;

// x is show, xx is shows editorial
//alterationVisualMode: CHAR_x CHAR_x?;
alterationDisplay:
        CHAR_x // sometimes found - TODO for?
        |
        CHAR_X // cautionary accidental
        |
        CHAR_i // editorial accidental, it does not imply position
        |
        CHAR_I // accidental placed above the note
        |
        CHAR_j // bracket
        |
        CHAR_Z // parentheses
        |
        (CHAR_y CHAR_y?) | (CHAR_Y CHAR_Y?); // X = editorial intervention


turn: CHAR_S // regular turn
    |
    DOLLAR // wagnerian turn
    ;

userAssignable: CHAR_i;

glissando: COLON;


articulation:
    staccato | spiccato | pizzicato | staccatissimo | tenuto | accent
    ;

accent: CIRCUMFLEX;

tenuto: TILDE;

staccatissimo: GRAVE_ACCENT;

pizzicato: QUOTATION_MARK;

spiccato: CHAR_s;

staccato: APOSTROPHE;

editorialIntervention:
    (CHAR_y CHAR_y* AT?) // hidden //@ footnote comment? // if yy --> hidden, we've found even yyy
    |
    CHAR_X; // associated no a note

slurStart: AMPERSAND? LEFT_PARENTHESIS; // ampersand for ellision
ligatureTieStart: ANGLE_BRACKET_OPEN | LEFT_BRACKET CHAR_y?; // y for hidden;
tieContinue: UNDERSCORE;
ligatureTieEnd: ANGLE_BRACKET_CLOSE | RIGHT_BRACKET;
slurEnd: AMPERSAND? RIGHT_PARENTHESIS; // ampersand for ellision
barLineCrossedNoteStart: CHAR_T;
barLineCrossedNoteEnd: CHAR_t;

// it can be found before or after the note with the same meaning
stem:
    SLASH  // STEM_UP
    |
    BACKSLASH // STEM_DOWN;
    ;

beam:
    (
        (CHAR_L //BEAM_START
        |
        CHAR_J// BEAM_END
        |
        CHAR_K // partial beam that extends to the right
        |
        CHAR_k // partial beam that extends to the left
        ) staffChange?
    )+
    ;


// bottom line = L1, bottom space = S1, first bottom ledger line = L0, space between first ledger line and bottom line = S0, second bottom ledger line = L-1, first top ledger line = L6
staffPosition: lineSpace number;

lineSpace: CHAR_L | CHAR_S; // l = line, s = space

lyricsText: FIELD_TEXT;

plainChant: TANDEM_BEGIN_PLAIN_CHANT | TANDEM_END_PLAIN_CHANT;

mordent:
    //LETTER_W
       CHAR_M | // MORDENT form accid upper, //TODO
       CHAR_m | // MORDENT form upper, //TODO
	   CHAR_W // MORDENT_INVERTED_TONE
	   CHAR_w? // MORDENT_INVERTED_TONE
	   |
       CHAR_w;
trill:
	 CHAR_T CHAR_T? // the second T denotes an extended trill (horizontal twisting line)
     |
     CHAR_t;

dynamics:
    dynamics_symbol (SPACE? dynamics_symbol)*;

dynamics_symbol:
    subito? (
    staffChange // sometimes found here
    | crescendoBegin | crescendoEnd | diminuendoBegin | diminuendoEnd | crescendoContinue | diminuendoContinue |
    piano | pianissimo | triplePiano | quadruplePiano | forte |  fortissimo | tripleForte | quadrupleForte |
    mezzoPiano | mezzoForte | sforzando | fortePiano | footnote | rinforzando)
    CHAR_y? CHAR_y?; // sometimes found here

footnote: QUESTION_MARK+; //TODO -- ???

crescendoBegin: ANGLE_BRACKET_OPEN;

diminuendoBegin: ANGLE_BRACKET_CLOSE;

crescendoEnd: LEFT_BRACKET  LEFT_BRACKET?; // TODO difference between [ and [[

diminuendoEnd: RIGHT_BRACKET RIGHT_BRACKET?;

crescendoContinue: LEFT_PARENTHESIS;

diminuendoContinue: RIGHT_PARENTHESIS;

piano: CHAR_p;

pianissimo: CHAR_p CHAR_p;

triplePiano: CHAR_p CHAR_p CHAR_p;

quadruplePiano: CHAR_p CHAR_p CHAR_p CHAR_p;

forte: CHAR_f;

fortissimo: CHAR_f CHAR_f;

tripleForte: CHAR_f CHAR_f CHAR_f;

quadrupleForte: CHAR_f CHAR_f CHAR_f CHAR_f;

mezzoPiano: CHAR_m CHAR_p;

mezzoForte: CHAR_m CHAR_f;

sforzando: CHAR_s CHAR_f | CHAR_f CHAR_z | CHAR_s CHAR_f CHAR_z | CHAR_z;

fortePiano: CHAR_f CHAR_p;

rinforzando: CHAR_r CHAR_f? CHAR_z?;

subito: CHAR_s;

