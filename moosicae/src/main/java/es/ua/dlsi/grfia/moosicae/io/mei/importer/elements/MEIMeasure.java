package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ILeftBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.core.properties.IRightBarline;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Optional;

//TODO creo que aquí debemos poner los <sb>
/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIMeasure extends MEIObject implements IMeiSectionItem {
    private final INumber number;
    private final ILeftBarline leftBarline;
    private final IRightBarline rightBarline;

    @NotNull
    private MEIStaff[] staves;

    public MEIMeasure(IId id, INumber number, ILeftBarline left, IRightBarline right, MEIStaff[] staves) {
        super(id);
        this.number = number;
        this.leftBarline = left;
        this.rightBarline = right;
        this.staves = staves.clone();
    }
    public MEIStaff[] getStaves() {
        return staves;
    }

    @Override
    public MEIMeasure clone() {
        return new MEIMeasure(null, number, leftBarline, rightBarline, staves);
    }
    public Optional<INumber> getNumber() {
        return Optional.ofNullable(number);
    }
    public Optional<ILeftBarline> getLeftBarline() {
        return Optional.ofNullable(leftBarline);
    }
    public Optional<IRightBarline> getRightBarline() {
        return Optional.ofNullable(rightBarline);
    }

    @Override
    public String toString() {
        return "MEIMeasure{" +
                "left=" + leftBarline +
                "right=" + rightBarline +
                ", staves=" + Arrays.toString(staves) +
                "} " + super.toString();
    }
}
