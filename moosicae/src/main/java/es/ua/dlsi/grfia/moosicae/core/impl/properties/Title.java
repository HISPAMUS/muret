package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.CoreProperty;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Title extends CoreProperty implements ITitle {
    @NotNull
    private final String title;

    public Title(IId id, @NotNull String title) {
        super(id);
        this.title = title;
    }

    @Override
    public String getValue() {
        return title;
    }

    @Override
    public Title clone() {
        return new Title(null, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;

        Title title1 = (Title) o;

        return title.equals(title1.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                '}';
    }
}
