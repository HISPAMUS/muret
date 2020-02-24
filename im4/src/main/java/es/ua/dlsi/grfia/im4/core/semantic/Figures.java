package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.Time;
import org.apache.commons.lang3.math.Fraction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

enum Decoration {
	none, stem, stemAndFlag
}

//TODO ¿Cómo codificamos cuadruple whole?
/**
 * The figures must be mantained in descending length
 */
public enum Figures implements Comparable<Figures> {
	MAX_FIGURE ("_MAX_FIGURE_", Integer.MAX_VALUE, 1, Integer.MAX_VALUE, NotationType.eModern, Decoration.none, 0), // used the same way Integer.MAX_VALUE
	QUADRUPLE_WHOLE ("-1", 16,1,-1, NotationType.eModern, Decoration.none, 0),
	DOUBLE_WHOLE ("0", 8,1,0, NotationType.eModern, Decoration.none, 0),
	WHOLE ("1", 4,1,1, NotationType.eModern, Decoration.none, 0),
	HALF ("2", 2,1,2, NotationType.eModern, Decoration.stem, 0),
	QUARTER ("4", 1,1,4,NotationType.eModern, Decoration.stem, 0),
	EIGHTH ("8", 1,2,8, NotationType.eModern, Decoration.stem, 1),
	SIXTEENTH ("16", 1, 4, 16, NotationType.eModern, Decoration.stem, 2),
	THIRTY_SECOND ("32", 1, 8, 32, NotationType.eModern, Decoration.stem, 3),
	SIXTY_FOURTH ("64", 1, 16, 64,NotationType.eModern, Decoration.stem, 4),
	HUNDRED_TWENTY_EIGHTH ("128", 1, 32, 128, NotationType.eModern, Decoration.stem, 5),
	TWO_HUNDRED_FIFTY_SIX ("256", 1, 64, 256, NotationType.eModern, Decoration.stem, 6),
    MAXIMA ("X", 32, 1, -2, NotationType.eMensural, Decoration.stem, 0),
    LONGA ("L", 16, 1, -1, NotationType.eMensural, Decoration.stem, 0),
    BREVE ("S", 8, 1, 0, NotationType.eMensural, Decoration.none, 0),
    SEMIBREVE ("s", 4, 1, 1, NotationType.eMensural, Decoration.none, 0),
    MINIM("M", 2, 1, 2, NotationType.eMensural, Decoration.stemAndFlag, 0),
    SEMIMINIM("m", 1, 1, 4, NotationType.eMensural, Decoration.stemAndFlag, 0),
    FUSA ("U", 1, 2, 8, NotationType.eMensural, Decoration.stemAndFlag, 1),
    SEMIFUSA ("u", 1, 4, 16, NotationType.eMensural, Decoration.stemAndFlag, 2);

    static Figures [] SORTED_DESC_MENSURAL = new Figures[] {
            MAXIMA, LONGA, BREVE, SEMIBREVE, MINIM, SEMIMINIM, FUSA, SEMIFUSA
    };

    static Figures [] SORTED_DESC_MODERN = new Figures[] {
            QUADRUPLE_WHOLE, DOUBLE_WHOLE, WHOLE, HALF, QUARTER, EIGHTH, SIXTEENTH, THIRTY_SECOND, SIXTY_FOURTH, HUNDRED_TWENTY_EIGHTH, TWO_HUNDRED_FIFTY_SIX
    };

	private static final Map<String, Figures> skmMap = Collections.unmodifiableMap(initializeSkmMapping());

	private static Map<String, Figures> initializeSkmMapping() {
		Map<String, Figures> mMap = new HashMap<>();
		for (Figures s : Figures.values()) {
			mMap.put(s.skmEncoding, s);
		}
		return mMap;
	}
	final Time duration;
	/**
	 * Classical interpretation (the one used in denominators of meters)
	 */
    final int meterUnit;
    final NotationType notationType;

    final Decoration decoration;
    final int numFlags;
    private final Time ratio;

    String skmEncoding;

    Figures(String skmEncoding, int quarters, int quarterSubdivisions, int meterUnit, NotationType notationType, Decoration decoration, int flags) {
		duration = new Time(Fraction.getFraction(quarters, quarterSubdivisions));
		this.skmEncoding = skmEncoding;
		this.meterUnit = meterUnit;
		this.notationType = notationType;
		this.decoration = decoration;
		this.numFlags = flags;
		this.ratio = new Time(Fraction.getFraction(quarters, quarterSubdivisions));
	}

	public String getSkmEncoding() {
		return skmEncoding;
	}

	public Time getDuration() {
		return duration;
	}

	public int getMeterUnit() {
		return meterUnit;
	}

	public final NotationType getNotationType() {
		return notationType;
	}

	public boolean usesFlag() {
		return (decoration == Decoration.stemAndFlag || decoration == Decoration.stem) && numFlags > 0;
	}
	public boolean usesStem() {
		return decoration == Decoration.stem || decoration == Decoration.stemAndFlag;
	}

	public boolean usesCombinedStemAndFlag() {
		return decoration == Decoration.stemAndFlag;
	}


	public Time getRatio() {
	    return ratio;
    }


	public static Figures findFigure(String skmEncoding) throws IM4Exception {
    	Figures figure = skmMap.get(skmEncoding);
    	if (figure == null) {
			throw new IM4Exception("Cannot find a figure with encoding " + skmEncoding);
		}
    	return figure;
	}
	/**
	 * Compute the duration of the figure using dots
	 * @param dots
	 * @return
	 */
	public Time getDurationWithDots(int dots) {
		Fraction sumDurations = duration.getExactTime();
		Fraction lastDur = sumDurations;
		
		for (int i=0; i<dots; i++) {
			lastDur = lastDur.multiplyBy(Fraction.ONE_HALF);
			sumDurations = sumDurations.add(lastDur);
		}
		
		return new Time(sumDurations);
	}

	public static Figures findDuration(Time duration, NotationType notationType) throws IM4Exception {
		if (notationType == null) {
			throw new IM4Exception("Cannot search a duration if notationType is null");
		}
		for (Figures fig: Figures.values()) {
			if (fig.notationType == notationType && fig.duration.equals(duration)) {
				return fig;
			}
		}
		throw new IM4Exception("Cannot find a figure with duration " + duration + " and notation type " + notationType);
	}

	public static Figures findMeterUnit(int meterUnit, NotationType notationType) throws IM4Exception {
		for (Figures fig: Figures.values()) {
			if (fig.notationType == notationType && meterUnit == fig.meterUnit) {
				return fig;
			}
		}
		throw new IM4Exception("Cannot find a figure with meter unit " + meterUnit + " and notation type " + notationType);
	}

    public static Figures findFigureWithFlags(int flags, NotationType notationType) throws IM4Exception {
        for (Figures fig: Figures.values()) {
            if (fig.notationType == notationType && flags == fig.numFlags) {
                return fig;
            }
        }
        throw new IM4Exception("Cannot find a figure with flags " + flags + " and notation type " + notationType);
    }
	public int getNumFlags() {
		return numFlags;
	}

    public static Figures[] getFiguresSortedDesc(NotationType notationType) {
        if (notationType == NotationType.eMensural) {
            return SORTED_DESC_MENSURAL;
        } else if (notationType == NotationType.eModern) {
            return SORTED_DESC_MODERN;
        } else {
            throw new IM4RuntimeException("Unknown notation type " + notationType);
        }
    }
}
