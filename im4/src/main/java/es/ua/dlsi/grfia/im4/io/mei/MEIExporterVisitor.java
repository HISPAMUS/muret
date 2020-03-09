package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.core.impl.*;
import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.IMeter;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;
import es.ua.dlsi.grfia.im4.utils.xml.XMLAttribute;
import es.ua.dlsi.grfia.im4.utils.xml.XMLElement;

public class MEIExporterVisitor implements IExporterVisitor<MEIExporterContext> {
    @Override
    public void export(IClef clef, MEIExporterContext context) {
        String meiLine = Integer.toString(clef.getLine());
        String meiSign = MEIFactory.getInstance().generateClefSign(clef.getSign());

        if (context.isResultAddedAsAttribute()) {
            context.getXmlElement().addAttribute(new XMLAttribute("clef.line", meiLine));
            context.getXmlElement().addAttribute(new XMLAttribute("clef.line", meiLine));
        } else {
            XMLElement xmlClef = new XMLElement("clef");
            xmlClef.addChild(new XMLElement("line", meiLine));
            xmlClef.addChild(new XMLElement("shape", meiSign));
            context.getXmlElement().addChild(xmlClef);
        }
    }

    @Override
    public void export(IMeter meter, MEIExporterContext context) {

    }


    @Override
    public void export(Part part, MEIExporterContext context) {

    }

    @Override
    public void export(Voice voice, MEIExporterContext context) {

    }


}
