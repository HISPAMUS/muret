package es.ua.dlsi.grfia.moosicae.core.enums;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.adt.IFraction;
import es.ua.dlsi.grfia.moosicae.core.adt.IFractionBuilder;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.adt.ITimeBuilder;
import es.ua.dlsi.grfia.moosicae.core.impl.adt.FractionBuilder;
import es.ua.dlsi.grfia.moosicae.core.impl.adt.TimeBuilder;
import es.ua.dlsi.grfia.moosicae.utils.Pair;

// TODO: 22/9/17 Que tenga plica o no depende de la tipografía?
// TODO: revisar lo de la plica - no lo quito porque ya lo tengo metido...
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public enum EFigures implements Comparable<EFigures> {
    OCTUPLE_WHOLE(32, 1, -1, ENotationTypes.eModern, EFigureVisualDecorations.none, 0),
    QUADRUPLE_WHOLE(16, 1, -1, ENotationTypes.eModern, EFigureVisualDecorations.none, 0),
    DOUBLE_WHOLE(8, 1, 0, ENotationTypes.eModern, EFigureVisualDecorations.none, 0),
    WHOLE(4, 1, 1, ENotationTypes.eModern, EFigureVisualDecorations.none, 0),
    HALF(2, 1, 2, ENotationTypes.eModern, EFigureVisualDecorations.stem, 0),
    QUARTER(1, 1, 4, ENotationTypes.eModern, EFigureVisualDecorations.stem, 0),
    EIGHTH(1, 2, 8, ENotationTypes.eModern, EFigureVisualDecorations.stem, 1),
    SIXTEENTH(1, 4, 16, ENotationTypes.eModern, EFigureVisualDecorations.stem, 2),
    THIRTY_SECOND(1, 8, 32, ENotationTypes.eModern, EFigureVisualDecorations.stem, 3),
    SIXTY_FOURTH(1, 16, 64, ENotationTypes.eModern, EFigureVisualDecorations.stem, 4),
    HUNDRED_TWENTY_EIGHTH(1, 32, 128, ENotationTypes.eModern, EFigureVisualDecorations.stem, 5),
    TWO_HUNDRED_FIFTY_SIX(1, 64, 256, ENotationTypes.eModern, EFigureVisualDecorations.stem, 6),
    MAXIMA(32, 1, -2, ENotationTypes.eMensural, EFigureVisualDecorations.stem, 0),
    LONGA(16, 1, -1, ENotationTypes.eMensural, EFigureVisualDecorations.stem, 0),
    BREVE(8, 1, 0, ENotationTypes.eMensural, EFigureVisualDecorations.none, 0),
    SEMIBREVE(4, 1, 1, ENotationTypes.eMensural, EFigureVisualDecorations.none, 0),
    MINIM(2, 1, 2, ENotationTypes.eMensural, EFigureVisualDecorations.stemAndFlag, 0),
    SEMIMINIM(1, 1, 4, ENotationTypes.eMensural, EFigureVisualDecorations.stemAndFlag, 0),
    FUSA(1, 2, 8, ENotationTypes.eMensural, EFigureVisualDecorations.stemAndFlag, 1),
    SEMIFUSA(1, 4, 16, ENotationTypes.eMensural, EFigureVisualDecorations.stemAndFlag, 2);

    static EFigures[] SORTED_DESC_MENSURAL = new EFigures[]{
            MAXIMA, LONGA, BREVE, SEMIBREVE, MINIM, SEMIMINIM, FUSA, SEMIFUSA
    };

    static EFigures[] SORTED_DESC_MODERN = new EFigures[]{
            QUADRUPLE_WHOLE, DOUBLE_WHOLE, WHOLE, HALF, QUARTER, EIGHTH, SIXTEENTH, THIRTY_SECOND, SIXTY_FOURTH, HUNDRED_TWENTY_EIGHTH, TWO_HUNDRED_FIFTY_SIX
    };

    final ITime duration;
    /**
     * Classical interpretation (the one used in denominators of meters)
     */
    final int meterUnit;
    final ENotationTypes notationType;

    final EFigureVisualDecorations decoration;
    final int numFlags;
    private final ITime ratio;

    EFigures(int quarters, int quarterSubdivisions, int meterUnit, ENotationTypes notationType, EFigureVisualDecorations decoration, int flags) {
        duration = ITimeBuilder.getInstance().build(quarters, quarterSubdivisions);
        this.meterUnit = meterUnit;
        this.notationType = notationType;
        this.decoration = decoration;
        this.numFlags = flags;
        this.ratio = ITimeBuilder.getInstance().build(quarters, quarterSubdivisions);
    }

    public ITime getDuration() {
        return duration;
    }

    public int getMeterUnit() {
        return meterUnit;
    }

    public final ENotationTypes getENotationType() {
        return notationType;
    }

    public boolean usesFlag() {
        return (decoration == EFigureVisualDecorations.stemAndFlag || decoration == EFigureVisualDecorations.stem) && numFlags > 0;
    }

    public boolean usesStem() {
        return decoration == EFigureVisualDecorations.stem || decoration == EFigureVisualDecorations.stemAndFlag;
    }

    public boolean usesCombinedStemAndFlag() {
        return decoration == EFigureVisualDecorations.stemAndFlag;
    }


    public ITime getRatio() {
        return ratio;
    }

    /**
     * Compute the duration of the figure using dots
     *
     * @param dots
     * @return
     */
    public ITime getDurationWithDots(int dots) {
        IFraction sumDurations = duration.getExactTime();
        IFraction lastDur = sumDurations;

        for (int i = 0; i < dots; i++) {
            lastDur = lastDur.multiplyBy(IFractionBuilder.getInstance().getOneHalf());
            sumDurations = sumDurations.add(lastDur);
        }

        return ITimeBuilder.getInstance().build(sumDurations);
    }

    public static EFigures findDuration(ITime duration, ENotationTypes notationType) throws IMException {
        if (notationType == null) {
            throw new IMException("Cannot search a duration if notationType is null");
        }
        for (EFigures fig : EFigures.values()) {
            if (fig.notationType == notationType && fig.duration.equals(duration)) {
                return fig;
            }
        }
        throw new IMException("Cannot find a figure with duration " + duration + " and notation type " + notationType);
    }

    public static Pair<EFigures, Integer> findDurationWithDots(ITime duration, ENotationTypes notationType) throws IMException {
        if (notationType == null) {
            throw new IMException("Cannot search a duration if notationType is null");
        }
        for (EFigures fig : EFigures.values()) {
            ITime figureDuration = fig.getDuration();
            for (int i=0; i<5; i++) { // maximum 5 dots
                if (fig.notationType == notationType && figureDuration.equals(duration)) {
                    return new Pair<>(fig, i);
                }
                figureDuration = figureDuration.add(figureDuration.divide(2));
            }
        }
        throw new IMException("Cannot find a figure (and dots) with duration " + duration + " and notation type " + notationType);
    }

    public static EFigures findMeterUnit(int meterUnit, ENotationTypes notationType) throws IMException {
        for (EFigures fig : EFigures.values()) {
            if (fig.notationType == notationType && meterUnit == fig.meterUnit) {
                return fig;
            }
        }
        throw new IMException("Cannot find a figure with meter unit " + meterUnit + " and notation type " + notationType);
    }

    public static EFigures findFigureWithFlags(int flags, ENotationTypes notationType) throws IMException {
        for (EFigures fig : EFigures.values()) {
            if (fig.notationType == notationType && flags == fig.numFlags) {
                return fig;
            }
        }
        throw new IMException("Cannot find a figure with flags " + flags + " and notation type " + notationType);
    }

    public int getNumFlags() {
        return numFlags;
    }

    public static EFigures[] getEFiguresSortedDesc(ENotationTypes notationType) {
        if (notationType == ENotationTypes.eMensural) {
            return SORTED_DESC_MENSURAL;
        } else if (notationType == ENotationTypes.eModern) {
            return SORTED_DESC_MODERN;
        } else {
            throw new IMRuntimeException("Unknown notation type " + notationType);
        }
    }
}
