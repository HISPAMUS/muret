package es.ua.dlsi.grfia.moosicae.io.commonbuilders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EConventionalKeys;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.core.enums.ETheoreticalKeys;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * It generates a key or a key signature depending on the presence of the mode element as a child of the key element or not
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class KeyOrKeySignatureBuilder extends CoreObjectBuilder<ICoreItem> implements IImporterAdapter<ICoreItem, XMLImporterParam> {
    protected IKeyAccidentalCount keyAccidentalCount;
    protected IMode mode;
    protected EAccidentalSymbols accidentalSymbol;
    protected List<IPitchClass> pitchClassList;

    public KeyOrKeySignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        this.pitchClassList = new LinkedList<>();
    }

    public KeyOrKeySignatureBuilder from(IKeyAccidentalCount keyAccidentalCount) {
        this.keyAccidentalCount = keyAccidentalCount;
        return this;
    }

    public KeyOrKeySignatureBuilder from(EAccidentalSymbols accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    public KeyOrKeySignatureBuilder from(IMode mode) {
        this.mode = mode;
        return this;
    }

    public KeyOrKeySignatureBuilder add(IPitchClass pitchClass) {
        this.pitchClassList.add(pitchClass);
        return this;
    }


    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
    }

    @Override
    public ICoreItem build() throws IMException {
        if (keyAccidentalCount != null) {
            int fifths = this.keyAccidentalCount.getValue();

            EModes eMode;
            if (mode == null) {
                // look for key using a major mode, and return only the key signature
                eMode = EModes.major;
            } else {
                eMode = mode.getValue();
            }

            EConventionalKeys ekey = EConventionalKeys.findKeyWithAccidentalCount(eMode, fifths, accidentalSymbol);
            IKey key = coreObjectFactory.createConventionalKey(null, ekey);

            if (mode == null) {
                return key.getKeySignature(); // it the mode element was not present, just return the key signature value
            } else {
                return key;
            }
        } else {
            if (mode == null) {
                // it's a key signature without mode
                return coreObjectFactory.createUnconventionalKeySignature(null, pitchClassList.toArray(new IPitchClass[0]));
            } else {
                // try to find a theoretical key
                Optional<ETheoreticalKeys> theoreticalKeys = ETheoreticalKeys.find(mode.getValue(), pitchClassList);
                if (theoreticalKeys.isPresent()) {
                    IKey key = coreObjectFactory.createTheoreticalKey(null, theoreticalKeys.get());
                    return key;
                } else {
                    return coreObjectFactory.createUnconventionalKeySignature(null, pitchClassList.toArray(new IPitchClass[0]));
                }
            }
        }
    }
}
