package es.ua.dlsi.grfia.im3ws.muret.entity;

import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import org.junit.Test;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class AgnosticSymbolConverterTest {
    @Test
    public void convertToEntityAttribute() {
        AgnosticSymbolConverter agnosticSymbolConverter = new AgnosticSymbolConverter();
        String colon = "colon:L-1";
        AgnosticSymbol symbol = agnosticSymbolConverter.convertToEntityAttribute("colon:L-1");
        assertEquals(colon, symbol.getAgnosticString());
    }
}
