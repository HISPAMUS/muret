package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 02/04/2020
 */
public class MxmlFifths extends MxmlObject {
    @NotNull
    private Integer value;

    private EAccidentalSymbols accidentalSymbol;

    public MxmlFifths(IId id, @NotNull Integer value) {
        super(id);
        if (value < 0) {
            this.value = -value;
            accidentalSymbol = EAccidentalSymbols.FLAT;
        } else if (value == 0) {
            this.value = 0;
            accidentalSymbol = null;
        } else {
            this.value = value;
            accidentalSymbol = EAccidentalSymbols.SHARP;
        }
    }

    public Integer getValue() {
        return value;
    }

    public Optional<EAccidentalSymbols> getAccidentalSymbol() {
        return Optional.ofNullable(accidentalSymbol);
    }

    @Override
    public MxmlFifths clone() {
        return new MxmlFifths(null, value);
    }
}
