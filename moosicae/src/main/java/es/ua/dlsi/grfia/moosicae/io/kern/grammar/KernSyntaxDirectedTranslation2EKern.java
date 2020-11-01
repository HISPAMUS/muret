package es.ua.dlsi.grfia.moosicae.io.kern.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.*;
import es.ua.dlsi.grfia.moosicae.io.kern.kernLexer;
import es.ua.dlsi.grfia.moosicae.io.kern.kernParser;
import es.ua.dlsi.grfia.moosicae.io.kern.kernParserBaseListener;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ANTLRUtils;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ErrorListener;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.GrammarParseRuntimeException;
import es.ua.dlsi.grfia.moosicae.utils.antlr4.ParseError;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * It translates from **kern to **ekern just using the grammar
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernSyntaxDirectedTranslation2EKern {
    private boolean debug;

    public KernSyntaxDirectedTranslation2EKern() {
    }

    public static class Loader extends kernParserBaseListener {
        private static final String SEPARATOR = "·";
        private boolean debug;
        private final Parser parser;
        private int spineIndex;
        private int row;
        private ArrayList<EKernHeaders> spineTypes; // only kern, dyn, and dynam types will be exported
        private LinkedList<LinkedList<String>> translatedEKernMatrix;
        private LinkedList<String> currentEKernMatrixRow;
        private StringBuilder currentChordStringBuilder;

        public Loader(Parser parser, boolean debug) {
            this.debug = debug;
            this.parser = parser;
            this.translatedEKernMatrix = new LinkedList<>();
            this.spineTypes = new ArrayList<>();
            this.row = 0;
            this.currentEKernMatrixRow = null;
            this.currentChordStringBuilder = null;
        }

        public LinkedList<LinkedList<String>> getTranslatedEKernMatrix() {
            return translatedEKernMatrix;
        }

        private GrammarParseRuntimeException createException(String message, Throwable e) throws GrammarParseRuntimeException {
            return new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + message + " :" + e);
        }

        private GrammarParseRuntimeException createException(Throwable e) throws GrammarParseRuntimeException {
            return new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + e);
        }

        private GrammarParseRuntimeException createException(String message) throws GrammarParseRuntimeException {
            return new GrammarParseRuntimeException("[Row #" + this.row + ", spine #" + spineIndex + "] " + message);
        }

        private void output(String encoding) {
            currentEKernMatrixRow.add(encoding);
        }

        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            super.enterEveryRule(ctx);
            if (debug) {
                System.out.println(ANTLRUtils.getRuleDescription(parser, ctx, "Enter"));
            }
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx) {
            super.enterEveryRule(ctx);
            if (debug) {
                System.out.print(ANTLRUtils.getRuleDescription(parser, ctx, "Exit"));
                System.out.println();
            }
        }

        private void enterRow() {
            this.spineIndex = 0;
            this.currentEKernMatrixRow = new LinkedList<>();
        }

        private void exitRow() {
            this.row ++;
            this.translatedEKernMatrix.add(this.currentEKernMatrixRow);
            this.currentEKernMatrixRow = null;
        }

        @Override
        public void enterRecord(kernParser.RecordContext ctx) {
            super.enterRecord(ctx);
            enterRow();
        }

        @Override
        public void exitRecord(kernParser.RecordContext ctx) {
            super.exitRecord(ctx);
            exitRow();
        }

        @Override
        public void enterHeader(kernParser.HeaderContext ctx) {
            super.enterHeader(ctx);
            enterRow();
        }

        @Override
        public void exitHeader(kernParser.HeaderContext ctx) {
            super.exitHeader(ctx);
            exitRow();
        }

        @Override
        public void enterHeaderField(kernParser.HeaderFieldContext ctx) {
            super.enterHeaderField(ctx);
        }

        @Override
        public void exitField(kernParser.FieldContext ctx) {
            super.exitField(ctx);
            this.spineIndex ++;
        }

        @Override
        public void exitPlaceHolder(kernParser.PlaceHolderContext ctx) {
            super.exitPlaceHolder(ctx);
            output(ctx.getText());
        }

        @Override
        public void exitHeaderField(kernParser.HeaderFieldContext ctx) {
            super.exitHeaderField(ctx);

            EKernHeaders type = EKernHeaders.valueOf(ctx.getText().substring(2)); // remove the **
            if (type == null) {
                createException("Cannot find a valid header type for '" + ctx.getText() + "'");
            }

            spineTypes.add(type);
            switch (type) {
                case dyn:
                    throw new UnsupportedOperationException("TO-DO: ¿hay dyn?"); //TODO
                case dynam:
                    output(EKernHeaders.edynam.getEncoding());
                    break;
                case kern:
                    output(EKernHeaders.ekern.getEncoding());
                    break;
            } // the other spine types are not encoded
        }

        @Override
        public void enterPart(kernParser.PartContext ctx) {
            super.enterPart(ctx);
        }

        @Override
        public void exitPart(kernParser.PartContext ctx) {
            super.exitPart(ctx);
            output(ctx.getText());
        }

        @Override
        public void exitBarline(kernParser.BarlineContext ctx) {
            super.exitBarline(ctx);
            // remove the number
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ctx.EQUAL().getText());
            if (ctx.barLineType() != null) {
                stringBuilder.append(ctx.barLineType().getText());
            }
            output(stringBuilder.toString());
        }

        @Override
        public void exitSpineOperation(kernParser.SpineOperationContext ctx) {
            super.exitSpineOperation(ctx);
            output(ctx.getText());
        }

        @Override
        public void exitSpineTerminator(kernParser.SpineTerminatorContext ctx) {
            super.exitSpineTerminator(ctx);
            this.spineTypes.remove(spineIndex);
            spineIndex--; // because we have removed it
        }

        @Override
        public void exitSpineJoin(kernParser.SpineJoinContext ctx) {
            super.exitSpineJoin(ctx);
            spineIndex--; // because we have removed it
        }

        @Override
        public void exitSpineAdd(kernParser.SpineAddContext ctx) {
            super.exitSpineAdd(ctx);
            this.spineTypes.add(spineIndex+1, this.spineTypes.get(spineIndex));
        }

        @Override
        public void exitSpineSplit(kernParser.SpineSplitContext ctx) {
            this.spineTypes.add(spineIndex+1, this.spineTypes.get(spineIndex));
        }

        @Override
        public void exitTandemInterpretation(kernParser.TandemInterpretationContext ctx) {
            super.exitTandemInterpretation(ctx);
            output(ctx.getText());
        }


        @Override
        public void exitRest(kernParser.RestContext ctx) {
            super.exitRest(ctx);
            StringBuilder stringBuilder = new StringBuilder();
            outputDuration(ctx.duration(), stringBuilder);
            for (TerminalNode terminalNode: ctx.CHAR_r()) {
                stringBuilder.append(terminalNode.getText());
            }
            if (ctx.fermata() != null) {
                stringBuilder.append(SEPARATOR);
                stringBuilder.append(ctx.fermata().getText());
            }
            output(stringBuilder.toString());
        }

        private void outputDuration(kernParser.DurationContext duration, StringBuilder stringBuilder) {
            stringBuilder.append(duration.modernDuration().number().getText());
            stringBuilder.append(SEPARATOR);
            if (duration.modernDuration().augmentationDot() != null && !duration.modernDuration().augmentationDot().isEmpty()) {
                for (kernParser.AugmentationDotContext augmentationDotContext: duration.modernDuration().augmentationDot()) {
                    stringBuilder.append(augmentationDotContext.getText());
                }
                stringBuilder.append(SEPARATOR);
            }
        }

        private void outputPitch(kernParser.PitchContext pitch, StringBuilder stringBuilder) {
            stringBuilder.append(pitch.diatonicPitchAndOctave().getText());
            if (pitch.alteration() != null) {
                stringBuilder.append(SEPARATOR);
                stringBuilder.append(pitch.alteration().accidental().getText());
                if (pitch.alteration().alterationDisplay() != null) {
                    stringBuilder.append(SEPARATOR);
                    stringBuilder.append(pitch.alteration().alterationDisplay().getText());
                }
            }
        }

        @Override
        public void exitNote(kernParser.NoteContext ctx) {
            super.exitNote(ctx);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i < ctx.beforeNote().getChildCount(); i++) {
                stringBuilder.append(ctx.beforeNote().getChild(i).getText());
                stringBuilder.append(SEPARATOR);
            }
            outputDuration(ctx.duration(), stringBuilder);
            outputPitch(ctx.pitch(), stringBuilder);
            for (int i=0; i < ctx.afterNote().getChildCount(); i++) {
                stringBuilder.append(SEPARATOR);
                stringBuilder.append(ctx.afterNote().getChild(i).getText());
            }
            if (this.currentChordStringBuilder != null) {
                // inside a chord
                this.currentChordStringBuilder.append(stringBuilder);
            } else {
                output(stringBuilder.toString());
            }

        }

        @Override
        public void enterChord(kernParser.ChordContext ctx) {
            super.enterChord(ctx);
            this.currentChordStringBuilder = new StringBuilder();
        }

        @Override
        public void exitChordSpace(kernParser.ChordSpaceContext ctx) {
            super.exitChordSpace(ctx);
            this.currentChordStringBuilder.append(ctx.getText());
        }

        @Override
        public void exitChord(kernParser.ChordContext ctx) {
            super.exitChord(ctx);
            output(currentChordStringBuilder.toString());
            currentChordStringBuilder = null;
        }

    }

    private String translateKern(CharStream input, String inputDescription) throws IMException {
        ErrorListener errorListener = new ErrorListener();
        try {
            Logger.getLogger(KernSyntaxDirectedTranslation2EKern.class.getName()).log(Level.INFO, "Parsing {0}", inputDescription);

            kernLexer lexer = new kernLexer(input);

            if (debug) {
                new ANTLRUtils().printLexer(lexer);
            }

            lexer.addErrorListener(errorListener);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            kernParser parser = new kernParser(tokens);
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.start();
            ParseTreeWalker walker = new ParseTreeWalker();
            Loader loader = new Loader(parser, debug);
            walker.walk(loader, tree);

            if (errorListener.getNumberErrorsFound() != 0) {
                throw new IMException(errorListener.getNumberErrorsFound() + " errors found in "
                        + inputDescription + "\n" + errorListener.toString());
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (LinkedList<String> row: loader.getTranslatedEKernMatrix()) {
                boolean first = true;
                for (String col: row) {
                    if (first) {
                        first = false;
                    } else {
                        stringBuilder.append('\t');
                    }
                    stringBuilder.append(col);
                }
                if (!first) {
                    // if not empty
                    stringBuilder.append('\n');
                }
            }


            return stringBuilder.toString();
        } catch (Throwable e) {
            e.printStackTrace();
            Logger.getLogger(KernSyntaxDirectedTranslation2EKern.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(KernSyntaxDirectedTranslation2EKern.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
            }

            throw new IMException(e.getMessage());
        }

    }

    public void translateKern(File inputFile, File outputFile) throws IMException {
        try {
            CharStream input = CharStreams.fromFileName(inputFile.getAbsolutePath());
            String translated = translateKern(input, inputFile.getAbsolutePath());
            byte[] strToBytes = translated.getBytes();
            Files.write(outputFile.toPath(), strToBytes);
        } catch (IOException e) {
            throw new IMException(e);
        }
    }

    public String translateKern(InputStream stream) throws IMException {
        try {
            CharStream input = CharStreams.fromStream(stream);
            return translateKern(input, "Stream");
        } catch (IOException e) {
            throw new IMException(e);
        }
    }

    public String translateKern(String string) throws IMException {
        CharStream input = CharStreams.fromString(string);
        return translateKern(input, string);
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
