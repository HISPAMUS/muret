package es.ua.dlsi.grfia.im3ws.muret.service;


import com.fasterxml.jackson.annotation.JsonView;
import es.ua.dlsi.grfia.im3ws.muret.entity.JSONFilteredDataViews;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.service.ICRUDService;

import java.util.Optional;

/**
 * @author drizo
 */
public interface UserService extends ICRUDService<User, Integer> {
    Optional<User> findByUserNamePassword(String username, String password);
}
