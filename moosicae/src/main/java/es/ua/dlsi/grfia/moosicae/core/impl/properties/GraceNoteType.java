package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.enums.EGraceNoteType;
import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 13/05/2020
 */
public class GraceNoteType extends EnumCoreProperty<EGraceNoteType> implements IGraceNoteType {
    public GraceNoteType(IId id, @NotNull EGraceNoteType enumValue) {
        super(id, enumValue);
    }

    @Override
    public GraceNoteType clone() {
        return new GraceNoteType(null, value);
    }

}
