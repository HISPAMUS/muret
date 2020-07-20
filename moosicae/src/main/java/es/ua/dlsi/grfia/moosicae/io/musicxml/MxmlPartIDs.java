package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MxmlPartIDs {
    private HashMap<IPart, String> partIDs;

    public MxmlPartIDs() {
        this.partIDs =  new HashMap<>();
    }

    String getID(IPart part) {
        String id = partIDs.get(part);
        if (id != null) {
            return id;
        } else {
            Optional<IId> iid = part.getId();
            String value;
            if (iid.isPresent()) {
                value = part.getId().get().getValue();
            } else {
                value = "P" + (partIDs.size() + 1);
            }
            partIDs.put(part, value);
            return value;
        }
    }
}