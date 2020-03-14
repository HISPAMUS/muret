package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;
import es.ua.dlsi.grfia.moosicae.utils.CoreUtils;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Title implements ITitle {
    private final String title;

    public Title(String title) {
        CoreUtils.requireNotNullConstructorParam(this, title, "title");
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Title clone() {
        return new Title(title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return title.equals(title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                '}';
    }
}
