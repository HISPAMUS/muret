/*
@author: David Rizo (drizo@dlsi.ua.es) April, 2021.
Agnostic encoding for OMR
*/
parser grammar agnosticParser;
options { tokenVocab=agnosticLexer; } // use tokens from agnosticLexer.g4

@parser::header {
}

@rulecatch {
    // ANTLR does not generate its normal rule try/catch
    catch(RecognitionException e) {
        throw e;
    }
}

start: version (EOL agnosticSymbol)* EOL*;
version: VERSION COLON naturalNumber; // currently 'version:4'
agnosticSymbol: (coordinates TAB)? symbol COLON positionInStaff COLON staff;

coordinates: naturalNumber TAB naturalNumber;

positionInStaff: (CHAR_L | CHAR_S) integer;
staff: naturalNumber;

symbol: accidental | horizontalBracket | clef | colon | digit | dot | enclosure | mark | metersign | multirest | note | rest | slur | verticalLine;

accidental: TACCIDENTAL SEPSYMBOL STACCIDENTALS (SEPPROPERTIES PCUE)?;

clef: TCLEF SEPSYMBOL (CHAR_C | CHAR_F | CHAR_G) clefLine (SEPPROPERTIES STCLEFOCTAVE)?;

clefLine: DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5;

colon: TCOLON;

dot: TDOT;

digit: TDIGIT SEPSYMBOL naturalNumber;

enclosure: TENCLOSURE SEPSYMBOL STENCLOSURES SEPPROPERTIES leftRight;

horizontalBracket: THORIZONTAL_BRACKET SEPSYMBOL (PSTART | PEND);

leftRight: PRIGHT | PLEFT;

mark: TMARK SEPSYMBOL (markPositional | markUnpositional | markUpperLower);

markPositional: STMARKS_POSITIONAL SEPPROPERTIES pAboveBelow;

markUnpositional: STMARKS_UNPOSITIONAL;

markUpperLower: STMARKS_UPPERLOWER SEPPROPERTIES pUpperLower;

metersign: TMETERSIGN SEPSYMBOL STMETERSIGNS;

multirest: TMULTIREST;

note: TNOTE SEPSYMBOL noteFigure (SEPPROPERTIES PCHORD)? (SEPPROPERTIES cue)?;

cue: PCUE (SEPPROPERTIES PSLASH)?;

noteFigure: (STFIGURES_WITHOUT_STEM | STFIGURES_WITH_STEM SEPPROPERTIES pUpDown) | (beam SEPPROPERTIES pUpDown);

beam: STBEAM naturalNumber;

rest: TREST SEPSYMBOL (STFIGURES_WITHOUT_STEM | STFIGURES_WITH_STEM | STMENSURAL_REST_FIGURES);

slur: TSLUR SEPSYMBOL (PTIE | pStartEnd);

verticalLine: TVERTICAL_LINE SEPSYMBOL STLINEWIDTH;

pUpDown: PUP | PDOWN;
pAboveBelow: PABOVE | PBELOW;
pStartEnd: PSTART | PEND;
pUpperLower: PUPPER | PLOWER;

naturalNumber: (DIGIT_0 | DIGIT_1 | DIGIT_2 | DIGIT_3 | DIGIT_4 | DIGIT_5 | DIGIT_6 | DIGIT_7 | DIGIT_8 | DIGIT_9)+;
integer: HYPHEN? naturalNumber;

