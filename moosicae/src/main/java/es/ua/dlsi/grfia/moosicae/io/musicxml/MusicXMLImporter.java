package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;

/**
 * Use StAX for parsing
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MusicXMLImporter extends AbstractImporter {
    public MusicXMLImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory);
    }

    @Override
    public IScore importScore(String input) throws IMException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return importScore(inputStream);
    }

    @Override
    public IScore importScore(File file) throws IMException {
        try {
            InputStream inputStream = new FileInputStream(file);
            return importScore(inputStream);
        } catch (FileNotFoundException e) {
            throw new IMException(e);
        }
    }

    public IScore importScore(InputStream inputStream) throws IMException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "website":
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                }
            }

        } catch (XMLStreamException e) {
            throw new IMException(e);
        }

        return null;
    }
}
