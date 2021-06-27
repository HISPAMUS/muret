lexer grammar agnosticLexer;

@lexer::header {
import java.util.ArrayList;
}

VERSION: 'agnostic_version';

// Agnostic symbol types
TACCIDENTAL: 'accidental';
TCLEF: 'clef';
TCOLON: 'colon';
TDIGIT: 'digit';
TENCLOSURE: 'enclosure';
TDOT: 'dot';
THORIZONTAL_BRACKET: 'horizBracket';
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
STCLEFOCTAVE: '8va' | '8vb' | '15ma' | '15mb';
STACCIDENTALS: 'flat' | 'natural' | 'sharp' | 'double_sharp' | 'double_sharp_x' | 'double_flat';
STMETERSIGNS: 'Ct' | 'Ccut' | 'CZ' | 'CcutZ' | 'O' | 'Odot' | 'Cdot'; // Ct for common time, to avoid ambiguities
// fusa and semifusa are used for mensural notation
STFIGURES_WITH_STEM: 'longa2Black' | 'longaBlack' | 'longa2' | 'longa' | 'quadrupleWholeStem' | 'tripleWholeStem' | 'doubleWholeStem' | 'doubleWholeBlackStem' | 'half' | 'quarter' | 'eighth' | 'sixteenth' | 'thirtySecond' | 'sixtyFourth' | 'hundredTwentyEighth' | 'twoHundredFiftySix' | 'eighthCut' | 'eighthVoid' | 'sixteenthVoid' | 'fusa' | 'semifusa';
STFIGURES_WITHOUT_STEM:
    'doubleWhole' | 'breve' | 'breveBlack' |  'whole'  | 'wholeBlack';
STMENSURAL_REST_FIGURES: 'seminima';

STMARKS_UNPOSITIONAL: 'accent' | 'tenuto' | 'harmonic' | 'breath' | 'arpeggio' | 'trill';
STMARKS_POSITIONAL: 'staccatissimo' | 'marcato' | 'fermata';
STMARKS_UPPERLOWER: 'turn' | 'mordent';
STBEAM: 'beamedRight' | 'beamedLeft' | 'beamedBoth';
STLINEWIDTH: 'thin' | 'thick';
STENCLOSURES: 'bracket' | 'parenthesis';

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
PRIGHT: 'right';
PLEFT: 'left';


// General rules
COLON: ':';

CHAR_C: 'C';
CHAR_F: 'F';
CHAR_G: 'G';
CHAR_L: 'L';
CHAR_S: 'S';

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
TAB: '\t';



fragment DOT : '.';
fragment UNDERSCORE : '_';

