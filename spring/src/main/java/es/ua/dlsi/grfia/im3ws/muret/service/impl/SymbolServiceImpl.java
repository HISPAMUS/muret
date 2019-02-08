package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.SymbolService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author drizo
 */
@Service
public class SymbolServiceImpl extends CRUDServiceImpl<Symbol, Long, SymbolRepository> implements SymbolService {
    @Autowired
    SymbolRepository symbolRepository;

    @Override
    protected SymbolRepository initRepository() {
        return symbolRepository;
    }
}

