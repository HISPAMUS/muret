package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.SVGSet;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticOrSemanticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticOrSemanticSymbolFontSingleton;
import es.ua.dlsi.im3.core.score.NotationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
//!Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("fonts")
@RestController
public class FontsController {

    @Autowired
    public FontsController() {
    }

    // see JSONTagging.generateDictionary
    /**
     *
     * @param notationType Mensural, modern
     * @param manuscriptType Handwritten, printed
     * @return Map<symbolType, svg>
     * @throws IM3WSException On SVG constructrion
     */
    @GetMapping(path = {"svgset"})
    // Does not need to be transactional @Transactional(readOnly = true)
    public SVGSet getAgnosticSymbolSVGSet(@RequestParam(name="notationType") NotationType notationType, @RequestParam(name="manuscriptType") ManuscriptType manuscriptType) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting AgnosticSymbolSVGSet");
        try {
            Objects.requireNonNull(notationType, "notationType cannot be null");
            Objects.requireNonNull(manuscriptType, "manuscriptType cannot be null");
            AgnosticOrSemanticSymbolFont agnosticOrSemanticSymbolFont = AgnosticOrSemanticSymbolFontSingleton.getInstance().getLayoutFont(notationType, manuscriptType);
            SVGSet result = new SVGSet(agnosticOrSemanticSymbolFont.getLayoutFont().getSVGFont().getAscent(),
                    agnosticOrSemanticSymbolFont.getLayoutFont().getSVGFont().getDescent(),
                    agnosticOrSemanticSymbolFont.getLayoutFont().getSVGFont().getUnitsPerEM(),
                    agnosticOrSemanticSymbolFont.getFullSVGSetPathd());
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot export", e);
        }
    }
}
