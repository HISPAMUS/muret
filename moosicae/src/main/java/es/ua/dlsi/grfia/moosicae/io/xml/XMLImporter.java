package es.ua.dlsi.grfia.moosicae.io.xml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.io.*;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use StAX for parsing
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public abstract class XMLImporter {
    private Stack<String> elementStack;
    private Stack<IImporterAdapter<?, XMLImporterParam>> builderStack;
    protected ImportingContexts<ICoreObject> importingContexts;
    protected final ICoreAbstractFactory coreAbstractFactory;
    protected final CoreObjectBuilderSuppliers coreObjectBuilderSuppliers;

    public XMLImporter(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
        this.coreObjectBuilderSuppliers = new CoreObjectBuilderSuppliers();
    }

    public abstract void validate(File fileToBeValidated) throws IMException;

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
        return buildScore();
    }

    protected abstract IScore buildScore() throws IMException;

    private void handleStartElement(StartElement startElement) throws IMException {
        String elementName = startElement.getName().getLocalPart();
        // if there is an specific builder associated to this element name, create it and import it with the specific importer visitor
        // e.g. <note> may be imported with a INoteBuilder
        // If the importer is MEIImporterVisitor, there will be a method in MEIImporterVisitor able to import the specifics of MEI
        // and insert them into the INoteBuilder
        if (coreObjectBuilderSuppliers.contains(elementName)) {
            IImporterAdapter<?, XMLImporterParam> coreObjectBuilder = (IImporterAdapter<?, XMLImporterParam>) importingContexts.begin(elementName,
                    (IObjectBuilder<ICoreObject>) coreObjectBuilderSuppliers.create(elementName, coreAbstractFactory));
            builderStack.push(coreObjectBuilder);
            // coreObjectBuilder.doImport(xmlImporterVisitor, new XMLImporterVisitorParam(startElement.getAttributes()));
            XMLImporterParam importerParam = new XMLImporterParam(startElement.getAttributes());
            if (importerParam.getCharacters().isPresent() || importerParam.hasAttributes()) {
                coreObjectBuilder.read(importerParam);
            }
        }
    }


    private void handleCharacters(String elementName, String data) throws IMException {
        IImporterAdapter<?, XMLImporterParam> currentBuilder = null;
        if (!builderStack.isEmpty()) {
            currentBuilder = builderStack.peek();
        }
        // if there is an specific builder associated to this element name, handle the contents using the specific importer visitor
        if (coreObjectBuilderSuppliers.contains(elementName)) {
            if (currentBuilder != null && !data.isEmpty()) {
                //currentBuilder.doImport(xmlImporterVisitor, new XMLImporterVisitorParam(data));
                XMLImporterParam importerParam = new XMLImporterParam(data);
                currentBuilder.read(importerParam);

            }
        }
    }


    private void handleEndElement(EndElement endElement) throws IMException {
        String elementName = endElement.getName().getLocalPart();

        // if there is an specific builder associated to this element name, finish the context
        // (it will build an object and prepare it for the parent context to be inserted)
        if (importingContexts.contains(elementName)) {
            Object coreObject = importingContexts.end(elementName);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Parsed element {0} into object {1} = {2}", new Object[] { elementName, coreObject.getClass().getName(), coreObject });
            onEndElement(elementName, coreObject);
            builderStack.pop();
        }
    }

    protected abstract void onEndElement(String elementName, Object end);

}
