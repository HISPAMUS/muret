package es.ua.dlsi.grfia.im3ws.muret.model.transducers.grammar;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.agnostic2semantic.grammar.mensuralBaseListener;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.agnostic2semantic.grammar.mensuralLexer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.agnostic2semantic.grammar.mensuralParser;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.io.antlr.ErrorListener;
import es.ua.dlsi.im3.core.io.antlr.GrammarParseRuntimeException;
import es.ua.dlsi.im3.core.io.antlr.ParseError;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticExporter;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.enums.ClefNote;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticClef;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.math3.fraction.BigFraction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GrammarBasedAgnostic2SemanticMensuralTransducer extends GrammarBasedAgnostic2SemanticTransducer {
    private ErrorListener errorListener;
    public static class Loader extends mensuralBaseListener {
        SemanticTransduction semanticTransduction;
        @Override
        public void enterStaff(mensuralParser.StaffContext ctx) {
            super.enterStaff(ctx);
            BigFraction initialProbability = new BigFraction(1); //TODO
            semanticTransduction = new SemanticTransduction(initialProbability);
        }


        @Override
        public void exitClef(mensuralParser.ClefContext ctx) {
            String clefType = ctx.clefType().getText();
            String verticalPosition = ctx.verticalPosition().getText().substring(1);
            ClefNote clefNote = null;
            int line = 0;

            clefNote = ClefNote.valueOf(clefType);
            if (clefNote == null) {
                throw new GrammarParseRuntimeException("Invalid clef type " + clefType);
            }

            try {
                PositionInStaff positionInStaff = PositionInStaff.parseString(verticalPosition);

                if (!positionInStaff.laysOnLine()) {
                    throw new GrammarParseRuntimeException("Invalid vertical position ("
                            + verticalPosition + "), it should be in a line");
                }

                line = positionInStaff.getLine();
            } catch (IM3Exception e) {
                throw new GrammarParseRuntimeException("Invalid vertical position ("
                        + verticalPosition + ") for clef type " + clefType);
            }

            SemanticClef semanticClef = null;
            try {
                semanticClef = new SemanticClef(NotationType.eMensural, clefNote, line);
            } catch (ImportException e) {
                throw new GrammarParseRuntimeException("Cannot create semantic clef from agnostic '" + ctx.getText() + "'");
            }
            //TODO token IDS semanticClef.setAgnosticIDs(token.getId());
            semanticTransduction.add(semanticClef);
        }

        @Override
        public void exitStaff(mensuralParser.StaffContext ctx) {
            super.exitStaff(ctx);
        }

        @Override
        public void enterVerticalPosition(mensuralParser.VerticalPositionContext ctx) {
            super.enterVerticalPosition(ctx);
        }

        @Override
        public void exitVerticalPosition(mensuralParser.VerticalPositionContext ctx) {
            super.exitVerticalPosition(ctx);
        }

        @Override
        public void enterLine(mensuralParser.LineContext ctx) {
            super.enterLine(ctx);
        }

        @Override
        public void exitLine(mensuralParser.LineContext ctx) {
            super.exitLine(ctx);
        }

        @Override
        public void enterSpace(mensuralParser.SpaceContext ctx) {
            super.enterSpace(ctx);
        }

        @Override
        public void exitSpace(mensuralParser.SpaceContext ctx) {
            super.exitSpace(ctx);
        }


        @Override
        public void enterKeySignature(mensuralParser.KeySignatureContext ctx) {
            super.enterKeySignature(ctx);
        }

        @Override
        public void exitKeySignature(mensuralParser.KeySignatureContext ctx) {
            super.exitKeySignature(ctx);
        }

        @Override
        public void enterAccidental(mensuralParser.AccidentalContext ctx) {
            super.enterAccidental(ctx);
        }

        @Override
        public void exitAccidental(mensuralParser.AccidentalContext ctx) {
            super.exitAccidental(ctx);
        }

        @Override
        public void enterAccidentalValue(mensuralParser.AccidentalValueContext ctx) {
            super.enterAccidentalValue(ctx);
        }

        @Override
        public void exitAccidentalValue(mensuralParser.AccidentalValueContext ctx) {
            super.exitAccidentalValue(ctx);
        }

        @Override
        public void enterTimeSignature(mensuralParser.TimeSignatureContext ctx) {
            super.enterTimeSignature(ctx);
        }

        @Override
        public void exitTimeSignature(mensuralParser.TimeSignatureContext ctx) {
            super.exitTimeSignature(ctx);
        }

        @Override
        public void enterMeterSign(mensuralParser.MeterSignContext ctx) {
            super.enterMeterSign(ctx);
        }

        @Override
        public void exitMeterSign(mensuralParser.MeterSignContext ctx) {
            super.exitMeterSign(ctx);
        }

        @Override
        public void enterMeterNumbers(mensuralParser.MeterNumbersContext ctx) {
            super.enterMeterNumbers(ctx);
        }

        @Override
        public void exitMeterNumbers(mensuralParser.MeterNumbersContext ctx) {
            super.exitMeterNumbers(ctx);
        }

        @Override
        public void enterMeterSignType(mensuralParser.MeterSignTypeContext ctx) {
            super.enterMeterSignType(ctx);
        }

        @Override
        public void exitMeterSignType(mensuralParser.MeterSignTypeContext ctx) {
            super.exitMeterSignType(ctx);
        }

        @Override
        public void enterMelody(mensuralParser.MelodyContext ctx) {
            super.enterMelody(ctx);
        }

        @Override
        public void exitMelody(mensuralParser.MelodyContext ctx) {
            super.exitMelody(ctx);
        }

        @Override
        public void enterRest(mensuralParser.RestContext ctx) {
            super.enterRest(ctx);
        }

        @Override
        public void exitRest(mensuralParser.RestContext ctx) {
            super.exitRest(ctx);
        }

        @Override
        public void enterNote(mensuralParser.NoteContext ctx) {
            super.enterNote(ctx);
        }

        @Override
        public void exitNote(mensuralParser.NoteContext ctx) {
            super.exitNote(ctx);
        }

        @Override
        public void enterDot(mensuralParser.DotContext ctx) {
            super.enterDot(ctx);
        }

        @Override
        public void exitDot(mensuralParser.DotContext ctx) {
            super.exitDot(ctx);
        }

        @Override
        public void enterLigature(mensuralParser.LigatureContext ctx) {
            super.enterLigature(ctx);
        }

        @Override
        public void exitLigature(mensuralParser.LigatureContext ctx) {
            super.exitLigature(ctx);
        }

        @Override
        public void enterBarline(mensuralParser.BarlineContext ctx) {
            super.enterBarline(ctx);
        }

        @Override
        public void exitBarline(mensuralParser.BarlineContext ctx) {
            super.exitBarline(ctx);
        }

        @Override
        public void enterCustos(mensuralParser.CustosContext ctx) {
            super.enterCustos(ctx);
        }

        @Override
        public void exitCustos(mensuralParser.CustosContext ctx) {
            super.exitCustos(ctx);
        }

        public SemanticTransduction getSemanticTransduction() {
            return semanticTransduction;
        }
    }

    @Override
    public SemanticTransduction transduce(AgnosticEncoding agnosticEncoding) throws IM3Exception {
        AgnosticExporter exporter = new AgnosticExporter(AgnosticVersion.v2);
        exporter.setSeparateTokensWithSpace(true);
        String agnosticEncodingString = exporter.export(agnosticEncoding);

        try {
            CodePointCharStream input = CharStreams.fromString(agnosticEncodingString);
            mensuralLexer lex = new mensuralLexer(input);
            return translate(lex);
        } catch (Throwable e) {
            //TODO Comprobar errores
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Translate error {0}", e.getMessage());
            StringBuilder sb = new StringBuilder();
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(pe.getMsg());
            }
            //TODO que ponga lo que sí se ha reconocido - ver estrategias recuperación errores
            return errorTransduction(sb.toString());
        }
    }

    SemanticTransduction errorTransduction(String msg) {
        SemanticTransduction result = new SemanticTransduction(new BigFraction(0));
        result.setErrorMessage(msg);
        return result;
    }

        private SemanticTransduction translate(mensuralLexer lexer) {
            errorListener = new ErrorListener();
            lexer.addErrorListener(errorListener);
            TokenStream tokens = new CommonTokenStream(lexer);
            mensuralParser parser = new mensuralParser(tokens);
            parser.addErrorListener(errorListener);

            mensuralParser.StaffContext tree = parser.staff();
            ParseTreeWalker walker = new ParseTreeWalker();

            Loader loader = new Loader();
            walker.walk(loader, tree);
            if (errorListener.getNumberErrorsFound() != 0) {
                return errorTransduction(errorListener.toString());
            } else {
                return loader.getSemanticTransduction();
            }
        }
}
