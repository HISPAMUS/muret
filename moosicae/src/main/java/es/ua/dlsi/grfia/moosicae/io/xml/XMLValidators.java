package es.ua.dlsi.grfia.moosicae.io.xml;

import com.thaiopensource.util.PropertyMapBuilder;
import com.thaiopensource.validate.SchemaReader;
import com.thaiopensource.validate.ValidateProperty;
import com.thaiopensource.validate.ValidationDriver;
import com.thaiopensource.validate.auto.AutoSchemaReader;
import com.thaiopensource.validate.prop.rng.RngProperty;
import com.thaiopensource.xml.sax.ErrorHandlerImpl;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.Objects;

/**
 * Utilities for validating relaxNG using JING.
 * Based on the code in com.thaiopensource.relaxng.util.Driver
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 07/04/2020
 */
public class XMLValidators {
    public static void validateRelaxNG(InputStream relaxNGInputStream, File fileToBeValidated) throws IMException {
        Objects.requireNonNull(relaxNGInputStream, "RelaxNG input stream");
        ErrorHandlerImpl eh = new ErrorHandlerImpl(System.err);
        PropertyMapBuilder properties = new PropertyMapBuilder();
        properties.put(ValidateProperty.ERROR_HANDLER, eh);
        RngProperty.CHECK_ID_IDREF.add(properties);
        SchemaReader sr = null;

        try {
            ValidationDriver driver = new ValidationDriver(properties.toPropertyMap(), sr);
            //InputSource schemaInputSource = ValidationDriver.uriOrFileInputSource(uriOrFileRelaxNG);
            if (driver.loadSchema(new InputSource(relaxNGInputStream))) {
                InputSource in = new InputSource(new FileInputStream(fileToBeValidated));
                if (!driver.validate(in)) {
                    throw new IMException("Invalid relax ng xml file, see messages above");
                }
            }
            else {
                throw new IMException("Cannot load schema");
            }
        }
        catch (SAXException e) {
            throw new IMException(e);
        }
        catch (IOException e) {
            throw new IMException(e);
        }
    }

    public static void validateAgainstXSD(InputStream [] xsds, File fileToBeValidated) throws IMException {
        try {
          /*  SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false); // ignore DTD - it's generating problems
            factory.setNamespaceAware(true);

            SchemaFactory schemaFactory =
                    SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            factory.setSchema(schemaFactory.newSchema(
                    new Source[] {new StreamSource(xsd)}));

            SAXParser parser = factory.newSAXParser();

            XMLReader reader = parser.getXMLReader();
            reader.setErrorHandler(new SimpleErrorHandler());
            reader.parse(new InputSource(new FileInputStream(fileToBeValidated)));*/

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // ignore DTD - it's generating problems
            factory.setNamespaceAware(true);

            SchemaFactory schemaFactory =
                    SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            Source [] sources = new Source[xsds.length];
            for (int i=0; i<sources.length; i++) {
                sources[i] = new StreamSource(xsds[i]);
            }
            factory.setSchema(schemaFactory.newSchema(sources));

            DocumentBuilder builder = factory.newDocumentBuilder();

            builder.setErrorHandler(new SimpleErrorHandler());

            Document document = builder.parse(new FileInputStream(fileToBeValidated));
        } catch (Exception e) {
            throw new IMException(e);
        }
    }
}
