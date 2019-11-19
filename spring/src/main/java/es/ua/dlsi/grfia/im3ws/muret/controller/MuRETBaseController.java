package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MuRETBaseController {
    protected final MURETConfiguration muretConfiguration;
    protected final ImageRepository imageRepository;
    protected final PageRepository pageRepository;
    protected final RegionRepository regionRepository;
    protected final SymbolRepository symbolRepository;

    public MuRETBaseController(
            MURETConfiguration muretConfiguration,
            ImageRepository imageRepository,
            PageRepository pageRepository,
            RegionRepository regionRepository,
            SymbolRepository symbolRepository
    ) {
        this.muretConfiguration = muretConfiguration;
        this.imageRepository = imageRepository;
        this.pageRepository = pageRepository;
        this.symbolRepository = symbolRepository;
        this.regionRepository = regionRepository;
    }

    protected Image getImage(long imageID) throws IM3WSException {
        //Logger.getLogger(this.getClass().getName()).log(Level.INFO, "ID: "+ imageID);
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + imageID);
        }
        return image.get();
    }

    protected Page getPage(long pageID) throws IM3WSException {
        Optional<Page> page = pageRepository.findById(pageID);
        if (!page.isPresent()) {
            throw new IM3WSException("Cannot find a page with id " + pageID);
        }
        return page.get();
    }

    protected Region getRegion(long regionID) throws IM3WSException {
        Optional<Region> region = regionRepository.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + regionID);
        }
        return region.get();
    }    
    protected Symbol getSymbol(long symbolID) throws IM3WSException {
        Optional<Symbol> symbol = symbolRepository.findById(symbolID);
        if (!symbol.isPresent()) {
            throw new IM3WSException("Cannot find a symbol with id " + symbolID);
        }
        return symbol.get();
    }

}
