package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.MEIMeasureRightProperty;

import javax.validation.constraints.NotNull;
import java.util.Optional;

//TODO creo que aquí debemos poner los <sb>
/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIMeasure implements ICoreObject {
    private final MEIMeasureRightProperty right;
    @NotNull
    private final IId id;

    @NotNull
    private MEIStaff [] staves;

    public MEIMeasure(@NotNull IId id, MEIMeasureRightProperty right, MEIStaff [] staves) {
        this.id = id;
        this.right = right;
        this.staves = staves.clone();
    }

    @Override
    public IId getId() {
        return id;
    }

    public MEIStaff[] getStaves() {
        return staves;
    }

    @Override
    public MEIMeasure clone() {
        return new MEIMeasure(id, right, staves);
    }

    public Optional<MEIMeasureRightProperty> getRight() {
        return Optional.ofNullable(right);
    }
}
