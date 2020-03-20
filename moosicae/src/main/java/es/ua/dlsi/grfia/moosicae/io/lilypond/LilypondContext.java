package es.ua.dlsi.grfia.moosicae.io.lilypond;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public class LilypondContext implements ILilypondElement {
    private final String name;
    private boolean useNew;
    private List<ILilypondElement> children;

    public LilypondContext(String name, boolean useNew) {
        this.name = name;
        this.useNew = useNew;
        this.children = new LinkedList<>();
    }

    public void addChild(ILilypondElement child) {
        if (child == this) {
            throw new IMRuntimeException("Trying to create as child the parent element itself");
        }
        this.children.add(child);
    }

    public void addChild(String string) {
        this.addChild(new LilypondLine(string));
    }

    @Override
    public String export(int tabs) {
        StringBuilder stringBuilder = new StringBuilder();

        String tabString = ILilypondElement.generateTabs(tabs);
        stringBuilder.append(tabString);
        stringBuilder.append('\\');
        if (useNew) {
            stringBuilder.append("new ");
        }
        stringBuilder.append(name);
        stringBuilder.append(" {");
        stringBuilder.append('\n');

        for (ILilypondElement lilypondElement: children) {
            stringBuilder.append(lilypondElement.export(tabs+1));
            stringBuilder.append('\n');
        }

        stringBuilder.append(tabString);
        stringBuilder.append('}');
        stringBuilder.append('\n');

        return stringBuilder.toString();
    }
}
