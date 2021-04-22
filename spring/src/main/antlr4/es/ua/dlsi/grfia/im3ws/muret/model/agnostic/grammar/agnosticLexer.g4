lexer grammar agnosticLexer;

@lexer::header {
import java.util.ArrayList;
}

VERSION: 'version';

// Agnostic symbol types
TACCIDENTAL: 'accidental';
TBRACKET: 'bracket';
TCLEF: 'clef';
TCOLONT: 'colon';
TDIGIT: 'digit';
TMARK: 'mark';
TMETERSIGN: 'metersign';
TMULTIREST: 'multirest';
TNOTE: 'note';
TREST: 'rest';
TSLUR: 'slur';
TVERTICAL_LINE: 'verticalLine';
SEPSYMBOL: DOT;
SEPPROPERTIES: UNDERSCORE;

// Subtypes
STACCIDENTALS: 'flat' | 'natural' | 'sharp' | 'double_sharp';
STMETERSIGNS: 'Ct' | 'Ccut' | 'CZ' | 'CcutZ' | 'O' | 'Odot' | 'Cdot'; // Ct for common time, to avoid ambiguities
STFIGURES_WITHOUT_STEM:
    'doubleWhole' | 'breve' | 'breveBlack' |  'whole'  | 'wholeBlack';
STFIGURES_WITH_STEM: 'longa' | 'longaBlack' | 'quadrupleWholeStem' | 'tripleWholeStem' | 'doubleWholeStem' | 'doubleWholeBlackStem' | // mensural
| 'half' | 'quarter' | 'eighth' | 'sixteenth' | 'thirtySecond' | 'sixtyFourth' | 'hundredTwentEighth' | 'twoHundredFiftySix' | 'eighthCut' | 'eighthVoid' | 'sixteenthVoid';
STMENSURAL_REST_FIGURES: 'seminima' | 'fusa' | 'semifusa';

STMARKS_UNPOSITIONAL: 'accent' | 'tenuto' | 'harmonic';
STMARKS_POSITIONAL: 'staccatissimo' | 'marcato' | 'fermata';
STMARKS_UPPERLOWER: 'turn';
STBEAM: 'beamedRight' | 'beamedLeft' | 'beamedBoth';
STLINEWIDTH: 'thin' | 'thick';

// Properties
PSTART: 'start';
PEND: 'end';
PDOWN: 'down';
PUP: 'up';
PABOVE: 'above';
PBELOW: 'below';
PUPPER: 'upper';
PLOWER: 'lower';
PCHORD: 'chord';
PCUE: 'cue';
PSLASH: 'slash';
PTIE: 'tie';

// General rules
COLON: ':';

CHAR_C: 'C';
CHAR_F: 'F';
CHAR_G: 'G';

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

EOL : '\r'?'\n';

HYPHEN: '-';


fragment DOT : '.';
fragment UNDERSCORE : '_';

