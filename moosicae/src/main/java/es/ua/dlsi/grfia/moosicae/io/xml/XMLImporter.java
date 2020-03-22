package es.ua.dlsi.grfia.moosicae.io.xml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;
import es.ua.dlsi.grfia.moosicae.io.CoreObjectBuilderSuppliers;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.ImportingContexts;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
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
public abstract class XMLImporter<ImporterVisitor extends IImporterVisitor<IXMLImporterVisitorParam>> extends AbstractImporter {
    protected final CoreObjectBuilderSuppliers coreObjectBuilderSuppliers;
    protected final ImporterVisitor xmlImporterVisitor;
    private Stack<String> elementStack;
    private Stack<CoreObjectBuilder<?>> builderStack;
    protected ImportingContexts importingContexts;

    public XMLImporter(ICoreAbstractFactory abstractFactory, ImporterVisitor importerVisitor) {
        super(abstractFactory);
        coreObjectBuilderSuppliers = new CoreObjectBuilderSuppliers();
        this.xmlImporterVisitor = importerVisitor;
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
        importingContexts = new ImportingContexts();
        elementStack = new Stack<>();
        builderStack = new Stack<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    handleStartElement(startElement);
                    elementStack.push(startElement.getName().getLocalPart());
                } else if (nextEvent.isCharacters()) {
                    Characters characters = nextEvent.asCharacters();
                    String data = characters.getData().trim();
                    if (!data.isEmpty()) {
                        handleCharacters(elementStack.peek(), data.trim());
                    }
                } else if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    handleEndElement(endElement);
                    elementStack.pop();
                }
            }
        } catch (XMLStreamException e) {
            throw new IMException(e);
        }
        return null;
    }


    /**
     * @param startElement
     * @return True if handled and consumed
     */
    protected abstract boolean handleSpecialStartElement(StartElement startElement);

    /**
     * @param data
     * @return True if handled and consumed
     */
    protected abstract boolean handleSpecialCharactersElement(String elementName, String data);

    /**
     * @param endElement
     * @return True if handled and consumed
     */
    protected abstract boolean handleSpecialEndElement(EndElement endElement);

    private void handleStartElement(StartElement startElement) throws IMException {
        if (!handleSpecialStartElement(startElement)) {
            String elementName = startElement.getName().getLocalPart();
            if (coreObjectBuilderSuppliers.contains(elementName)) {
                CoreObjectBuilder<?> coreObjectBuilder = (CoreObjectBuilder<?>) importingContexts.begin(elementName,
                        (CoreObjectBuilder<?>) coreObjectBuilderSuppliers.create(elementName, coreAbstractFactory));
                builderStack.push(coreObjectBuilder);
                coreObjectBuilder.doImport(xmlImporterVisitor, new XMLImporterVisitorAtrributes(startElement.getAttributes()));
            }
        }
    }


    private void handleCharacters(String elementName, String data) {
        if (!handleSpecialCharactersElement(elementName, data)) {
            if (coreObjectBuilderSuppliers.contains(elementName)) {
                CoreObjectBuilder<?> currentBuilder = builderStack.peek();
                currentBuilder.doImport(xmlImporterVisitor, new XMLImporterVisitorCharacters(data));
            }
        }
    }


    private void handleEndElement(EndElement endElement) throws IMException {
        String elementName = endElement.getName().getLocalPart();

        if (!handleSpecialEndElement(endElement)) {
            if (importingContexts.contains(elementName)) {
                importingContexts.end(elementName);
                builderStack.pop();
            }
        }
    }

}
