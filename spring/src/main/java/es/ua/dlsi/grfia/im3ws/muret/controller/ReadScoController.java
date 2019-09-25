package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AgnosticEncodingJSON;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AgnosticSymbolTypeAndPosition;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.TranslationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO De momento estoy poniendo esto aquí, que coge muchas cosas de MuRET de manera desordenada. Lo debemos cambiar
/**
 * @author drizo
 */
@RequestMapping("readsco")
@RestController
public class ReadScoController  {
    private final NotationModel notationModel;

    @Autowired
    public ReadScoController() {
        this.notationModel = new NotationModel();
    }


    /**
     *
     * @param agnosticEncodingJSON
     * @return MEI encoding inside a string
     * @throws IM3WSException
     * @throws IM3Exception
     * @throws FileNotFoundException
     */
    @PostMapping(path = "agnostic2semantic", consumes = "application/json", produces = "application/json")
    public StringResponse agnostic2MEI(@RequestBody AgnosticEncodingJSON agnosticEncodingJSON) throws IM3WSException, IM3Exception, FileNotFoundException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Converting semantic staff from agnostic {0}", agnosticEncodingJSON);

        NotationType notationType = agnosticEncodingJSON.getNotationType();
        List<AgnosticSymbolTypeAndPosition> symbols = agnosticEncodingJSON.getAgnosticSymbols();

        AgnosticEncoding agnosticEncoding = new AgnosticEncoding();
        for (AgnosticSymbolTypeAndPosition item: symbols) {
            System.out.println("Symbol");
            System.out.println(item);
            AgnosticSymbolType agnosticSymbolType = AgnosticSymbolTypeFactory.parseString(item.getShape());
            PositionInStaff positionInStaff = PositionInStaff.parseString(item.getPosition());
            AgnosticSymbol agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2, agnosticSymbolType, positionInStaff);
            agnosticEncoding.add(agnosticSymbol);
        }

        TranslationModel translationModel = new TranslationModel();
        SemanticTransduction semanticTransduction = translationModel.computeSemanticFromAgnostic(agnosticEncoding, notationType);

        NotationModel notationModel = new NotationModel();
        String mei = notationModel.getMEINotation(semanticTransduction.getSemanticEncoding(), notationType);

        return new StringResponse(mei);
    }
}
