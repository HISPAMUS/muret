package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.SVGSet;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFontSingleton;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.layout.LayoutConstants;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping("/muretapi/agnostic")
@CrossOrigin("${angular.url}")
@RestController
public class AgnosticSymbolSVGController {

    /*@GetMapping(path = {"svgscales"})
    public Scales getAgnosticSVGFontScale(@RequestParam(name="notationType") NotationType notationType, @RequestParam(name="manuscriptType") ManuscriptType manuscriptType) throws IM3WSException {
        Objects.requireNonNull(notationType, "notationType cannot be null");
        Objects.requireNonNull(manuscriptType, "manuscriptType cannot be null");
        AgnosticSymbolFont agnosticSymbolFont = AgnosticSymbolFontSingleton.getInstance().getLayoutFont(notationType, manuscriptType);
            return new Scales(agnosticSymbolFont.getLayoutFont().getScaleX(), agnosticSymbolFont.getLayoutFont().getScaleY(),
                    LayoutConstants.EM);
    }*/

    /*@GetMapping(path = {"svg"})
    public StringResponse getAgnosticSymbolSVG(@RequestParam(name="notationType") NotationType notationType, @RequestParam(name="manuscriptType") ManuscriptType manuscriptType, @RequestParam(name="symbolType") String symbolType) throws IM3WSException {
            Objects.requireNonNull(notationType, "notationType cannot be null");
            Objects.requireNonNull(manuscriptType, "manuscriptType cannot be null");
            Objects.requireNonNull(symbolType, "symbolType cannot be null");
            AgnosticSymbolFont agnosticSymbolFont = AgnosticSymbolFontSingleton.getInstance().getLayoutFont(notationType, manuscriptType);
            Objects.requireNonNull(symbolType, "layoutFont for notationType " + notationType + " and manuscriptType " + manuscriptType + " has not been found");
        try {
            return new StringResponse(agnosticSymbolFont.getSVGPathd(symbolType));
        } catch (IM3Exception e) {
            throw new IM3WSException("Cannot find a svg path for agnostic symbol '" + symbolType + "', notationType '" + notationType + "' and manuscriptType " + manuscriptType + "'");
        }
    }*/

    /**
     *
     * @param notationType
     * @param manuscriptType
     * @return Map<symbolType, svg>
     * @throws IM3WSException
     */
    @GetMapping(path = {"svgset"})
    public SVGSet getAgnosticSymbolSVGSet(@RequestParam(name="notationType") NotationType notationType, @RequestParam(name="manuscriptType") ManuscriptType manuscriptType) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting AgnosticSymbolSVGSet");
        Objects.requireNonNull(notationType, "notationType cannot be null");
        Objects.requireNonNull(manuscriptType, "manuscriptType cannot be null");
        AgnosticSymbolFont agnosticSymbolFont = AgnosticSymbolFontSingleton.getInstance().getLayoutFont(notationType, manuscriptType);

        return new SVGSet(agnosticSymbolFont.getLayoutFont().getScaleX(),
                agnosticSymbolFont.getLayoutFont().getScaleY(),
                LayoutConstants.EM,
                agnosticSymbolFont.getFullSVGSetPathd());
    }
}

