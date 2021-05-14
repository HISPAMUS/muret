package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.enums.EGraceNoteType;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 13/05/2020
 */
public class IGraceNoteTypeBuilder extends CoreObjectBuilder<IGraceNoteType> {
    private EGraceNoteType value;

    public IGraceNoteTypeBuilder() {}

    public IGraceNoteTypeBuilder from(EGraceNoteType value) {
        this.value = value;
        return this;
    }


    @Override
    public IGraceNoteType build() throws IMException {
        return ICoreAbstractFactory.getInstance().createGraceNoteType(getId(), value);
    }


}
