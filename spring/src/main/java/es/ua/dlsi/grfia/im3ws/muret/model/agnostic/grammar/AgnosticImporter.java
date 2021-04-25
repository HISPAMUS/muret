package es.ua.dlsi.grfia.im3ws.muret.model.agnostic.grammar;

import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.io.antlr.ErrorListener;
import es.ua.dlsi.im3.core.io.antlr.ParseError;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
public class AgnosticImporter {
    public static class Loader extends agnosticParserBaseListener {
        private final Parser parser;

        public Loader(Parser parser) {
            this.parser = parser;
        }
    }

    private void importAgnostic(CharStream input, String inputDescription) throws ImportException {
        ErrorListener errorListener = new ErrorListener();
        try {
            Logger.getLogger(AgnosticImporter.class.getName()).log(Level.INFO, "Parsing {0}", inputDescription);

            agnosticLexer lexer = new agnosticLexer(input);

            lexer.addErrorListener(errorListener);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            agnosticParser parser = new agnosticParser(tokens);
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.start();
            ParseTreeWalker walker = new ParseTreeWalker();
            Loader loader = new Loader(parser);
            walker.walk(loader, tree);
            if (errorListener.getNumberErrorsFound() != 0) {
                throw new ImportException(errorListener.getNumberErrorsFound() + " errors found in "
                        + inputDescription + "\n" + errorListener.toString());
            }

        } catch (Throwable e) {
            e.printStackTrace();
            Logger.getLogger(AgnosticImporter.class.getName()).log(Level.WARNING, "Import error {0}", e.getMessage());
            for (ParseError pe : errorListener.getErrors()) {
                Logger.getLogger(AgnosticImporter.class.getName()).log(Level.WARNING, "Parse error: {0}", pe.toString());
            }

            throw new ImportException(e.getMessage());
        }
    }

    public void importAgnostic(File file) throws ImportException {
        try {
            CharStream input = CharStreams.fromFileName(file.getAbsolutePath());
            importAgnostic(input, file.getAbsolutePath());
        } catch (IOException e) {
            throw new ImportException(e);
        }
    }

    public void importSKernMens(String string) throws ImportException {
        CharStream input = CharStreams.fromString(string);
        importAgnostic(input, string);
    }
}
