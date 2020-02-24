package es.ua.dlsi.grfia.im4.core.io.antlr4;

import org.antlr.v4.runtime.*;

public class ANTLRUtils {
    private static StringBuilder printTabs(ParserRuleContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        while (ctx.getParent() != null) {
            stringBuilder.append("\t");
            ctx = ctx.getParent();
        }
        return stringBuilder;
    }
    private static String getTokenText(ParserRuleContext ctx) {
        if (ctx.getText().equals("\t")) {
            return "\\t";
        } else if (ctx.getText().equals("\n")) {
            return "\\n";
        } else if (ctx.getText().equals("\r")) {
            return "\\r";
        } else if (ctx.getText().equals("\r\n")) {
            return "\\r\\n";
        } else {
            return ctx.getText();
        }
    }
    public static String getRuleDescription(Parser parser, ParserRuleContext ctx, String prefix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(printTabs(ctx));
        stringBuilder.append(prefix);
        stringBuilder.append(" RULE <" + parser.getRuleNames()[ctx.getRuleIndex()] + ">\t");
        stringBuilder.append("FROM: <" + getTokenText(ctx) + "> @");
        stringBuilder.append("(" + ctx.getStart().getLine() + ", " + ctx.getStart().getCharPositionInLine() + ")");
        stringBuilder.append("\tTO: <" + getTokenText(ctx) + "> @");
        stringBuilder.append("(" + ctx.getStop().getLine() + ", " + ctx.getStart().getCharPositionInLine() + ")");

        return stringBuilder.toString();
    }

    public static void printLexer(Lexer lexer) {
        String [] modes = lexer.getModeNames();
        System.out.println("----- LEXER MODES ----");
        for (String mode: modes) {
            System.out.println("\t" + mode);
        }

        System.out.println("----- LEXER START ----");
        TokenSource tokenSource = lexer;
        while (true) {
            Token token = tokenSource.nextToken();
            if (token.getType() == Lexer.EOF) {
                break;
            }

            System.out.print("Mode <" + modes[lexer._mode] + ">\t");
            System.out.print("Line #" + token.getLine() + "\tColumn #" + token.getCharPositionInLine() + "\t");

            if (token.getText().equals("\n")) {
                System.out.println("Token: <\\n>");
            } else if (token.getText().equals("\t")) {
                System.out.println("Token: <\\t>");
            } else {
                System.out.println("Token: <" + token.getText() + ">");
            }
        }
        System.out.println("----- LEXER END ----");

        lexer.reset(); // leave lexer as it was
    }
}
