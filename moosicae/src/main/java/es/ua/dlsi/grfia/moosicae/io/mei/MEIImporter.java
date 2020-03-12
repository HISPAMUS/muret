package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;
import es.ua.dlsi.grfia.moosicae.io.builders.IClefBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

/**
 * Use DOM for importing, maybe a little bit slower than STAX or SAX but we have more control
 */
public class MEIImporter extends AbstractImporter {

    /**
     * It uses the default core factory
     */
    public MEIImporter() {
    }

    public MEIImporter(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public IScore importScore(String input) throws IMException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IMException("Cannot configure DOM parser", e);
        }

        try {
            Document doc = db.parse(new InputSource( new StringReader( input )));
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("mei");
            if (nList == null || nList.getLength() != 1) {
                int count = nList == null ? 0 : nList.getLength();
                throw new IMException("Expected one top element named 'mei' and found '" + count);
            }
            IScore score = coreAbstractFactory.createScore();

            //TODO quitar la inicialización a pelo
            IPart part = coreAbstractFactory.createPart(score);
            IVoice voice = coreAbstractFactory.createVoice(part);
            IStaff staff = coreAbstractFactory.createStaff(score);


            parse(nList.item(0), score, voice, staff); //TODO quitar voice y staff
            return score;
        } catch (SAXException | IOException e) {
            throw new IMException("Cannot parse string", e);
        }
    }

    private void parse(Node node, IScore score, IVoice voice, IStaff staff) throws IMException {
        switch (node.getNodeName()) { // removing this switch makes it much more difficult
            case "staffDef":
                processStaffDef(node, voice, staff);
                break;
        }
    }

    private Optional<String> getAttrValue(Node node, String name) {
        if (node.getAttributes() == null) {
            return Optional.empty();
        } else {
            Node attribute = node.getAttributes().getNamedItem(name);
            if (attribute != null) {
                return Optional.ofNullable(attribute.getNodeValue());
            } else {
                return Optional.empty();
            }

        }
    }

    private void processStaffDef(Node node, IVoice voice, IStaff staff) throws IMException {
        Optional<String> clefShape = getAttrValue(node, "clef.shape");
        if (clefShape.isPresent()) {
            IClefBuilder clefBuilder = builderFactory.getClefBuilder();
            clefBuilder.addProperty(IClefBuilder.PROP_SHAPE, clefShape.get());
            Optional<String> clefLine = getAttrValue(node, "clef.line");
            if (clefLine.isPresent()) {
                builderFactory.getClefBuilder().addProperty(IClefBuilder.PROP_LINE, clefLine.get());
            }

            IClef clef = clefBuilder.build();
            voice.addItem(clef);
            staff.addItem(clef);
        }
    }
}
