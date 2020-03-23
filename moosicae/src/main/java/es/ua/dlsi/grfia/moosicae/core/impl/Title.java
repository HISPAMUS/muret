package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.CoreProperty;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Title extends CoreProperty implements ITitle {
    @NotNull
    private final String title;

    public Title(@NotNull IId id, @NotNull String title) {
        super(id);
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Title clone() {
        return new Title(IdGenerator.getInstance().generateUniqueId(), title);
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
