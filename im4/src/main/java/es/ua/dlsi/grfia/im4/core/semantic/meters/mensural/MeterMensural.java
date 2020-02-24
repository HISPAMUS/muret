package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Figures;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;
import es.ua.dlsi.grfia.im4.core.semantic.meters.Meter;
import org.apache.commons.lang3.math.Fraction;

import java.util.Objects;

public abstract class MeterMensural extends Meter {

	/**
	 * Or maximarum
	 */
	private Perfection modusMaior;
	/**
	 * Or longarum
	 */
	private Perfection modusMinor;
	private Perfection prolatio;
	private Perfection tempus;
    Time breveDuration;
	Time maximaDuration;
    Time longaDuration;
    Time semibreveDuration;

	/**
	 * 
	 * @param modusMaior When null it is taken as imperfect
	 * @param modusMinor When null it is taken as imperfect
	 * @param tempus
	 * @param prolatio
	 */
	public MeterMensural(String skmEncoding, Perfection modusMaior, Perfection modusMinor, Perfection tempus, Perfection prolatio) {
        super(skmEncoding);
        this.prolatio = prolatio;
        this.tempus = tempus;
        this.modusMinor = modusMinor;
        this.modusMaior = modusMaior;

        initDurations();
    }

    private void initDurations() {
        semibreveDuration = Figures.MINIM.getDuration().multiplyBy(Fraction.getFraction(
                prolatio == null ? 2 : prolatio.getDivisions(),
                1)
        );

        breveDuration = semibreveDuration.multiplyBy(Fraction.getFraction(
                tempus == null? 2: tempus.getDivisions(),
                1)
        );


        longaDuration = breveDuration.multiplyBy(Fraction.getFraction(
                modusMinor == null? 2: modusMinor.getDivisions(),
                1)
        );

        maximaDuration = longaDuration.multiplyBy(Fraction.getFraction(
                modusMaior == null? 2: modusMaior.getDivisions(),
                1)
        );
    }

    public final Perfection getProlatio() {
		return prolatio;
	}

	public final Perfection getTempus() {
		return tempus;
	}

	public final Perfection getModusMaior() {
		return modusMaior;
	}

	public final Perfection getModusMinor() {
		return modusMinor;
	}

	/*public final Time getMaximaDuration() {
		return maximaDuration;
	}

	public final Time getLongaDuration() {
		return longaDuration;
	}*/

	public final Time getBreveDuration() {
		return breveDuration;
	}

	public final Time getSemibreveDuration() {
		return semibreveDuration;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeterMensural that = (MeterMensural) o;
        return modusMaior == that.modusMaior &&
                modusMinor == that.modusMinor &&
                prolatio == that.prolatio &&
                tempus == that.tempus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(modusMaior, modusMinor, prolatio, tempus);
    }

    @Override
    public String toString() {
        return "TimeSignatureMensural{" +
                "modusMaior=" + modusMaior +
                ", modusMinor=" + modusMinor +
                ", prolatio=" + prolatio +
                ", tempus=" + tempus +
                '}';
    }

    /**
     * It just be used only is used by ScoreSong
     * @param figure
     * @param dots
     * @return
     */
    public Time getDuration(Figures figure, int dots) {
	    Time duration = getDuration(figure);
	    Time lastDuration = duration;
	    for (int i=0; i<dots; i++) {
	        lastDuration = lastDuration.divide(2);
	        duration = duration.add(lastDuration);
        }
        return duration;
    }

    /**
     * Default values. In ternary rhythms, it returns the perfecta (3 elements). Package visibility, it is used by ScoreSong
     * @param figure
     * @return
     */
	private Time getDuration(Figures figure) {
        Time duration;
		switch (figure) {
			case MAXIMA:
				duration = maximaDuration;
				break;
			case LONGA:
				duration = longaDuration;
				break;
			case BREVE:
				duration = breveDuration;
				break;
			case SEMIBREVE:
				duration = semibreveDuration;
				break;
			default:
				duration = figure.getDuration();
				break;
		}
		return duration;
	}

	public void setModusMaior(Perfection modusMaior) {
        this.modusMaior = modusMaior;
        initDurations();
    }

    public void setModusMinor(Perfection modusMinor) {
        this.modusMinor = modusMinor;
        initDurations();
    }

	@Override
	public boolean isCompound() {
		return false;
	}
}
