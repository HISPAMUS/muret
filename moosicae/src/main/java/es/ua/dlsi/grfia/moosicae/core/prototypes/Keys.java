package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKeySignature;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.core.properties.*;

import java.util.Objects;
import java.util.Optional;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class Keys extends Prototypes<IKey> {
    public static String CM = "CM";
    public static String Am = "Am";
    public static String FM = "FM";
    public static String Dm = "Dm";
    public static String BbM = "BbM";
    public static String Gm = "Gm";
    public static String EbM = "EbM";
    public static String Cm = "Cm";
    public static String AbM = "AbM";
    public static String Fm = "Fm";
    public static String DbM = "DbM";
    public static String Bbm = "Bbm";
    public static String GbM = "GbM";
    public static String Ebm = "Ebm";
    public static String CbM = "CbM";
    public static String Abm = "Abm";
    public static String GM = "GM";
    public static String Em = "Em";
    public static String DM = "DM";
    public static String Bm = "Bm";
    public static String AM = "AM";
    public static String Fsm = "Fsm";
    public static String EM = "EM";
    public static String Csm = "Csm";
    public static String BM = "BM";
    public static String Gsm = "Gsm";
    public static String FsM = "FsM";
    public static String Dsm = "Dsm";
    public static String CsM = "CsM";
    public static String Asm = "Asm";


    private IKey generateKey(int fifths, EDiatonicPitches ediatonicPitch, EAccidentalSymbols eaccidentalSymbol, EModes emode) throws IMException {
        IAccidentalSymbol keyAccidentalSymbol = null;
        IKeyAccidentalCount keyAccidentalCount;
        if (fifths < 0) {
            keyAccidentalSymbol = coreAbstractFactory.createAccidentalSymbol(null, EAccidentalSymbols.FLAT);
            keyAccidentalCount = coreAbstractFactory.createKeyAccidentalCount(null, -fifths);
        } else if (fifths > 0) {
            keyAccidentalSymbol = coreAbstractFactory.createAccidentalSymbol(null, EAccidentalSymbols.SHARP);
            keyAccidentalCount = coreAbstractFactory.createKeyAccidentalCount(null, fifths);
        } else {
            keyAccidentalCount = coreAbstractFactory.createKeyAccidentalCount(null, 0);
        }
        IMode mode = coreAbstractFactory.createMode(null, emode);

        ICommonAlterationKeySignature commonAlterationKey = coreAbstractFactory.createCommonAlterationKey(null, keyAccidentalCount, keyAccidentalSymbol, mode);

        // check they are valid
        IDiatonicPitch expectedDiatonicPitch = coreAbstractFactory.createDiatonicPitch(null, ediatonicPitch);
        if (!commonAlterationKey.getPitchClass().getDiatonicPitch().equals(expectedDiatonicPitch)) {
            throw new IMException("Corrupt common alteration key - invalid diatonic pitch - review code");
        }

        EAccidentalSymbols keyAccidental = null;
        Optional<IAccidentalSymbol> optKeyAccidental = commonAlterationKey.getPitchClass().getAccidental();
        if (optKeyAccidental.isPresent()) {
            keyAccidental = optKeyAccidental.get().getValue();
        }
        if (!Objects.equals(eaccidentalSymbol, keyAccidental)) {
            throw new IMException("Corrupt common alteration key - invalid alteration - review code (expected " + eaccidentalSymbol + " and found " + keyAccidental + ") for " + commonAlterationKey);
        }
        return commonAlterationKey;
    }

    private IKey generateKey(int fifths, EDiatonicPitches ediatonicPitch, EModes emode) throws IMException {
        return generateKey(fifths, ediatonicPitch, null, emode);
    }

    public Keys(ICoreAbstractFactory coreAbstractFactory) throws IMException {
        super(coreAbstractFactory);

        this.add(CM, generateKey(0, EDiatonicPitches.C, EModes.major));
        this.add(Am, generateKey(0, EDiatonicPitches.A, EModes.minor));
        this.add(FM, generateKey(-1, EDiatonicPitches.F, EModes.major));
        this.add(Dm, generateKey(-1, EDiatonicPitches.D, EModes.minor));
        this.add(BbM, generateKey(-2, EDiatonicPitches.B, EAccidentalSymbols.FLAT, EModes.major));
        this.add(Gm, generateKey(-2, EDiatonicPitches.G, EModes.minor));
        this.add(EbM, generateKey(-3, EDiatonicPitches.E,EAccidentalSymbols.FLAT, EModes.major));
        this.add(Cm, generateKey(-3, EDiatonicPitches.C, EModes.minor));
        this.add(AbM, generateKey(-4, EDiatonicPitches.A, EAccidentalSymbols.FLAT, EModes.major));
        this.add(Fm, generateKey(-4, EDiatonicPitches.F, EModes.minor));
        this.add(DbM, generateKey(-5, EDiatonicPitches.D, EAccidentalSymbols.FLAT, EModes.major));
        this.add(Bbm, generateKey(-5, EDiatonicPitches.B, EAccidentalSymbols.FLAT, EModes.minor));
        this.add(GbM, generateKey(-6, EDiatonicPitches.G, EAccidentalSymbols.FLAT, EModes.major));
        this.add(Ebm, generateKey(-6, EDiatonicPitches.E, EAccidentalSymbols.FLAT, EModes.minor));
        this.add(CbM, generateKey(-7, EDiatonicPitches.C, EAccidentalSymbols.FLAT, EModes.major));
        this.add(Abm, generateKey(-7, EDiatonicPitches.A, EAccidentalSymbols.FLAT, EModes.minor));
        this.add(GM, generateKey(1, EDiatonicPitches.G, EModes.major));
        this.add(Em, generateKey(1, EDiatonicPitches.E, EModes.minor));
        this.add(DM, generateKey(2, EDiatonicPitches.D, EModes.major));
        this.add(Bm, generateKey(2, EDiatonicPitches.B, EModes.minor));
        this.add(AM, generateKey(3, EDiatonicPitches.A, EModes.major));
        this.add(Fsm, generateKey(3, EDiatonicPitches.F, EAccidentalSymbols.SHARP, EModes.minor));
        this.add(EM, generateKey(4, EDiatonicPitches.E, EModes.major));
        this.add(Csm, generateKey(4, EDiatonicPitches.C, EAccidentalSymbols.SHARP, EModes.minor));
        this.add(BM, generateKey(5, EDiatonicPitches.B, EModes.major));
        this.add(Gsm, generateKey(5, EDiatonicPitches.G, EAccidentalSymbols.SHARP, EModes.minor));
        this.add(FsM, generateKey(6, EDiatonicPitches.F, EAccidentalSymbols.SHARP, EModes.major));
        this.add(Dsm, generateKey(6, EDiatonicPitches.D, EAccidentalSymbols.SHARP, EModes.minor));
        this.add(CsM, generateKey(7, EDiatonicPitches.C, EAccidentalSymbols.SHARP, EModes.major));
        this.add(Asm, generateKey(7, EDiatonicPitches.A, EAccidentalSymbols.SHARP, EModes.minor));

    }

}
