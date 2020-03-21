package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.INote;
import es.ua.dlsi.grfia.moosicae.core.IPitch;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPitchBuilder;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.Stack;

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

    public IScore importScore(File file) throws IMException {
        try {
            InputStream inputStream = new FileInputStream(file);
            return importScore(inputStream);
        } catch (FileNotFoundException e) {
            throw new IMException(e);
        }
    }

    public IScore importScore(InputStream inputStream) throws IMException {
       /* XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);

            StackMap<String, ImporterContext<?>> importerContexts = new StackMap<>();
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "part":
                            ImporterContext<IPartBuilder> partBuilderImporterContext = new ImporterContext<>(coreAbstractFactory);
                            importerContexts.push("part", partBuilderImporterContext);
                            break;
                        case "note":
                            ImporterContext<INoteBuilder> noteImporterContext = new ImporterContext<>(new INoteBuilder(coreAbstractFactory));
                            importerContexts.peekRequired("part").add(noteImporterContext);
                            break;
                        case "pitch":
                            ImporterContext<IPitchBuilder> pitchImporterContext = new ImporterContext<>(new IPitchBuilder(coreAbstractFactory));
                            importerContexts.peekRequired("note").add(pitchImporterContext);
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    switch (endElement.getName().getLocalPart()) {
                        case "note":
                            ImporterContext<INoteBuilder> noteImporterContext = (ImporterContext<INoteBuilder>) importerContexts.pop();
                            noteImporterContext.build();
                            break;

                    }
                }
            }

        } catch (XMLStreamException e) {
            throw new IMException(e);
        }
*/
        return null;
    }
}
