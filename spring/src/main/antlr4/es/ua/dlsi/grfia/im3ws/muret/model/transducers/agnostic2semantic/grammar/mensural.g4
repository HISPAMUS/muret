grammar mensural;

@lexer::header {
}

@parser::header {
}

@rulecatch {
    // ANTLR does not generate its normal rule try/catch
    catch(RecognitionException e) {
        throw e;
    }
}

//TODO context information from previous staves
staff: clef SEP (keySignature SEP)? (timeSignature SEP)? (melody SEP)? custos?;

verticalPosition: SEPVERTICALPOS (line | space);
line: 'L' INTEGER;
space: 'S' INTEGER;

// clef
clef: SYMBOL_CLEF SEPSYMBOL clefType verticalPosition;
clefType: 'G' | 'F' | 'Fpetrucci';

// key signature
keySignature: accidental (SEPSYMBOL accidental)*;
accidental: SYMBOL_ACCIDENTAL SEPSYMBOL accidentalValue;
accidentalValue: 'flat' | 'sharp';

// time signature
timeSignature: meterSign meterNumbers? | meterNumbers;
meterSign: SYMBOL_METERSIGN SEPSYMBOL meterSignType verticalPosition;
digit: SYMBOL_DIGIT SEPSYMBOL INTEGER verticalPosition;
meterNumbers: digit (SEPL digit);
meterSignType: 'Ct' | 'C/'; //TODO Other meter signs

// melody
//TODO binary and ternary groups
melody: note | rest | ligature | barline | timeSignature;

// rest
rest: SYMBOL_REST SEPSYMBOL FIGURE verticalPosition dot?;

// note
note: (accidental SEP)? SYMBOL_NOTE SEPSYMBOL FIGURE STEM? verticalPosition dot?; //TODO groups of dot kinds (division...)

dot: SYMBOL_DOT verticalPosition;
//TODO fermata

//ligature
ligature: SYMBOL_LIGATURE verticalPosition;

// barline
barline: SYMBOL_VERTICALLINE;

// custos
custos: SYMBOL_CUSTOS verticalPosition;

//TODO signum conguntriae


SEP: ' ' | '\t'; //v2 is space, v1 was tab
SEPSYMBOL: '.';
SEPVERTICALPOS: ':';
fragment DIGIT: ('0'..'9');
INTEGER: '-'? DIGIT+;
FIGURE: 'whole' | 'half' | 'quarter'; //TODO
STEM: '_up' | '_down';

// agnostic symbol types
SYMBOL_CLEF: 'clef';
SYMBOL_ACCIDENTAL: 'accidental';
SYMBOL_METERSIGN: 'metersign';
SYMBOL_CUSTOS: 'custos';
SYMBOL_NOTE: 'note';
SYMBOL_REST: 'rest';
SYMBOL_LIGATURE: 'ligature';
SYMBOL_VERTICALLINE: 'verticalLine';
SYMBOL_FIGURE: 'whole' | 'half' | 'quarter'; //TODO figures
SYMBOL_DOT: 'dot';
SYMBOL_STEM: '_up' |'_down';
SYMBOL_DIGIT: 'digit';

