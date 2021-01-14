package es.ua.dlsi.grfia.moosicae.core;


import es.ua.dlsi.grfia.moosicae.core.properties.IName;

import java.util.Optional;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPart extends IMooObject {
    Optional<IName> getName();
    void setName(String name);

    void add(IVoice voice);

    IVoice[] getVoices();
    void remove(IVoice voice);
}
