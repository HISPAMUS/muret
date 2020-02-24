package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import org.apache.commons.lang3.math.Fraction;

import java.util.Objects;

public abstract class DurationalSemanticItem extends SemanticItem {
    final protected Figures figure;
    final protected int dots;
    final protected Fermata fermata;
    final protected Size size;
    final protected Perfection perfection;

    public DurationalSemanticItem(String skmEncoding, Figures figure, int dots, Perfection perfection, Fermata fermata, Size size) {
        super(skmEncoding);
        Objects.requireNonNull(figure, "figure");

        this.figure = figure;
        this.dots = dots;
        this.fermata = fermata;
        this.size = size;
        this.perfection = perfection;
    }

    public Figures getFigure() {
        return figure;
    }

    public int getDots() {
        return dots;
    }

    public Fermata getFermata() {
        return fermata;
    }

    public Size getSize() {
        return size;
    }

    public Perfection getPerfection() {
        return perfection;
    }

    //TODO Test unitario - sobre todo de mensural
    protected String buildSkmEncoding() throws IM4Exception {
        StringBuilder sb = new StringBuilder();

        if (figure.getNotationType() == NotationType.eModern) {
            Fraction divider = Fraction.getFraction(1, figure.getMeterUnit());
            Fraction durationValue = Fraction.ONE.divideBy(divider).reduce();
            if (durationValue.getDenominator() != 1) {
                throw new IM4Exception("Cannot export figure " + figure + " that produces a fraction: " + durationValue);
            }
            sb.append(durationValue.getNumerator());
        } else if (figure.getNotationType() == NotationType.eMensural) {
            char car;
            NotationType notationType;
            switch (figure) {
                case MAXIMA:
                    car = 'X';
                    break;
                case LONGA:
                    car = 'L';
                    break;
                case BREVE:
                    car = 'S';
                    break;
                case SEMIBREVE:
                    car = 's';
                    break;
                case MINIM:
                    car = 'M';
                    break;
                case SEMIMINIM:
                    car = 'm';
                    break;
                case FUSA:
                    car = 'U';
                    break;
                case SEMIFUSA:
                    car = 'u';
                    break;
                default:
                    throw new IM4Exception("Unsupported mensural figure " + figure);
            }
            sb.append(car);
        } else {
            throw new IM4Exception("Unsupported notation type " + figure.getNotationType());
        }
        if (perfection != null) {
            if (perfection != null) {
                switch (perfection) {
                    case perfectum:
                        sb.append('p');
                        break;
                    case imperfectum:
                        sb.append('i');
                        break;
                    default:
                        throw new IM4Exception("Unsupported perfection type: " + perfection);
                }
            } else {
                throw new IM4Exception("Expected a perfection");
            }
        }
        return sb.toString();
    }

}
