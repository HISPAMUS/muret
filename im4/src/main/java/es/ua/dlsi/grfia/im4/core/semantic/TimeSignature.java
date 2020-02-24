package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.Time;


public abstract class TimeSignature extends SemanticItem {

    public TimeSignature(String skmEncoding) {
        super(skmEncoding);
    }

    public abstract boolean isCompound();

    /**
     * It returns the duration of a measure, i.e., the unit denoted by the figures denoted by the meter (mensural notation
     * does not use measure)
     * @return
     */
    public abstract Time getDuration();

    /**
     * It returns the beat of an onset (e.g. 0,1,2,3 for 4/4 bars)
     *
     * @param onset
     * @return Integer value if it starts in a beat, float value with decimals
     * if the onset is located between two beats. It starts from 0
     */
    public int getIntegerBeat(Time timeSignatureOnset, Time onset)  {
        //return (int) Math.IEEEremainder(onset, getMeasureDuration(resolution));
        //return (int) (onset  % getMeasureDuration(resolution));
        return (int) getBeat(timeSignatureOnset, onset); //TODO Pruebas unitarias
    }

    /**
     * It returns the beat of an onset
     *
     * @param onset
     * @return Integer value if it starts in a beat, float value with decimals
     * if the onset is located between two beats. It starts from 0
     */
    public double getBeat(Time timeSignatureOnset, Time onset) {
        double offset = onset.substract(timeSignatureOnset).mod(getDuration());
        return offset;
    }
}
