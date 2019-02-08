package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.State;
import es.ua.dlsi.grfia.im3ws.muret.repository.StateRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.StateService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author drizo
 */
@Service
public class StateServiceImpl extends CRUDServiceImpl<State, Long, StateRepository> implements StateService {
    @Autowired
    StateRepository stateRepository;

    @Override
    protected StateRepository initRepository() {
        return stateRepository;
    }
}

