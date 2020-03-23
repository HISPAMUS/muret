package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;


import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * It contains clef changes, keys, meters..
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MusicXMLAttributes implements IMusicXMLPartItem {

    @NotNull
    private final INonDurational [] nonDurationalList;

    public MusicXMLAttributes( INonDurational [] nonDurationalList ) {
        this.nonDurationalList = nonDurationalList.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicXMLAttributes)) return false;

        MusicXMLAttributes that = (MusicXMLAttributes) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(nonDurationalList, that.nonDurationalList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(nonDurationalList);
    }

    @Override
    public IId getId() {
        return null;
    }

    @Override
    public ICoreObject clone() {
        return null;
    }



    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {

    }

    @Override
    public ICoreItem[] getItems() {
        return nonDurationalList;
    }
}
