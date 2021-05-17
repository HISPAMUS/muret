package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.io.commonbuilders.KeyOrKeySignatureBuilder;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlFifths;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 02/04/2020
 */
public class MusicXMLKeyOrKeySignatureBuilder extends KeyOrKeySignatureBuilder {
    private MxmlFifths fifths;
    /**
     * We use alteration and not IAccidentalSymbol because the builder linked in MusicXMLImporter to <key-alter> returns IAlteration
     */
    private List<IAlteration> alterations;
    protected List<IDiatonicPitch> diatonicPitches;

    public MusicXMLKeyOrKeySignatureBuilder() {
        this.diatonicPitches = new ArrayList<>();
        this.alterations = new ArrayList<>();
    }

    public MusicXMLKeyOrKeySignatureBuilder from(MxmlFifths fifths) {
        this.fifths = fifths;
        return this;
    }

    public KeyOrKeySignatureBuilder add(IDiatonicPitch diatonicPitch) {
        diatonicPitches.add(diatonicPitch);
        return this;
    }

    public KeyOrKeySignatureBuilder add(IAlteration alteration) {
        alterations.add(alteration);
        return this;
    }


    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        super.read(xmlImporterParam);
    }


    @Override
    public IVoicedSingle build() throws IMException {
        if (fifths != null) {
            this.from(ICoreAbstractFactory.getInstance().createKeyAccidentalCount(null, fifths.getValue()));
            if (fifths.getAccidentalSymbol().isPresent()) {
                this.from(fifths.getAccidentalSymbol().get());
            }
        } else {
            if (this.alterations.size() != this.diatonicPitches.size()) {
                throw new IMException("The number of key-step (" + this.diatonicPitches.size() + ") is not the same as the alterations (" + this.alterations.size()+ ")");
            }

            for (int i=0; i<alterations.size(); i++) {
                IPitchClass pitchClass = ICoreAbstractFactory.getInstance().createPitchClass(null, diatonicPitches.get(i), alterations.get(i).getAccidentalSymbol());
                add(pitchClass);
            }
        }

        return super.build();
    }
}
