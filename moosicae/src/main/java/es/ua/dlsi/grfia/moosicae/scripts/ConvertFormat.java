package es.ua.dlsi.grfia.moosicae.scripts;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.FormatConverter;
import es.ua.dlsi.grfia.moosicae.utils.LoggerLevels;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * It converts bewteen formats
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/5/21
 */
public class ConvertFormat {
    public static final void main(String [] args) throws IMException, IOException {
        if (args.length != 2) {
            throw new IMException("Use ConvertFormat <input file> <output file>");
        }

        try {
            LoggerLevels.changeLevel(Level.WARNING);
            FormatConverter formatConverter = new FormatConverter();
            formatConverter.convert(new File(args[0]), new File(args[1]));
            System.out.println("Conversion done");
        } catch (Throwable t) {
            System.err.println("Error with input file " + args[0]);
            t.printStackTrace();
            throw t;
        }
    }
}
