package es.ua.dlsi.grfia.moosicae.core.impl.mensural;

import es.ua.dlsi.grfia.moosicae.core.adt.IFractionBuilder;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.impl.Meter;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.mensural.IMensuration;

import javax.validation.constraints.NotNull;


import java.util.Optional;

public abstract class Mensuration extends Meter implements IMensuration {
	/**
	 * Or maximarum
	 */
	private EMensuralPerfections modusMaior;
	/**
	 * Or longarum
	 */
	private EMensuralPerfections modusMinor;
	private EMensuralPerfections prolatio;
	private EMensuralPerfections tempus;
    ITime breveDuration;
	ITime maximaDuration;
	ITime longaDuration;
	ITime semibreveDuration;

	ITime barDuration;

	/**
	 *
	 * @param modusMaior When null it is taken as imperfect
	 * @param modusMinor When null it is taken as imperfect
	 * @param tempus
	 * @param prolatio
	 */
	public Mensuration(IId id,  EMensuralPerfections modusMaior,  EMensuralPerfections modusMinor, @NotNull EMensuralPerfections tempus, @NotNull EMensuralPerfections prolatio) {
		super(id);
        this.prolatio = prolatio;
        this.tempus = tempus;
        this.modusMinor = modusMinor;
        this.modusMaior = modusMaior;

        initDurations();
    }

    private void initDurations() {
        semibreveDuration = EFigures.MINIM.getDuration().multiplyBy(IFractionBuilder.getInstance().build(
                prolatio == null ? 2 : prolatio.getDivisions(),
                1)
        );

        breveDuration = semibreveDuration.multiplyBy(IFractionBuilder.getInstance().build(
                tempus == null? 2: tempus.getDivisions(),
                1)
        );


        longaDuration = breveDuration.multiplyBy(IFractionBuilder.getInstance().build(
                modusMinor == null? 2: modusMinor.getDivisions(),
                1)
        );

        maximaDuration = longaDuration.multiplyBy(IFractionBuilder.getInstance().build(
                modusMaior == null? 2: modusMaior.getDivisions(),
                1)
        );
    }

    public final EMensuralPerfections getProlatio() {
		return prolatio;
	}

	public final EMensuralPerfections getTempus() {
		return tempus;
	}

	public final Optional<EMensuralPerfections> getModusMaior() {
		return Optional.of(modusMaior);
	}

	public final Optional<EMensuralPerfections> getModusMinor() {
		return Optional.of(modusMinor);
	}

	/*public final Time getMaximaDuration() {
		return maximaDuration;
	}

	public final Time getLongaDuration() {
		return longaDuration;
	}*/

	public final ITime getBreveDuration() {
		return breveDuration;
	}

	public final ITime getSemibreveDuration() {
		return semibreveDuration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Mensuration)) return false;

		Mensuration that = (Mensuration) o;

		if (modusMaior != that.modusMaior) return false;
		if (modusMinor != that.modusMinor) return false;
		if (prolatio != that.prolatio) return false;
		return tempus == that.tempus;
	}

	@Override
	public int hashCode() {
		int result = modusMaior != null ? modusMaior.hashCode() : 0;
		result = 31 * result + (modusMinor != null ? modusMinor.hashCode() : 0);
		result = 31 * result + (prolatio != null ? prolatio.hashCode() : 0);
		result = 31 * result + (tempus != null ? tempus.hashCode() : 0);
		return result;
	}

	public void setModusMaior(EMensuralPerfections modusMaior) {
        this.modusMaior = modusMaior;
        initDurations();
    }

    public void setModusMinor(EMensuralPerfections modusMinor) {
        this.modusMinor = modusMinor;
        initDurations();
    }

	@Override
	public abstract Mensuration clone();
}
