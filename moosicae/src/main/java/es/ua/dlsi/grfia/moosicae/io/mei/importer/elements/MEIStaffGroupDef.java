package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffGroupDef extends MEISystemDef {
    private final MEISystemDef[] children;

    //TODO barrados...
    public MEIStaffGroupDef(IId id, MEISystemDef[] children) {
        super(id);
        this.children = children;
    }

    @Override
    public MEIStaffGroupDef clone() {
        return new MEIStaffGroupDef(null, children.clone());
    }

    public MEISystemDef[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "MEIStaffGroupDef{" +
                "children=" + Arrays.toString(children) +
                "} " + super.toString();
    }
}
