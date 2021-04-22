/*
@author: David Rizo (drizo@dlsi.ua.es) April, 2022.
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

start: NOTE;

