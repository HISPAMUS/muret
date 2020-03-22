package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPartBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPitchBuilder;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;
import es.ua.dlsi.grfia.moosicae.io.CoreObjectBuilderSuppliers;
import es.ua.dlsi.grfia.moosicae.io.ImportingContexts;

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
    private CoreObjectBuilderSuppliers coreObjectBuilderSuppliers;

    public MusicXMLImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory);
        coreObjectBuilderSuppliers = new CoreObjectBuilderSuppliers();
        coreObjectBuilderSuppliers.add("score-part", IPartBuilder::new);

        coreObjectBuilderSuppliers.add("note", INoteBuilder::new);
        coreObjectBuilderSuppliers.add("pitch", IPitchBuilder::new);
    }

    @Override
    public IScore importScore(String input) throws IMException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return importScore(inputStream);
    }

    public IScore importScore(File file) throws IMException {
        try {
            InputStream inputStream = new FileInputStream(file);
            return importScore(inputStream);
        } catch (FileNotFoundException e) {
            throw new IMException(e);
        }
    }

    public IScore importScore(InputStream inputStream) throws IMException {
        ImportingContexts importingContexts = new ImportingContexts();


        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
                    if (coreObjectBuilderSuppliers.contains(elementName)) {
                        importingContexts.begin(elementName, (CoreObjectBuilder<?>) coreObjectBuilderSuppliers.create(elementName, coreAbstractFactory));
                    } else {
                        switch (elementName) {
                        }
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    String elementName = endElement.getName().getLocalPart();

                    if (importingContexts.contains(elementName)) {
                        importingContexts.end(elementName);
                    } else {
                        switch (elementName) {
                        }
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new IMException(e);
        }
        return null;
    }
}
