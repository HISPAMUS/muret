package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * It contains several parsers used in builders
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIAttributesParsers {
    private static MEIAttributesParsers instance;

    private MEIAttributesParsers() {
    }

    public static MEIAttributesParsers getInstance() {
        if (instance == null) {
            instance = new MEIAttributesParsers();
        }
        return instance;
    }

    public Optional<EFigures> parseFigure(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> dur = xmlImporterParam.getAttribute("dur");
        if (dur.isPresent()) {
            EFigures eFigure;
            switch (dur.get()) {
                case "maxima":
                    eFigure = EFigures.MAXIMA;
                    break;
                case "longa":
                    eFigure = EFigures.LONGA;
                    break;
                case "brevis":
                    eFigure = EFigures.BREVE;
                    break;
                case "semibrevis":
                    eFigure = EFigures.SEMIBREVE;
                    break;
                case "minima":
                    eFigure = EFigures.MINIM;
                    break;
                case "semiminima":
                    eFigure = EFigures.SEMIMINIM;
                    break;
                case "fusa":
                    eFigure = EFigures.FUSA;
                    break;
                case "semifusa":
                    eFigure = EFigures.SEMIFUSA;
                    break;
                case "long":
                    eFigure = EFigures.QUADRUPLE_WHOLE;
                    break;
                case "breve":
                    eFigure = EFigures.DOUBLE_WHOLE;
                    break;
                default:
                    eFigure = EFigures.findMeterUnit(Integer.parseInt(dur.get()), ENotationTypes.eModern);
            }
            return Optional.of(eFigure);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Integer> parseDots(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> dots = xmlImporterParam.getAttribute("dots");
        if (dots.isPresent()) {
            return Optional.of(Integer.parseInt(dots.get()));
        } else {
            return Optional.empty();
        }
    }

    Optional<Integer> parseOctave(XMLImporterParam xmlImporterParam) {
        Optional<String> value = xmlImporterParam.getAttribute("oct");
        if (value.isPresent()) {
            return Optional.of(Integer.parseInt(value.get()));
        } else {
            return Optional.empty();
        }
    }

    Optional<EAccidentalSymbols> parseAccidentalSymbol(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> value = xmlImporterParam.getAttribute("accid.ges");
        if (value.isPresent()) {
            EAccidentalSymbols eAccidentalSymbol;
            switch (value.get()) {
                case "fff":
                    eAccidentalSymbol = EAccidentalSymbols.TRIPLE_FLAT;
                    break;
                case "ff":
                    eAccidentalSymbol = EAccidentalSymbols.DOUBLE_FLAT;
                    break;
                case "f":
                    eAccidentalSymbol = EAccidentalSymbols.FLAT;
                    break;
                case "n":
                    eAccidentalSymbol = EAccidentalSymbols.NATURAL;
                    break;
                case "s":
                    eAccidentalSymbol = EAccidentalSymbols.SHARP;
                    break;
                case "ss":
                    eAccidentalSymbol = EAccidentalSymbols.DOUBLE_SHARP;
                    break;
                default:
                    throw new IMException("Unkown accidental symbol '" + value.get() + "'");
            }
            return Optional.of(eAccidentalSymbol);
        } else {
            return Optional.empty();
        }
        //TODO hidden, editorial...
    }

    Optional<EDiatonicPitches> parseDiatonicPitch(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> value = xmlImporterParam.getAttribute("pname");
        if (value.isPresent()) {
            EDiatonicPitches diatonicPitch = EDiatonicPitches.noteFromName(value.get().toUpperCase());
            return Optional.of(diatonicPitch);
        } else {
            return Optional.empty();
        }
        //TODO hidden, editorial...
    }

}
